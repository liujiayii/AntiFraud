package com.antifraud.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antifraud.entity.Ukey;
import com.antifraud.entity.User;
import com.antifraud.service.UkeyService;
import com.antifraud.utils.JsonUtil;
import com.antifraud.utils.UkeyUtil;

/**
 * U盾控制层
 *
 * @ClassName: UkeyController

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年1月18日-上午10:29:05
 */
@RequestMapping("/Ukey")
@RestController
public class UkeyController {
	
	@Autowired
	private UkeyService ukeyService;
	
	/**
	 * 查询所有U盾信息
	 *
	 * @Title: selectUkeyAll
	
	 * @description 
	 *
	 * @param page
	 * @param limit
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月18日-上午10:46:11
	 */
	@RequestMapping(value = "/selectUkeyAll", produces = "application/json; charset=utf-8")
	public String selectUkeyAll(Integer page, Integer limit) {
		int code = 1;
		String msg = "成功";
		int count = 0;
		if (page == null || page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		
		List<Ukey> ukeyList = null;
		try {
			ukeyList = ukeyService.findByLimit(page, limit);
			count = ukeyService.getCount();
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, count, ukeyList);
	}
	
	/**
	 * 通过id查询
	 *
	 * @Title: selectUkeyById
	
	 * @description 
	 *
	 * @param id
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月18日-上午10:52:32
	 */
	@RequestMapping(value = "/selectUkeyById", produces = "application/json; charset=utf-8")
	public String selectUkeyById(Long id) {
		int code = 1;
		String msg = "成功";
		Ukey ukey = null;
		// 获取增强算法密钥
		String ukey_ckey = UkeyUtil.toUkeySet();
		try {
			ukey = ukeyService.selectById(id);
			ukey.setUkey_ckey(ukey_ckey);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, ukey);
	}
	
	/**
	 * 通过id删除
	 *
	 * @Title: deleteUkeyById
	
	 * @description 
	 *
	 * @param id
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月18日-上午10:54:51
	 */
	@RequestMapping(value = "/deleteUkeyById", produces = "application/json; charset=utf-8")
	public String deleteUkeyById(Long id) {
		int code = 1;
		String msg = "成功";
		
		try {
			ukeyService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	/**
	 * 添加U盾
	 *
	 * @Title: insertUkey
	
	 * @description 
	 *
	 * @param ukey
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月18日-上午10:55:46
	 */
	@RequestMapping(value = "/insertUkey", produces = "application/json; charset=utf-8")
	public String insertUkey(Ukey ukey) {
		int code = 1;
		String msg = "添加成功";
		ukey.setCreate_time(new Date());
		
		try {
			Ukey uk = ukeyService.selectByUkeySn(ukey.getUkey_sn());
			
			if (uk != null) {
				msg = "该U盾已存在";
			} else {
				ukeyService.insertSelective(ukey);
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	/**
	 * 通过id修改
	 *
	 * @Title: updateUkey
	
	 * @description 
	 *
	 * @param ukey
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月18日-上午11:00:37
	 */
	@RequestMapping(value = "/updateUkey", produces = "application/json; charset=utf-8")
	public String updateUkey(Ukey ukey) {
		int code = 1;
		String msg = "设置增强密钥成功";
		ukey.setUpdate_time(new Date());
		
		try {
			ukeyService.updateByIdSelective(ukey);
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	/**
	 * 设置U盾状态
	 *
	 * @Title: updateUkeyStat
	
	 * @description 
	 *
	 * @param ukey
	 * @return 
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年1月21日-上午9:46:05
	 */
	@RequestMapping(value = "/updateUkeyStat", produces = "application/json; charset=utf-8")
	public String updateUkeyStat(Ukey ukey) {
		System.out.println(ukey);
		int code = 1;
		String msg = "";
		Ukey uk = null;
		Integer stat = null;
		ukey.setUpdate_time(new Date());
		if (ukey.getUkey_stat() == 0) {
			ukey.setUkey_stat(1);
		} else if (ukey.getUkey_stat() == 1) {
			ukey.setUkey_stat(0);
		}
		try {
			ukeyService.updateUkeyStatById(ukey);
			
			uk = ukeyService.selectById(ukey.getId());
			if (uk.getUkey_stat() == 0) {
				stat = 0;
				msg = "U盾解锁成功";
			} else {
				stat = 1;
				msg = "U盾锁定成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, stat);
	}
	

}
