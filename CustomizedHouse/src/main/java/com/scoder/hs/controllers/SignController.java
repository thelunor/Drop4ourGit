package com.scoder.hs.controllers;

import com.scoder.hs.service.SignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign")
public class SignController {

	private SignService boardService;

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
	public String signUpPage() {
		return "sign/signUpPage";
	}

	@GetMapping("/signUpGenericTerms")
	public String signUpGenericTerms() {
		return "sign/signUpGenericTerms";
	}

	@GetMapping("/signUpREATerms")
	public String signUpREATerms() {
		return "sign/signUpREATerms";
	}

	@GetMapping("/signUpREAInfo")
	public String signUpREAInfo() {
		return "sign/signUpREAInfo";
	}

	@GetMapping("/signUpGenericInfo")
	public String signUpGenericInfo() {
		return "sign/signUpGenericInfo";
	}

	@PostMapping("/signUp")
	public String write(BoardDto boardDto) {
		boardService.savePost(boardDto);

		return "redirect:/signUpSuccess";
	}
}
