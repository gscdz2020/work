<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
   if((session.getAttribute("isright")!=null)&&session.getAttribute("isright")=="wrong"){
	     response.getWriter().println("<html><body><p>please check your username or password</p></body></html>");
   }
   else if((session.getAttribute("isnull")!=null)&&session.getAttribute("isnull")=="yes"){
	   response.getWriter().println("<html><body><p>password or username null</p></body></html>");
   }
%>

	<h1>Login Page</h1>
	<form action="login" method="post">
		occupation: <select name="occupation">
			<option value="Admin">管理员</option>
			<option value="User">用户</option>
		</select> <br> <label for="username">username:</label><input id="username"
			name="username" type="text"><br /> <br> <label
			for="password">password:</label><input id="password" name="password"
			type="password"><br/>
		<button type="submit">登录</button>
	</form>
</body>
</html>