/*package com.antifraud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antifraud.entity.THousePropertyMortgage;
import com.antifraud.entity.TRecordManageBorrow;
import com.antifraud.entity.TRecordManageSave;
import com.antifraud.service.TRecordManageService;
import com.antifraud.utils.ResultInfo;

*//**
 * @ClassName: TRecordManageController

 * @description 档案管理控制器
 *
 * @author zhangkai
 *//*
@Controller
@RequestMapping("/tRecordManage")
@SuppressWarnings("all")
public class TRecordManageController {
	
	@Autowired
	TRecordManageService tRecordManageService;
	
	*//**
	 * 
	 * @Title: saveTRecord
	 * @description 存档
	 *
	 * @param TRecordManageSave
	 * @return ResultInfo  
	 *//*
	@RequestMapping(value="/saveTRecord")
	@ResponseBody
	public ResultInfo saveTRecord(TRecordManageSave tRecordManageSave){
		ResultInfo result = new ResultInfo();
		try {
			int row = tRecordManageService.saveTRecord(tRecordManageSave);
			if(row>=1){
				System.out.println("存档成功");
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
	*//**
	 * 
	 * @Title: destroyTRecord
	 * @description 销档
	 *
	 * @param TRecordManageSave
	 * @return ResultInfo  
	 *//*
	@RequestMapping(value="/saveTRecord")
	@ResponseBody
	public ResultInfo destroyTRecord(TRecordManageSave tRecordManageSave){
		ResultInfo result = new ResultInfo();
		try {
			int row = tRecordManageService.destroyTRecord(tRecordManageSave);
			if(row>=1){
				System.out.println("销档成功");
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
	*//**
	 * 
	 * @Title: saveTRecordBorrow
	 * @description 借阅
	 *
	 * @param tRecordManageBorrow
	 * @return ResultInfo  
	 *//*
	@RequestMapping(value="/saveTRecordBorrow")
	@ResponseBody
	public ResultInfo destroyTRecord(TRecordManageBorrow tRecordManageBorrow){
		ResultInfo result = new ResultInfo();
		try {
			int row = tRecordManageService.saveTRecordBorrow(tRecordManageBorrow);
			if(row>=1){
				System.out.println("借阅成功");
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
	*//**
	 * 
	 * @Title: saveTRecordBorrow
	 * @description 归还
	 *
	 * @param tRecordManageBorrow
	 * @return ResultInfo  
	 *//*
	
	@RequestMapping(value="/rebackTRecord")
	@ResponseBody
	public ResultInfo rebackTRecord(TRecordManageBorrow tRecordManageBorrow){
		ResultInfo result = new ResultInfo();
		try {
			int row = tRecordManageService.rebackTRecord(tRecordManageBorrow);
			if(row>=1){
				System.out.println("归还成功");
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
	*//**
	 * 
	 * @Title: selectContractedHouse
	 * @description 查询已经签合同的业务报表（房产抵押表）
	 *
	 * @param tHousePropertyMortgage
	 * @return ResultInfo
	 *//*
	@RequestMapping(value="/selectContractedHouse")
	@ResponseBody
	public ResultInfo<THousePropertyMortgage> selectContractedHouse(THousePropertyMortgage 	tHousePropertyMortgage){
		ResultInfo<THousePropertyMortgage> result = new ResultInfo<THousePropertyMortgage>();
		try {
			List<THousePropertyMortgage> tHousePropertyMortgage_list = tRecordManageService.selectContractedHouse(tHousePropertyMortgage);
			if(tHousePropertyMortgage_list!=null&&tHousePropertyMortgage_list.size()>0){
				System.out.println("查询成功");
				result.code=0;
				result.msg="successfully!";
				result.objs=tHousePropertyMortgage_list;
			}else{
				result.code=0;
				result.msg="没有符合条件的数据!";
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.code=-1;
			result.msg="error!";
		}
		return result;
	}
}
*/