package com.dmgroup.springboot.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dmgroup.springboot.pojo.Business;
import com.dmgroup.springboot.service.FiberService;

import java.io.*;

public class JavaRoutePlan {
	
	public List<List<Integer>> run(int fiberSrc, int fiberDst, int routeSrc, int routeDst) {
		
		// initialize graph
		JavaRoutePlanHelper g = new JavaRoutePlanHelper(250); 
		// Load and parse edge txt        
		String pathname = "./graph/elec-fiberProperties.txt";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) 
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                if(!line.startsWith("#")) {                	
                	String[] str = line.split("\t");
                	int station1 = Integer.parseInt(str[0]);
                	int station2 = Integer.parseInt(str[1]); 
                	g.addEdge(station1, station2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }	    
        // add defeat fiber 
        g.removeEdge(fiberSrc, fiberDst);
        
        System.out.println("Following are all different paths from "+routeSrc+" to "+routeDst); 
        return g.getShortestPath(routeSrc, routeDst);
	}
}
