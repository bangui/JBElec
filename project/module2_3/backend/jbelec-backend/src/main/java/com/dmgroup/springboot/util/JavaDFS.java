package com.dmgroup.springboot.util;

import java.util.ArrayList;
import java.util.List;

public class JavaDFS {
	  
    // No. of vertices in graph 
    private int v;  
      
    // adjacency list  
    private ArrayList<Integer>[] adjList;  
      
    // route plan resutl
    private List<List<Integer>> results;
    
    //Constructor 
    public JavaDFS(int vertices){ 
          
        //initialise vertex count 
        this.v = vertices; 
          
        // initialise adjacency list 
        initAdjList();  
    } 
      
    // utility method to initialise 
    // adjacency list 
    @SuppressWarnings("unchecked") 
    private void initAdjList() 
    { 
        adjList = new ArrayList[v]; 
          
        for(int i = 0; i < v; i++) 
        { 
            adjList[i] = new ArrayList<>(); 
        } 
    } 
      
    // add edge from u to v 
    public void addEdge(int u, int v) 
    { 
        // Add v to u's list. 
        adjList[u].add(v);  
    } 

    // remove edge from u to v
    public void removeEdge(int u, int v) {
    	if(adjList[u].contains(v)) {
//        	System.out.println("Remove edge of: " + u + " " + v);
//        	System.out.println("v convert as " + adjList[u].indexOf(v));
        	adjList[u].remove(adjList[u].indexOf(v));
    	}
    }
    // Prints all paths from 
    // 's' to 'd' 
    public List<List<Integer>> getAllPaths(int s, int d)  
    { 
        boolean[] isVisited = new boolean[v]; 
        ArrayList<Integer> pathList = new ArrayList<>(); 
        results = new ArrayList<>();
        //add source to path[] 
        pathList.add(s); 
          
        //Call recursive utility 
        getAllPathsUtil(s, d, isVisited, pathList, results);
        return results;
    } 
  
    // A recursive function to print 
    // all paths from 'u' to 'd'. 
    // isVisited[] keeps track of 
    // vertices in current path. 
    // localPathList<> stores actual 
    // vertices in the current path 
    private void getAllPathsUtil(Integer u, Integer d, 
                                    boolean[] isVisited, 
                            List<Integer> localPathList,
                            List<List<Integer>> results) { 
          
        // Mark the current node 
        isVisited[u] = true; 
          
        if (u.equals(d))  
        { 
//            System.out.println(localPathList); 
        	results.add(new ArrayList<>(localPathList));
            // if match found then no need to traverse more till depth 
            isVisited[u]= false; 
            return ; 
        } 
          
        // Recur for all the vertices 
        // adjacent to current vertex 
        for (Integer i : adjList[u])  
        { 
            if (!isVisited[i]) 
            { 
                // store current node  
                // in path[] 
                localPathList.add(i); 
                getAllPathsUtil(i, d, isVisited, localPathList, results); 
                  
                // remove current node 
                // in path[] 
                localPathList.remove(i); 
            } 
        } 
          
        // Mark the current node 
        isVisited[u] = false; 
    }     
}
