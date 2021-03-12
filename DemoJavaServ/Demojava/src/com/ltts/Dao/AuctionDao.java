package com.ltts.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ltts.Configuration.MyConnection;
import com.ltts.model.Auction;
import com.ltts.model.Player;



public class AuctionDao {
	public List<Auction> getAllAuction() throws Exception{
		List<Auction> li=new ArrayList<Auction>();
		Connection mc=MyConnection.getConnection(); // TRanfers control to another 
		Statement ps=mc.createStatement();
		ResultSet rs=ps.executeQuery("select * from Auction");
		//Player p=new Player();
		while(rs.next()) {
			li.add(new Auction(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)));
			
		}
		return li;
		
	}
	public Auction getAuctionById(int id) throws Exception {
		Auction a=new Auction();
		List<Auction> li=getAllAuction();
		for(Auction a1:li) {
			if(a1.getAuction_id() == id) {
				a.setAuction_id(id);
				a.setPlayer_id(a1.getPlayer_id());
				a.setTeam_id(a1.getTeam_id());
				a.setYear(a1.getYear());
				a.setAmount(a1.getAmount());
				
			}
		}
		
		return a;
	}

	
	public boolean insertAuction(Auction a) throws Exception {
		//fill your code
		Connection mc=MyConnection.getConnection(); // TRanfers control to another 
		PreparedStatement ps=mc.prepareStatement("insert into auction values(?,?,?,?,?)");
		ps.setInt(1, a.getAuction_id());
		ps.setInt(2, a.getPlayer_id());
		ps.setInt(3, a.getTeam_id());
		ps.setInt(4,a.getYear());
		ps.setInt(5, a.getAmount());

		return ps.execute();
		//return false;

		
	}

}