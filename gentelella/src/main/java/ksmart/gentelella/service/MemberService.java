package ksmart.gentelella.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.gentelella.domain.Member;
import ksmart.gentelella.dao.MemberMapper;

@Service
public class MemberService {
	/*
	//1. DI 필드 주입방식
	@Autowired
	private MemberMapper memberMappper;
	
	//2. DI SETTER 메소드 주입방식
	private MemberMapper memberMappper2;
	public void setMemberMapper(MemberMapper memberMapper){
		this.memberMappper2 = memberMapper;
	}
	 */
	
	@PostConstruct
	public void initialize() {
		System.out.println("======================================");
		System.out.println("======= MembrService bean 등록 =========");
		System.out.println("======================================");
	}
	
	//3. DI 생성자 메소드 주입방식
	private final MemberMapper memberMapper;
	
	//3-1. spring framework 4.3 이후 부터 @Autowired 쓰지 않아도 주입가능
	@Autowired
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper= memberMapper;
	}
	
	public List<Member> getMemberList(){
		List<Member> memberList = memberMapper.getMemberList();
		int memberListSize = memberList.size();
		for(int i = 0 ; i < memberListSize ; i++) {
			int level = memberList.get(i).getMemberLevel();
			if(level==1) {
				memberList.get(i).setMemberLevelName("관리자");
			}else if(level == 2) {
				memberList.get(i).setMemberLevelName("판매자");
			}else if(level == 3) {
				memberList.get(i).setMemberLevelName("구매자");
			}
		}
		return memberList;
	}
		
	public Member getMemberInfoById(String memberId) {
		return memberMapper.getMemberInfoById(memberId);
	}
	
	public int addMember(Member member) {
		int result = memberMapper.addMember(member);
				
		return result;
	}
	public int modifyMember(Member member) {
		int result = memberMapper.modifyMember(member);
		
		return result;
	}
	
}
