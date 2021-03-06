package com.antifraud.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.antifraud.dao.ReplenishProcedureDao;
import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.PostLoanManage;
import com.antifraud.entity.ReplenishProcedure;
import com.antifraud.entity.ReplenishProcedureImage;
import com.antifraud.entity.VehicleMortgage;
import com.antifraud.entityVO.HousePropertyMortgageVo;
import com.antifraud.entityVO.PostLoanManageVo;
import com.antifraud.entityVO.ReplenishProcedureVo;
import com.antifraud.service.FiduciaryLoanService;
import com.antifraud.service.HousePropertyMortgageService;
import com.antifraud.service.PostLoanManageService;
import com.antifraud.service.ReplenishProcedureImageService;
import com.antifraud.service.SpotRecordService;
import com.antifraud.service.VehicleMortgageService;
import com.antifraud.service.impl.ReplenishProcedureImageServiceImpl;
import com.antifraud.utils.JsonUtil;
import com.antifraud.utils.UpdateFile;

/**
 * 
 *
 * @ClassName: ReplenishProcedureImageController
 * 
 * @description 补充手续图片表Controller层
 *
 * @author zhangkai
 * @createDate 2018年10月29日
 */
@Controller
@RequestMapping("ReplenishProcedureImage")
public class ReplenishProcedureImageController {
	@Resource
	private ReplenishProcedureImageService replenishProcedureImageService;
	@Resource
	private HousePropertyMortgageService housePropertyMortgageService;
	@Resource
	private VehicleMortgageService vehicleMortgageService;
	@Resource
	private FiduciaryLoanService fiduciaryLoanService;
	@Resource
	private PostLoanManageService postLoanManageService;
	@Autowired
	private SpotRecordService spotRecordService;

	/**
	 * 
	 *
	 * @Title: filesUpload
	 * 
	 * @description 详情页多文件上传
	 *
	 * @param @param
	 *            files
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年10月29日
	 */
	@RequestMapping("filesUpload")
	@ResponseBody
	public String filesUpload(String id, HttpServletRequest request) {

		int code;
		String msg;
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			List<MultipartFile> files = multipartRequest.getFiles("file");
			if (files != null) {
				for (int i = 0; i < files.size(); i++) {
					MultipartFile file = files.get(i);
					replenishProcedureImageService.saveFile(file, id);
				}
				code = 1;
				msg = "上传成功";
			} else {
				code = 1;
				msg = "图片不存在";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "上传失败";
		}

		return JsonUtil.getResponseJson(code, msg, null, null);

	}

	/**
	 * 
	 *
	 * @Title: findAllHouseProperty
	 * 
	 * @description 主页列表查询房产报单申请表
	 *
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月14日
	 */
	@RequestMapping(value = "findAllHouseProperty", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findAllHouseProperty(int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		int count = 0;
		int start;
		try {
			start = (page - 1) * limit;
			result = replenishProcedureImageService.findAllHouseProperty(start, limit);
			count = postLoanManageService.findAllHouseProperty().size();
			if (result != null) {
				code = 1;
				msg = "查询成功";
			} else {
				code = 1;
				msg = "查询无结果";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}

		return JsonUtil.getResponseJson(code, msg, count, result);
	}

	/**
	 * 
	 *
	 * @Title: findAllVehicle
	 * 
	 * @description 主页列表查询车辆报单申请表
	 *
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月14日
	 */
	@RequestMapping(value = "findAllVehicle", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findAllVehicle(int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		int count = 0;
		int start;
		try {
			start = (page - 1) * limit;
			result = replenishProcedureImageService.findAllVehicle(start, limit);
			count = postLoanManageService.findAllVehicle().size();
			if (result != null) {
				code = 1;
				msg = "查询成功";
			} else {
				code = 1;
				msg = "查询无结果";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}

		return JsonUtil.getResponseJson(code, msg, count, result);
	}

	/**
	 * 
	 *
	 * @Title: findAllFiduciary
	 * 
	 * @description 主页列表查询信用报单申请表
	 *
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月14日
	 */
	@RequestMapping(value = "findAllFiduciary", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findAllFiduciary(int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		int count = 0;
		int start;
		try {
			start = (page - 1) * limit;
			result = replenishProcedureImageService.findAllFiduciary(start, limit);
			count = postLoanManageService.findAllFiduciary().size();
			if (result != null) {
				code = 1;
				msg = "查询成功";
			} else {
				code = 1;
				msg = "查询无结果";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}

		return JsonUtil.getResponseJson(code, msg, count, result);
	}

	/**
	 * 
	 *
	 * @Title: findHousePropertyByPhone
	 * 
	 * @description 主页通过电话查询房产报单申请表
	 *
	 * @param @param
	 *            phone
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月14日
	 */
	@RequestMapping(value = "findHousePropertyByPhone", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findHousePropertyByPhone(String phone, int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		int count = 0;
		int start;
		try {
			start = (page - 1) * limit;
			result = replenishProcedureImageService.findHousePropertyByPhone(phone, start, limit);
			count = postLoanManageService.findHousePropertyByPhone(phone).size();
			if (result != null) {
				code = 1;
				msg = "查询成功";
			} else {
				code = 1;
				msg = "查询无结果";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}

		return JsonUtil.getResponseJson(code, msg, count, result);
	}

	/**
	 * 
	 *
	 * @Title: findVehicleByPhone
	 * 
	 * @description 主页通过电话查询车辆报单申请表
	 *
	 * @param @param
	 *            phone
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月14日
	 */
	@RequestMapping(value = "findVehicleByPhone", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findVehicleByPhone(String phone, int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		int count = 0;
		int start;
		try {
			start = (page - 1) * limit;
			result = replenishProcedureImageService.findVehicleByPhone(phone, start, limit);
			count = postLoanManageService.findVehicleByPhone(phone).size();
			if (result != null) {
				code = 1;
				msg = "查询成功";
			} else {
				code = 1;
				msg = "查询无结果";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}

		return JsonUtil.getResponseJson(code, msg, count, result);
	}

	/**
	 * 
	 *
	 * @Title: findFiduciaryByPhone
	 * 
	 * @description 主页通过电话查询信用报单申请表
	 *
	 * @param @param
	 *            phone
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月14日
	 */
	@RequestMapping(value = "findFiduciaryByPhone", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findFiduciaryByPhone(String phone, int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		int count = 0;
		int start;
		try {
			start = (page - 1) * limit;
			result = replenishProcedureImageService.findFiduciaryByPhone(phone, start, limit);
			count = postLoanManageService.findFiduciaryByPhone(phone).size();
			if (result != null) {
				code = 1;
				msg = "查询成功";
			} else {
				code = 1;
				msg = "查询无结果";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}

		return JsonUtil.getResponseJson(code, msg, count, result);
	}

	/**
	 * 
	 *
	 * @Title: addAndUpdateReplenishProcedure
	 * 
	 * @description 通过报单编号增加或修改借款人业务信息表与贷款人职业信息
	 *
	 * @param @param
	 *            replenishProcedureVo
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月23日
	 */
	@RequestMapping(value = "/addAndUpdateReplenishProcedure", method = RequestMethod.POST)
	@ResponseBody
	public String addAndUpdateReplenishProcedure(@RequestBody ReplenishProcedureVo replenishProcedureVo,HttpServletRequest request, HttpServletResponse resp) {
		String id;
		int code;
		String msg;
		ReplenishProcedureVo row;
		String occupational;
		String industry_of_the_company;
		boolean belong_to_oneself = true;
		String belong_to_oneself_for_webpage;
		boolean whether_the_loan =true;
		String whether_the_loan_for_webpage;
		String talk_place;
		String Interview_place;

		try {
			
			
			//将从前端传的String类型字段的值传给boolean类型字段
			belong_to_oneself_for_webpage= replenishProcedureVo.getBelong_to_oneself_for_webpage();
			if(belong_to_oneself_for_webpage.equals("1")){
				belong_to_oneself=true;
			}else if(belong_to_oneself_for_webpage.equals("0")){
				belong_to_oneself=false;
			}
			replenishProcedureVo.setBelong_to_oneself(belong_to_oneself);


			
			//将从前端传的String类型字段的值传给boolean类型字段
			whether_the_loan_for_webpage=replenishProcedureVo.getWhether_the_loan_for_webpage();
			if(whether_the_loan_for_webpage.equals("1")){
				whether_the_loan=true;
			}else if(whether_the_loan_for_webpage.equals("0")){
				whether_the_loan=false;
			}
			replenishProcedureVo.setWhether_the_loan(whether_the_loan);
		
			
			
			//将从前端传的talk_place的值传给Interview_place
			talk_place=replenishProcedureVo.getTalk_place();
			replenishProcedureVo.setInterview_place(talk_place);
			
			
			
			occupational = replenishProcedureVo.getOccupational();
			if (occupational == "0") {
				replenishProcedureVo.setOccupational("国家机关、企业、事业单位");
			} else if (occupational == "1") {
				replenishProcedureVo.setOccupational("专业技术人员");
			} else if (occupational == "3") {
				replenishProcedureVo.setOccupational("办事人员和有关人员");
			} else if (occupational == "4") {
				replenishProcedureVo.setOccupational("商业、服务业人员");
			} else if (occupational == "5") {
				replenishProcedureVo.setOccupational("农、林、牧、渔、水利业");
			} else if (occupational == "6") {
				replenishProcedureVo.setOccupational("生产、运输设备操作人员");
			} else if (occupational == "x") {
				replenishProcedureVo.setOccupational("军人");
			} else if (occupational == "y") {
				replenishProcedureVo.setOccupational("其他从业人员");
			} else if (occupational == "其他") {
				replenishProcedureVo.setOccupational("未知");
			}


			
			
			industry_of_the_company = replenishProcedureVo.getIndustry_of_the_company();
			if (industry_of_the_company == "A") {
				replenishProcedureVo.setIndustry_of_the_company("农、林、牧、渔业");
			} else if (industry_of_the_company == "B") {
				replenishProcedureVo.setIndustry_of_the_company("采掘业");
			} else if (industry_of_the_company == "C") {
				replenishProcedureVo.setIndustry_of_the_company("制造业");
			} else if (industry_of_the_company == "D") {
				replenishProcedureVo.setIndustry_of_the_company("电力、燃气及水的生产和供应业");
			} else if (industry_of_the_company == "E") {
				replenishProcedureVo.setIndustry_of_the_company("建筑业");
			} else if (industry_of_the_company == "F") {
				replenishProcedureVo.setIndustry_of_the_company("交通运输、仓储和邮政业");
			} else if (industry_of_the_company == "G") {
				replenishProcedureVo.setIndustry_of_the_company("信息传输、计算机服务和软件业");
			} else if (industry_of_the_company == "H") {
				replenishProcedureVo.setIndustry_of_the_company("批发和零售业");
			} else if (industry_of_the_company == "I") {
				replenishProcedureVo.setIndustry_of_the_company("住宿和餐饮业");
			} else if (industry_of_the_company == "J") {
				replenishProcedureVo.setIndustry_of_the_company("金融业");
			} else if (industry_of_the_company == "K") {
				replenishProcedureVo.setIndustry_of_the_company("房地产业");
			} else if (industry_of_the_company == "L") {
				replenishProcedureVo.setIndustry_of_the_company("租赁和商务服务业");
			} else if (industry_of_the_company == "M") {
				replenishProcedureVo.setIndustry_of_the_company("科学研究、技术服务业和地质勘察业");
			} else if (industry_of_the_company == "N") {
				replenishProcedureVo.setIndustry_of_the_company("水利、环境和公共设施管理业");
			} else if (industry_of_the_company == "O") {
				replenishProcedureVo.setIndustry_of_the_company("居民服务和其他服务业");
			} else if (industry_of_the_company == "P") {
				replenishProcedureVo.setIndustry_of_the_company("教育");
			} else if (industry_of_the_company == "Q") {
				replenishProcedureVo.setIndustry_of_the_company("卫生、社会保障和社会福利业");
			} else if (industry_of_the_company == "R") {
				replenishProcedureVo.setIndustry_of_the_company("文化、体育和娱乐业");
			} else if (industry_of_the_company == "S") {
				replenishProcedureVo.setIndustry_of_the_company("公共管理和社会组织");
			} else if (industry_of_the_company == "T") {
				replenishProcedureVo.setIndustry_of_the_company("国际组织");
			} else if (industry_of_the_company == "Z") {
				replenishProcedureVo.setIndustry_of_the_company("未知");
			}

			
			//修改房贷申请表，车辆申请表，信用申请表几个字段
			replenishProcedureImageService.updateHouseProperty(replenishProcedureVo);
			replenishProcedureImageService.updateVehicle(replenishProcedureVo);
			replenishProcedureImageService.updateFiduciary(replenishProcedureVo);
			
			
			//增加或修改补充手续图片表数据
			id = replenishProcedureVo.getEntry_number();
			row = replenishProcedureImageService.findReplenishProcedureByEntry_number(id);
			System.out.println("id"+id);
			System.out.println("row"+row);
			if (row == null) {
				replenishProcedureImageService.addReplenishProcedureToBusiness_massage(replenishProcedureVo);
				replenishProcedureImageService.addReplenishProcedureToOccupational_information(replenishProcedureVo);
				code = 1;
				msg = "successfully!";
				  postLoanManageService.updateHousePropertyStatus(id);
				  postLoanManageService.updateVehicleStatus(id);
				  postLoanManageService.updateFiduciaryStatus(id);
			} else {
				replenishProcedureImageService.updateReplenishProcedureToBusiness_massage(replenishProcedureVo);
				replenishProcedureImageService.updateReplenishProcedureToOccupational_information(replenishProcedureVo);

				code = 1;
				msg = "successfully!";
				spotRecordService.judgementResult(id, 6, null);
			}
			
			
			
			//修改房贷申请表，车辆申请表，信用申请表的状态字段
			
			
			 
			
			
								
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "error!";
		}
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	
	/**
	 * 
	 *
	 * @Title: findReplenishProcedureByEntry_number
	 * 
	 * @description 通过报单编号查询补充手续表
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月23日
	 */
	@RequestMapping(value = "findReplenishProcedureByEntry_number", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findReplenishProcedureByEntry_number(String id) throws Exception {

		int code;
		String msg;
		ReplenishProcedureVo result = null;
		String purpose_of_loan;
		BigDecimal approval_limit;
		String approval_deadline;
		HousePropertyMortgage housePropertyMortgagehouse;
		VehicleMortgage vehicleMortgage;
		FiduciaryLoan fiduciaryLoan;
		boolean belong_to_oneself;
		String belong_to_oneself_for_webpage = null;
		boolean whether_the_loan;
		String whether_the_loan_for_webpage = null;
		String Interview_place;
		String talk_place;
		int payment_type;
		
		try {
			result = replenishProcedureImageService.findReplenishProcedureByEntry_number(id);
						
			if (result != null) {

				
				//将查询出来的boolean类型字段的值传给String类型字段
				belong_to_oneself=result.isBelong_to_oneself();
				if(belong_to_oneself==true){
					belong_to_oneself_for_webpage="1";
				}else if(belong_to_oneself==false){
					belong_to_oneself_for_webpage="0";
				}
				result.setBelong_to_oneself_for_webpage(belong_to_oneself_for_webpage);
				
				
				//将查询出来的boolean类型字段的值传给String类型字段
				whether_the_loan=result.isWhether_the_loan();
				if(whether_the_loan==true){
					whether_the_loan_for_webpage="1";
				}else if(whether_the_loan==false){
					whether_the_loan_for_webpage="0";
				}
				result.setWhether_the_loan_for_webpage(whether_the_loan_for_webpage);
				
					
				//将查出来的Interview_place的值传给talk_place
				Interview_place=result.getInterview_place();
				result.setTalk_place(Interview_place);
				
				
				//查询房贷申请表，车辆贷款申请表，信用贷款申请表的几个字段
				housePropertyMortgagehouse = housePropertyMortgageService.findByEntryNumber(id);
				vehicleMortgage = vehicleMortgageService.findByEntryNumber(id);
				fiduciaryLoan = fiduciaryLoanService.findByEntryNumber(id);
								
				if (housePropertyMortgagehouse != null) {

					purpose_of_loan = housePropertyMortgagehouse.getPurpose_of_loan();
					approval_limit = housePropertyMortgagehouse.getApproval_limit();
					approval_deadline = housePropertyMortgagehouse.getApproval_deadline();
					payment_type=housePropertyMortgagehouse.getPayment_type();
					result.setPurpose_of_loan(purpose_of_loan);
					result.setApproval_deadline(approval_deadline);
					result.setApproval_limit(approval_limit);
					result.setPayment_type(payment_type);
				} else if (vehicleMortgage != null) {

					purpose_of_loan = vehicleMortgage.getPurpose_of_loan();
					approval_limit = vehicleMortgage.getApply_for_limit();
					approval_deadline = vehicleMortgage.getApproval_deadline();
					payment_type=vehicleMortgage.getPayment_type();
					result.setPurpose_of_loan(purpose_of_loan);
					result.setApproval_deadline(approval_deadline);
					result.setApproval_limit(approval_limit);
					result.setPayment_type(payment_type);

				} else if (fiduciaryLoan != null) {

					purpose_of_loan = fiduciaryLoan.getPurpose_of_loan();
					approval_limit = fiduciaryLoan.getApproval_limit();
					approval_deadline = fiduciaryLoan.getApproval_deadline();
					payment_type=fiduciaryLoan.getPayment_type();
					result.setPurpose_of_loan(purpose_of_loan);
					result.setApproval_deadline(approval_deadline);
					result.setApproval_limit(approval_limit);
                    result.setPayment_type(payment_type);
				}
				
				
							
				code = 1;
				msg = "查询成功";
			} else {
				code = 1;
				msg = "查询无结果";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}

		return JsonUtil.getResponseJson(code, msg, null, result);
	}

	@RequestMapping(value="findHousesd", produces = "application/json;charset=utf-8")
	@ResponseBody
	public  String findHousesd(int page, int limit){
	
	
		int code;
		
		String msg;
		List<HousePropertyMortgage> list = null;
		int start = (page - 1) * limit;
		try {
			
			list= replenishProcedureImageService.findHousesd(start, limit);
			 
			if (list != null) {
				code = 1;
				msg = "查询成功";
			} else {
				code = 1;
				msg = "查询无结果";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}
		return JsonUtil.getResponseJson(code, msg, replenishProcedureImageService.findHousesdcount(), list);
	}
	@RequestMapping (value="findVehiclesd", produces = "application/json;charset=utf-8")
	@ResponseBody
	public  String findVehiclesd(int page, int limit){
	
	
		int code;
		int count = 0;
		String msg;
		List<VehicleMortgage> list = null;
		int start = (page - 1) * limit;
		
		try {
			
			list= replenishProcedureImageService.findVehiclesd(start, limit);
			
			if (list != null) {
				code = 1;
				msg = "查询成功";
			} else {
				code = 1;
				msg = "查询无结果";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}
	
		return JsonUtil.getResponseJson(code, msg, replenishProcedureImageService.findVehiclesdcount(), list);
	}
	@RequestMapping(value="findFiduciarysd", produces = "application/json;charset=utf-8")
	@ResponseBody
	public  String findFiduciarysd(int page, int limit){
	
	
		int code;
		int count = 0;
		String msg;
		List<FiduciaryLoan> list = null;
		int start = (page - 1) * limit;
		try {
			
			list= replenishProcedureImageService.findFiduciarysd(start, limit);
		
			if (list != null) {
				code = 1;
				msg = "查询成功";
			} else {
				code = 1;
				msg = "查询无结果";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
		}
		return JsonUtil.getResponseJson(code, msg, replenishProcedureImageService.findFiduciarysdcount(), list);
	}
}
