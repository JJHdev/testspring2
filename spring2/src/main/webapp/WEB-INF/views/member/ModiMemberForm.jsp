<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원정보 수정 form</h3>
	수정하고자 하는 회원id =${memberid}
	<form:form id="ModiMemberFrm" modelAttribute="UpdateMember"  method="post" action="./update">
		<table border="1">
			<tr>
				<th>성별</th>
				<form:hidden path="id" value="${memberid}"/>
				<th><form:input path="gender" value="${member.gender}"/></th>
			</tr>
			<tr>
				<th>비밀번호</th>
				<th><form:password path="passwd"/></th>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="비번수정하기">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form:form>	
</body>
</html>