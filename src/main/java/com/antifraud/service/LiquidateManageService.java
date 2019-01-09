package com.antifraud.service;
import java.util.List;

import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.PostLoanManage;
import com.antifraud.entityVO.PostLoanManageVo;

/**
 * 
 *
 * @ClassName: LiquidateManageService

 * @description 清收管理Service层
 *
 * @author zhangkai
 * @createDate 2018年10月11日
 */
public interface LiquidateManageService {
	
    
    /**
     * 
    *
     * @Title: findAllHousePropertyOnPages
    
     * @description  主页列表分页查询房屋报单申请表
    *
     * @param @param start
     * @param @param limit
     * @param @return 
       
     * @return List<PostLoanManageVo>    
    
     *
     * @author zhangkai
     * @createDate 2018年11月23日
     */
	List<PostLoanManageVo> findAllHousePropertyOnPages(int start, int limit);

	/**
	 * 
	*
	 * @Title: findAllHouseProperty
	
	 * @description 主页列表查询房屋报单申请表
	*
	 * @param @return 
	   
	 * @return List<PostLoanManageVo>    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年11月23日
	 */
	List<PostLoanManageVo> findAllHouseProperty();

	/**
	 * 
	*
	 * @Title: findAllVehicle
	
	 * @description 主页列表查询车辆报单申请表
	*
	 * @param @return 
	   
	 * @return List<PostLoanManageVo>    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年11月23日
	 */
	List<PostLoanManageVo> findAllVehicle();

	/**
	 * 
	*
	 * @Title: findAllVehicleOnPages
	
	 * @description 主页列表分页查询车辆报单申请表
	*
	 * @param @param start
	 * @param @param limit
	 * @param @return 
	   
	 * @return List<PostLoanManageVo>    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年11月23日
	 */
	List<PostLoanManageVo> findAllVehicleOnPages(int start, int limit);
	
    /**
     * 	
    *
     * @Title: findAllFiduciary
    
     * @description 主页列表查询信用报单申请表
    *
     * @param @return 
       
     * @return List<PostLoanManageVo>    
    
     *
     * @author zhangkai
     * @createDate 2018年11月23日
     */
	List<PostLoanManageVo> findAllFiduciary();

	/**
	 * 
	*
	 * @Title: findAllFiduciaryOnPages
	
	 * @description 主页列表分页查询信用报单申请表
	*
	 * @param @param start
	 * @param @param limit
	 * @param @return 
	   
	 * @return List<PostLoanManageVo>    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年11月23日
	 */
	List<PostLoanManageVo> findAllFiduciaryOnPages(int start, int limit);
	
    /**
     * 	
    *
     * @Title: findHousePropertyByPhone
    
     * @description 主页按电话查询房屋报单申请表
    *
     * @param @param phone
     * @param @return 
       
     * @return List<PostLoanManageVo>    
    
     *
     * @author zhangkai
     * @createDate 2018年11月23日
     */
	List<PostLoanManageVo> findHousePropertyByPhone(String phone);
	
	/**
	 * 
	*
	 * @Title: findHousePropertyByPhoneOnPages
	
	 * @description 主页按电话分页查询房屋报单申请表 
	*
	 * @param @param phone
	 * @param @param start
	 * @param @param limit
	 * @param @return 
	   
	 * @return List<PostLoanManageVo>    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年11月23日
	 */
	List<PostLoanManageVo> findHousePropertyByPhoneOnPages(String phone, int start, int limit);

	/**
	 * 
	*
	 * @Title: findVehicleByPhoneOnPages
	
	 * @description  主页按电话分页查询车辆报单申请表
	*
	 * @param @param phone
	 * @param @param start
	 * @param @param limit
	 * @param @return 
	   
	 * @return List<PostLoanManageVo>    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年11月23日
	 */
	List<PostLoanManageVo> findVehicleByPhoneOnPages(String phone, int start, int limit);
	
	/**
	 * 
	*
	 * @Title: findVehicleByPhone
	
	 * @description 主页按电话查询车辆报单申请表
	*
	 * @param @param phone
	 * @param @return 
	   
	 * @return List<PostLoanManageVo>    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年11月23日
	 */
	List<PostLoanManageVo> findVehicleByPhone(String phone);

	/**
	 * 
	*
	 * @Title: findFiduciaryByPhoneOnPages
	
	 * @description 主页按电话分页查询信用报单申请表
	*
	 * @param @param phone
	 * @param @param start
	 * @param @param limit
	 * @param @return 
	   
	 * @return List<PostLoanManageVo>    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年11月23日
	 */
	List<PostLoanManageVo> findFiduciaryByPhoneOnPages(String phone, int start, int limit);

	/**
	 * 
	*
	 * @Title: findFiduciaryByPhone
	
	 * @description 主页按电话查询信用报单申请表
	*
	 * @param @param phone
	 * @param @return 
	   
	 * @return List<PostLoanManageVo>    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年11月23日
	 */
	List<PostLoanManageVo> findFiduciaryByPhone(String phone);

	/**
	 * 
	*
	 * @Title: findHousePropertyByEntry_number
	
	 * @description 详情页按报单编号查询房屋报单申请
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return PostLoanManageVo    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年11月23日
	 */
	PostLoanManageVo findHousePropertyByEntry_number(String id);

	/**
	 * 
	*
	 * @Title: findVehicleByEntry_number
	
	 * @description 详情页按报单编号查询车辆报单申请表
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return PostLoanManageVo    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年11月23日
	 */
	PostLoanManageVo findVehicleByEntry_number(String id);

	/**
	 * 
	*
	 * @Title: findFiduciaryByEntry_number
	
	 * @description 详情页按报单编号查询信用贷款申请表
	*
	 * @param @param id
	 * @param @return 
	   
	 * @return PostLoanManageVo    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年11月23日
	 */
	PostLoanManageVo findFiduciaryByEntry_number(String id);
	
	
}
