package com.antifraud.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.taglibs.standard.lang.jstl.Literal;

import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.User;
import com.antifraud.entity.VehicleMortgage;
import com.antifraud.entity.User;
import com.antifraud.entityVO.FiduciaryLoanVo;
import com.antifraud.entityVO.FklistVo;
import com.antifraud.utils.ResultInfo;

/**
 * 
 *
 * @ClassName: FiduciaryLoanDao
 * @description 信用贷款
 * @author qixiyao
 * @createDate 2018年10月26日-上午11:16:26
 */
public interface FiduciaryLoanDao {
	/**
	 * 
	 * @Title: findByUserId
	 * @description 根据user_id查询全部
	 * @param @param
	 *            user_id
	 * @param @return
	 * @return List<FiduciaryLoan>
	 * @author qixiyao
	 * @createDate 2018年11月7日-上午11:22:33
	 */
	List<FiduciaryLoan> findByUserId(@Param("user_id")Long user_id, @Param("page")Integer page, @Param("size")Integer size);

	/**
	 * 
	 * @Title: saveFiduciaryLoan
	 * @description 保存
	 * @param @param
	 *            fiduciaryLoan
	 * @param @return
	 * @return List<FiduciaryLoan>
	 * @author qixiyao
	 * @createDate 2018年10月26日-上午11:16:10
	 */
	public int saveFiduciaryLoan(@Param("fiduciaryLoan")FiduciaryLoan fiduciaryLoan);

	/**
	 * 
	 * @Title: insert
	 * @description 增加
	 * @param @param
	 *            fiduciaryLoan
	 * @param @return
	 * @return int
	 * @author qixiyao
	 * @createDate 2018年10月10日-上午10:37:16
	 */
	public int insert(FiduciaryLoan fiduciaryLoan);

	/**
	 * 
	 * @Title: insertfield
	 * @description 资产评估的添加字段
	 * @param @param
	 *            field
	 * @param @return
	 * @return int
	 * @author qixiyao
	 * @createDate 2018年10月26日-上午11:15:29
	 */
	public int insertfield(int field);

	/**
	 * 
	 * @Title: deleteFiduciaryLoanById
	 * @description 根据id删除
	 * @param @param
	 *            id
	 * @param @return
	 * @return int
	 * @author qixiyao
	 * @createDate 2018年10月26日-上午11:16:44
	 */
	public int deleteFiduciaryLoanById(Long id);

	/**
	 * 
	 * @Title: updateFiduciaryLoan
	 * @description 修改信用贷款（全部修改）
	 * @param @param
	 *            fiduciaryLoan
	 * @param @return
	 * @return int
	 * @author qixiyao
	 * @createDate 2018年10月26日-上午11:17:02
	 */
	public int updateFiduciaryLoan(FiduciaryLoan fiduciaryLoan);

	/**
	 * 
	 *
	 * @Title: updateFiduciaryLoan
	 * 
	 * @description 根据id修改
	 *
	 * @param @param
	 *            id
	 * 
	 * @return void
	 *
	 * 
	 * @author qixiyao
	 * @createDate 2018年10月8日-下午2:05:12
	 */
	public int updateFiduciaryLoanById(FiduciaryLoan fiduciaryLoan);

	/**
	 * 根据id查询
	 * 
	 * @Title: findById
	 * @description 根据id查询
	 * @param @param
	 *            id
	 * @param @return
	 * @return List<FiduciaryLoan>
	 * @author qixiyao
	 * @createDate 2018年10月26日-上午11:17:28
	 */
	FiduciaryLoan findById(Long id);

	/**
	 * 查询所有
	 *
	 * @Title: findAll
	 * @description
	 *
	 * @param @return
	 * @return List<FiduciaryLoan>
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月24日-下午1:52:59
	 */
	public List<FiduciaryLoan>  findAll();

	/**
	 * 通过电话查询（移动端）
	 *
	 * @Title: findByPhone
	
	 * @description 
	 *
	 * @param @param phone
	 * @param @return 
	   
	 * @return List<FiduciaryLoan>    
	
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月16日-下午4:35:56
	 */
	public List<FiduciaryLoan> findByPhone (@Param("user_id")Long user_id,@Param("phone")String phone);
	
	/**
	 * 根据手机号查询（业务报单模块，资产评估模块，业务反馈模块通用）
	 *
	 * @Title: findByPhone
	
	 * @description 
	 *
	 * @param phone 抵押人电话
	 * @param user_id 用户id
	 * @param type 报单状态
	 * @param status 进程状态
	 * @param page 当前页
	 * @param size 单页显示条数
	 * @param @return 	   
	 * @return List<FiduciaryLoan>    	
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月16日-下午2:51:35
	 */
	public List<FiduciaryLoan> listAllAndPhone(@Param("phone") String phone, @Param("user_id")Long user_id, @Param("type")Integer type, @Param("status")Integer status, @Param("page")Integer page, @Param("size")Integer size);

	/**
	 * 
	 * @Title: ResultFiduciaryLoan
	 * @description 资产评估
	 * @param @return
	 * @return Long
	 * @author qixiyao
	 * @createDate 2018年10月23日-上午11:24:16
	 */
	public FiduciaryLoan ResultFiduciaryLoan(FiduciaryLoan fiduciaryLoan);

	/**
	 * 通过报单编号查询
	 *
	 * @Title: findByEntryNumber
	 * @description
	 *
	 * @param @param
	 *            entry_number
	 * @param @return
	 * @return FiduciaryLoan
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月29日-下午2:04:13
	 */
	public FiduciaryLoan findByEntryNumber(String entry_number);

	/**
	 * 
	 * @Title: findLastEntryNumber
	 * @description 查询最大的一个报单编号
	 * @param @return
	 * @return FiduciaryLoan
	 * @author qixiyao
	 * @createDate 2018年11月1日-上午9:48:13
	 */
	FiduciaryLoan findLastEntryNumber();

	/**
	 * 分页查询
	 *
	 * @Title: findByLimit
	 * @description
	 *
	 * @param @param
	 *            page ：当前页
	 * @param @param
	 *            size ：每页显示条数
	 * @param @return
	 * @return List<FiduciaryLoan>
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月31日-下午3:34:29
	 */
	public List<FiduciaryLoan> findByLimit(@Param("user_id") Long user_id, @Param("status") Integer status, @Param("page") Integer page, @Param("size") Integer size);

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
	 * @createDate 2018年10月31日-下午4:27:30
	 */
	public int getCount(@Param("user_id") Long user_id, @Param("status") Integer status,@Param("phone") String phone, @Param("type") Integer type);

	/**
	 * 通过id查询信贷详细信息
	 *
	 * @Title: findDetailById
	 * @description
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * @return FiduciaryLoanVo
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月2日-下午4:57:04
	 */
	public FiduciaryLoanVo getDetailsById(Long id);

	/**
	 * 
	 *
	 * @Title: findallForCamapte
	 * @description 分页查询所有状态值为5的信用报单
	 *
	 * @param @param
	 *            page
	 * @param @param
	 *            page
	 * @param @returnsize
	 * @return
	 *
	 * @author lishaozhang
	 * @createDate 2018年11月8日-上午10:56:04
	 */
	List<FiduciaryLoan> findallForCamapte(@Param("star") int star, @Param("size") int size);
	//为分页而服务
	Integer findallForCamaptecount();
	/**
	 * 
	*
	 * @Title: updateFiduciaryLoanStatus
	
	 * @description 修改信用贷款保单任务状态进程
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
	Integer updateFiduciaryLoanStatus(@Param("entry_number")String entry_number, @Param("status")int status, @Param("remark")String remark);
	
	List<FklistVo> findListAlls(@Param("entry_number")String entry_number);
	
	
	

	/**
	 * 
	 *
	 * @Title: updateStatus
	 * @description 根据信贷报单编号修改状态值
	 * @param entry_number 信贷报单编号
	 * @param status 状态值
	 * @return int 受影响行数   
	 * @author ZhaoSong
	 * @createDate 2018年11月22日
	 */
	/*
	int updateStatus(String entry_number,int status);
	*/
	
	/**
>>>>>>> .r861
	 * @Title: findByManagement
	 *
	 * @description 根据风控人员Id(management)查询状态值(status)为3(业务反馈通过)的数据
	 *
	 * @param @param management
	 * @param @param page
	 * @param @param size
	 * @param @return 
	 * 
	 * @return List<FiduciaryLoan>    
	 *
	 * @author yaozijun
	 *
	 * @createDate 2018年11月22日
	 */
	List <FiduciaryLoan> findByManagement (@Param("management")Long management,@Param("page")Integer page, @Param("size")Integer size);
	
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
	 * 
	  * @Title: failedRemarks
	  * @description 资产评估的备注保存方法
	  * @param @param id
	  * @param @param remarks 
	  * @return void    
	  * @author caoyaru
	  * @createDate 2018年11月25日-下午5:17:21
	 */
	void failedRemarks(@Param("id")Long id, @Param("remarks")String remarks);

	/**
	 * 
	*
	 * @Title: fiandHousePropertyMortgageByStatus
	
	 * @description 用一句话描述这个方法的作用
	*
	 * @param @param status1
	 * @param @param status2
	 * @param @param star
	 * @param @param limit
	 * @param @return 
	   
	 * @return List<HousePropertyMortgage>    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年11月26日
	 */
	List <FiduciaryLoan>fiandFiduciaryLoanByStatus(@Param("status1")int status1,@Param("status2")int status2,@Param("star")int star,@Param("limit")int limit);
	Integer fiandFiduciaryLoanByStatusCount(@Param("status1")int status1,@Param("status2")int status2);

	
	/**
	 * 
	  * @Title: fiduciaryCount
	  * @description 统计信用贷款总条数
	  * @param @return 
	  * @return int    
	  * @author caoyaru
	  * @createDate 2018年11月26日-上午9:57:24
	 */
	int fiduciaryCount();
	
	/**
	 * 
	  * @Title: fiduciaryMoney
	  * @description 信贷金额
	  * @param @return 
	  * @return int    
	  * @author caoyaru
	  * @createDate 2018年11月26日-下午4:51:06
	 */
	BigDecimal fiduciaryMoney();
	
	/**
	 * 修改报单状态和备注
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
	 * @createDate 2018年11月27日-下午5:50:55
	 */
	int updateStatusAndRemark (@Param("id") Long id, @Param("status") Integer status, @Param("remark") String remark);
	/**
	 * 
	 * @Title: getassessmensId
	 * @description 查询信用评估师id
	 * @param @return  
	 * @return List<User>    
	 * @author qixiyao
	 * @createDate 2018年11月29日-上午10:37:05
	 */
	List<User> getassessmensId();
	/**
	 * 
	 * @Title: lastid
	 * @description 查询最后一条资产评估的id
	 * @param @return  
	 * @return List<FiduciaryLoan>    
	 * @author qixiyao
	 * @createDate 2018年11月29日-上午10:40:05
	 */
	List<FiduciaryLoan> lastid();
	
	
	
	
	
	
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
	 * @Title: lastidFS
	 * @description 查询最后一条已通过面审的风控外勤id
	 * @return List<FiduciaryLoan>   已通过面审的风控外勤id 
	 * @author ZhaoSong
	 * @createDate 2018年11月30日
	 */
	List<FiduciaryLoan> lastidFS();
	
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
	int updateRemark(@Param("entry_number")String entry_number,@Param("remark")String remark);
	
	
	/**
	 * @Title: findByEntryNumbers
	 * @description 根据报单编号查询
	 * @param @param entry_number 报单编号
	 * @return FiduciaryLoan   查到的对象
	 * @author ZhaoSong
	 * @createDate 2018年11月30日
	 */
	FiduciaryLoan findByEntryNumbers(String entry_number);

	/**
	 * 
	 * @Title: selectManagement
	 * @description 根据报单查询当前操作人
	 * @param @param entry_number
	 * @param @return  
	 * @return User    
	 * @author qixiyao
	 * @createDate 2018年12月6日-上午10:32:17
	 */
	User selectManagement(@Param("entry_number")String entry_number);
	

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
