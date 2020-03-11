package com.scoder.hs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign")
public class SignController {

	@GetMapping("/loginPage")
	public String login() {
		return "sign/loginPage";
	}
	@GetMapping("/signUpPage")
	public String join() {
		return "sign/signUpPage";
	}

}
