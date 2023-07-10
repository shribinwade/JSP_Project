package com.form.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.form.dto.formDTO;
import com.form.util.ConnectionFactory;

public class formDAO  {
    
private static String SQL_Insert="insert into user_dtls(user_name,user_email,user_phno,user_state,user_city) values (?,?,?,?,?);";
private static String SQL_Select="Select * from user_dtls;";
private static String SQL_Delete=" delete from user_dtls where user_id=?";
private static String SQL_Edit="update user_dtls set user_name=?,user_email=?,user_phno=?,user_state=?,user_city=? where user_id=?;";

 
public boolean formInsert(formDTO userDTO ) throws Exception {
	 System.out.println("hello");
	 Connection con = ConnectionFactory.getConnetion();
	 boolean isSaved=false;
	 try {
		 PreparedStatement pstmt = con.prepareStatement(SQL_Insert);
		 
		 
		 pstmt.setString(1, userDTO.getUser_name() );
		 pstmt.setString(2, userDTO.getUser_email() );
		 pstmt.setLong(3, userDTO.getUser_phone());
		 pstmt.setString(4, userDTO.getUser_state());
		 pstmt.setString(5, userDTO.getUser_city() );

		 int count = pstmt.executeUpdate();
		 
		 if(count > 0) {
			 isSaved=true;
		 }
	 }
	 catch(Exception e) {
		 e.printStackTrace();
		 }
	return isSaved;
	
	 
   }
	


public List<formDTO> getUsers(){
	
	List<formDTO> users =new ArrayList<>();
	
	try {
	     Connection con = ConnectionFactory.getConnetion();
	     
	     Statement stmt = con.createStatement();
	     ResultSet rs = stmt.executeQuery(SQL_Select);
	     
	     while(rs.next()) {
	    	 
	    	 formDTO user=new formDTO();
	    	 
	    	 user.setUser_id(rs.getInt("user_id"));
	    	 user.setUser_name(rs.getString("user_name"));
	    	 user.setUser_phone(rs.getInt("user_phno"));
	    	 user.setUser_email(rs.getString("user_email"));
	    	 user.setUser_state(rs.getString("user_state"));
	    	 user.setUser_city(rs.getString("user_city"));

	    	 //adding each user to collection
	    	 users.add(user);
	     }
	     
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	return users;
	
}

public boolean rowDelete(int userID ) throws Exception {
	 
	 Connection con = ConnectionFactory.getConnetion();
	 boolean isSaved=false;
	 try {
		 PreparedStatement pstmt = con.prepareStatement(SQL_Delete);
		 
		 
		 pstmt.setInt(1, userID);
		

		 int count = pstmt.executeUpdate();
		 
		 if(count > 0) {
			 isSaved=true;
		 }
	 }
	 catch(Exception e) {
		 e.printStackTrace();
		 }
	return isSaved;
	
	 
  }

public boolean rowEdit(formDTO rowUsers ) throws Exception {
	 
	 Connection con = ConnectionFactory.getConnetion();
	 boolean isSaved=false;
	 try {
		 PreparedStatement pstmt = con.prepareStatement(SQL_Edit);
		 
		 
		 pstmt.setString(1, rowUsers.getUser_name());
		 pstmt.setString(2, rowUsers.getUser_email());
		 pstmt.setInt(3, rowUsers.getUser_phone());
		 pstmt.setString(4, rowUsers.getUser_state());
		 pstmt.setString(5, rowUsers.getUser_city());
		 pstmt.setInt(6, rowUsers.getUser_id());

		

		 int count = pstmt.executeUpdate();
		 
		 if(count > 0) {
			 isSaved=true;
		 }
	 }
	 catch(Exception e) {
		 e.printStackTrace();
		 }
	return isSaved;
	
	 
 }
  
}
