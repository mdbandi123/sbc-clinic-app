package org.acumen.training.codes.model.dto;

import java.time.LocalDateTime;

public class PatientQueueReportDTO {
    private String name;
    private String icNo;
    private Boolean checkIn;
    private String type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String details;


    public PatientQueueReportDTO(String name, String icNo, Boolean checkIn, 
                                  String type, LocalDateTime startTime, LocalDateTime endTime, 
                                  String details) {
        this.name = name;
        this.icNo = icNo;
        this.checkIn = checkIn;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.details = details;
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


	public Boolean getCheckIn() {
		return checkIn;
	}


	public void setCheckIn(Boolean checkIn) {
		this.checkIn = checkIn;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}

    
}

