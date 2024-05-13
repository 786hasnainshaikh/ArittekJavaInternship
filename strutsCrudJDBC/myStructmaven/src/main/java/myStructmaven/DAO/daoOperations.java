package myStructmaven.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import myStructmaven.DaoConnection.connection;
import myStructmaven.model.user;

public class daoOperations {
	// getting connection
    static Connection con=	connection.getConnection();
   
    
    // add student method
    public static String addStudent(String name, String email, String password) {
    	try {
			String querry="insert into studetails (name , email , password) values(?, ? ,?)";
			PreparedStatement pstm=con.prepareStatement(querry);
			pstm.setString(1, name);
			pstm.setString(2, email);
			pstm.setString(3, password);
			
			int i = pstm.executeUpdate();
			if (i>0) {
				return "success";
			}
			else {
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "fail";
    	
    
    }
    
    // get all students method
    public static List<user> getAllStudentst() {
    	user user;
    	ArrayList<user> userList=new ArrayList<>();
    	
    	 try {
			String queery="SELECT * FROM studetails";
			PreparedStatement pstm=con.prepareStatement(queery);
			ResultSet set = pstm.executeQuery();
			
			
			while(set.next()) {
				user=new user();
				user.setId(set.getInt(1));
				user.setName(set.getString(2));
				user.setEmail(set.getString(3));
				user.setPassword(set.getString(4));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	return userList;
}
  
    
    // delete Student method
 
   public static String deleteStudent(int id) {
    	try {
			String queery="delete  from studetails where id=?";
			PreparedStatement pstm=con.prepareStatement(queery);
			// pass parameters
			pstm.setInt(1, id);
			
			int i = pstm.executeUpdate();
			if (i==1) {
				return "success";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "fail";
    } 
   
   
   // get single student method
   public static user getSingleStudent(int id) {
	   user user=null;
	  try {
		String query="select * from studetails where id =?";
		PreparedStatement pstm=con.prepareStatement(query);
		pstm.setInt(1, id);
		
		ResultSet resultSet = pstm.executeQuery();
		while(resultSet.next()) {
		    user = new user();
			user.setId(resultSet.getInt(1));
			user.setName(resultSet.getString(2));
			user.setEmail(resultSet.getString(3));
			user.setPassword(resultSet.getString(4));
		}
	} catch (Exception e) {
		e.printStackTrace();
	} 
	   
	  return user; 
   }

   
   // update student method
   public static String updateStudent(String name, String email, String password, int id) {
	   try {
		String queery="UPDATE studetails SET name = ?, email = ?, password =? WHERE id =?";
		PreparedStatement pstm=con.prepareStatement(queery);
		
		pstm.setString(1, name);
		pstm.setString(2, email);
		pstm.setString(3,password);
		
		pstm.setInt(4, id);
		
		int i = pstm.executeUpdate();
		
		if(i== 1) {
			return "success";
		}else {
			return "fail";
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	   
	   return "fail";
   }

}