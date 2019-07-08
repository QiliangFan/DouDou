<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="myinfo">
	<div class="image">
		<img style="width:80%;" alt="bear" src="./img/bear.gif">
	</div>
	<div class="text" style="margin-top: 70px;">
		<div class="text-content" style="font-size:110%; color:#585858;">邮箱：${sessionScope.email}</div>
		<div class="text-content">
			<form style="" action="ModifyPwd" method="post">
				<div style="display:flex;flex-direction:column;justify-content: space-between;align-items:flex-end;">
					<p id="password1"><input style="width:200px;" name="pwd1" type="password" id="pwd1"></input></p>
					<p id="password2"><input style="width:200px;" name="pwd2" type="password" id="pwd2"></input></p>
					<input style="margin-top:35px;" type="submit" id="submit" value="修改密码" class="sub"></input>
				</div>
			</form>
		</div>
	</div>
</div>