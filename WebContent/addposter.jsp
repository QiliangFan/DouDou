<%@ page language="java" contentType="text/html; charset=utf-8"
import="service.MovieService,serviceimp.MovieServiceImp,vo.Movie,java.util.List,servlet.MovieServlet"
import="service.PosterService,serviceimp.PosterServiceImp,vo.Poster,java.util.List,servlet.PosterServlet"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/addmovie.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>addposter</title>
</head>
<body>
<p style="font-size:25px; color:#666; margin-left:20px;">Poster</p><hr/>
    <form action="PosterServlet" method="post" class="bootstrap-frm">
	   海报名：<input type="text" name="picturename" ><br>
	   存储名：<input type="text" name="image_address" ><br>
	   电影名:<input type="text" name="movieName" ><br>
	   <input type="submit" value="提交" class="sub">
    </form>
</body>
</html>