package org.acumen.training.codes.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "appointment_notification")
public class AppointmentNotification {
	private Integer messageId;
    private Integer fkPatientId;
    private LocalDate sendDate;
    private String details;
    private String message;
    private String type;
    private Boolean hasSend;
    private LocalDate hasSendDate;
    
	@JsonIgnore
    private Patient patient;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id", nullable = false, unique = true)
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    @Column(name = "fk_patient_id", nullable = false)
    public Integer getFkPatientId() {
        return fkPatientId;
    }

    public void setFkPatientId(Integer fkPatientId) {
        this.fkPatientId = fkPatientId;
    }

    @Column(name = "send_date", nullable = false)
    public LocalDate getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDate sendDate) {
        this.sendDate = sendDate;
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
    public Boolean getHasSend() {
        return hasSend;
    }

    public void setHasSend(Boolean hasSend) {
        this.hasSend = hasSend;
    }

    @Column(name = "has_send_date", nullable = false)
    public LocalDate getHasSendDate() {
        return hasSendDate;
    }

    public void setHasSendDate(LocalDate hasSendDate) {
        this.hasSendDate = hasSendDate;
    }

    @ManyToOne
    @JoinColumn(name = "fk_patient_id", insertable = false, updatable = false)
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}