package org.acumen.training.codes.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "medical_certificate")
public class MedicalCertificate {
	private Integer medicalCertificateId;
	private LocalDate startDate;
	private LocalDate day;
	private String reason;
	private Integer fkPatientId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medical_certificate_id", nullable = false, unique = true)
	public Integer getMedicalCertificateId() {
		return medicalCertificateId;
	}

	public void setMedicalCertificateId(Integer medicalCertificateId) {
		this.medicalCertificateId = medicalCertificateId;
	}

	@Column(name = "start_date", nullable = false)
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	@Column(name = "day", nullable = false)
	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}
	
	@Column(name = "reason", nullable = false)
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "fk_patient_id", nullable = false)
	public Integer getFkPatientId() {
		return fkPatientId;
	}

	public void setFkPatientId(Integer fkPatientId) {
		this.fkPatientId = fkPatientId;
	}

}
