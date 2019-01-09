package com.antifraud.entity;

import java.util.Date;

/**
 * 
 *
 * @ClassName: Spot_image

 * @description 实地图片表，存放实地的图片一对多
 *
 * @author LiuHangjing
 * @createDate 2018年10月22日下午5:48:56
 */
public class Spot_image {
	/** 主键 */
	private Long id;
	
	/** 实地表主键 */
	private String report_id;
	
	/** 图片路径 */
	private String img_url;
	
	/** 图片格式  */
	private String img_format;
	
	/** 创建时间 */
	private Date create_time;
	
	/** 修改时间  */
	private Date update_time;

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getReport_id() {
		return report_id;
	}


	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}


	@Override
	public String toString() {
		return "Spot_image [id=" + id + ", report_id=" + report_id + ", img_url=" + img_url + ", img_format="
				+ img_format + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}


	
	
}
