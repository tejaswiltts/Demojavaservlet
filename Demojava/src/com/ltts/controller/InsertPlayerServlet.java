package com.ltts.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.DAO.PlayerDao;
import com.ltts.model.player;

/**
 * Servlet implementation class InsertPlayerServlet
 */
@WebServlet("/InsertPlayerServlet")
public class InsertPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertPlayerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int PlayerId=Integer.parseInt(request.getParameter("PlayerId"));
		String name=request.getParameter("name");
		String dateOfBirth=request.getParameter("dateOfBirth");
		String nationality=request.getParameter("nationality");
		String skills=request.getParameter("skills");
		int runs=Integer.parseInt(request.getParameter("runs"));
		int wickets=Integer.parseInt(request.getParameter("wickets"));
		int number_of_matches=Integer.parseInt(request.getParameter(" number_of_matches"));
		int teamid=Integer.parseInt(request.getParameter("teamid"));
		
		player p=new player(PlayerId,name,dateOfBirth,nationality,skills,runs,wickets,number_of_matches,teamid);
		System.out.println("Inside Servlet: "+p);
		PlayerDao pd=new PlayerDao();
		boolean b=false;
		try {
			b=pd.insertPlayer(p); // Control TRanfers to Dao file
			System.out.println("Successfully Inserted...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
