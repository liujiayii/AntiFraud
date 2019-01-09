package com.antifraud.entityVO;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 *
 * @ClassName: ReplenishProcedureVo

 * @description 借款人业务信息表,贷款人职业信息表
 *
 * @author zhangkai
 * @createDate 2018年11月28日
 */
public class ReplenishProcedureVo {

	/**主键*/
	private long id;
	
	/**报单编号*/
	private String entry_number;
	
	/**面谈时间 */
	private Date facetime;
	
	/**借款种类备注*/
	private String borrowing_species;
	
	/**劳动报酬 */
	private BigDecimal reward;
	
	/**筹款时间 */
	private int money_collecting_time;
	
	/**收入来源有几处 */
	private int ource_of_revenue;
	
	/**还款来源 */
	private String repayment;
	
	/**房产情况 */
	private String housing_situation;
	
	/**车产情况 */
	private String car_situation;
	
	/**其它固定资产 */
	private String other_assets;
	
	/**担保方式 */
	private String guaranty_style;
	
	/**征信报告 */
	private String credit;
	
	/**保证人姓名 */
	private String name_of_sponsor;
	
	/**保证金额 */
	private double margin_trade;
	
	/**抵押方式 */
	private String pledge_type;
	
	/**是否属于本人 (对应数据库)*/
	private boolean belong_to_oneself;
	
	/**是否属于本人 (对应前端)*/
	private String belong_to_oneself_for_webpage;
	
	/**评估价格 */
	private BigDecimal assess_price;
	
	/**借款期限 */
	private String life_of_loan;
	
	/**贷款年利率 */
	private BigDecimal annual_interest_rate;
	
	/**是否贷过款(对应数据库) */
	private boolean whether_the_loan;
	
	/**是否贷过款(对应前端) */
	private String whether_the_loan_for_webpage;
	
	/**是否如约还款 */
	private String observant_party;
	
	/**分公司 */
	private Long branch_office;
	
	/**接待人员 */
	private String reception_personnel;
	
	/**申请人现住址 */
	private String nowaddress;
	
	/**信用卡额度 */
	private BigDecimal line_of_credit;
	
	/**银行负债情况 */
	private String liabilities_of_bank;
	
	/**民间负债情况 */
	private String liabilities_of_folk;
	
	/**贷款记录 */
	private String loan_documentation;
	
	/**家庭地址 */
	private String home_address;
	
	/**月收入 */
	private BigDecimal monthly_profit;
	
	/**配偶月收入 */
	private BigDecimal spouse_monthly_profit;
	
	/**身份信息图片 */
	private String identity_img;
	
	/**房本或车本图片 */
	private String picture_of_collateral;
	
	/**信用图片 */
	private String credit_image;
	
	/**实物图片 */
	private String the_pictures;
	
	/**经营状况图片 */
	private String business_picture;
	
	/**现居住地图片 */
	private String residential_address_image;
	
	/**行驶证图片 */
	private String driving_license_image;
	
	/**借款说明 */
	private String borrowing_that;
	
	/**勘察师意见 */
	private String survey_and_opinion;
	
	/**风控意见 */
	private String risk_control_opinion;
	
	/**报单状态 */
	private int type;
	
	/**面谈地点(对应数据库)*/
	private String Interview_place;	
	
	/**面谈地点(对应前端)*/
	private String talk_place;
		
	/**借款人职业 */
	private String occupational;
	
	/**单位名称 */
	private String company_name;
	
	/**单位所属行业 */
	private String industry_of_the_company;
	
	/**单位地址 */
	private String company_address;
	
	/**单位地址邮编 */
	private String company_mail;
	
	/**工作单位电话 */
	private String commany_tel;
	
	/**单位工作起始年份 */
	private String starting_work;
	
	/**职务(1高级，2中级领导，3一般员工，4其他，9未知) */
	private int duty;
	
	/**职称（0无，1高级，2中级，3初级，9未知） */
	private int professional_title;
	
	/**年收入 */
	private BigDecimal annual_income;
	
	/**服务费费率 */
	private BigDecimal service_rate;
	
	/**居住状况 */
	private int residential_condition;
	
	/**居住年限 */	
	private String period_of_resident;

	/**借款用途*/
	private String purpose_of_loan;
	
	/**审批额度(单位 /万元)*/
	private BigDecimal approval_limit;
	
	/**审批期限(单位/月)*/
	private  String approval_deadline;
	
	/**业务类型*/
	private int business_type;

	/**借款类型 */
	private int bor_type;
	
	/**借款地点 */
	private int site;
	
	/**投向行业 */
	private long throw_industry;
	
	/**申请人家庭收入 */
	private double home_annual_income;
	
	/**还款方式（1：先息后本，2：等额本息3：一次性还款）*/
	private int payment_type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEntry_number() {
		return entry_number;
	}

	public void setEntry_number(String entry_number) {
		this.entry_number = entry_number;
	}

	public Date getFacetime() {
		return facetime;
	}

	public void setFacetime(Date facetime) {
		this.facetime = facetime;
	}

	public String getBorrowing_species() {
		return borrowing_species;
	}

	public void setBorrowing_species(String borrowing_species) {
		this.borrowing_species = borrowing_species;
	}

	public BigDecimal getReward() {
		return reward;
	}

	public void setReward(BigDecimal reward) {
		this.reward = reward;
	}

	public int getMoney_collecting_time() {
		return money_collecting_time;
	}

	public void setMoney_collecting_time(int money_collecting_time) {
		this.money_collecting_time = money_collecting_time;
	}

	public int getOurce_of_revenue() {
		return ource_of_revenue;
	}

	public void setOurce_of_revenue(int ource_of_revenue) {
		this.ource_of_revenue = ource_of_revenue;
	}

	public String getRepayment() {
		return repayment;
	}

	public void setRepayment(String repayment) {
		this.repayment = repayment;
	}

	public String getHousing_situation() {
		return housing_situation;
	}

	public void setHousing_situation(String housing_situation) {
		this.housing_situation = housing_situation;
	}

	public String getCar_situation() {
		return car_situation;
	}

	public void setCar_situation(String car_situation) {
		this.car_situation = car_situation;
	}

	public String getOther_assets() {
		return other_assets;
	}

	public void setOther_assets(String other_assets) {
		this.other_assets = other_assets;
	}

	public String getGuaranty_style() {
		return guaranty_style;
	}

	public void setGuaranty_style(String guaranty_style) {
		this.guaranty_style = guaranty_style;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getName_of_sponsor() {
		return name_of_sponsor;
	}

	public void setName_of_sponsor(String name_of_sponsor) {
		this.name_of_sponsor = name_of_sponsor;
	}

	public double getMargin_trade() {
		return margin_trade;
	}

	public void setMargin_trade(double margin_trade) {
		this.margin_trade = margin_trade;
	}

	public String getPledge_type() {
		return pledge_type;
	}

	public void setPledge_type(String pledge_type) {
		this.pledge_type = pledge_type;
	}

	public boolean isBelong_to_oneself() {
		return belong_to_oneself;
	}

	public void setBelong_to_oneself(boolean belong_to_oneself) {
		this.belong_to_oneself = belong_to_oneself;
	}

	public String getBelong_to_oneself_for_webpage() {
		return belong_to_oneself_for_webpage;
	}

	public void setBelong_to_oneself_for_webpage(String belong_to_oneself_for_webpage) {
		this.belong_to_oneself_for_webpage = belong_to_oneself_for_webpage;
	}

	public BigDecimal getAssess_price() {
		return assess_price;
	}

	public void setAssess_price(BigDecimal assess_price) {
		this.assess_price = assess_price;
	}

	public String getLife_of_loan() {
		return life_of_loan;
	}

	public void setLife_of_loan(String life_of_loan) {
		this.life_of_loan = life_of_loan;
	}

	public BigDecimal getAnnual_interest_rate() {
		return annual_interest_rate;
	}

	public void setAnnual_interest_rate(BigDecimal annual_interest_rate) {
		this.annual_interest_rate = annual_interest_rate;
	}

	public boolean isWhether_the_loan() {
		return whether_the_loan;
	}

	public void setWhether_the_loan(boolean whether_the_loan) {
		this.whether_the_loan = whether_the_loan;
	}

	public String getWhether_the_loan_for_webpage() {
		return whether_the_loan_for_webpage;
	}

	public void setWhether_the_loan_for_webpage(String whether_the_loan_for_webpage) {
		this.whether_the_loan_for_webpage = whether_the_loan_for_webpage;
	}

	public String getObservant_party() {
		return observant_party;
	}

	public void setObservant_party(String observant_party) {
		this.observant_party = observant_party;
	}

	public Long getBranch_office() {
		return branch_office;
	}

	public void setBranch_office(Long branch_office) {
		this.branch_office = branch_office;
	}

	public String getReception_personnel() {
		return reception_personnel;
	}

	public void setReception_personnel(String reception_personnel) {
		this.reception_personnel = reception_personnel;
	}

	public String getNowaddress() {
		return nowaddress;
	}

	public void setNowaddress(String nowaddress) {
		this.nowaddress = nowaddress;
	}

	public BigDecimal getLine_of_credit() {
		return line_of_credit;
	}

	public void setLine_of_credit(BigDecimal line_of_credit) {
		this.line_of_credit = line_of_credit;
	}

	public String getLiabilities_of_bank() {
		return liabilities_of_bank;
	}

	public void setLiabilities_of_bank(String liabilities_of_bank) {
		this.liabilities_of_bank = liabilities_of_bank;
	}

	public String getLiabilities_of_folk() {
		return liabilities_of_folk;
	}

	public void setLiabilities_of_folk(String liabilities_of_folk) {
		this.liabilities_of_folk = liabilities_of_folk;
	}

	public String getLoan_documentation() {
		return loan_documentation;
	}

	public void setLoan_documentation(String loan_documentation) {
		this.loan_documentation = loan_documentation;
	}

	public String getHome_address() {
		return home_address;
	}

	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}

	public BigDecimal getMonthly_profit() {
		return monthly_profit;
	}

	public void setMonthly_profit(BigDecimal monthly_profit) {
		this.monthly_profit = monthly_profit;
	}

	public BigDecimal getSpouse_monthly_profit() {
		return spouse_monthly_profit;
	}

	public void setSpouse_monthly_profit(BigDecimal spouse_monthly_profit) {
		this.spouse_monthly_profit = spouse_monthly_profit;
	}

	public String getIdentity_img() {
		return identity_img;
	}

	public void setIdentity_img(String identity_img) {
		this.identity_img = identity_img;
	}

	public String getPicture_of_collateral() {
		return picture_of_collateral;
	}

	public void setPicture_of_collateral(String picture_of_collateral) {
		this.picture_of_collateral = picture_of_collateral;
	}

	public String getCredit_image() {
		return credit_image;
	}

	public void setCredit_image(String credit_image) {
		this.credit_image = credit_image;
	}

	public String getThe_pictures() {
		return the_pictures;
	}

	public void setThe_pictures(String the_pictures) {
		this.the_pictures = the_pictures;
	}

	public String getBusiness_picture() {
		return business_picture;
	}

	public void setBusiness_picture(String business_picture) {
		this.business_picture = business_picture;
	}

	public String getResidential_address_image() {
		return residential_address_image;
	}

	public void setResidential_address_image(String residential_address_image) {
		this.residential_address_image = residential_address_image;
	}

	public String getDriving_license_image() {
		return driving_license_image;
	}

	public void setDriving_license_image(String driving_license_image) {
		this.driving_license_image = driving_license_image;
	}

	public String getBorrowing_that() {
		return borrowing_that;
	}

	public void setBorrowing_that(String borrowing_that) {
		this.borrowing_that = borrowing_that;
	}

	public String getSurvey_and_opinion() {
		return survey_and_opinion;
	}

	public void setSurvey_and_opinion(String survey_and_opinion) {
		this.survey_and_opinion = survey_and_opinion;
	}

	public String getRisk_control_opinion() {
		return risk_control_opinion;
	}

	public void setRisk_control_opinion(String risk_control_opinion) {
		this.risk_control_opinion = risk_control_opinion;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getInterview_place() {
		return Interview_place;
	}

	public void setInterview_place(String interview_place) {
		Interview_place = interview_place;
	}

	public String getTalk_place() {
		return talk_place;
	}

	public void setTalk_place(String talk_place) {
		this.talk_place = talk_place;
	}

	public String getOccupational() {
		return occupational;
	}

	public void setOccupational(String occupational) {
		this.occupational = occupational;
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

	public String getCommany_tel() {
		return commany_tel;
	}

	public void setCommany_tel(String commany_tel) {
		this.commany_tel = commany_tel;
	}

	public String getStarting_work() {
		return starting_work;
	}

	public void setStarting_work(String starting_work) {
		this.starting_work = starting_work;
	}

	public int getDuty() {
		return duty;
	}

	public void setDuty(int duty) {
		this.duty = duty;
	}

	public int getProfessional_title() {
		return professional_title;
	}

	public void setProfessional_title(int professional_title) {
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

	public int getResidential_condition() {
		return residential_condition;
	}

	public void setResidential_condition(int residential_condition) {
		this.residential_condition = residential_condition;
	}

	public String getPeriod_of_resident() {
		return period_of_resident;
	}

	public void setPeriod_of_resident(String period_of_resident) {
		this.period_of_resident = period_of_resident;
	}

	public String getPurpose_of_loan() {
		return purpose_of_loan;
	}

	public void setPurpose_of_loan(String purpose_of_loan) {
		this.purpose_of_loan = purpose_of_loan;
	}

	public BigDecimal getApproval_limit() {
		return approval_limit;
	}

	public void setApproval_limit(BigDecimal approval_limit) {
		this.approval_limit = approval_limit;
	}

	public String getApproval_deadline() {
		return approval_deadline;
	}

	public void setApproval_deadline(String approval_deadline) {
		this.approval_deadline = approval_deadline;
	}

	public int getBusiness_type() {
		return business_type;
	}

	public void setBusiness_type(int business_type) {
		this.business_type = business_type;
	}

	public int getBor_type() {
		return bor_type;
	}

	public void setBor_type(int bor_type) {
		this.bor_type = bor_type;
	}

	public int getSite() {
		return site;
	}

	public void setSite(int site) {
		this.site = site;
	}

	public long getThrow_industry() {
		return throw_industry;
	}

	public void setThrow_industry(long throw_industry) {
		this.throw_industry = throw_industry;
	}

	public double getHome_annual_income() {
		return home_annual_income;
	}

	public void setHome_annual_income(double home_annual_income) {
		this.home_annual_income = home_annual_income;
	}

	public int getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(int payment_type) {
		this.payment_type = payment_type;
	}

	@Override
	public String toString() {
		return "ReplenishProcedureVo [id=" + id + ", entry_number=" + entry_number + ", facetime=" + facetime
				+ ", borrowing_species=" + borrowing_species + ", reward=" + reward + ", money_collecting_time="
				+ money_collecting_time + ", ource_of_revenue=" + ource_of_revenue + ", repayment=" + repayment
				+ ", housing_situation=" + housing_situation + ", car_situation=" + car_situation + ", other_assets="
				+ other_assets + ", guaranty_style=" + guaranty_style + ", credit=" + credit + ", name_of_sponsor="
				+ name_of_sponsor + ", margin_trade=" + margin_trade + ", pledge_type=" + pledge_type
				+ ", belong_to_oneself=" + belong_to_oneself + ", belong_to_oneself_for_webpage="
				+ belong_to_oneself_for_webpage + ", assess_price=" + assess_price + ", life_of_loan=" + life_of_loan
				+ ", annual_interest_rate=" + annual_interest_rate + ", whether_the_loan=" + whether_the_loan
				+ ", whether_the_loan_for_webpage=" + whether_the_loan_for_webpage + ", observant_party="
				+ observant_party + ", branch_office=" + branch_office + ", reception_personnel=" + reception_personnel
				+ ", nowaddress=" + nowaddress + ", line_of_credit=" + line_of_credit + ", liabilities_of_bank="
				+ liabilities_of_bank + ", liabilities_of_folk=" + liabilities_of_folk + ", loan_documentation="
				+ loan_documentation + ", home_address=" + home_address + ", monthly_profit=" + monthly_profit
				+ ", spouse_monthly_profit=" + spouse_monthly_profit + ", identity_img=" + identity_img
				+ ", picture_of_collateral=" + picture_of_collateral + ", credit_image=" + credit_image
				+ ", the_pictures=" + the_pictures + ", business_picture=" + business_picture
				+ ", residential_address_image=" + residential_address_image + ", driving_license_image="
				+ driving_license_image + ", borrowing_that=" + borrowing_that + ", survey_and_opinion="
				+ survey_and_opinion + ", risk_control_opinion=" + risk_control_opinion + ", type=" + type
				+ ", Interview_place=" + Interview_place + ", talk_place=" + talk_place + ", occupational="
				+ occupational + ", company_name=" + company_name + ", industry_of_the_company="
				+ industry_of_the_company + ", company_address=" + company_address + ", company_mail=" + company_mail
				+ ", commany_tel=" + commany_tel + ", starting_work=" + starting_work + ", duty=" + duty
				+ ", professional_title=" + professional_title + ", annual_income=" + annual_income + ", service_rate="
				+ service_rate + ", residential_condition=" + residential_condition + ", period_of_resident="
				+ period_of_resident + ", purpose_of_loan=" + purpose_of_loan + ", approval_limit=" + approval_limit
				+ ", approval_deadline=" + approval_deadline + ", business_type=" + business_type + ", bor_type="
				+ bor_type + ", site=" + site + ", throw_industry=" + throw_industry + ", home_annual_income="
				+ home_annual_income + ", payment_type=" + payment_type + "]";
	}
	
	
	
	
}