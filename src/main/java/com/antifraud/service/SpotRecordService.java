package com.antifraud.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.SpotRecord;
import com.antifraud.entity.VehicleMortgage;
/**
 * 
 *
 * @ClassName: SpotRecordService

 * @description 实地记录表
 *
 * @author lishaozhang
 * @createDate 2018年10月30日下午13:42
 */
public interface SpotRecordService {
  //插入实地记录
  public Map saveSpotRecord(SpotRecord spotRecord);
  //修改实地记录
  public Map updateSpotRecordById(SpotRecord spotRecord);
  //通过主键删除实地记录
  public Map deleteSpotRecordById(Long id);
  //通过实地人员id查询实地记录
  public Map findSpotRecordByUserId(Long user_id, int page, int limit);
  //通过报单编号查询实地记录	
  public Map findSpotRecordByReportId(String reportId, int page, int limit);
  //分页查询所有
  public Map findAllSpotRecord(int currentPage, int pageSize);
  //分頁按類型查詢
  public Map findAllSpotRecordfd(int beginPageIndex, int endPageIndex,String cs);
  //实地结果判定审核结果通过未通过
  public Map judgementResult(String reportId, int status, String remark);
  //根据状态值
  public Map fiandVehicleMortgageByStatus(int status1, int status2, int page, int limit, long userid, long risk_management);
  public Map fiandFiduciaryLoanByStatus(int status1, int status2, int page, int limit, long management,long risk_management);
  public Map fiandHousePropertyMortgageByStatus(int status1, int status2, int page, int limit, long management,long risk_management);
  
  List<SpotRecord> findSpotRecordbytrid(int trid);
  
  /**
   * 通过电话或者姓名查询面审实地模块房产信息
   *
   * @Title: findHouseInfoByPhoneOrName 
   * @description 
   *
   * @param phone 电话
   * @param name 抵押人姓名
   * @param user_id 用户id
   * @param page 当前页数
   * @param limit 每页显示条数
   * @return 
     
   * List<HousePropertyMortgage>    
   *
   * @author lujinpeng
   * @createDate 2018年12月24日-上午11:46:10
   */
  List<HousePropertyMortgage> findHouseInfoByPhoneOrName(String phone, String name, Long user_id, Integer page, Integer limit);

  /**
	 * 通过电话或者姓名查询面审实地模块信贷信息
	 *
	 * @Title: findFiduciaryLoanByPhoneOrName	
	 * @description 
	 *
	 * @param phone 电话
	 * @param name 抵押人姓名
	 * @param user_id 用户id
	 * @param page 当前页数
	 * @param limit 每页显示条数
	 * @return 
	   
	 * List<FiduciaryLoan>    
	 *
	 * @author lujinpeng
	 * @createDate 2018年12月24日-上午11:44:48
	 */
	 List<FiduciaryLoan> findFiduciaryLoanByPhoneOrName(String phone, String name, Long user_id, Integer page, Integer limit);
	 
	/**
	 * 通过电话或者姓名查询面审实地模块车贷信息
	 *
	 * @Title: findVehicleMortgageByPhoneOrName	
	 * @description 
	 *
	 * @param phone 电话
	 * @param name 抵押人姓名
	 * @param user_id 用户id
	 * @param page 当前页数
	 * @param limit 每页显示条数
	 * @return 
	   
	 * List<VehicleMortgage>    
	 *
	 * @author lujinpeng
	 * @createDate 2018年12月24日-上午11:44:48
	 */
	 List<VehicleMortgage> findVehicleMortgageByPhoneOrName(String phone, String name, Long user_id, Integer page, Integer limit);
  
}
