package com.ltts.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ltts.Configuration.MyConnection;
import com.ltts.model.Team;

public class TeamDao {
	public List<Team> getAllTeams(){
		List<Team> li=new ArrayList<Team >();
		
		return li;
		}
	public Team getTeamById(int id) throws Exception {
		Team t=new Team();
		List<Team> li=getAllTeams();
		for(Team t1:li) {
			if(t1.getTeam_id() == id) {
				t.setTeam_id(t1.getTeam_id());
				t.setTeamname(t1.getTeamname());
				t.setOwnername(t1.getOwnername());
				t.setCoachname(t1.getCoachname());
		
			}
		}
		
		return t;
	}
	public boolean insertTeam(Team t) throws Exception
	{
		Connection c= MyConnection.getConnection();
		
		PreparedStatement ps= c.prepareStatement("insert into team values(?,?,?,?)");
		ps.setInt(1,t.getTeam_id());
		ps.setString(2, t.getTeamname());
		ps.setString(3, t.getOwnername());
		ps.setString(4, t.getCoachname());
		return ps.execute();
}
	
}