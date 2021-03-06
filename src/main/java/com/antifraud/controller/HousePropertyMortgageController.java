package com.antifraud.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.User;
import com.antifraud.entity.VehicleMortgage;
import com.antifraud.entityVO.HousePropertyMortgageVo;
import com.antifraud.service.FiduciaryLoanService;
import com.antifraud.service.HousePropertyMortgageService;
import com.antifraud.service.PhotoService;
import com.antifraud.service.UserService;
import com.antifraud.service.VehicleMortgageService;
import com.antifraud.utils.DesUtil;
import com.antifraud.utils.JsonUtil;
import com.antifraud.utils.MD5Encrypt;
import com.antifraud.utils.ResultInfo;

import net.sf.jmimemagic.Magic;

/**
 * 
 * @ClassName: HousePropertyMortgageController
 * @description 房产抵押
 * @author 李凯
 * @createDate 2018年9月28日 上午10:21:22
 */
@Controller
@RequestMapping("/HousePropertyMortgage")
@Scope("prototype")
public class HousePropertyMortgageController {

	private Logger logger = Logger.getLogger(HousePropertyMortgageController.class);
	@Autowired
	private UserService userService;
	@Resource
	private HousePropertyMortgageService housePropertyMortgageService;
	@Resource
	private FiduciaryLoanService fiduciaryLoanService;
	@Resource
	private VehicleMortgageService vehicleMortgageService;
	@Resource
	private PhotoService photoService;
	int code = 1;
	String msg = "成功";

	/**
	 * 
	 * @Title: houseMoney
	 * @description 房贷车贷信贷总金额
	 * @param @return
	 * @return String
	 * @author caoyaru
	 * @createDate 2018年11月26日-下午4:53:31
	 */
	@ResponseBody
	@RequestMapping(value = "/totalMoney", produces = "application/json; charset=utf-8")
	public String totalMoney() {
		BigDecimal count = new BigDecimal(0.00);
		BigDecimal houseMoney = new BigDecimal(0.00);
		BigDecimal vehicleMoney = new BigDecimal(0.00);
		BigDecimal fiduciaryMoney = new BigDecimal(0.00);
		try {
			// 房贷金额
			houseMoney = housePropertyMortgageService.houseMoney();
			// 车贷金额
			vehicleMoney = vehicleMortgageService.vehicleMoney();
			// 信用金额
			fiduciaryMoney = fiduciaryLoanService.fiduciaryMoney();
			// 总金额
			if (houseMoney == null) {
				houseMoney = new BigDecimal(0.00);
			}
			if (vehicleMoney == null) {
				vehicleMoney = new BigDecimal(0.00);
			}
			if (fiduciaryMoney == null) {
				fiduciaryMoney = new BigDecimal(0.00);
			}
			count = houseMoney.add(vehicleMoney).add(fiduciaryMoney);
		} catch (Exception e) {
			code = -1;
			msg = "失败";
		}

		return JsonUtil.getResponseJson(code, msg, null, count);
	}

	/**
	 * 
	 * @Title: houseMoney
	 * @description 房贷金额
	 * @param @return
	 * @return String
	 * @author caoyaru
	 * @createDate 2018年11月26日-下午4:17:46
	 */
	@ResponseBody
	@RequestMapping(value = "/houseMoney", produces = "application/json; charset=utf-8")
	public String houseMoney() {
		BigDecimal houseMoney = new BigDecimal(0.00);
		try {
			houseMoney = housePropertyMortgageService.houseMoney();
			if (houseMoney == null) {
				houseMoney = new BigDecimal(0.00);
			}
		} catch (Exception e) {
			code = -1;
			msg = "失败";
		}

		return JsonUtil.getResponseJson(code, msg, null, houseMoney);
	}

	/**
	 * 
	 * @Title: ordersTotal
	 * @description 房贷车贷信贷总数
	 * @param @return
	 * @return String
	 * @author caoyaru
	 * @createDate 2018年11月26日-下午4:15:41
	 */
	@ResponseBody
	@RequestMapping(value = "/ordersTotal", produces = "application/json; charset=utf-8")
	public String ordersTotal() {
		int count = 0;
		try {
			// 房贷总和
			int housePropertyMortgageCount = housePropertyMortgageService.fiduciaryCount();
			// 信贷总和
			int fiduciaryLoanCount = fiduciaryLoanService.fiduciaryCount();
			// 车贷总和
			int vehicleMortgageCount = vehicleMortgageService.fiduciaryCount();
			// 总数
			count = housePropertyMortgageCount + fiduciaryLoanCount + vehicleMortgageCount;

		} catch (Exception e) {
			code = -1;
			msg = "失败";
		}

		return JsonUtil.getResponseJson(code, msg, count, null);
	}

	/**
	 * 
	 * @Title: fiduciaryCount
	 * @description 统计房贷总数
	 * @param @return
	 * @return String
	 * @author caoyaru
	 * @createDate 2018年11月26日-上午10:04:08
	 */
	@ResponseBody
	@RequestMapping(value = "/fiduciaryCount", produces = "application/json; charset=utf-8")
	public String fiduciaryCount() {
		int count = 0;

		try {
			count = housePropertyMortgageService.fiduciaryCount();

		} catch (Exception e) {
			code = -1;
			msg = "失败";
		}

		return JsonUtil.getResponseJson(code, msg, count, null);
	}

	

	/**
	 * 
	 * @Title: findByPhone
	 * @description 根据手机号查询
	 * @param @param
	 *  _a 所有属性 des加密（包括时间戳）_s所有属性md5 加密
	 * @param @return
	 * @return List<HousePropertyMortgage>
	 * @author qixiyao
	 * @createDate 2018年11月12日-下午3:15:56
	 */
	@ResponseBody
	@RequestMapping(value = "/findByPhone", produces = "application/json; charset=utf-8")
	public Map<String, Object> findByPhone(String _a, String _s, String _t) {
			List<HousePropertyMortgage> Phone = null;
		Map<String, Object> map = new HashMap<>();
		/**参数解密,后加的ZhaoSong*/
		try {
			String str = DesUtil.getrechargeMember(_a, _t);
			if (str != "") {
				String md5 = MD5Encrypt.MD5Encode(str);
				if (md5.equals(_s)) {
					Map<String, String> data = DesUtil.map(str);
					Long user_id = Long.parseLong(data.get("user_id"));
					String phone = data.get("phone");
					Phone = housePropertyMortgageService.findByPhone(user_id, phone);
					if (Phone == null) {
						code = -1;
						msg = "没有查到该手机号";
					} else {
						code = 1;
						msg = "查询成功";
					}

				}else {
					map.put("code", -1);
					map.put("msg", "签名错误，您的访问数据非法");

				}
			} else {
				map.put("code", -1);
				map.put("msg", "网络超时您的网络不行");
			}
		} catch (Exception e) {
			map.put("code", -1);
			map.put("msg", "系统异常");
		}

		logger.info(msg);
		map.put("code", code);
		map.put("msg", msg);
		map.put("data", Phone);

		return map;
	}

	/**
	 * 
	 * @Title: selectById
	 * @description 根据id查询
	 * @param @param
	 *            id
	 * @param @return
	 * @return String
	 * @author qixiyao
	 * @createDate 2018年11月15日-下午2:50:26
	 */
	@ResponseBody
	@RequestMapping(value = "/selectById", produces = "application/json; charset=utf-8")
	public String selectById(Long id) {
		HousePropertyMortgage result = null;

		try {
			result = housePropertyMortgageService.selectById(id);
			if (result == null) {
				msg = "查无此id";
			} else {
				msg = "查询成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
			logger.info(e);
		}
		logger.info(msg);
		return JsonUtil.getResponseJson(code, msg, null, result);
	}

	/**
	 * 
	 * @Title: deleteFiduciaryLoanById
	 * @description 根据id删除
	 * @param @param
	 *            id
	 * @param @return
	 * @return String
	 * @author qixiyao
	 * @createDate 2018年11月12日-下午3:25:07
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteById", produces = "application/json; charset=utf-8")
	public String deleteById(Long id) {
		try {
			int ids = housePropertyMortgageService.deleteById(id);
			if (ids == 1) {
				msg = "删除成功";
			} else {
				msg = "删除失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		return JsonUtil.getResponseJson(code, msg, null, null);
	}

	/**
	 * 
	 * @Title: findByUserId
	 * @description 根据user_id查询全部
	 * @param @param
	 *            user_id
	 * @param @param
	 *            page
	 * @param @param
	 *            limit
	 * @param @return
	 * @return String
	 * @author qixiyao
	 * @createDate 2018年11月12日-下午3:40:55
	 */
	@ResponseBody
	@RequestMapping(value = "/findByUserId", produces = "application/json; charset=utf-8")
	public Map<String, Object> findByUserId(String _a, String _s, String _t) {
		List<HousePropertyMortgage> userId = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String str = DesUtil.getrechargeMember(_a, _t);
			if (str != "") {
				String md5 = MD5Encrypt.MD5Encode(str);
				if (md5.equals(_s)) {
					Map<String, String> data = DesUtil.map(str);
					Integer page = Integer.parseInt(data.get("page"));
					Integer limit = Integer.parseInt(data.get("limit"));
					Integer user_id = Integer.parseInt(data.get("user_id"));

					if (page == null || page <= 0) {
						page = 1;
					}
					page = (page - 1) * limit;

					userId = housePropertyMortgageService.findByUserId(user_id, page, limit);
					map.put("code", 1);
					map.put("msg", "查询成功");
					map.put("data", userId);
					/*
					 * for (HousePropertyMortgage fiduciaryLoan : userId) {
					 * System.out.println(fiduciaryLoan); }
					 */
					/*
					 * if (page == null || page <= 0) { page = 1; } if
					 * (userId.size() > 0) { msg = "查询成功"; } else { msg =
					 * "查无信息"; }
					 */

				}else {
					map.put("code", -1);
					map.put("msg", "签名错误，您的访问数据非法");

				}
			}else {
				map.put("code", -1);
				map.put("msg", "网络超时您的网络不行");
			}

		} catch (Exception e) {

			e.printStackTrace();
			map.put("code", -1);
			map.put("msg", "查询失败");
		}

		return map;
	}

	/**
	 * 根据抵押人手机号码模糊查询，手机号为空则查询全部（业务报单，资产评估，业务反馈均可使用）
	 *
	 * @Title: listAllAndPhone
	 * 
	 * @description
	 *
	 * @param session
	 * @param phone
	 *            抵押人电话号
	 * @param temp
	 *            区分属于哪个模块的变量
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页显示条数
	 * @param @return
	 * 
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月23日-下午2:39:28
	 */
	@ResponseBody
	@RequestMapping(value = "listAllAndPhone", produces = "application/json; charset=utf-8")
	public String listAllAndPhone(HttpSession session, @RequestParam(value = "phone", required = false) String phone,
			String temp, Integer page, Integer limit) {
		int code = 1;
		String msg= "成功";
		int count = 0;
		Integer type = null;
		Integer status = null;
		if (page == null || page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		User user = (User) session.getAttribute("user");
		List<HousePropertyMortgage> result = null;
		List<HousePropertyMortgage> list = new ArrayList<>();

		try {
			if (temp.equals("businessFeedback")) {
				/** 业务反馈模块 */
				if (phone == null || phone.equals("")) {
					status = null;
				}
				
			} else if (temp.equals("printingContract")) {
				/** 打印合同模块 */
				status = 6;
			}
			if (user.getPost().equals("超级管理员") || user.getPost().indexOf("评估师") > 0) {
				result = housePropertyMortgageService.listAllAndPhone(phone, null, type, status, page, limit);
				count = housePropertyMortgageService.getCount(null, status, phone, type);
			} else {
				result = housePropertyMortgageService.listAllAndPhone(phone, user.getId(), type, status, page, limit);
				count = housePropertyMortgageService.getCount(user.getId(), status, phone, type);
			}
			if (result.size() > 0 && temp.equals("businessFeedback")) {
				for (HousePropertyMortgage hpm : result) {
					if (hpm.getStatus() != null) {
						list.add(hpm);
					}
				}
				result = list;
				count = list.size();
			}
			if (count == 0) {
				msg = "查无信息";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
			logger.info(e);
		}

		return JsonUtil.getResponseJson(code, msg, count, result);
	}

	/**
	 * 
	 * @Title: saveAll
	 * @description 保存全部
	 * @param @param
	 *            housePropertyMortgage
	 * @param @return
	 * @return Map
	 * @author qixiyao
	 * @createDate 2018年11月12日-下午2:59:41
	 */
	@SuppressWarnings("null")
	@RequestMapping(value = "/saveAll", produces = "application/json; charset=utf-8")
	@ResponseBody

	public Map<Object, Object> saveAll(String _a, String _s, String _t) {
		Map<Object, Object> map = new HashMap<>();
		/**参数解密,后加的ZhaoSong*/
		try {

			String str = DesUtil.getrechargeMember(_a, _t);
			if (str != "") {
				String md5 = MD5Encrypt.MD5Encode(str);
				if (md5.equals(_s)) {
					Map<String, String> data = DesUtil.map(str);
					HousePropertyMortgage housePropertyMortgage = new HousePropertyMortgage();
					if (data.get("user_id") != null && !data.get("user_id").equals("")) {
						housePropertyMortgage.setUser_id(Integer.parseInt(data.get("user_id")));
					}
					
					if (data.get("name") != null && !data.get("name").equals("")) {
						housePropertyMortgage.setName(data.get("name"));
					}
					if (data.get("phone") != null && !data.get("phone").equals("")) {
						housePropertyMortgage.setPhone(data.get("phone"));
					}
					if (data.get("id_number") != null && !data.get("id_number").equals("")) {
						housePropertyMortgage.setId_number(data.get("id_number"));
					}
					if (data.get("type") != null && !data.get("type").equals("")) {
						housePropertyMortgage.setType(Integer.parseInt(data.get("type")));
					}
					if (data.get("emergency_name") != null && !data.get("emergency_name").equals("")) {
						housePropertyMortgage.setEmergency_name(data.get("emergency_name"));
					}
					if (data.get("emergency_phone") != null && !data.get("emergency_phone").equals("")) {
						housePropertyMortgage.setEmergency_phone(data.get("emergency_phone"));
					}
					if (data.get("apply_for_limit") != null && !data.get("apply_for_limit").equals("")) {
						BigDecimal apply_for_limit = new BigDecimal(data.get("apply_for_limit"));
						housePropertyMortgage.setApply_for_limit(apply_for_limit);
					}
					if (data.get("apply_for_deadline") != null && !data.get("apply_for_deadline").equals("")) {
						housePropertyMortgage.setApply_for_deadline(data.get("apply_for_deadline"));
					}
					if (data.get("purpose_of_loan") != null && !data.get("purpose_of_loan").equals("")) {
						housePropertyMortgage.setPurpose_of_loan(data.get("purpose_of_loan"));
					}
					if (data.get("gender") != null && !data.get("gender").equals("")) {
						housePropertyMortgage.setGender(Integer.parseInt(data.get("gender")));
					}
					if (data.get("email") != null && !data.get("email").equals("")) {
						housePropertyMortgage.setEmail(data.get("email"));
					}
					if (data.get("spouse_identification_name") != null
							&& !data.get("spouse_identification_name").equals("")) {
						housePropertyMortgage.setSpouse_identification_name(data.get("spouse_identification_name"));
					}
					if (data.get("spouse_identification_number") != null
							&& !data.get("spouse_identification_number").equals("")) {
						housePropertyMortgage.setSpouse_identification_number(data.get("spouse_identification_number"));
					}
					if (data.get("spousal_work_unit") != null && !data.get("spousal_work_unit").equals("")) {
						housePropertyMortgage.setSpousal_work_unit(data.get("spousal_work_unit"));
					}
					if (data.get("relative_contact_name") != null && !data.get("relative_contact_name").equals("")) {
						housePropertyMortgage.setRelative_contact_name(data.get("relative_contact_name"));
					}
					if (data.get("relative_contact_number") != null
							&& !data.get("relative_contact_number").equals("")) {
						housePropertyMortgage.setRelative_contact_number(data.get("relative_contact_number"));
					}
					if (data.get("account_opening_time") != null && !data.get("account_opening_time").equals("")) {
						housePropertyMortgage
								.setAccount_opening_time(Integer.parseInt(data.get("account_opening_time")));
					}
					if (data.get("emergency_relation") != null && !data.get("emergency_relation").equals("")) {
						housePropertyMortgage.setEmergency_relation(Integer.parseInt(data.get("emergency_relation")));
					}
					if (data.get("domestic_relation") != null && !data.get("domestic_relation").equals("")) {
						housePropertyMortgage.setDomestic_relation(Integer.parseInt(data.get("domestic_relation")));
					}
					if (data.get("age") != null && !data.get("age").equals("")) {
						housePropertyMortgage.setAge(Integer.parseInt(data.get("age")));
					}
					if (data.get("marital_status") != null && !data.get("marital_status").equals("")) {
						housePropertyMortgage.setMarital_status(Integer.parseInt(data.get("marital_status")));
					}
					if (data.get("education") != null && !data.get("education").equals("")) {
						housePropertyMortgage.setEducation(Integer.parseInt(data.get("education")));
					}
					if (data.get("diploma") != null && !data.get("diploma").equals("")) {
						housePropertyMortgage.setDiploma(Integer.parseInt(data.get("diploma")));
					}
					if (data.get("home_phone") != null && !data.get("home_phone").equals("")) {
						housePropertyMortgage.setHome_phone(data.get("home_phone"));
					}
					if (data.get("business_phone_number") != null && !data.get("business_phone_number").equals("")) {
						housePropertyMortgage.setBusiness_phone_number(data.get("business_phone_number"));
					}if (data.get("home_address") != null && !data.get("home_address").equals("")) {
						housePropertyMortgage.setHome_address(data.get("home_address"));
					}
					
					
					if (data.get("mailing_address") != null && !data.get("mailing_address").equals("")) {
						housePropertyMortgage.setMailing_address(data.get("mailing_address"));
					}
					if (data.get("permanent_residence_address") != null
							&& !data.get("permanent_residence_address").equals("")) {
						housePropertyMortgage.setPermanent_residence_address(data.get("permanent_residence_address"));
					}
					if (data.get("home_number") != null && !data.get("home_number").equals("")) {
						housePropertyMortgage.setHome_number(data.get("home_number"));
					}
					if(data.get("customs_type")!=null&&!data.get("customs_type").equals("")){
						housePropertyMortgage.setCustoms_type(Integer.parseInt(data.get("customs_type")));
					}
					Date date = new Date();
					housePropertyMortgage.setCreate_time(date);
					housePropertyMortgage.setUpdate_time(date);
					Integer customs_type = housePropertyMortgage.getCustoms_type();
/*
					if (housePropertyMortgage.getType() == 0) {
						housePropertyMortgage.setCustoms_type(customs_type);
						housePropertyMortgage.setBusiness_type(0);
						map.put("code", 1);
						map.put("msg", "保存成功");
						housePropertyMortgageService.saveAll(housePropertyMortgage);

					}*/
				
						housePropertyMortgage.setCustoms_type(customs_type);
						housePropertyMortgage.setBusiness_type(0);
						List<User> user = housePropertyMortgageService.getassessmensId();
						List<HousePropertyMortgage> lastid = housePropertyMortgageService.lastid();
						Long[] longs = new Long[user.size()];
						for (int a = 0; a < user.size(); a++) {
							longs[a] = user.get(a).getId();
						}
						if (lastid.size() == 0 || lastid.get(0).getAssessmens() == null) {
							housePropertyMortgage.setAssessmens(longs[0]);
						} else {

							long id = lastid.get(0).getAssessmens();

							for (int a = 0; a < user.size(); a++) {

								if (longs[a].equals(id)) {
									if (a + 1 >= user.size()) {
										housePropertyMortgage.setAssessmens(longs[0]);
									} else {
										housePropertyMortgage.setAssessmens(longs[a + 1]);
									}

								}
							}
						}

						int result = housePropertyMortgageService.saveAll(housePropertyMortgage);
						List<HousePropertyMortgage> findByUserId = housePropertyMortgageService
								.findByUserId(housePropertyMortgage.getUser_id(), null, null);
						map.put("code", 1);
						map.put("msg", "提交成功");
						map.put("data", result);
						map.put("entry_number", findByUserId.get(0).getEntry_number());
					

				}else {
					map.put("code", -1);
					map.put("msg", "签名错误，您的访问数据非法");

				}

			}else {
				map.put("code", -1);
				map.put("msg", "网络超时您的网络不行");
			}

		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", -1);
			map.put("msg", "系统异常");
		}

		return map;

	}

	/**
	 * 
	 * @Title: updateById
	 * @description 根据id修改
	 * @param request
	 * @param response
	 * @param session
	 * @param record
	 * @return Map<String,Object>
	 * @author likai
	 * @createDate 2018年9月28日 上午9:23:19
	 */
	@ResponseBody
	@RequestMapping(value = "/updateById", produces = "application/json; charset=utf-8")
	public String updateById(HousePropertyMortgage housePropertyMortgage) {

		Integer type = housePropertyMortgage.getType();
		try {
			if (type == 0) {
				housePropertyMortgageService.updateById(housePropertyMortgage);
				code = 1;
				msg = "修改成功";
			}else if (type == 1) {
				code = -1;
				msg = "报单已提交，不可修改";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
			logger.info(e);
		}
		logger.info(msg);
		return JsonUtil.getResponseJson(code, msg, null, null);
	}

	/**
	 * 
	 * @Title: ResultHousePropertyMortgage
	 * @description 房屋评估
	 * @param @return
	 * @return Map<String,Object>
	 * @author qixiyao
	 * @createDate 2018年10月15日-下午1:50:21
	 */
	@ResponseBody
	@RequestMapping(value = "/ResultHousePropertyMortgage", produces = "application/json; charset=utf-8")
	public String ResultHousePropertyMortgage(HousePropertyMortgage housePropertyMortgage) {
		
		Long id = housePropertyMortgage.getId();
		Integer status = housePropertyMortgage.getStatus();
		String remark = housePropertyMortgage.getRemark();
		//如果备注不为空表示不通过
		if (remark != null ) {
			housePropertyMortgage.setStatus(1);
			code = -1;
			msg = "资产评估不通过";
		}else{
			housePropertyMortgage.setStatus(2);
			housePropertyMortgage.setAffirm_time(new Date());
			housePropertyMortgageService.updateTimeH(housePropertyMortgage.getEntry_number());
			code = 1;
			msg = "资产评估通过";
		}
		housePropertyMortgageService.updatefield(housePropertyMortgage);
		return JsonUtil.getResponseJson(code, msg, null, null);
		

	}

	/**
	 * 房产抵押业务反馈信息列表
	 *
	 * @Title: findHousePropertyMortgage
	 * @description
	 *
	 * @param page
	 *            当前页
	 * 
	 * @param limit
	 *            每页显示条数
	 * 
	 * @param @return
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月1日-上午10:42:02
	 */
	@RequestMapping(value = "findHousePropertyMortgage", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findHousePropertyMortgage(HttpSession session, Integer page, Integer limit) {
		List<HousePropertyMortgage> housePropertyMortgageList = null;
		User user = (User) session.getAttribute("user");
		List<HousePropertyMortgage> list = new ArrayList<>();
		int count = 0;
		if (page == null || page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;

		try {
			if (user.getPost().equals("超级管理员")) {
				/** 如果是超级管理员则查询全部 */
				housePropertyMortgageList = housePropertyMortgageService.findByLimit(null, null, page, limit);
			} else {
				/** 显示当前业务员所有报单数据 */
				housePropertyMortgageList = housePropertyMortgageService.findByLimit(user.getId(), null, page, limit);
			}
			if (housePropertyMortgageList.size() > 0) {
				for (HousePropertyMortgage hpm : housePropertyMortgageList) {
					if (hpm.getStatus() != null) {
						list.add(hpm);
					}
				}
				count = list.size();
			}
			if (count == 0) {
				msg = "无数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("系统异常");
			code = -1;
			msg = "系统异常";
		}

		return JsonUtil.getResponseJson(code, msg, count, list);
	}

	/**
	 * 房产抵押业务反馈
	 *
	 * @Title: housePropertyMortgageBusFeedback
	 * @description
	 *
	 * @param housePropertyMortgage
	 * 
	 * @param remark
	 *            备注
	 * 
	 * @param @return
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2018年10月26日-下午2:36:20
	 */
	@ResponseBody
	@RequestMapping(value = "/housePropertyMortgageBusFeedback", produces = "application/json; charset=utf-8")
	public String housePropertyMortgageBusFeedback(HousePropertyMortgage housePropertyMortgage, String remark) {
		int result = 0;
		/** 备注为空则视为通过 */
		if (remark == null || "".equals(remark)) {

			housePropertyMortgage.setStatus(3);
			/**资产评估通过,分配给风控内勤人员ZhaoSong*/
			// 所有内勤id 包含风控主管
			List<User> user = housePropertyMortgageService.getassessmensIdH();
			// 倒数第二条报单
			List<HousePropertyMortgage> lastid = housePropertyMortgageService.lastidH();

			Long[] longs = new Long[user.size()];
			for (int a = 0; a < user.size(); a++) {
				longs[a] = user.get(a).getId();
			}

			if (lastid.size() == 0 || lastid.get(0).getManagement() == null) {
				housePropertyMortgage.setManagement(longs[0]);
			} else {

				long id = lastid.get(0).getManagement();

				for (int a = 0; a < user.size(); a++) {

					if (longs[a].equals(id)) {
						if (a + 1 >= user.size()) {
							housePropertyMortgage.setManagement(longs[0]);
						} else {
							housePropertyMortgage.setManagement(longs[a + 1]);
						}

					}
				}
			}
		} else {
			/** 备注不为空则视为不通过，修改进程状态为1（不通过） */
			housePropertyMortgage.setStatus(1);
			housePropertyMortgage.setRemark(remark);
		}

		try {
			housePropertyMortgageService.updateTimeH(housePropertyMortgage.getEntry_number());
			result = housePropertyMortgageService.updateStatusAndRemark(housePropertyMortgage.getId(),
					housePropertyMortgage.getStatus(), remark);
			int row = housePropertyMortgageService.updateManagementId(housePropertyMortgage.getId(),
					housePropertyMortgage.getManagement());
			if (result <= 0) {
				logger.error("更新失败");
				code = result;
				msg = "更新失败";
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("信用贷款业务反馈失败！");
			code = -1;
			msg = "系统异常";
		}
		msg = "修改成功";
		return JsonUtil.getResponseJson(code, msg, null, result);
	}

	/**
	 * 根据id查询房产抵押详细信息
	 *
	 * @Title: getDetailsById
	 * @description
	 *
	 * @param id
	 * @param @return
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月2日-上午11:12:25
	 */
	@RequestMapping(value = "getDetailsById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getDetailsById(Long id) {
		HousePropertyMortgage housePropertyMortgage = null;
		try {
			housePropertyMortgage = housePropertyMortgageService.selectById(id);
			if (housePropertyMortgage == null) {
				msg = "无数据";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("系统异常");
			code = -1;
			msg = "系统异常";
		}

		return JsonUtil.getResponseJson(code, msg, null, housePropertyMortgage);
	}

	/**
	 * 
	 * @Title: findAll
	 * @description 查询全部
	 * @param @param
	 *            page
	 * @param @param
	 *            limit
	 * @param @return
	 * @return String
	 * @author qixiyao
	 * @createDate 2018年11月12日-上午11:32:48
	 */
	@ResponseBody
	@RequestMapping(value = "/findAll", produces = "application/json; charset=utf-8")
	public Map<String, Object> findAll(HttpSession session, Integer status, Integer page, Integer limit) {
		Long user_id= (Long)session.getAttribute("user_id");
		User user = (User)session.getAttribute("user");
		List<HousePropertyMortgage> housePropertyMortgages = null;
		Map<String, Object> map = new HashMap<>();
		if (page == null || page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		try {
			if(user.getPost().equals("超级管理员")||user.getPost().equals("业务主管")){
			user_id=null;
			housePropertyMortgages = housePropertyMortgageService.findByLimit(null, status, page, limit);
			if (housePropertyMortgages.size() == 0) {
				code = -1;
				msg = "无数据";
			}
			}else{
				housePropertyMortgages = housePropertyMortgageService.findByLimit(user_id, status, page, limit);
				if (housePropertyMortgages.size() == 0) {
				code = -1;
				msg = "无数据";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("系统异常");
			code = -1;
			msg = "系统异常";
		}
		map.put("code", code);
		map.put("msg", msg);
		map.put("data", housePropertyMortgages);
		map.put("count", housePropertyMortgageService.getCount(user_id, null, null, null));
		return map;
	}

	/**
	 * 
	 *
	 * @Title: findByManagement
	 *
	 * @description 根据风控人员Id(management)查询状态值(status)为3(业务反馈通过)的数据
	 *
	 * @param @param
	 *            management
	 * @param @param
	 *            page
	 * @param @param
	 *            limit
	 * @param @return
	 * 
	 * @return String
	 *
	 * @author yaozijun
	 *
	 * @createDate 2018年11月26日
	 */
	@RequestMapping(value = "findByManagement", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findByManagement(Long management, Integer page, Integer limit) {
		List<HousePropertyMortgage> result = null;
		int count = 0;
		try {
			if (page == null || page <= 0) {
				page = 1;
			}
			page = (page - 1) * limit;
			result = housePropertyMortgageService.findByManagement(management, page, limit);
			count = housePropertyMortgageService.findByManagementCount(management);

			if (result.size() == 0) {
				msg = "查无信息";
			} else {
				msg = "查询成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
			logger.info(e);
		}
		logger.info(msg);

		return JsonUtil.getResponseJson(code, msg, count, result);

	}

	/**
	 * @Title: updateStatus
	 * @description 修改房屋报单状态
	 * @param entry_number
	 *            房屋抵押报单编号
	 * @param status
	 *            房屋抵押报单状态
	 * @return HashMap<String,Object> 返回处理结果
	 * @author ZhaoSong
	 * @createDate 2018年11月22日
	 */
	@RequestMapping("/updateHouseStatus")
	@ResponseBody
	public HashMap<String, Object> updateStatus(String _a, String _s, String _t) {

		HashMap<String, Object> result = new HashMap<String,Object>();
		int status = 0;
		String entry_number = null;
		try {
			String str = DesUtil.getrechargeMember(_a, _t);
			if (!str.equals("")) {
				String md5 = MD5Encrypt.MD5Encode(str);
				if (md5.equals(_s)) {
					Map<String, String> data = DesUtil.map(str);
					status = Integer.parseInt(data.get("status"));
					entry_number = data.get("entry_number");
				}else {
					result.put("code", -1);
					result.put("msg", "签名错误，您的访问数据非法");

				}
			}else {
				result.put("code", -1);
				result.put("msg", "网络超时您的网络不行");
			}

		} catch (Exception e) {
			result.put("code", -1);
			result.put("msg", "系统异常");
		}


		// String entry_number, int status

		if (status == 3 && entry_number != null && !entry_number.equals("")) {// 如果状态为3,面审通过,将报单分配给风控外勤

			status++;
			// 根据报单编号查找到此报单
			HousePropertyMortgage housePropertyMortgage = housePropertyMortgageService.findByEntryNumber(entry_number);
			// 所有风控外勤id 包括风控主管
			List<User> user = housePropertyMortgageService.getRiskManagementIdH();
			// 倒数第二条报单
			List<HousePropertyMortgage> lastid = housePropertyMortgageService.lastidHS();
			Long[] longs = new Long[user.size()];
			for (int a = 0; a < user.size(); a++) {
				longs[a] = user.get(a).getId();
			}

			if (lastid.size() == 0 || lastid.get(0).getRisk_management() == null) {
				housePropertyMortgage.setRisk_management(longs[0]);
			} else {

				long id = lastid.get(0).getRisk_management();

				for (int a = 0; a < user.size(); a++) {

					if (longs[a].equals(id)) {
						if (a + 1 >= user.size()) {
							housePropertyMortgage.setRisk_management(longs[0]);
						} else {
							housePropertyMortgage.setRisk_management(longs[a + 1]);
						}

					}
				}
			}

			int r = housePropertyMortgageService.updateByIdStatus(housePropertyMortgage.getId(), status);
			int row = housePropertyMortgageService.updateRiskManagementId(housePropertyMortgage.getId(),
					housePropertyMortgage.getRisk_management());
			if (row > 0 && r > 0) {
				housePropertyMortgageService.updateTimeH(entry_number);
				result.put("code", 1);
				result.put("msg", "已分配给风控外勤人员");
			} else {
				result.put("code", -1);
				result.put("msg", "分配失败");
			}
		} else {
			
			if (entry_number != null && entry_number != "") {
				if (housePropertyMortgageService.findByEntryNumber(entry_number) != null) {
					status += 1;
					int row = housePropertyMortgageService.updateStatus(entry_number, status);
					if (row != 0) {
						result.put("code", 1);
						result.put("msg", "修改状态成功");
					}
				}
			} else {
				result.put("code", -1);
				result.put("msg", "查此报单编");
			}
		}
		return result;
	}

	/**
	 * @Title: refuseToPass
	 * @description 拒绝通过的方法(拒绝通过后,订单状态变为1,,不通过,但是订单不会删除)
	 * @param @param
	 *            entry_number 房屋报单编号
	 * @param @param
	 *            status 状态值
	 * @return HashMap<String,Object> 处理结果
	 * @author ZhaoSong
	 * @createDate 2018年11月29日
	 */
	@RequestMapping("/refuseToPassHouse")
	@ResponseBody
	public HashMap<String, Object> refuseToPass(String _a, String _s, String _t) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		String entry_number = null;
		int status = 0;
		String remark = null;

		try {
			String str = DesUtil.getrechargeMember(_a, _t);
			if (!str.equals("")) {
				String md5 = MD5Encrypt.MD5Encode(str);
				if (md5.equals(_s)) {
					Map<String, String> data = DesUtil.map(str);
					entry_number = data.get("entry_number");
					status = Integer.parseInt(data.get("status"));
					remark = data.get("remark");
				}else {
					result.put("code", -1);
					result.put("msg", "签名错误，您的访问数据非法");

				}
			}else {
				result.put("code", -1);
				result.put("msg", "网络超时您的网络不行");
			}

		} catch (Exception e) {
			result.put("code", -1);
			result.put("msg", "系统异常");
		}
		if (entry_number != null && entry_number != "") {
			if (housePropertyMortgageService.findByEntryNumber(entry_number) != null) {
				status = 1;// 状态设置为1,不通过s
				int row = housePropertyMortgageService.refuseToPass(entry_number, status);
				if (remark != null && !remark.equals("")) {
					// 将不通过理由填入此报单中
					int r = housePropertyMortgageService.updateRemark(entry_number, remark);
					// 若填入成功,则返回处理结果
					if (row > 0&&r>0) {
						result.put("code", 1);
						result.put("msg", "处理完成");
					} else {

						result.put("code", -1);
						result.put("msg", "处理失败");
					}
				} else {
					result.put("code", -1);
					result.put("msg", "不通过理由不得为空!");
				}
			} else {
				result.put("code", -1);
				result.put("msg", "查无此报单");
			}
			
	}else {
		result.put("code", -1);
		result.put("msg", "报单编号不能为空");
	}
		
		return result;
}
	
	/**
	 * @Title: submitDeclarationH
	 * @description 修改并提交房屋报单
	 * @param @param housePropertyMortgage 参数对象
	 * @return ResultInfo 处理结果 
	 * @author ZhaoSong
	 * @createDate 2018年12月24日
	 */
	@RequestMapping("/submitDeclarationH")
	@ResponseBody
	public ResultInfo submitDeclarationH(HousePropertyMortgage housePropertyMortgage){
		ResultInfo result=new ResultInfo();
		housePropertyMortgage.setAffirm_time(new Date());
		housePropertyMortgage.setType(1);
		int row = housePropertyMortgageService.submitDeclarationH(housePropertyMortgage);
		if(row>0){
			result.code=1;
			result.msg="保存修改成功";
		}else{
			result.code=-1;
			result.msg="保存修改失败";
		}
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}