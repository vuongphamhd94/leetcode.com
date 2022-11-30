package com.vuong.Web01.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	@GetMapping("/")
	public String Index1(Model mode) {
		mode.addAttribute("message", "Xin chao");
		return "Index";
	}

	@PostMapping("/home")
	public String Index(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "home";
	}
}
