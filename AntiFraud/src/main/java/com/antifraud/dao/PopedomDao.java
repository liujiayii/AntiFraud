package com.antifraud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.antifraud.entity.Popedom;
import com.antifraud.entity.Role;
import com.antifraud.entity.UserPopedom;


/**
 * @ClassName: PopedomDao
 * @description 权限管理持久层
 * @author ZhaoSong
 * @createDate 2018年11月12日
 */
public interface PopedomDao {

	
	/**
	 * @Title: findPopedomByUserId
	 * @description 根据用户id查询权限
	 * @param id 用户id  
	 * @return List<Popedom> 所有的权限    
	 * @author ZhaoSong
	 * @createDate 2018年11月5日
	 */
	List<Popedom> findPopedomByUserId(Long id);
	
	
	/**
	 * @Title: deletePopedomById
	 * @description 根据用户id删除所有权限
	 * @param id 用户id
	 * @return int 受影响行数   
	 * @author ZhaoSong
	 * @createDate 2018年11月5日
	 */
	int deletePopedomById(Long id);
	
	
	/**
	 * @Title: addPopedomById
	 * @description 根据用户id添加权限
	 * @param id 用户id
	 * @param userPopedom 用户权限对象
	 * @return int 生效行数
	 * @author ZhaoSong
	 * @createDate 2018年11月5日
	 */
	int addPopedomById(UserPopedom userPopedom);
	
}
