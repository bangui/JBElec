package com.dmgroup.springboot.test;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dmgroup.springboot.Application;
import com.dmgroup.springboot.pojo.Business;
import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Route;
import com.dmgroup.springboot.pojo.Station;
import com.dmgroup.springboot.service.BusinessService;
import com.dmgroup.springboot.service.FiberService;
import com.dmgroup.springboot.service.StationService;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class GenerateFiberGraphFromDB {
	@Autowired
	private FiberService fiberService;
	
	@Autowired
	private StationService stationService;
	
	@Test
	public void Test1() throws Exception {
		// get station as vertex
		List<Station> stations = stationService.findAll();				
	    String[] vertex = new String[stations.size()];	    
	    for(int i=0; i<stations.size(); i++) { 
	    	vertex[i] = stations.get(i).getSTATION_NAME();
	    }
		// get fiber connection as edge
	    int [][] edges = new int[vertex.length][vertex.length];
	    // init edges 
	    for(int i=0; i<vertex.length; i++) {
	    	for(int j=0; j<vertex.length; j++)
	    		edges[i][j] = -1;
	    }
	    List<Fiber> fibers = fiberService.findAll();		
		for(Fiber fiber: fibers) {
			List<Integer> stationIds = fiber.getSTATIONS_ID();
			int src = stationIds.get(0), dst = stationIds.get(1), props = fiber.getFIBER_ID();
			edges[src][dst] = props;
			edges[dst][src] = props;
		}
	    // build edge and store as txt
		int edgeCount = countEdge(edges);
		int vertexCount = stations.size();
		writeFile(edges, edgeCount, vertexCount);		
//		System.out.println("Successful!");
	}
	public int countEdge(int[][] edges) {
		int count = 0;
		for(int i=0; i<edges.length; i++) {
			for(int j=0; j<edges[0].length; j++) {
				if(edges[i][j] != -1) {
					count++;
				}
			}
		}
		System.out.println("Edge count: " + count);
		return count;
	}
    public static void writeFile(int[][] edges, int edgeCount, int vertexCount) {
        try {
            File writeName = new File("./graph/elec-fiberProperties.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); 
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
            	out.write("# Nodes: " + vertexCount + " Edges: " + edgeCount + "\r\n" + 
            			"# FromNodeId	ToNodeId\r\n"); 
        		for(int i=0; i<edges.length; i++) {
        			for(int j=0; j<edges[0].length; j++) {
        				if(edges[i][j] != -1) {
        					out.write(i + "\t" + j + "\t" + edges[i][j] + "\r\n");        					
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
