package com.antifraud.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.antifraud.entity.Photo;
/**
 * 
 *
 * @ClassName: PhotoService
 * @description 根据报单编号上传图片
 * @author qixiyao
 * @createDate 2018年11月26日-下午2:20:01
 */
public interface PhotoService {

	Map addPhoto(String report_id, MultipartFile[] files,Byte bussness_type);
	/**
	 * 
	  * @Title: queryImage
	  * @description 根据报单编号查询图片路径和类型
	  * @param @param report_id 
	  * @return void    
	  * @author caoyaru
	  * @createDate 2018年11月28日-下午4:51:30
	 */
	List<Photo> queryImage(String report_id);
}
