package com.antifraud.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.Photo;
import com.antifraud.entity.User;
import com.antifraud.entityVO.FklistVo;
import com.antifraud.service.FiduciaryLoanService;
import com.antifraud.service.HousePropertyMortgageService;
import com.antifraud.service.PhotoService;
import com.antifraud.service.VehicleMortgageService;
import com.antifraud.utils.DesUtil;
import com.antifraud.utils.HttpClientUtil;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@Controller
public class FklistController extends HttpClientUtil {

	@Resource
	private HousePropertyMortgageService housePropertyMortgageService;
	@Autowired
	private FiduciaryLoanService fiduciaryLoanService;
	@Autowired
	private VehicleMortgageService vehicleMortgageService;
	@Autowired
	private PhotoService photoService;
	
	/**
	 * 航静
	 */
	@ResponseBody
	@RequestMapping(value = "/maplist" , produces = "application/json; charset=utf-8")
	public String maplist(HttpServletRequest request, HttpServletResponse resp) throws UnsupportedEncodingException {
		System.out.println("456");
		System.getProperty("file.encoding");// 获取java环境默认编码
		System.setProperty("file.encoding", "utf-8");// 设置java环境默认编码
		request.getCharacterEncoding();// JSP获取客户端请求的编码
		request.setCharacterEncoding("utf-8");// JSP设置客户端请求的编码

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		List<FklistVo> FklistVoList = null;
		List<FklistVo> FklistVoListone = null;
		List<FklistVo> FklistVoListtwo = null;
		List<FklistVo> FklistVoListAll = new ArrayList<>();
	    String entry_number = "FW000000001";
	    try {
			FklistVoList = housePropertyMortgageService.findListAlls(entry_number);
			FklistVoListone = fiduciaryLoanService.findListAlls(entry_number);
			FklistVoListtwo = vehicleMortgageService.findListAlls(entry_number);
			if (FklistVoList != null && FklistVoList.size() != 0) {
				FklistVoListAll.addAll(FklistVoList);
			}
			if (FklistVoListone != null && FklistVoListone.size() == 0) {
				FklistVoListAll.addAll(FklistVoListone);
			}
			if (FklistVoListtwo != null && FklistVoListtwo.size() == 0) {
				FklistVoListAll.addAll(FklistVoListtwo);
			}
			List<Photo> queryImage = photoService.queryImage(entry_number);
			//String path = JSONObject.toJSONString(queryImage);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data", FklistVoListAll);
			jsonObject.put("queryImage", queryImage);
			System.out.println(jsonObject.toString());
            Map<String , Object> map2 = new HashMap<String , Object>();
			map2.put("params", jsonObject.toString());
			System.out.println("map2"+map2);
			String code = HttpClientUtil.doPost("http://192.168.1.101:8001/supervisor/risk/SuperAntiCtrl/receiveInfo",map2);
			System.out.println(code);
			return code;
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}
	
	/**
	 * 韩
	 */

	@ResponseBody
	@RequestMapping(value = "/maplistss" , produces = "application/json; charset=utf-8")
	public String maplistss(HttpServletRequest request, HttpServletResponse resp) throws UnsupportedEncodingException {
		System.out.println("456");
		System.getProperty("file.encoding");// 获取java环境默认编码
		System.setProperty("file.encoding", "utf-8");// 设置java环境默认编码
		request.getCharacterEncoding();// JSP获取客户端请求的编码
		request.setCharacterEncoding("utf-8");// JSP设置客户端请求的编码

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		List<FklistVo> FklistVoList = null;
		List<FklistVo> FklistVoListone = null;
		List<FklistVo> FklistVoListtwo = null;
		List<FklistVo> FklistVoListAll = new ArrayList<>();
	    String entry_number = "FW000000001";
	    try {
			FklistVoList = housePropertyMortgageService.findListAlls(entry_number);
			FklistVoListone = fiduciaryLoanService.findListAlls(entry_number);
			FklistVoListtwo = vehicleMortgageService.findListAlls(entry_number);
			if (FklistVoList != null && FklistVoList.size() != 0) {
				FklistVoListAll.addAll(FklistVoList);
			}
			if (FklistVoListone != null && FklistVoListone.size() == 0) {
				FklistVoListAll.addAll(FklistVoListone);
			}
			if (FklistVoListtwo != null && FklistVoListtwo.size() == 0) {
				FklistVoListAll.addAll(FklistVoListtwo);
			}
			List<Photo> queryImage = photoService.queryImage(entry_number);
			//String path = JSONObject.toJSONString(queryImage);
			JSONObject jsonObject = new JSONObject();
			 String substring = entry_number.substring(0,2);
	            System.out.println("保单编号前两个字符---------"+substring);
	            //根据报单编号查询内勤ID，根据内勤ID查询当前操作人的姓名
	            if(substring.equals("FW")){
	            	//房屋操作人
	               User managementName = housePropertyMortgageService.selectManagement(entry_number);
	            	jsonObject.put("managementName", managementName.getName());
	            	System.out.println("当前操作人=============>"+managementName.getName());
	            }else if(substring.equals("CL")){
	            	//车辆操作人
	            	User managementName = vehicleMortgageService.selectManagement(entry_number);
	            	jsonObject.put("managementName", managementName.getName());
	            	System.out.println("当前操作人=============>"+managementName.getName());
	            }else if(substring.equals("XY")){
	            	//信贷操作人
	            	User managementName = fiduciaryLoanService.selectManagement(entry_number);
	            	jsonObject.put("managementName", managementName.getName());
	            	System.out.println("当前操作人=============>"+managementName.getName());
				}
	            
			jsonObject.put("data", FklistVoListAll);
			jsonObject.put("queryImage", queryImage);
			System.out.println(jsonObject.toString());
			String jobStr =DesUtil.encode("yunquekj", jsonObject.toString());
            Map<String , Object> map2 = new HashMap<String , Object>();
			map2.put("params", jobStr);
			
			System.out.println("map2"+map2);
            String code = HttpClientUtil.doPost("http://192.168.1.102:8001/supervisor/risk/SuperAntiCtrl/receiveInfo",map2);
			System.out.println(code);
			
			return code;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
        }

	}

	
	
}
