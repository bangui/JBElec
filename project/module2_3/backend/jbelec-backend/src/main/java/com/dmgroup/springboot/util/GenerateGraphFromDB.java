package com.dmgroup.springboot.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Station;
import com.dmgroup.springboot.service.FiberService;
import com.dmgroup.springboot.service.StationService;

public class GenerateGraphFromDB {
	private StationService stationService;
	private FiberService fiberService;
	private String newFilePath;
	
	public GenerateGraphFromDB(String newFilePath, StationService stationService, FiberService fiberService) {
		this.stationService = stationService;
		this.fiberService = fiberService;
		this.newFilePath = newFilePath;
	}	
	public void run() throws Exception {
		// get station as vertex
		List<Station> stations = stationService.findAll();				
	    String[] vertex = new String[stations.size()];	    
	    for(int i=0; i<stations.size(); i++) { 
	    	vertex[i] = stations.get(i).getSTATION_NAME();
	    }
		// get fiber connection as edge
	    double [][] edges = new double[vertex.length][vertex.length];
	    List<Fiber> fibers = fiberService.findAll();		
		for(Fiber fiber: fibers) {
			List<Integer> stationIds = fiber.getSTATIONS_ID();
			edges[stationIds.get(0)][stationIds.get(1)] = 1;
		}
	    // build edge and store as txt
		int edgeCount = countEdge(edges);
		int vertexCount = stations.size();
		writeFile(edges, edgeCount, vertexCount);		
		System.out.println("Generage graph from database and store as txt successful!");
	}
	public int countEdge(double[][] edges) {
		int count = 0;
		for(int i=0; i<edges.length; i++) {
			for(int j=0; j<edges[0].length; j++) {
				if(edges[i][j] == 1) {
					count++;
				}
			}
		}
		System.out.println("Edge count: " + count);
		return count;
	}
    public void writeFile(double[][] edges, int edgeCount, int vertexCount) {
        try {
            File writeName = new File(newFilePath); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); 
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
            	out.write("# Nodes: 241 Edges: 281\r\n" + 
            			"# FromNodeId	ToNodeId\r\n"); 
        		for(int i=0; i<edges.length; i++) {
        			for(int j=0; j<edges[0].length; j++) {
        				if(edges[i][j] == 1) {
        					out.write(i + "\t" + j + "\r\n");
        				}
        			}
        		}                                
                out.flush(); // write cache into disk
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
