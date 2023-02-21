<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>memberList</h3>
	<c:forEach items="${list}" var="temp">
		${temp.id}
		${temp.passwd}
		${temp.city}
		${temp.gender}<br/>
	</c:forEach>
</body>
</html>