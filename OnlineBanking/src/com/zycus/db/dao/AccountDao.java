package com.zycus.db.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.zycus.pojo.accounts.Account;
import com.zycus.db.util.ConnectionUtil;


public class AccountDao {
	private static final String INSERT = "insert into account values(?,?,?,?,?,?)";
	private static final String SELECT_ALL = "select account_pk, account_number, account_holder, account_type, amount, opening_date"
											+ " from account";
	
	public static void insert(Account account) {
		
		try(Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(INSERT);
			
			ps.setString(1, account.getPrimaryKey().toString());
			ps.setString(2, account.getAccountNumber().toString());
			ps.setString(3, account.getHolderName());
			ps.setString(4, account.getAccountType());
			ps.setDouble(5, account.getAmount());
			ps.setString(6, account.getOpeningDate().toString());
			
			int rows = ps.executeUpdate();
			System.out.println("Account : Record added : " + rows);
			
			ps.close();
		} catch(SQLException ex) {
			System.out.println("Account :This id already exist");
		} catch(NullPointerException ex) {
			System.out.println("Database connection error");
		}
	}
	
	public static List <Account> getAllAccount() {
		
		try(Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SELECT_ALL);
			ResultSet rs = ps.executeQuery();
			List <Account> allAccounts = new ArrayList<>();
			
			while(rs.next()) {
				Account account = new Account();
				account.setPrimaryKey(Long.parseLong(rs.getString("account_pk")));
				account.setAccountNumber(Long.parseLong(rs.getString("account_number")));
				account.setHolderName(rs.getString("account_holder"));
				account.setAccountType(rs.getString("account_type"));
				account.setAmount(rs.getDouble("amount"));
				account.setOpeningDate(Long.parseLong(rs.getString("opening_date")));
				account.setConnectedCards(CardDao.findByAccountPK(account.getPrimaryKey()));
				allAccounts.add(account);
			}
			
			return allAccounts;
		} catch(SQLException ex) {
			ex.printStackTrace();
			
			return null;
		} catch(NullPointerException ex) {
			ex.printStackTrace();
			
			return null;
		}
	}
}
