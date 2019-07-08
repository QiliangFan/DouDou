<%@ page language="java" 
import="service.MovieService,serviceimp.MovieServiceImp,vo.Movie,java.util.List"
import="service.PosterService,serviceimp.PosterServiceImp,vo.Poster,java.util.List"
contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="./css/main.css">
<link rel="stylesheet" type="text/css" href="./stylesheet/index.css">
<script type="text/javascript" src="./javascript/addToCart.js"></script>
<script type="text/javascript" src="./javascript/toMovieInfo.js"></script>
<title>豆豆电影</title>

</head>
<%
  request.setCharacterEncoding("UTF-8");
   %>
<body>
<%request.getSession(); %>

<script color="0,0,0" opacity="0.5" count="99" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.js" type="text/javascript" charset="utf-8"></script>
<jsp:include page="./myjsp/unlogined_topbar.jsp" />
<jsp:include page="./myjsp/SearchBar.jsp"/>
<div class="mdiv1">
<ul>
<li><p class="mfont1">正在热映</p></li>
<li ><a href="buy_ticket.jsp" title="全部正在热映" class="mfont2" style="zindex:4">全部正在热映 》 </a></li>
</ul>
</div>
    <%
    //直接调用后台数据
     MovieService ts=new MovieServiceImp();
     PosterService ps=new PosterServiceImp();
     Poster p=new Poster();
     List<Movie> list=ts.selects2();
     List<Movie> list2=ts.selects();
     %>
     <div class="box">
     <%
     for(int i=0;i<list.size()&&i<5;i++){
     Movie n=list.get(i);
     p.setMovieName(n.getMovieName());
     System.out.println(n.getMovieName());
     Poster x=ps.selectone(p);
     System.out.println(x.getImage_address());
     String addre="./poster/"+x.getImage_address();
     System.out.println(addre);
     Double star=n.getGrade()/n.getNumOfPeople();
     %>
     <div>
     <div class="div5">
            <ul>
                <li><a href="javascript:void(0)" onclick="convey(this,'${sessionScope.email}')" name=<%=n.getMovieName() %>><img style="padding-left:75px;padding-top:5px;" src=<%=addre %> alt="<%=n.getMovieName()%>"></a></li>
            </ul>
        </div>
    <br>
    <div class="div6">
            <ul>
                <li style="text-align:center;"><a style="padding-left:75px;padding-top:0px;" href="" title="<%=n.getMovieName() %>"><%=n.getMovieName() %></a></li>
            </ul>
    </div>
     <div class="div7">
                <ul>
                    <li style="text-align:center;"><a href="" style="padding-left:75px;color:rgb(226, 171, 81);"><%=String.format("%.1f", star) %></a></li>
                </ul>
      </div>
      <div class="divbutton">
                <ul>
                    <li style="text-align:center;"><a  href="javascript:void(0)" onclick="addToCart('${sessionScope.email}','<%=n.getMovieName() %>')" class="button button1" style="font-size:13px">购票</a></li>
                </ul>
       </div>
    </div>
    <%
     }
     %>
     </div>
     <img style="padding-left:100px;padding-top:10px;width:60%;" src="img/guanggao2.jpg" alt="姚晨">
  	 <div class="mdiv2" >
	<ul>
	<li><p class="mfont1">最近热门电影 </p></li>
	<li ><a href="movietime.jsp" title="最新" class="mfont2" >最新</a></li>
	<li ><a href="moviehot.jsp" title="热门" class="mfont2" >热门</a></li>
	<li ><a href="moviegrade.jsp" title="豆瓣高分" class="mfont2" >豆瓣高分</a></li>
	<li ><a href="moviechina.jsp" title="华语" class="mfont2" >华语</a></li>
	<li ><a href="movieAmerica.jsp" title="欧美" class="mfont2" >欧美 </a></li>
	<li ><a href="movieJapan.jsp" title="日本" class="mfont2" >日本</a></li>
	<li ><a href="movieKorea.jsp" title="韩国" class="mfont2" >韩国 </a></li>
	<li ><a href="movierank.jsp" title="全部正在热映" class="mfont2" >更多 》 </a></li>
	</ul>
	</div>
	<div class="box">
     <%
     for(int i=0;i<list2.size()&&i<5;i++){
     Movie n=list2.get(i);
     p.setMovieName(n.getMovieName());
     Poster x=ps.selectone(p);
     String addre="poster/"+x.getImage_address();
     System.out.println(addre);
     Double star=n.getGrade()/n.getNumOfPeople();
     %>
     <div>
     <div class="div5">
            <ul>
                <li style="text-align:center;"><a href="javascript:void(0)" onclick="convey(this,'${sessionScope.email}')" name=<%=n.getMovieName() %>><img style="padding-left:70px;padding-top:5px;" src=<%=addre %> alt="<%=n.getMovieName()%>"></a></li>
            </ul>
        </div>
    <br>
    <div class="div6">
            <ul>
                <li style="text-align:center;"><a style="padding-left:70px;padding-top:0px;" href="" title="<%=n.getMovieName() %>"><%=n.getMovieName() %></a></li>
            </ul>
    </div>
     <div class="div7">
                <ul>
                    <li style="text-align:center;"><a href="" style="padding-left:70px;color:rgb(226, 171, 81);"><%=String.format("%.1f", star) %></a></li>
                </ul>
      </div>
    </div>
    <%
     }
     %>
     </div>
     <div class="mdiv1" >
		<ul>
		<li><p class="mfont1">最受欢迎的影评 </p></li>
		<li ><a href="./index.jsp" title="更多热门影评" class="mfont2" >更多热门影评 》 </a></li>
		</ul>
	</div>
	<img style="padding-left:100px;padding-top:10px;width:40%;" src="img/yingping.jpg">
	<img style="padding-left:100px;padding-top:10px;width:20%;" src="img/yingpinglogo.jpg">
	<img style="padding-left:10px;padding-top:10px;" src="img/bottom.png">
</body>
</html>