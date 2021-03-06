package com.antifraud.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.antifraud.dao.RecordManageSaveDao;
import com.antifraud.entity.RecordManageSave;
import com.antifraud.entityVO.RecordManagerSaveVo;
import com.antifraud.service.RecordManageSaveService;


/**
 * 
 *
 * @ClassName: RecordManageSaveServiceImpl

 * @description 档案管理表
 *
 * @author zhangkai
 * @createDate 2018年10月9日
 */
@Service
@Transactional
public class RecordManageSaveServiceImpl implements RecordManageSaveService{
	@Autowired 
	RecordManageSaveDao recordManageSaveDao;
	
	/**
	 * 消除档案
	 */
	@Override
	public int removeRecord(RecordManageSave recordManageSave) {
		int rows = recordManageSaveDao.removeRecord(recordManageSave);
		return rows;
	}
	
	
	/**
	 * 查询全部
	 */
	@Override
	public List <RecordManageSave> findAllRecord() {
		List <RecordManageSave> rows = recordManageSaveDao.findAllRecord();
		return rows;
	}	
	
	/**
	 * 通过id修改
	 */
	@Override
	public int alterRecordById(RecordManageSave recordManageSave) {
		int rows = recordManageSaveDao.alterRecordById(recordManageSave);
		return rows;
	}

	/**
	 * 按报单编号查询（模糊查询）
	 */
	@Override
	public List<RecordManagerSaveVo> findRecordByRecordId(String report_id) {
		
		return recordManageSaveDao.findRecordByRecordId(report_id);
	}
	
	/**
	 * 插入数据
	 */
	@Override
	public int addRecord(RecordManageSave recordManageSave) {
		int rows = recordManageSaveDao.addRecord(recordManageSave);
		return rows;
	}

	/**
	 * 通过报单编号修改
	 */
	@Override
	public int updateByReportId(RecordManageSave recordManageSave) {
		
		return recordManageSaveDao.updateByReportId(recordManageSave);
	}

    /**
     * 查询所有档案信息
     */
	@Override
	public List<RecordManageSave> findAll() {
		
		return recordManageSaveDao.findAll();
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<RecordManagerSaveVo> findByLimit(Integer page, Integer size) {

		return recordManageSaveDao.findByLimit(page, size);
	}

	/**
	 * 查询总数
	 */
	@Override
	public int getCount() {

		return recordManageSaveDao.getCount();
	}

	/**
	 * 为档案管理存表拓展类添加属性值
	 */
	@Override
	public void addFields(RecordManagerSaveVo recordManageSaveVo, String name, String phone, Integer business_type, String read_name) {
		recordManageSaveVo.setName(name);
		recordManageSaveVo.setPhone(phone);
		recordManageSaveVo.setBusiness_type(business_type);
		recordManageSaveVo.setRead_name(read_name);
	}

	/**
	 * 通过报单编号查询
	 */
	@Override
	public RecordManageSave findByRecordId(String report_id) {
		
		return recordManageSaveDao.findByRecordId(report_id);
	}
	
	
}
