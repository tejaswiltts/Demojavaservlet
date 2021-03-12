package com.ltts.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.ltts.Configuration.MyConnection;
import com.ltts.model.Player;


public class PlayerDao {
	public List<Player> getAllPlayers()
	{
		List<Player> li= new ArrayList<Player>();
		return li;
	}
	public Player getPlayerById(int id) throws Exception {
		Player p=new Player();
		List<Player> li=getAllPlayers();
		for(Player p1:li) {
			if(p1.getPlayer_id() == id) {
				p.setPlayer_id(id);
				p.setName(p1.getName());
				p.setDateOfBirth(p1.getDateOfBirth());
				p.setNationality(p1.getNationality());
				p.setSkills(p1.getSkills());
				p.setRuns(p1.getRuns());
				p.setWickets(p1.getWickets());
				p.setNumber_of_matches(p1.getNumber_of_matches());
				p.setTeam_id(p1.getTeam_id());
				
			}
		}
		
		return p;
	}

	
	public boolean insertPlayer(Player p) throws Exception
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