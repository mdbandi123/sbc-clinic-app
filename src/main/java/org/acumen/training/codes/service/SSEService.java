package org.acumen.training.codes.service;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class SSEService {
	
	private final CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();

	public SseEmitter subscribeSSE() {
		SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
		emitters.add(emitter);

		emitter.onCompletion(() -> emitters.remove(emitter));
		emitter.onTimeout(() -> emitters.remove(emitter));

		emitter.onError((ex) -> {
			System.err.println("Emitter error: " + ex.getMessage());
			emitters.remove(emitter);
		});

		return emitter;
	}
	
	public boolean sendSSE(String eventName) {
		for (Iterator<SseEmitter> iterator = emitters.iterator(); iterator.hasNext();) {
		    SseEmitter emitter = iterator.next();

		    try {
		        emitter.send(SseEmitter.event().name(eventName).data("event triggered"));
		        return true;
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		}
		
		return false;
	}
}
