package com.antifraud.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.antifraud.entity.RecordManageBorrow;
import com.antifraud.entity.RecordManageSave;

/**
 * 
 *
 * @ClassName: RecordManageBorrowDao

 * @description 借阅管理表
 *
 * @author zhangkai
 * @createDate 2018年10月9日
 */
public interface RecordManageBorrowDao {
	
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
	
	 * @description 按报单编号查询
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return RecordManageBorrow    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年10月16日
	 */
	RecordManageBorrow findRecordByRecordId(Long id);
	
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
	 * @param @param report_id
	 * @param @return    
	 * @return RecordManageBorrow    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月29日-上午11:53:17
	 */
	List<RecordManageBorrow> findRecordByReportId (String report_id);
	
	/**
	 * 查询所有档案借阅信息
	 *
	 * @Title: findRecordList
	 * @description 
	 *
	 * @param @return    
	 * @return List<RecordManageBorrow>    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月29日-下午1:41:39
	 */
	List<RecordManageBorrow> findRecordList ();
	
	/**
	 * 查询档案借阅表相同报单编号的最后一条借阅记录
	 *
	 * @Title: getRecordLastByReportId
	 * @description 
	 *
	 * @param @return    
	 * @return RecordManageBorrow    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月30日-上午10:02:35
	 */
	RecordManageBorrow getRecordLastByReportId (String report_id);
	
	/**
	 * 通过id查询
	 *
	 * @Title: findRecordById
	
	 * @description 
	 *
	 * @param @param id
	 * @param @return 
	   
	 * @return RecordManageBorrow    
	
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月12日-下午5:14:31
	 */
	RecordManageBorrow findRecordById (Long id);
	
	/**
	 * 添加档案借阅信息
	 *
	 * @Title: addRecordBorrow
	 * @description 
	 *
	 * @param @param recordManageBorrow
	 * @param @return    
	 * @return int    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月30日-上午11:35:41
	 */
	int addRecordBorrow (RecordManageBorrow recordManageBorrow);
	
	/**
	 * 分页查询
	 *
	 * @Title: findByLimit
	 * @description 
	 *
	 * @param @param page
	 * @param @param size
	 * @param @return    
	 * @return List<RecordManageBorrow>    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月31日-下午5:02:05
	 */
	List<RecordManageBorrow> findByLimit(@Param("report_id") String report_id, @Param("page") Integer page, @Param("size") Integer size);
	
	/**
	 * 查询总数（参数为空查询总条数，不为空查询同一报单编号总条数）
	 *
	 * @Title: getCount
	 * @description 
	 * @param report_id 报单编号
	 * @param @return    
	 * @return int    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月31日-下午5:02:35
	 */
	int getCount(@Param("report_id") String report_id);
	
}


