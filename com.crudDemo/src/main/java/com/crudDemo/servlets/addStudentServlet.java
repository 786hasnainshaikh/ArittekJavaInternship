package com.crudDemo.servlets;

import java.io.IOException;
import java.util.ServiceLoader;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crudDemo.DAO.Dao;
import com.crudDemo.entities.book;


@WebServlet("/addBook")
public class addStudentServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String author=req.getParameter("author");
		String location=req.getParameter("location");
		
		book obj=new book(name, author, location);
		
		if ( name.length() ==0  || author.length()==0|| location.length()==0 ){
			System.out.println("values cant be null");
			resp.sendRedirect("addBook.jsp");
		}
		else {
			boolean book = Dao.addBook(obj);
			
			if(book == true){
				resp.sendRedirect("home.jsp");
			}
			else {
				System.out.println("some thing error");
				resp.sendRedirect("addBook.jsp");
			}
		}
		
		
		
		
		
		
	}
	

}
