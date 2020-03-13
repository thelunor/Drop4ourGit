package com.scoder.hs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scoder.hs.dto.CHUserCustom;
import com.scoder.hs.dto.REA;
import com.scoder.hs.service.REAService;

@Controller
@RequestMapping("/rea")
public class REAController {
	
	@Autowired
	private REAService reaService;
	
	@GetMapping("/reaMain")
	public String mainPage(@AuthenticationPrincipal CHUserCustom chuserCustom, Model model) {
		System.out.println("공인중개사 메인!");
		System.out.println("유저 아이디?"+chuserCustom.getUsername());
		REA rea = reaService.getReaInfo(chuserCustom.getUsername());
		model.addAttribute("rea", rea);
		//공인중개사 정보 & 사무실 소개 정보 가져와서 뿌려줘야 함
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
