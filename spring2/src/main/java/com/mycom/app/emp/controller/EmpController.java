package com.mycom.app.emp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.app.emp.EmpDTO;
import com.mycom.app.emp.service.EmpService;

import jdk.nashorn.internal.objects.annotations.Getter;

//사원관리 관련 컨트롤러
//컨트롤러클래스임을 알려주는 애너테이션@controller
@Controller
@RequestMapping(value="emp")
public class EmpController {
	//필드
	//EmpService empService = new EmpServiceImpl();
	@Autowired
	private EmpService empService;

	//생성자
	//메서드
	@RequestMapping(value="empDetail.do",method=RequestMethod.GET)
	public String getEmpDetail(HttpServletRequest request,Model modle) {
		//1.파라미터받기
		String strEmpId= request.getParameter("empId");
		int empId = Integer.parseInt(strEmpId);
		//2.비즈니스로직수행 ->service -> DAO
		//private EmpService empService =new EmpServiceImpl(); 
		EmpDTO empDTO= empService.getEmpDetail(empId);
		//3.model
		modle.addAttribute("empDTO",empDTO);
		//4.view
		return "emp/empDetail";
	}
	
	//사원이름목록조회
	@RequestMapping(value="empNameList")
	public String getEmpNameList(Model model) {
		//1.파라미터받기
		//2 비즈니스로직수행 ->service ->DAO -> DB
		//private EmpService empService = new EmpServiceImpl();
		List<String> nameList = empService.getEmpNameList();
		//3.model
		model.addAttribute("nameList",nameList);
		//4.view
		return "emp/empNameList";
	}
	
	//사원목록조회
	@RequestMapping(value="empList")
	public String getEmpList(Model model) {
		//private EmpService empService = new EmpServiceImpl();
		List<EmpDTO> empList =empService.getEmpList();
		model.addAttribute("empList", empList);
		return "emp/empList";
	}
	//요청주소 http://localhost:포트번호/컨패/emp/empList
	//view "/WEB-INF/view/emp/empList.jsp"
	
	
	/* @RequestMapping(
	 * 			value="요청주소",
	 * 			method=RequestMethod.요청방식)
	 *            => GET,POST,PUT,DELETE 
	 * */
	@RequestMapping(value="reqMethod1",method=RequestMethod.GET)
	//@GetMapping("reqMethod1")
	public String requestMethod1(Model model) {
		model.addAttribute("m1","method=RequestMethod.GET 실습");
		//model.addAttribute("m1","@GetMapping 실습");
		return "test/resultView";
	}
	
}
