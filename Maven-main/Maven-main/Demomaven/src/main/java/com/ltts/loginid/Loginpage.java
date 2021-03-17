package com.ltts.loginid;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Loginpage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Loginpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project", "root","root");
			String user= request.getParameter("uname");
			String password= request.getParameter("pass");
			 PreparedStatement ps =con.prepareStatement("select * from data where username=? and password=?");
			 ps.setString(1, user);
			 ps.setString(2, password);
			 
		    ResultSet rs=ps.executeQuery();
		   
		    PrintWriter out= response.getWriter();
			 if(rs.next())
			 {
				 out.print("LOGIN SUCCESSFUL");
			 }
			 else
			 {
				 out.print("LOGIN FAILED");
			 }
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
