package com.antifraud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.antifraud.entity.MovingTrack;
/**
 * 
 *
 * @ClassName: MovingTrack

 * @description 移动端实地移动轨迹接口
 *
 * @author lishaozhang
 * @createDate 2018年10月30日-上午10:27:30
 * */
public interface MovingTrackDao {
	
	/**
	 * 
	*
	 * @Title: insertMovingTrack
	
	 * @description 实地移动端移动轨迹插入
	*
	 * @param @param movingTrack
	 * @param @return 
	   
	 * @return int    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年10月30日
	 */
   int insertMovingTrack(MovingTrack movingTrack);
	
   /**
    * 
   *
    * @Title: MovingTrack
   
    * @description 根据风控人员id查询移动轨迹
   *
    * @param @param user_id
    * @param @return 
      
    * @return List<MovingTrack>    
   
    *
    * @author lishaozhang
 * @param limit 
 * @param star 
    * @createDate 2018年10月30日
    */
	List<MovingTrack> findMovingTrackByUserId(@Param("user_id")long user_id, @Param("star")int star,@Param("limit") int limit);
	 
}
