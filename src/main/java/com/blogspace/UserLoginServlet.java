package com.blogspace;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blogspace.model.User;

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		res.setContentType("text/html");
		User user = new User();
		boolean flag = user.userLogin(username, password);
		if(!flag) {
		res.sendRedirect("login.html");
		return;
		}
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		session.setAttribute("fromLoginServlet", true);
		RequestDispatcher rd = req.getRequestDispatcher("home");
		rd.forward(req, res);
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.sendRedirect("login.html"); 
	}
}
