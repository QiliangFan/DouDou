<%@ page language="java" contentType="text/html; charset=utf-8"
import="service.MovieService,serviceimp.MovieServiceImp,vo.Movie,java.util.List,servlet.MovieServlet,servlet.MovieServletupdate"
import="service.PosterService,serviceimp.PosterServiceImp,vo.Poster,java.util.List,servlet.PosterServlet,servlet.PosterServletupdate"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/addmovie.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>updateposter</title>
</head>
<body>
 <% 
    request.setCharacterEncoding("UTF-8");
    PosterServletupdate tsu=new PosterServletupdate();
    Poster p=new Poster();
    String movieName= request.getParameter("movieName");
    PosterService ms=new PosterServiceImp();
	Poster ch=new Poster();
    if(movieName!=null){
    	p.setMovieName(movieName);
    	ch=ms.selectone(p);
    }
    %>
<p style="font-size:25px; color:#666; margin-left:20px;">Poster</p><hr/>
    <form action="PosterServletupdate" method="post" class="bootstrap-frm">
    海报名：<input type="text" name="picturename" value=<%=ch.getPicturename() %>><br>
     存储名：<input type="text" name="image_address" value=<%=ch.getImage_address() %>><br>
    电影名:<input type="text" name="movieName" value=<%=ch.getMovieName() %>><br>
    <input type="submit" value="提交" class="sub">
    </form>
</body>
</html>