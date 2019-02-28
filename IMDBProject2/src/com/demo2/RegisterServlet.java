package com.demo2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simmy1.RegisterDao;
import com.simmy2.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 //Copying all the input parameters in to local variables
		 int userid =Integer.parseInt( request.getParameter("userid"));
		 String username = request.getParameter("username");
		 String password = request.getParameter("password"); 
		 String email = request.getParameter("email");
		 
		User user=new User();
		
		 user.setUserid(userid);
	     user.setUsername(username);
         user.setPassword(password); 
         user.setEmail(email);
         
         RegisterDao registerDao = new RegisterDao();
         
         //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
         String userRegistered = registerDao.registerUser(user);
         
         if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
         {
         request.getRequestDispatcher("home3.jsp").forward(request, response);
         }
         else   //On Failure, display a meaningful message to the User.
         {
         request.setAttribute("errMessage", userRegistered);
         request.getRequestDispatcher("../Register.jsp").forward(request, response);
         }
         }
		 
		//doGet(request, response);
	}

