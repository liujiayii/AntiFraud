package com.antifraud.service.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.antifraud.dao.PhotoDao;
import com.antifraud.entity.Photo;
import com.antifraud.service.PhotoService;
import com.antifraud.utils.UpdateFile;
/**
 * 
 *
 * @ClassName: PhotoServiceImpl
 * @description 根据报单编号上传图片
 * @author qixiyao
 * @createDate 2018年11月26日-下午2:27:14
 */
@Service
public class PhotoServiceImpl implements PhotoService {
          
	   @Autowired
	   private PhotoDao pjotoDao;
	   
	@Override
	public Map addPhoto(String report_id, MultipartFile[] files,Byte bussness_type) {
		Map map = new HashMap<>();
		
		for (MultipartFile file : files) {
			
			Photo photo = new Photo();
			
			Map<String, String> update;
			try {
				update = UpdateFile.update(file);
				
				String imgurl = update.get("Path");
				String img_format = update.get("suffix");
				photo.setCreate_time(new Date());
				photo.setImg_url(imgurl);
				photo.setImg_format(img_format);
				photo.setReport_id(report_id);
				/*Byte bussness_type;
			     if (report_id.startsWith("XY")) {
			    	 bussness_type = 2;
				} else if (report_id.startsWith("FW")) {
					 bussness_type = 0;
				}else {
					 bussness_type = 1;
				} */
			     photo.setBussness_type(bussness_type);
			     
			     pjotoDao.insert(photo);
			     map.put("code", 1);
			     map.put("msg", "上传成功");
			     
			     return map;
			     
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		     
		}
		map.put("code", -1);
		map.put("msg", "上传失败");
		return map;
		
		
			
	}
	
	/** 根据报单编号查询图片路径和类型*/
	@Override
	public List<Photo> queryImage(String report_id) {
		return pjotoDao.queryImage(report_id);
		
	}
	
	
}
