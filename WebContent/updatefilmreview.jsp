<%@ page language="java" contentType="text/html; charset=utf-8"
import="service.FilmReviewService,serviceimp.FilmReviewServiceImp,vo.FilmReview,java.util.List,servlet.FilmReviewServletupdate"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/addmovie.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>updatefilmreview</title>
</head>
<body>
 <% 
    request.setCharacterEncoding("UTF-8");
 	FilmReviewServletupdate frsu=new FilmReviewServletupdate();
 	FilmReview p=new FilmReview();
    String movieName= request.getParameter("movieName");
    String time= request.getParameter("time");
    String author= request.getParameter("author");
//     System.out.println(movieName);
//     System.out.println(time);
//     System.out.println(author);
    FilmReviewService ms=new FilmReviewServiceImp();
    FilmReview ch=new FilmReview();
    if(movieName!=null&&time!=null&&author!=null){
    	p.setMovieName(movieName);
    	p.setTime(time);
    	p.setAuthor(author);
    	ch=ms.selectone(p);
    	//System.out.println(ch.getAuthor());
    }
    %>
<p style="font-size:25px; color:#666; margin-left:20px;">FilmReview</p><hr/>
    <form action="FilmReviewServletupdate" method="post" class="bootstrap-frm">
    电影片名：<input type="text" name="movieName" value=<%=ch.getMovieName() %>><br>
    海报地址：<input type="text" name="imageName" value=<%=ch.getImageName() %>><br>
    被浏览量:<input type="text" name="readnum" value=<%=ch.getReadnum() %>><br>
    评论作者:<input type="text" name="author" value=<%=ch.getAuthor() %>><br>
    评论时间:<input type="text" name="time" value=<%=ch.getTime() %>><br>
    电影影评:<input type="text" name="review" value=<%=ch.getReview() %>><br>
    <input type="submit" value="提交" class="sub">
    </form>
</body>
</html>