package com.vuong.WebDemo.Models;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("chim")
//@Primary //chỉ đinh Beam được ưu tiên  khi khởi tạo interface (trường hợp có nhiều lớp cùng implements một interface)
public class Chim implements Dongvat {

	@Override
	public String Ten() {

		return "Chim chào mào";
	}

	@Override
	public String SoChan() {

		return "Hai chân";
	}

	@Override
	public boolean Bay() {
		return true;
	}

	@PostConstruct // chỉ định một hàm sẽ được chạy ngay sau khi 1 bean được tạo và đưa vào quản lý
	public void Hello() {
		System.out.println("Xin chào!");
	}

	@PreDestroy // Chỉ định một hàm sẽ được chạy trước khi 1 Bean bị hủy bỏ
	public void Bye() {
		System.out.println("Tạm biệt");
	}

}
