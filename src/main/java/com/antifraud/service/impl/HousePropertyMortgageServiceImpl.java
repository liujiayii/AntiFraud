package com.antifraud.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antifraud.dao.HousePropertyMortgageDao;
import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.User;
import com.antifraud.entityVO.FklistVo;
import com.antifraud.entityVO.HousePropertyMortgageVo;
import com.antifraud.service.HousePropertyMortgageService;

/**
 * 
 * @ClassName: HousePropertyMortgageServiceImpl
 * @description 房产抵押
 * @author 李凯
 * @createDate 2018年9月28日 上午10:23:52
 */
@Service("housePropertyMortgageService")
@Transactional(rollbackFor = { Exception.class })
public class HousePropertyMortgageServiceImpl implements HousePropertyMortgageService {

	@Resource
	private HousePropertyMortgageDao housePropertyMortgageDao;

	/** 通过id修改 */
	public HousePropertyMortgage updateById(HousePropertyMortgage housePropertyMortgage) {
		return housePropertyMortgageDao.updateById(housePropertyMortgage);
	}

	/**
	 * 根据id查询
	 */
	@Override
	public HousePropertyMortgage selectById(Long id) {
		return housePropertyMortgageDao.selectById(id);
	}

	/**
	 * 根据手机号查询
	 */
	@Override
	public List<HousePropertyMortgage> listAllAndPhone(String phone, Long user_id, Integer type, Integer status,
			Integer page, Integer size) throws Exception {

		return housePropertyMortgageDao.listAllAndPhone(phone, user_id, type, status, page, size);
	}

	/** 通过报单编号查询 */
	@Override
	public HousePropertyMortgage findByEntryNumber(String entry_number) {

		return housePropertyMortgageDao.findByEntryNumber(entry_number);
	}

	/**
	 * 保存全部 生成报单编号
	 */
	@Override
	public int saveAll(HousePropertyMortgage housePropertyMortgage) {
		HousePropertyMortgage lasthousePropertyMortgage = housePropertyMortgageDao.findLastEntryNumber();
		String lastEntry_number = null;
		try {
			lastEntry_number = lasthousePropertyMortgage.getEntry_number();

		} catch (Exception e) {
			housePropertyMortgage.setEntry_number("FW000000001");
		}
		if (null == lastEntry_number) {
			housePropertyMortgage.setEntry_number("FW000000001");
			lastEntry_number = "FW000000001";
		}
		String substring = lastEntry_number.substring(2);
		int number = Integer.parseInt(substring);
		number += 1;
		String zero = "";
		for (int i = 0; i < 9 - String.valueOf(number).length(); i++) {
			zero += "0";
		}
		String entry_number = "FW" + zero + number;
		housePropertyMortgage.setEntry_number(entry_number);

		// housePropertyMortgage.setRisk_management((long)number);
		int insert = 0;
		try {
			insert = housePropertyMortgageDao.insert(housePropertyMortgage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return insert;
	}

	/**
	 * 资产评估
	 */
	@Override
	public int ResultHousePropertyMortgage(HousePropertyMortgage housePropertyMortgage) {
		return housePropertyMortgageDao.ResultHousePropertyMortgage(housePropertyMortgage);
	}

	/** 根据user_id分页查询 */
	@Override
	public List<HousePropertyMortgage> findByLimit(Long user_id, Integer status, Integer page, Integer size) {

		return housePropertyMortgageDao.findByLimit(user_id, status, page, size);
	}

	/** 查询总数 */
	@Override
	public int getCount(Long user_id, Integer status, String phone, Integer type) {

		return housePropertyMortgageDao.getCount(user_id, status, phone, type);
	}

	/**
	 * 根据主键id删除
	 */
	@Override
	public int deleteById(Long id) {
		return housePropertyMortgageDao.deleteById(id);
	}

	/**
	 * 根据user_id查询全部
	 */
	@Override
	public List<HousePropertyMortgage> findByUserId(Integer user_id, Integer page, Integer limit) {
		return housePropertyMortgageDao.findByUserId(user_id, page, limit);
	}

	/**
	 * 增加的方法
	 */
	@Override
	public int insert(HousePropertyMortgage housePropertyMortgage) {
		return housePropertyMortgageDao.insert(housePropertyMortgage);
	}

	/**
	 * 根据id查询房产抵押详情（包括图片）
	 */
	@Override
	public HousePropertyMortgageVo getDetailsById(Long id) {
		return housePropertyMortgageDao.getDetailsById(id);
	}

	/**
	 * 查询全部
	 */
	@Override
	public List<HousePropertyMortgage> findAll() {
		return housePropertyMortgageDao.findAll();
	}

	/** 根据电话查询，无则查询全部 */
	@Override
	public List<HousePropertyMortgage> findByPhone(Long user_id, String phone) {

		return housePropertyMortgageDao.findByPhone(user_id, phone);
	}

	/** 根据风控人员Id(management)查询状态值(status)为3(业务反馈通过)的数据 */
	@Override
	public List<HousePropertyMortgage> findByManagement(Long management, Integer page, Integer size) {

		return housePropertyMortgageDao.findByManagement(management, page, size);
	}

	/** 统计风控人员Id(management)查询状态值(status)为3(业务反馈通过)的数据的总条数 */
	@Override
	public int findByManagementCount(Long management) {

		return housePropertyMortgageDao.findByManagementCount(management);
	}

	/**
	 * 查询上标所需要的字段
	 */
	@Override
	public List<FklistVo> findListAlls(String entry_number) {

		return housePropertyMortgageDao.findListAlls(entry_number);
	}

	/**
	 * 根据房屋报单编号修改状态值
	 */
	@Override
	public int updateStatus(String entry_number, int status) {
		int row = housePropertyMortgageDao.updateStatus(entry_number, status);
		return row;
	}

	/** 统计房贷总数 */
	@Override
	public int fiduciaryCount() {
		return housePropertyMortgageDao.fiduciaryCount();
	}

	/** 房贷金额 */
	@Override
	public BigDecimal houseMoney() {
		return housePropertyMortgageDao.houseMoney();
	}

	/** 根据ID修改状态 */
	@Override
	public int updateByIdStatus(Long id, Integer status) {

		return housePropertyMortgageDao.updateByIdStatus(id, status);
	}

	/** 修改报单状态和备注 */
	@Override
	public int updateStatusAndRemark(Long id, Integer status, String remark) {

		return housePropertyMortgageDao.updateStatusAndRemark(id, status, remark);
	}

	/**
	 * 查询房屋评估师id
	 */
	@Override
	public List<User> getassessmensId() {

		return housePropertyMortgageDao.getassessmensId();
	}

	/**
	 * 查询最后一条资产评估的id
	 */
	@Override
	public List<HousePropertyMortgage> lastid() {
		// TODO Auto-generated method stub
		return housePropertyMortgageDao.lastid();
	}

	/**
	 * 查询所有风控内勤人员
	 */
	@Override
	public List<User> getassessmensIdH() {
		return housePropertyMortgageDao.getassessmensIdH();
	}

	/**
	 * 查询最后一条报单的风控内勤id
	 */
	@Override
	public List<HousePropertyMortgage> lastidH() {
		return housePropertyMortgageDao.lastidH();
	}

	/**
	 * 修改风控内勤id
	 */
	@Override
	public int updateManagementId(Long id, Long management) {
		return housePropertyMortgageDao.updateManagementId(id, management);
	}

	/**
	 * 拒绝通过的方法(拒绝通过后,订单状态变为1,不通过,但是订单不会删除)
	 */
	@Override
	public int refuseToPass(String entry_number, int status) {
		return housePropertyMortgageDao.refuseToPass(entry_number, status);
	}

	/**
	 * 查询所有风控外勤人员
	 */
	@Override
	public List<User> getRiskManagementIdH() {
		return housePropertyMortgageDao.getRiskManagementIdH();
	}

	/**
	 * 修改风控外勤id
	 */
	@Override
	public int updateRiskManagementId(Long id, Long risk_management) {
		return housePropertyMortgageDao.updateRiskManagementId(id, risk_management);
	}

	/**
	 * 根据报单编号修改 备注信息
	 */
	@Override
	public int updateRemark(String entry_number, String remark) {
		return housePropertyMortgageDao.updateRemark(entry_number, remark);
	}

	/**
	 * 查询最后一条已通过面审的风控外勤id
	 */
	@Override
	public List<HousePropertyMortgage> lastidHS() {
		return housePropertyMortgageDao.lastidHS();
	}

	/**
	 * 根据报单编号修改更新时间
	 */
	@Override
	public int updateTimeH(String entry_number) {

		return housePropertyMortgageDao.updateTimeH(entry_number);
	}

	/**
	 * 根据报单编号查询当前操作人
	 */
	@Override
	public User selectManagement(String entry_number) {
		return housePropertyMortgageDao.selectManagement(entry_number);

	}

	/**
	 * 资产评估的修改字段
	 */
	@Override
	public int updatefield(HousePropertyMortgage housePropertyMortgage) {
		// TODO Auto-generated method stub
		return housePropertyMortgageDao.updatefield(housePropertyMortgage);
	}

	@Override
	public int submitDeclarationH(HousePropertyMortgage housePropertyMortgage) {
		return housePropertyMortgageDao.submitDeclarationH(housePropertyMortgage);

	}

	@Override
	public BigDecimal findByDate(String year, String month, String day) {
		BigDecimal bigDecimal = housePropertyMortgageDao.findByDate(year, month, day);
		if(bigDecimal!=null){
			return bigDecimal;
		}else{
			return null;
		}
		
	}

	@Override
	public Integer findByCount(String year, String month, String day) {
		Integer count = housePropertyMortgageDao.findByCount(year, month, day);
		return count;
	}

}
