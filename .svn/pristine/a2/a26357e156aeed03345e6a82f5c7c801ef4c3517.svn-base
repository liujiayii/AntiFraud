package com.antifraud.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.PostLoanManage;
import com.antifraud.entity.RecordManageSave;
import com.antifraud.entity.VehicleMortgage;
import com.antifraud.entityVO.HousePropertyMortgageVo;
import com.antifraud.entityVO.PostLoanManageVo;
//import com.antifraud.entityVO.RecordManageVo;
import com.antifraud.service.FiduciaryLoanService;
import com.antifraud.service.HousePropertyMortgageService;
import com.antifraud.service.PostLoanManageService;
import com.antifraud.service.VehicleMortgageService;
import com.antifraud.utils.JsonUtil;
import com.antifraud.utils.ResultInfo;

/**
 * 
 *
 * @ClassName: PostLoanManageController
 * 
 * @description 贷后管理表Controller层
 *
 * @author zhangkai
 * @createDate 2018年10月11日
 */
@Controller
@RequestMapping("PostLoanManage")
public class PostLoanManageController {
	@Resource
	private PostLoanManageService postLoanManageService;
	@Resource
	private HousePropertyMortgageService housePropertyMortgageService;
	@Resource
	private VehicleMortgageService vehicleMortgageService;
	@Resource
	private FiduciaryLoanService fiduciaryLoanService;

	/**
	 * 
	 *
	 * @Title: findHousePropertyByPhone
	 * 
	 * @description 主页通过电话查询房产报单申请表
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return Map<String,Object>
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月1日
	 */
	@RequestMapping(value = "findHousePropertyByPhone", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findHousePropertyByPhone(String phone, int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		PostLoanManageVo postLoanManageVo;
		int affirm_date;
		Date affirm_time;
		Date now_time;
		long time;
		long days;
		Integer is_overdue;

		int count = 0;
		int start;
		try {
			start = (page - 1) * limit;
			result = postLoanManageService.findHousePropertyByPhone(phone);
			count = housePropertyMortgageService.findByPhone(null, phone).size();

			if (result != null) {
				for (int i = 0; i < result.size(); i++) {
					String id = result.get(i).getEntry_number();
					postLoanManageVo = postLoanManageService.findPostLoanManageByRecordId(id);
					affirm_date = result.get(i).getAffirm_date();
					affirm_time = result.get(i).getAffirm_time();
					now_time = new Date();
					time = now_time.getTime() - affirm_time.getTime();
					days = time / (24 * 60 * 60 * 1000);
					if (days <= affirm_date) {
						is_overdue = 0;
					} else {
						is_overdue = 1;
					}

					if (postLoanManageVo == null) {
						result.get(i).setIs_overdue(is_overdue);
					} else {
						if (postLoanManageVo.getIs_overdue() == null) {
							result.get(i).setIs_overdue(is_overdue);
						} else {
							result.get(i).setIs_overdue(postLoanManageVo.getIs_overdue());
						}
					}

				}
				code = 1;
				msg = "查询成功";
				System.out.println("查询成功");
			} else {
				code = 1;
				msg = "查询无结果";
				System.out.println("查询无结果");
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
			System.out.println("查询失败");
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
	 * @return Map<String,Object>
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月8日
	 */
	@RequestMapping(value = "findVehicleByPhone", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findVehicleByPhone(String phone, int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		PostLoanManageVo postLoanManageVo;
		int affirm_date;
		Date affirm_time;
		Date now_time;
		long time;
		long days;
		int is_overdue;
		int count = 0;
		int start;
		try {
			start = (page - 1) * limit;
			result = postLoanManageService.findHousePropertyByPhone(phone);
			count = postLoanManageService.findVehicleByPhone(phone).size();
			if (result != null) {
				for (int i = 0; i < result.size(); i++) {
					String id = result.get(i).getEntry_number();
					postLoanManageVo = postLoanManageService.findPostLoanManageByRecordId(id);
					affirm_date = result.get(i).getAffirm_date();
					affirm_time = result.get(i).getAffirm_time();
					now_time = new Date();
					time = now_time.getTime() - affirm_time.getTime();
					days = time / (24 * 60 * 60 * 1000);
					if (days <= affirm_date) {
						is_overdue = 0;
					} else {
						is_overdue = 1;
					}

					if (postLoanManageVo == null) {
						result.get(i).setIs_overdue(is_overdue);
					} else {
						if (postLoanManageVo.getIs_overdue() == null) {
							result.get(i).setIs_overdue(is_overdue);
						} else {
							result.get(i).setIs_overdue(postLoanManageVo.getIs_overdue());
						}
					}
				}
				code = 1;
				msg = "查询成功";
				System.out.println("查询成功");
			} else {
				code = 1;
				msg = "查询无结果";
				System.out.println("查询无结果");
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
			System.out.println("查询失败");
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
	 * @return Map<String,Object>
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月8日
	 */
	@RequestMapping(value = "findFiduciaryByPhone", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findFiduciaryByPhone(String phone, int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		PostLoanManageVo postLoanManageVo;
		int affirm_date;
		Date affirm_time;
		Date now_time;
		long time;
		long days;
		int is_overdue;
		int count = 0;
		int start;
		try {
			start = (page - 1) * limit;
			result = postLoanManageService.findFiduciaryByPhone(phone);
			count = fiduciaryLoanService.findByPhone(null, phone).size();
			if (result != null) {
				for (int i = 0; i < result.size(); i++) {
					String id = result.get(i).getEntry_number();
					postLoanManageVo = postLoanManageService.findPostLoanManageByRecordId(id);
					affirm_date = result.get(i).getAffirm_date();
					affirm_time = result.get(i).getAffirm_time();
					now_time = new Date();
					time = now_time.getTime() - affirm_time.getTime();
					days = time / (24 * 60 * 60 * 1000);
					if (days <= affirm_date) {
						is_overdue = 0;
					} else {
						is_overdue = 1;
					}

					if (postLoanManageVo == null) {
						result.get(i).setIs_overdue(is_overdue);
					} else {
						if (postLoanManageVo.getIs_overdue() == null) {
							result.get(i).setIs_overdue(is_overdue);
						} else {
							result.get(i).setIs_overdue(postLoanManageVo.getIs_overdue());
						}
					}
				}
				code = 1;
				msg = "查询成功";
				System.out.println("查询成功");
			} else {
				code = 1;
				msg = "查询无结果";
				System.out.println("查询无结果");
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
			System.out.println("查询失败");
		}

		return JsonUtil.getResponseJson(code, msg, count, result);
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
	 * @return Map<String,Object>
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月8日
	 */
	@RequestMapping(value = "findAllHouseProperty", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findAllHouseProperty(int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		PostLoanManageVo postLoanManageVo;
		int affirm_date;
		Date affirm_time = null;
		Date now_time;
		long time;
		long days;
		int is_overdue;
		int count = 0;
		int start;
		try {
			start = (page - 1) * limit;
			result = postLoanManageService.findAllFiduciary();
			count = housePropertyMortgageService.findAll().size();

			if (result != null) {
				for (int i = 0; i < result.size(); i++) {
					String id = result.get(i).getEntry_number();
					postLoanManageVo = postLoanManageService.findPostLoanManageByRecordId(id);
					affirm_time = result.get(i).getAffirm_time();
					affirm_date = result.get(i).getAffirm_date();
					now_time = new Date();
					time = now_time.getTime() - affirm_time.getTime();
					days = time / (24 * 60 * 60 * 1000);
					if (days <= affirm_date) {
						is_overdue = 0;
					} else {
						is_overdue = 1;
					}

					if (postLoanManageVo == null) {
						result.get(i).setIs_overdue(is_overdue);
					} else {
						if (postLoanManageVo.getIs_overdue() == null) {
							result.get(i).setIs_overdue(is_overdue);
						} else {
							result.get(i).setIs_overdue(postLoanManageVo.getIs_overdue());
						}
					}
				}
				code = 1;
				msg = "查询成功";
				System.out.println("查询成功");
			} else {
				code = 1;
				msg = "查询无结果";
				System.out.println("查询无结果");
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
			System.out.println("查询失败");
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
	 * @return Map<String,Object>
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月8日
	 */
	@RequestMapping(value = "findAllVehicle", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findAllVehicle(int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		PostLoanManageVo postLoanManageVo;
		int affirm_date;
		Date affirm_time;
		Date now_time;
		long time;
		long days;
		int is_overdue;
		int count = 0;
		int start;
		try {
			start = (page - 1) * limit;
			result = postLoanManageService.findAllFiduciary();
			count = vehicleMortgageService.findAllVehicleMortgage().size();
			if (result != null) {
				for (int i = 0; i < result.size(); i++) {
					String id = result.get(i).getEntry_number();
					postLoanManageVo = postLoanManageService.findPostLoanManageByRecordId(id);
					affirm_date = result.get(i).getAffirm_date();
					affirm_time = result.get(i).getAffirm_time();
					now_time = new Date();
					time = now_time.getTime() - affirm_time.getTime();
					days = time / (24 * 60 * 60 * 1000);
					if (days <= affirm_date) {
						is_overdue = 0;
					} else {
						is_overdue = 1;
					}

					if (postLoanManageVo == null) {
						result.get(i).setIs_overdue(is_overdue);
					} else {
						if (postLoanManageVo.getIs_overdue() == null) {
							result.get(i).setIs_overdue(is_overdue);
						} else {
							result.get(i).setIs_overdue(postLoanManageVo.getIs_overdue());
						}
					}
				}
				code = 1;
				msg = "查询成功";
				System.out.println("查询成功");
			} else {
				code = 1;
				msg = "查询无结果";
				System.out.println("查询无结果");
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
			System.out.println("查询失败");
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
	 * @return Map<String,Object>
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月8日
	 */
	@RequestMapping(value = "findAllFiduciary", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findAllFiduciary(int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		PostLoanManageVo postLoanManageVo;
		int affirm_date;
		Date affirm_time;
		Date now_time;
		long time;
		long days;
		int is_overdue;
		int count = 0;
		int start;
		try {
			start = (page - 1) * limit;
			result = postLoanManageService.findAllFiduciary();
			count = fiduciaryLoanService.findAll().size();
			if (result != null) {
				for (int i = 0; i < result.size(); i++) {
					String id = result.get(i).getEntry_number();
					postLoanManageVo = postLoanManageService.findPostLoanManageByRecordId(id);
					affirm_date = result.get(i).getAffirm_date();
					affirm_time = result.get(i).getAffirm_time();
					now_time = new Date();
					time = now_time.getTime() - affirm_time.getTime();
					days = time / (24 * 60 * 60 * 1000);
					if (days <= affirm_date) {
						is_overdue = 0;
					} else {
						is_overdue = 1;
					}

					if (postLoanManageVo == null) {
						result.get(i).setIs_overdue(is_overdue);
					} else {
						if (postLoanManageVo.getIs_overdue() == null) {
							result.get(i).setIs_overdue(is_overdue);
						} else {
							result.get(i).setIs_overdue(postLoanManageVo.getIs_overdue());
						}
					}
				}
				code = 1;
				msg = "查询成功";
				System.out.println("查询成功");
			} else {
				code = 1;
				msg = "查询无结果";
				System.out.println("查询无结果");
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
			System.out.println("查询失败");
		}

		return JsonUtil.getResponseJson(code, msg, count, result);
	}

	/**
	 * 
	 *
	 * @Title: findPostLoanManageByRecordId
	 * 
	 * @description 详情页通过报单编号查询
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return Map<String,Object>
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月8日
	 */
	@RequestMapping(value = "findPostLoanManageByRecordId")
	@ResponseBody
	public String findPostLoanManageByRecordId(String id) {

		int code;
		String msg;
		PostLoanManageVo result = null;
		HousePropertyMortgage housePropertyMortgage;
		VehicleMortgage vehicleMortgage;
		FiduciaryLoan fiduciaryLoan;
		
		try {
			result = postLoanManageService.findPostLoanManageByRecordId(id);
			if (result != null) {
				
				housePropertyMortgage = housePropertyMortgageService.findByEntryNumber(id);
				vehicleMortgage = vehicleMortgageService.findByEntryNumber(id);
				fiduciaryLoan = fiduciaryLoanService.findByEntryNumber(id);
				
				if (housePropertyMortgageService != null) {
					result.setStatus(housePropertyMortgage.getStatus());
				} else if (vehicleMortgage != null) {
					result.setStatus(vehicleMortgage.getStatus());
				} else if (fiduciaryLoan != null) {
					result.setStatus(fiduciaryLoan.getStatus());
				}
				code = 1;
				msg = "查询成功";
				System.out.println("查询成功");
			} else {
				code = 1;
				msg = "查询无结果";
				System.out.println("查询无结果");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			code = -1;
			msg = "查询失败";
			System.out.println("查询失败");
		}

		return JsonUtil.getResponseJson(code, msg, null, result);

	}

	/**
	 * 
	 *
	 * @Title: addAndUpdatePostLoanManage
	 * 
	 * @description 详情页增加或修改数据
	 *
	 * @param @param
	 *            postLoanManage 贷后管理
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月8日
	 */

	@RequestMapping(value = "addAndUpdatePostLoanManage")
	@ResponseBody
	public String addAndUpdatePostLoanManage(PostLoanManage postLoanManage) {

		int code;
		String msg;		
		String id;
		try {
			id = postLoanManage.getReport_id();
			PostLoanManageVo rows = postLoanManageService.findPostLoanManageByRecordId(id);
			if (rows == null) {
				 postLoanManageService.addPostLoanManage(postLoanManage);
				code = 1;
				msg = "successfully!";
				System.out.println("增加成功");
			} else {
				 postLoanManageService.updatePostLoanManage(postLoanManage);
				code = 1;
				msg = "successfully!";
				System.out.println("修改成功");
			}
			postLoanManageService.updateHousePropertyStatus(id);
			postLoanManageService.updateVehicleStatus(id);
			postLoanManageService.updateFiduciaryStatus(id);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "error!";
			System.out.println("操作失败");
		}
		return JsonUtil.getResponseJson(code, msg, null, null);
	}

}
