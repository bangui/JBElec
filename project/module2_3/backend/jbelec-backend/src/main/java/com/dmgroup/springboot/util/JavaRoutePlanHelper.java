package com.dmgroup.springboot.util;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue; 
  
public class JavaRoutePlanHelper { 
  
    // Number of vertices in fiber-graph 
    private int v;   
    // adjacency matrix
    private int[][] adjMatrix;       
    // results of route plan
    private List<List<Integer>> results;
    
    //Constructor 
    public JavaRoutePlanHelper(int vertices){           
        //init vertex count 
        this.v = vertices; 
        initAdjMatrix();
        
    } 
      
    // utility method to initialize
     private void initAdjMatrix() {
    	 adjMatrix = new int[v][v];
     }
     
    // add edge between u and v of undirected graph
    public void addEdge(int u, int v) 
    { 
    	adjMatrix[u][v] = 1;
    	adjMatrix[v][u] = 1;
    } 

    // remove edge between u and v of undirected graph
    public void removeEdge(int u, int v) {
    	adjMatrix[u][v] = 0;
    	adjMatrix[v][u] = 0;
    }
    
    // get shortest path between 's' and 'd', default 3 pathes
    public List<List<Integer>> getShortestPath(int s, int d){//                
        results = new ArrayList<>();
        int pathCount = 3; // default 3 paths
        while(pathCount > 0) {
	        List<Integer> path = dijstra(s, d);
	        if(path.size() == 0) break; // if cannot generate default 3 paths, break
	        for(int i=1; i<path.size(); i++) { // remove used edges in generated path
	        	removeEdge(path.get(i), path.get(i-1));
	        }
	        pathCount--;	        
	        results.add(new ArrayList<>(path));
        }
        return results;    	
    }
    
    public List<Integer> dijstra(Integer u, Integer d) {
    	List<Integer> path = new ArrayList<>();
        int[] dist = new int[v];   // distance between source vertex and other vertexes
        int[] lastVertex = new int[v];
        boolean[] used = new boolean[v];  
        used[u] = true;  // vertex u is visited
        
        for(int i = 0;i < v; i++) {
        	if(i == u) continue;
        	if(adjMatrix[u][i] == 1) {
        		dist[i] = adjMatrix[u][i] ;
        		lastVertex[i] = u;
        	}
        	else {
        		dist[i] = Integer.MAX_VALUE;
        	}
            used[i] = false;
        }
        for(int i = 0; i < adjMatrix.length;i++) {
        	if(i == u) continue;
            int min = Integer.MAX_VALUE;    // temporary distance between u and i
            int k = 0;
            for(int j = 0;j < adjMatrix.length;j++) {  // find the vertex which has minimized distance with u
            	if(j == u) continue;
                if(!used[j] && dist[j] != 0 && min > dist[j]) {
                    min = dist[j];
                    k = j;
                }
            }

            if(k == 0 && min == Integer.MAX_VALUE) break;
            
            used[k] = true;    // visited the vertex which has minimized distance
            for(int j = 0;j < adjMatrix.length;j++) {  // try add k as mid vertex between u and other vertex with shorter distance
            	if(j == u) continue;
                if(!used[j]) {                      
                    if(adjMatrix[k][j] != 0 && (dist[j] > min + adjMatrix[k][j] || dist[j] == Integer.MAX_VALUE)) {
                        dist[j] = min + adjMatrix[k][j];
                    	lastVertex[j] = k;
                    }
                }
            }
        }     
        int head = d;        
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.addFirst(head);
        int maxStationCount = 10;
        while(head != u && maxStationCount > 0) {      
        	head = lastVertex[head];
        	deque.addFirst(head); 
        	maxStationCount--;
        }
        if(maxStationCount == 0) return new ArrayList<>();
        for(int x: deque) {
        	path.add(x);
        }
        return path;	
    }             
}