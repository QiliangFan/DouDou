<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆界面</title>
<link rel="stylesheet" type="text/css" href="../stylesheet/login.css"/>
<script type="text/javascript" src="../javascript/logsign.js"></script>
</head>
<body>
<script color="0,0,0" opacity="0.5" count="99" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.js" type="text/javascript" charset="utf-8"></script>
	<div class="login">
		<div class="loginleft">
			<img style="width:100%;height:100%;" src="../img/logsign1.png" alt="logsign1"/>
		</div>
		<div class="loginright">
			<form action="../Verify" method="post" style="text-align:center;">
					<input type="email" id="email" name="email" placeholder="请输入邮箱"></input><br>
					<input type="password" id="pwd" name="pwd" placeholder="请输入密码"></input><br>
					<input type="submit" name="login" value="登陆"></input><br>	
			</form>
		</div>
		<div class="end">
			
		</div>
	</div>
</body>
</html>