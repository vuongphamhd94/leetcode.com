package com.vuong.WebNextFlix.Controller;

import java.util.List;

import com.vuong.WebNextFlix.Mapper.UsersMapper;
import com.vuong.WebNextFlix.Mode.Users;
import com.vuong.WebNextFlix.Mode.UsersExample;
import com.vuong.WebNextFlix.Mode.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@ResponseBody
public class HomePageController {
	
	@Autowired
	UsersMapper usersMapper;
	@Autowired
	test tes;
	@GetMapping("/")
	public String index() {
		ModelAndView modelAndView = new ModelAndView("index");
//		UsersExample example = new UsersExample();
//		example.createCriteria().andIdEqualTo(1l);
//		List<Users> listUser = usersMapper.selectByExample(example);
//		
//		for(Users item : listUser) {
//			System.out.println(item.getId() + ": " + item.getFullName());
//		}
		
		System.out.println(tes.Demo());
		return "index";
	}
}
