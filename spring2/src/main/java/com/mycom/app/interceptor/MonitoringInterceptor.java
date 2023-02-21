package com.mycom.app.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MonitoringInterceptor implements HandlerInterceptor {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	//spring frame work에서 제공하는 StopWatch
	ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	throws Exception {
		StopWatch stopWatch= new StopWatch(handler.toString());
		stopWatch.start(handler.toString()); //타이머 시작한다.
		stopWatchLocal.set(stopWatch);
		
		logger.info("접근경로 :"+getURLPath(request));
		logger.info("요청처리 시작 시간 :"+getCurrentTime());
		//logger.info("preHandler() 호출");
		return true;
	}

	//컨트롤러에 요청을 처리 한 후 호출. 컨트롤러에서 예외가 발생하면 더 이상 실행하지 x
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		logger.info("요청처리 종료 시간 :"+getCurrentTime());
		//logger.info("postHandle() 호출");
	}

	//컨트롤러에 요청을 처리하여 view전송이 종료 된 후 호출 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)	throws Exception {
		StopWatch stopWatch= stopWatchLocal.get();
		stopWatch.stop();
		logger.info("요청 view 전송 후 시간 :"+stopWatch.getTotalTimeMillis()+"ms");
		stopWatchLocal.set(null);
		logger.info("=======================");
		//logger.info("afterCompletion() 호출");
	}
	
	// 접근경로 구하기
	/*
	 * 요청주소 Http://localhost:8083/app/qwert 
	 * currPath = request.getRequestURI() = /app/WEB-INF/views/home.jsp 
	 * queryS = request.getQueryString() =null 
	 * 요청주소 Http://localhost:8083/app/qwert?q=1&w=123 
	 * currPath = request.getRequestURI() b= /app/WEB-INF/views/home.jsp 
	 * queryS = request.getQueryString(); = q=1&w=123
	 */
	private String getURLPath(HttpServletRequest request) {
		String currPath = request.getRequestURI();
		String queryS = request.getQueryString();
		queryS= queryS==null? "": "?"+queryS;
		return currPath+queryS;
	}
	
	//현재 시스템의 시간구하기
	private String getCurrentTime() {
		//현재시간
		Calendar today =Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy/MM//dd HH:mm:ss");
		today.setTimeInMillis(System.currentTimeMillis());
		//현재 시간에 날짜 시간패턴 입히기 
		return df.format(today.getTime());
	}
}
