package com.antifraud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.antifraud.entity.Log;
/**
 * 
  * @ClassName: LogDao
  * @description 日志
  * @author caoyaru
  * @createDate 2018年12月12日-上午9:34:14
 */
public interface LogDao {
	
	/**
	 * 
	  * @Title: saveLog
	  * @description 保存日志
	  * @param @param log 
	  * @return void    
	  * @author caoyaru
	  * @createDate 2018年12月10日-下午4:21:58
	 */
	public void saveLog(Log log) ;
	
	/**
	 * 
	  * @Title: findById
	  * @description 查询全部
	  * @param @return 
	  * @return Log    
	  * @author caoyaru
	  * @createDate 2018年12月11日-上午11:43:56
	 */
	public List<Log> findById(@Param("page") Integer page, @Param("size") Integer size);
	
	/**
	  * 
	  * @Title: getCount
	  * @description 查询总数
	  * @param @return 
	  * @return int    
	  * @author caoyaru
	  * @createDate 2018年12月12日-上午10:18:33
	 */
	int getCount();
}
