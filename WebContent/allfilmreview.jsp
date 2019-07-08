<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
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
				<div class="myfilmreview">
<c:forEach items="${sessionScope.allfilmreview }" var="item" varStatus="s">
<div style="display:flex;flex-direction:row;width:100%;align-items:center;justify-content:center;margin-top:40px;">
	<div class="filmimage">
		<img style="width:100%;" alt="s" src="./img/${item[1]}">
	</div>
	<div class="filmcontent">
		<div style="align-self:center;text-align:center;margin-bottom:10px;color:#8c97a3;font-size: 15px;"><span style="color:#96a3b1;">电影名字:</span>${item[4] }</div>
		<div> </div>
		<div style="align-self:center;text-align:center;margin-bottom:10px;color:#8c97a3;font-size: 15px;"><span style="color:#96a3b1;">作者:</span>${item[3] }</div>
		<div> </div>
		<div style="text-align:center;color:#8c97a3;font-size: 15px;"><span style="color:#96a3b1;">时间：</span>${item[5]}</div>
		<div style="text-indent:5px;color:gray;font-size:12px;margin-top: 7px;">${item[0] }</div>
		<div></div>
	</div>
	<div>
		<form action="DeleteMyServlet" method="post"><input type="text" name="emailNameFromTable" value="${item[3]}" style="display:none;"/><input type="submit" class="sub" value="删除"/></form>
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

