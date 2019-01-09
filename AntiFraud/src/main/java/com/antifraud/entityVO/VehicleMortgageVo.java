package com.antifraud.entityVO;

import com.antifraud.entity.VehicleMortgage;

/**
 * 车辆抵押扩展类
 *
 * @ClassName: FiduciaryLoanVo
 * @description 
 *
 * @author lujinpeng
 * @createDate 2018年11月2日-下午2:41:46
 */
public class VehicleMortgageVo extends VehicleMortgage {
	/** 报单编号 */
	private String report_id;
	/** 图片路径 */
	private String img_url;
	/** 图片类型 */
	private String img_format;
	/** 1身份证，2房本，3车，4驾驶证 */
	private Byte bussness_type;
	
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
	public Byte getBussness_type() {
		return bussness_type;
	}
	public void setBussness_type(Byte bussness_type) {
		this.bussness_type = bussness_type;
	}
	
}
