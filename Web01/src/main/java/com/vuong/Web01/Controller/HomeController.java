package com.vuong.Web01.Controller;

import java.util.ArrayList;
import java.util.List;

import com.vuong.Web01.Model.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	private List<User> list = new ArrayList<User>();
	
	@GetMapping("/user")
	public List<User> index() {
		return list;
	}
	@PostMapping("/user")
	public User cerate(@RequestBody User model) {
		list.add(model);
		return model;
	}
	@PutMapping("/user")
	public User update(@RequestBody User model) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(model.getName())) {
				list.set(i, model);
				break;
			}
		}
		
		return model;
	}
	@DeleteMapping("/user")
	public void delete(@RequestParam(name = "name") String name) {
		System.out.println("name: " + name);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(name)) {
				list.remove(i);
				break;
			}
		}
	}

}
