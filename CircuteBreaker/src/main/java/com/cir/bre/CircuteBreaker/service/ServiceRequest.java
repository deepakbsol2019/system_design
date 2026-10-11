package com.cir.bre.CircuteBreaker.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ServiceRequest {
	
	private final CallResourceService callResourceService;
	public ServiceRequest(CallResourceService callResourceService) {
		this.callResourceService=callResourceService;
	}

	@CircuitBreaker(name = "resourceTest",fallbackMethod = "fallMethod")
	public ResponseEntity<String> getData() {
		return this.callResourceService.getData();
	}

	
	public ResponseEntity<String> fallMethod(Exception e){
		System.out.println("Exception due to ::"+e.getMessage());
		return new ResponseEntity<>("This is fallMethod",HttpStatus.OK);
	}
}
