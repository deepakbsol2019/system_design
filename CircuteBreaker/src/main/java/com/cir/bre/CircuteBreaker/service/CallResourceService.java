package com.cir.bre.CircuteBreaker.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
		name="ResourceService",
		url="${Resource.service.url}"
		)
public interface CallResourceService {
	@GetMapping("/api/test")
	public ResponseEntity<String> getData();

}
