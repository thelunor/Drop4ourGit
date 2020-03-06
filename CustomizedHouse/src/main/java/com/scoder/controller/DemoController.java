package com.scoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scoder.dto.User;
import com.scoder.repository.UserRepository;
import com.scoder.service.UserService;
import com.scoder.service.UserServiceImpl;


@Controller
public class DemoController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/")
	public String index() {
		System.out.println("index ������!");
		return "index";
	}
	
	@GetMapping("/user/login")
	public String login() {
		System.out.println("login ������!");
		return "login";
	}
	
	@GetMapping("/user/login/result")
	public String loginResult() {
		System.out.println("login �Ϸ� ������!");
		return "loginSuccess";
	}
	
	
	
	@RequestMapping(value = "/user/greeting", method = RequestMethod.GET)
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		System.out.println("��Ʈ�ѷ� Ÿ��?"+name.toString());
        model.addAttribute("name", name);		
		return "greeting";   // html name
	}
	
	@RequestMapping(value = "/user/object", method = RequestMethod.GET)
	public String greeting(Model model) {
		return "object";   // html name
	}
	
	@RequestMapping(value = "/user/save", method = RequestMethod.GET)
	public String save(Model model) {
		return "save";   // html name
	}
	
	
}