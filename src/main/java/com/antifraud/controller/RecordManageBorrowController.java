package com.antifraud.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.RecordManageBorrow;
import com.antifraud.entity.RecordManageSave;
import com.antifraud.entity.User;
import com.antifraud.entity.VehicleMortgage;
import com.antifraud.entityVO.RecordManagerSaveVo;
import com.antifraud.service.FiduciaryLoanService;
import com.antifraud.service.HousePropertyMortgageService;
import com.antifraud.service.RecordManageBorrowService;
import com.antifraud.service.RecordManageSaveService;
import com.antifraud.service.VehicleMortgageService;
import com.antifraud.utils.JsonUtil;

/**
 * 
 *
 * @ClassName: RecordManageBorrowController

 * @description 借阅管理表
 *
 * @author zhangkai
 * @createDate 2018年10月9日
 */
@Controller
@RequestMapping("/RecordManageBorrow")
public class RecordManageBorrowController {
	private static Logger logger = Logger.getLogger(RecordManageBorrowController.class);
	int code = 1;
	String msg = "成功";
	/** 借表 */
	@Autowired
	RecordManageBorrowService recordManageBorrowService;
	/** 存表 */
	@Autowired
    RecordManageSaveService recordManageSaveService;
	/** 信用借贷 */
	@Autowired
	private FiduciaryLoanService fiduciaryLoanService;
	/** 房产抵押 */
	@Autowired
	private HousePropertyMortgageService housePropertyMortgageService;
	/** 车辆抵押 */
	@Autowired
	private VehicleMortgageService vehicleMortgageService;
	
	/**
	 * 通过id查询
	 *
	 * @Title: findRecordById
	
	 * @description 
	 *
	 * @param id 报单id
	 * @param @return 
	   
	 * @return String    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月12日-下午5:09:29
	 */
	@RequestMapping(value="/findRecordById",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findRecordById(Long id){
		RecordManageBorrow recordManageBorrow = null;
		try {
			recordManageBorrow = recordManageBorrowService.findRecordById(id);
			if (recordManageBorrow != null) {
				msg = "查询成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("系统异常");
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, recordManageBorrow);
	}	
	
	/**
	 * 通过报单编号查询借表最后一条数据
	 *
	 * @Title: getRecordLastByReportId
	
	 * @description 
	 *
	 * @param report_id 报单编号
	 * @param @return 
	   
	 * @return String    
	
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月13日-下午6:06:03
	 */
	@RequestMapping(value="getRecordLastByReportId",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getRecordLastByReportId (String report_id) {
		RecordManageBorrow recordManageBorrow = null;
		try {
			recordManageBorrow = recordManageBorrowService.getRecordLastByReportId(report_id);
			if (recordManageBorrow != null) {
				msg = "成功";
			}
		} catch(Exception e){
			e.printStackTrace();
			logger.error("系统异常");
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, recordManageBorrow);
	}
	
	/**
	 * 查询借阅档案信息列表
	 *
	 * @Title: findRecordBorrowList
	
	 * @description 
	 *
	 * @param page 当前页
	 * @param limit 每页显示条数
	 * @param @return 
	   
	 * @return String    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月23日-下午2:29:16
	 */
	@RequestMapping(value="findRecordBorrowList",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findRecordBorrowList (Integer page, Integer limit) {
		if (page == null || page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		/** 查询借阅信息表 */
		List<RecordManagerSaveVo> recordManageSaveVoList = null;
		
		try {
			recordManageSaveVoList = recordManageSaveService.findByLimit(page, limit);
			if (recordManageSaveVoList.size() < 0) {
				msg = "无数据";
			}
			for (RecordManagerSaveVo recordManageSaveVo : recordManageSaveVoList) {
				/** 通过报单编号查询信贷信息 */
				FiduciaryLoan fiduciaryLoan = fiduciaryLoanService.findByEntryNumber(recordManageSaveVo.getReport_id());
				/** 通过报单编号查询房产抵押信息 */
				HousePropertyMortgage housePropertyMortgage = housePropertyMortgageService.findByEntryNumber(recordManageSaveVo.getReport_id());
				/** 通过报单编号查询车辆抵押信息 */
				VehicleMortgage vehicleMortgage = vehicleMortgageService.findByEntryNumber(recordManageSaveVo.getReport_id());
				
				if (fiduciaryLoan != null) {
					recordManageSaveService.addFields(recordManageSaveVo, fiduciaryLoan.getName(), fiduciaryLoan.getPhone(), fiduciaryLoan.getBusiness_type(), null);
				}
				if (housePropertyMortgage != null) {
					recordManageSaveService.addFields(recordManageSaveVo, housePropertyMortgage.getName(), housePropertyMortgage.getPhone(), housePropertyMortgage.getBusiness_type(), null);
				}
				if (vehicleMortgage != null) {
					recordManageSaveService.addFields(recordManageSaveVo, vehicleMortgage.getName(), vehicleMortgage.getPhone(), vehicleMortgage.getBusiness_type(), null);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("系统异常");
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, recordManageSaveService.getCount(), recordManageSaveVoList);
	}
	
	/**
	 * 查询档案借阅日志列表
	 *
	 * @Title: findRecordBorrow
	
	 * @description 
	 *
	 * @param report_id 报单编号
	 * @param page 当前页
	 * @param limit 每页显示条数
	 * @param @return 
	   
	 * @return String    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月23日-下午2:29:50
	 */
	@RequestMapping(value="findRecordBorrow",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findRecordBorrow (String report_id, Integer page, Integer limit) {
		int code = 1;
		String msg = "成功";
		if (page == null || page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		/** 查询同一报单档案所有借阅记录(分页) */
		List<RecordManageBorrow> recordManageBorrowList = null;
		try {
			recordManageBorrowList = recordManageBorrowService.findByLimit(report_id, page, limit);
			
			if (recordManageBorrowList == null) {
				msg = "无数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("系统异常");
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, recordManageBorrowService.getCount(report_id), recordManageBorrowList);
	}
	
	/**
	 * 添加档案借阅日志（在档案借出或归还时生成一条借阅日志）
	 *
	 * @Title: addRecordLogs
	 * @description 
	 *
	 * @param recordManageBorrow
	 * @param @return    
	 * @return String    
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月30日-上午11:12:56
	 */
	@RequestMapping(value="addRecordBorrow", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addRecordBorrow (RecordManageBorrow recordManageBorrow, HttpSession session) {
		int code = 1;
		String msg = "成功";
		Date currDate = new Date();
		User user = (User)session.getAttribute("user");
		/** 通过报单编号查询存表数据 */
		RecordManageSave recordManageSave = recordManageSaveService.findByRecordId(recordManageBorrow.getReport_id());
		/** 通过报单编号查询借表中当前报单的最后一条数据 */
		RecordManageBorrow recordManageBorrowLast = recordManageBorrowService.getRecordLastByReportId(recordManageBorrow.getReport_id());
		/** 设置存表的修改时间 */
		recordManageSave.setModify_time(currDate);
		/** 设置存表的修改人 */
		recordManageSave.setModify_name(user.getName());
		
		/** 设置借表操作人 */
		recordManageBorrow.setCreate_name(user.getName());
		/** 如果状态为0，则为归还 ,否则为借出*/
		if (recordManageBorrow.getStatus() == 0) {
			/** 设置归还时间 */
			recordManageBorrow.setReturn_time(currDate);
			/** 设置存表的状态为归还状态 */
			recordManageSave.setStatus(0);
		} else if (recordManageBorrow.getStatus() == 1) {
			/** 设置借出时间 */
			recordManageBorrow.setRead_time(currDate);
			/** 设置存表的状态为借出状态 */
			recordManageSave.setStatus(1);
		}
		try {
			
			if (recordManageBorrowLast == null || recordManageBorrowLast.getStatus() != recordManageBorrow.getStatus()) {
				/** 修改存表信息 */
				recordManageSaveService.updateByReportId(recordManageSave);
				/** 添加借表信息 */
				recordManageBorrowService.addRecordBorrow(recordManageBorrow);
			} else {
				code = 0;
				msg = "无效的操作";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("系统异常");
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	
}










