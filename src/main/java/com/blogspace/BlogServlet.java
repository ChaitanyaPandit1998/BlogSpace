package com.blogspace;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.blogspace.model.Blog;
import java.sql.Date;
import java.util.ArrayList;

public class BlogServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Blog blog = new Blog();
		ArrayList<Blog> set = blog.getAllPosts();
		HttpSession session = req.getSession();
		session.setAttribute("data", set);
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		  rd.forward(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean flag = (Boolean) session.getAttribute("fromLoginServlet");
		if(flag) {
			session.setAttribute("fromLoginServlet", false);
			doGet(req,res);
			return;
		}
		res.setContentType("text/html");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String username = (String) session.getAttribute("username");
		Blog blog = new Blog(title,content,username,new Date(System.currentTimeMillis()));
		blog.saveBlog();
		doGet(req,res);
		
	}

}
