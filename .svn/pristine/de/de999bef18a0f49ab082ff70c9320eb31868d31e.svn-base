package com.antifraud.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Ukey {

	//主键
	public Long id;
	
	//加密锁编号
	public String ukey_sn;
	
	//加密锁ID
	public String ukey_id;
	
	//增强算法密钥
	public String ukey_ckey;
	
	//加密锁绑定管理员
	public String ukey_user;
	
	//加密锁状态：0 正常，1 挂失
	public int ukey_stat;

	//创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date create_time;
	
	//修改时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date update_time;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUkey_sn() {
		return ukey_sn;
	}

	public void setUkey_sn(String ukey_sn) {
		this.ukey_sn = ukey_sn;
	}

	public String getUkey_id() {
		return ukey_id;
	}

	public void setUkey_id(String ukey_id) {
		this.ukey_id = ukey_id;
	}

	public String getUkey_ckey() {
		return ukey_ckey;
	}

	public void setUkey_ckey(String ukey_ckey) {
		this.ukey_ckey = ukey_ckey;
	}

	public String getUkey_user() {
		return ukey_user;
	}

	public void setUkey_user(String ukey_user) {
		this.ukey_user = ukey_user;
	}

	public int getUkey_stat() {
		return ukey_stat;
	}

	public void setUkey_stat(int ukey_stat) {
		this.ukey_stat = ukey_stat;
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
		return "Ukey [id=" + id + ", ukey_sn=" + ukey_sn + ", ukey_id=" + ukey_id + ", ukey_ckey=" + ukey_ckey
				+ ", ukey_user=" + ukey_user + ", ukey_stat=" + ukey_stat + ", create_time=" + create_time
				+ ", update_time=" + update_time + "]";
	}

}
