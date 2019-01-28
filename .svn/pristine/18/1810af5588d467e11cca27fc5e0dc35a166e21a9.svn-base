package com.antifraud.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antifraud.service.FiduciaryLoanService;
import com.antifraud.service.HousePropertyMortgageService;
import com.antifraud.service.VehicleMortgageService;

/**
  * @ClassName: IndexController
  * @description 风控主页根据日期查询数据单独写了个控制器
  * @author ZhaoSong
  * @createDate 2019年1月23日
 */
@Controller
public class IndexController {

	@Autowired
	private HousePropertyMortgageService housePropertyMortgageService;
	@Autowired
	private FiduciaryLoanService fiduciaryLoanService;
	@Autowired
	private VehicleMortgageService vehicleMortgageService;

	
	
	
	/**
	  * @Title: findByDate
	  * @description 根据日期条件查询主页面数据
	  * @param @param date 日期字符串
	  * @return Map<String,Object> 返回查询结果
	  * @author ZhaoSong
	  * @createDate 2019年1月23日
	 */
	@RequestMapping("/findByDay")
	@ResponseBody
	public Map<String, Object> findByDate(String date) {
		BigDecimal houseSum = new BigDecimal(0.00);
		BigDecimal carSum = new BigDecimal(0.00);
		BigDecimal xinSum = new BigDecimal(0.00);
		BigDecimal sum = new BigDecimal(0.00);
		Integer houseCount = 0;
		Integer carCount = 0;
		Integer xinCount = 0;
		Integer amount = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String[] d = date.split("-");
			if (d.length == 1) {// 查询某年
				if (housePropertyMortgageService.findByDate(d[0], null, null) != null) {
					houseSum = housePropertyMortgageService.findByDate(d[0], null, null);
				}
				houseCount = housePropertyMortgageService.findByCount(d[0], null, null);
				if (vehicleMortgageService.findByDate(d[0], null, null) != null) {
					carSum = vehicleMortgageService.findByDate(d[0], null, null);
				}
				carCount = vehicleMortgageService.findByCount(d[0], null, null);
				if (fiduciaryLoanService.findByDate(d[0], null, null) != null) {
					xinSum = fiduciaryLoanService.findByDate(d[0], null, null);
				}
				xinCount = fiduciaryLoanService.findByCount(d[0], null, null);
				amount = houseCount + carCount + xinCount;
				sum = houseSum.add(carSum).add(xinSum);

			}

			if (d.length == 2) {// 查询某年某月
				if (housePropertyMortgageService.findByDate(d[0], d[1], null) != null) {
					houseSum = housePropertyMortgageService.findByDate(d[0], d[1], null);
				}
				houseCount = housePropertyMortgageService.findByCount(d[0], d[1], null);
				if (vehicleMortgageService.findByDate(d[0], d[1], null) != null) {
					carSum = vehicleMortgageService.findByDate(d[0], d[1], null);
				}
				carCount = vehicleMortgageService.findByCount(d[0], d[1], null);
				if (fiduciaryLoanService.findByDate(d[0], d[1], null) != null) {
					xinSum = fiduciaryLoanService.findByDate(d[0], d[1], null);
				}
				xinCount = fiduciaryLoanService.findByCount(d[0], d[1], null);
				sum = houseSum.add(carSum).add(xinSum);
				amount = houseCount + carCount + xinCount;

			}

			if (d.length == 3) {// 查询某年某月某日
				if (housePropertyMortgageService.findByDate(d[0], d[1], d[2]) != null) {
					houseSum = housePropertyMortgageService.findByDate(d[0], d[1], d[2]);
				}
				houseCount = housePropertyMortgageService.findByCount(d[0], d[1], d[2]);
				if (vehicleMortgageService.findByDate(d[0], d[1], d[2]) != null) {
					carSum = vehicleMortgageService.findByDate(d[0], d[1], d[2]);
				}
				carCount = vehicleMortgageService.findByCount(d[0], d[1], d[2]);
				if (fiduciaryLoanService.findByDate(d[0], d[1], d[2]) != null) {
					xinSum = fiduciaryLoanService.findByDate(d[0], d[1], d[2]);
				}
				xinCount = fiduciaryLoanService.findByCount(d[0], d[1], d[2]);
				sum = houseSum.add(carSum).add(xinSum);
				amount = houseCount + carCount + xinCount;
			}
			map.put("houseSum", houseSum);
			map.put("houseCount", houseCount);
			map.put("carSum", carSum);
			map.put("carCount", carCount);
			map.put("xinSum", xinSum);
			map.put("xinCount", xinCount);
			map.put("sum", sum);
			map.put("amount", amount);
			map.put("code", 1);

		} catch (Exception e) {
			map.put("code", -1);
			map.put("msg", "系统异常！");
		}

		return map;
	}

}
