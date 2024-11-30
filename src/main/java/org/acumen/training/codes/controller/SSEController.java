package org.acumen.training.codes.controller;

import org.acumen.training.codes.service.SSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/sse")
@CrossOrigin(
	    origins = "http://localhost:5173",
	    allowedHeaders = "*",
	    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE},
	    allowCredentials = "true"
	)
public class SSEController {
	
	@Autowired
	private SSEService sseService;
	
	@GetMapping("/subscribe")
	public SseEmitter subscribeSSE() {
		return sseService.subscribeSSE();
	}	
}
