package com.antifraud.entityVO;

import java.util.Date;
/**
 * 
 *
 * @ClassName: PostLoanManageVo

 * @description 贷后管理表,房产贷款申请表,车辆贷款申请表,信用贷款申请表
 *
 * @author zhangkai
 * @createDate 2018年11月28日
 */
public class PostLoanManageVo extends HousePropertyMortgageVo {
	/** 回访时间 */
	private Date visit_time;
	/** 回访人姓名 */
	private String visit_name;
	/** 回访内容 */
	private String visit_content;
	/** 还款分析 */
	private String intention_analysis;
	/** 是否逾期( 1 是，0 否) */
	private Integer is_overdue;
	/** 逾期时间 */
	private Date overdue_time;
	/** 创建时间 */
	private Date create_time;
	/** 更新时间 */
	private Date update_time;
	
	/** 借款期限/还款期限 */
	private String life_of_loan;

	public Date getVisit_time() {
		return visit_time;
	}

	public void setVisit_time(Date visit_time) {
		this.visit_time = visit_time;
	}

	public String getVisit_name() {
		return visit_name;
	}

	public void setVisit_name(String visit_name) {
		this.visit_name = visit_name;
	}

	public String getVisit_content() {
		return visit_content;
	}

	public void setVisit_content(String visit_content) {
		this.visit_content = visit_content;
	}

	public String getIntention_analysis() {
		return intention_analysis;
	}

	public void setIntention_analysis(String intention_analysis) {
		this.intention_analysis = intention_analysis;
	}

	public Integer getIs_overdue() {
		return is_overdue;
	}

	public void setIs_overdue(Integer is_overdue) {
		this.is_overdue = is_overdue;
	}

	public Date getOverdue_time() {
		return overdue_time;
	}

	public void setOverdue_time(Date overdue_time) {
		this.overdue_time = overdue_time;
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

	public String getLife_of_loan() {
		return life_of_loan;
	}

	public void setLife_of_loan(String life_of_loan) {
		this.life_of_loan = life_of_loan;
	}

	@Override
	public String toString() {
		return "PostLoanManageVo [visit_time=" + visit_time + ", visit_name=" + visit_name + ", visit_content="
				+ visit_content + ", intention_analysis=" + intention_analysis + ", is_overdue=" + is_overdue
				+ ", overdue_time=" + overdue_time + ", create_time=" + create_time + ", update_time=" + update_time
				+ ", life_of_loan=" + life_of_loan + "]";
	}
	
	
	
	
	
	
	
}
