package com.simmy3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.simmy.ConnectionFactory;
import com.simmy2.User;

public class UserDao {
	public int insert(User user) throws SQLException
	{
		String query="insert into useracconut values(?,?,?,?)";
		Connection conn =ConnectionFactory.getConnection();
		

		PreparedStatement pStatement= conn.prepareStatement(query);
		pStatement.setInt(1, user.getUserid());
		pStatement.setString(2, user.getUsername());
		pStatement.setString(3, user.getPassword());
		pStatement.setString(4, user.getEmail());
		int  output=pStatement.executeUpdate();
		return output;
		
	}
	

	public static void main(String[] args) throws SQLException {
	new UserDao().insert(new User(3,"simmy"," simmy@12","simmy@gmail.com"));
		System.out.println("sucessfully added");
		
	}


}


