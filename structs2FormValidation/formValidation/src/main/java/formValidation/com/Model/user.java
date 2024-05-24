package formValidation.com.Model;

import com.opensymphony.xwork2.ActionSupport;



public class user extends ActionSupport{
	private int id;
	private String userName;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

//	public String execute() {
//		if (userName == null || userName.isEmpty() ){
//			return "fail";
//		}
//		else {
//			return "success";
//		}  
//	}
	

	@Override
	public void validate() {
		if (userName == null || userName.isEmpty()){
			addFieldError("userName", "username is required!!");
			
		}
		if (password == null || password.isEmpty()){
			addFieldError("password", "passowrd cant be blank");
		}
		
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}

}
