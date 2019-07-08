<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>豆豆电影网</title>
<link rel="stylesheet" href="./stylesheet/index.css" type="text/css"/>
<script type="text/javascript" src="./javascript/getfilmreview.js"></script>
<script type="text/javascript" src="./javascript/toMovieInfo.js"></script>
</head>
<body>
<%request.getSession(); %>
<script color="0,0,0" opacity="0.5" count="99" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.js" type="text/javascript" charset="utf-8"></script>
<div style="display:flex;flex-direction:column;">
	<div >
		<jsp:include page="./myjsp/unlogined_topbar.jsp"></jsp:include>
	</div>
	<div>
		<jsp:include page="./myjsp/SearchBar.jsp"></jsp:include>
	</div>
	<div>
		<jsp:include page="./filmreview.jsp"></jsp:include>
	</div>
</div>
</body>
</html>