package com.antifraud.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antifraud.dao.PopedomDao;
import com.antifraud.entity.Popedom;
import com.antifraud.entity.Role;
import com.antifraud.entity.User;
import com.antifraud.entity.UserPopedom;
import com.antifraud.service.PopedomService;

@Service
public  class PopedomServiceImpl implements PopedomService{

	
	@Autowired
	private PopedomDao popedomDao;
	
	
	@Override
	public List<Popedom> findPopedomByUserId(Long id) {
		List<Popedom> popedoms = popedomDao.findPopedomByUserId(id);
		return popedoms;
	}


	@Override
	public int addPopedomByUserId(Long id,int[] popedoms) {
		System.out.println("进来了");
		int row = popedomDao.deletePopedomById(id);
		System.out.println("删除完毕");
		if(row>=0&&popedoms!=null){
			for(int popedom:popedoms){
				UserPopedom userPopedom = new UserPopedom();
				userPopedom.setId(null);
				userPopedom.setUser_id(id);
				userPopedom.setPopedom_id(popedom);
				Date date= new Date();
				userPopedom.setUpdate_time(date);
				userPopedom.setCreate_time(date);
				System.out.println("开始添加权限");
				int r = popedomDao.addPopedomById(userPopedom);
			}
				return row;
		}
		return 0;
	}
	
	

}
