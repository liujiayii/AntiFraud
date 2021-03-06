package com.antifraud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antifraud.entity.QuestionTopic;
import com.antifraud.service.QuestionTopicService;
import com.antifraud.utils.JsonUtil;

/**
 * 
 *
 * @ClassName: QuestionTopicController
 * @description 面审随机出题
 * @author qixiyao
 * @createDate 2018年10月17日-上午9:51:19
 */
@Controller
@RequestMapping("/QuestionTopic")
public class QuestionTopicController {
	
	private Logger logger = Logger.getLogger(QuestionTopicController.class);
	
	@Autowired
	private QuestionTopicService questionTopicService;
	
	int code = 1;
	String msg = "成功！";
	
	/**
	 * 
	 * @Title: addQuestion
	 * @description 面审随机出题的添加问题
	 * @param @return  
	 * @return Map<String,Object>    
	 * @author qixiyao
	 * @createDate 2018年10月17日-上午9:47:01
	 */
	@ResponseBody
	@RequestMapping("/addQuestion")
	public String addQuestion(QuestionTopic questionTopic){
		int code = 0;
		String msg = null;
		int result = 0;
		
		try {
			result = questionTopicService.addQuestion(questionTopic);
			
			if (result > 0) {
				code = 1;
				msg = "添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e);
			code = -1;
			msg = "系统异常";
		}
		
		return JsonUtil.getResponseJson(code, msg, null, result);
	}
	
	/**
	 * 随机生成问题
	 *
	 * @Title: findListRandom
	
	 * @description 
	 *
	 * @param @return 
	   
	 * @return String    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月26日-下午4:21:04
	 */
	@RequestMapping(value="findListRandom", produces="application/json; charset=utf-8")
	@ResponseBody
	public String findListRandom() {
		List<QuestionTopic> questionTopicList = new ArrayList<>();
		List<QuestionTopic> findAll = null;
		/** 创建随机数对象，随机生成10个数 */
		Random r = new Random();
		/** 生成问题的总数 */
		int count = 10;
		try {
			/** 查询所有问题 */
			findAll = questionTopicService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			code = -1;
			msg = "系统异常！";
			logger.error(msg);
		}
		for (int i = 0; i < count; i++) {
			questionTopicList.add(findAll.get(r.nextInt(10)));
		}
		
		return JsonUtil.getResponseJson(code, msg, count, questionTopicList);
	}
	
	
}
