<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>account</title>
</head>
<body>
	<h2>Hello World!</h2>
	<hr />
	<form action="admin/login" method="post">
		<input type="text" name="adminName" /> <input type="text"
			name="adminPassword"> 
			<input type="hidden" value="${token}" name="token">
			<input type="submit">
	</form>
	<hr />
	<form action="mail/sendMail" method="post">
		<input type="text" name="toMail" /></br> 
		<img alt="加载失败"
			src="image/randomCode" onclick="changeImage()"> 
			<input type="text" name="inputCode" />
			<input
			type="submit" value="注册" />
	</form>
	<script type="text/javascript">
		function changeImage() {
			//var img=document.getElementsByTagName("img");
			//alert("ok");
			window.location.reload(true);
		}
	</script>
</body>
</html>
