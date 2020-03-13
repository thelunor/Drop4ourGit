package com.scoder.hs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sale")
public class SaleController {

	@GetMapping("/saleListPage")
	public String saleListPage() {
		System.out.println("난 탄다 컨트롤");
		return "sale/saleListPage";
	}
}
