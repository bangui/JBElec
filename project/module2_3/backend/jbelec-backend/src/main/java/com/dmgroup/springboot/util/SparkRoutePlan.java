package com.dmgroup.springboot.util;

import java.util.ArrayList;
import java.util.List;

import com.dmgroup.spark.SparkApplication;

public class SparkRoutePlan {
	public static List<List<Integer>> run(int fiberSrc, int fiberDst, int routeSrc, int routeDst) {
		System.out.println("Entering SparkApplcation");
		List<List<Object>> res = SparkApplication.runRoutePlan(fiberSrc, fiberDst, routeSrc, routeDst);
		List<List<Integer>> resConvert = new ArrayList<>();
		
		for(List<Object> list: res) {
			List<Integer> listConvert = new ArrayList<>();
			for(Object o: list) {
				listConvert.add(Integer.parseInt(o.toString()));
			}
			resConvert.add(listConvert);
		}
		
		return resConvert;
	}
}
