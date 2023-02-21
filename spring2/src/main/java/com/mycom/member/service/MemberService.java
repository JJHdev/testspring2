package com.mycom.member.service;

import java.util.List;

import com.mycom.member.domain.Member;

public interface MemberService {
	//회원등록처리
	public void setNewMember(Member member);
	//회원id로 상세회원정보 조회
	public abstract Member getMemberById(String id);
	public abstract List<Member> getAllMemberList();
	public abstract void modiMember(Member member);
	public abstract void DeleteMember(Member member);
}
