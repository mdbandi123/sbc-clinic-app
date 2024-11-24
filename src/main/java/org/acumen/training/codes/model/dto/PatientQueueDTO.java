package org.acumen.training.codes.model.dto;

import java.time.LocalDateTime;

public class PatientQueueDTO {
    private String name;
    private String icNo;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String type;
    
    public PatientQueueDTO(String name, String icNo, LocalDateTime startTime, LocalDateTime endTime, String type) {
    	this.name = name;
    	this.icNo = icNo;
    	this.startTime = startTime;
    	this.endTime = endTime;
    	this.type = type;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcNo() {
		return icNo;
	}
	public void setIcNo(String icNo) {
		this.icNo = icNo;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
