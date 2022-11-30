package com.vuong.WebDemo.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Configurations {
	private String name;
	public Configurations(String name) {
		this.name = name;
	}

	public String hello() {
		return this.name;

	}
}

