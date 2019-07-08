<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*" %>

<%
	List<String[]> filmreivewForAFilmList=(List<String[]>)application.getAttribute("filmreivewForAFilmList");
%>

<c:forEach items="${ applicationScope.filmreivewForAFilmList}" var="item" varStatus="s" >
				<hr style="width:1000px;background-color:gray;height: 1px;border: none;margin-top: 11px;" />
				
				
				<div class="two-flex">
					<div class="twoflex-left">
						<a style="width:100%;" href="http://4399.com">
						<img src="./img/${item[1]}" alt="review" />
						</a>	
					</div>
					<div class="twoflex-right">
						<div class="film-content">
							<div style="text-align:center;"><span style="color:gray;">电影名字：</span>${item[4]}</div><p> </p>
							<div style="text-align:center;"><span style="color:gray;">影评作者：</span>${item[3]}</div><p> </p>
							<div style="text-align:center;"><span style="color:gray;">时间：</span>${item[5]}</div>
							<div style="text-indent:20px;color:gray;font-size:70%;"><p>${item[0]}</p></div>
						</div>
					</div>
				</div>
</c:forEach>
<hr style="width:1000px;background-color:gray;height: 1px;border: none;margin-top: 11px;" />