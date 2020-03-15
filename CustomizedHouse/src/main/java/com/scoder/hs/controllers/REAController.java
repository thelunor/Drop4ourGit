package com.scoder.hs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.scoder.hs.dto.CHUserCustom;
import com.scoder.hs.dto.REA;
import com.scoder.hs.dto.REAIntroBoard;
import com.scoder.hs.service.REAService;

@Controller
@RequestMapping("/rea")
public class REAController {
	
	@Autowired
	private REAService reaService;
	
	@GetMapping("/reaMain")
	public String mainPage(@AuthenticationPrincipal CHUserCustom chuserCustom, Model model) {
		System.out.println("공인중개사 메인!");
		REA rea = reaService.getReaInfo(chuserCustom.getUsername());
		model.addAttribute("user", chuserCustom);
		model.addAttribute("rea", rea);
		//공인중개사 소개 가져오기!
		REAIntroBoard reaIntroBoard = reaService.getReaIntro(chuserCustom.getUsername());
		System.out.println("후기글 가져와?"+reaIntroBoard.toString());
		model.addAttribute("reaIntroBoard", reaIntroBoard);
		
		//공인중개사 후기 가져오기
		
		return "rea/reaMain";
	}
	@GetMapping("/myPage")
	public String myPage() {
		return "rea/myPage";
	}
	@GetMapping("/introPage")
	public String introPage() {
		return "rea/reaIntroPage";
	}
	
	@PostMapping("/introPageWrite")
	public String introPageWrite(@AuthenticationPrincipal CHUserCustom chuserCustom, REAIntroBoard reaIntroBoard) {
		String path = "";
		reaIntroBoard.setUserId(chuserCustom.getUsername());
		String str = reaIntroBoard.getIntroContent();
		str.replace("<p>", "");
		
		boolean result = reaService.saveReaIntro(reaIntroBoard);
		if(result) {
			path = "redirect:/rea/reaMain";
		} else {
			path = "redirect:/rea/introPageWrite";
		}
		return path;
	}

}
