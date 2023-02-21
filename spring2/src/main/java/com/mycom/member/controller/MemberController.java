package com.mycom.member.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.app.HomeController;
import com.mycom.member.domain.Member;
import com.mycom.member.service.MemberService;
@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private MemberService memberService;
	
	// 회원가입폼 보여줘
	@GetMapping("/add")
	public String requestAddMemberForm(@ModelAttribute("NewMember") Member simpleMember) {
		return "/member/addMember";
	}
	

	@PostMapping("/add")
	public String submitAddMember(Model model,@ModelAttribute("NewMember") Member Member) {
		memberService.setNewMember(Member);
		return "/test/resultView";
	}
	
	//회원 id로 상세회원정보 조회
	@GetMapping("/info")
	public String reqeustMemberById(Model model,@RequestParam("memberid") String id) {
		Member member = memberService.getMemberById(id);
		model.addAttribute("member",member);
		return "member/memberInfo";
	}
	
	//회원목록조회
	//요청주소 ~ 컨패/
	@GetMapping("/list")
	public ModelAndView requestAllMemberList(ModelAndView mv) {
		List<Member> memberList = memberService.getAllMemberList();
		mv.addObject("memberList",memberList);
		mv.setViewName("member/memberList");
		return mv;
	} 
	
	//비밀번호 수정폼 요청 (get, update)
	@GetMapping("/update")
	public ModelAndView requestModiMemberForm(String memberid, @ModelAttribute("UpdateMember") Member member,ModelAndView mv) {
		logger.info(memberid);
		//수정폼에는 수정하고자 하는 특정회원의 정보데이터가 출력이 되어 있어야 하므로 특정회원의 정보를 가져와 Model처리하여 view로 넘긴다. 
		member = memberService.getMemberById(memberid);
		mv.addObject("member",member);
		mv.addObject("memberid",memberid);
		mv.setViewName("member/ModiMemberForm");
		return mv;
	}
	
	//비밀번호 수정처리 (post, update)
	@PostMapping("/update")
	public String submitModiMember(@ModelAttribute("UpdateMember") Member member){
		logger.info(member.toString());
		memberService.modiMember(member);
		return "redirect:/member/list";
	}
	
	//비밀번호 삭제폼 요청 (get, update)
	@GetMapping("/delete")
	public ModelAndView requestDeleteMemberForm(String memberid, @ModelAttribute("DeleteMember") Member member,ModelAndView mv) {
		logger.info(memberid);
		//수정폼에는 수정하고자 하는 특정회원의 정보데이터가 출력이 되어 있어야 하므로 특정회원의 정보를 가져와 Model처리하여 view로 넘긴다. 
		member = memberService.getMemberById(memberid);
		mv.addObject("member",member);
		mv.addObject("memberid",memberid);
		mv.setViewName("member/DeleteMemberForm");
		return mv;
	}
	
	//비밀번호 삭제처리 (post, update)
	@PostMapping("/delete")
	public String submitDeleteMember(@ModelAttribute("DeleteMember") Member member){
		logger.info(member.toString());
		memberService.DeleteMember(member);
		return "redirect:/member/list";
	}
	
}
