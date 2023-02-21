package com.mycom.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//요청메서드 @RequestMapping를 선언하면 된다
		/*value = "요청url" 
		  method = 요청방식  예)RequestMethod.GET|RequestMethod.POST|RequestMethod.PUT|RequestMethod.DELETE등)*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		//model 처리
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("mid","hongid");
		model.addAttribute("mage",30);
		request.setAttribute("mpwd","1234");
		
		//기존방식  return "views/home.jsp"   
				//       "경로/"+파일명+".jsp"
				/*servlet-context.xml에서 설정
				  <beans:property name="prefix" value="/WEB-INF/views/" />
				  <beans:property name="suffix" value=".jsp" />   */
		return "home";
	}
	
}
