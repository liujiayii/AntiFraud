package com.antifraud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.SpotRecord;
import com.antifraud.entity.VehicleMortgage;
/**
 * 
 *
 * @ClassName: SpotRecordDao

 * @description 实地记录表
 *
 * @author lishaozhang
 * @createDate 2018年10月30日下午2:22
 */
public interface SpotRecordDao {
	/**
	 * 
	*
	 * @Title: insertSpotRecord
	
	 * @description 实地记录表插入 方法
	*
	 * @param @param spotRecord
	 * @param @return 
	   
	 * @return int    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年10月30日
	 */
    int insertSpotRecord(SpotRecord spotRecord);
    
    /**
     * 
    *
     * @Title: updateSpotRecordById
    
     * @description 修改实地记录
    *
     * @param @param spotRecord
     * @param @return 
       
     * @return int    
    
     *
     * @author lishaozhang
     * @createDate 2018年10月30日
     */
    int updateSpotRecordById(SpotRecord spotRecord);
    /**
     * 
    *
     * @Title: deleteSpotRecordById
    
     * @description 通过主键删除实地记录
    *
     * @param @param id
     * @param @return 
       
     * @return int    
    
     *
     * @author lishaozhang
     * @createDate 2018年10月30日
     */
    int deleteSpotRecordById(Long id);
    /**
     * 
    *
     * @Title: findSpotRecordByUserId
    
     * @description 通过风控人员id查询实地记录
    *
     * @param @param user_id
     * @param @return 
       
     * @return List<SpotRecord>    
    
     *
     * @author lishaozhang
     * @createDate 2018年10月30日
     */
    List<SpotRecord> findSpotRecordByUserId(@Param("user_id")Long user_id,@Param("star")int star,@Param("limit")int limit);
    Integer findSpotRecordByUserIdCount();
    /**
	 * 
	*
	 * @Title: findSpotRecordByReportId
	
	 * @description 通过订单编号查询实地记录
	 *
	 * @param @param reportId
	 * @param @return 
	   
	 * @return List<SpotRecord>    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年10月30日
	 */
    List<SpotRecord> findSpotRecordByReportId(@Param("reportId")String reportId,@Param("star")int star,@Param("limit")int limit);
    Integer findSpotRecordByReportIdCount();
    /**
     * 
    *
     * @Title: findAllSpotRecord
    
     * @description 分页查询所有实地记录数据
    *
     * @param @return 
       
     * @return List<SpotRecord>    
    
     *
     * @author lishaozhang
     * @createDate 2018年10月31日
     */
    List<SpotRecord> findAllSpotRecord(@Param("beginPageIndex") int beginPageIndex, @Param("endPageIndex") int endPageIndex);
    
    /**
     * @Title: findAllSpotRecordfd
     * @param beginPageIndex
     * @param endPageIndex
     * @return List<SpotRecord> 
     */
    List<SpotRecord> findAllSpotRecordfd(@Param("beginPageIndex") int beginPageIndex, @Param("endPageIndex") int endPageIndex, @Param("cs") String cs);
    
    /**
     * 
    *
     * @Title: findSpotRecordCount
    
     * @description 查询总记录数
    *
     * @param @return
       
     * @return int    
    
     *
     * @author lishaozhang
     * @createDate 2018年11月1日
     */
    Integer findSpotRecordCount();
    
    Integer findSpotRecordCountfd(@Param("cs") String cs);
    
    

	List<FiduciaryLoan> fiandFiduciaryLoanByStatus(@Param("status1")int status1,@Param("status2") int status2,@Param("star") int star,@Param("limit") int limit,@Param("management") Long management, @Param("risk_management") Long risk_management);

	Integer fiandFiduciaryLoanByStatusCount(@Param("status1")int status1,@Param("status2") int status2,@Param("management") Long management, @Param("risk_management") Long risk_management);

	List<HousePropertyMortgage> fiandHousePropertyMortgageByStatus(@Param("status1")int status1,@Param("status2") int status2,@Param("star") int star,@Param("limit") int limit,@Param("management") Long management, @Param("risk_management") Long risk_management);

	Integer fiandHousePropertyMortgageByStatusCount(@Param("status1")int status1,@Param("status2") int status2,@Param("management") Long management, @Param("risk_management") Long risk_management);

	List<VehicleMortgage> fiandVehicleMortgageByStatus(@Param("status1")int status1,@Param("status2") int status2,@Param("star") int star,@Param("limit") int limit,@Param("management") Long management, @Param("risk_management") Long risk_management);

	Integer fiandVehicleMortgageByStatusCount(@Param("status1")int status1,@Param("status2") int status2,@Param("management") Long management, @Param("risk_management") Long risk_management);
  
	
	/**
	 * 根据轨迹id查询全部信息
	 * @param trid
	 * @return  List<SpotRecord>
	 */
	   List<SpotRecord> findSpotRecordbytrid(@Param("trid")int trid);
	   
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
	 * @createDate 2018年12月24日-上午11:44:48
	 */
	 List<HousePropertyMortgage> findHouseInfoByPhoneOrName(@Param("phone") String phone, @Param("name") String name, @Param("user_id") Long user_id, @Param("page") Integer page, @Param("limit") Integer limit);
	 
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
	 List<FiduciaryLoan> findFiduciaryLoanByPhoneOrName(@Param("phone") String phone, @Param("name") String name, @Param("user_id") Long user_id, @Param("page") Integer page, @Param("limit") Integer limit);
	 
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
	 List<VehicleMortgage> findVehicleMortgageByPhoneOrName(@Param("phone") String phone, @Param("name") String name, @Param("user_id") Long user_id, @Param("page") Integer page, @Param("limit") Integer limit);
	 
	 
}
