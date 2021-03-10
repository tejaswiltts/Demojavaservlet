package com.ltts.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ltts.configuration.MyConnection;
import com.ltts.model.team;

public class TeamDao {
	public List<team> getAllTeams(){
		List<team> li=new ArrayList<team >();
		
		return li;
		}
	public team getTeamById(int id) {
		team t = new team();
			
		return t;
	}
	public boolean insertTeam(team t) throws Exception
	{
		Connection c= MyConnection.getConnection();
		
		PreparedStatement ps= c.prepareStatement("insert into team values(?,?,?,?)");
		ps.setInt(1,t.getTeam_id());
		ps.setString(2, t.getTeamname());
		ps.setString(3, t.getOwnername());
		ps.setString(4, t.getCoachname());
		return ps.execute();
}
	
	public boolean updateTeam(int id,String name) throws Exception
	{
		Connection c= MyConnection.getConnection();
		PreparedStatement ps= c.prepareStatement("UPDATE team SET teamname=? WHERE teamid=?");
		ps.setString(1, name);
		ps.setInt(2, id);
		System.out.println("Data Updated Succesfully");
		return ps.execute();
	}
	
	public void teamPlayer(String tname) throws Exception
	{
		Connection c= MyConnection.getConnection();
		PreparedStatement ps=c.prepareStatement("Select * from player as p, team as t where p.teamid=t.teamid AND t.teamname=? ;");
		ps.setString(1, tname);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(7)+" "+rs.getInt(8)+" "+rs.getInt(9));
			
		}
	}
	
	public void skillPlayer(String tname, String tskill) throws Exception
	{
		Connection c= MyConnection.getConnection();
		PreparedStatement ps=c.prepareStatement("Select * from player as p, team as t where p.teamid=t.teamid AND t.teamname=? AND p.skills=? ;");
		ps.setString(1, tname);
		ps.setString(2, tskill);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(7)+" "+rs.getInt(8)+" "+rs.getInt(9));
			
		}
	}

}