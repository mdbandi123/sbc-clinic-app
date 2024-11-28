package org.acumen.training.codes.controller;

import java.util.List;

import org.acumen.training.codes.model.Appointment;
import org.acumen.training.codes.model.dto.QueuePatientDTO;
import org.acumen.training.codes.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
@CrossOrigin
public class QueueController {
	
	@Autowired
	private QueueService queueService;

	@GetMapping("/details/list")
	public List<QueuePatientDTO> getQueueOfPatients(){
		return queueService.getQueueOfPatients();
	}
	
	@GetMapping("/details/list/checkin/false")
	public List<QueuePatientDTO> getQueueOfPatientsNotCheckedIn(){
		return queueService.getQueueOfPatientsNotCheckedIn();
	}
	
	@PostMapping("/insert")
	public boolean insertToQueue(@RequestBody Appointment appointment){
		return queueService.insertToQueue(appointment);
	}	
	
	@PatchMapping("/update/type/{id}")
	public boolean updateQueueType(@PathVariable Integer id) {
		return queueService.updateQueueType(id);
	}
	
	@PatchMapping("/update/checkin/{id}")
	public boolean updateCheckIn(@PathVariable Integer id) {
		return queueService.updateCheckIn(id);
	}
}
