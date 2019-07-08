<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
<style>
/*         * { */
/*             box-sizing: border-box; */
/*         } */

/*         body { */
/*             margin: 0; */
/*             padding: 0; */
/*             font-weight: 500; */
/*             font-family: "Microsoft YaHei","宋体","Segoe UI", "Lucida Grande", Helvetica, Arial,sans-serif, FreeSans, Arimo; */
/*         } */

        #container {
            width: 500px;
            height: 820px;
            margin: 0 auto;
        }
        div.search {padding: 30px 0;}

        form {
            position: relative;
/*             width: 300px; */
            margin: 0 auto;
        }

        input, button {
            border: none;
            outline: none;
        }

        input {
            width: 100%;
            height: 42px;
            padding-left: 13px;
        }

        button {
            height: 42px;
            width: 42px;
            cursor: pointer;
            position: absolute;
        }
        /*搜索框7*/
        .bar7 form {
            height: 42px;
        }
        .bar7 input {
            width: 200px;
            border-radius: 42px;
            border: 2px solid rgb(209, 215, 216);
            background: white;
            transition: .3s linear;
            float: right;
            height:32px;
        }
        .bar7 input:focus {
            width: 300px;
        }
        .bar7 button {
            background: none;
            top: -2px;
            margin-left:165px;
            margin-top:0px;
        }
        .bar7 button:before{
          content: "\f002";
          font-family: FontAwesome;
          color: #c0c0c0;
        }
</style>
<div class="header1">
    <div style="display:flex;flex-direction:row;align-items:center;">
        <p class="doudoufont">豆豆电影</p>
    </div>
    <div style="display:flex;flex-direction:row;justify-content:center;;width:40%;margin-left:-70px;margin-top: 7px">
    <form action="search" method="post" class="search bar7">
		<div style="display:flex;flex-direction:row;justify-content:center;">
		<input  type="text"  name="searchcontent"/>
		<button type="submit" name="search" value="搜索影片"></button>
		</div>
	</form>
	</div>
</div>
<div class="header2">
        <ul>
            <li class="font3"><a id="buy" href="buy_ticket.jsp" title="资讯&购票">资讯&购票</a></li>
            <li class="font3"><a id="choosemovie" href="movierank.jsp" title="选电影">选电影</a></li>
            <li class="font3"><a id="type" href="movierank.jsp" title="分类">分类</a></li>
        </ul>
</div>

