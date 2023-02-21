package com.mycom.app.emp.repository;

import java.util.List;

import com.mycom.app.emp.EmpDTO;

public interface EmpDAO {
	//접근제어자 abstract 메서드명(매개변수);  추상메서드
	//사원상세보기
	public abstract EmpDTO getEmpDetail(int empId);
	public abstract List<String> getEmpNameList();
	public abstract List<EmpDTO> getEmpList();
}
