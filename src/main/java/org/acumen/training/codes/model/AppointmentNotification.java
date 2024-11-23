package org.acumen.training.codes.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "appointment_notification")
public class AppointmentNotification {
	private Integer message_id;
	private Integer fk_patient_id;
	private LocalDate send_date;
	private String details;
	private String message;
	private String type;
	private Boolean has_send;
	private LocalDate has_send_date;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id", nullable = false, unique = true)
	public Integer getMessage_id() {
		return message_id;
	}

	public void setMessage_id(Integer message_id) {
		this.message_id = message_id;
	}

	@Column(name = "message_id", nullable = false)
	public Integer getFk_patient_id() {
		return fk_patient_id;
	}

	public void setFk_patient_id(Integer fk_patient_id) {
		this.fk_patient_id = fk_patient_id;
	}

	@Column(name = "send_date", nullable = false)
	public LocalDate getSend_date() {
		return send_date;
	}

	public void setSend_date(LocalDate send_date) {
		this.send_date = send_date;
	}

	@Column(name = "details", nullable = false)
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Column(name = "message", nullable = false)
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "has_send", nullable = false)
	public Boolean getHas_send() {
		return has_send;
	}

	public void setHas_send(Boolean has_send) {
		this.has_send = has_send;
	}

	@Column(name = "has_send_date", nullable = false)
	public LocalDate getHas_send_date() {
		return has_send_date;
	}

	public void setHas_send_date(LocalDate has_send_date) {
		this.has_send_date = has_send_date;
	}

}
