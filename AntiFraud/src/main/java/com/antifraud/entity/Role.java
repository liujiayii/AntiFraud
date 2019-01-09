package com.antifraud.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @ClassName: Role

 * @description 角色表
 *
 * @author LiuHangjing
 * @createDate 2018年9月26日下午4:22:22
 */
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 编号*/
	private Long id;
	/** 角色名称*/
	private String role_name;
	/** 创建时间*/
	private Date create_time;
	/** 角色关键字用于角色控制*/
	private String key_word;
	/** 修改时间*/
	private Date update_time;
	public String getKey_word() {
		return key_word;
	}
	public void setKey_word(String key_word) {
		this.key_word = key_word;
	}
	/** 角色关联表字段*/
	private Long c_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
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
	public Long getC_id() {
		return c_id;
	}
	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", role_name=" + role_name + ", create_time=" + create_time + ", update_time="
				+ update_time + ", c_id=" + c_id + "]";
	}
	
}
