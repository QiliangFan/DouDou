<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="./javascript/toMovieInfo.js"></script>
	<div class="three-flex">
	<div class="left"></div>
	<div class="mid">
		
		<!-- 影评 -->
		<div class="filmreview">
			<c:forEach items="${ sessionScope.filmreviewlist}" var="item" varStatus="s" >
				<hr style="width:1000px;background-color:gray;height: 1px;border: none;" />
				<div class="two-flex">
					<div class="twoflex-left">
						<a href="javascript:void(0)" onclick="convey(this,'${sessionScope.email}')" name="${item[0] }">
						<img style="width:100%;" src="./img/${item[3]}" alt="review" />
						</a>	
					</div>
					<div class="twoflex-right">
						<div class="film-content">
							<div style="text-align:center;font-size:14px;color:#8c97a3;"><span style="color:#96a3b1;font-size:15px;">电影名字：</span>${item[0]}</div><p> </p>
							<div style="text-align:center;font-size:14px;margin-top: 5px;color:#8c97a3;"><span style="color:#96a3b1;font-size:15px;">影评作者：</span>${item[1]}</div><p> </p>
							<div style="text-align:center;font-size:14px;margin-top: 5px;color:#8c97a3;"><span style="color:#96a3b1;font-size:15px;">时间：</span>${item[5]}</div>
							<div style="text-indent:20px;color:gray;font-size:70%;font-size:15px;"><p style="font-size:14px;margin-top: 5px;">${item[2]}</p></div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<hr style="width:1000px;background-color:gray;height: 1px;border: none;" />
	</div>
	<div class="right"></div>
</div>
