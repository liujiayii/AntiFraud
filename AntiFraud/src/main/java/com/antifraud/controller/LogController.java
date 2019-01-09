package com.antifraud.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antifraud.entity.Log;
import com.antifraud.entity.User;
import com.antifraud.service.LogService;
import com.antifraud.utils.JsonUtil;
/**
 * 
  * @ClassName: LogController
  * @description 日志
  * @author caoyaru
  * @createDate 2018年12月12日-上午9:33:02
 */
@Controller
@RequestMapping("Log")
public class LogController {
	@Autowired
	private LogService logService;
	
	int code = 1;
	String msg = "成功";
	/**
	 * 
	  * @Title: showLog
	  * @description 显示操作人日志
	  * @param @return 
	  * @return String    
	  * @author caoyaru
	  * @createDate 2018年12月12日-上午9:33:13
	 */
	@ResponseBody
	@RequestMapping(value = "/showLog" , produces = "application/json; charset=utf-8")
	public String showLog( Integer page, Integer limit){
		//查询当前登陆人
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		Log log = new Log();
		if (page == null || page <= 0) {
			page = 1;
		}
		page = (page - 1) * limit;
		try {
			System.out.println("用户ID+++++++++++++++？"+user.getId());
			List<Log> listLog = logService.findById( page, limit);
			System.out.println(listLog.toString());
			return JsonUtil.getResponseJson(code, msg, logService.getCount(), listLog);
		} catch (Exception e) {
			e.printStackTrace();
			int code = -1;
			String msg = "失败";
			return JsonUtil.getResponseJson(code, msg, null, null);
		}
	}
}
