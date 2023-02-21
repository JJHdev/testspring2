package com.mycom.member.repository;

import java.util.List;

import com.mycom.member.domain.Member;

public interface MemberRepository {

	public void setNewMember(Member member);

	public Member getMemberById(String id);
	public List<Member> getAllMemberList();
	public void modiMember(Member member);
	public void deleteMember(Member member);
}
