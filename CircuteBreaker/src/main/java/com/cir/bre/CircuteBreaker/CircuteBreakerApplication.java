package com.cir.bre.CircuteBreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CircuteBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuteBreakerApplication.class, args);
	}

}
