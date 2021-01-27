package com.robertbuckley.strings;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping("/")
	public String main() {
		return ("Hello client! How are you today?");
	}
	@RequestMapping("/random")
	public String random() {
		return "Spring boot is real easy to use!";
	}
}
