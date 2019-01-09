package com.antifraud.service;

import java.util.List;

import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.RecordManageSave;
import com.antifraud.entityVO.RecordManageVo;
import com.antifraud.entityVO.RecordManagerSaveVo;

/**
 * 
 *
 * @ClassName: RecordManageSaveService

 * @description 档案管理表
 *
 * @author zhangkai
 * @createDate 2018年10月9日
 */
public interface RecordManageSaveService {

	
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
	List <RecordManageSave> findAllRecord();
	
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
	 * @param report_id 报单编号
	 * @param @return    
	 * @return RecordManagerSaveVo    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月5日-下午2:43:57
	 */
	List<RecordManagerSaveVo> findRecordByRecordId(String report_id);
	
	/**
	 * 通过报单编号查询
	 *
	 * @Title: findByRecordId
	
	 * @description 
	 *
	 * @param report_id 报单编号
	 * @param @return 
	   
	 * @return RecordManageSave    
	
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月13日-下午4:51:35
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
	 * @createDate 2018年10月30日-下午1:50:43
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
	 * @createDate 2018年10月30日-下午1:56:16
	 */
	List<RecordManageSave> findAll ();
	
	/**
	 * 分页查询
	 *
	 * @Title: findByLimit
	 * @description 
	 *
	 * @param page 当前页
	 * @param size 每页显示条数
	 * @param @return    
	 * @return List<RecordManageSave>    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月31日-下午5:08:52
	 */
	List<RecordManagerSaveVo> findByLimit (Integer page, Integer size);
	
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
	 * @createDate 2018年10月31日-下午5:09:20
	 */
	int getCount();
	
	/**
	 * 为档案管理存表拓展类添加属性值
	 *
	 * @Title: addFields
	 * @description 
	 *
	 * @param name 抵押人姓名
	 * @param phone 抵押人电话
	 * @param business_type 业务类型(0 房产抵押，1 车辆抵押，2 信用借贷)
	 * @param read_name 借阅人姓名
	 * @return void    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月1日-下午3:51:41
	 */
	void addFields (RecordManagerSaveVo recordManageSaveVo, String name, String phone, Integer business_type, String read_name);
	
}
