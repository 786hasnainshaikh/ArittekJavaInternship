package myStructmaven.DaoConnection;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;

// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.hibernate.cfg.Configuration;



  

 public class connection {
	
	 
// this is to get session object to perform crud operation 	 

	 
	 /*
	  * 
	  static Configuration cfg=new Configuration();
	
	static SessionFactory factory;
	public static Session session1;
	
	public static Session getSession() {
		cfg.configure("hibernate.cfg.xml");
		factory =cfg.buildSessionFactory();
		session1= factory.openSession();
		
		return session1;
	}
	   
	  * */
	
	
	
	
	
	
	private static final String URL = "jdbc:mysql://localhost:3307/studentdeatils";
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
