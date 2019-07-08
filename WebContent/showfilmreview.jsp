<%@ page language="java" contentType="text/html; charset=utf-8"
import="service.FilmReviewService,serviceimp.FilmReviewServiceImp,vo.FilmReview,java.util.List"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>showfilmreview</title>
<style type="text/css">
.*{
font-family:鍦嗕綋;
}
body,table{
font-size:12px;
}
table{
table-layout:fixed;
empty-cells:show;
border-collapse: collapse;
margin:0 auto;
}
td{
height:30px;
}
h1,h2,h3{
font-size:12px;
margin:0;
padding:0;
}
.table{
border:2.5px solid #cad9ea;
color:#666;
}
.table th {
background-repeat:repeat-x;
height:30px;
}
.table td,.table th{
border:1.5px solid #cad9ea;
padding:0 1em 0;
}
.button {
    border: none;
    color: white;
/*     padding: 16px 32px; */
	
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 11px;
    margin-left:10px; 
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}
.button1 {
    background-color: white; 
    color:#666;; 
    border: none;
}

.button1:hover {
    background-color:#cfe2d1;
    color:#666;;
}
</style>
<script type="text/javascript">
function deletes_(movieName,time,author){
   var f=confirm("是否确定删除？");
   if(f){
   location.href="FilmReviewServletdelete?movieName="+movieName+"&time="+time+"&author="+author;
   }else{
   alert("您取消删除");
   }
}
 
function update(movieName,time,author){
	var f=confirm("是否确定修改？");
	 if(f){
		   location.href="updatefilmreview.jsp?movieName="+movieName+"&time="+time+"&author="+author;
		   }else{
		   alert("您取消删除");
		   }
}
</script>
</head>
<body>
    <table width="90%" class="table" style="text-align:center; margin-top:50px;">
    <tr>
    <td style=" background-color:#f7f7f7;">电影片名</td>
    <td style="width:120px; background-color:#f7f7f7;">海报地址</td>
    <td style="background-color:#f7f7f7;">被浏览量</td>
    <td style="width:120px; background-color:#f7f7f7;">评论作者</td>
    <td style="width:70px; background-color:#f7f7f7;">评论时间</td>
    <td style="width:300px; background-color:#f7f7f7;">影评</td>
    <td style="background-color:#f7f7f7;">操作</td>
    </tr>
    <%
    //直接调用后台数据
     FilmReviewService ts=new FilmReviewServiceImp();
     List<FilmReview> list=ts.selects();
     for(int i=0;i<list.size();i++){
     FilmReview n=list.get(i);
     String cut=new String();
     if(n.getImageName().length() > 15) {
    	 cut = n.getImageName().substring(0, 15)+ "...";
    	 }else {
    	 cut=n.getImageName();
    	 }
     
     %>
     <tr>
  <td><%=n.getMovieName() %></td>
  <td><%=cut %></td>
  <td><%=n.getReadnum() %></td>
  <td><%=n.getAuthor() %></td>
  <td><%=n.getTime() %></td>
  <td><%=n.getReview() %></td>
  <td ><input type="button" style="height:22px;width: 40px;margin-left:-5px;margin-top:8px;" class="button button1" onclick="update(<%="'"+n.getMovieName()+"'" %>,<%="'"+n.getTime()+"'" %>,<%="'"+n.getAuthor()+"'" %>)" value="修改"/>
    
     <input type="button" style="margin-top:8px;height:22px;width: 40px;margin-left:-5px;margin-bottom:8px;" class="button button1" onclick="deletes_(<%="'"+n.getMovieName()+"'" %>,<%="'"+n.getTime()+"'" %>,<%="'"+n.getAuthor()+"'" %>)" value="删除"/></td>
  </tr>
    <%
     }
     %>
     </table>
</body>
</html>