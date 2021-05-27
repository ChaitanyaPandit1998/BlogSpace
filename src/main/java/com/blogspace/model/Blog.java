package com.blogspace.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.blogspace.DatabaseConnection;
import java.sql.Connection;

public class Blog {
	
	private String title;
	private String content;
	private String username;
	private Date createdAt;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Blog() {
		
	}
	
	public Blog(String title, String content, String username, Date createdAt) {
		super();
		this.title = title;
		this.content = content;
		this.username = username;
		this.createdAt = createdAt;
	}
	
	public void saveBlog() {
		try {
			  
           Connection con = DatabaseConnection.initializeDatabase();
           PreparedStatement st = con
                   .prepareStatement("insert into blog(title,content,username,created_at) values(?,?,?,?)");
  
            
            st.setString(1, this.title);
            st.setString(2, this.content);
            st.setString(3, this.username);
            st.setDate(4, this.createdAt);
            
            st.executeUpdate();

            st.close();
            con.close();
  
 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public ArrayList<Blog> getAllPosts() {
		ArrayList<Blog> set = new ArrayList<>();
		try {
	           Connection con = DatabaseConnection.initializeDatabase();
	           PreparedStatement st = con
	                   .prepareStatement("select * from blog");
	  
	            ResultSet res = st.executeQuery();
	          while(res.next()) {
	       set.add(new Blog(res.getString(2),res.getString(3),res.getString(4),res.getDate(5)));
	          }
	          st.close();
	           con.close();
	            return set;
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
		return set;
	}
}
