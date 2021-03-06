package com.antifraud.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.antifraud.entity.Spot_image;
import com.antifraud.service.SpotImageService;
/**
 * 
 *
 * @ClassName: SpotImageController

 * @description 实地图片表控制层
 *
 * @author lishaozhang
 * @createDate 2018年10月31日
 */
@Controller
@RequestMapping("SpotImage")
public class SpotImageController {
   
	@Autowired
	private SpotImageService spotImageService;
	
	/**
	 * 
	*
	 * @Title: saveSpotImage
	
	 * @description 保存实地图片的方法
	*
	 * @param @param report_id
	 * @param @param request
	 * @param @return 
	   
	 * @return Map    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年10月31日
	 */
	@RequestMapping("saveSpotImage")
	@ResponseBody
	public synchronized Object saveSpotImage(String report_id ,HttpServletRequest request){
		
		//获取所有传过来的图片
		MultipartHttpServletRequest multipartRequest =  (MultipartHttpServletRequest)request;
		
		List<MultipartFile> files = multipartRequest.getFiles("pic");
		Map map =spotImageService.saveSpotImage(report_id, files);
		return JSONObject.toJSON(map);
		
	}
	
	/**
	 * 
	*
	 * @Title: findSpotImageByPid
	
	 * @description  或者报单编号查询实地图片表的方法
	*
	 * @param @param pid report_id
	 * @param @return 
	   
	 * @return List<Spot_image>    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年10月31日
	 */
	@RequestMapping("findSpotImageByReport_id")
	@ResponseBody
    public Object findSpotImageByPidOrReport_id(String report_id ,int page, int limit){
    	
    	Map map =spotImageService.findSpotImageByPidOrReport_id(report_id,page,limit);
    	
		return JSONObject.toJSON(map);
    	
    }
    /**
     * 
    *
     * @Title: updateSpotImageByid
    
     * @description 
    *
     * @param @param spot_image
     * @param @return 
       
     * @return Map    
    
     *
     * @author lishaozhang
     * @createDate 2018年10月31日
     */
	@RequestMapping("updateSpotImageByid")
	@ResponseBody
    public Object updateSpotImageByid(Spot_image spot_image){
    	
    	Map map =spotImageService.updateSpotImageByid(spot_image);
    	
		return JSONObject.toJSON(map);
    	
    }
    /**
     * 
    *
     * @Title: deleteSpotImageByPid
    
     * @description 通过pid删除某个实地记录的所有照片
    *
     * @param @param pid
     * @param @return 
       
     * @return Map    
    
     *
     * @author lishaozhang
     * @createDate 2018年11月1日
     */
	@RequestMapping("deleteSpotImageByreport_id")
	@ResponseBody
    public Object deleteSpotImageByPid (String report_id){
    	
    	Map map =spotImageService.deleteSpotImageByPid(report_id);
    	
		return JSONObject.toJSON(map);  	
    }
	/**
	 * 
	*
	 * @Title: deleteSpotImageByid
	
	 * @description 
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return Map    通过id删除某张实地照片表
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年11月1日
	 */
	@RequestMapping("deleteSpotImageByid")
	@ResponseBody
    public Object deleteSpotImageByid (Long id){
    	
    	Map map =spotImageService.deleteSpotImageByid(id);
    	
		return JSONObject.toJSON(map);
    	
    }

	
	
}
