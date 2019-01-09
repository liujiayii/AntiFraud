package com.antifraud.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *
 * @ClassName: FiduciaryLoan

 * @description 信用贷款表
 *
 * @author qixiyao
 * @createDate 2018年9月28日-下午5:50:27
 */
public class FiduciaryLoan {

	/** 主键 */
	private Long id;
	/** 报单编号 */
	private String entry_number;
	/** 抵押人姓名 */
	private String name;
	/** 电话 */
	private String phone;
	/** 身份证 */
	private String id_number;
	/** 状态（0 保存 1提交） */
	private Integer type;
	/** 进程状态 0 作废 1 不通过    2 3 4...通过（哪一步）*/
	private Integer status;
	/** 紧急联系人 */
	private String emergency_name;
	/** 紧急联系人电话 */
	private String emergency_phone;
	/** 紧急联系人身份证 */
	private String emergency_id_number;
	/** 申请额度 */
	private BigDecimal apply_for_limit;
	/** 申请期限 */
	private String apply_for_deadline;
	/** 借款用途 */
	private String purpose_of_loan;
	/** 创建人id */
	private Long user_id;
	/** 创建时间 */
	private Date create_time;
	/** 修改时间 */
	private Date update_time;
	/** 备注 */
	private String remark;
	/** 审批额度 */
	private BigDecimal approval_limit;
	/** 审批期限 */
	private String approval_deadline;
	/** 确认时间 */
	private Date affirm_time;
	/** 还款方式 */
	private int payment_type;
	/** 工作信息 */
	private String work_info;
	/** 工作地址 */
	private String work_address;
	/** 收入信息 */
	private BigDecimal income;
	/** 确认天数 */
	private Integer affirm_date;
	/** 业务类型 */
	private Integer business_type;
	/** 借款人性别 */
	private Integer gender;
	/** 借款人年龄 */
	private Integer age;
	/** 婚姻状况 */
	private Integer marital_status;
	/** 学历 */
	private Integer education;
	/** 学位 */
	private Integer diploma;
	/** 住宅电话号码 */
	private String home_phone;
	/** 单位电话号码 */
	private String business_phone_number;
	/** 通信地址（家庭住址） */
	private String home_address;
	/** 邮编 */
	private String mailing_address;
	/** 户籍地址 */
	private String permanent_residence_address;
	/** 电子邮箱 */
	private String email;
	/** 配偶姓名 */
	private String spouses_name;
	/** 配偶证件号码 */
	private String spouse_identification_number;
	/** 配偶工作单位 */
	private String spousal_work_unit;
	/** 配偶联系电话 */
	private String spouse_telephone;
	/** 亲属联系人姓名 */
	private String relative_contact_name;
	/** 亲属联系电话 */
	private String relative_contact_number;
	/** 是否本月开户 */
	private Integer account_opening_time;
	/** 紧急联系人与本人关系 */
	private Integer emergency_relation;
	/** 亲属联系人与本人关系 */
	private Integer domestic_relation;
	/** 资产评估师id */
	private Long assessmens;
	/** 风控人员id */
	private Long management;
	/** 风控外勤id */
	private Long risk_management;
	/** 企业姓名（企业开户）*/
	private String enterprise_name;
	/** 企业信用代码（企业开户）*/
	private String enterprise_credit;
	/** 企业对公账号*/
	private String enterprise_bank_no;
	/** 报单类型（0 个人贷  1 企业贷）*/
	private Integer customs_type;
	
	public Integer getCustoms_type() {
		return customs_type;
	}
	public void setCustoms_type(Integer customs_type) {
		this.customs_type = customs_type;
	}
	public String getEnterprise_name() {
		return enterprise_name;
	}
	public void setEnterprise_name(String enterprise_name) {
		this.enterprise_name = enterprise_name;
	}
	public String getEnterprise_credit() {
		return enterprise_credit;
	}
	public void setEnterprise_credit(String enterprise_credit) {
		this.enterprise_credit = enterprise_credit;
	}
	public String getEnterprise_bank_no() {
		return enterprise_bank_no;
	}
	public void setEnterprise_bank_no(String enterprise_bank_no) {
		this.enterprise_bank_no = enterprise_bank_no;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getEmergency_name() {
		return emergency_name;
	}
	public void setEmergency_name(String emergency_name) {
		this.emergency_name = emergency_name;
	}
	public String getEmergency_phone() {
		return emergency_phone;
	}
	public void setEmergency_phone(String emergency_phone) {
		this.emergency_phone = emergency_phone;
	}
	public String getEmergency_id_number() {
		return emergency_id_number;
	}
	public void setEmergency_id_number(String emergency_id_number) {
		this.emergency_id_number = emergency_id_number;
	}
	public BigDecimal getApply_for_limit() {
		return apply_for_limit;
	}
	public void setApply_for_limit(BigDecimal apply_for_limit) {
		this.apply_for_limit = apply_for_limit;
	}
	
	public String getApply_for_deadline() {
		return apply_for_deadline;
	}
	public void setApply_for_deadline(String apply_for_deadline) {
		this.apply_for_deadline = apply_for_deadline;
	}
	public String getPurpose_of_loan() {
		return purpose_of_loan;
	}
	public void setPurpose_of_loan(String purpose_of_loan) {
		this.purpose_of_loan = purpose_of_loan;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public Date getAffirm_time() {
		return affirm_time;
	}
	public void setAffirm_time(Date affirm_time) {
		this.affirm_time = affirm_time;
	}

	public int getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(int payment_type) {
		this.payment_type = payment_type;
	}
	public String getWork_info() {
		return work_info;
	}
	public void setWork_info(String work_info) {
		this.work_info = work_info;
	}
	public String getWork_address() {
		return work_address;
	}
	public void setWork_address(String work_address) {
		this.work_address = work_address;
	}
	public BigDecimal getIncome() {
		return income;
	}
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	public Integer getAffirm_date() {
		return affirm_date;
	}
	public void setAffirm_date(Integer affirm_date) {
		this.affirm_date = affirm_date;
	}
	public Integer getBusiness_type() {
		return business_type;
	}
	public void setBusiness_type(Integer business_type) {
		this.business_type = business_type;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getMarital_status() {
		return marital_status;
	}
	public void setMarital_status(Integer marital_status) {
		this.marital_status = marital_status;
	}
	public Integer getEducation() {
		return education;
	}
	public void setEducation(Integer education) {
		this.education = education;
	}
	public Integer getDiploma() {
		return diploma;
	}
	public void setDiploma(Integer diploma) {
		this.diploma = diploma;
	}
	public String getHome_phone() {
		return home_phone;
	}
	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}
	public String getBusiness_phone_number() {
		return business_phone_number;
	}
	public void setBusiness_phone_number(String business_phone_number) {
		this.business_phone_number = business_phone_number;
	}
	public String getHome_address() {
		return home_address;
	}
	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}
	public String getMailing_address() {
		return mailing_address;
	}
	public void setMailing_address(String mailing_address) {
		this.mailing_address = mailing_address;
	}
	public String getPermanent_residence_address() {
		return permanent_residence_address;
	}
	public void setPermanent_residence_address(String permanent_residence_address) {
		this.permanent_residence_address = permanent_residence_address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSpouses_name() {
		return spouses_name;
	}
	public void setSpouses_name(String spouses_name) {
		this.spouses_name = spouses_name;
	}
	public String getSpouse_identification_number() {
		return spouse_identification_number;
	}
	public void setSpouse_identification_number(String spouse_identification_number) {
		this.spouse_identification_number = spouse_identification_number;
	}
	public String getSpousal_work_unit() {
		return spousal_work_unit;
	}
	public void setSpousal_work_unit(String spousal_work_unit) {
		this.spousal_work_unit = spousal_work_unit;
	}
	public String getSpouse_telephone() {
		return spouse_telephone;
	}
	public void setSpouse_telephone(String spouse_telephone) {
		this.spouse_telephone = spouse_telephone;
	}
	public String getRelative_contact_name() {
		return relative_contact_name;
	}
	public void setRelative_contact_name(String relative_contact_name) {
		this.relative_contact_name = relative_contact_name;
	}
	public String getRelative_contact_number() {
		return relative_contact_number;
	}
	public void setRelative_contact_number(String relative_contact_number) {
		this.relative_contact_number = relative_contact_number;
	}
	public Integer getAccount_opening_time() {
		return account_opening_time;
	}
	public void setAccount_opening_time(Integer account_opening_time) {
		this.account_opening_time = account_opening_time;
	}
	public Integer getEmergency_relation() {
		return emergency_relation;
	}
	public void setEmergency_relation(Integer emergency_relation) {
		this.emergency_relation = emergency_relation;
	}
	public Integer getDomestic_relation() {
		return domestic_relation;
	}
	public void setDomestic_relation(Integer domestic_relation) {
		this.domestic_relation = domestic_relation;
	}
	public Long getAssessmens() {
		return assessmens;
	}
	public void setAssessmens(Long assessmens) {
		this.assessmens = assessmens;
	}
	public Long getManagement() {
		return management;
	}
	public void setManagement(Long management) {
		this.management = management;
	}
	public Long getRisk_management() {
		return risk_management;
	}
	public void setRisk_management(Long risk_management) {
		this.risk_management = risk_management;
	}
	
	@Override
	public String toString() {
		return "FiduciaryLoan [id=" + id + ", entry_number=" + entry_number + ", name=" + name + ", phone=" + phone
				+ ", id_number=" + id_number + ", type=" + type + ", status=" + status + ", emergency_name="
				+ emergency_name + ", emergency_phone=" + emergency_phone + ", emergency_id_number="
				+ emergency_id_number + ", apply_for_limit=" + apply_for_limit + ", apply_for_deadline="
				+ apply_for_deadline + ", purpose_of_loan=" + purpose_of_loan + ", user_id=" + user_id
				+ ", create_time=" + create_time + ", update_time=" + update_time + ", remark=" + remark
				+ ", approval_limit=" + approval_limit + ", approval_deadline=" + approval_deadline + ", affirm_time="
				+ affirm_time + ", payment_type=" + payment_type + ", work_info=" + work_info + ", work_address="
				+ work_address + ", income=" + income + ", affirm_date=" + affirm_date + ", business_type="
				+ business_type + ", gender=" + gender + ", age=" + age + ", marital_status=" + marital_status
				+ ", education=" + education + ", diploma=" + diploma + ", home_phone=" + home_phone
				+ ", business_phone_number=" + business_phone_number + ", home_address=" + home_address
				+ ", mailing_address=" + mailing_address + ", permanent_residence_address="
				+ permanent_residence_address + ", email=" + email + ", spouses_name=" + spouses_name
				+ ", spouse_identification_number=" + spouse_identification_number + ", spousal_work_unit="
				+ spousal_work_unit + ", spouse_telephone=" + spouse_telephone + ", relative_contact_name="
				+ relative_contact_name + ", relative_contact_number=" + relative_contact_number
				+ ", account_opening_time=" + account_opening_time + ", emergency_relation=" + emergency_relation
				+ ", domestic_relation=" + domestic_relation + ", assessmens=" + assessmens + ", management="
				+ management + ", risk_management=" + risk_management + ", enterprise_name=" + enterprise_name
				+ ", enterprise_credit=" + enterprise_credit + ", enterprise_bank_no=" + enterprise_bank_no
				+ ", customs_type=" + customs_type + "]";
	}
	
	
	
	
	
	
}
