package com.antifraud.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antifraud.dao.LiquidateManageDao;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.PostLoanManage;
import com.antifraud.entityVO.PostLoanManageVo;
import com.antifraud.service.LiquidateManageService;

/**
 * 
 *
 * @ClassName: LiquidateManageServiceImpl

 * @description 清收管理ServiceImpl层
 *
 * @author zhangkai
 * @createDate 2018年10月11日
 */
@Service
@Transactional
public class LiquidateManageServiceImpl implements LiquidateManageService{
	@Autowired
	LiquidateManageDao liquidateManageDao ;

	/**
	 * 主页列表分页查询房屋报单申请表
	 */
	@Override
	public List<PostLoanManageVo> findAllHousePropertyOnPages(int start, int limit) {
		return liquidateManageDao.findAllHousePropertyOnPages(start, limit);
	}
	
	/**
	 * 主页列表查询房屋报单申请表
	 */
	@Override
	public List<PostLoanManageVo> findAllHouseProperty() {
		return liquidateManageDao.findAllHouseProperty();
	}
	
	
	
	

	/**
	 * 主页列表分页查询车辆报单申请表
	 */
	@Override
	public List<PostLoanManageVo> findAllVehicleOnPages(int start, int limit) {
		return liquidateManageDao.findAllVehicleOnPages(start, limit);
	}
	
	/**
	 * 主页列表查询车辆报单申请表
	 */
	@Override
	public List<PostLoanManageVo> findAllVehicle() {
		return liquidateManageDao.findAllVehicle();
	}

	
	
	
	
	/**
	 * 主页列表查询信用报单申请表
	 */
	@Override
	public List<PostLoanManageVo> findAllFiduciary() {
		return liquidateManageDao.findAllFiduciary();
	}
	
	/**
	 * 主页列表分页查询信用报单申请表
	 */
	@Override
	public List<PostLoanManageVo> findAllFiduciaryOnPages(int start, int limit) {
		return liquidateManageDao.findAllFiduciaryOnPages(start, limit);
	}
	
	
	
	

	/**
	 * 主页按电话分页查询房屋报单申请表
	 */
	@Override
	public List<PostLoanManageVo> findHousePropertyByPhoneOnPages(String phone, int start, int limit) {
		return liquidateManageDao.findHousePropertyByPhoneOnPages(phone, start, limit);
	}

	/**
	 * 主页按电话分页查询车辆报单申请表
	 */
	@Override
	public List<PostLoanManageVo> findVehicleByPhoneOnPages(String phone, int start, int limit) {
		return liquidateManageDao.findVehicleByPhoneOnPages(phone, start, limit);
	}

	/**
	 * 主页按电话分页查询信用报单申请表
	 */
	@Override
	public List<PostLoanManageVo> findFiduciaryByPhoneOnPages(String phone, int start, int limit) {
		return liquidateManageDao.findFiduciaryByPhoneOnPages(phone, start, limit);
	}

	/**
	 * 详情页按报单编号查询房屋报单申请
	 */
	@Override
	public PostLoanManageVo findHousePropertyByEntry_number(String id) {
		return liquidateManageDao.findHousePropertyByEntry_number(id);
	}

	/**
	 * 详情页按报单编号查询车辆报单申请表
	 */
	@Override
	public PostLoanManageVo findVehicleByEntry_number(String id) {
		return liquidateManageDao.findVehicleByEntry_number(id);
	}

	/**
	 * 详情页按报单编号查询信用贷款申请表
	 */
	@Override
	public PostLoanManageVo findFiduciaryByEntry_number(String id) {
		return liquidateManageDao.findFiduciaryByEntry_number(id);
	}
	
	/**
	 * 主页按电话查询房屋报单申请表
	 */
	@Override
	public List<PostLoanManageVo> findHousePropertyByPhone(String phone) {
		return liquidateManageDao.findHousePropertyByPhone(phone);
	}

	/**
	 * 主页按电话查询车辆报单申请表
	 */
	@Override
	public List<PostLoanManageVo> findVehicleByPhone(String phone) {
		return liquidateManageDao.findVehicleByPhone(phone);
	}

	/**
	 * 主页按电话查询信用报单申请表
	 */
	@Override
	public List<PostLoanManageVo> findFiduciaryByPhone(String phone) {
		return liquidateManageDao.findFiduciaryByPhone(phone);
	}
	
	

	
}
