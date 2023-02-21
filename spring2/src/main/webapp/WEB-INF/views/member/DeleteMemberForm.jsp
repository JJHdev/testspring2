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
	<form:form id="deleteMemberFrm" modelAttribute="DeleteMember" method="post" action="./delete">
		<table border="1">
			<tr>
				<th>회원 id</th>
				<th><form:input path="id"/></th>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="삭제하기">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form:form>	
</body>
</html>