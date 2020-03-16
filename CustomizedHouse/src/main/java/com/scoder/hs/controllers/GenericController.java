package com.scoder.hs.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scoder.hs.dto.CHUserCustom;

@Controller
@RequestMapping("/generic")
public class GenericController {
	@GetMapping("/genMainPage")
	public String genMainPage(@AuthenticationPrincipal CHUserCustom chuserCustom, Model model) {
		System.out.println("일반 회원 메인 타니?");
		model.addAttribute("user", chuserCustom);
		return "generic/main";
	}
	
	@GetMapping("/myPage")
	public String myPage() {
		System.out.println("일반 회원 마이페이지 타니?");
		return "generic/myPage";
	}
}
