package com.antifraud.dao;

import com.antifraud.entity.QuestionAnswer;

/**
 * 
 *
 * @ClassName: QuestionAnswerDao
 * @description 添加答案
 * @author qixiyao
 * @createDate 2018年10月16日-下午3:45:49
 */
public interface QuestionAnswerDao {

	/**
	 * 
	 * @Title: addAnswer
	 * @description 答案表的DAO
	 * @param   
	 * @return void    
	 * @author qixiyao
	 * @createDate 2018年10月16日-下午3:45:34
	 */
	public int addAnswer(QuestionAnswer questionAnswer);
	
	/**
	 * 通过关联题目表id查询
	 *
	 * @Title: findByTopicId
	
	 * @description 
	 *
	 * @param topic_id 关联题目表id
	 * @param @return
	 * @param @throws Exception 
	   
	 * @return QuestionAnswer    
	 *
	 * @author lujinpeng
	 * @createDate 2018年11月26日-上午10:57:05
	 */
	QuestionAnswer findByTopicId (Long topic_id) throws Exception;
	
	
	
	
	
	
	
	
	
}
