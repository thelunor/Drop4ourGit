package com.scoder.hs.controllers;

import com.scoder.hs.dto.CHUser;
import com.scoder.hs.dto.Generic;
import com.scoder.hs.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sign")
@Slf4j
public class SignController {

	@Autowired
	private SignService signService;

	@GetMapping("/loginPage")
	public String login() {
		return "/sign/loginPage";
	}
	
	@GetMapping("/signUpPage")
	public String signUpPage() {
		return "/sign/signUpPage";
	}

	@GetMapping("/signUpGenericTerms")
	public String signUpGenericTerms() {
		return "/sign/signUpGenericTerms";
	}

	@GetMapping("/signUpREATerms")
	public String signUpREATerms() {
		return "/sign/signUpREATerms";
	}

	@GetMapping("/signUpREAInfo")
	public String signUpREAInfo() {
		return "/sign/signUpREAInfo";
	}

	@GetMapping("/signUpGenericInfo")
	public String signUpGenericInfo() {
		return "/sign/signUpGenericInfo";
	}

	@PostMapping("/signUpGenericUser")
	public String signUpGenericUser(CHUser chUser, Generic generic) {
		boolean result = false;
		System.out.println(generic.toString());
		try {
			result = signService.signUpGenericUser(chUser, generic);
		} catch (Exception e) {
			System.out.println("Controller signUpGenericUser 예외발생: " + e.getMessage());
		}
		return result ? "redirect:/sign/signUpSuccess" : "redirect:/sign/signUpFailure";
	}

	@GetMapping("/signUpSuccess")
	public String signUpSuccess() {
		return "/sign/signUpSuccess";
	}

	@GetMapping("/signUpFailure")
	public String signUpFailure() {
		return "/sign/signUpFailure";
	}

}
