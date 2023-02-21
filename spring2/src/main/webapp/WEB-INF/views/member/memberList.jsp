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
	${memberList}
	<table border="1">
	<thead>
		<tr>
			<th>id</th><th>name</th><th>passwd</th><th>gender</th><th>regdate</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="temp" items="${memberList}">
		<tr>
			<td><a href="<%=request.getContextPath()%>/member/info?memberid=${temp.id}">${temp.id}</a></td>
			<td>${temp.name}</td>
			<td>${temp.passwd}</td>
			<td>${temp.gender}</td>
			<td>${temp.regdate}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</body>
</html>