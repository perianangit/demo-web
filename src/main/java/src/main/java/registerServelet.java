package src.main.java.src.main.java;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegisterDAO;
import model.Assign;


@WebServlet("/registerServelet")
public class registerServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String userAdmin=request.getParameter("role");
		String userMobileNumber=request.getParameter("mobilenumber");
		int userAge=Integer.parseInt(request.getParameter("age"));
		int userYearOfStudy=Integer.parseInt(request.getParameter("yearofstudy"));
		float userMark=Float.parseFloat(request.getParameter("mark"));
		String userEmail=request.getParameter("email");
		String userPassword=request.getParameter("password");
		String userAdmissionStatus="pending";
		String userBranch="not selected";
		String message=null;
		Assign register= new Assign(name,userAdmin,userMobileNumber,userAge,userYearOfStudy,userMark,userEmail,userPassword, userAdmissionStatus,userBranch);
		System.out.println(name);
		RegisterDAO dao= new RegisterDAO();
		try {
			RegisterDAO.insertUser(register);
			message="registered successfully";
		}
		catch(Exception e)
		{
			message=e.getMessage();
		}
		PrintWriter out =response.getWriter();
		out.println(message);
	}

	

}
