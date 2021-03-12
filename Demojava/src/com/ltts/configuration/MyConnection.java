package com.ltts.configuration;
import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	
	public static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","root");
		
		return con;
		
	}
	

}