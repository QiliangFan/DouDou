<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./stylesheet/index.css" type="text/css"/>
<script type="text/javascript" src="./javascript/movieinfo.js"></script>
<meta charset="UTF-8">
<title>电影详情</title>
</head>
<style>
.input1{
    outline-style: none ;
    border: 1px solid #ccc; 
    border-radius: 3px;
    padding: 13px 14px;
    width: 190px;
    font-size: 13px;
    font-weight: 700;
    font-family: "Microsoft soft";
    height: 6px;
}
.input2{
    outline-style: none ;
    border: 1px solid #ccc; 
    border-radius: 3px;
    width: 60px;
    font-size: 13px;
    font-weight: 700;
    font-family: "Microsoft soft";
    margin-left:15px;
    vertical-align:middle;
    height: 34px;
    padding-left: 9px;
}
</style>
<body>

<script color="0,0,0" opacity="0.5" count="99" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.js" type="text/javascript" charset="utf-8"></script>
<div >
	<jsp:include page="./myjsp/unlogined_topbar.jsp"></jsp:include>
</div>
<div>
	<jsp:include page="./myjsp/SearchBar.jsp"></jsp:include>
</div>
<div style="display:flex;flex-direction:column;align-items:center;">
<%
	String[] info=(String[]) session.getAttribute("toMovieinfo");
	String movieName=info[0];
	String pictureName=info[1];
	String time=info[2];
	String country=info[3];
	String moviekind=info[4];
	String director=info[5];
	String screenwriter=info[6];
	double grade=Double.valueOf(info[7]);
	double numOfPeople=Double.valueOf(info[8]);
	String actor=info[9];
%>
<div style="width:60%;margin-top:60px;">

	<div style="font-size:25px;font-weight:bolder;margin-bottom:30px;">
		<%=movieName %>
	</div>
	<div style="display:flex;flex-direction:row;justify-content:flex-start;">
		<div style="width:15%;">
			<img alt="?" src="./img/<%=pictureName %>">
		</div>
		<div style="width:60%;margin-left:15px;">
			<div style="display:flex;flex-direction:column;align-items:flex-start;line-height:26px;font-size:13px;">
				<div>
					<span style="color:gray;">导演：</span>
					<span style="color:dodgerblue"><%=director %></span>
				</div>
				<div>
					<span style="color:gray;padding-top:5px;">编剧：</span>
					<span style="color:dodgerblue"><%=screenwriter %></span>
				</div>
				<div>
					<span style="color:gray;">主演：</span>
					<span style="color:dodgerblue"><%=actor %></span>
				</div>
				<div>
					<span style="color:gray;">类型：</span>
					<span style="color:dodgerblue"><%=moviekind %></span>
				</div>
				<div>
					<span style="color:gray;">制作国家或地区：</span>
					<span style="color:dodgerblue"><%=country %></span>
				</div>
				<div>
					<span style="color:gray;">上映时间：</span>
					<span style="color:dodgerblue"><%=time %></span>
				</div>
				<div>
					<span style="color:gray;">豆豆评分:<%=new DecimalFormat("0.0").format( grade/numOfPeople )%></span>
				</div>
				<form onsubmit="return check('${sessionScope.email}')" action="ScoreForMovie" id="score" name="<%=movieName %>" method="post">
					<div style="display:flex;flex-direction:row;margin-top: 50px;margin-left: -350px;">
						<input pattern="([0-9])|(10)" class="input1" type="text" name="scoreinput" id="scoreinput" placeholder="请输入您的评分：0-10分"></input>
						<input type="submit" class="input2" value="确定"></input>
					</div>
				</form>
				
			</div>
			
		</div>

	</div>
	<div style="margin-top:40px;">
		<span style="font-size:16px;color:gray">看过该电影的人留下的短评:</span>
	</div>
	<div>
		<jsp:include page="./myjsp/filmreviewforafilm.jsp"></jsp:include>
	</div>
	<div style="margin-top:40px;margin-bottom:30px;">
		<span style="font-size:13px;color:gray;">写点什么吧^.^p</span>
	</div>
	<div>
		<jsp:include page="./myjsp/writeMyFilmReview.jsp"></jsp:include>
	</div>
</div>
</div>
</body>
</html>