package com.antifraud.entity;

import java.util.Date;

/**
 * 
 *
 * @ClassName: QuestionTopic
 * @description 题库题目表
 * @author qixiyao
 * @createDate 2018年10月16日-下午3:11:53
 */
public class QuestionTopic {
	/** 主键 */
	private Long id;
	/** 题目 */
	private String topic;
	/** 类型 */
	private Integer status;
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
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
