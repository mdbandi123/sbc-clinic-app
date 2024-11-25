package org.acumen.training.codes.model.dto;

import java.time.LocalDateTime;

public class AppointmentPatientDTO {
	private String name;
	private String icNo;
	private LocalDateTime date; 
	private String remark;
	
	public AppointmentPatientDTO(String name, String icNo, LocalDateTime date, String remark) {
		this.name = name;
		this.icNo = icNo;
		this.date = date;
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcNo() {
		return icNo;
	}

	public void setIcNo(String icNo) {
		this.icNo = icNo;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
