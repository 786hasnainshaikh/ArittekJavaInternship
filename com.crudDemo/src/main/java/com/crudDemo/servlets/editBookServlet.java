package com.crudDemo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crudDemo.DAO.Dao;
import com.crudDemo.entities.book;

@WebServlet("/editBook")
public class editBookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String author=req.getParameter("author");
		String location=req.getParameter("location");
		
		book book=new book(id , name, author, location);
		
		Dao.updateBook(book);
		
		resp.sendRedirect("home.jsp");
	}
     
}
