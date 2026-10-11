package com.resource.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/api/test")
	public ResponseEntity<String> getData(){
		System.out.println("This is Resource Service");
		return new ResponseEntity<>("Successfull",HttpStatus.OK);
	}

}
