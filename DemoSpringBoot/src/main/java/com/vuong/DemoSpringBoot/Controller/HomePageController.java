package com.vuong.DemoSpringBoot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
	@GetMapping("/quickstart")
	public String quickstart() {
		return "Hello Spring Boot!";
	}
	@GetMapping("/")
	public String PageIndex() {
		return "Hello Index Page";
	}
}
