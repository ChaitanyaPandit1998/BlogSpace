<%@page import="com.blogspace.model.Blog"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BlogSpace</title>
<link rel="stylesheet" href="Home.css">
</head>
<body>
	<div class="header">
			<nav>
        <ul>
         	<li>
		 		 <a href="home.jsp"> Welcome <%=(String)session.getAttribute("username")%> </a>
		 </li>
          <li>
		<a href="newBlog.jsp"> Add Blog</a>
		</li>
		<li>
		 <a href="logout"> Logout </a>
		 </li>
		
		 </ul>
		 </nav>
	</div>

	<div class="container">
		<div class="grid-container">
			<%ArrayList<Blog> std = (ArrayList<Blog>)session.getAttribute("data");
    for(Blog b:std){%>

			<div class="grid-item">
				<div class="title-content">
					<h4><%=b.getTitle()%></h4>
						<p>
					<%=b.getContent()%>
				</p>
				</div>
				<br/>
				<p class="intro">- <%=b.getUsername()%></p>
			</div>

			<%}%>
		</div>
	</div>
</body>
</html>