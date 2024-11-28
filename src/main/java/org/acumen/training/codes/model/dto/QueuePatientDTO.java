package org.acumen.training.codes.model.dto;

import java.time.LocalDateTime;

public class QueuePatientDTO {
	private Integer queueId;
	private String name;
	private String icNo;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String type;
	private Boolean checkIn;

	public QueuePatientDTO(Integer queueId, String name, String icNo, LocalDateTime startTime, LocalDateTime endTime,
			String type, Boolean checkIn) {
		this.queueId = queueId;
		this.name = name;
		this.icNo = icNo;
		this.startTime = startTime;
		this.endTime = endTime;
		this.type = type;
		this.checkIn = checkIn;
	}

	public Integer getQueueId() {
		return queueId;
	}

	public void setQueueId(Integer queueId) {
		this.queueId = queueId;
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

	public Boolean getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Boolean checkIn) {
		this.checkIn = checkIn;
	}
	
	
}
