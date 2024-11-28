package org.acumen.training.codes.model.dto;

import java.time.LocalDateTime;

public class PatientReportDTO {
	private Integer reportId;
	private Integer appointmentId;
	private String name;
	private String icNo;
	private LocalDateTime date;
	private String details;

	public PatientReportDTO(Integer reportId, Integer appointmentId, String name, String icNo, LocalDateTime date,
			String details) {
		this.reportId = reportId;
		this.appointmentId = appointmentId;
		this.name = name;
		this.icNo = icNo;
		this.date = date;
		this.details = details;
	}

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
