package com.blogspace.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.blogspace.DatabaseConnection;

public class User {
	
		private String username;
		private String password;
		private String email;
		private Date createdAt;
		
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		
		public User() {
			
		}
		
		public User(String username, String password, String email, Date createdAt) {
			super();
			this.username = username;
			this.password = password;
			this.email = email;
			this.createdAt = createdAt;
		}
		
		public void registerUser() {
			try {
				  
	            Connection con = DatabaseConnection.initializeDatabase();
	  
	            PreparedStatement st = con
	                   .prepareStatement("insert into user(username,password,email,created_at) values(?,?,?,?)");
	  
	            
	            st.setString(1, this.username);
	            st.setString(2, this.password);
	            st.setString(3, this.email);
	            st.setDate(4, this.createdAt);
	            
	            st.executeUpdate();
	
	            st.close();
	            con.close();
	  
	 
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		
	public boolean userLogin(String username,String password) {
			try {
	Connection con = DatabaseConnection.initializeDatabase();
    PreparedStatement st = con.prepareStatement("select username,password from user where username = ?");
    st.setString(1, username);
    ResultSet res = st.executeQuery();
     while(res.next()) {
    	 	String getPassword = res.getString(2);
    	 	if(password.equals(getPassword))
    	 		return true;
    }
		      return false;
			}catch(Exception e){
				e.printStackTrace();
			}
		return false;
		}

		
}
