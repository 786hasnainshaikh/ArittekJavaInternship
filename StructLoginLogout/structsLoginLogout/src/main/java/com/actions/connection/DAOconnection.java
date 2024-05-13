package com.actions.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOconnection {
	
	
	private static final String URL = "jdbc:mysql://localhost:3307/registerdetails";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static Connection con = null;
	
	public static Connection getConnection() {
		
		if (con != null)
            return con;
		else {
		try {
			Class.forName(DRIVER);
		      con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		    } 
		 catch (ClassNotFoundException e) {
		      e.printStackTrace();
		    }
		 catch (SQLException e) {
		      e.printStackTrace();
		    }
		return con;
		}
	}

}
