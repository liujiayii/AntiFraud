package com.antifraud.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;

import com.antifraud.entity.RecordManageSave;
import com.antifraud.entity.VehicleMortgage;
import com.antifraud.entityVO.RecordManagerSaveVo;
import com.antifraud.service.FiduciaryLoanService;
import com.antifraud.service.HousePropertyMortgageService;
import com.antifraud.service.RecordManageBorrowService;
import com.antifraud.service.RecordManageSaveService;
import com.antifraud.service.VehicleMortgageService;
import com.antifraud.utils.JsonUtil;
import com.antifraud.utils.ResultInfo;

/**
 * 
 *
 * @ClassName: RecordManageSaveController

 * @description 档案管理表
 *
 * @author zhangkai
 * @createDate 2018年10月19日
 */
@Controller
@RequestMapping("RecordManageSave")
public class RecordManageSaveController {	
	private static Logger logger = Logger.getLogger(RecordManageSaveController.class);
	int code = 1;
	String msg = "";
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
	/** 档案借表 */
	@Autowired
	private RecordManageBorrowService recordManageBorrowService;
     
	/**
	 * 
	*
	 * @Title: removeRecord
	
	 * @description 消除档案
	*
	 * @param @param recordManageSave
	 * @param @return 
	   
	 * @return ResultInfo    
	
	 *
	 * @author zhangkai
	 * @createDate 2018年10月9日
	 */
	@RequestMapping(value="/removeRecord")
	@ResponseBody
	public ResultInfo removeRecord(RecordManageSave recordManageSave){
		
		ResultInfo result = new ResultInfo();
		try {
			
			int rows = recordManageSaveService.removeRecord(recordManageSave);
			if(rows>=1){
				result.code=0;
				result.msg="successfully!";
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.code=-1;
			result.msg="error!";
		}
		return result;
	}
	
		
/**
 * 
*
 * @Title: findAllRecord

 * @description 查询全部
*
 * @param @return 
   
 * @return List<RecordManageVo>    

 *
 * @author zhangkai
 * @createDate 2018年10月15日
 */
	@RequestMapping("/findAllRecord")
	@ResponseBody
	public List <RecordManageSave> findAllRecord(){
		List <RecordManageSave> rows= recordManageSaveService.findAllRecord();
		if(rows!=null){
		}
		return rows;
	}
	
	
/**
 * 
*
 * @Title: alterRecordById

 * @description 通过id修改
*
 * @param @param recordManageSave
 * @param @return 
   
 * @return ResultInfo    

 *
 * @author zhangkai
 * @createDate 2018年10月19日
 */
	@RequestMapping(value="/updateRecordById")
	@ResponseBody
	public String updateRecordById(RecordManageSave recordManageSave){
		/** 如果修改状态为消档，则添加修改时间 */
		if (recordManageSave.getStatus() == 2) {
			recordManageSave.setCencal_time(new Date());
		}
		/** 通过报单编号查询存表中数据 */
		RecordManageSave rms = recordManageSaveService.findByRecordId(recordManageSave.getReport_id());
		try {
			/** 判断前端页面是否有修改动作，如果没有则阻止修改操作 */
			if (rms.getStatus() == recordManageSave.getStatus() 
					& rms.getArchivet_location().equals(recordManageSave.getArchivet_location())) {
				
				return JsonUtil.getResponseJson(0, "请选择要修改的内容", null, null);
			}
			
			recordManageSaveService.alterRecordById(recordManageSave);
			
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常!";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
		
    /**
     * 通过报单编号查询(模糊查询)
     *
     * @Title: findRecordByRecordId
     * @description 
     *
     * @param report_id 报单编号
     * @param @return    
     * @return String    
     *
     * @author lujinpeng
     * @createDate 2018年11月5日-下午2:54:15
     */
	@RequestMapping(value="/findRecordByRecordId",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findRecordByRecordId(String report_id){
		int code = 1;
		String msg = "成功";
		/** 借阅人姓名 */
		String read_name = "";
		List<RecordManagerSaveVo> recordManageSaveVoList = null;
		if (recordManageBorrowService.getRecordLastByReportId(report_id) != null) {
			read_name = recordManageBorrowService.getRecordLastByReportId(report_id).getRead_name();
		} else {
			read_name = "";
		}
		try {
			recordManageSaveVoList = recordManageSaveService.findRecordByRecordId(report_id);
			for (RecordManagerSaveVo recordManageSaveVo : recordManageSaveVoList) {
				/** 通过报单编号查询信贷信息 */
				FiduciaryLoan fiduciaryLoan = fiduciaryLoanService.findByEntryNumber(recordManageSaveVo.getReport_id());
				/** 通过报单编号查询房产抵押信息 */
				HousePropertyMortgage housePropertyMortgage = housePropertyMortgageService
						.findByEntryNumber(recordManageSaveVo.getReport_id());
				/** 通过报单编号查询车辆抵押信息 */
				VehicleMortgage vehicleMortgage = vehicleMortgageService
						.findByEntryNumber(recordManageSaveVo.getReport_id());
				if (fiduciaryLoan != null) {
					recordManageSaveService.addFields(recordManageSaveVo, fiduciaryLoan.getName(), fiduciaryLoan.getPhone(),
							fiduciaryLoan.getBusiness_type(),read_name);
				}
				if (housePropertyMortgage != null) {
					recordManageSaveService.addFields(recordManageSaveVo, housePropertyMortgage.getName(),
							housePropertyMortgage.getPhone(), housePropertyMortgage.getBusiness_type()
							,read_name);
				}
				if (vehicleMortgage != null) {
					recordManageSaveService.addFields(recordManageSaveVo, vehicleMortgage.getName(),
							vehicleMortgage.getPhone(), vehicleMortgage.getBusiness_type()
							,read_name);
				} 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("系统异常");
			code = -1;
			msg = "系统异常";
		}
		if (recordManageSaveVoList.size() < 0) {
			msg = "无数据";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, recordManageSaveVoList);
	}
	
	/**
	 * 档案归档（插入档案信息）
	 *
	 * @Title: addRecord
	 * @description 
	 *
	 * @param @param recordManageSave
	 * @param @return    
	 * @return String    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月5日-下午1:56:16
	 */
	@RequestMapping(value="/addRecord")
	@ResponseBody
	public String addRecord(RecordManageSave recordManageSave){
		int code = 1;
		String msg = "成功";
		try {
			/** 设置档案状态 */
			recordManageSave.setStatus(0);
			/** 设置存档时间 */
			recordManageSave.setArchivet_time(new Date());
			/** 设置存档人 */
			recordManageSave.setCreate_name(null);
			
			recordManageSaveService.addRecord(recordManageSave);
		} catch (Exception e) {
			e.printStackTrace();
			code=-1;
			msg="系统异常!";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}	
	
	/**
	 * 查询所有存档档案信息
	 *
	 * @Title: findRecordSaveList
	
	 * @description 
	 *
	 * @param page 当前页
	 * @param limit 每页显示条数
	 * @param @return 
	   
	 * @return String    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月23日-下午2:42:44
	 */
	@RequestMapping(value="findRecordSaveList",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findRecordSaveList (Integer page, Integer limit) {
		int code = 1;
		String msg = "成功";
		if (page == null || page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
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
					recordManageSaveService.addFields(recordManageSaveVo, fiduciaryLoan.getName(), fiduciaryLoan.getPhone()
							, fiduciaryLoan.getBusiness_type(), null);
				}
				if (housePropertyMortgage != null) {
					recordManageSaveService.addFields(recordManageSaveVo, housePropertyMortgage.getName(), housePropertyMortgage.getPhone()
							, housePropertyMortgage.getBusiness_type(), null);
				}
				if (vehicleMortgage != null) {
					recordManageSaveService.addFields(recordManageSaveVo, vehicleMortgage.getName(), vehicleMortgage.getPhone()
							, vehicleMortgage.getBusiness_type(), null);
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
	
}
	























	
	
