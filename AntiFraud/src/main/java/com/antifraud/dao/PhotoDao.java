package com.antifraud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.antifraud.entity.Photo;

/**
 * 
 * @ClassName: PhotoDao
 * @description 房贷车贷信用贷图片
 * @author 李凯
 * @createDate 2018年9月28日 上午10:14:06
 */
public interface PhotoDao {
	
	/**
	 * @Title: deleteByPrimaryKey
	 * @description 根据主键删除
	 * @param id
	 * @return int
	 * @author 李凯
	 * @createDate 2018年9月28日 上午10:15:14
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 
	 * @Title: insert
	 * @description 增加(需要全部字段)
	 * @param record
	 * @return int
	 * @author 李凯
	 * @createDate 2018年9月28日 上午10:15:30
	 */
	int insert(Photo record);

	/**
	 * 
	 * @Title: insertSelective
	 * @description 选择性增加(无需全部字段)
	 * @param record
	 * @return int
	 * @author 李凯
	 * @createDate 2018年9月28日 上午10:17:14
	 */
	int insertSelective(Photo record);

	/**
	 * 
	 * @Title: selectByPrimaryKey
	 * @description 根据主键查询
	 * @param id
	 * @return Photo
	 * @author 李凯
	 * @createDate 2018年9月28日 上午10:18:22
	 */
	Photo selectByPrimaryKey(Long id);

	/**
	 * 
	 * @Title: updateByPrimaryKeySelective
	 * @description 选择性修改
	 * @param record
	 * @return int
	 * @author 李凯
	 * @createDate 2018年9月28日 上午10:18:40
	 */
	int updateByPrimaryKeySelective(Photo record);

	/**
	 * 
	 * @Title: updateByPrimaryKey
	 * @description 全部修改
	 * @param record
	 * @return int
	 * @author 李凯
	 * @createDate 2018年9月28日 上午10:18:53
	 */
	int updateByPrimaryKey(Photo record);

	/**
	 * @Title: listAll
	 * @description 查询所有
	 * @return List<Photo>
	 * @author 李凯
	 * @createDate 2018年9月26日 下午5:09:11
	 */
	List<Photo> listAll();
	/**
	 * 
	  * @Title: queryImage
	  * @description 根据报单编号查询图片路径和类型
	  * @param @param report_id
	  * @param @return 
	  * @return int    
	  * @author caoyaru
	  * @createDate 2018年11月28日-下午4:53:10
	 */
	List<Photo> queryImage(@Param("report_id")String report_id);
}