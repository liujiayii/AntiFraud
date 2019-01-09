package com.antifraud.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antifraud.dao.FiduciaryLoanDao;
import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.User;
import com.antifraud.entityVO.FiduciaryLoanVo;
import com.antifraud.entityVO.FklistVo;
import com.antifraud.service.FiduciaryLoanService;

/**
 * 
 *
 * @ClassName: FiduciaryLoanServiceImpl
 * 
 * @description 信用贷款Service的实现类
 *
 * @author qixiyao
 * @createDate 2018年10月8日-下午3:13:46
 */
@Service
public class FiduciaryLoanServiceImpl implements FiduciaryLoanService {

	@Autowired
	private FiduciaryLoanDao fiduciaryLoanDao;

	/** 显示信用贷款表全部 生成报单编号 */
	@Override
	public int saveFiduciaryLoan(FiduciaryLoan fiduciaryLoan) {
		System.out.println("打印一" + fiduciaryLoan);
		FiduciaryLoan lastFiduciaryLoan = fiduciaryLoanDao.findLastEntryNumber();
		String lastEntry_number = null;
		try {
			lastEntry_number = lastFiduciaryLoan.getEntry_number();

		} catch (Exception e) {
			fiduciaryLoan.setEntry_number("XY000000001");
		}
		String substring = lastEntry_number.substring(2);
		int number = Integer.parseInt(substring);
		number += 1;
		String zero = "";
		for (int i = 0; i < 9 - String.valueOf(number).length(); i++) {
			zero += "0";
		}
		String entry_number = "XY" + zero + number;
		fiduciaryLoan.setEntry_number(entry_number);
		System.out.println("打印二" + fiduciaryLoan);
		int insert = fiduciaryLoanDao.insert(fiduciaryLoan);
		System.out.println(insert);
		return insert;
		
	}

	/** 增加 */
	@Override
	public int insert(FiduciaryLoan fiduciaryLoan) {
		return fiduciaryLoanDao.insert(fiduciaryLoan);
	}

	/** 根据id删除 */
	@Override
	public int deleteFiduciaryLoanById(Long id) {
		return fiduciaryLoanDao.deleteFiduciaryLoanById(id);
	}

	/** 全部修改 */
	@Override
	public int updateFiduciaryLoan(FiduciaryLoan fiduciaryLoan) {
		return fiduciaryLoanDao.updateFiduciaryLoan(fiduciaryLoan);
	}

	/** 根据id修改 */
	@Override
	public int updateFiduciaryLoanById(FiduciaryLoan fiduciaryLoan) {
		return fiduciaryLoanDao.updateFiduciaryLoanById(fiduciaryLoan);
	}

	/** 根据id查询 */
	@Override
	public FiduciaryLoan findById(Long id) {

		return fiduciaryLoanDao.findById(id);
	}
	
	/** 根据手机号码查询 (移动端)*/
	@Override
	public List<FiduciaryLoan> findByPhone(Long user_id,String phone) {
		
		return fiduciaryLoanDao.findByPhone(user_id,phone);
	}
	
	/** 根据手机号码查询（pc端） */
	@Override
	public List<FiduciaryLoan> listAllAndPhone(String phone, Long user_id, Integer type, Integer status, Integer page, Integer size) {
		
		return fiduciaryLoanDao.listAllAndPhone(phone, user_id, type, status, page, size);
	}

	/** 通过报单编号查询 */
	@Override
	public FiduciaryLoan findByEntryNumber(String entry_number) {

		return fiduciaryLoanDao.findByEntryNumbers(entry_number);
	}

	/** 分页查询 */
	@Override
	public List<FiduciaryLoan> findByLimit(Long user_id, Integer status, Integer page, Integer size) {

		return fiduciaryLoanDao.findByLimit(user_id, status, page, size);
	}

	/** 查询总数 */
	@Override
	public int getCount(Long user_id, Integer status, String phone, Integer type) {

		return fiduciaryLoanDao.getCount(user_id, status, phone, type);
	}

	/** 资产评估 */
	@Override
	public FiduciaryLoan ResultFiduciaryLoan(FiduciaryLoan fiduciaryLoan) {
		return fiduciaryLoanDao.ResultFiduciaryLoan(fiduciaryLoan);
	}

	/**
	 * 通过id查询信贷详细信息
	 */
	@Override
	public FiduciaryLoanVo getDetailsById(Long id) {

		return fiduciaryLoanDao.getDetailsById(id);
	}

	/**
	 * 查询全部
	 */
	@Override
	public List<FiduciaryLoan> findAll() {
		return fiduciaryLoanDao.findAll();
	}

	/**
	 * 根据user_id查询全部
	 */
	@Override
	public List<FiduciaryLoan> findByUserId(Long user_id, Integer page, Integer size) {
		List<FiduciaryLoan> findByUserId = fiduciaryLoanDao.findByUserId(user_id, page, size);
		for (FiduciaryLoan fiduciaryLoan : findByUserId) {
			System.out.println(fiduciaryLoan);
		}
		return findByUserId;
	}
	/**
	 * 查询上标所需要的字段
	 */
	@Override
	public List<FklistVo> findListAlls(String entry_number) {
	
		return fiduciaryLoanDao.findListAlls(entry_number);
	}
	/**
	 * 根据信贷报单编号修改状态值
	 */
	@Override
	public int updateStatus(String entry_number, int status) {
		 int row = fiduciaryLoanDao.updateFiduciaryLoanStatus(entry_number, status,null);
		return row;
	}

	/** 根据风控人员Id(management)查询状态值(status)为3(业务反馈通过)的数据 */
	@Override
	public List <FiduciaryLoan> findByManagement(Long management, Integer page, Integer size) {
		
		return fiduciaryLoanDao.findByManagement(management, page, size);
	}
	
	/** 统计风控人员Id(management)查询状态值(status)为3(业务反馈通过)的数据的总条数 */
	@Override
	public int findByManagementCount(Long management) {
		
		return fiduciaryLoanDao.findByManagementCount(management);
	}
	
	
	
	/** 统计信用贷款总数 */
	@Override
	public int fiduciaryCount() {
		return fiduciaryLoanDao.fiduciaryCount();
	}
	
	/** 信贷金额 */
	@Override
	public BigDecimal fiduciaryMoney() {
		return fiduciaryLoanDao.fiduciaryMoney();
	}

	/**
	 * 修改状态和备注
	 */
	@Override
	public int updateStatusAndRemark(Long id, Integer status, String remark) {
		
		return fiduciaryLoanDao.updateStatusAndRemark(id, status, remark);
	}
	/**
	 * 查询信用评估时id
	 */
	@Override
	public List<User> getassessmensId() {
		return fiduciaryLoanDao.getassessmensId();
	}
	/**
	 * 查询最后一条资产评估的id
	 */
	@Override
	public List<FiduciaryLoan> lastid() {
		return fiduciaryLoanDao.lastid();
	}
	/**
	 * 查询所有风控内勤人员
	 */
	@Override
	public List<User> getassessmensIdF() {
		return fiduciaryLoanDao.getassessmensIdF();
	}
	/**
	 * 查询最后一条报单的风控内勤id
	 */
	@Override
	public List<FiduciaryLoan> lastidF() {
		return fiduciaryLoanDao.lastidF();
	}
	/**
	 * 修改风控内勤id
	 */
	@Override
	public int updateManagementId(Long id, Long management) {
		return fiduciaryLoanDao.updateManagementId(id, management);
	}
	/**
	 * 拒绝通过的方法(拒绝通过后,订单状态变为1,不通过,但是订单不会删除)
	 */
	@Override
	public int refuseToPass(String entry_number, int status) {
		return fiduciaryLoanDao.refuseToPass(entry_number, status);
	}
	/**
	 * 查询所有风控外勤人员
	 */
	@Override
	public List<User> getRiskManagementIdF() {
		return fiduciaryLoanDao.getRiskManagementIdF();
	}
	/**
	 * 修改风控外勤id
	 */
	@Override
	public int updateRiskManagementId(Long id, Long risk_management) {
		return fiduciaryLoanDao.updateRiskManagementId(id, risk_management);
	}
	/**
	 * 根据报单编号修改备注信息
	 */
	@Override
	public int updateRemark(String entry_number, String remark) {
		return fiduciaryLoanDao.updateRemark(entry_number, remark);
	}
	/**
	 * 查询最后一条已通过面审的风控外勤id
	 */
	@Override
	public List<FiduciaryLoan> lastidFS() {
		
		return fiduciaryLoanDao.lastidFS();
	}
	/**
	 * 根据报单查询当前操作人
	 */
	@Override
	public User selectManagement(String entry_number) {
		// TODO Auto-generated method stub
		return fiduciaryLoanDao.selectManagement(entry_number);
	}
	/**
	 * 根据报单编号修改更新时间
	 */
	@Override
	public int updateTimeF(String entry_number) {
		return	fiduciaryLoanDao.updateTimeF( entry_number);
	}

	@Override
	public int submitDeclarationF(FiduciaryLoan fiduciaryLoan) {
		return fiduciaryLoanDao.submitDeclarationF(fiduciaryLoan);
	}

}
