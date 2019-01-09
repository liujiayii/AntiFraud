package com.antifraud.entity;

import java.util.Date;

/**
 * 
 *
 * @ClassName: ReplenishProcedure

 * @description 签合同
 *
 * @author lishaozhang
 * @createDate 2018年9月25日
 */
public class Compact {
	
	//主键
    private long id;
    //报单编号
    private String report_id;
    //图片路径
    private String img_url;
    //图片格式
    private String img_format;
    //风控人员id
    private long user_id;
    //备注
    private String remark;
    //创建时间
    private Date create_time;
    //修改时间
    private Date update_time;
    //合同编号
    private String contract_id;
   
    
	public Compact() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public long getId() {
		return id;
	}



	public void setId(long id) {
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



	public long getUser_id() {
		return user_id;
	}



	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
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



	public String getContract_id() {
		return contract_id;
	}



	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}



	@Override
	public String toString() {
		return "Compact [id=" + id + ", report_id=" + report_id + ", img_url=" + img_url + ", img_format=" + img_format
				+ ", user_id=" + user_id + ", remark=" + remark + ", create_time=" + create_time + ", update_time="
				+ update_time + "]";
	}
    
}
