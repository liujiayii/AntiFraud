package com.antifraud.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antifraud.dao.MovingTrackDao;
import com.antifraud.entity.MovingTrack;
import com.antifraud.service.MovingTrackService;
/**
 * 
 *
 * @ClassName: MovingTrackServiceImpl

 * @description 移动端 实地轨迹
 *
 * @author lishaozhang
 * @createDate 2018年10月30日
 */
@Service
public class MovingTrackServiceImpl implements MovingTrackService{
	
	@Autowired
	private MovingTrackDao movingTrackDao;

	@Override
	public Map insertMovingTrack(MovingTrack movingTrack) {
		Map map = new HashMap();
		movingTrack.setCreat_time(new Date());
		 int result = movingTrackDao.insertMovingTrack(movingTrack);
		 if(result >= 1){
			 map.put("code", 1);
			 map.put("msg", "保存成功");
			 return map;
		 }
		 map.put("code", -1);
		 map.put("msg", "保存失败");
		 return map;
		 
	}

	@Override
	public List<MovingTrack> findByUserId(Long user_id,int page,int limit) {
		int star = (page -1) * limit;
		
		return movingTrackDao.findMovingTrackByUserId(user_id,star,limit);
	}
}
