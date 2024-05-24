package com.actions.Model;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;



public class user {



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

	// creating logger object
	static Logger logger = LogManager.getLogger(user.class);

	// check user method with setting user object in session object

	public String validUser() {
    
		if ( username.equals("hasnain") && password == 1234) {

			// setting log message for if user loggedin successfully
			logger.info(this.username + " logged in successfully");

			// setting session
			session.setAttribute("loggedIn", username);
			return "success";
		}

		else {
			logger.error("incorrect username or password");
			return "error";
		}

	}

	// logout method with removing session object
	public String logout() {
		// setting logout log message 
		logger.info("user log Out successfully");
		// here removing session
		session.removeAttribute("loggedIn");
		return "loggedOut";
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", sessionMap= password=" + password + "]";
	}

}
