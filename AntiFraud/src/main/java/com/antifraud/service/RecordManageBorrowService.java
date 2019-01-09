package com.antifraud.service;

import java.util.List;

import com.antifraud.entity.RecordManageBorrow;
import com.antifraud.entity.RecordManageSave;
import com.antifraud.entity.User;

/**
 * 
 *
 * @ClassName: RecordManageBorrowService

 * @description 借阅管理表
 *
 * @author zhangkai
 * @createDate 2018年10月9日
 */
public interface RecordManageBorrowService {
	
	/**
	 * 
	*
	 * @Title: borrowRecord
	
	 * @description 档案借阅
	*
	 * @param @param recordManageBorrow
	 * @param @return 
	   
	 * @return int    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年10月9日
	 */
	int borrowRecord(RecordManageBorrow recordManageBorrow);
	
	/**
	 * 
	*
	 * @Title: alterRecord
	
	 * @description 修改借阅记录
	*
	 * @param @param recordManageBorrow
	 * @param @return 
	   
	 * @return int    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年10月9日
	 */
	int alterBorrowRecord(RecordManageBorrow recordManageBorrow);
	
	/**
	 * 
	*
	 * @Title: findByRecordId
	
	 * @description 按id查询
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return RecordManageBorrow    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年10月16日
	 */
	RecordManageBorrow findRecordById(Long id);
	
	/**
	 * 
	*
	 * @Title: findAllRecord
	
	 * @description 全部查询
	*
	 * @param @return 
	   
	 * @return List<RecordManageBorrow>    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年10月19日
	 */
	List <RecordManageBorrow> findAllRecord();
	
	/**
	 * 通过报单编号查询借阅信息
	 *
	 * @Title: findRecordByReportId
	 * @description 
	 *
	 * @param report_id 报单编号
	 * @param @return    
	 * @return RecordManageBorrow    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月29日-上午11:54:43
	 */
	List<RecordManageBorrow> findRecordByReportId (String report_id);
	
	/**
	 * 查询所有档案借阅信息(通过报单编号分组显示)
	 *
	 * @Title: findRecordList
	 * @description 
	 *
	 * @param @return    
	 * @return List<RecordManageBorrow>    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月29日-下午1:42:31
	 */
	List<RecordManageBorrow> findRecordList ();
	
	/**
	 * 查询档案借阅表相同报单编号的最后一条借阅记录
	 *
	 * @Title: getRecordLastByReportId
	
	 * @description 
	 *
	 * @param report_id 报单编号
	 * @param @return 
	   
	 * @return RecordManageBorrow    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月19日-下午2:49:30
	 */
	RecordManageBorrow getRecordLastByReportId (String report_id);
	
	/**
	 * 添加档案借阅信息
	 *
	 * @Title: addRecordBorrow
	 * @description 
	 *
	 * @param recordManageBorrow
	 * @param @return    
	 * @return int    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月30日-上午11:36:23
	 */
	int addRecordBorrow (RecordManageBorrow recordManageBorrow);
	
	/**
	 * 分页查询
	 *
	 * @Title: findByLimit
	
	 * @description 
	 *
	 * @param report_id 报单编号
	 * @param page 当前页
	 * @param size 每页显示条数
	 * @param @return 
	   
	 * @return List<RecordManageBorrow>    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月19日-下午2:50:08
	 */
	List<RecordManageBorrow> findByLimit(String report_id, Integer page, Integer size);
	
	/**
	 * 查询总数，参数为空查询所有，不为空通过报单编号查询
	 *
	 * @Title: getCount
	
	 * @description 
	 *
	 * @param report_id 报单编号
	 * @param @return 
	   
	 * @return int    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月23日-上午11:03:15
	 */
	int getCount(String report_id);
}
