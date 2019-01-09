package com.antifraud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.antifraud.utils.AcceptUntils;
import com.antifraud.utils.HttpClientUtil;
import com.antifraud.utils.JsonUtil;

/**
 * 贷后管理
 *
 * @ClassName: AcceptController
 * 
 * @description
 *
 * @author lisaozhang
 * @createDate 2018年12月17日-上午11:23:02
 */
@Controller
@RequestMapping("AcceptController")
public class AcceptController {

	@RequestMapping("Accept")
	@ResponseBody
	public static Object loadJson(int page, int limit) {

		Map<Object, Object> map = new HashMap<>();

		ArrayList<Object> arrayList = new ArrayList<>();

		JSONArray jsonArray = new JSONArray();
		String loadJson = null;
		try {
			loadJson = AcceptUntils.loadJson("www.ouyepuhui.com/loanTrack");
			System.out.println("loadJson" + loadJson);
		} catch (Exception e) {
			map.put("code", -1);
			map.put("msg", "数据获取异常");
			map.put("data", arrayList);
			map.put("count", 0);

			return JSONObject.toJSON(map);
		}
		try {
			loadJson = loadJson.substring(loadJson.indexOf("["), loadJson.lastIndexOf("]") + 1);
		} catch (Exception e) {
			map.put("code", 1);
			map.put("msg", "数据获取异常");
			map.put("data", null);
			map.put("count", 0);
			return map;
		}

		// System.out.println(loadJson);
		JSONArray json = (JSONArray) JSONArray.parse(loadJson);

		try {
			int star = (page - 1) * limit;
			for (int i = star; i < star + limit; i++) {
				if (i == json.size()) {
					break;
				}
				arrayList.add(json.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("code", 1);
		map.put("msg", "查询成功");
		map.put("data", arrayList);
		map.put("count", json.size());

		return JSONObject.toJSON(map);
	}

	/**
	 * 通过电话搜索
	 *
	 * @Title: findByPhone
	 * 
	 * @description
	 * 
	 * @description
	 *
	 * @param phone
	 *            电话号码
	 * @param page
	 *            当前页数
	 * @param limit
	 *            每页显示条数
	 * @param @return
	 * 
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2018年12月18日-上午11:37:14
	 */
	@RequestMapping(value = "findByPhone", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findByPhone(String phone, Integer page, Integer limit) {
		int code = 1;
		String msg = "成功";
		int count = 0;
		String data = null;
		JSONArray array = null;
		ArrayList<Object> arrayList = new ArrayList<>();
		try {
			data = HttpClientUtil.doGet("www.ouyepuhui.com/loanMobile?mobile=" + phone);
			JSONObject obj = JSON.parseObject(data);
			array = obj.getJSONArray("pagemobile");
			count = array.size();
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		/** 处理数据分页 */
		try {
			int star = (page - 1) * limit;
			for (int i = star; i < star + limit; i++) {
				if (i == array.size()) {
					break;
				}
				arrayList.add(array.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return JsonUtil.getResponseJson(code, msg, count, arrayList);
	}

	/**
	 * 查询是否逾期数据
	 *
	 * @Title: findLoanOverdue
	 * 
	 * @description
	 *
	 * @param is_overdue
	 *            是否逾期（0非逾期 ,1 逾期）
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页显示条数
	 * @param @return
	 * 
	 * @return String
	 *
	 * @author lujinpeng
	 * @createDate 2018年12月18日-上午11:34:54
	 */
	@RequestMapping(value = "findLoanOverdue", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findLoanOverdue(int is_overdue, Integer page, Integer limit) {
		int code = 1;
		String msg = "成功";
		int count = 0;
		String data = null;
		JSONArray array = null;
		ArrayList<Object> arrayList = new ArrayList<>();

		try {
			data = HttpClientUtil.doGet("www.ouyepuhui.com/loanOverdue?is_overdue=" + is_overdue);
			JSONObject obj = JSON.parseObject(data);
			array = obj.getJSONArray("pageoverdue");
			count = array.size();
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		/** 处理数据分页 */
		try {
			int star = (page - 1) * limit;
			for (int i = star; i < star + limit; i++) {
				if (i == array.size()) {
					break;
				}
				arrayList.add(array.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return JsonUtil.getResponseJson(code, msg, count, arrayList);
	}

}
