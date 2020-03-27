package com.scoder.hs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scoder.hs.dto.CHUserCustom;
import com.scoder.hs.dto.REA;
import com.scoder.hs.dto.REAIntroBoard;
import com.scoder.hs.dto.Sale;
import com.scoder.hs.service.REAService;

@Controller
@RequestMapping("/rea")
public class REAController {
	
	@Autowired
	private REAService reaService;
	
	@GetMapping("/reaMain")
	public String mainPage(@AuthenticationPrincipal CHUserCustom chuserCustom, Model model) {
		System.out.println("공인중개사 메인!");
		System.out.println("커스텀 된 객체?"+chuserCustom.toString());
		REA rea = reaService.getReaInfo(chuserCustom.getUsername());
		model.addAttribute("user", chuserCustom);
		model.addAttribute("rea", rea);
		
		//공인중개사 소개 & 후기 없을 때 어떻게 처리할 지 넣기
		
		//공인중개사 소개 가져오기!
		REAIntroBoard reaIntroBoard = reaService.getReaIntro(chuserCustom.getUsername());
				
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
	public String introPageWrite() {
		System.out.println("소개페이지 글쓰기 타니?");
		String path = "";

		//@AuthenticationPrincipal CHUserCustom chuserCustom, REAIntroBoard reaIntroBoard
		
//		boolean result = reaService.saveReaIntro(reaIntroBoard);
//		if(result) {
//			path = "redirect:/rea/reaMain";
//		} else {
//			path = "redirect:/rea/introPageWrite";
//		}
		return path;
	}
	
	@GetMapping("/reaSale")
	public String salePage(@AuthenticationPrincipal CHUserCustom chuserCustom, Model model) {
		//공인중개사 정보 가져와서 뿌리기
		REA rea = reaService.getReaInfo(chuserCustom.getUsername());
		model.addAttribute("user", chuserCustom);
		model.addAttribute("rea", rea);
		return "rea/reaSalePage";
	}
	
	@GetMapping("/addSale")
	public String addSalePage() {
		return "rea/saleAddPage";
	}
	
	//매물 등록하기
	@PostMapping("/addSale")
	public String addSale(Sale sale, @AuthenticationPrincipal CHUserCustom chuserCustom) {
		System.out.println("매물 등록!");
		System.out.println(sale.toString());
		//서비스 연결 -> db 저장
		boolean result = reaService.saveSale(sale);
		System.out.println("매물 저장 됨?");
		
		
		return "rea/saleAddPage";
	}
	

}
