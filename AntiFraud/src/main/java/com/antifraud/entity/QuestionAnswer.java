package com.antifraud.entity;

import java.util.Date;

/**
 * 
 *
 * @ClassName: QuestionAnswer
 * @description 答案表
 * @author qixiyao
 * @createDate 2018年10月16日-下午3:16:22
 */
public class QuestionAnswer {

	/** 主键 */
	private Long id;
	/** 题目id */
	private Long topic_id;
	/** 答案 */
	private String answer;
	/** 报单编号 */
	private String report_id;
	/** 创建时间 */
	private Date create_time;
	/** 修改时间 */
	private Date update_time;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(Long topic_id) {
		this.topic_id = topic_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getReport_id() {
		return report_id;
	}
	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
}
