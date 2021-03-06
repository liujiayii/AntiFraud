package com.antifraud.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.antifraud.entity.User;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.User;
import com.antifraud.entity.VehicleMortgage;
import com.antifraud.entityVO.FklistVo;
import com.antifraud.entityVO.VehicleMortgageVo;
/**
 * 
 * @ClassName: VehicleMortgageService
 * @description 车辆质押抵押的接口类
 * @author caoyaru
 * @createDate 2018年10月8日-下午4:08:31
 */
public interface VehicleMortgageService {
	
	/**
	 * 
	 * @Title: updatefield
	 * @description 资产评估的修改字段
	 * @param @param vehicleMortgage
	 * @param @return  
	 * @return int    
	 * @author qixiyao
	 * @createDate 2018年12月10日-下午5:30:33
	 */
	int updatefield(VehicleMortgage vehicleMortgage);
	/**
	 * 
	 * @Title: findByPhone
	 * @description 根据手机号查询
	 * @param @param phone
	 * @param @return  
	 * @return List<VehicleMortgage>    
	 * @author qixiyao
	 * @createDate 2018年11月20日-下午4:08:39
	 */
	public List<VehicleMortgage> findByPhone (Long user_id,String phone);
	
	/**
	 * 
	 * @Title: findByUserId
	 * @description 根据user_id查询全部
	 * @param @param user_id
	 * @param @return  
	 * @return List<VehicleMortgage>    
	 * @author qixiyao
	 * @createDate 2018年11月7日-下午1:51:29
	 */
	List<VehicleMortgage> findByUserId(Long user_id, Integer page, Integer size);
	
	/**
	 * 
	 * @Title: addVehicleMortgage
	 * @description 保存
	 * @param @param vehicleMortgage 
	 * @return void    
	 * @author caoyaru
	 * @createDate 2018年10月8日-下午3:56:57
	 */
	int addVehicleMortgage(VehicleMortgage vehicleMortgage);
	
	/**
	 * 
	 * @Title: updateVehicleMortgage
	 * @description 根据ID修改
	 * @param @param id 
	 * @return void    
	 * @author caoyaru
	 * @createDate 2018年10月8日-下午4:11:31
	 */
	int updateVehicleMortgage(VehicleMortgage vehicleMortgage);
	
	/**
	 * 	
	 * @Title: findAllVehicleMortgage
	 * @description 查询全部记录
	 * @param @return 
	 * @return List<VehicleMortgage>    
	 * @author caoyaru
	 * @createDate 2018年10月8日-下午4:18:26
	 */
	
	List<VehicleMortgage> findAllVehicleMortgage();
	
	/**
	 * 选择性修改
	 *
	 * @Title: updateVehicleMortgageSelective
	 * @description 
	 *
	 * @param @param vehicleMortgage
	 * @param @return    
	 * @return int    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月29日-上午10:25:58
	 */
	int updateVehicleMortgageSelective (VehicleMortgage vehicleMortgage);
	
	/**
	 * 
	 * @Title: selectIdVehicleMortgage
	 * @description 根据主键ID查询
	 * @param @param id
	 * @param @return 
	 * @return VehicleMortgage    
	 * @author caoyaru
	 * @createDate 2018年10月8日-下午4:23:51
	 */
	VehicleMortgage selectIdVehicleMortgage(Long id);
	
	/**
	 * 通过电话模糊查询，参数为空则查询全部（业务报单，资产评估，业务反馈模块均可使用）
	 *
	 * @Title: listAllAndPhone
	
	 * @description 
	 *
	 * @param phone 电话号码
	 * @param user_id 用户id
	 * @param type 报单状态
	 * @param status 报单进程状态
	 * @param page 当前页数
	 * @param size 每页显示条数
	 * @param @return 
	   
	 * @return List<VehicleMortgage>    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月19日-下午2:44:03
	 */
	List<VehicleMortgage> listAllAndPhone(String phone, Long user_id, Integer type, Integer status, Integer page, Integer size);
	
	/**
	 * 
	  * @Title: deleById
	  * @description 根据ID删除
	  * @param @param id
	  * @param @return 
	  * @return int    
	  * @author caoyaru
	  * @createDate 2018年10月11日-下午1:47:12
	 */
	int deleById(Long id);
	
	/**
	 * 
	 * @Title: ResultVehicleMortgage
	 * @description 资产评估
	 * @param @param log
	 * @param @return  
	 * @return int    
	 * @author qixiyao
	 * @createDate 2018年10月31日-上午10:18:23
	 */
	
	VehicleMortgage ResultVehicleMortgage(Long status);
	
	/**
	 * 通过报单编号查询
	 *
	 * @Title: findByEntryNumber
	
	 * @description 
	 *
	 * @param entry_number 报单编号
	 * @param @return 
	   
	 * @return VehicleMortgage    
	
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月19日-下午2:44:47
	 */
	VehicleMortgage findByEntryNumber (String entry_number);

	
	/**
	 * 分页查询
	 *
	 * @Title: findByLimit
	
	 * @description 
	 *
	 * @param user_id 用户id
	 * @param status 报单进程状态
	 * @param page 当前页
	 * @param size 每页显示条数
	 * @param @return 
	   
	 * @return List<VehicleMortgage>    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月19日-下午2:45:05
	 */
	List<VehicleMortgage> findByLimit (Long user_id, Integer status, Integer page, Integer size);
	
	/**
	 * 查询总数（参数为空则查询全部条数）
	 *
	 * @Title: getCount
	
	 * @description 
	 *
	 * @param user_id 用户id
	 * @param status 用户进程状态
	 * @param phone 抵押人电话
	 * @param type 报单状态
	 * @param @return 
	   
	 * @return int    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月19日-下午2:45:53
	 */
	int getCount (Long user_id, Integer status, String phone, Integer type);

	/**
	 * 通过id查询车辆抵押详细信息
	 *
	 * @Title: getDetailsById
	 * @description 
	 *
	 * @param id 
	 * @param @return    
	 * @return VehicleMortgageVo    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月2日-下午5:07:56
	 */
	VehicleMortgageVo getDetailsById(Long id);
	/**
	 * 
	 * @Title: findListAlls
	 * @description 查询上标所需要的字段
	 * @param @param entry_number
	 * @param @return  
	 * @return List<FklistVo>    
	 * @author lichangchun
	 * @createDate 2018年12月10日-上午11:59:48
	 */
	List<FklistVo> findListAlls(String entry_number);
	
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
	List <VehicleMortgage> findByManagement( Long management, Integer page, Integer size);

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
	int updateStatus(String entry_number,int status);
	
	/**
	 * 
	  * @Title: fiduciaryCount
	  * @description 统计车贷总数
	  * @param @return 
	  * @return int    
	  * @author caoyaru
	  * @createDate 2018年11月26日-上午10:08:11
	 */
	public int fiduciaryCount();
	
	/**
	 * 
	  * @Title: houseMoney
	  * @description 车贷金额
	  * @param @return 
	  * @return int    
	  * @author caoyaru
	  * @createDate 2018年11月26日-下午4:40:01
	 */
	BigDecimal vehicleMoney();
	
	/**
	 * 
	  * @Title: updateByIdStatus
	  * @description 根据ID修改状态
	  * @param @param id
	  * @param @param status 
	  * @return void    
	  * @author caoyaru
	  * @createDate 2018年11月27日-下午4:32:53
	 */
	public int updateByIdStatus(Long id, Integer status);
	
	/**
	 * 修改状态和备注
	 *
	 * @Title: updateStatusAndRemark
	
	 * @description 
	 *
	 * @param @param id
	 * @param @param status
	 * @param @param remark
	 * @param @return 
	   
	 * @return int    
	
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月28日-下午2:52:11
	 */
	int updateStatusAndRemark (Long id, Integer status, String remark);
	/**
	 *查询最后一条报单的风控内勤id
	 */
	List<VehicleMortgage> lastid();
	/**
	 *查询车辆评估师id 
	 */
	List<User> getassessmensId();

	
	
	
	

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
	int updateManagementId(@Param("id")Long id,@Param("managemnt")Long managemnt);
	
	
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
	 * @Title: updateRemark
	 * @description 通过报单编号修改备注信息
	 * @param @param entry_number 报单编号
	 * @param @param remark 备注信息
	 * @return int   受影响行数
	 * @author ZhaoSong
	 * @createDate 2018年11月30日
	 */
	 int updateRemark(String entry_number,String remark);
	 
	
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
	 * 
	 * @Title: selectManagement
	 * @description 根据报单查询当前操作人
	 * @param @param entry_number
	 * @param @return  
	 * @return User    
	 * @author qixiyao
	 * @createDate 2018年12月6日-上午10:26:48
	 */
	 User selectManagement(String entry_number);
	
	
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
	 * @Title: submitDeclaration
	 * @description 修改并保存车辆报单
	 * @param vehicleMortgage 对象参数
	 * @return int 受影响行数   
	 * @author ZhaoSong
	 * @createDate 2018年12月24日
	 */
	int  submitDeclarationV(VehicleMortgage vehicleMortgage);
	
	
	
	
	
	
	
	
	
	/**
	  * @Title: findByDate
	  * @description 根据日期条件查询车辆报单总金额
	  * @param @param year 年份
	  * @param @param month 月份
	  * @param @param day 天
	  * @return BigDecimal 符合日期查询条件的车辆报单总金额  
	  * @author ZhaoSong
	  * @createDate 2019年1月23日
	 */
	BigDecimal findByDate(String year,String month,String day);
	
	
	/**
	  * @Title: findByCount
	  * @description 根据日期条件查询车辆报单数量
	  * @param @param year 年份
	  * @param @param month 月份
	  * @param @param day 天
	  * @return Integer 符合日期查询条件的车辆报单总数量   
	  * @author ZhaoSong
	  * @createDate 2019年1月23日
	 */
	Integer findByCount(String year,String month,String day);
	
	
	
	
	
	
	
}
