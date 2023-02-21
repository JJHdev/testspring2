package com.mycom.app.emp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.app.emp.EmpDTO;
import com.mycom.app.emp.repository.EmpDAOImpl;
//Service역할을 하는 클래스이다.
@Service
public class EmpServiceImpl implements EmpService{

		//필드
		@Autowired
		private EmpDAOImpl empDAO;
		//생성자
		EmpServiceImpl(){System.out.println("EmpServiceImpl의 기본생성자.");};
		//메서드
		@Override
		public EmpDTO getEmpDetail(int empId) {
			EmpDTO empDTO = new EmpDTO();
			empDTO =empDAO.getEmpDetail(empId);	
		return empDTO;
		}
		@Override
		public List<String> getEmpNameList() {
			List<String> list = empDAO.getEmpNameList();
			return list;
		}
		@Override
		public List<EmpDTO> getEmpList() {
			List<EmpDTO> list=empDAO.getEmpList();
			return list;
		}
}
