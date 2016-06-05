package com.project.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  


		String oldUsername=request.getParameter("userName");  
		User user = UserDto.getUserById(oldUsername);
		String newUserName = request.getParameter("newuserName");
		String newPassword = request.getParameter("newpassword");
		String newEmail = request.getParameter("newemail");
		String newgirlfriendname = request.getParameter("newgirlfriendname");
		if(user.getUserName().equals(""))
			out.println("Invalid username");
		if(!newPassword.equals(""))
		{
			user.setPassword(newPassword);
		}
		if(!newUserName.equals(""))
			user.setUserName(newUserName);
		if(!newEmail.equals(""))
			user.setEmail(newEmail);
		if(!newgirlfriendname.equals(""))
			user.setGirlFriendName(newgirlfriendname);
		int status = UserDto.update(user, oldUsername);
		if(status > 0){
			out.println("Record updated successfully");
			out.println("<a href=\"home.html\"> Home </a>");
		}	
		
	}
}


