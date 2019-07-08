<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mysql.jdbc.Driver" %>   
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./stylesheet/index.css" type="text/css"/>
<link rel="stylesheet" type="text/css" href="../stylesheet/movie.css">
<script type="text/javascript" src="./javascript/toMovieInfo.js"></script>
<title>moviehot</title>
</head>
<body>
<script color="0,0,0" opacity="0.5" count="99" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.js" type="text/javascript" charset="utf-8"></script>
	<div >
		<jsp:include page="./myjsp/unlogined_topbar.jsp"></jsp:include>
	</div>
	<div>
		<jsp:include page="./myjsp/SearchBar.jsp"></jsp:include>
	</div>
<jsp:include page="./myjsp/RecommandMovie.jsp" />
<%  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  ////驱动程序名
            String url = "jdbc:MySQL://106.14.142.29:3306/DouDou?&useSSL=false&serverTimezone=UTC"; //数据库名
            String username = "javaweb";  //数据库用户名
            String password = "fanqiliang";  //数据库用户密码
            Connection conn = DriverManager.getConnection(url, username, password);  //连接状态
            if(conn != null){  
                //out.print("数据库连接成功！");  
                out.print("<br />"); 
%>

<%
                Statement stmt = null;
				Statement stmt2 = null;
                ResultSet rs = null;  
                String sql = "SELECT * FROM movie order by numOfPeople DESC;";  //查询语句
                stmt = conn.createStatement();
                stmt2 = conn.createStatement();
                rs = stmt.executeQuery(sql);  
                //out.print("查询结果：");  
				//out.print("<br/>");
				%>
				<div style="display:flex;flex-direction:coloumn;align-items:center;flex-wrap:wrap;margin-left:20px;margin-right:100px;">
				<%
                while (rs.next()) {
                	String mname=rs.getString("movieName");
                	String sql2="select * from Poster where movieName='"+mname+"';";
                	//out.print(sql2);  
                	ResultSet rs2 = stmt2.executeQuery(sql2);
                	rs2.next();
                	String tmp=rs2.getString("image_address");
                	//out.print(tmp);
                 	String addre="poster/"+rs2.getString("image_address");
                 	Double star=rs.getDouble("grade")/rs.getDouble("numOfPeople");
                 	//out.print(addre);
                %>
                <div style="display:flex;flex-direction:column;align-items:center;">
     <div class="div5">
            <ul style="display:flex;flex-direction:column; justify-content:center;">
                <li style="text-align:center;"><a href="javascript:void(0)" onclick="convey(this,'${sessionScope.email}')" name=<%=mname %>><img src=<%=addre %> alt="<%=mname %>" ></a></li>
            </ul>
        </div>
    <br>
    <div class="div6">
            <ul style="display:flex;flex-direction:column; justify-content:center;">
                <li style="text-align:center;"><a  href="" title="<%=mname %>"><%=mname %></a></li>
            </ul>
    </div>
     <div class="div7">
                <ul>
                    <li style="text-align:center;"><a href="" style="color:rgb(226, 171, 81);"><%=String.format("%.1f", star) %></a></li>
                </ul>
      </div>
    </div>
  <%
            }%>
            </div>
            <%
				
            }else{  
                out.print("连接失败！");  
            }  
        }catch (Exception e) {        
            //e.printStackTrace();  
            out.print("数据库连接异常！");  
        }  
%>  
</body>
</html>