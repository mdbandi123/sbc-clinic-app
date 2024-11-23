package org.acumen.training.codes.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "appointment")
public class Appointment {
	private Integer appointmentId;
	private LocalDate date;
	private Boolean isArrival;
	private Integer fkPatientId;
	private String remark;
	
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
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Column(name = "is_arrival", nullable = false)
	public Boolean getIsArrival() {
		return isArrival;
	}

	public void setIsArrival(Boolean isArrival) {
		this.isArrival = isArrival;
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

}
