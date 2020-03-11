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
        return "/index";
    }
		
	
	@GetMapping("/user/login")
	public String login() {
		System.out.println("로그인??");
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
		return "greeting";   
	}
	
	@RequestMapping(value = "/user/object", method = RequestMethod.GET)
	public String greeting(Model model) {
		return "object";   
	}
	
	@RequestMapping(value = "/user/save", method = RequestMethod.GET)
	public String save(Model model) {
		return "save";  
	}
	
	
}
