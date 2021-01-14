package com.example.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CreateUserResponseModel {

	@SerializedName("is_active")
	private boolean isActive;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("items")
	private List<Object> items;

	@SerializedName("email")
	private String email;

	@SerializedName("is_student")
	private boolean is_student;

	@SerializedName("is_teacher")
	private boolean isTeacher;

	@SerializedName("is_education_employee")
	private boolean isEducationEmployee;


	public boolean isIs_student() {
		return is_student;
	}

	public void setIs_student(boolean is_student) {
		this.is_student = is_student;
	}

	public boolean isTeacher() {
		return isTeacher;
	}

	public void setTeacher(boolean teacher) {
		isTeacher = teacher;
	}

	public boolean isEducationEmployee() {
		return isEducationEmployee;
	}

	public void setEducationEmployee(boolean educationEmployee) {
		isEducationEmployee = educationEmployee;
	}

	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}

	public boolean isIsActive(){
		return isActive;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setItems(List<Object> items){
		this.items = items;
	}

	public List<Object> getItems(){
		return items;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}