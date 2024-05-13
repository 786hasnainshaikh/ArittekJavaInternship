package com.actions.Model;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.actions.DAO.DAOoperations;
import com.actions.GemailSend.sendMail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class user  {

	;

	private int id;

	private String username;


	private int password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	
	// getting session object here
	
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	
	
    // check user method with setting user object in session object
	public String validUser() {
		// getting user from database
		user user2 = DAOoperations.getUser(getUsername(), getPassword());
	    
		// if user is valid setting user in session object
		if (user2 != null && (user2.getUsername().equals(this.getUsername()) && user2.getPassword() == this.getPassword())) {
			
			
			String to="mh2686139@gmail.com";
			String from="shaikhhussnain1122@gmail.com";
			String subject="sending mail to sir jetmal";
			String body="user logging successfully";
			
			// sending mail using sendMail class sendingMail method
			boolean mail = sendMail.sendingMail(to, from, subject, body);
			
			if(mail == true) {
				System.out.println("mail sent successfully");
			}else {
				System.out.println("mail sending failed");
			}
			
			// setting session
            session.setAttribute("loggedIn", user2);
			return "welcome";
		}
	

		else {
			return "error";
		}

	}

	
	
	
	// logout method with removing session object
	public String logout() {

		// here removing session
		session.removeAttribute("loggedIn");
		return "loggedOut";
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", sessionMap= password=" + password
				+ "]";
	}

}
