<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用js方式生成页面二维码</title>
<!-- 注意两个js文件的先后顺序，先加载基础js，再加载依赖js -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.qrcode.min.js"></script>
</head>
<body>
生成的二维码如下所示：<br>
<div id="qrcode"></div>
<br>
<br>
<br>
<br>
可调整大小的样例：<br>
<div id="qrcode_min"></div>


<script type="text/javascript">
	<!-- 注意一定是q大写jQuery -->
	jQuery('#qrcode').qrcode("https://www.baidu.com");
	jQuery('#qrcode_min').qrcode({width:64,height:64,text:"size doesn't matter"});
</script>
</body>
</html>