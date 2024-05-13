package com.actions.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.actions.Model.user;
import com.actions.connection.DAOconnection;

public class DAOoperations {
	
	static Connection con= DAOconnection.getConnection();
		
	
	
	// returning user
		public static user getUser(String username, int password) {
			user user=null;;
			try {
				String queString="SELECT * FROM logindetails where  userName=? and password=?";
				PreparedStatement pstm=con.prepareStatement(queString);
				
				pstm.setString(1, username);
				pstm.setInt(2, password);
				
				ResultSet resultSet = pstm.executeQuery();
				
				if (resultSet.next()) {
					// created user object
					user =new user();
					user.setId(resultSet.getInt(1));
					user.setUsername(resultSet.getString(2));
					user.setPassword(resultSet.getInt(3));
					return user;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			return null;
		}
			return user;

}
}
