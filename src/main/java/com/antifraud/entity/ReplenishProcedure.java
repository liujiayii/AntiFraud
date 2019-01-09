package com.antifraud.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 
 *
 * @ClassName: ReplenishProcedure

 * @description 补充手续表
 *
 * @author yaozijun
 * @createDate 2018年9月25日
 */
public class ReplenishProcedure {
	
	/* 主键ID */
	private Long id;
	
	/* 报单编号 */
	private String report_id;
	
	/* 风控人员id */
	private Long user_id;
	
	/* 补充时间 */
	private Date replenish_time;
	
	/* 备注 */
	private String remark ;
	
	/* 创建时间 */
	private java.util.Date create_time;
	
	/* 修改时间 */
	private java.util.Date update_time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReport_id() {
		return report_id;
	}

	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Date getReplenish_time() {
		return replenish_time;
	}

	public void setReplenish_time(Date replenish_time) {
		this.replenish_time = replenish_time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public java.util.Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(java.util.Date now_time) {
		this.create_time = now_time;
	}

	public java.util.Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(java.util.Date now_time) {
		this.update_time = now_time;
	}

	@Override
	public String toString() {
		return "ReplenishProcedure [id=" + id + ", report_id=" + report_id + ", user_id=" + user_id
				+ ", replenish_time=" + replenish_time + ", remark=" + remark + ", create_time=" + create_time
				+ ", update_time=" + update_time + "]";
	}

	
	
	
	
	
	
}
