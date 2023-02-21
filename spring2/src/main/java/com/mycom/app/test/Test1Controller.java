package com.mycom.app.test;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러 역할을 하는 클래스이다
@Controller
public class Test1Controller {
	//필드
	//생성자
	//메서드
	/*@RequestMapping의 속성
	 * value="요청주소"
	 * method=요청방식 
예)RequestMethod.GET|RequestMethod.POST|RequestMethod.PUT|RequestMethod.DELETE등*/
	//요청주소 http://ip주소:포트번호/컨패/reqMethod1
	@RequestMapping(value="/reqMethod1",method=RequestMethod.GET)
	public String requestMethod1(Model model) {
		model.addAttribute("m1", "method=RequestMethod.GET실습");
		return "test/resultView";
	}
	/*메서드 @RequestMapping
	 HTTP요청방식을 단순화 하고, 요청처리메서드의 의미를 좀 더 잘 표현 
	 스프링 4.3부터 지원하기 시작 
	  =>pom.xml의 <org.springframework-version>4.3.0.RELEASE</org.springframework-version>  
	 @GetMapping은   method=RequestMethod.GET과 동일
	 @PutMapping은   method=RequestMethod.PUT과 동일
	 @DeleteMapping은   method=RequestMethod.Delete과 동일
	 */
	//요청주소 http://ip주소:포트번호/컨패/reqMethod2
	@GetMapping("/reqMethod2")
	public String requestMethod2(Model model) {
		model.addAttribute("m1", "@GetMapping실습");
		return "test/resultView";
	}
  /*@PathVariable 경로 변수
   *웹 요청 url에 포함된 파라미터 값을 전달받는 경로변수와
        이를 처리하는 요청 처리 메서드의 매개변수에 선언하는  @PathVariable
   *웹 요청 url에 포함된 경로변수의 값은       
        요청 처리 메서드의 매개변수    데이터타입에 맞게 자동으로 변환
   *import org.springframework.web.bind.annotation.PathVariable; 
   *문법>@RequestMapping("경로변수")
	public Sting 요청메서드명(@PathVariable 경로변수, ... )*/
	//요청주소 http://ip주소:포트번호/컨패/reqMethod3/sales
	//요청주소 http://ip주소:포트번호/컨패/reqMethod3/develop
	//요청주소 http://ip주소:포트번호/컨패/reqMethod3/marketing
	@GetMapping("/reqMethod3/{dname}")
	public String requestMethod3(Model model,
			                     @PathVariable String dname) {
		model.addAttribute("m1", "@PathVariable 경로 변수");
		System.out.println("@PathVariable String dname="+dname);//콘솔에 출력
		model.addAttribute("dname", dname); //브라우저에 출력
		return "test/resultView";
	}
	//요청주소 http://ip주소:포트번호/컨패/reqMethod4/sales/loc/seoul
	//요청주소 http://ip주소:포트번호/컨패/reqMethod4/develop/loc/jeju
	//요청주소 http://ip주소:포트번호/컨패/reqMethod4/marketing/loc/pusan
	@GetMapping("/reqMethod4/{dname}/loc/{location}")
	public String requestMethod4(Model model,
			                     @PathVariable String dname,
			                     @PathVariable String location) {
		model.addAttribute("m1", "@PathVariable 경로 변수");
		System.out.println("@PathVariable String dname="+dname);//콘솔에 출력
		System.out.println("@PathVariable String location="+location);//콘솔에 출력
		model.addAttribute("dname", dname); //브라우저에 출력
		model.addAttribute("location", location); //브라우저에 출력
		return "test/resultView";
	}
	//인터페이스 Model이용하여 model처리
	//model.addAttribute(String 속성명, Object 값);
	//model.addAttribute(String 속성명, null); null값을 허용
	//요청주소 http://ip주소:포트번호/컨패/reqMethod5
	@GetMapping("/reqMethod5")
	public String requestMethod5(Model model) {
		model.addAttribute("m1", "Model인터페이스 실습");
		model.addAttribute("m2", null); //브라우저에서는 출력x
		return "test/resultView";
	}
   /*ModelAndView클래스를 사용하여 Model과 View지정하기
	*ModelAndView클래스를 사용하면 Model과 View를 한번에 지정할 수 있다
	*import org.springframework.web.servlet.ModelAndView;
	*문법>Model지정시  참조변수명.addObject(String 모델명, Object 값);
	     View지정시    참조변수명.setViewName(String 뷰명);*/
	//요청주소 http://ip주소:포트번호/컨패/reqMethod6
	@GetMapping("/reqMethod6")
	public ModelAndView requestMethod6(ModelAndView mv) {
		mv.addObject("m1", "ModelAndView 실습"); //Model
		mv.setViewName("test/resultView"); //View지정
		return mv;
	}
  /*@RequestParam
    *import org.springframework.web.bind.annotation.RequestParam;
	*문법1> 파라미터명이 매개변수명과 동일할 경우
	        요청메서드(@RequestParam 타입 매개변수명)
		요청메서드(타입 매개변수명)      
	*문법2> 파라미터명을 매개변수명과 다르게 지정할 경우
	        요청메서드(@RequestParam("파라미터명") 타입 매개변수명)
	*여러 속성
	 name="파라미터명"
	 required=true|false.파라미터 필수여부.기본값은 true(필수)
	          true일 때 해당 파라미터가 없으면 Http상태코드 400반환
	          false일때  해당 파라미터가 없으면 해당 파라미터없어도 상관없다
	 defaultValue="" 파라미터가 없거나 빈 값이면 기본값으로 대체하여 사용          */
	//요청주소 http://ip주소:포트번호/컨패/reqMethod7?파라미터명=값&파라미터명=값
	//요청주소 http://ip주소:포트번호/컨패/reqMethod7?bno=100&dname=it
	//요청주소 http://ip주소:포트번호/컨패/reqMethod7?bno=&dname=
	@GetMapping("/reqMethod7")
	public String requestMethod7(Model model,
			@RequestParam int bno,
			@RequestParam String dname) {
		//String 변수명 = request.getParameter("파라미터명");
		//기존의 getParameter()방식은 리턴타입이  String이었으므로
		//필요하면 형변환을 추가적으로 해야 했다
		//String strBno = request.getParameter("bno");
		//int bno = Integer.parseInt(strBno);
		System.out.println("@RequestParam int bno="+(bno*99));//콘솔출력
		System.out.println("@RequestParam String dname="+dname);//콘솔출력
		model.addAttribute("m1","@RequestParam 실습중");
		model.addAttribute("m2",bno*99);
		model.addAttribute("dname",dname);
		return "test/resultView";
	}
	private static final Logger logger = LoggerFactory.getLogger(Test1Controller.class);
	//@RequestParam
	//요청주소  ~컨패/reqMethod7-1?no=&name=
	@RequestMapping("/reqMethod7-1")
	public String requestMethod7_1(Model model,
			HttpServletRequest request,
			@RequestParam(name="no",required=false,defaultValue="1") int bNo,
			@RequestParam(name="name",defaultValue="마케팅") String dname){
		model.addAttribute("m1","@RequestParam 실습중");
		model.addAttribute("m2",bNo*400);
		model.addAttribute("dname",dname);
		return "test/resultView";
	}
	//요청주소  ~컨패/reqMethod8?name=hongGD&email=h@test.com&age=25&gender=f
	@RequestMapping("/reqMethod8")
	public String requestMethod8(Model model,
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam int age,
			@RequestParam String gender) {
		model.addAttribute("m1","@RequestParam 실습중");
		model.addAttribute("MODELname",name);
		model.addAttribute("MODELemail",email);
		model.addAttribute("MODELage",age);
		model.addAttribute("MODELgender",gender);
		return "test/resultView";
	}
	//user정보를 입력할 수 있는 폼요청처리 
	//@RequestMapping(value= {"요청주소1","요청주소2"})
	//여기에서는 아래 2가지 주소로 아래의 요청메서드를 호출할 수 있다
	//요청주소  ~컨패/userFrm
	//요청주소  ~컨패/userAddFrm
	@RequestMapping(value= {"/userFrm","/userAddFrm"})
	public String userFrmShow(Model model) {
		return "/test/userFrm";
	}
	//@RequestMapping(value= {"요청주소1","요청주소2"})
	//@RequestMapping(method= {요청메서드1,요청메서드2})
	//@RequestMapping(method= {RequestMethod.GET,RequestMethod.POST})
	//여기에서는 GET방식 이나 POST방식 둘 다 허용한다
	//요청주소  ~컨패/reqMethod9?name=hongGD&email=h@test.com&age=25&gender=f&hobby=baseball&hobby=movie&hobby=sleep
	//요청주소  ~컨패/reqMethod9-1?name=hongGD&email=h@test.com&age=25&gender=&hobby=baseball&hobby=movie&hobby=sleep
	/* 여기에서는 POST방식에 대해서 테스트하고자 한다면  
	      요청주소  ~컨패/userFrm으로   유저정보를 입력할 수 있는 페이지(userFrm.jsp)를 요청한후
	   userFrm.jsp에서  정보를 입력한 후 
	     확인버튼을 클릭하면 submit되면서  입력하거나 선택한 정보가 
	     아래의 요청메서드를 호출하면서  UserDTO객체의 필드값들이  설정됨을 확인 할 수 있다*/
	@RequestMapping(value={"/reqMethod9","/reqMethod9-1"},
			        method= {RequestMethod.GET,RequestMethod.POST})
	public String requestMethod9(Model model,
			UserDTO userDTO) {
		System.out.println(userDTO);//콘솔출력
		model.addAttribute("m1","parameter를 객체로 생성-실습중");
		model.addAttribute("userDTO",userDTO);
		return "test/resultView";
	}
	//파라미터로 String[]받기
	//요청주소  컨패/reqMethod11?hobby=baseball&hobby=movie&hobby=sleep
	@RequestMapping(value="/reqMethod11")
	public String requestMethod11(Model model,
			@RequestParam  String[] hobby) {
		System.out.println(hobby[0]); //콘솔출력결과 baseball
		System.out.println(hobby[1]); //콘솔출력결과 movie
		System.out.println(hobby[2]); //콘솔출력결과 sleep
		System.out.println(hobby.length); //콘솔출력결과 3
		model.addAttribute("m1","parameter를  String[]받기-실습중");
		return "test/resultView";
	}
	//파라미터로 ArrayList받기
	//요청주소  컨패/reqMethod10?hobby=baseball&hobby=movie&hobby=sleep
	@RequestMapping(value="/reqMethod10")
	public String requestMethod10(Model model,
	      @RequestParam  ArrayList<String> hobby) {
		System.out.println(hobby); //콘솔출력결과 [baseball, movie, sleep]
		System.out.println(hobby.size()); //콘솔출력결과 3
		model.addAttribute("m1","parameter를  ArrayList받기-실습중");
		return "test/resultView";
	}
/*	@GetMapping(value="/reqMethod12")
	public String requestShowFrm() {
		logger.info("@GetMapping 호출"); //콘솔출력
		return "test/userFrm2";
	}
	@PostMapping(value="/reqMethod12")
	public String reqAddUserProc() {
		logger.info("@PostMapping 호출"); //콘솔출력
		return "test/userFrm2";
	}*/
	
	@GetMapping(value="/reqMethod12")
	public String reqShowUserFrm(@ModelAttribute("member") Member member) {
		logger.info("@GetMapping 호출"); //콘솔출력
		return "test/memberFrm";
	}
	@PostMapping(value="/reqMethod12")
	public String reqAddUserProc(@ModelAttribute("member") Member member,
								 Model model) {
		System.out.println("member"+member);
		logger.info("@PostMapping 호출");
		model.addAttribute("member",member);
		return "test/memberInfo";
	}
	@RequestMapping("/logTest")
	public String logTest() {
		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		return "test/logTest";
	}

	// HandlerInterceptor를 구현한 ExInterceptor를 이용하여 로깅작업을 확인하기 위함 
	@GetMapping("/logTest2")
	public String reqMethod15() {
		logger.info("logTest2 로  메서드 진입");
		return "test/resultView";
	}

	@GetMapping("/logTest3")
	public String reqMethod16() {
		logger.info("logTest3 로  메서드 진입");
		return "test/resultView";
	}
	
	// 요청주소~컨패/addmember 
	//memberFrm2.jsp가 보인다.
	@GetMapping("/addmember")
	public String showMemberFrm(@ModelAttribute("NewMember")Member member) {
		logger.info("Member member"+member.toString());
		return "test/memberFrm2";
	}
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("addMember","신규회원등록");
	}
	@PostMapping("/addmember")
	public String newMemberInfo(Model model,@ModelAttribute("NewMember")Member member) {
		logger.info("Member member"+member.toString());
		model.addAttribute("member",member);
		return "test/memberInfo2";
	}
	
	//---메서드 레벨의 @ModelAttribute 개념실습 시작----
	//reqMethod17 밖에서 m1,m2 설정해도 reqMethod17로 들어가면 속성값 m1,m2가 셋팅되어 들어간다.
	//컨트롤러의 요청 메서드가 호출되고
	//View를 리턴하기전에
	// @ModelAttribute으로 선언되 메서드를 호출하여
	// 반환받은 값을 view의 모델로 넘긴다. 
	@GetMapping("/testModelAttribute")
	public String reqMethod17(){
		return "test/resultView";
	}
	//@ModelAttribute("모델명(속성명)")
	@ModelAttribute("m1")
	public String setM1() {
		return "m1이란다~";
	}
	//@ModelAttribute메서드에서 모델명이 지정되지 않고 내부에서 지정해주는 방식.
	@ModelAttribute
	public void setM2(Model model) {
		model.addAttribute("m2","m2이란다짜란짜짠");
	}
	//---메서드 레벨의 @ModelAttribute 개념실습 끝----
	
	@RequestMapping(value="/getMembers",method = {RequestMethod.POST,RequestMethod.GET})
	public String getMembers(Model model ,@ModelAttribute("NewMember")Member member) {
		logger.info(member.toString());
		model.addAttribute("mem",member);
		return "redirect:/memberList";
	}
	
	//회원목록보기 요청
	@RequestMapping(value="/memberList",method = {RequestMethod.POST,RequestMethod.GET})
	public String getMemberList(Model model) {
		List<Member> list = new ArrayList<Member>();
		for(int i=0; i<6;i++) {
			Member m = new Member();
			m.setId(i);
			m.setPasswd("1234"+i);
			m.setCity("경기도");
			m.setGender("남성");
			list.add(m);
		}
		model.addAttribute("list",list);
		return "test/memberList";
	}
	
}


/*
 
요청 메서드에서 view지정
 view redirection (뷰 리다이렉션)
  - 사용자 요청을 하면 요청에 따라 현재 뷰에서 다른 뷰페이지로 이동
  => 페이지 강제 이동
  @ReqiestMapping("최초의 요청url")
  public String 요청메서드명() {
	  return redirect:요청url; or
	  return forward:요청url; 
  }
 1. redirect방식
 	- browser의 요청 url이 변경 되면서 최종 응답 view페이지로 강제 이동
 	- 최초의 요청 후에 다시 요청을 생성하게 된다. 기존의 요청 url은 더이상 유효하지 않게 된다. 
 	사용 예) 데이터에(db(insert,delete,update),session) 변화가 생기는 요청
		   로그인요청, 회원가입, 게시글 등록 
 2. forward방식
 	- borwser의 최초요청 url이 유지되면서 최종 응답 view페이지로 강제 이동
 	- 최초요청 url이 유지되므로 기존의 요청 url은 유효하다.
 	 => 웹브라우저는 다른 페이지로 이동했는지 알 수 없다.
 	 => 또 다른 요청 url을 알수 없다.
 	사용 예) 데이터에(db(select)) 변화가 적거나 없는 요청
		   목록조회, 검색 등

*/



