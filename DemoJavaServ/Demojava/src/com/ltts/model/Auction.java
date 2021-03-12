package com.ltts.model;

public class Auction {
	private int Auctionid;
	private int Playerid;
	private int Teamid;
	private int Year;
	public Auction() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Auction [Auction_id=" + Auctionid + ", Player_id=" + Playerid + ", Team_id=" + Teamid + ", Year="
				+ Year + ", Amount=" + Amount + "]";
	}
	public Auction(int auction_id, int player_id, int team_id, int year, int amount) {
		super();
		Auctionid = auction_id;
		Playerid = player_id;
		Teamid = team_id;
		Year = year;
		Amount = amount;
	}
	public int getAuction_id() {
		return Auctionid;
	}
	public void setAuction_id(int auction_id) {
		Auctionid = auction_id;
	}
	public int getPlayer_id() {
		return Playerid;
	}
	public void setPlayer_id(int player_id) {
		Playerid = player_id;
	}
	public int getTeam_id() {
		return Teamid;
	}
	public void setTeam_id(int team_id) {
		Teamid = team_id;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	private int Amount;

}