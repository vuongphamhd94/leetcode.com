package com.vuong.WebDemo.Models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuration_Bean {
	@Bean
	public Configurations  Demo() {
		return new Configurations("vuong");
	}
}
