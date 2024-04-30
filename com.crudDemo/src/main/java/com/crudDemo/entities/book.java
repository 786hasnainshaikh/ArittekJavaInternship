package com.crudDemo.entities;

public class book {
    private int bookId;
    private String BookName;
    private String author;
    private String location;
    
    
    
    
	public book(int id, String bookName, String author, String location) {
		super();
		this.bookId=id;
		BookName = bookName;
		this.author = author;
		this.location = location;
	}
	public book() {
		super();
	}
	public book(String bookName, String author, String location) {
		super();
		BookName = bookName;
		this.author = author;
		this.location = location;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "book [bookId=" + bookId + ", BookName=" + BookName + ", author=" + author + ", location=" + location
				+ "]";
	} 
}
