<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>上传文件测试</title>
  </head>
<body>
<div align="center">
  <!-- 文件上传操作时form表单必须加上enctype属性 -->
  <h1>上传附件</h1>
  <form method="post" action="/SSMDemo/students/doUpload" enctype="multipart/form-data">
  <input type="file" name="file" />
  <input type="submit" value="上传"/>
  </form>
</div>
</body>
</html>