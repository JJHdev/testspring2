<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  Spring form태그를 사용하기 위해서는 반드시 아래와 같이 taglib가 선언되어 있어야 한다. 
  form태그 앞에는 prefix에서 명시한 고정값을 붙여야 한다. -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>userFrm.jsp-@</h3>
	<form:form modelAttribute="userDTO" id="userFrm" method="POST" action="<%=request.getContextPath()%>/reqMethod12" >
		이름 : <form:input path="name" id="name" required="required"/><br/>
		이메일 :<form:input path="email" id="email" required="required"/><br/>
		나이 : <form:input path="age" id="age" required="required"/><br/>
		성별 : <form:radiobutton path="gender" id="gender" value="f" checked="checked"/>여성<br/>
			 <form:radiobutton path="gender" id="gender" value="m" />남성<br/>
		취미: <form:checkbox path="hobby" value="baseball" checked="checked"/>야구
			 <form:checkbox path="hobby" value="soccer" checked="checked"/>축구
			 <form:checkbox path="hobby" value="badminturn" checked="checked"/>배드민턴
			 <form:checkbox path="hobby" value="tenise" checked="checked"/>테니스
			 <input type="submit" value="제출하기">
			 <input type="reset" value="취소">
	</form:form>
	<!-- 요청주소 /reqMethod12 get방식 userFrm2.jsp를 보여준다 (폼만 출력)  -->
	<!-- 요청주소 /reqMethod12 post방식 userFrm2.jsp에서 입력한 내용을 submit 처리 -->
	
</body>
</html>