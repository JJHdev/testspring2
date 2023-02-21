<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<!--  Home Controller에 의해서 Model받았다.
	model.addAttribute("serverTime", formattedDate );
	model.addAttribute("mid","hongid");
	model.addAttribute("mage",30);
	request.setAttribute("mpwd","1234"); -->
<h1>Hello world!</h1>

<P>  The time on the server is ${serverTime}. </P>
 현재시간= ${serverTime} <br/>
 *회원id= ${mid} <br/>
 *회원나이= ${mage} <br/>
 *회원비번= ${mpwd} <br/>
</body>
</html>
