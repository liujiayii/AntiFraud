package com.antifraud.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.antifraud.dao.SpotImageDao;
import com.antifraud.dao.SpotRecordDao;
import com.antifraud.entity.SpotRecord;
import com.antifraud.entity.Spot_image;
import com.antifraud.service.SpotImageService;
import com.antifraud.utils.UpdateFile;

/**
 * 
 *
 * @ClassName: SpotImageServiceImpl

 * @description 实地图片表接口方法实现
 *
 * @author lishaozhang
 * @createDate 2018年10月31日
 */
@Service
public class SpotImageServiceImpl implements SpotImageService{
	
	@Autowired
	private SpotImageDao  spotImageDao;
	
	@Autowired
	private SpotRecordDao spotRecordDao;
	
	//上传实地图片并保存信息到数据库
	@Override
	public Map saveSpotImage(String report_id, List<MultipartFile> files) {
		Map map = new HashMap<>();
		int reulat = 0;
		Spot_image spot_image = new Spot_image();
		
		Long id = null;
		//首先通过报单编号查询到实地记录表的id也就是实地图片表的Pid
		/*List<SpotRecord> findSpotRecordByReportId = spotRecordDao.findSpotRecordByReportId(report_id);
		SpotRecord spotRecord = findSpotRecordByReportId.get(0);
		Long pid = spotRecord.getId();
		System.out.println("pid"+pid);
*/		//先确认文件都是图片类型的格式如果是上传并保存信息到数据库如果不是返回错误代码
		
		//获取源文件格式
		for (MultipartFile file : files) {
			//获取原文件全文件名
			String originalFilename = file.getOriginalFilename();
			//文件后缀
			String img_format = originalFilename.substring(originalFilename.lastIndexOf(".")).replace(".", "");
		
			//文件类型验证 如果文件不符合要求返回错误信息  
			if(!"psdjpgpngsvg".contains(img_format)){
				
				map.put("code", -1);
				map.put("msg", "文件类型需要是psd jpg png svg 格式的图片");
				
				return map;
		}
	
	}
		//都通过校验后
		UpdateFile updateFile = new UpdateFile();
		for (MultipartFile file : files) {
			
			try {
				//将文件上传并返回文件上传之后的路径和类型
				Map<String, String> update = updateFile.update(file);
				String img_url = update.get("Path");
				String img_format = update.get("suffix");
				
				//将参数封入实体类并保存到数据库
				spot_image.setReport_id(report_id);
				spot_image.setImg_url(img_url);
				spot_image.setImg_format(img_format);
				spot_image.setCreate_time(new Date());
				reulat = spotImageDao.insertSpotlmage(spot_image);
				id = spot_image.getId();	
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
				map.put("code", -1);
				map.put("msg", "文件路径出现问题");
				
				return map;
				
			}
		}
		//没有出现异常返回正确参数  
		map.put("code", 1);
		map.put("msg", "保存成功");
		map.put("id", id);
		return map;
		          
}
    //根据报单编号或者pid查询实地图片表
	@Override
	public Map findSpotImageByPidOrReport_id(String report_id,int page, int limit) {
		
		Map map =new HashMap<>();

		//报单编号查询awd
		int star =(page - 1) * limit;

		List<Spot_image> Spot_imageList = spotImageDao.findSpotImageByPid(report_id,star,limit);
		
		if(Spot_imageList.size() <= 0){
			map .put("code", -1);
			map.put("msg", "暂时没有该客户实地图片信息");			
			return map;
		}
		
		
		map .put("code", 1);
		map.put("msg", "查询成功");		
		map.put("count",spotImageDao.findSpotImageByPidCount());
		map.put("data", Spot_imageList);
		
		return map;
	}
	
	
	@Override
	public Map updateSpotImageByid(Spot_image spot_image) {
		
		Map map = new HashMap<>();
		int result = spotImageDao.updateSpotImageByid(spot_image);
		
		if(result >= 1){
			map.put("code", 1);
			map.put("mas", "修改成功");
			return map;
		}
		map.put("code", -1);
		map.put("mas", "数据库没有这条记录");
		
		return map;
	
	}
	@Override
	public Map deleteSpotImageByPid(String report_id ) {
		
		Map map =new HashMap<>();
		
		int result = spotImageDao.deleteSpotImageByreport_id(report_id);
		if(result >= 1){
			map.put("code", 1);
			map.put("msg", "删除成功");
			return map;
		}
		
		map.put("code", 1);
		map.put("msg", "数据库目前没有该客户实地图片信息");
		return map;
		
	}
	@Override
	public Map deleteSpotImageByid(Long id) {
		
		Map map =new HashMap<>();
		
		int result = spotImageDao.deleteSpotImageByid(id);
		
		if(result >= 1){
			map.put("code", 1);
			map.put("msg", "删除成功");
			return map;
		}
		
		map.put("code", 1);
		map.put("msg", "数据库目前没有这条记录");
		return map;
	}
}