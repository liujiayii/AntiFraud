package com.antifraud.dao;

import java.util.List;

import com.antifraud.entity.QuestionTopic;

public interface QuestionTopicDao {
	/**
	 * 
	 * @Title: insertQuestion
	 * @description 添加问题的方法
	 * @param   
	 * @return void    
	 * @author qixiyao
	 * @createDate 2018年10月16日-下午3:26:39
	 */
	public int addQuestion(QuestionTopic questionTopic);
	
	/**
	 * 通过id查询
	 *
	 * @Title: findById
	
	 * @description 
	 *
	 * @param id 问题表id
	 * @param @return
	 * @param @throws Exception 
	   
	 * @return QuestionTopic    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月26日-上午10:53:30
	 */
	QuestionTopic findById (Long id) throws Exception;
	
	/**
	 * 查询所有题目
	 *
	 * @Title: findAll
	
	 * @description 
	 *
	 * @param @return
	 * @param @throws Exception 
	   
	 * @return List<QuestionTopic>    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月26日-上午11:09:35
	 */
	List<QuestionTopic> findAll() throws Exception;
}
