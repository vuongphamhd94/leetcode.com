package com.vuong.Web01;

import java.util.List;

import com.vuong.Web01.Model.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Web01Application {

	public static void main(String[] args) {
		SpringApplication.run(Web01Application.class, args);
		
		
		String url = "http://localhost:8080/user";
		
		WebClient.Builder builer = WebClient.builder();
		List<User> users = builer.build()
				.method(HttpMethod.GET)
				.uri(url)
				.retrieve()
				.bodyToMono(List.class)
				.block();
		System.out.println("------------------++----");
		System.out.println(users.size());
		
		
		
	}

}
