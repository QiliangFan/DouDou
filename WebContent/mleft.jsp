<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
html,body{
  height:20%;
}
body{
  text-align:center;
}
body:before{
  content:'';
  height:100%;
  display:inline-block;
  vertical-align:middle;
}
button{
  background:rgb(150, 190, 181);
  color:#fff;
  border:none;
  position:relative;
  height:30px;
  font-size:0.8em;
  padding:10 2em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
  width:200px;
}
button:hover{
  background:#fff;
  color:#1AAB8A;
}
button:before,button:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:400ms ease all;
}
button:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
button:hover:before,button:hover:after{
  width:100%;
  transition:800ms ease all;
}
li{
	float: left;
    list-style: none;
    margin-left:-20px;
    padding-bottom:20px;
}
</style>
</head>
<body>
    <ul>
       <li><a href="addmovie.jsp" target="rights"><button>添加电影</button></a></li>
       <li><a href="showmovie.jsp" target="rights"><button>查看电影</button></a></li>
       <li><a href="addposter.jsp" target="rights"><button>添加海报</button></a></li>
       <li><a href="showposter.jsp" target="rights"><button>查看海报</button></a></li>
       <li><a href="showfilmreview.jsp" target="rights"><button>查看影评</button></a></li>
       <li><a href="mright.jsp" target="rights"><button>更多</button></a></li>
    </ul>
</body>
</html>