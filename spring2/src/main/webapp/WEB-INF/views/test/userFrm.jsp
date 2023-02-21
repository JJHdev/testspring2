<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>userFrm.jsp</h3>
	<form name="userFrm" id="userFrm" method="GET" action="<%=request.getContextPath()%>/reqMethod9">
		이름 : <input type="text" name="name" id="name" required="required"><br/>
		이메일 :<input type="text" name="email" id="email" required="required"><br/>
		나이 : <input type="text" name="age" id="age" required="required"><br/>
		성별 : <input type="radio" name="gender" id="gender" value="f" checked="checked">여성<br/>
			 <input type="radio" name="gender" id="gender" value="m" >남성<br/>
		취미: <input type="checkbox" name="hobby" value="baseball" checked="checked">야구
			 <input type="checkbox" name="hobby" value="soccer" checked="checked">축구
			 <input type="checkbox" name="hobby" value="badminturn" checked="checked">배드민턴
			 <input type="checkbox" name="hobby" value="tenise" checked="checked">테니스
			 <input type="submit" value="제출하기">
	</form>
</body>
</html>