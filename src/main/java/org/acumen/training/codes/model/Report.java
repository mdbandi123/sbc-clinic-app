package org.acumen.training.codes.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "report")
public class Report {
	private Integer reportId;
	private Integer fkStaffId;
	private String details;
	private LocalDateTime date;
	
	@JsonIgnore
	private Queue queue;
	
	@JsonIgnore
	private Staff staff;

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
	
	@Column(name = "date", nullable = false)
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@OneToOne(mappedBy = "report", cascade = CascadeType.ALL)
	public Queue getQueue() {
		return queue;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
	}
	
	@ManyToOne
	@JoinColumn(name = "fk_staff_id", insertable = false, updatable = false)
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	

}
