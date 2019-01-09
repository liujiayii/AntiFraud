package com.antifraud.entityVO;

import java.util.Date;
/**
 * 
 *
 * @ClassName: RecordManageVo

 * @description 
 *
 * @author zhangkai
 * @createDate 2018年9月29日
 */
public class RecordManageVo {
	/**主键*/
    private Long id;
    /**报单编号*/
    private String report_id;
    /**档案状态*/
    private Byte status;
    /**存档时间*/
    private Date archivet_time;
    /**消档时间*/
    private Date cencal_time;
    /**存放位置*/
    private String archivet_location;
    /**借阅时间*/
    private  Date read_time;
    /**归还时间*/
    private  Date return_time;
    /**借阅人*/
    private String read_name;
    
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
	public Date getArchivet_time() {
		return archivet_time;
	}
	public void setArchivet_time(Date archivet_time) {
		this.archivet_time = archivet_time;
	}
	public Date getCencal_time() {
		return cencal_time;
	}
	public void setCencal_time(Date cencal_time) {
		this.cencal_time = cencal_time;
	}
	public String getArchivet_location() {
		return archivet_location;
	}
	public void setArchivet_location(String archivet_location) {
		this.archivet_location = archivet_location;
	}
	public Date getRead_time() {
		return read_time;
	}
	public void setRead_time(Date read_time) {
		this.read_time = read_time;
	}
	public Date getReturn_time() {
		return return_time;
	}
	public void setReturn_time(Date return_time) {
		this.return_time = return_time;
	}
	public String getRead_name() {
		return read_name;
	}
	public void setRead_name(String read_name) {
		this.read_name = read_name;
	}
	@Override
	public String toString() {
		return "RecordManageVo [id=" + id + ", report_id=" + report_id + ", status=" + status + ", archivet_time="
				+ archivet_time + ", cencal_time=" + cencal_time + ", archivet_location=" + archivet_location
				+ ", read_time=" + read_time + ", return_time=" + return_time + ", read_name=" + read_name + "]";
	}

	
    
}