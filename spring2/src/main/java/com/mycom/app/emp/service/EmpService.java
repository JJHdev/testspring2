package com.mycom.app.emp.service;

import java.util.List;

import com.mycom.app.emp.EmpDTO;

public interface EmpService {
	//상수
	//추상메서드
	//사원상세보기 select * from emp where empid=?
	public abstract EmpDTO getEmpDetail(int empId);
	
	//사원이름목록조회 select ename from emp;
	public abstract List<String> getEmpNameList();
	
	//사원목록조회 select * from emp;
	public abstract List<EmpDTO> getEmpList();
}
