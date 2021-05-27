package com.blogspace;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import com.blogspace.model.User;

public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirm_password = req.getParameter("confirm_password");
		String email = req.getParameter("email");
		res.setContentType("text/html");
		
		if(password.equals(confirm_password)) {
			
			User user = new User(username,password,email,new Date(System.currentTimeMillis()));
			user.registerUser();
			res.sendRedirect("login.html");			
		}else {
			res.sendRedirect("register.html");
		}

		
	}
}
