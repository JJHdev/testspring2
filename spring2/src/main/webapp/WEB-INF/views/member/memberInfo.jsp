<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${member}
	<ul>
		<li>id:${member.id}</li>
		<li>name:${member.name}</li>
		<li>passwd:${member.passwd}</li>
		<li>gender:${member.gender}</li>
		<li>regdate:${member.regdate}</li>
	</ul>
	<span><a href="<%=request.getContextPath()%>/member/update?memberid=${member.id}">비번 수정</a></span>
	<span><a href="<%=request.getContextPath()%>/member/delete?memberid=${member.id}">회원삭제</a></span>
</body>
</html>