package org.acumen.training.codes.model.dto;

import java.time.LocalDateTime;

public class AppointmentPatientDTO {
	private Integer appointmentId;
	private Integer patientId;
	private Integer reportId;
	private String name;
	private String icNo;
	private LocalDateTime date;
	private String remark;
	private Boolean isArrival;
	private Boolean isConfirmed;
	private String email;

	public AppointmentPatientDTO(Integer appointmentId, Integer patientId, Integer reportId,String name, String icNo, LocalDateTime date, String remark,
			Boolean isArrival, Boolean isConfirmed, String email) {
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.reportId = reportId;
		this.name = name;
		this.icNo = icNo;
		this.date = date;
		this.remark = remark;
		this.isArrival = isArrival;
		this.isConfirmed = isConfirmed;
		this.email = email;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	
	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
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

	public Boolean getIsArrival() {
		return isArrival;
	}

	public void setIsArrival(Boolean isArrival) {
		this.isArrival = isArrival;
	}

	public Boolean getIsConfirmed() {
		return isConfirmed;
	}

	public void setIsConfirmed(Boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
