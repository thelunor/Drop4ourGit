package com.scoder.hs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.scoder.hs.dto.CHUser;
import com.scoder.hs.dto.Generic;
import com.scoder.hs.dto.REA;
import com.scoder.hs.service.SignService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sign")
@Slf4j
public class SignController {

	// application.properties 에 app.upload.dir을 정의하고, 없는 경우에 default 값으로 user.home (System에 종속적인)
	private String uploadDir;

	@Autowired
	private SignService signService;
	//로그인 페이지
	@GetMapping("/loginPage")
	public String login() {
		return "/sign/loginPage";
	}
	//회원가입 첫 페이지
	@GetMapping("/signUpPage")
	public String signUpPage() {
		return "/sign/signUpPage";
	}
	//일반회원 약관동의 페이지
	@GetMapping("/signUpGenericTerms")
	public String signUpGenericTerms() {
		return "/sign/signUpGenericTerms";
	}
	//공인중개사 약관동의 페이지
	@GetMapping("/signUpREATerms")
	public String signUpREATerms() {
		return "/sign/signUpREATerms";
	}
	//공인중개사 정보입력 페이지(마지막 페이지)
	@GetMapping("/signUpREAInfo")
	public String signUpREAInfo() {
		return "/sign/signUpREAInfo";
	}
	//일반회원 정보입력 페이지(마지막 페이지)
	@GetMapping("/signUpGenericInfo")
	public String signUpGenericInfo() {
		return "/sign/signUpGenericInfo";
	}
	//일반회원 회원가입 기능
	@PostMapping("/signUpGenericUser")
	public String signUpGenericUser(CHUser chUser, Generic generic) {
		boolean result = false;
		System.out.println(generic.toString());
		//성공하면 완료페이지, 실패하면 실패 페이지
		try {
			result = signService.signUpGenericUser(chUser, generic);
		} catch (Exception e) {
			System.out.println("Controller signUpGenericUser 예외발생: " + e.getMessage());
		}
		return result ? "redirect:/sign/signUpSuccess" : "redirect:/sign/signUpFailure";
	}

	//공인중개사 회원가입 기능
	@PostMapping("/signUpREAUser")
	public String signUpREAUser(CHUser chUser, REA rea, @RequestParam("reaImage") MultipartFile multipartFile) {
		boolean result = false;
		try {
		} catch (Exception e) {
			System.out.println("Controller signUpREAUser 예외발생: " + e.getMessage());
		}
		return result ? "redirect:/sign/signUpSuccess" : "redirect:/sign/signUpFailure";
	}
	//회원가입 성공 페이지
	@GetMapping("/signUpSuccess")
	public String signUpSuccess() {
		return "/sign/signUpSuccess";
	}
	//회원가입 실패 페이지
	@GetMapping("/signUpFailure")
	public String signUpFailure() {
		return "/sign/signUpFailure";
	}



}
