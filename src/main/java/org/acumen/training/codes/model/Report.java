package org.acumen.training.codes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "report")
public class Report {
	private Integer reportId;
	private Integer fkStaffId;
	private String details;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id", nullable = false, unique = true)
	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	@Column(name = "fk_staff_id", nullable = false)
	public Integer getFkStaffId() {
		return fkStaffId;
	}

	public void setFkStaffId(Integer fkStaffId) {
		this.fkStaffId = fkStaffId;
	}

	@Column(name = "details", nullable = false)
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
