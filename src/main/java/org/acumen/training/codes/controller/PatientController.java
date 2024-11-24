package org.acumen.training.codes.controller;

import java.util.List;

import org.acumen.training.codes.dao.PatientDao;
import org.acumen.training.codes.model.Patient;
import org.acumen.training.codes.model.dto.PatientQueueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {
	
	@Autowired
	private PatientDao patientDao;
	
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
	
	@GetMapping(path = "/test")
	public String testGet() {
		return "patient get working";
	}
	
	@GetMapping(path = "/list/all")
	public List<Patient> getAllPatients(){
		return patientDao.getAllPatients();
	}
	
	@GetMapping(path = "/list/all/join")
	public List<PatientQueueDTO> getJoinSample(){
		return patientDao.getJoinSample();
	}
	
	@GetMapping(path = "/websocket/sample")
	public void testWebsocket() {
		messagingTemplate.convertAndSend("/topic/data-update", "Data updated!");
	}
	
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public String send(String message) throws Exception {
        return "test";
    }
}
