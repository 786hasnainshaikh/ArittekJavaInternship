package com.crudDemo.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudDemo.connections.connection;
import com.crudDemo.entities.book;



public class Dao {
    
	 private static Connection c= connection.getConnection();
	
	public static boolean addBook(book book) {
		
		boolean flage=false;
		try {
			String queery="insert into booktable (bookName , bookAuthor , location) values (?,?,?)";
			PreparedStatement pstm = c.prepareStatement(queery);
			// setting values into database
			pstm.setString(1, book.getBookName());
			pstm.setString(2, book.getAuthor());
			pstm.setString(3, book.getLocation());
			
			int i = pstm.executeUpdate();
			if (i == 1){
			    flage=true;
			    return flage;
			}
			else{
				return flage;
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flage;
	}
 
	
	public static List<book> showAllBooks(){
		ArrayList<book> BooksList = new ArrayList<book>();
		book book=null;
		
		try {
			String queery="select * from booktable";
			PreparedStatement pstm= c.prepareStatement(queery);
			ResultSet resultSet = pstm.executeQuery();
			
			while(resultSet.next()){
				
			book=new book();
				book.setBookId(resultSet.getInt(1));
				book.setBookName(resultSet.getString(2));
				book.setAuthor(resultSet.getString(3));
				book.setLocation(resultSet.getString(4));
				BooksList.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return BooksList;
	}

    public static void deleteBook(int id){
    	try {
			String queery="delete from booktable where id=?";
			PreparedStatement pstm=c.prepareStatement(queery);
			pstm.setInt(1, id);
			
			int i = pstm.executeUpdate();
			
			if(i== 1){
				System.out.println("book deleted");
			}
			else {
				System.out.println("someThing error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
   
    public static book getBookById(int id){
    	book b=null;
    	try {
			String queery="select * from booktable where id=?";
			PreparedStatement pstm=c.prepareStatement(queery);
			pstm.setInt(1, id);
			
			ResultSet resultSet = pstm.executeQuery();
			
			while(resultSet.next()){
				b=new book();
				b.setBookId(resultSet.getInt(1));
				b.setBookName(resultSet.getString(2));
				b.setAuthor(resultSet.getString(3));
				b.setLocation(resultSet.getString(4));
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return b;
    		
    }
    
    
    public static void updateBook(book book){
    	try {
			String querry="update booktable set bookName=?, bookAuthor=? , location =? where id=?";
		
			PreparedStatement pstm=c.prepareStatement(querry);
			
			pstm.setString(1, book.getBookName());
			pstm.setString(2, book.getAuthor());
			pstm.setString(3, book.getLocation());
			pstm.setInt(4, book.getBookId());
			
			int update = pstm.executeUpdate();
			
			if(update == 1){
				System.out.println("book updated");

			}
			else{
				System.out.println("someThing error");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    }

}
