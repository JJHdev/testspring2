package com.mycom.app.emp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycom.app.emp.EmpDTO;

//DAO 역할을 하는 클래스
//실제로는 DB와 연동해야하지만 여기에서는 연동했다고 가정하고진행하겠음
@Repository
public class EmpDAOImpl implements EmpDAO {
	//필드
	//생성자
	EmpDAOImpl(){System.out.println("EmpDAOImpl의 기본생성자.");};
	//메서드
	
	@Override
	public EmpDTO getEmpDetail(int empId) {
		EmpDTO empDTO = new EmpDTO("hongid","홍길동","1234",3800);
		return empDTO;
	}
	
	//사원이름목록조회
	@Override
	public List<String> getEmpNameList() {
		List<String> list = new ArrayList<String>();
		list.add(new String("홍길동"));
		list.add(new String("김길동"));
		list.add(new String("이길동"));
		list.add(new String("박길동"));
		return list;
	}

	@Override
	public List<EmpDTO> getEmpList() {
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		EmpDTO empDTO = new EmpDTO();
		list.add(new EmpDTO("hongid","홍길동","1",3000));
		list.add(new EmpDTO("kimid","김길동","12",3000));
		list.add(new EmpDTO("Leeid","이길동","123",3000));
		list.add(new EmpDTO("pdid","대길동","1234",3000));
		return list;
	}
	
	

}
