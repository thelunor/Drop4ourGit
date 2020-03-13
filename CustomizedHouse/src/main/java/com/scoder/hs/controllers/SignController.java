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
//	@GetMapping("/loginSuccess") -> 테스트용
//	public String loginSuccess(@AuthenticationPrincipal CHUserCustom chuserCustom) {
//		System.out.println("이거 타니?");
//		System.out.println("유저"+chuserCustom.toString());
//		return "index";
//	}
	
	@GetMapping("/signUpPage")
	public String join() {
		return "sign/signUpPage";
	}

}
