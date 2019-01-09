package com.antifraud.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.antifraud.entity.Spot_image;

/**
 * 
 *
 * @ClassName: SpotImageService

 * @description 实地图片表接口方法
 *
 * @author lishaozhang
 * @createDate 2018年10月31日
 */
public interface SpotImageService {
    /**
     * 
    *
     * @Title: saveSpotImage
    
     * @description 添加实地图片表的方法
    *
     * @param @param report_id
     * @param @param files
     * @param @return 
       
     * @return Map    
    
     *
     * @author lishaozhang
     * @createDate 2018年10月31日
     */
	Map saveSpotImage(String report_id, List<MultipartFile> files);
    /**
     * 
    *
     * @Title: findSpotImageByPidOrReport_id
    
     * @description 根据报单编号或pid查询图片表
    *
     * @param @param pid
     * @param @param report_id
     * @param @return 
       
     * @return Map    
    
     *
     * @author lishaozhang
     * @createDate 2018年10月31日
     */
	

	Map updateSpotImageByid(Spot_image spot_image);
	Map deleteSpotImageByid(Long id);
	Map findSpotImageByPidOrReport_id(String report_id, int page, int limit);
	Map deleteSpotImageByPid(String report_id);

}
