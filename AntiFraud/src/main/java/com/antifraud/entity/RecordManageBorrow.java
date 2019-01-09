package com.antifraud.entity;

import java.util.Date;
/**
 * 
 *
 * @ClassName: RecordManageBorrow

 * @description 档案借阅表的实体类
 *
 * @author zhangkai
 * @createDate 2018年9月29日
 */
public class RecordManageBorrow {
	/**主键*/
    private Long id;
    /**报单编号 */
    private String report_id;
    /**档案状态*/
    private Byte status;
    /**借阅时间*/
    private Date read_time;
    /**借阅人*/
    private String read_name;
    /**归还时间*/
    private Date return_time;
    /**存放位置*/
    private String archivet_location;
    /** 操作人 */
    private String create_name;
    
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
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
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Date getRead_time() {
		return read_time;
	}
	public void setRead_time(Date read_time) {
		this.read_time = read_time;
	}
	public String getRead_name() {
		return read_name;
	}
	public void setRead_name(String read_name) {
		this.read_name = read_name;
	}
	public Date getReturn_time() {
		return return_time;
	}
	public void setReturn_time(Date return_time) {
		this.return_time = return_time;
	}
	public String getArchivet_location() {
		return archivet_location;
	}
	public void setArchivet_location(String archivet_location) {
		this.archivet_location = archivet_location;
	}
	@Override
	public String toString() {
		return "RecordManageBorrow [id=" + id + ", report_id=" + report_id + ", status=" + status + ", read_time="
				+ read_time + ", read_name=" + read_name + ", return_time=" + return_time + ", archivet_location="
				+ archivet_location + "]";
	}
	
    
}
