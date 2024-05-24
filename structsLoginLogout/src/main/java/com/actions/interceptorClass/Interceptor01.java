package com.actions.interceptorClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.actions.Model.user;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class Interceptor01 implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

	// creating logger object
	static Logger logger = LogManager.getLogger(user.class);

	public String intercept(ActionInvocation invocation) throws Exception {
		// Create and configure the HttpServletRequest object
		HttpServletRequest request = ServletActionContext.getRequest();
		

		// Get the URL requested by the client
		String requestUrl = request.getRequestURL().toString();
		String requestMethod = request.getMethod();

		// Get the action method name
	     String methodName = invocation.getProxy().getMethod();
		

		// Get the username and password from the request parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		

		

		// Log before action execution
		logger.info("============================================================================================");
		logger.info("Before action: " + ", Method: " + methodName + ", Request URL: " + requestUrl + ", HTTP Method: "
				+ requestMethod + ", Username: " + username + ", Password: " + password);

		// Proceed to the next interceptor or action
		String result = invocation.invoke();
        
		System.out.println(result);
		// Log before action execution
		logger.info("After action: " + ", Method: " + methodName + ", Request URL: " + requestUrl + ", HTTP Method: "
				+ requestMethod + ", Username: " + username + ", Password: " + password);
		logger.info("============================================================================================");

		return result;

	}

}
