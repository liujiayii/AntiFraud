package com.antifraud.entity;

import java.io.Serializable;
import java.util.Date;

public class UserPopedom implements Serializable{

	/** 序列化编号 */
	private static final long serialVersionUID = 1L;
	
	/**用户权限表id*/
	private Long id;
	/**用户id*/
	private Long user_id;
	/**权限id*/
	private int popedom_id;
	/**修改时间*/
	private Date update_time;
	/**创建时间*/
	private Date create_time;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public int getPopedom_id() {
		return popedom_id;
	}
	public void setPopedom_id(int popedom_id) {
		this.popedom_id = popedom_id;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "UserPopedom [id=" + id + ", user_id=" + user_id + ", popedom_id=" + popedom_id + ", update_time="
				+ update_time + ", create_time=" + create_time + "]";
	}
	
	
	
		
}
