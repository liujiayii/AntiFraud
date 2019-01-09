package com.antifraud.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
  * @ClassName: Log
  * @description 日志
  * @author caoyaru
  * @createDate 2018年12月12日-上午9:33:57
 */
public class Log implements Serializable{
	
	/**  字段的含义 */
	private static final long serialVersionUID = 2458472541845333888L;

	private int id;
	
	private String content;
	
	private String admin;
	
	private String adminId;
	
	private String operation;
	
	private Date createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", content=" + content + ", admin=" + admin + ", adminId=" + adminId + ", operation="
				+ operation + ", createDate=" + createDate + "]";
	}
	
	
	

}
