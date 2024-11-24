package org.acumen.training.codes.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(catalog = "queue")
public class Queue {
	private Integer queueId;
	private Boolean checkIn;
	private String type;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Integer fkPatientId;
	private Integer fkReportId;
	
	@JsonIgnore
	private Patient patient;
	
	@JsonIgnore
	private Report report;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "queue_id", nullable = false, unique = true)
	public Integer getQueueId() {
		return queueId;
	}

	public void setQueueId(Integer queueId) {
		this.queueId = queueId;
	}

	@Column(name = "check_in", nullable = false)
	public Boolean getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Boolean checkIn) {
		this.checkIn = checkIn;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "start_time", nullable = false)
	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	@Column(name = "end_time", nullable = false)
	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	@Column(name = "fk_patient_id", nullable = false)
	public Integer getFkPatientId() {
		return fkPatientId;
	}

	public void setFkPatientId(Integer fkPatientId) {
		this.fkPatientId = fkPatientId;
	}

	@Column(name = "fk_report_id", nullable = false, unique = true)
	public Integer getFkReportId() {
		return fkReportId;
	}

	public void setFkReportId(Integer fkReportId) {
		this.fkReportId = fkReportId;
	}

	@ManyToOne
	@JoinColumn(name = "fk_patient_id", insertable = false, updatable = false)
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@OneToOne
	@JoinColumn(name = "fk_report_id", insertable = false, updatable = false)
	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}
}
