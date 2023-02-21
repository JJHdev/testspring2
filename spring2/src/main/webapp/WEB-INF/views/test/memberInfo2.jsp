<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>${addMember}</h4>

id: ${member.id}<br/>
passwd: ${member.passwd}<br/>
city: ${member.city}<br/>
gender: ${member.gender}<br/>
hobby: ${member.hobby[0]}<br/>

<table border="1">
	<thead>
		<tr>
			<th>모델명</th><th>index</th><th>count</th><th>current</th><th>first</th><th>last</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="temp" items="${member.hobby}" varStatus="status">
		<tr>
			<td>${temp}</td>
			<td>${status.index}</td>
			<td>${status.count}</td>
			<td>${status.current}</td>
			<td>${status.first}</td>
			<td>${status.last}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<pre>
	status.index : 0부터 시작. 반복의 인덱스번호
	status.count: 1부터 시작 현재 몇번째 반복인지를 나타내는 값
	status.current : 넘어온 배열 값
	status.first : 처음에만 true를 리턴
	status.last : 마지막에만 true를 리턴
</pre>

</body>
</html>