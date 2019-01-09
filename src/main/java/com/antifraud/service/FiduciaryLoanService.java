package com.antifraud.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.User;
import com.antifraud.entity.VehicleMortgage;
import com.antifraud.entity.User;
import com.antifraud.entityVO.FiduciaryLoanVo;
import com.antifraud.entityVO.FklistVo;

/**
 * 
 *
 * @ClassName: FiduciaryLoanService
 * 
 * @description 信用贷款的Service接口类
 *
 * @author qixiyao
 * @createDate 2018年10月8日-下午2:27:22
 */
public interface FiduciaryLoanService {
	/** 保存全部 */
	public int saveFiduciaryLoan(FiduciaryLoan fiduciaryLoan);

	/** 根据user_id查询全部 */
	public List<FiduciaryLoan> findByUserId(Long user_id, Integer page, Integer size);

	/** 全部增加 */
	public int insert(FiduciaryLoan fiduciaryLoan);

	/** 查询全部 */
	public List<FiduciaryLoan> findAll();

	/** 根据id删除 */
	public int deleteFiduciaryLoanById(Long id);

	/** 全部修改 */
	public int updateFiduciaryLoan(FiduciaryLoan fiduciaryLoan);

	/** 根据id修改 */
	public int updateFiduciaryLoanById(FiduciaryLoan fiduciaryLoan);

	/** 根据id查询 */
	public FiduciaryLoan findById(Long id);

	/** 根据手机号查询（移动端） */
	public List<FiduciaryLoan> findByPhone (Long user_id,String phone);
	
	/**
	 * 通过电话模糊查询，参数为空则查询全部（业务报单，资产评估，业务反馈模块均可使用）
	 *
	 * @Title: listAllAndPhone
	 * @description 
	 * @param phone 电话号码
	 * @param user_id 用户id
	 * @param type 报单状态
	 * @param status 报单进程状态
	 * @param page 当前页数
	 * @param size 每页显示条数
	 * @param @return 
	 * @return List<FiduciaryLoan>    
	 * @author lujinpeng
	 * @createDate 2018年11月19日-下午2:39:05
	 */
	public List<FiduciaryLoan> listAllAndPhone(String phone, Long user_id, Integer type, Integer status, Integer page, Integer size);

	/** 资产评估 */
	public FiduciaryLoan ResultFiduciaryLoan(FiduciaryLoan fiduciaryLoan);

	/**
	 * 通过报单编号查询
	 * @Title: findByEntryNumber
	 * @description 
	 * @param entry_number 报单编号
	 * @param @return 
	 * @return FiduciaryLoan    
	 * @author lujinpeng
	 * @createDate 2018年11月19日-下午2:40:07
	 */
	public FiduciaryLoan findByEntryNumber(String entry_number);

	/**
	 * 分页查询
	 * @Title: findByLimit
	 * @description 
	 * @param user_id 用户id
	 * @param status 报单进程状态
	 * @param page 当前页数
	 * @param size 每页显示条数
	 * @param @return 
	 * @return List<FiduciaryLoan>    
	 * @author lujinpeng
	 * @createDate 2018年11月19日-下午2:40:42
	 */
	public List<FiduciaryLoan> findByLimit(Long user_id, Integer status, Integer page, Integer size);

	/**
	 * 查询条数（参数为空则查询全部条数）
	 * @Title: getCount
	 * @description 
	 * @param user_id 用户id
	 * @param status 报单进程状态
	 * @param phone 抵押人电话号码
	 * @param type 报单状态
	 * @param @return 
	 * @return int    
	 * @author lujinpeng
	 * @createDate 2018年11月19日-下午2:41:48
	 */
	public int getCount(Long user_id, Integer status, String phone, Integer type);

	/**
	 * 通过id查询信贷详细信息
	 * @Title: getDetailsById
	 * @description 
	 * @param id 报单id
	 * @param @return 
	 * @return FiduciaryLoanVo    
	 * @author lujinpeng
	 * @createDate 2018年11月19日-下午2:42:50
	 */
	public FiduciaryLoanVo getDetailsById(Long id);
	/**
	 * 
	 * @Title: findListAlls
	 * @description 查询上标所需要的字段
	 * @param @param entry_number
	 * @param @return  
	 * @return List<FklistVo>    
	 * @author lichangchun
	 * @createDate 2018年12月10日-上午11:57:47
	 */
	List<FklistVo> findListAlls(String entry_number);
	
	/**
	 * @Title: updateStatus
	 * @description 根据信贷报单编号修改状态值
	 * @param entry_number 信贷报单编号
	 * @param status 状态值
	 * @return int 受影响行数   
	 * @author ZhaoSong
	 * @createDate 2018年11月22日
	 */
	int updateStatus(String entry_number,int status);
	
	/**
	 * @Title: findByManagement
	 * @description 根据风控人员Id(management)查询状态值(status)为3(业务反馈通过)的数据
	 * @param @param management
	 * @param @param page
	 * @param @param size
	 * @param @return 
	 * @return List<FiduciaryLoan>    
	 * @author yaozijun
	 * @createDate 2018年11月22日
	 */
	List <FiduciaryLoan> findByManagement (Long management, Integer page, Integer size);
	
	/**
	 * @Title: findByManagementCount
	 * @description 统计风控人员Id(management)查询状态值(status)为3(业务反馈通过)的数据的总条数
	 * @param @param management
	 * @param @return 
	 * @return int    
	 * @author yaozijun
	 * @createDate 2018年11月22日
	 */
	int findByManagementCount (Long management);
	
	/**
	  * @Title: fiduciaryCount
	  * @description 统计信用贷款总条数
	  * @param @return 
	  * @return int    
	  * @author caoyaru
	  * @createDate 2018年11月26日-上午9:56:18
	 */
	public int fiduciaryCount();
	
	/**
	  * @Title: fiduciaryMoney
	  * @description 信贷金额
	  * @param @return 
	  * @return int    
	  * @author caoyaru
	  * @createDate 2018年11月26日-下午4:50:09
	 */
	BigDecimal fiduciaryMoney();
	
	/**
	 * 修改状态和备注
	 * @Title: updateStatusAndRemark
	 * @description 
	 * @param id 报单id
	 * @param status 报单状态
	 * @param remark 备注
	 * @param @return 
	 * @return int    
	 * @author lujinpeng
	 * @createDate 2018年11月28日-下午2:58:45
	 */
	int updateStatusAndRemark (Long id, Integer status, String remark);
	
	
	/**
	 * @Title: getassessmensId
	 * @description 查询所有风控内勤人员
	 * @return List<User> 所有风控内勤人员 
	 * @author ZhaoSong
	 * @createDate 2018年11月28日
	 */
	List<User> getassessmensIdF();
	
	/**
	 * @Title: getRiskManagementIdF
	 * @description 查询所有风控外勤人员
	 * @return List<User> 所有风控外勤人员   
	 * @author ZhaoSong
	 * @createDate 2018年11月30日
	 */
	List<User> getRiskManagementIdF();
	
	/**
	 * @Title: lastid
	 * @description 查询最后一条报单的风控内勤id
	 * @return List<FiduciaryLoan> 表中最后一条风控内勤id  
	 * @author ZhaoSong
	 * @createDate 2018年11月28日
	 */
	List<FiduciaryLoan> lastidF();
	
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
	 * 
	 * @Title: getassessmensId
	 * @description 查询信用评估时id
	 * @param @return  
	 * @return List<User>    
	 * @author qixiyao
	 * @createDate 2018年11月29日-上午10:38:18
	 */
	List<User> getassessmensId();
	/**
	 * 
	 * @Title: lastid
	 * @description 查询最后一条资产评估的id
	 * @param @return  
	 * @return List<FiduciaryLoan>    
	 * @author qixiyao
	 * @createDate 2018年11月29日-上午10:40:39
	 */
	List<FiduciaryLoan> lastid();
	
	/**
	 * @Title: refuseToPass
	 * @description 拒绝通过的方法(拒绝通过后,订单状态变为1,,不通过,但是订单不会删除)
	 * @param @param entry_number 信贷报单编号
	 * @param @param status 报单状态
	 * @return int 受影响行数   
	 * @author ZhaoSong
	 * @createDate 2018年11月29日
	 */
	int refuseToPass(@Param("entry_number")String entry_number,@Param("status")int status);
	
	
	/**
	 * @Title: updateRemark
	 * @description 根据报单编号修改备注信息
	 * @param @param entry_number 报单编号
	 * @param @param remark 备注信息
	 * @return int  受影响行数  
	 * @author ZhaoSong
	 * @createDate 2018年11月30日
	 */
	int updateRemark(String entry_number,String remark);
	
	
	/**
	 * @Title: lastidFS
	 * @description 查询最后一条已通过面审的风控外勤id
	 * @return List<FiduciaryLoan>   已通过面审的风控外勤id 
	 * @author ZhaoSong
	 * @createDate 2018年11月30日
	 */
	List<FiduciaryLoan> lastidFS();
	/**
	 * 
	 * @Title: selectManagement
	 * @description 根据报单查询当前操作人
	 * @param @param entry_number
	 * @param @return  
	 * @return User    
	 * @author qixiyao
	 * @createDate 2018年12月6日-上午10:31:09
	 */
	public User selectManagement(String entry_number);
	
	 /**
	  * @Title: updateTimeF
	  * @description 根据报单编号修改更新时间
	  * @param @param entry_number 报单编号
	  * @return int  受影响行数  
	  * @author ZhaoSong
	  * @createDate 2018年12月6日
	  */
	int updateTimeF(@Param("entry_number")String entry_number);
	
	

	/**
	 * @Title: submitDeclarationF
	 * @description 修改并保存信贷报单
	 * @param @param fiduciaryLoan 参数对象
	 * @return int 受影响行数   
	 * @author ZhaoSong
	 * @createDate 2018年12月24日
	 */
	int submitDeclarationF(FiduciaryLoan fiduciaryLoan);
	
}
