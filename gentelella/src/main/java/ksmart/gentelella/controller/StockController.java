package ksmart.gentelella.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {
	
	@PostConstruct
	public void initialize() {
		System.out.println("======================================");
		System.out.println("======= StockController bean 등록 ======");
		System.out.println("======================================");
	}
	
	@GetMapping("/addarticle")
	public String addarticle() {
		
		return "stock/addarticle";
	}
	
	@GetMapping("/addskk")
	public String addskk() {
		
		return "stock/addskk";
	}
	
	@GetMapping("/getarticle")
	public String getarticle() {
		
		return "stock/getarticle";
	}
	
	@GetMapping("/getskk")
	public String getskk() {
		
		return "stock/getskk";
	}
	
	@GetMapping("/getstock")
	public String getstock() {
		
		return "stock/getstock";
	}
	
	@GetMapping("/gettotalstock")
	public String gettotalstock() {
		
		return "stock/gettotalstock";
	}
}
