package myStructmaven.RegisterBean;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import myStructmaven.DAO.daoOperations;


@Entity
@Table(name = "Struts_Crud_HB")
public class bean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    int id;
	@Column(name="student_name")
	String name;
	@Column(name = "student_email")
    String email;
	@Column(name = "stu_password")
    String password;
	
	
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
		String addStudent = daoOperations.addStudent(this);
    	return addStudent ;
    }
	}


