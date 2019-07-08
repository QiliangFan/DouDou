<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎加入豆豆家园</title>
<link rel="stylesheet"  href="../stylesheet/login.css" type="text/css"/>
<script type="text/javascript" src="../javascript/logsign.js"></script>
</head>
<body>
<script color="0,0,0" opacity="0.5" count="99" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.js" type="text/javascript" charset="utf-8"></script>
	<div class="login">
		<div class="loginleft">
			<img style="width:100%;height:100%;" src="../img/logsign1.png" alt="logsign2"/>
		</div>
		<div class="loginright">
			<form action="../Verify" method="post" style="text-align:center;">
				<input type="email" id="email" name="email" placeholder="请输入邮箱"></input><br>
				<input type="password" id="pwd1" name="pwd1" placeholder="请输入密码" ></input><br>
				<input type="password" id="pwd2" name="pwd2" placeholder="请再次输入密码" ></input><br>
				<input type="submit" id="signup" name="signup" value="注册"></input><br>
			</form>
		</div>
		<div class="end">
		
		</div>
	</div>
</body>
</html>
