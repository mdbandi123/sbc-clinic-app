package org.acumen.training.codes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.acumen.training.codes.dao.QueueDao;
import org.acumen.training.codes.model.Appointment;
import org.acumen.training.codes.model.Queue;
import org.acumen.training.codes.model.dto.QueuePatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueService {
	
	@Autowired
	private QueueDao queueDao;
	
	public List<QueuePatientDTO> getQueueOfPatients(){
		return queueDao.getQueueOfPatients();
	}
	
	
	public boolean insertToQueue(Appointment appointment) {
		Queue queue = new Queue();
		queue.setCheckIn(false);
		queue.setType("Queue");
		queue.setStartTime(LocalDateTime.now());
		queue.setEndTime(null);
		queue.setFkPatientId(appointment.getFkPatientId());
		queue.setFkReportId(null);
		return queueDao.insertToQueue(queue);
	}
	
	public boolean updateQueueType(Integer id) {
		return queueDao.updateQueueType(id, "Queue");
	}
	
	public boolean updateCheckIn(Integer id) {
		return queueDao.updateCheckIn(id, true, LocalDateTime.now());
	}
}
