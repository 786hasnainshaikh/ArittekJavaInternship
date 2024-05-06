package myStructmaven.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import myStructmaven.DAO.daoOperations;

public class deleteAction {

	
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
	
   public String deleteStudent() {
	  int id=  Integer.parseInt(request.getParameter("id")); 
	  String deleteStudent = daoOperations.deleteUser(id);

      return deleteStudent;
   }
}
