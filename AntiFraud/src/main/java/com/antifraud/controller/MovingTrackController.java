package com.antifraud.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.antifraud.entity.MovingTrack;
import com.antifraud.service.MovingTrackService;
/**
 * 
 *
 * @ClassName: MovingTrackController
 * @description 实地移动轨迹
 * @author lishaozhang
 * @createDate 2018年10月30日-上午10:35:31
 */
@Controller
public class MovingTrackController {
   @Autowired
   private MovingTrackService movingTrackService;
	
   
   @RequestMapping("saveMovingTrack")
   @ResponseBody
   public Object saveMovingTrack(MovingTrack movingTrack) throws UnsupportedEncodingException{
	   String customer_name = movingTrack.getCustomer_name();
	  String customer_name2 = new String(customer_name.getBytes("iso-8859-1"), "utf-8");
	  movingTrack.setCustomer_name(customer_name2);
	  
	   Map map = movingTrackService.insertMovingTrack(movingTrack);
	return JSONObject.toJSON(map);   
   }
   
   @RequestMapping("findMovingTrackByUserId")
   @ResponseBody
   public Object findMovingTrackByUserId(long user_id,int page ,int limit){
	   Map map =new HashMap();
	  
	   List<MovingTrack> movingTrackList = movingTrackService.findByUserId(user_id,page,limit);
	   if(movingTrackList.size()>0){
		   map.put("code", 1);
		   map.put("msg", "查询成功");
		   map.put("count", movingTrackList.size());
		   map.put("data",movingTrackList);
		   return JSONObject.toJSON(map);  
	   }
	   
	   map.put("coode", -1);
	   map.put("msg", "查询失败");
	   map.put("count", null);
	   map.put("data",null);
	   return JSONObject.toJSON(map);  
   }
   
}
