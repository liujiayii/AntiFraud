package com.antifraud.entityVO;

import com.antifraud.entity.RecordManageBorrow;
/**
 * 档案管理借表扩展类
 *
 * @ClassName: RecordManagerBorrowVo
 * @description 
 *
 * @author lujinpeng
 * @createDate 2018年10月31日-下午2:13:17
 */
public class RecordManagerBorrowVo extends RecordManageBorrow {

	/** 抵押人姓名 */
	private String name;
	/** 抵押人电话 */
	private String phone;
	/** 业务类型（0 房产抵押，1 车辆抵押，2 信用借贷） */
	private Integer business_type;
	
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
	public Integer getBusiness_type() {
		return business_type;
	}
	public void setBusiness_type(Integer business_type) {
		this.business_type = business_type;
	}
	
}
