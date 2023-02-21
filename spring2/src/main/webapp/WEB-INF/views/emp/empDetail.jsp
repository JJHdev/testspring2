<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- EmpDetailController에서 아래와 같이 model을 받았따.
		modle.addAttribute("empDTO",empDTO); -->
 <h3>empDetail.jsp</h3>
 <hr/>
 ${empDTO}<br/>
사원id : ${empDTO.empId}<br/>
사원명 :  ${empDTO.empName}<br/>
비밀번호 :  ${empDTO.pwd}<br/>
급여  :  ${empDTO.sal}<br/>
</body>
</html>
