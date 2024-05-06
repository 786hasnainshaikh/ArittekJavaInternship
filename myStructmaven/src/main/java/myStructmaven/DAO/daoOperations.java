package myStructmaven.DAO;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import myStructmaven.RegisterBean.bean;
import myStructmaven.actions.updateAction;

import java.util.ArrayList;
import java.util.List;

public class daoOperations {

	// configuration of hibernate to get session object to perform operations
	public static Session session;
	public static Transaction tx;
	public static Configuration config = new Configuration().configure().addAnnotatedClass(bean.class);
	public static SessionFactory sessionFactory = config.buildSessionFactory();

	// add user
	@SuppressWarnings("deprecation")
	public static String addStudent(bean bean) {

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// method to add object
			session.saveOrUpdate(bean);
			tx.commit();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	// get all users
	@SuppressWarnings({})
	public static List<bean> listUser() {

		List<bean> userList = new ArrayList<bean>();

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// Create a native SQL query with specified return type
			NativeQuery<bean> query = session.createNativeQuery("SELECT * FROM struts_crud_hb", bean.class);

			// Execute the query and retrieve the result list
			userList = query.getResultList();
			tx.commit();
			// return that list
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	// get single student
	public static bean singleStudentById(int id) {

		bean user = new bean();
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// method for get single object
			user = (bean) session.get(bean.class, id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	// delete student
	@SuppressWarnings("deprecation")
	public static String deleteUser(int id) {

		bean user = new bean();
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// get particular object
			user = (bean) session.get(bean.class, id);
			// then delete that object

			session.delete(user);
			tx.commit();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	// update student
	@SuppressWarnings("deprecation")
	public static String update(updateAction bean) {

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
            
			// get particular object
			bean singleStudent = session.get(bean.class, bean.getId());
            
			// check if object is null or not
			if (singleStudent != null) {
				// Modify the object
				singleStudent.setName(bean.getName());
				singleStudent.setEmail(bean.getEmail());
				singleStudent.setPassword(bean.getPassword());
			}

			// Save the changes (optional, session may auto-detect changes)
			session.update(singleStudent);
			tx.commit();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

}