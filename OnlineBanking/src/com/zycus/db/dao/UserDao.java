package com.zycus.db.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.zycus.db.util.ConnectionUtil;
import com.zycus.exceptions.LoginException;

public class UserDao {
	private static final String SELECT_ALL = "select username, password from users";
	
	public static void verifyUser(String username, String password) throws LoginException {
		
		try(Connection con = ConnectionUtil.getConnection()) {
			boolean flag = false;
			PreparedStatement ps = con.prepareStatement(SELECT_ALL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				if(rs.getString("username").equals(username)) {
					
					if(rs.getString("password").equals(password)) {
						flag = true;
						break;
					}
					else {
						throw new LoginException("Password Invalid");
					}
				}
			}
			
			if(!flag) {
				throw new LoginException("Username Invalid");
			}
		} catch(SQLException ex) {
			throw new LoginException("Server Down");
		} catch(NullPointerException ne) {
			throw new LoginException("Server Down");
		}
	}
}
