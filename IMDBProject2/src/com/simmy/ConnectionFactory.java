package com.simmy;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	  private static Connection conn;
		
		public static Connection getConnection() 
		{
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "orcl11g"
							+ "");
				} catch (Exception e) 
				{
				
					 e.printStackTrace();
				}
				
				return conn;
			}
	  public static void main(String[] args) {
		System.out.println(ConnectionFactory.getConnection());
		}
		
		}


