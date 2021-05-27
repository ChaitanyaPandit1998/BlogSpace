<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post</title>
<link rel="stylesheet" href="newBlog.css">
</head>
<body>
	<div class="header">
			<nav>
        <ul>
          	<li>
		 		 <a href="home.jsp"> Welcome <%=(String)session.getAttribute("username")%> </a>
		 </li>
          <li>
		<a href="newBlog.jsp"> Post</a>
		</li>
		<li>
		 <a href="logout"> Logout </a>
		 </li>
		
		 </ul>
		 </nav>
	</div>
<h1>Post Your Blog</h1>
<div>
    <form name = "blog" method = "post" action = "addblog">
        <p>
           <span>
             <input type="text" name="title" size="40" class="titleinput" placeholder="Title">
          </span>
          <span>
            <textarea name="content" cols="40" rows="10" placeholder="Description"></textarea>
          </span>
          <input type="submit" class="btn">
      </p>
  </form>
</div>
		
</body>
</html>
