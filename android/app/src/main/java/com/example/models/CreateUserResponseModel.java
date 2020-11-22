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