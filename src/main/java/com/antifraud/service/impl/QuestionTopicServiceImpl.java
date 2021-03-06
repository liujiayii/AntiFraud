package com.antifraud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antifraud.dao.QuestionTopicDao;
import com.antifraud.entity.QuestionTopic;
import com.antifraud.service.QuestionTopicService;
/**
 * 
 *
 * @ClassName: QuestionTopicServiceImpl
 * @description 添加问题service的实现类
 * @author qixiyao
 * @createDate 2018年10月16日-下午3:43:26
 */
@Service
public class QuestionTopicServiceImpl implements QuestionTopicService {

	@Autowired
	private QuestionTopicDao questionTopicDao;
	@Override
	public int addQuestion(QuestionTopic questionTopic) {
		
		return questionTopicDao.addQuestion(questionTopic);
	}
	
	/**
	 * 通过id查询
	 */
	@Override
	public QuestionTopic findById(Long id) throws Exception {
		
		return questionTopicDao.findById(id);
	}
	
	/**
	 * 查询所有
	 */
	@Override
	public List<QuestionTopic> findAll() throws Exception {

		return questionTopicDao.findAll();
	}
}
