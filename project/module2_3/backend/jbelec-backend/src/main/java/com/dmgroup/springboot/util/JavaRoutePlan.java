package com.dmgroup.springboot.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JavaRoutePlan {
	public static List<List<Integer>> run(String txtGraphPath, int fiberSrc, int fiberDst, int routeSrc, int routeDst) {
		// initialize graph with vertex number
		JavaDFS g = new JavaDFS(250); 
		// Load and parse edge txt        		
        try (FileReader reader = new FileReader(txtGraphPath);
             BufferedReader br = new BufferedReader(reader) 
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                if(!line.startsWith("#")) {
                	String[] str = line.split("\t");
                	g.addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }	    
        // add default fiber 
        g.removeEdge(fiberSrc, fiberDst);
        System.out.println("Following are all different paths from "+routeSrc+" to "+routeDst); 
        return g.getAllPaths(routeSrc, routeDst); 
	}
}