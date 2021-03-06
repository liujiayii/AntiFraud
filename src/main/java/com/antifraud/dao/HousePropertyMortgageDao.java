package com.antifraud.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.User;
import com.antifraud.entity.VehicleMortgage;
import com.antifraud.entityVO.FklistVo;
import com.antifraud.entityVO.HousePropertyMortgageVo;
import com.antifraud.utils.ResultInfo;
/**
 * @ClassName: HousePropertyMortgageDao
 * @description 房产抵押
 * @author 李凯
 * @createDate 2018年9月28日 上午10:13:06
 */
public interface HousePropertyMortgageDao {
	/**
	 * @Title: deleteByPrimaryKey
	 * @description 根据主键删除
	 * @param id
	 * @return
	 * int
	 * @author 李凯
	 * @createDate 2018年9月26日 上午10:08:11
	 */
	    int deleteByPrimaryKey(Long id);
	    /**
	     * 
	     * @Title: updateById
	     * @description 根据id修改
	     * @param @param housePropertyMortgage
	     * @param @return  
	     * @return HousePropertyMortgage    
	     * @author qixiyao
	     * @createDate 2018年11月16日-上午9:42:07
	     */
	    HousePropertyMortgage updateById(HousePropertyMortgage housePropertyMortgage);
	    /**
	     * 
	     * @Title: selectById
	     * @description 根据id查询
	     * @param @param id
	     * @param @return  
	     * @return HousePropertyMortgage    
	     * @author qixiyao
	     * @createDate 2018年11月16日-上午9:42:50
	     */
	    HousePropertyMortgage selectById(@Param("id")Long id);
	    /**
	     * 
	     * @Title: deleteById
	     * @description 根据id删除
	     * @param @param id
	     * @param @return  
	     * @return int    
	     * @author qixiyao
	     * @createDate 2018年11月16日-上午9:46:28
	     */
	    int deleteById(@Param("id") Long id);
	   /**
	    * 
	    * @Title: findByUserId
	    * @description 根据user_id查询全部
	    * @param @param user_id
	    * @param @param page
	    * @param @param limit
	    * @param @return  
	    * @return List<HousePropertyMortgage>    
	    * @author qixiyao
	    * @createDate 2018年11月13日-下午2:00:00
	    */
	    List<HousePropertyMortgage> findByUserId(@Param("user_id")Integer user_id,@Param("page")Integer page,@Param("limit")Integer limit);
	    
	    /**
	 * @Title: insert
	 * @description 增加(需要全部字段)
	 * @param record
	 * @return
	 * int
	 * @author 李凯
	 * @createDate 2018年9月26日 上午10:08:31
	 */
	    int insert(HousePropertyMortgage record);
	    
	    /**
	     * 
	     * @Title: insertfield
	     * @description 资产评估
	     * @param @param field
	     * @param @return  
	     * @return int    
	     * @author qixiyao
	     * @createDate 2018年10月26日-下午1:49:05
	     */
	    int ResultHousePropertyMortgage(HousePropertyMortgage housePropertyMortgage );

	    /**
	     * @Title: insertSelective
	     * @description 选择性增加(无需全部字段)
	     * @param record
	     * @return
	     * int
	     * @author 李凯
	     * @createDate 2018年9月26日 上午10:09:16
	     */
	    int insertSelective(HousePropertyMortgage record);

	/**
	 * @Title: selectByPrimaryKey
	 * @description 根据主键查询
	 * @param id
	 * @return
	 * HousePropertyMortgage
	 * @author 李凯
	 * @createDate 2018年9月26日 上午10:09:53
	 */
	    HousePropertyMortgage selectByPrimaryKey(Long id);

	/**
	 * @Title: updateByPrimaryKeySelective
	 * @description 选择性修改
	 * @param record
	 * @return
	 * int
	 * @author 李凯
	 * @createDate 2018年9月26日 上午10:10:45
	 */
	    int updateByPrimaryKeySelective (HousePropertyMortgage record);

	    /**
	 * @Title: updateByPrimaryKey
	 * @description 全部修改
	 * @param record
	 * @return int
	 * @author 李凯
	 * @createDate 2018年9月26日 上午10:11:46
	 */
	    int updateByPrimaryKey(HousePropertyMortgage record);
	    
	    /**
	     * 通过电话查询
	     *
	     * @Title: listAllAndPhone
	     * @description 
	     *
	     * @param phone 抵押人电话
	     * @param user_id 用户id
	     * @param type 报单状态
	     * @param status 报单进程状态
	     * @param page 当前页
	     * @param size 每页显示条数
	     * @param @return 
	       
	     * @return List<HousePropertyMortgage>    
	     *
	     * @author lujinpeng
	     * @createDate 2018年11月16日-下午2:02:13
	     */
		List<HousePropertyMortgage> listAllAndPhone(@Param("phone") String phone, @Param("user_id")Long user_id, @Param("type")Integer type, @Param("status")Integer status, @Param("page")Integer page, @Param("size")Integer size);
		
		/**
		 * 通过电话查询，无则查询全部
		 *
		 * @Title: findByPhone
		
		 * @description 
		 *
		 * @param @param phone
		 * @param @return 
		   
		 * @return List<HousePropertyMortgage>    
		
		 *
		 * @author lujinpeng
		 * @createDate 2018年11月15日-下午12:43:31
		 */
		List<HousePropertyMortgage> findByPhone (@Param("user_id")Long user_id,@Param("phone")String phone);
		
		/**

		 * @Title: getByid
		 * @description 根据主键ID查询（关联房贷车贷信用贷图片表）
		 * @param id
		 * @return
		 * HousePropertyMortgage
		 * @author 李凯
		 * @createDate 2018年9月26日 下午1:58:55
		 */
		List<HousePropertyMortgageVo> getByid(Long id);
		
		/**
		 * 根据id查询房产抵押详情（包括图片）
		 *
		 * @Title: getDetailsByid
		 * @description 
		 *
		 * @param @param id
		 * @param @return    
		 * @return List<HousePropertyMortgageVo>    
		 *
		 * @author lujinpeng
		 * @createDate 2018年11月2日-上午10:17:41
		 */
		HousePropertyMortgageVo getDetailsById(Long id);
		
		/**
		 * 查询房产抵押表所有信息
		 *
		 * @Title: findAll
		 * @description 查询全部
		 * @param @param page
		 * @param @param limit
		 * @param @return  
		 * @return List<HousePropertyMortgage>    
		 * @author qixiyao
		 * @createDate 2018年11月16日-上午10:34:44
		 */
		List<HousePropertyMortgage> findAll ();
		
		/**
		 * 
		 * @Title: saveAll
		 * @description 保存全部的方法
		 * @param @return  
		 * @return List<HousePropertyMortgage>    
		 * @author qixiyao
		 * @createDate 2018年10月29日-上午10:49:24
		 */
		int saveAll(@Param("housePropertyMortgage")HousePropertyMortgage housePropertyMortgage);
		
		
		/**
		 * 通过报单编号查询
		 *
		 * @Title: findAByEntryNumber
		 * @description 
		 *
		 * @param @param entry_number
		 * @param @return    
		 * @return HousePropertyMortgage    
		 *
		 * @author lujinpeng
		 * @createDate 2018年10月29日-下午2:11:33
		 */
		HousePropertyMortgage findByEntryNumber (String entry_number);
		
		/**

		 * 分页查询
		 *
		 * @Title: findByLimit
		 * @description 
		 *
		 * @param @param page
		 * @param @param size
		 * @param @return    
		 * @return List<HousePropertyMortgage>    
		 *
		 * @author lujinpeng
		 * @createDate 2018年10月31日-下午3:48:02
		 */
		List<HousePropertyMortgage> findByLimit (@Param("user_id")Long user_id, @Param("status")Integer status,@Param("page") Integer page, @Param("size") Integer size);
		
		/**
		 * 查询总数
		 * @Title: getCount
		 * @description 
		 * @param user_id 用户id
		 * @param status 进程状态
		 * @param phone 抵押人电话
		 * @param type 报单状态
		 * @param @return 
		 * @return int    
		 * @author lujinpeng
		 * @createDate 2018年11月16日-下午1:50:34
		 */
		int getCount (@Param("user_id") Long user_id, @Param("status") Integer status,@Param("phone") String phone, @Param("type") Integer type);
		
		/**
		 * 
		 * @Title: findLastEntryNumber
		 * @description 查询最大的一个报单编号
		 * @param @return  
		 * @return HousePropertyMortgage    
		 * @author qixiyao
		 * @createDate 2018年11月1日-下午2:28:09
		 */
		HousePropertyMortgage findLastEntryNumber();
		/**
		 * @Title: findAllHousePropertyMortgageForCompact
		 * @description 分页查询所有可以签合同的房屋抵押报单
		 * @param @param star
		 * @param @param limit
		 * @param @return 
		 * @return HousePropertyMortgage    
		 * @author lishaozhang
		 * @createDate 2018年11月8日
		 */
		List<HousePropertyMortgage> findAllHousePropertyMortgageForCompact(@Param("star") int star,@Param("limit") int limit);

		Integer  findAllHousePropertyMortgageForCompactCount();
         /**
          * @Title: updateHousePropertyMortgageStatus
          * @description 修改房屋贷款进程状态
          * @param @param entry_number
          * @param @param status
          * @param @return 
          * @return Integer    
          * @author lishaozhang
         * @param remark 
          * @createDate 2018年11月16日
          */
		Integer updateHousePropertyMortgageStatus(@Param("entry_number")String entry_number, @Param("status")int status,@Param("remark") String remark);
		
        /**
		 * @Title: findByManagement
		 * @description 根据风控人员Id(management)查询状态值(status)为3(业务反馈通过)的数据
		 * @param @param management
		 * @param @param page
		 * @param @param size
		 * @param @return 
		 * @return List<HousePropertyMortgage>    
		 * @author yaozijun
		 * @createDate 2018年11月26日
		 */
		List <HousePropertyMortgage> findByManagement (@Param("management")Long management,@Param("page")Integer page, @Param("size")Integer size);
		
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
		 * @createDate 2018年11月26日
		 */
		int findByManagementCount (Long management);
		
		/**
		 * 
		 * @Title: findListAlls
		 * @description 查询上标所需要的字段
		 * @param @param entry_number
		 * @param @return  
		 * @return List<FklistVo>    
		 * @author lichangchun
		 * @createDate 2018年12月10日-上午11:50:57
		 */
		List<FklistVo> findListAlls(@Param("entry_number")String entry_number);
		
		
		/**
		 * @Title: updateStatus
		 * @description 根据房屋报单编号修改状态值
		 * @param entry_number 房屋报单编号
		 * @param status 状态值
		 * @return int 受影响行数   
		 * @author ZhaoSong
		 * @createDate 2018年11月22日
		 */
		int updateStatus(@Param("entry_number")String entry_number,@Param("status")int status);
		/**
		 * 
		 * @Title: updatefield
		 * @description 资产评估的修改字段
		 * @param @param housePropertyMortgage
		 * @param @return  
		 * @return int    
		 * @author qixiyao
		 * @createDate 2018年12月10日-下午5:25:41
		 */
		int updatefield(HousePropertyMortgage housePropertyMortgage);
		/**
		 * 
		*
		 * @Title: fiandVehicleMortgageByStatus
		
		 * @description 根据状态分页查询房屋报单
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
		List <HousePropertyMortgage>fiandHousePropertyMortgageByStatus(@Param("status1")int status1,@Param("status2")int status2,@Param("star")int star,@Param("limit")int limit);
		
		Integer fiandHousePropertyMortgageByStatusCount(@Param("status1")int status1,@Param("status2")int status2);

		/**
		 * 
		  * @Title: fiduciaryCount
		  * @description 统计房贷总数
		  * @param @return 
		  * @return int    
		  * @author caoyaru
		  * @createDate 2018年11月26日-上午10:05:12
		 */
		int fiduciaryCount();
		
		/**
		 * 
		  * @Title: houseMoney
		  * @description 房贷金额
		  * @param @return 
		  * @return int    
		  * @author caoyaru
		  * @createDate 2018年11月26日-下午4:18:48
		 */
		BigDecimal houseMoney();
		
		/**
		 * 修改报单状态和备注
		 *
		 * @Title: updateStatusAndRemark
		
		 * @description 
		 *
		 * @param id 报单id
		 * @param status 报单状态
		 * @param remark 备注
		 * @param @return 
		   
		 * @return int    
		 *
		 * @author lujinpeng
		 * @createDate 2018年11月27日-下午5:50:00
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
		  * @createDate 2018年11月27日-下午4:44:20
		 */
		int updateByIdStatus(@Param("id")Long id, @Param("status")Integer status);
		
		
		/**
		 *查询房屋评估师id 
		 */
		List<User> getassessmensId();
		
		/**
		 * 查询最后一条资产评估的id
		 */
		List<HousePropertyMortgage> lastid();
		
		
		/**
		 * @Title: getassessmensId
		 * @description 查询所有风控内勤人员
		 * @return List<User> 所有风控内勤人员 
		 * @author ZhaoSong
		 * @createDate 2018年11月28日
		 */
		List<User> getassessmensIdH();
		
		
		
		/**
		 * @Title: getRiskManagementIdH
		 * @description 查询所有风控外勤人员
		 * @return List<User> 所有风控外勤人员   
		 * @author ZhaoSong
		 * @createDate 2018年11月30日
		 */
		List<User> getRiskManagementIdH();
		
		
		/**
		 * @Title: lastid
		 * @description 查询最后一条报单的风控内勤id
		 * @return List<HousePropertyMortgage> 表中最后一条风控内勤id  
		 * @author ZhaoSong
		 * @createDate 2018年11月28日
		 */
		List<HousePropertyMortgage> lastidH();
		
		/**
		 * @Title: lastidFS
		 * @description 查询最后一条已通过面审的风控外勤id
		 * @return List<HousePropertyMortgage>   已通过面审的风控外勤id 
		 * @author ZhaoSong
		 * @createDate 2018年11月30日
		 */
		List<HousePropertyMortgage> lastidHS();
		
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
		 * @param @param entry_number 房屋报单编号
		 * @param @param status 报单状态
		 * @return int 受影响行数   
		 * @author ZhaoSong
		 * @createDate 2018年11月29日
		 */
		int refuseToPass(@Param("entry_number")String entry_number,@Param("status")int status);
		
		/**
		 * @Title: updateRemark
		 * @description 根据报单编号修改 备注信息
		 * @param @param entry_number 报单编号
		 * @param @param remark 备注信息
		 * @return int    受影响行数
		 * @author ZhaoSong
		 * @createDate 2018年11月30日
		 */
		int updateRemark(@Param("entry_number")String entry_number,@Param("remark")String remark);
		/**
		 * 
		 * @Title: selectManagement
		 * @description 用根据报单编号查询当前操作人
		 * @param @param entry_number
		 * @param @return  
		 * @return String    
		 * @author qixiyao
		 * @createDate 2018年12月6日-上午10:04:39
		 */
		User selectManagement(@Param("entry_number")String entry_number);
		
		 /**
		  * @Title: updateTimeH
		  * @description 根据报单编号修改更新时间
		  * @param @param entry_number 报单编号
		  * @return int  受影响行数  
		  * @author ZhaoSong
		  * @createDate 2018年12月6日
		  */
		int updateTimeH(@Param("entry_number")String entry_number);
		
		
		/**
		 * @Title: submitDeclarationH
		 * @description 修改并提交房屋报单
		 * @param housePropertyMortgage 参数对象
		 * @return int 受影响行数   
		 * @author ZhaoSong
		 * @createDate 2018年12月24日
		 */
		int  submitDeclarationH(HousePropertyMortgage housePropertyMortgage);
		
		
		/**
		  * @Title: findByDate
		  * @description 根据日期查询首页房屋报单总金额
		  * @param @param year 年份
		  * @param @param month 月份
		  * @param @param day 天
		  * @return BigDecimal 符合条件的房屋报单总金额   
		  * @author ZhaoSong
		  * @createDate 2019年1月23日
		 */
		BigDecimal findByDate(@Param("year")String year,@Param("month")String month,@Param("day")String day);
		
		/**
		  * @Title: findBycount
		  * @description 根据日期查询首页房屋报单总数量
		  * @param @param year 年份
		  * @param @param month 月份
		  * @param @param day 天
		  * @return Integer 符合条件的房屋报单总数量
		  * @author ZhaoSong
		  * @createDate 2019年1月23日
		 */
		Integer findByCount(@Param("year")String year,@Param("month")String month,@Param("day")String day);
		
		
		
		
		
		
		
}