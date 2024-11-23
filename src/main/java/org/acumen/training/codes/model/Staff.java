package org.acumen.training.codes.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "staff")
public class Staff {
	private Integer staffId;
	private String name;
	private String icNo;
	private String gender;
	private String address;
	private String contactNo;
	private String position;
	private LocalDateTime registrationTime;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id", nullable = false, unique = true)
	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
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

	public void setContact(String contactNo) {
		this.contactNo = contactNo;
	}

	@Column(name = "position", nullable = false)
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "registration_time", nullable = false)
	public LocalDateTime getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(LocalDateTime registrationTime) {
		this.registrationTime = registrationTime;
	}

}
