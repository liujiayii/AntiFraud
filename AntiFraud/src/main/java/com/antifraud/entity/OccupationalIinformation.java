package com.antifraud.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: OccupationalIinformation
 * @description 贷款人职业信息Bean
 * @author ZhaoSong
 * @createDate 2018年11月20日
 */
public class OccupationalIinformation implements Serializable{

	/**  序列化编号 */
	private static final long serialVersionUID = -5195673624238814381L;
	
	/**
	 * 主键id
	 */
	private Long id;
	/**
	 * 保单编号
	 */
	private String entry_number;
	/**
	 * 借款人职业
	 */
	private String occupational;
	/**
	 * 单位名称
	 */
	private String company_name;
	/**
	 * 单位所属行业
	 */
	private String industry_of_the_company;
	/**
	 * 单位地址
	 */
	private String company_address;
	/**
	 * 工作单位电话
	 */
	private String commany_tel;
	/**
	 * 单位地址邮编
	 */
	private String company_mail;
	/**
	 * 单位工作其实年份
	 */
	private String starting_work;
	/**
	 * 职务
	 */
	private Integer duty;
	/**
	 * 职称
	 */
	private Integer professional_title;
	/**
	 * 年收入
	 */
	private BigDecimal annual_income;
	/**
	 * 服务费费率
	 */
	private BigDecimal service_rate;
	/**
	 * 居住状况
	 */
	private Integer residential_condition;
	/**
	 * 居住年限
	 */
	private String period_of_resident;
	/** 投向行业*/
	private Integer throw_industry;
	
	public Integer getThrow_industry() {
		return throw_industry;
	}
	public void setThrow_industry(Integer throw_industry) {
		this.throw_industry = throw_industry;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEntry_number() {
		return entry_number;
	}
	public void setEntry_number(String entry_number) {
		this.entry_number = entry_number;
	}
	public String getOccupational() {
		return occupational;
	}
	public void setOccupational(String occupational) {
		this.occupational = occupational;
	}
	public String getCommany_tel() {
		return commany_tel;
	}
	public void setCommany_tel(String commany_tel) {
		this.commany_tel = commany_tel;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getIndustry_of_the_company() {
		return industry_of_the_company;
	}
	public void setIndustry_of_the_company(String industry_of_the_company) {
		this.industry_of_the_company = industry_of_the_company;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public String getCompany_mail() {
		return company_mail;
	}
	public void setCompany_mail(String company_mail) {
		this.company_mail = company_mail;
	}
	public String getStarting_work() {
		return starting_work;
	}
	public void setStarting_work(String starting_work) {
		this.starting_work = starting_work;
	}
	public Integer getDuty() {
		return duty;
	}
	public void setDuty(Integer duty) {
		this.duty = duty;
	}
	public Integer getProfessional_title() {
		return professional_title;
	}
	public void setProfessional_title(Integer professional_title) {
		this.professional_title = professional_title;
	}
	
	
	public BigDecimal getAnnual_income() {
		return annual_income;
	}
	public void setAnnual_income(BigDecimal annual_income) {
		this.annual_income = annual_income;
	}
	public BigDecimal getService_rate() {
		return service_rate;
	}
	public void setService_rate(BigDecimal service_rate) {
		this.service_rate = service_rate;
	}
	public String getPeriod_of_resident() {
		return period_of_resident;
	}
	public void setPeriod_of_resident(String period_of_resident) {
		this.period_of_resident = period_of_resident;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "OccupationalIinformation [id=" + id + ", entry_number=" + entry_number + ", occupational="
				+ occupational + ", company_name=" + company_name + ", industry_of_the_company="
				+ industry_of_the_company + ", company_address=" + company_address + ", commany_tel=" + commany_tel
				+ ", company_mail=" + company_mail + ", starting_work=" + starting_work + ", duty=" + duty
				+ ", professional_title=" + professional_title + ", annual_income=" + annual_income + ", service_rate="
				+ service_rate + ", residential_condition=" + residential_condition + ", period_of_resident="
				+ period_of_resident + ", throw_industry=" + throw_industry + "]";
	}
	public Integer getResidential_condition() {
		return residential_condition;
	}
	public void setResidential_condition(Integer residential_condition) {
		this.residential_condition = residential_condition;
	}
	
	
	
}
