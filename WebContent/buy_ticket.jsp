<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.mysql.jdbc.Driver"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="referrer" content="never">
<link rel="stylesheet" type="text/css" href="./stylesheet/buy.css">
<link rel="stylesheet" href="./stylesheet/index.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./javascript/addToCart.js"></script>
<script type="text/javascript" src="./javascript/toMovieInfo.js"></script>
<title>buy_ticket</title>
</head>
<body>
	<div><jsp:include page="./myjsp/unlogined_topbar.jsp"></jsp:include>
</div>
	<div><jsp:include page="./myjsp/SearchBar.jsp"></jsp:include></div>
	<div class="div4">
		<p
		style="font-size: 26px; font-weight: 700; font-family: Arial; padding-top: 30px; padding-left: 100px; color: rgb(0, 0, 0);">电影票
			- 天津</p> <br /> <a href=""><img
			style="padding-left: 100px; padding-top: 0px; width: 650px;%;"
			src="img/guanggao.jpeg" alt="蜘蛛侠： 英雄远征 2019"></a> <br />
		<p
		style="font-size: 15px; font-family: Arial; padding-top: 10px; padding-left: 100px; color: rgb(48, 116, 86);">正在上映</p>
</div>
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
                String sql = "SELECT * FROM movie where (select (UNIX_TIMESTAMP((select DATE(CURDATE()))) - UNIX_TIMESTAMP(time))/(60*60*24) dif_minute)<30 order by time DESC;";  //查询语句
                stmt = conn.createStatement();
                stmt2 = conn.createStatement();
                rs = stmt.executeQuery(sql);  
                //out.print("查询结果：");  
				//out.print("<br/>");
				%>
	<div
	style="display: flex; flex-direction: row; align-items: center; flex-wrap: wrap; margin-right: 100px;">
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
                 	//out.print(addre);
                %>
		<div
		style="display: flex; flex-direction: column; align-items: center; margin-top: 50px; margin-left: 50px;">
			<div class="div5">
				<ul
				style="display: flex; flex-direction: column; align-items: center;">
					<li style="text-align: center;"><a href="javascript:void(0)"
						onclick="convey(this,'${sessionScope.email}')" name=<%=mname %>><img
							src=<%=addre %> alt="<%=mname %>"></a></li>
			</ul>
		</div> <br>
			<div class="div6">
				<ul
				style="display: flex; flex-direction: column; align-items: center;">
					<li style="text-align: center; margin-top: 5px;"><a href=""
						title="<%=mname %>"><%=mname %></a></li>
			</ul>
		</div>
			<div>
				<ul
				style="display: flex; flex-direction: column; align-items: center;">
					<li style="list-style: none; text-align: center;"><a
						href="javascript:void(0)"
						onclick="addToCart('${sessionScope.email}','<%=mname %>')"
						class="button button1"
						style="font-size: 13px; margin-top: 5px; background-color: #268DCD; color: white;">购票</a></li>
			</ul>
		</div>
	</div> <%
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
	<img style="padding-left: 10px; padding-top: 10px;"
	src="img/bottom.png">
</body>
</html>