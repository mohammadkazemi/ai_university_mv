package com.example.models;

import com.google.gson.annotations.SerializedName;

public class CreateUserBodyModel{

	@SerializedName("password")
	private String password;

	@SerializedName("name")
	private String name;

	@SerializedName("email")
	private String email;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}