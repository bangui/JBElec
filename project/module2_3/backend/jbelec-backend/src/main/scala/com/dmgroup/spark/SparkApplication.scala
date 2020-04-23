package com.dmgroup.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.graphx.{EdgeDirection, VertexId, Graph}
import org.apache.spark.graphx.util.GraphGenerators
import org.apache.spark.graphx.GraphLoader
import org.apache.log4j.{Level, Logger}
import scala.collection.JavaConverters._


object SparkApplication {
  def runRoutePlan(srcId1: Int, dstId1: Int, srcId2: Int, dstId2: Int): java.util.List[java.util.List[Long]] = {
    // blocking spark log
    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)    
    // spark configuration
    val conf = new SparkConf().setAppName("Route_Plan").setMaster("local")
    val sc = new SparkContext(conf)
    // load graph with fiber connection
    val fiberGraph = GraphLoader.edgeListFile(sc,"./graph/elec-fiberProperties.txt")
    // set defeat fiber
    val faultSrcId = srcId1
    val faultDstId = dstId1           
    // set two endpoints of a business
    val businessSrcId: VertexId = srcId2
    val businessDstId: VertexId = dstId2
    // route planning
    println("Run route plan on fiber: " + faultSrcId + " " + faultDstId +
        " route: " + businessSrcId + " " + businessDstId)
    val scalaRes: List[List[Long]] = SparkRoutePlan.run(fiberGraph, faultSrcId, faultDstId, businessSrcId, businessDstId)
    // convert scala format results into java format
    val javaRes: java.util.List[java.util.List[Long]] = new java.util.ArrayList()
    for(p <- scalaRes){
      javaRes.add(p.asJava)
    }
    // stop spark application context
    sc.stop()
    return javaRes
  }
}