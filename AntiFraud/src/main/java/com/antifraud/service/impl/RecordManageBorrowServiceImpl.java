package com.antifraud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antifraud.dao.RecordManageBorrowDao;
import com.antifraud.entity.RecordManageBorrow;
import com.antifraud.entity.RecordManageSave;
import com.antifraud.entity.User;
import com.antifraud.service.RecordManageBorrowService;

/**
 * 
 *
 * @ClassName: RecordManageBorrowServiceImpl

 * @description 借阅管理表
 *
 * @author zhangkai
 * @createDate 2018年10月9日
 */
@Service
@Transactional
public class RecordManageBorrowServiceImpl implements RecordManageBorrowService{
	@Autowired
	RecordManageBorrowDao recordManageBorrowDao;
	
	/**
	 * 档案借阅
	 */
	@Override
	public int borrowRecord(RecordManageBorrow recordManageBorrow) {
		int rows = recordManageBorrowDao.borrowRecord(recordManageBorrow);
		return rows;
	}

	/**
	 * 修改借阅记录
	 */
	@Override
	public int alterBorrowRecord(RecordManageBorrow recordManageBorrow) {
		int rows = recordManageBorrowDao.alterBorrowRecord(recordManageBorrow);
		return rows;
	}

	/**
	 * 按id查询
	 */
	@Override
	public RecordManageBorrow findRecordById(Long id) {

		return recordManageBorrowDao.findRecordById(id);
	}
	
	/**
	 * 全部查询
	 */
	public List <RecordManageBorrow> findAllRecord() {
		List <RecordManageBorrow> rows = recordManageBorrowDao.findAllRecord();
		return rows;
	}

	/**
	 * 通过报单编号查询借阅信息
	 */
	@Override
	public List<RecordManageBorrow> findRecordByReportId(String report_id) {
		
		return recordManageBorrowDao.findRecordByReportId(report_id);
	}

	/**
	 * 查询所有档案借阅信息
	 */
	@Override
	public List<RecordManageBorrow> findRecordList() {
		
		return recordManageBorrowDao.findRecordList();
	}

	/**
	 * 查询档案借阅表相同报单编号的最后一条借阅记录
	 */
	@Override
	public RecordManageBorrow getRecordLastByReportId(String report_id) {
		
		return recordManageBorrowDao.getRecordLastByReportId(report_id);
	}

	/**
	 * 添加档案借阅信息
	 */
	@Override
	public int addRecordBorrow(RecordManageBorrow recordManageBorrow) {
		
		return recordManageBorrowDao.addRecordBorrow(recordManageBorrow);
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<RecordManageBorrow> findByLimit(String report_id, Integer page, Integer size) {
		
		return recordManageBorrowDao.findByLimit(report_id, page, size);
	}

	/**
	 * 查询总数
	 */
	@Override
	public int getCount(String report_id) {

		return recordManageBorrowDao.getCount(report_id);
	}
}





















