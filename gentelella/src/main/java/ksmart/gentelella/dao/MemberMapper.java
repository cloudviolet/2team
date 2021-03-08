package ksmart.gentelella.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.gentelella.domain.Member;

@Mapper
public interface MemberMapper {
	// 회원 수정 처리
	public int modifyMember(Member member);
	
	// 회원 수정 화면으로
	public Member getMemberInfoById(String memberId);
	
	// 회원 등록
	public int addMember(Member member);
	
	// 회원 목록 조회
	public List<Member> getMemberList();
}
