package org.acumen.training.codes.controller;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/*
 * Emitter setup for realtime events using SSE
 * */
@RestController
@RequestMapping("/SSE")
@CrossOrigin(origins = "http://localhost:5173")
public class SSEController {
	
	private final CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();

	@GetMapping(path = "/test")
	public String testGet() {
		return "SSE Sample";
	}
	
	@GetMapping("/subscribe")
	public SseEmitter subscribe() {
		SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
		emitters.add(emitter);
		
		emitter.onCompletion(()-> emitters.remove(emitter));
		emitter.onTimeout(()-> emitters.remove(emitter));
		
	    emitter.onError((ex) -> {
	        System.err.println("Emitter error: " + ex.getMessage());
	        emitters.remove(emitter);
	    });
	    
		return emitter;
	}
	
	@PutMapping("/update")
	public String update() {
		for (Iterator<SseEmitter> iterator = emitters.iterator(); iterator.hasNext();) {
		    SseEmitter emitter = iterator.next();

		    try {
		        emitter.send(SseEmitter.event().data("table updated"));
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		}
		
		return "updated na";
	}
	
}
