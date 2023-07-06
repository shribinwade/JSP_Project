package com.form.dto;

public class formDTO {
 
 private Integer user_id;
 private String user_name;
 private String user_email;
 private int user_phone;
 private String user_state;
 private String user_city;
 
//*************************************************
 public int getUser_phone() {
	return user_phone;
}

public void setUser_phone(int user_phone) {
	this.user_phone = user_phone;
}

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	} 



public Integer getUser_id() {
		return user_id;
	}
 
 //***************************************************
 public String getUser_name() {
	return user_name;
}
 public void setUser_name(String user_name) {
	this.user_name = user_name;
}
 
 //**************************************************
 public String getUser_email() {
	return user_email;
}
 public void setUser_email(String user_email) {
	this.user_email = user_email;
}
 
//***************************************************
 public String getUser_state() {
	return user_state;
}
 public void setUser_state(String user_state) {
	this.user_state = user_state;
}
 
 //***************************************************
 public String getUser_city() {
	return user_city;
}
 public void setUser_city(String user_city) {
	this.user_city = user_city;
}

}
