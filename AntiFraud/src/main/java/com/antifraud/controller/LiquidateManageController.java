package com.antifraud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.antifraud.entityVO.PostLoanManageVo;

import com.antifraud.service.LiquidateManageService;

import com.antifraud.utils.AcceptUntils;
import com.antifraud.utils.JsonUtil;

/**
 * 
 *
 * @ClassName: LiquidateManageController
 * 
 * @description 清收管理表Controller层
 *
 * @author zhangkai
 * @createDate 2018年10月11日
 */
@Controller
@RequestMapping("LiquidateManage")
public class LiquidateManageController {
	@Autowired
	LiquidateManageService liquidateManageService;

	/**
	 * 
	 *
	 * @Title: findAllHouseProperty
	 * 
	 * @description 主页列表查询房屋报单申请表
	 *
	 * @param @param
	 *            page
	 * @param @param
	 *            limit
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月22日
	 */
	@RequestMapping(value = "findAllHouseProperty", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findAllHouseProperty(int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		int count = 0;
		int start;
		int end;
		String loadJson = null;

		try {

			start = (page - 1) * limit;
			end = start + limit + 1;
			result = liquidateManageService.findAllHouseProperty();
			count = liquidateManageService.findAllHouseProperty().size();

			if (result != null) {// 防止空指针异常

				// 调用普惠的接口，只要有一期逾期，对应报单编号就算逾期，去掉结果集中该报单编号对应未逾期结果
				loadJson = AcceptUntils.loadJson("www.ouyepuhui.com/loanTrack");
				loadJson = loadJson.substring(loadJson.indexOf("["), loadJson.lastIndexOf("]") + 1);
				JSONArray json = (JSONArray) JSONArray.parse(loadJson);
				if (json.size() > 0) {
					for (int i = 0; i < result.size(); i++) {
						PostLoanManageVo postLoanManageVo = result.get(i);
						String entryNumber = postLoanManageVo.getEntry_number();
						int number = 0;
						int total_period = 0;
						for (int j = 0; j < json.size(); j++) {
							JSONObject jSONObject = json.getJSONObject(j);
							int is_overdue = jSONObject.getIntValue("is_overdue");
							String entry_number = jSONObject.getString("entry_number");
							total_period = jSONObject.getIntValue("total_period");
							if (entry_number.equals(entryNumber) && is_overdue == 0) {
								number++;
							}
						}
						if (number == total_period) {
							result.remove(i);
							i--;
							count--;
						}
					}
				}

				// 替代mysql分页,防止list越界异常
				if (result.size() >= end) {
					result = result.subList(start, end);
				} else {
					if (result.size() > start) {
						result = result.subList(start, result.size());
					} else {
						result.clear();
					}
				}

			}

			if (result != null) {
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
	 * @param @param
	 *            page
	 * @param @param
	 *            limit
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月22日
	 */
	@RequestMapping(value = "findAllVehicle", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findAllVehicle(int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		int count = 0;
		int start;
		int end;
		String loadJson = null;

		try {
			start = (page - 1) * limit;
			end = start + limit + 1;
			result = liquidateManageService.findAllVehicleOnPages(start, limit);
			count = liquidateManageService.findAllVehicle().size();

			if (result != null) {// 防止空指针异常

				// 调用普惠的接口，只要有一期逾期，对应报单编号就算逾期，去掉结果集中该报单编号对应未逾期结果
				loadJson = AcceptUntils.loadJson("www.ouyepuhui.com/loanTrack");
				loadJson = loadJson.substring(loadJson.indexOf("["), loadJson.lastIndexOf("]") + 1);
				JSONArray json = (JSONArray) JSONArray.parse(loadJson);
				if (json.size() > 0) {
					for (int i = 0; i < result.size(); i++) {
						PostLoanManageVo postLoanManageVo = result.get(i);
						String entryNumber = postLoanManageVo.getEntry_number();
						int number = 0;
						int total_period = 0;
						for (int j = 0; j < json.size(); j++) {
							JSONObject jSONObject = json.getJSONObject(j);
							int is_overdue = jSONObject.getIntValue("is_overdue");
							String entry_number = jSONObject.getString("entry_number");
							total_period = jSONObject.getIntValue("total_period");
							if (entry_number.equals(entryNumber) && is_overdue == 0) {
								number++;
							}
						}
						if (number == total_period) {
							result.remove(i);
							i--;
							count--;
						}
					}
				}

				// 替代mysql分页,防止list越界异常
				if (result.size() >= end) {
					result = result.subList(start, end);
				} else {
					if (result.size() > start) {
						result = result.subList(start, result.size());
					} else {
						result.clear();
					}
				}

			}

			if (result != null) {

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
	 * @param @param
	 *            page
	 * @param @param
	 *            limit
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月22日
	 */
	@RequestMapping(value = "findAllFiduciary", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findAllFiduciary(int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		int count = 0;
		int start;
		int end;
		String loadJson = null;

		try {
			start = (page - 1) * limit;
			end = start + limit + 1;
			result = liquidateManageService.findAllFiduciaryOnPages(start, limit);
			count = liquidateManageService.findAllFiduciary().size();

			if (result != null) {// 防止空指针异常

				// 调用普惠的接口，只要有一期逾期，对应报单编号就算逾期，去掉结果集中该报单编号对应未逾期结果
				loadJson = AcceptUntils.loadJson("www.ouyepuhui.com/loanTrack");
				loadJson = loadJson.substring(loadJson.indexOf("["), loadJson.lastIndexOf("]") + 1);
				JSONArray json = (JSONArray) JSONArray.parse(loadJson);
				if (json.size() > 0) {
					for (int i = 0; i < result.size(); i++) {
						PostLoanManageVo postLoanManageVo = result.get(i);
						String entryNumber = postLoanManageVo.getEntry_number();
						int number = 0;
						int total_period = 0;
						for (int j = 0; j < json.size(); j++) {
							JSONObject jSONObject = json.getJSONObject(j);
							int is_overdue = jSONObject.getIntValue("is_overdue");
							String entry_number = jSONObject.getString("entry_number");
							total_period = jSONObject.getIntValue("total_period");
							if (entry_number.equals(entryNumber) && is_overdue == 0) {
								number++;
							}
						}
						if (number == total_period) {
							result.remove(i);
							i--;
							count--;
						}
					}
				}

				// 替代mysql分页,防止list越界
				if (result.size() >= end) {
					result = result.subList(start, end);
				} else {
					if (result.size() > start) {
						result = result.subList(start, result.size());
					} else {
						result.clear();
					}
				}

			}

			if (result != null) {

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
	 * @Title: findHousePropertyByPhone
	 * 
	 * @description 主页按电话查询房屋报单申请表
	 *
	 * @param @param
	 *            phone
	 * @param @param
	 *            page
	 * @param @param
	 *            limit
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月22日
	 */
	@RequestMapping(value = "findHousePropertyByPhone", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findHousePropertyByPhone(String phone, int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		int count = 0;
		int start;
		int end;
		String loadJson = null;
		try {
			start = (page - 1) * limit;
			end = start + limit + 1;
			result = liquidateManageService.findHousePropertyByPhoneOnPages(phone, start, limit);
			count = liquidateManageService.findHousePropertyByPhone(phone).size();

			if (result != null) {// 防止空指针异常

				// 调用普惠的接口，只要有一期逾期，对应报单编号就算逾期，去掉结果集中该报单编号对应未逾期结果
				loadJson = AcceptUntils.loadJson("www.ouyepuhui.com/loanTrack");
				loadJson = loadJson.substring(loadJson.indexOf("["), loadJson.lastIndexOf("]") + 1);
				JSONArray json = (JSONArray) JSONArray.parse(loadJson);
				if (json.size() > 0) {
					for (int i = 0; i < result.size(); i++) {
						PostLoanManageVo postLoanManageVo = result.get(i);
						String entryNumber = postLoanManageVo.getEntry_number();
						int number = 0;
						int total_period = 0;
						for (int j = 0; j < json.size(); j++) {
							JSONObject jSONObject = json.getJSONObject(j);
							int is_overdue = jSONObject.getIntValue("is_overdue");
							String entry_number = jSONObject.getString("entry_number");
							total_period = jSONObject.getIntValue("total_period");
							if (entry_number.equals(entryNumber) && is_overdue == 0) {
								number++;
							}
						}
						if (number == total_period) {
							result.remove(i);
							i--;
							count--;
						}
					}
				}

				// 替代mysql分页,防止list越界异常
				if (result.size() >= end) {
					result = result.subList(start, end);
				} else {
					if (result.size() > start) {
						result = result.subList(start, result.size());
					} else {
						result.clear();
					}
				}

			}

			if (result != null) {

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
	 * @description 主页按电话查询车辆报单申请表
	 *
	 * @param @param
	 *            phone
	 * @param @param
	 *            page
	 * @param @param
	 *            limit
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月22日
	 */
	@RequestMapping(value = "findVehicleByPhone", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findVehicleByPhone(String phone, int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		int count = 0;
		int start;
		int end;
		String loadJson = null;
		try {
			start = (page - 1) * limit;
			end = start + limit + 1;
			result = liquidateManageService.findVehicleByPhoneOnPages(phone, start, limit);
			count = liquidateManageService.findVehicleByPhone(phone).size();

			if (result != null) {// 防止空指针异常

				// 调用普惠的接口，只要有一期逾期，对应报单编号就算逾期，去掉结果集中该报单编号对应未逾期结果
				loadJson = AcceptUntils.loadJson("www.ouyepuhui.com/loanTrack");
				loadJson = loadJson.substring(loadJson.indexOf("["), loadJson.lastIndexOf("]") + 1);
				JSONArray json = (JSONArray) JSONArray.parse(loadJson);
				if (json.size() > 0) {
					for (int i = 0; i < result.size(); i++) {
						PostLoanManageVo postLoanManageVo = result.get(i);
						String entryNumber = postLoanManageVo.getEntry_number();
						int number = 0;
						int total_period = 0;
						for (int j = 0; j < json.size(); j++) {
							JSONObject jSONObject = json.getJSONObject(j);
							int is_overdue = jSONObject.getIntValue("is_overdue");
							String entry_number = jSONObject.getString("entry_number");
							total_period = jSONObject.getIntValue("total_period");
							if (entry_number.equals(entryNumber) && is_overdue == 0) {
								number++;
							}
						}
						if (number == total_period) {
							result.remove(i);
							i--;
							count--;
						}
					}
				}

				// 替代mysql分页,防止list越界异常
				if (result.size() >= end) {
					result = result.subList(start, end);
				} else {
					if (result.size() > start) {
						result = result.subList(start, result.size());
					} else {
						result.clear();
					}
				}

			}

			if (result != null) {

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
	 * @description 主页按电话查询信用报单申请表
	 *
	 * @param @param
	 *            phone
	 * @param @param
	 *            page
	 * @param @param
	 *            limit
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return String
	 *
	 * 
	 * @author zhangkai
	 * @createDate 2018年11月22日
	 */
	@RequestMapping(value = "findFiduciaryByPhone", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findFiduciaryByPhone(String phone, int page, int limit) throws Exception {

		int code;
		String msg;
		List<PostLoanManageVo> result = null;
		int count = 0;
		int start;
		int end;
		String loadJson = null;
		try {
			start = (page - 1) * limit;
			end = start + limit + 1;
			result = liquidateManageService.findFiduciaryByPhoneOnPages(phone, start, limit);
			count = liquidateManageService.findFiduciaryByPhone(phone).size();

			if (result != null) {// 防止空指针异常

				// 调用普惠的接口，只要有一期逾期，对应报单编号就算逾期，去掉结果集中该报单编号对应未逾期结果
				loadJson = AcceptUntils.loadJson("www.ouyepuhui.com/loanTrack");
				try {
					loadJson = loadJson.substring(loadJson.indexOf("["), loadJson.lastIndexOf("]") + 1);
				} catch (Exception e) {
					return null;
				}
				
				JSONArray json = (JSONArray) JSONArray.parse(loadJson);
				
				if (json.size() > 0) {
					for (int i = 0; i < result.size(); i++) {
						PostLoanManageVo postLoanManageVo = result.get(i);
						String entryNumber = postLoanManageVo.getEntry_number();
						int number = 0;
						int total_period = 0;
						for (int j = 0; j < json.size(); j++) {
							JSONObject jSONObject = json.getJSONObject(j);
							int is_overdue = jSONObject.getIntValue("is_overdue");
							String entry_number = jSONObject.getString("entry_number");
							total_period = jSONObject.getIntValue("total_period");
							if (entry_number.equals(entryNumber) && is_overdue == 0) {
								number++;
							}
						}
						if (number == total_period) {
							result.remove(i);
							i--;
							count--;
						}
					}
				}

				// 替代mysql分页,防止list越界异常
				if (result.size() >= end) {
					result = result.subList(start, end);
				} else {
					if (result.size() > start) {
						result = result.subList(start, result.size());
					} else {
						result.clear();
					}
				}

			}

			if (result != null) {

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
	 * @Title: findHousePropertyByEntry_number
	 * 
	 * @description 详情页按报单编号查询房屋报单申请表
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
	 * @createDate 2018年11月22日
	 */
	@RequestMapping(value = "findHousePropertyByEntry_number", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findHousePropertyByEntry_number(String id) throws Exception {

		int code;
		String msg;
		PostLoanManageVo result = null;
		try {
			result = liquidateManageService.findHousePropertyByEntry_number(id);
			if (result != null) {
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
	 * @Title: findVehicleByEntry_number
	 * 
	 * @description 详情页按报单编号查询车辆报单申请表
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
	 * @createDate 2018年11月22日
	 */
	@RequestMapping(value = "findVehicleByEntry_number", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findVehicleByEntry_number(String id) throws Exception {

		int code;
		String msg;
		PostLoanManageVo result = null;
		try {
			result = liquidateManageService.findVehicleByEntry_number(id);
			if (result != null) {
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
	 * @Title: findFiduciaryByEntry_number
	 * 
	 * @description 详情页按报单编号查询信用贷款申请表
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
	 * @createDate 2018年11月22日
	 */
	@RequestMapping(value = "findFiduciaryByEntry_number", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String findFiduciaryByEntry_number(String id) throws Exception {

		int code;
		String msg;
		PostLoanManageVo result = null;
		try {
			result = liquidateManageService.findFiduciaryByEntry_number(id);

			if (result != null) {
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

}
