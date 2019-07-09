<%@ page language="java" contentType="text/html; charset=utf-8"
import="service.MovieService,serviceimp.MovieServiceImp,vo.Movie,java.util.List,servlet.MovieServlet"
import="service.PosterService,serviceimp.PosterServiceImp,vo.Poster,java.util.List,servlet.PosterServlet"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/addmovie.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>addmovie</title>
</head>
<body>
	<p style="font-size: 25px; color: #666; margin-left: 20px;">Movie</p>
<hr />
	<form action="MovieServlet" method="post" class="bootstrap-frm">
		电影片名：<input type="text" name="movieName"><br> 电影导演：<input
		type="text" name="director"><br> 上映日期:<input type="text"
		name="time"><br> 制片国家：<input type="text" name="country"><br>
		电影编剧：<input type="text" name="screenwriter"><br> 电影类型：<input
		type="text" name="moviekind"><br> 获评总分：<input type="text"
		name="grade"><br> 评分人数：<input type="text" name="numOfPeople"><br> 电影票价：<input type="text"
		name="price"><br> 电影主演：<input type="text" name="actor"><br>
		<input type="submit" value="提交" class="sub">
</form>
</body>
</html>