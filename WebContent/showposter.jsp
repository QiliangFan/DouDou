<%@ page language="java" contentType="text/html; charset=utf-8"
import="service.MovieService,serviceimp.MovieServiceImp,vo.Movie,java.util.List,servlet.MovieServlet"
import="service.PosterService,serviceimp.PosterServiceImp,vo.Poster,java.util.List,servlet.PosterServlet"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>showposter</title>
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
function deletes_(id){
   var f=confirm("是否确定删除？");
   if(f){
   location.href="PosterServletdelete?movieName="+id;
   }else{
   alert("您取消删除");
   }
}
 
function update(moviename){
	location.href="updateposter.jsp?movieName="+moviename;
}
</script>
</head>
<body>
    <table width="90%" class="table" style="text-align:center; margin-top:50px;">
    <tr>
    <td style="width:200px; background-color:#f7f7f7;">海报名</td>
    <td style="width:250px; background-color:#f7f7f7;">存储名</td>
    <td style="background-color:#f7f7f7;">电影名</td>
    <td style="background-color:#f7f7f7;">操作</td>
    </tr>
    <%
    //直接调用后台数据
     PosterService ts=new PosterServiceImp();
     List<Poster> list=ts.selects();
     for(int i=0;i<list.size();i++){
     Poster n=list.get(i);
     %>
     <tr>
  <td><%=n.getPicturename() %></td>
  <td><%=n.getImage_address() %></td>
  <td><%=n.getMovieName() %></td>
  <td ><input type="button" style="height:22px;width: 40px;margin-left: 0px;margin-top:8px;" class="button button1" onclick="update(<%="'"+n.getMovieName()+"'" %>)" value="修改"/>
    
     <input type="button" style="margin-top:8px;height:22px;width: 40px;margin-left: 0px;margin-bottom:8px;" class="button button1" onclick="deletes_(<%="'"+n.getMovieName()+"'"%>)" value="删除"/></td>
  </tr>
    <%
     }
     %>
     </table>
</body>
</html>