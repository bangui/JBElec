package com.dmgroup.spark

import org.apache.spark.graphx.{Graph, VertexId, EdgeRDD, Edge}
import org.apache.spark.rdd.RDD

object SparkRoutePlan {
  def run[VD, ED](graph: Graph[VD, Int], fiberSrc: VertexId, fiberDst: VertexId, src: VertexId, dst: VertexId): List[List[Long]] = {
    if (src == dst) return List(List(src))
    var res: List[List[Long]] = Nil
    // Init graph, the attribute of each vertex is (dist from src, visit time, id of vertex with dist-1), edge with default attribute 1
    var directedGraph: Graph[(Int, Int, VertexId), Int] = {
      graph.mapVertices((id, _) => (if(id == src) 0 else Int.MaxValue, 0, 0L)).cache()   
    }
    // convert directed graph to undirected graph
    val undirectedEdgeRDD = directedGraph.reverse.edges.union(directedGraph.edges)
    val undirectedgraph = Graph(directedGraph.vertices, undirectedEdgeRDD)
    var g = undirectedgraph
    // defeat fiber/edge used in generated path
    g = g.mapEdges(e => (          
        if((e.dstId == fiberDst && e.srcId == fiberSrc) || (e.srcId == fiberDst && e.dstId == fiberSrc)) Int.MaxValue else e.attr)
    ).cache()
    // Traverse forward from src to dst to get shortest distance
    var pathCount = 0
    while(pathCount < 3){ // default 3 paths      
      var dstAttr = (Int.MaxValue, 0, 0L)
      while (dstAttr._1 == Int.MaxValue) {
        val msgs = g.aggregateMessages[(Int, Int, VertexId)](
          e => if (e.srcAttr._1 != Int.MaxValue && e.srcAttr._1 + e.attr < e.dstAttr._1 && e.srcAttr._2 <= 2) {
            e.sendToDst((e.srcAttr._1 + e.attr, e.srcAttr._2 + 1, e.srcId))
          },
          (a, b) => if (a._1 < b._1) a else b).cache()    
        if (msgs.count == 0) return res    
        g = g.ops.joinVertices(msgs) {
          (id, oldAttr, newAttr) =>
            if (newAttr._1 < oldAttr._1) newAttr else oldAttr
        }.cache()
        dstAttr = g.vertices.filter(_._1 == dst).first()._2
      }  
      // Traverse backward from dst to src to get route path
      var path: List[VertexId] = dstAttr._3 :: dst :: Nil 
      var nextVertex: VertexId = src;    
      var maxStationCount = 10;
      while (path.head != src && maxStationCount > 0) {
        nextVertex = g.vertices.filter(_._1 == path.head).first()._2._3    
        path =  nextVertex:: path
        maxStationCount -= 1;
      }
      // reset graph
      g = g.mapVertices((id, _) => (if(id == src) 0 else Int.MaxValue, 0, 0L)).cache()      
      g = g.mapEdges(e => (          
          if(path.contains(e.dstId) && path.contains(e.srcId)) Int.MaxValue else e.attr)
      ).cache()      
      if(maxStationCount != 0) res = path :: res      
      pathCount = pathCount + 1
    }    
    return res 
  }   
}