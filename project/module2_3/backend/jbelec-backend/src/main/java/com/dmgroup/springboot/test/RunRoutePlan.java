package com.dmgroup.springboot.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dmgroup.springboot.Application;
import com.dmgroup.springboot.pojo.Business;
import com.dmgroup.springboot.pojo.Route;
import com.dmgroup.springboot.pojo.RouteChange;
import com.dmgroup.springboot.service.FiberService;
import com.dmgroup.springboot.service.RouteChangeService;
import com.dmgroup.springboot.util.JavaRoutePlan;
import com.dmgroup.springboot.util.SparkRoutePlan;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class) 
public class RunRoutePlan {
	@Autowired
	private FiberService fiberService;		

	@Test // demo for running route plan
	public void RoutePlanTest() throws Exception {
		List<List<String>> res = new ArrayList<>();
		// args: fiberId
		// init method: java or spark version
//		JavaRoutePlan rp = new JavaRoutePlan();
		SparkRoutePlan rp = new SparkRoutePlan();
		int fiberId = 0;
		// if hasn't fiberId find with fiberSrc and fiberDst		
		// Load and parse fiber properties txt     
		int[][] fiberMatrix = new int[240][240];
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
                	int fiber = Integer.parseInt(str[2]);	                	
                	fiberMatrix[station1][station2] = fiber;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }	        
        // get fiberSrc and fiberDst        
		List<Integer> fiberStations = fiberService.findOne(fiberId).getSTATIONS_ID();		
		int fiberSrc = fiberStations.get(0);
		int fiberDst = fiberStations.get(1);
		// get businessId and businessSrc, businessDst 
		List<Business> busis = fiberService.findBusiness(fiberId);
		// run route plan to get res of each business
		for(Business busi: busis) {
			List<String> tempRes = new ArrayList<>();
			tempRes.add(String.valueOf(busi.getBUSINESS_ID()));
			
			List<Route> routes = busi.getROUTE();								
			if(routes.size() == 0) continue;
			int routeSrc = routes.get(0).getSTATIONS_ID_LIST().get(0);
			int routeLen = routes.get(routes.size()-1).getSTATIONS_ID_LIST().size();
			int routeDst = routes.get(routes.size()-1).getSTATIONS_ID_LIST().get(routeLen-1);
			List<List<Integer>> resRoutePlan = rp.run(fiberSrc, fiberDst, routeSrc, routeDst);
			if(resRoutePlan.size() == 0) System.out.println("There is no result of route " + tempRes.get(0));			
			else {		       
				tempRes.add(resRoutePlan.toString());
				// get a list of fibers 
		        List<List<Integer>> fiberList = new ArrayList<>();
		        List<Integer> fiber = new ArrayList<>();
				for(List<Integer> re: resRoutePlan) {				
					for(int i=1; i<re.size(); i++) {
						fiber.add(fiberMatrix[re.get(i)][re.get(i-1)]);
					}
					fiberList.add(new ArrayList<>(fiber));	
					fiber.clear();
					System.out.println(re);
				}
				tempRes.add(fiberList.toString());
				tempRes.add(String.valueOf(fiberId));
			}
		// return res as: # serviceId, routeStationList, routeFiberList, defeatFiberId		
		
		System.out.println("Get route plan result: " + tempRes.toString());
		if(tempRes.size() > 1) res.add(new ArrayList<>(tempRes));
		}
		System.out.println("Get all results: " + res.toString());
	}
}
