package com.simmy1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.simmy.ConnectionFactory;
import com.simmy2.User;

public class RegisterDao {

	 public String registerUser(User user)
	 {
	 int userid = user.getUserid();
	 String email = user.getEmail();
	 String userName = user.getUsername();
	 String password = user.getPassword();
	 
	 Connection conn = null;
	 PreparedStatement PrepStatement = null;
	 
	 try
	 {
	 conn = ConnectionFactory.getConnection() ;
	 String query = "insert into useracconut(userid,username,password,email) values (NULL,?,?,?,?)"; //Insert user details into the table 'USERS'
	 PrepStatement = conn.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
	 PrepStatement.setInt(1, userid);
	 PrepStatement.setString(2, email);
	 PrepStatement.setString(3, userName);
	 PrepStatement.setString(4, password);
	 
	 int i= PrepStatement.executeUpdate();
	 
	 if (i!=0)  //Just to ensure data has been inserted into the database
	 return "SUCCESS"; 
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 
	 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	 }
	

}


