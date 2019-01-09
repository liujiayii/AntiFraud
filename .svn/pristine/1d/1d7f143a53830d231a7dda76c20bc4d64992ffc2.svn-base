package com.antifraud.controller;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.antifraud.entity.Photo;
import com.antifraud.service.PhotoService;
import com.antifraud.utils.JsonUtil;

/**
 * 
 *
 * @ClassName: PhotoController
 * @description 根据报单编号上传图片
 * @author qixiyao
 * @createDate 2018年11月26日-下午2:27:37
 */
@Controller
@RequestMapping("photo")
public class PhotoController {
	int code = 1;
	String msg = "成功";
      @Autowired
      private PhotoService photoService;
      
      @RequestMapping("addPhoto")
      @ResponseBody
      public Map addPhoto(String report_id ,MultipartFile[] files,Byte bussness_type){
    	  
    	Map map =  photoService.addPhoto(report_id,files,bussness_type);  	
		return map;
    	  
      }
      /**
       * 
        * @Title: queryImage
        * @description 根据报单编号查询图片路径和类型
        * @param @param report_id
        * @param @return 
        * @return String    
        * @author caoyaru
        * @createDate 2018年11月28日-下午6:11:18
       */
      @ResponseBody
      @RequestMapping(value="/queryImage",produces = "application/json; charset=utf-8")
      public String queryImage(String report_id){
    	  List<Photo> path = null;
    	  try {
    		  path = photoService.queryImage(report_id);
			System.out.println("图片地址---------》"+path);
		} catch (Exception e) {
			code = -1;
			String msg = "失败";
		}
    	  
    	  return JsonUtil.getResponseJson(code, msg, null, path);
    	  
      }
}
