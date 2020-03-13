package com.scoder.hs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rea")
public class REAController {
	
	@GetMapping("/reaMain")
	public String mainPage() {
		//공인중개사 소개 정보 가져와서 뿌려줘야 함
		return "rea/reaMain";
	}
	@GetMapping("/myPage")
	public String myPage() {
		return "rea/myPage";
	}
	@GetMapping("/introPage")
	public String introPage() {
		return "rea/introPage";
	}

}
