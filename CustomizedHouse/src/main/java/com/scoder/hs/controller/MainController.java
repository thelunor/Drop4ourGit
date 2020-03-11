package com.scoder.hs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scoder.hs.service.UserServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "loginPage";
	}
	
	@GetMapping("/joinPage")
	public String join() {
		return "joinPage";
	}
	


	@GetMapping("admin/adminPage")
	public String adminPage() {
		return "adminPage";
	}
	
	
}
