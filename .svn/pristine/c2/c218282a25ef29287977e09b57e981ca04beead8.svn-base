package com.antifraud.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antifraud.dao.FiduciaryLoanDao;
import com.antifraud.dao.HousePropertyMortgageDao;
import com.antifraud.dao.VehicleMortgageDao;
import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.VehicleMortgage;
import com.antifraud.service.BusFeedbackTimerService;

/**
 * 业务反馈service实现接口(自定义超时时间，超时修改报单状态type值为0<作废>)
 *
 * @ClassName: BusFeedbackTimerService
 * @description 
 *
 * @author lujinpeng
 * @createDate 2018年10月24日-上午11:17:19
 */
@Service
public class BusFeedbackTimerServiceImpl implements BusFeedbackTimerService {
	private static final Logger logger = Logger.getLogger(BusFeedbackTimerServiceImpl.class);

	/** 信用贷款 */
	@Autowired
	private FiduciaryLoanDao fiduciaryLoanDao;
	/** 房产抵押 */
	@Resource
	private HousePropertyMortgageDao housePropertyMortgageDao;
	/** 车辆抵押 */
	@Resource
	private VehicleMortgageDao vehicleMortgageDao;
	
	/**
	 * 信用贷款业务反馈
	 */
	@Override
	public void updateFiduciaryLoanStatus() {
		List<FiduciaryLoan> fiduciaryLoanList = fiduciaryLoanDao.findAll();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = sdf.format(new Date());
		long toDate;
		System.out.println("我是信贷");
		try {
			/** 获取当前时间戳 */
			toDate = sdf.parse(formatDate).getTime();
			
			for (FiduciaryLoan fiduciaryLoan : fiduciaryLoanList) {
				
				if (fiduciaryLoan.getAffirm_time() != null) {
					long fromDate = fiduciaryLoan.getAffirm_time().getTime();
					//超时时间(天)
					int day = fiduciaryLoan.getAffirm_date();
					
					/** 从确认时间到当前时间（天）大于自定义超时时间，资产评估通过（2），处于提交状态（1），则将进程状态设置为0 */
					if (((toDate - fromDate)/(1000 * 60 * 60 * 24)) > day && fiduciaryLoan.getType() == 1
							&& fiduciaryLoan.getStatus() == 2) {
						/** 设置状态为0（作废）*/
						fiduciaryLoan.setStatus(0);
						/** 设置备注 */
						fiduciaryLoan.setRemark("自定义超时 ");
						
						fiduciaryLoanDao.updateStatusAndRemark(fiduciaryLoan.getId(),fiduciaryLoan.getStatus(),fiduciaryLoan.getRemark());
					}
				}
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("超时修改状态失败！");
		}
		
	}

	/**
	 * 房产抵押
	 */
	@Override
	public void updateHousePropertyMortgage() {
		List<HousePropertyMortgage> housePropertyMortgageList = housePropertyMortgageDao.findAll();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = sdf.format(new Date());
		long toDate;
		System.out.println("我是房产");
		try {
			/** 获取当前时间戳 */
			toDate = sdf.parse(formatDate).getTime();
			
			for (HousePropertyMortgage housePropertyMortgage : housePropertyMortgageList) {
				
				if (housePropertyMortgage.getAffirm_time() != null) {
					long fromDate = housePropertyMortgage.getAffirm_time().getTime();
					//超时时间(天)
					int day = housePropertyMortgage.getAffirm_date();
					/** 从确认时间到当前时间（天）大于自定义超时时间，资产评估通过（2），处于提交状态（1），则将进程状态设置为0 */
					if (((toDate - fromDate)/(1000 * 60 * 60 * 24)) > day && housePropertyMortgage.getStatus() == 2
							&& housePropertyMortgage.getType() == 1) {
						/** 设置状态为0（作废）*/
						housePropertyMortgage.setStatus(0);
						/** 设置备注 */
						housePropertyMortgage.setRemark("自定义超时");
						
						housePropertyMortgageDao.updateStatusAndRemark(housePropertyMortgage.getId(),housePropertyMortgage.getStatus(),housePropertyMortgage.getRemark());
					}
				}
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("超时修改状态失败！");
		}
		
	}

	/**
	 * 车辆抵押
	 */
	@Override
	public void updateVehicleMortgage() {
		List<VehicleMortgage> vehicleMortgageList = vehicleMortgageDao.findAllVehicleMortgage();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = sdf.format(new Date());
		long toDate;
		System.out.println("车贷");
		try {
			/** 获取当前时间戳 */
			toDate = sdf.parse(formatDate).getTime();
			for (VehicleMortgage vehicleMortgage : vehicleMortgageList) {
				if (vehicleMortgage.getAffirm_time() != null) {
					long fromDate = vehicleMortgage.getAffirm_time().getTime();
					//超时时间(天)
					int day = vehicleMortgage.getAffirm_date();
					/** 从确认时间到当前时间（天）大于自定义超时时间，资产评估通过（2），处于提交状态（1），则将进程状态设置为0 */
					if (((toDate - fromDate)/(1000 * 60 * 60 * 24)) > day && vehicleMortgage.getStatus() == 2
							&& vehicleMortgage.getType() == 1) {
						/** 设置状态为0（作废）*/
						vehicleMortgage.setStatus(0);
						/** 设置备注 */
						vehicleMortgage.setRemark("自定义超时");
						
						vehicleMortgageDao.updateStatusAndRemark(vehicleMortgage.getId(),vehicleMortgage.getStatus(),vehicleMortgage.getRemark());
					}
				}
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("超时修改状态失败！");
		}
		
	}

	
}
