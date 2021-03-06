package com.antifraud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antifraud.dao.QuestionAnswerDao;
import com.antifraud.entity.QuestionAnswer;
import com.antifraud.service.QuestionAnswerService;
/**
 * 
 *
 * @ClassName: QuestionAnswerServiceImpl
 * @description 添加答案的service实现类
 * @author qixiyao
 * @createDate 2018年10月16日-下午3:48:56
 */
@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

	@Autowired
	private QuestionAnswerDao questionAnswerDao;

	@Override
	public int addAnswer(QuestionAnswer questionAnswer) {
		
		return questionAnswerDao.addAnswer(questionAnswer);
	}

	/**
	 * 通过关联题目表id查询
	 */
	@Override
	public QuestionAnswer findByTopicId(Long topic_id) throws Exception {
		
		return questionAnswerDao.findByTopicId(topic_id);
	}
	
}
