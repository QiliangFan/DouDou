<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div  class="topflex topliang">
		<div style="margin:0px;display:flex;flex-direction:row;align-items:center;">
			<ul>
				<li class="font2"><a class="a1" href="main.jsp" title="电影">豆豆电影</a></li>
	            <li class="font2"><a class="a1" href="" title="读书">读书</a></li>
	            <li class="font2"><a class="a1" href="" title="音乐">音乐</a></li>
	            <li class="font2"><a class="a1" href="" title="更多">更多</a></li>
			</ul>
		</div>	
		<div class="righttop">
			<%String email=(String)session.getAttribute("email"); %>
			<c:choose>
			
				<c:when test='${email==null||email==""}'>
					<a href="./page/login.jsp" class="a1">登陆</a>/
					
					<a href="./page/signup.jsp" class="a1">注册</a>  
				</c:when>	
				<c:otherwise>
					<a href="MyOwnPage.jsp" class="a1">欢迎您!<c:out value="${email}"></c:out></a>
					/<a href="SignOut" class="a1">注销 </a>
				</c:otherwise>
			</c:choose>
		</div> 
</div> 