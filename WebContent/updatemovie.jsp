<%@ page language="java" contentType="text/html; charset=utf-8"
import="service.MovieService,serviceimp.MovieServiceImp,vo.Movie,java.util.List,servlet.MovieServlet,servlet.MovieServletupdate"
import="service.PosterService,serviceimp.PosterServiceImp,vo.Poster,java.util.List,servlet.PosterServlet"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/addmovie.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>updatemovie</title>
</head>
<body>
 <% 
    request.setCharacterEncoding("UTF-8");
    MovieServletupdate tsu=new MovieServletupdate();
    Movie m=new Movie();
    String movieName= request.getParameter("movieName");
    MovieService ms=new MovieServiceImp();
	Movie ch=new Movie();
    if(movieName!=null){
    	m.setMovieName(movieName);
    	ch=ms.selectone(m);
    }
    %>
<p style="font-size:25px; color:#666; margin-left:20px;">Movie</p><hr/>
    <form action="MovieServletupdate" method="post" class="bootstrap-frm">
    电影片名：<input type="text" name="movieName" value=<%=ch.getMovieName() %>><br>
     电影导演：<input type="text" name="director" value=<%=ch.getDirector() %>><br>
    上映日期:<input type="text" name="time" value=<%=ch.getTime() %>><br>
    制片国家：<input type="text" name="country" value=<%=ch.getCountry() %>><br>
    电影编剧：<input type="text" name="screenwriter" value=<%=ch.getScreenwriter() %>><br>
    电影类型：<input type="text" name="moviekind" value=<%=ch.getMoviekind() %>><br>
    获评总分：<input type="text" name="grade" value=<%=ch.getGrade() %>><br>
    评分人数：<input type="text" name="numOfPeople" value=<%=ch.getNumOfPeople() %>><br>
    电影票价：<input type="text" name="price" value=<%=ch.getPrice() %>><br>
    电影主演：<input type="text" name="actor" value=<%=ch.getActor() %>><br>
    <input type="submit" value="提交" class="sub">
    </form>
</body>
</html>