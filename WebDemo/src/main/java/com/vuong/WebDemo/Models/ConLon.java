package com.vuong.WebDemo.Models;

import org.springframework.stereotype.Component;

@Component("conLon")
public class ConLon implements Dongvat {
	@Override
	public String Ten() {

		return "Con Lợn";
	}

	@Override
	public String SoChan() {
		return "Bốn chân";
	}

	@Override
	public boolean Bay() {
		return false;
	}
}
