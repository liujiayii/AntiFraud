package com.antifraud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antifraud.dao.LogDao;
import com.antifraud.entity.Log;
import com.antifraud.service.LogService;
/**
 * 
  * @ClassName: LogServiceImpl
  * @description 日志
  * @author caoyaru
  * @createDate 2018年12月10日-下午4:20:57
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {
	@Autowired
	private LogDao logDao;
	
	/**
	 * 保存日志
	 */
	@Override
	public void saveLog(Log log) {
		logDao.saveLog(log);

	}
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Log> findById( Integer page, Integer size) {
		List<Log> findById = logDao.findById( page, size);
		return findById;
	}

	/** 查询总数 */
	@Override
	public int getCount() {

		return logDao.getCount();
	}
	
}
