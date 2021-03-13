package ksmart.gentelella.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
	
	@PostConstruct
	public void initialize() {
		System.out.println("======================================");
		System.out.println("======= MenuController bean 등록 ======");
		System.out.println("======================================");
	}
	
	@GetMapping("/addmenu")
	public String addmenu() {
		
		return "menu/addmenu";
	}
	
	@GetMapping("/addrecipy")
	public String addrecipy() {
		
		return "menu/addrecipy";
	}
	
	@GetMapping("/getmenu")
	public String getmenu() {
		
		return "menu/getmenu";
	}
	
	@GetMapping("/getrecipy")
	public String getrecipy() {
		
		return "menu/getrecipy";
	}
	
	
	
}
