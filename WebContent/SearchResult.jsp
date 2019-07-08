<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./javascript/toMovieInfo.js"></script>
<link rel="stylesheet" type="text/css" href="./stylesheet/searchresult.css"></link>
<title>搜索结果页面</title>
<link rel="stylesheet" type="text/css" href="./stylesheet/index.css"></link>
</head>
<body>
	<div style="display:flex;flex-direction:column;">
		<div>
			<jsp:include page="./myjsp/unlogined_topbar.jsp"></jsp:include>
		</div>
		<div>
			<jsp:include page="./myjsp/SearchBar.jsp"></jsp:include>
		</div>
		<div>
			<%
			int num=Integer.valueOf((String)session.getAttribute("movieNum"));
			%>
		<c:if test="${sessionScope.movieNum=='0'}">
			<div class="none">
				<div class="noneleft">
					<img style="width:100%;height:100%;" src="./img/yingyingying.gif" alt="ya"/>
				</div>
				<div class="noneright">
					<img style="width:100%;height:100%;" src="./img/wobuzhidao.jpg" alt="ya"/>
				</div>
			</div>
		</c:if>
		<c:if test='${sessionScope.movieNum!="0"}'>
			<div>
			
				<%
					int totalnum=Integer.valueOf((String)(session.getAttribute("movieNum")));
					String[] movie=new String[totalnum];
					String[] image=new String[totalnum];
					for(int i=0;i<totalnum;i++){
						movie[i]=(String)session.getAttribute("movie"+String.valueOf(i+1));
						image[i]=(String)session.getAttribute("image"+String.valueOf(i+1));
					}
					session.setAttribute("image", image);
					session.setAttribute("movie",movie);
				%>
				
				<!-- 点击图片并传入参数 -->
				<div class="have">
					<c:forEach items="${image}" var="item" varStatus="s">
							
							<c:if test="${s.index%2==0 }">
								<div class="haveleft">
									<a style href="javascript:void(0)" onclick="convey(this,'${sessionScope.email}')" name="${sessionScope.movie[s.index] }"><img style="width:25%;align-self:center;" src="./img/${item}" alt="?"/></a>
									<a name="movieName"  href="javascript:void(0)" style="color: black;"> ${sessionScope.movie[s.index] }</a>				
								</div>
							</c:if>
								
								<c:if test="${s.index%2==1	 }">
									<div class="haveright">
										<img style="width:25%;align-self:center;" src="./img/${item}" alt="?"/>
										<a href="javascript:void(0)" onclick="convey(this,'${sessionScope.email}')" name="${sessionScope.movie[s.index] }" style="color: black;"> ${sessionScope.movie[s.index] }</a>
									</div>
								</c:if>
							
					</c:forEach>
					</div>
			</div>
		</c:if>
		</div>
	</div>
</body>
</html>