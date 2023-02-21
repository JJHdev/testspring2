package com.mycom.app.test;

import java.util.Arrays;

public class UserDTO {
	//필드
	private String name;
	private String email;
	private int age;
	private String gender;
	private String[] hobby; //취미는 체크박스.다중선택이므로 String배열
	
	//생성자
	public UserDTO() {}
	public UserDTO(String name, String email, int age, String gender) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.gender = gender;
	}
	
	
	public UserDTO(String name, String email, int age, String gender, String[] hobby) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.hobby = hobby;
	}
	//메서드 setter&getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", email=" + email + ", age=" + age + ", gender=" + gender + ", hobby="
				+ Arrays.toString(hobby) + "]";
	}
}