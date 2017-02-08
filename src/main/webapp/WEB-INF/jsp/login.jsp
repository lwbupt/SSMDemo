<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录页面</title>
</head>
<body>
	<form name="user" method="post" action="/SSMDemo/login">
		<label>姓名：</label>
		<input type="text" name="username">
		<br>
		<label>密码：</label>
		<input type="text" name="password">
		<input type="submit">
	</form>
</body>
</html>