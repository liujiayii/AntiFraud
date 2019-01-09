package com.antifraud.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.User;
import com.antifraud.entity.User;
import com.antifraud.entity.VehicleMortgage;
import com.antifraud.entityVO.FklistVo;
import com.antifraud.entityVO.VehicleMortgageVo;
import com.antifraud.utils.ResultInfo;

/**
 * 
 * @ClassName: VehicleMortgageDao
 * @description 车辆质押抵押
 * @author caoyaru
 * @createDate 2018年10月8日-下午3:18:18
 */
public interface VehicleMortgageDao {
	
	/**
	 * 
	 * @Title: updatefield
	 * @description 资产评估的修改字段
	 * @param @param vehicleMortgage
	 * @param @return  
	 * @return int    
	 * @author qixiyao
	 * @createDate 2018年12月10日-下午5:30:13
	 */
	 int updatefield(VehicleMortgage vehicleMortgage);
	/**
	 * 
	 * @Title: findByUserId
	 * @description 根据user_id查询全部
	 * @param @param user_id
	 * @param @return  
	 * @return List<VehicleMortgage>    
	 * @author qixiyao
	 * @createDate 2018年11月7日-下午1:50:31
	 */
	List<VehicleMortgage> findByUserId(@Param("user_id")Long user_id,@Param("page") Integer page, @Param("size") Integer size);

	/**
	 * 
	 * @Title: addVehicleMortgage
	 * @description 保存
	 * @param @param
	 *            vehicleMortgage
	 * @return void
	 * @author caoyaru
	 * @createDate 2018年10月8日-下午4:09:21
	 */
	int addVehicleMortgage(VehicleMortgage vehicleMortgage);

	/**
	 * 
	 * @Title: updateVehicleMortgage
	 * @description 根据ID修改
	 * @param @param
	 *            id
	 * @param @return
	 * @return int
	 * @author caoyaru
	 * @createDate 2018年10月12日-上午10:10:49
	 */
	int updateVehicleMortgage(VehicleMortgage vehicleMortgage);

	/**
	 * 根据id选择性修改数据
	 *
	 * @Title: updateVehicleMortgageSelective
	 * @description
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * @return int
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月24日-下午4:18:04
	 */
	int updateVehicleMortgageSelective(VehicleMortgage vehicleMortgage);

	/**
	 * 
	 * @Title: findAllVehicleMortgage
	 * @description 查询全部记录
	 * @param @return
	 * @return List<VehicleMortgage>
	 * @author caoyaru
	 * @createDate 2018年10月8日-下午4:17:58
	 */
	List<VehicleMortgage> findAllVehicleMortgage();

	/**
	 * 
	 * @Title: selectIdVehicleMortgage
	 * @description 根据主键ID查询
	 * @param @param
	 *            id
	 * @param @return
	 * @return VehicleMortgage
	 * @author caoyaru
	 * @createDate 2018年10月8日-下午4:23:21
	 */
	VehicleMortgage selectIdVehicleMortgage(Long id);
	/**
	 * 
	 * @Title: findByPhone
	 * @description 根据手机号查询
	 * @param @param phone
	 * @param @return  
	 * @return List<VehicleMortgage>    
	 * @author qixiyao
	 * @createDate 2018年11月20日-下午4:08:06
	 */
	public List<VehicleMortgage> findByPhone (@Param("user_id")Long user_id, @Param("phone")String phone);

	/**
	 *
	 * @Title: listAllAndPhone
	 * @description 根据电话查询
	 * @param @param
	 *            phone
	 * @param @return
	 * @return List<VehicleMortgage>
	 * @author caoyaru
	 * @createDate 2018年10月8日-下午4:29:45
	 */
	List<VehicleMortgage> listAllAndPhone(@Param("phone") String phone, @Param("user_id")Long user_id, @Param("type")Integer type, @Param("status")Integer status, @Param("page")Integer page, @Param("size")Integer size);

	/**
	 * 
	 * @Title: deleById
	 * @description 根据ID删除
	 * @param @param
	 *            id
	 * @param @return
	 * @return int
	 * @author caoyaru
	 * @createDate 2018年10月11日-下午1:48:20
	 */
	int deleById(Long id);

	/**
	 * 
	 * @Title: ResultVehicleMortgage
	 * @description 资产评估
	 * @param @param
	 *            log
	 * @param @return
	 * @return int
	 * @author qixiyao
	 * @createDate 2018年10月23日-上午11:38:17
	 */
	VehicleMortgage ResultVehicleMortgage(@Param("id") Long id);

	/**
	 * 通过 报单编号查询
	 *
	 * @Title: findByEntryNumber
	 * @description
	 *
	 * @param @param
	 *            entry_number
	 * @param @return
	 * @return VehicleMortgage
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月29日-下午2:21:48
	 */
	VehicleMortgage findByEntryNumber(String entry_number);

	/**
	 * 
	 * @Title: findLastEntryNumber
	 * @description 查询最大的报单编号
	 * @param @return
	 * @return VehicleMortgage
	 * @author qixiyao
	 * @createDate 2018年11月1日-上午11:47:19
	 */
	VehicleMortgage findLastEntryNumber();

	/**
	 * 分页查询
	 *
	 * @Title: findByLimit
	 * @description
	 *
	 * @param @param
	 *            page
	 * @param @param
	 *            size
	 * @param @return
	 * @return List<VehicleMortgage>
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月31日-下午3:54:58
	 */
	List<VehicleMortgage> findByLimit(@Param("user_id") Long user_id, @Param("status") Integer status, @Param("page") Integer page, @Param("size") Integer size);

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
	 * @createDate 2018年10月31日-下午4:36:37
	 */
	int getCount(@Param("user_id") Long user_id, @Param("status") Integer status,@Param("phone") String phone, @Param("type") Integer type);

	/**
	 * 通过id查询车辆抵押详细信息
	 *
	 * @Title: getDetailsById
	 * @description
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * @return VehicleMortgageVo
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月2日-下午5:06:56
	 */
	VehicleMortgageVo getDetailsById(Long id);
	/**
	 * 
	*
	 * @Title: findAllVehicleMortgageForCamapte
	
	 * @description 分页查询所有可以签合同业务的车辆抵押业务报单
	*
	 * @param @param star
	 * @param @param limit
	 * @param @return 
	   
	 * @return List<VehicleMortgageVo>    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年11月8日
	 */
	List<VehicleMortgageVo> findAllVehicleMortgageForCamapte(@Param("star") int star,@Param("limit") int limit);

	Integer findAllVehicleMortgageForCamapteCount();
    /**
     * 
    *
     * @Title: updateVehicleMortgageStatus
    
     * @description 修改车辆贷款进程
    *
     * @param @param entry_number
     * @param @param status
     * @param @return 
       
     * @return Integer    
    
     *
     * @author lishaozhang
     * @param remark 
     * @createDate 2018年11月16日
     */
	Integer updateVehicleMortgageStatus(@Param("entry_number")String entry_number, @Param("status")int status, @Param("remark")String remark);
	/**
	 * 
	 * @Title: findListAlls
	 * @description 查询上标所需要的字段
	 * @param @param entry_number
	 * @param @return  
	 * @return List<FklistVo>    
	 * @author lichangchun
	 * @createDate 2018年12月10日-上午11:59:32
	 */
	List<FklistVo> findListAlls(@Param("entry_number")String entry_number);
	
	/**
	 * 
	 *
	 * @Title: findByManagement
	 *
	 * @description 根据风控人员Id(management)查询状态值(status)为3(业务反馈通过)的数据
	 *
	 * @param @param management
	 * @param @param page
	 * @param @param size
	 * @param @return 
	 * 
	 * @return List<VehicleMortgage>    
	 *
	 * @author yaozijun
	 *
	 * @createDate 2018年11月22日
	 */
	List <VehicleMortgage> findByManagement (@Param("management")Long management,@Param("page")Integer page, @Param("size")Integer size);

	/**
	 * 
	 *
	 * @Title: findByManagementCount
	 *
	 * @description 统计风控人员Id(management)查询状态值(status)为3(业务反馈通过)的数据的总条数
	 *
	 * @param @param management
	 * @param @return 
	 * 
	 * @return int    
	 *
	 * @author yaozijun
	 *
	 * @createDate 2018年11月22日
	 */
	int findByManagementCount (Long management);
	
	
	
	
	
	
	

	/**
	 * @Title: updateStatus
	 * @description 根据车辆报单编号修改状态值
	 * @param entry_number 车辆报单编号
	 * @param status 状态值
	 * @return int 受影响行数   
	 * @author ZhaoSong
	 * @createDate 2018年11月22日
	 */
	int updateStatus(@Param("entry_number")String entry_number,@Param("status")int status);

	/**
	 * 
	*
	 * @Title: fiandVehicleMortgageByStatus
	/**
	 * 
	  * @Title: fiduciaryCount
	  * @description 统计车贷总数
	  * @param @return 
	  * @return int    
	  * @author caoyaru
	  * @createDate 2018年11月26日-上午10:08:47
	 */
	int fiduciaryCount();

	
	/** @description 根据状态查询车辆抵押报单
	*
	 * @param @param status1
	 * @param @param status2
	 * @param @return 
	   
	 * @return List<VehicleMortgage>    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年11月26日
	 */
	List <VehicleMortgage>fiandVehicleMortgageByStatus(@Param("status1")int status1,@Param("status2")int status2,@Param("star")int star,@Param("limit")int limit);
	Integer fiandVehicleMortgageByStatusCount(@Param("status1")int status1,@Param("status2")int status2);
	/**
	 * 
	  * @Title: houseMoney
	  * @description 车贷金额
	  * @param @return 
	  * @return int    
	  * @author caoyaru
	  * @createDate 2018年11月26日-下午4:40:36
	 */
	BigDecimal vehicleMoney();
	
	/**
	 * 修改报单状态和备注信息
	 *
	 * @Title: updateStatusAndRemark
	
	 * @description 
	 *
	 * @param @param status
	 * @param @param remark
	 * @param @return 
	   
	 * @return int    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月27日-下午5:41:19
	 */
	int updateStatusAndRemark (@Param("id") Long id, @Param("status") Integer status, @Param("remark") String remark);
	
	/**
	 * 
	  * @Title: updateByIdStatus
	  * @description 根据ID修改状态
	  * @param @param id
	  * @param @param status
	  * @param @return 
	  * @return int    
	  * @author caoyaru
	  * @createDate 2018年11月27日-下午4:34:13
	 */
	int updateByIdStatus(@Param("id")Long id, @Param("status")Integer status);
	
	
	
	/**
	 * @Title: getassessmensId
	 * @description 查询所有风控内勤人员
	 * @return List<User> 所有风控内勤人员 
	 * @author ZhaoSong
	 * @createDate 2018年11月28日
	 */
	List<User> getassessmensIdV();
	
	
	/**
	 * @Title: getRiskManagementIdV
	 * @description 查询所有风控外勤人员
	 * @return List<User> 所有风控外勤人员   
	 * @author ZhaoSong
	 * @createDate 2018年11月30日
	 */
	List<User> getRiskManagementIdV();
	
	
	
	/**
	 * @Title: lastid
	 * @description 查询最后一条报单的风控内勤id
	 * @return List<VehicleMortgage> 表中最后一条风控内勤id  
	 * @author ZhaoSong
	 * @createDate 2018年11月28日
	 */
	List<VehicleMortgage> lastidV();
	
	/**
	 * @Title: lastidFS
	 * @description 查询最后一条已通过面审的风控外勤id
	 * @return List<VehicleMortgage>   已通过面审的风控外勤id 
	 * @author ZhaoSong
	 * @createDate 2018年11月30日
	 */
	List<VehicleMortgage> lastidVS();
	
	
	
	/**
	 * @Title: updateManagementId
	 * @description 修改风控内勤id
	 * @param @param id 报单id
	 * @param @param managemnt 风控内勤id
	 * @param @return   受影响行数
	 * @author ZhaoSong
	 * @createDate 2018年11月29日
	 */
	int updateManagementId(@Param("id")Long id,@Param("management")Long management);
	
	
	/**
	 * @Title: updateRiskManagementId
	 * @description 修改风控外勤id
	 * @param @param id 报单id
	 * @param @param risk_management 风控外勤id
	 * @return int   受影响行数
	 * @author ZhaoSong
	 * @createDate 2018年11月30日
	 */
	int updateRiskManagementId(@Param("id")Long id,@Param("risk_management")Long risk_management);
	
	/**
	 * @Title: refuseToPass
	 * @description 拒绝通过的方法(拒绝通过后,订单状态变为1,不通过,但是订单不会删除)
	 * @param @param entry_number 车辆报单编号
	 * @param @param status 报单状态
	 * @return int 受影响行数   
	 * @author ZhaoSong
	 * @createDate 2018年11月29日
	 */
	int refuseToPass(@Param("entry_number")String entry_number,@Param("status")int status);
	
	
	/**
	 * @Title: updateRemark
	 * @description 通过报单编号修改备注信息
	 * @param @param entry_number 报单编号
	 * @param @param remark 备注信息
	 * @return int   受影响行数
	 * @author ZhaoSong
	 * @createDate 2018年11月30日
	 */
	 int updateRemark(@Param("entry_number")String entry_number,@Param("remark")String remark);
	
	 
	 /**
	  * @Title: updateTimeV
	  * @description 根据报单编号修改更新时间
	  * @param @param entry_number 报单编号
	  * @return int  受影响行数  
	  * @author ZhaoSong
	  * @createDate 2018年12月6日
	  */
	int updateTimeV(@Param("entry_number")String entry_number);
	
	 
	
	/**
	 * 查询最后一条资产评估的id
	 */
	List<VehicleMortgage> lastid();
	
	/**
	 *查询房屋评估师id 
	 */
	List<User> getassessmensId();
	/**
	 * 
	 * @Title: selectManagement
	 * @description 根据报单查询当前操作人
	 * @param @param entry_number
	 * @param @return  
	 * @return User    
	 * @author qixiyao
	 * @createDate 2018年12月6日-上午10:27:58
	 */
	User selectManagement(@Param("entry_number")String entry_number);
	
	/**
	 * @Title: submitDeclaration
	 * @description 修改并保存车辆报单
	 * @param vehicleMortgage 对象参数
	 * @return int 受影响行数   
	 * @author ZhaoSong
	 * @createDate 2018年12月24日
	 */
	int  submitDeclarationV(VehicleMortgage vehicleMortgage);
}
