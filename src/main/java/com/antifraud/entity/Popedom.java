package com.antifraud.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @ClassName: Popedom

 * @description 功能表
 *
 * @author LiuHangjing
 * @createDate 2018年9月26日下午4:25:07
 */
public class Popedom implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 编号*/
	private Long id;
	/** 权限名称*/
	private String popedom_name;
	/** 权限id*/
	private int pid;
	/** 功能路径 action*/
	private String popedom_url;
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
	public String getPopedom_name() {
		return popedom_name;
	}
	public void setPopedom_name(String popedom_name) {
		this.popedom_name = popedom_name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPopedom_url() {
		return popedom_url;
	}
	public void setPopedom_url(String popedom_url) {
		this.popedom_url = popedom_url;
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
		return "Popedom [id=" + id + ", popedom_name=" + popedom_name + ", pid=" + pid + ", popedom_url=" + popedom_url
				+ ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	
	
}
