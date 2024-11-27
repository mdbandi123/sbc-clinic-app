package org.acumen.training.codes.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "patient")
public class Patient {
	private Integer patientId;
	private String name;
	private String icNo;
	private String gender;
	private String address;
	private String contactNo;
	private LocalDateTime registrationTime;
	private String email;
	
	@JsonIgnore
	private List<AppointmentNotification> appointmentNotifications;
	
	@JsonIgnore
	private List<Queue> queues;
	
	@JsonIgnore
	private List<Appointment> appointments;
	
	@JsonIgnore
	private List<MedicalCertificate> medicalCertificates;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id", nullable = false, unique = true)
	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ic_no", nullable = false, unique = true)
	public String getIcNo() {
		return icNo;
	}

	public void setIcNo(String icNo) {
		this.icNo = icNo;
	}

	@Column(name = "gender", nullable = false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "contact_no", nullable = false, unique = true)
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Column(name = "registration_time", nullable = false)
	public LocalDateTime getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(LocalDateTime registrationTime) {
		this.registrationTime = registrationTime;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	public List<AppointmentNotification> getAppointmentNotifications() {
		return appointmentNotifications;
	}

	public void setAppointmentNotifications(List<AppointmentNotification> appointmentNotifications) {
		this.appointmentNotifications = appointmentNotifications;
	}

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	public List<Queue> getQueues() {
		return queues;
	}

	public void setQueues(List<Queue> queues) {
		this.queues = queues;
	}

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	public List<MedicalCertificate> getMedicalCertificates() {
		return medicalCertificates;
	}

	public void setMedicalCertificates(List<MedicalCertificate> medicalCertificates) {
		this.medicalCertificates = medicalCertificates;
	}

}