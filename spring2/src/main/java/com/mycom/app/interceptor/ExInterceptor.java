package com.mycom.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.app.HomeController;

/* interceptor(인터셉터)
 특정 url을 요청할 떄 컨트롤러로 가는 요청을 가로채 특정 작업을 처리하는 것을 의미한다.따라서 컨트롤러가 응답(response)하기 전에 가로채므로
 handler interceptor(핸들러 인터셉터)라고도 한다.
 
 -컨트롤러에 들어오는 요청 HttpRequest와 HttpResponse를 가로채는 역할을 한다.
 -인터셉터는
 	컨트롤러에 요청이 들어가기 전!! 
 	컨트롤러에 요청을 수행한 후!!
 	컨트롤러에 요청을 수행하여 view를 보여 준 후!! 
 	
 - 사용예시)
	- spooling = 응답 페이지를 출력하기 전에 서버에서 미리 데이터를 가여오는 기능
	- 요청이 처리되기 전에 파일을 업로드 하는 기능
	- logging = 각 요청에 대한 상세내역을 기록하는 기능
	- calidation = 유효성 검사기능
	- 폼에서 제출이 중복으로 일어나는 것을 막는 기능 
	
	logging = 각요청에 대한 상세내역을 기록하는 기능
	1. 인터셉터 등록 
		<interceptors class="패키지명. 인터셉터클래스명">
			<beans:bean class="com.mycom.app.interceptor.ExInterceptor"></beans:bean>
		</interceptors>
	
	2. 등록된 인터셉터빈 내용 구현
		여기에서는 HandelrInterceptor인터페이스를 구현하여 진행
		HandelrInterceptor인터페이스
		preHandler() : 컨트롤러에 요청이 들어가기 전에 호출 false를 리턴하면 이 후의 내용을 실행하지 x
		postHandler() : 컨트롤러에 요청을 처리 한 후 호출. 컨트롤러에서 예외가 발생하면 더 이상 실행하지 x
		afterHandler() : 컨트롤러에 요청을 처리하여 view전송이 종료 된 후 호출 */
public class ExInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(ExInterceptor.class);
	
	//컨트롤러에 요청이 들어가기 전에 호출되어지면서	 요청 핸들러(컨트롤러)의 실행을 차단한다.
	/*파라미터 
	HttpServletRequest	 : 현재 Http 요청 
	HttpServletResponse	 : 현재 Http 응답
	Object				 : 실행 핸들러 
	리턴타입     boolean - false를 리턴하면 이 후의 내용을 실행하지 x
	*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	throws Exception {
		logger.info("preHandler 호출");
		return true;
	}

	//컨트롤러에 요청을 처리 한 후 호출. 컨트롤러에서 예외가 발생하면 더 이상 실행하지 x
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		logger.info("postHandle 호출");
	}

	//컨트롤러에 요청을 처리하여 view전송이 종료 된 후 호출 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)	throws Exception {
		logger.info("preHandler 호출");
	}
}

