package com.dmgroup.springboot.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dmgroup.springboot.Application;
import com.dmgroup.springboot.pojo.Business;
import com.dmgroup.springboot.pojo.Fiber;
import com.dmgroup.springboot.pojo.Route;
import com.dmgroup.springboot.service.BusinessService;
import com.dmgroup.springboot.service.FiberService;
import com.dmgroup.springboot.service.StationService;
import com.dmgroup.springboot.util.GenerateGraphFromDB;
import com.dmgroup.springboot.util.JavaRoutePlan;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RunRoutePlan {
	@Autowired
	private FiberService fiberService;	
	@Autowired
	private StationService stationService;
	@Autowired
	private BusinessService businessService;
	
	// update graph txt from db
//	@Test 
//	public void UpdateGraphFromDB() throws Exception {
//		String newGraphFilePath = "./graph/newGraph.txt";
//		GenerateGraphFromDB genGraph = new GenerateGraphFromDB(newGraphFilePath, stationService, fiberService);
//		genGraph.run();
//	}
	
	@Test
	public void RoutePlanTest() throws Exception {
//		System.out.println("// get business");
		List<Business> busis = businessService.findAll();
		//UpdateGraphFromDB();
//		System.out.println("// get fibers");
		List<Fiber> fibers = fiberService.findAll();		
//		System.out.println("// test each business");
		// path to save results of route plan
        File writeName = new File("./graph/RoutePlanDefeatRecordinJava.txt");         
        writeName.createNewFile(); 
        FileWriter writer = new FileWriter(writeName);
        BufferedWriter out = new BufferedWriter(writer);
        // txt graph path to load
        //String txtGraphPath = "./graph/elec-fibergraphV2.txt";
        String txtGraphPath = "./graph/newGraph.txt";
		for(Business busi: busis) {
			List<Route> routes = busi.getROUTE();		
//			System.out.println("// test each route");
			if(routes.size() == 0) continue;
			int routeSrc = routes.get(0).getSTATIONS_ID_LIST().get(0);
			int stationLen = routes.get(routes.size()-1).getSTATIONS_ID_LIST().size();
			int routeDst = routes.get(routes.size()-1).getSTATIONS_ID_LIST().get(stationLen-1);
			for(Route route: routes) {
				List<Integer> routeStations = route.getSTATIONS_ID_LIST();
				if(routeStations.size() == 0) continue;				 				 
//				System.out.println("// test each fiber");
				List<Integer> routeFibers = route.getFIBERS_ID_LIST();
				// converge route
				for(int routeFiber: routeFibers) {
//					System.out.println("// get fiber src and dst");
					System.out.println(routeFiber);
					List<Integer> fiberStations = fiberService.findOne(routeFiber).getSTATIONS_ID();
					if(fiberStations.size() == 0) continue;
					int fiberSrc = fiberStations.get(0);
					int fiberDst = fiberStations.get(fiberStations.size()-1);
//					System.out.println("// route plan test");					
//					List<List<Object>> routePlanRes = SparkRoutePlan.run(routeSrc, routeDst, fiberSrc, fiberDst);
					List<List<Integer>> routePlanRes = JavaRoutePlan.run(txtGraphPath, fiberSrc, fiberDst, routeSrc, routeDst);
					if(routePlanRes.size() == 0) {
						List<String> stationNames=fiberService.findOne(routeFiber).getSTATIONS_NAME();
						String defeatRecord = "Route plan of business: " + busi.getLINE_NAME() + 
								" is defeat in route: " + route.getSTATIONS_NAME_LIST() +
								" of fiber: " + routeFiber + 
								" "+stationNames.get(0)+" "+stationNames.get(1)+"\r\n";
						System.out.println(defeatRecord);
						out.write(defeatRecord);
						out.flush();
					}
				}
			}
		}
	}
}
