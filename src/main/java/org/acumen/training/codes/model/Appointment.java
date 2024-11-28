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
@Table(catalog = "appointment")
public class Appointment {
	private Integer appointmentId;
	private LocalDateTime date;
	private Boolean isArrival;
	private Integer fkPatientId;
	private Integer fkReportId;
	private String remark;
	private Boolean isConfirmed;
	
	@JsonIgnore
	private Patient patient;
	
	@JsonIgnore
	private Report report;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id", nullable = false, unique = true)
	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	@Column(name = "date", nullable = false)
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Column(name = "is_arrival", nullable = false)
	public Boolean getIsArrival() {
		return isArrival;
	}

	public void setIsArrival(Boolean isArrival) {
		this.isArrival = isArrival;
	}

	
	@Column(name = "fk_report_id")
	public Integer getFkReportId() {
		return fkReportId;
	}

	public void setFkReportId(Integer fkReportId) {
		this.fkReportId = fkReportId;
	}
	
	@Column(name = "fk_patient_id", nullable = false)
	public Integer getFkPatientId() {
		return fkPatientId;
	}

	public void setFkPatientId(Integer fkPatientId) {
		this.fkPatientId = fkPatientId;
	}

	@Column(name = "remark", nullable = false)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "is_confirmed", nullable = false)
	public Boolean getIsConfirmed() {
		return isConfirmed;
	}

	public void setIsConfirmed(Boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
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
