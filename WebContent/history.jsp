<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./stylesheet/history.css"></link>
<meta charset="UTF-8">
<title>个人主页</title>

<link rel="stylesheet" href="./stylesheet/index.css" type="text/css"/>
<link rel="stylesheet" href="./stylesheet/myownpage.css" type="text/css" />
<script type="text/javascript" src="./javascript/MyOwnPage.js"></script>
<script type="text/javascript" src="./javascript/myinfo.js"></script>

</head>
<body>
<script color="0,0,0" opacity="0.5" count="99" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.js" type="text/javascript" charset="utf-8"></script>
<input style="display:none;" id="transport" value="${sessionScope.email }"></input>

<div style="display:flex;flex-direction:column;">
	<div>
		<jsp:include page="./myjsp/unlogined_topbar.jsp"></jsp:include>
	</div>
	<!-- 分三列，分别是空白、操作界面、鸟 -->
	<div class="header1">
        <p class="doudoufont">豆豆电影</p>
    </div>
	<div class="mySelect">
				<!-- 个人信息 -->
					<button onclick="myinfo()">个人信息</button>
					<button onclick="mycart()">购物车</button>
					<button onclick="history()">浏览记录</button>
					<button onclick="myfilmreview()">写过的影评</button>
					<c:if test="${sessionScope.authority==1 }">
						<button onclick="manage()">管理影评</button>
					</c:if>
	</div>
	<div class="MyOwnPage">
		<!-- 空白 -->
		<div class="MyOwnPageLeft">	
		</div>
		<!--操作界面  -->
		<div class="MyOwnPageCenter">
			
			<!-- 操作页面 -->
			<div class="operatePage">	
				<div class="history">
	<c:forEach items="${sessionScope.history }" var="item" varStatus="s" >
		<div style="width:100%;display:flex;flex-direction:row;justify-content:flex-start;">
			<div style="font-size: 13px;">
				<span style="color:gray;font-size: 13px;">电影名字：</span>${ item[2]}
			</div>
			<div style="margin-left:20px;font-size: 13px;">
				<span style="color:gray;font-size: 13px;">      访问时间:</span>${ item[1]}
			</div>
			<div style="margin-left:20px;font-size: 13px;">
				<span style="color:gray;font-size: 13px;">      访问者:</span>${ item[0]}
			</div>
			<div style="margin-left:20px;font-size: 13px;">
				<span style="color:gray;font-size: 13px;">      操作类型：${item[3] }电影</span>
			</div>
		</div>
	</c:forEach>
</div>
			</div>
			</div>
		
		<!--鸟 -->
		<div class="MyOwnPageRight">
			<img alt="bird" src="./img/bird.png">
		</div>
	</div>
</div>
<img style="padding-left:10px;padding-top:10px;" src="img/bottom.png">
</body>
</html>


