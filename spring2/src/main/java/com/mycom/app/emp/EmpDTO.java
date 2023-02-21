package com.mycom.app.emp;

//사원관련 DTO클래스
public class EmpDTO {
	//필드
	private String empId; //사원ID
	private String empName; //사원명
	private String pwd;   //비번
	private int sal;     //급여
	//생성자
	public EmpDTO(String empId, String empName, String pwd, int sal) {
		this.empId = empId;
		this.empName = empName;
		this.pwd = pwd;
		this.sal = sal;
	}
	public EmpDTO() {}
	//메서드
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "EmpDTO [empId=" + empId + ", empName=" + empName + ", pwd=" + pwd + ", sal=" + sal + "]";
	}
}
