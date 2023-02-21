<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head> 
<body>
http://localhost:8083/app/main
/views/member/main.jsp문서
  <h2>${greeting}</h2>
  <hr/>
  <ul> 
   	<li><a href="member/add">회원가입 (상대주소 방식)</a></li>
   	<li><a href="<%=request.getContextPath()%>/member/add">회원가입 (절대주소 방식)</a></li>
  </ul>
</body>
</html>