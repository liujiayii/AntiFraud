package com.antifraud.controller;

import java.util.Map;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


@Component
public class TestController {
	  @Scheduled(cron="1-59 * * * * ?")
		public void dingshi222() {
	    }
	
    /*public static void main(String[] args) {
    	JSONArray jsonArray = new JSONArray();
		String loadJson = null;
		try {
			loadJson = AcceptUntils.loadJson("http://192.168.1.101:8001/loanTrack");
	//		System.out.println("loadJson" + loadJson);
		} catch (Exception e) {
			System.out.println("获取信息一杵");
		}
		try {
			loadJson = loadJson.substring(loadJson.indexOf("["), loadJson.lastIndexOf("]") + 1);
		} catch (Exception e) {
			System.out.println("暂无数据"); 
		}

		// System.out.println(loadJson);
		JSONArray json = (JSONArray) JSONArray.parse(loadJson);
		

		for (Object o : json) {
			JSONObject jsonObject2 = JSONObject.fromObject(o);
			TManagementAfterLoan TMAL = (TManagementAfterLoan) JSONObject.toBean(jsonObject2,
					TManagementAfterLoan.class);
			     System.out.println(TMAL);
 
		}
	}*/
    
  
    
    
}
