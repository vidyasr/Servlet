package com.project.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServitletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password"); 
        User user = UserDto.getUserById(name);
       if(user.getUserName().equals(""))
       {
    	   out.println("Sorry! UserName doesn't exist");
       }
       else if(user.getUserName().equals(name) && !user.getPassword().equals(password)){
    	   out.println("Password is incorrect");
       }
       else if(user.getUserName().equals(name) && user.getPassword().equals(password)){
    	 out.println("<a href=\"edit.html\">Edit</a>");
    	 out.println("<a href=\"delete.html\">Delete</a>");
    	 out.println("<a href=\'Logout'\" method=\"post\">Logout</a>");
       }
       
       
	}
}
