package com.antifraud.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 *
 * @ClassName: User

 * @description 用户表实体
 *
 * @author LiuHangjing
 * @createDate 2018年9月26日下午3:15:36
 */
public class User implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 编号*/
	private Long id;
	/** 姓名*/
	private String name;
	/** 手机号*/
	private String phone;
	/** 职位 */
	private String post;
	/** 用户名*/
	private String user_name;
	/** 账号状态值*/
	private int status;
	/** 地区*/
	private String address;
	/** 密码*/
	private String user_pwd;
	/** 创建时间*/
	private Date create_time;
	/** 修改时间*/
	private Date update_time;
	/** 用户关联表字段*/
	private Long p_id;
	/** 用于储存用户人脸图片*/
	private String img_url;
	/** 用于shiro权限管理*/
	private String key_word;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
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
	public Long getP_id() {
		return p_id;
	}
	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getKey_word() {
		return key_word;
	}
	public void setKey_word(String key_word) {
		this.key_word = key_word;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", post=" + post + ", user_name=" + user_name
				+ ", status=" + status + ", address=" + address + ", user_pwd=" + user_pwd + ", create_time="
				+ create_time + ", update_time=" + update_time + ", p_id=" + p_id + ", img_url=" + img_url
				+ ", key_word=" + key_word + "]";
	}
	
}	
