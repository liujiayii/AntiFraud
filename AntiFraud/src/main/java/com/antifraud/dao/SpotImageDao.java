package com.antifraud.dao;

import java.util.List;

import com.antifraud.entity.Spot_image;
/**
 * 
 *
 * @ClassName: CompactMapper

 * @description 实地模块图片
 *
 * @author lishaozhang
 * @createDate 2018年10月31日-下午13:28:50
 * */
public interface SpotImageDao {
	//增加的方法 
	int insertSpotlmage(Spot_image spot_image);
	//根据报pid查询实地图片表
    List<Spot_image> findSpotImageByPid(String report_id, int star, int limit);
	Integer findSpotImageByPidCount();
    //根据repited修改实地图片表
	int updateSpotImageByid(Spot_image spot_image);
    //根据id查询实地图片表 
	Spot_image findSpotImageByid(Long id);
	//根据report_id编号删除实地图片表的方法
	int deleteSpotImageByreport_id(String report_id);
	//根据ID删除实地图片表的方法 
	int deleteSpotImageByid(Long id);
	
}
