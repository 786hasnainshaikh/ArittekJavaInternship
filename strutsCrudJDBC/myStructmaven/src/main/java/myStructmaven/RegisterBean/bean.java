package myStructmaven.RegisterBean;

import myStructmaven.DAO.daoOperations;

public class bean {
    private int id;
	private String name;
	private String email;
	private String password;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	  
	
	

    // add student into database
	public String addStudent() {
		String addStudent = daoOperations.addStudent(getName(), getEmail(), getPassword());
    	return addStudent ;
    }
	}


