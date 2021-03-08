package ksmart.gentelella.controller;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.gentelella.domain.Member;
import ksmart.gentelella.service.MemberService;

@Controller
public class CommonController {
	@Autowired
	private MemberService memberService;
	
	@PostConstruct
	public void initialize() {
		System.out.println("======================================");
		System.out.println("======= MembrController bean 등록 ======");
		System.out.println("======================================");
	}
	
	@GetMapping("/")
	public String main() {
		
		return "index";
	}
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
	//required = get방식으로 전달하지 않아도 받기위해서  값이 필수적인가?,defaultValue= "get방식"
	@GetMapping("/modifyMember")
	public String modifyMember(Model model, @RequestParam(name="memberId", required= false) String memberId) {
		System.out.println("memberId start");
		System.out.println("memberId >>" + memberId);
		System.out.println("memberId stop");
		
		Member member = memberService.getMemberInfoById(memberId);
		System.out.println(member +"<<service getMemberInfoById");
		model.addAttribute("member",member);
		return "member/modifyMember";
	}
	@PostMapping("/modifyMember")
	public String modifyMember(Member member) {
		System.out.println(member +"modifyMember");
		int result = memberService.modifyMember(member);
		return "redirect:/memberList";
	}
	
	@GetMapping("/memberList")
	public String getMemberList(Model model) {
		List<Member> memberList = memberService.getMemberList();
		System.out.println("memberList start");
		System.out.println(memberList);
		System.out.println("memberList stop");
		model.addAttribute("memberList",memberList);
		return "member/memberList";
	}
	
	@PostMapping("/addMember")
	public String addMember(Member member) {
		System.out.println("-----member start-----");
		System.out.println(member + "<<member");
		System.out.println("-----member end-----");
		// 회원 등록
		if(member != null && !"".equals(member.getMemberId())) {
			memberService.addMember(member);
		}
		return "redirect:/memberList";
	}
	
	@RequestMapping(value ="/addMember", method= RequestMethod.GET)
	public String addMember() {
		return "member/addMember";
	}
	
}
