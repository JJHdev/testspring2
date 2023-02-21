package com.mycom.member.domain;

//회원관련
public class Member {
	private String id;
	private String passwd;
	private String name;
	private String gender;
	private String regdate;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "SimpleMember [id=" + id + ", passwd=" + passwd + ", name=" + name + ", gender=" + gender + ", regdate="
				+ regdate + "]";
	}

	public Member(String id, String passwd, String name, String gender, String regdate) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.gender = gender;
		this.regdate = regdate;
	}
	public Member() {
	}
	
}
