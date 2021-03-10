package com.ltts.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.ltts.configuration.MyConnection;
import com.ltts.model.player;


public class PlayerDao {
	public List<player> getAllPlayers()
	{
		List<player> li= new ArrayList<player>();
		return li;
	}
	public player getPlayerById(int id)
	{
		player p=new player();
		return p;
	}
	
	public boolean insertPlayer(player p) throws Exception
	{
		Connection c= MyConnection.getConnection();
		PreparedStatement ps= c.prepareStatement("insert into player values(?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, p.getPlayer_id());
		ps.setString(2, p.getName());
		ps.setString(3, p.getDateOfBirth());
		ps.setString(4, p.getNationality());
		ps.setString(5, p.getSkills());
		ps.setInt(6, p.getRuns());
		ps.setInt(7, p.getWickets());
		ps.setInt(8, p.getNumber_of_matches());
		ps.setInt(9, p.getTeam_id());
		System.out.println("Data Inserted Succesfully");
		return ps.execute();
		
	}


}