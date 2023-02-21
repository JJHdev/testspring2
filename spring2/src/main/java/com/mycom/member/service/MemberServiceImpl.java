package com.mycom.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.member.domain.Member;
import com.mycom.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberRepository memberRepository;
	//회원등록
	@Override
	public void setNewMember(Member member) {
		memberRepository.setNewMember(member);
	}
	@Override
	public Member getMemberById(String id) {
		Member member = memberRepository.getMemberById(id);
		return member;
	}
	@Override
	public List<Member> getAllMemberList() {
		List<Member> memberList = memberRepository.getAllMemberList();
		return memberList;
	}
	@Override
	public void modiMember(Member member) {
		memberRepository.modiMember(member);
		
	}
	@Override
	public void DeleteMember(Member member) {
		memberRepository.deleteMember(member);
	}
}
