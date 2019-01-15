package com.antifraud.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 
* @ClassName: LoanInformation
* @Description: TODO
* @author lichangchun
* @date 2019年1月10日
*
 */
public class LoanInformation {

  /*主键id*/	
  private Long id;
  /*标号*/
  private Long bidId;
  /*报单编号*/
  private String entry_number;
  /*姓名*/
  private String realName;
  /*电话*/
  private String mobile;
  /*当前期数*/
  private int period;
  /*总期数*/
  private int total_period;
  /*还款金额*/
  private  BigDecimal amount;
  /*是否逾期*/
  private int is_overdue;
  /*创建时间*/
  private Timestamp createTime;
  /*还款时间*/
  private String repayment_time;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Long getBidId() {
	return bidId;
}
public void setBidId(Long bidId) {
	this.bidId = bidId;
}
public String getEntry_number() {
	return entry_number;
}
public void setEntry_number(String entry_number) {
	this.entry_number = entry_number;
}

public String getRealName() {
	return realName;
}
public void setRealName(String realName) {
	this.realName = realName;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public int getPeriod() {
	return period;
}
public void setPeriod(int period) {
	this.period = period;
}
public int getTotal_period() {
	return total_period;
}
public void setTotal_period(int total_period) {
	this.total_period = total_period;
}
public BigDecimal getAmount() {
	return amount;
}
public void setAmount(BigDecimal amount) {
	this.amount = amount;
}
public int getIs_overdue() {
	return is_overdue;
}
public void setIs_overdue(int is_overdue) {
	this.is_overdue = is_overdue;
}
public Timestamp getCreateTime() {
	return createTime;
}
public void setCreateTime(Timestamp createTime) {
	this.createTime = createTime;
}

public String getRepayment_time() {
	return repayment_time;
}
public void setRepayment_time(String repayment_time) {
	this.repayment_time = repayment_time;
}
@Override
public String toString() {
	return "LoanInformation [id=" + id + ", bidId=" + bidId + ", entry_number=" + entry_number + ", realName="
			+ realName + ", mobile=" + mobile + ", period=" + period + ", total_period=" + total_period + ", amount="
			+ amount + ", is_overdue=" + is_overdue + ", createTime=" + createTime + ", repayment_time="
			+ repayment_time + "]";
}

}
