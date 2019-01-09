package com.antifraud.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.RecordManageBorrow;
import com.antifraud.entity.RecordManageSave;
import com.antifraud.entityVO.RecordManageVo;
import com.antifraud.entityVO.RecordManagerSaveVo;

/**
 * 
 *
 * @ClassName: RecordManageSaveDao

 * @description 档案管理表
 *
 * @author zhangkai
 * @createDate 2018年10月9日
 */
public interface RecordManageSaveDao {

	
/**
 * 
*
 * @Title: removeRecord

 * @description 消除档案
*
 * @param @param recordManageSave
 * @param @return 
   
 * @return int    

 *
 * @author zhangkai
 * @createDate 2018年10月19日
 */
	int removeRecord(RecordManageSave recordManageSave);
	
/**
 * 
*
 * @Title: findAllRecord

 * @description 查询全部
*
 * @param @return 
   
 * @return List<RecordManageVo>    

 *
 * @author zhangkai
 * @createDate 2018年10月19日
 */
	List<RecordManageSave> findAllRecord();
	
/**
 * 
*
 * @Title: alterRecordById

 * @description 通过id修改
*
 * @param @param recordManageSave
 * @param @return 
   
 * @return int    

 *
 * @author zhangkai
 * @createDate 2018年10月19日
 */
	int alterRecordById(RecordManageSave recordManageSave);
	
	/**
	 * 通过报单编号查询（模糊查询）
	 *
	 * @Title: findRecordByRecordId
	 * @description 
	 *
	 * @param @param id
	 * @param @return    
	 * @return RecordManagerSaveVo    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月5日-下午2:42:49
	 */
	List<RecordManagerSaveVo> findRecordByRecordId(String report_id);
	
	/**
	 * 通过报单编号查询
	 *
	 * @Title: findByRecordId
	
	 * @description 
	 *
	 * @param @param report_id
	 * @param @return 
	   
	 * @return RecordManageSave    
	
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月13日-下午4:49:54
	 */
	RecordManageSave findByRecordId(String report_id);
	/**
	 * 
	*
	 * @Title: addRecord
	
	 * @description 插入数据
	*
	 * @param @param recordManageSave
	 * @param @return 
	   
	 * @return int    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年10月19日
	 */
	int addRecord(RecordManageSave recordManageSave);
	
	/**
	 * 通过报单编号修改
	 *
	 * @Title: updateByReportId
	 * @description 
	 *
	 * @param @param recordManageSave
	 * @param @return    
	 * @return int    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月30日-下午1:49:16
	 */
	int updateByReportId (RecordManageSave recordManageSave);
	
	/**
	 * 查询所有档案信息
	 *
	 * @Title: findAll
	 * @description 
	 *
	 * @param @return    
	 * @return List<RecordManageSave>    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月30日-下午1:55:20
	 */
	List<RecordManageSave> findAll ();
	
	/**
	 * 分页查询
	 *
	 * @Title: findByLimit
	 * @description 
	 *
	 * @param @param page
	 * @param @param size
	 * @param @return    
	 * @return List<RecordManageSave>    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月31日-下午5:03:11
	 */
	List<RecordManagerSaveVo> findByLimit(@Param("page") Integer page, @Param("size") Integer size);
	
	/**
	 * 查询总数
	 *
	 * @Title: getCount
	 * @description 
	 *
	 * @param @return    
	 * @return int    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月31日-下午5:03:28
	 */
	int getCount();
}
