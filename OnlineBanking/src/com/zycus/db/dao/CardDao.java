package com.zycus.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.zycus.db.util.ConnectionUtil;
import com.zycus.pojo.cards.Card;

public class CardDao {
	private static final String INSERT = "insert into card values(?,?,?,?,?)";
	private static final String SELECT_WHERE = "select card_pk, card_number, maximum_limit, expiry_date from card"
												+ " where account_fk = ?";
	public static final Long CARD_NUMBER_GENERATOR = 1003344000000000l;
	public static final Double MAXIMUM_LIMIT = 400000d;
	
	public static void insert(Card card) {
		
		try(Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(INSERT);
			
			ps.setString(1, card.getPrimaryKey().toString());
			ps.setString(2, card.getCardNumber().toString());
			ps.setDouble(3, card.getMaximumLimit());
			ps.setString(4, card.getExpiryDate().toString());
			ps.setString(5, card.getforeignKey().toString());
			
			int rows = ps.executeUpdate();
			System.out.println("Card : Record added : " + rows);
			
			ps.close();
		} catch(SQLException ex) {
			System.out.println("Card :This id already exist");
		} catch(NullPointerException ex) {
			System.out.println("Database connection error");
		}
	}
	
	public static List <Card> findByAccountPK(Long accountPK) {
		
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SELECT_WHERE);
			ps.setString(1, accountPK.toString());
			ResultSet rs = ps.executeQuery();
			List <Card> allCards = new ArrayList<>();
			
			while(rs.next()) {
				Card retrievedCard = new Card();
				retrievedCard.setforeignKey(accountPK);
				retrievedCard.setPrimaryKey(Long.parseLong(rs.getString("card_pk")));
				retrievedCard.setCardNumber(Long.parseLong(rs.getString("card_number")));
				retrievedCard.setMaximumLimit(rs.getDouble("maximum_limit"));
				retrievedCard.setExpiryDate(Long.parseLong(rs.getString("expiry_date")));
				
				allCards.add(retrievedCard);
			}
			
			return allCards;
		} catch(SQLException ex) {
			ex.printStackTrace();
			
			return null;
		} catch(NullPointerException ex) {
			ex.printStackTrace();
			
			return null;
		}
	}
}
