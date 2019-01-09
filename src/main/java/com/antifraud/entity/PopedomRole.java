package com.antifraud.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @ClassName: PopedomRole

 * @description 角色功能表
 *
 * @author LiuHangjing
 * @createDate 2018年9月26日下午4:29:39
 */
public class PopedomRole implements Serializable{

	private static final long serialVersionUID = 1L;
	/** 编号*/
	private Long id;
	/** 角色表id*/
	private Long role_id;
	/** 功能id*/
	private Long popedom_id;
	/** 状态(1 可用  2不可用)*/
	private int status;
	/** 创建时间*/
	private Date create_time;
	/** 修改时间*/
	private Date update_time;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public Long getPopedom_id() {
		return popedom_id;
	}
	public void setPopedom_id(Long popedom_id) {
		this.popedom_id = popedom_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
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
	@Override
	public String toString() {
		return "PopedomRole [id=" + id + ", role_id=" + role_id + ", popedom_id=" + popedom_id + ", status=" + status
				+ ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	
	
}
