package com.cir.bre.CircuteBreaker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cir.bre.CircuteBreaker.service.CallResourceService;
import com.cir.bre.CircuteBreaker.service.ServiceRequest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class TestController {
	
	private final ServiceRequest serviceRequest;
	public TestController(ServiceRequest serviceRequest) {
		this.serviceRequest=serviceRequest;
	}
	@GetMapping("/api/test")
	public ResponseEntity<?> getTest(){
		return serviceRequest.getData();
	}
	
}
