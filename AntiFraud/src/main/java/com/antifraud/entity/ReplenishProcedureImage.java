package com.antifraud.entity;

import java.util.Date;

import java.sql.Timestamp;
/**
 * 
 *
 * @ClassName: ReplenishProcedureImage

 * @description 补充手续图片表
 *
 * @author yaozijun
 * @createDate 2018年9月25日
 */
public class ReplenishProcedureImage {

	/* 主键ID */
	private Long id;
	
	/* 报单编号 */
	private String report_id;
	
	/* 图片路径 */
	private String img_url;
	
	/* 图片格式 */
	private String img_format;
	
	/* 创建时间 */
	private Date create_time;
	
	/* 修改时间 */
	private Date update_time;

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

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getImg_format() {
		return img_format;
	}

	public void setImg_format(String img_format) {
		this.img_format = img_format;
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
		return "ReplenishProcedureImage [id=" + id + ", report_id=" + report_id + ", img_url=" + img_url
				+ ", img_format=" + img_format + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}

	

	
	
	
}
