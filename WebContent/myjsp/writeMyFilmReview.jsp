<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="../javascript/movieinfo.js"></script>
<style>
.input3{
    outline-style: none ;
    border: 1px solid #ccc; 
    border-radius: 3px;
    width: 70px;
    font-size: 13px;
    font-weight: 700;
    font-family: "Microsoft soft";
    margin-left:15px;
    vertical-align:middle;
    height: 30px;
}
</style>
<input id="forgetemail" style="display:none;" value="${sessionScope.email }"></div>
<form onsubmit="return checkfilmreview()" action="WriteMyFilmReview" method="post">
	<div style="display:flex;flex-direction:column;align-items:flex-start;justify-content:flex-start;">
		<textarea rows="5" cols="100" name="writemyfilmreivew" id="writemyfilmreivew" placeholder="你就这么狠心让我空手而归吗～.～" style="font-size: 13px;"></textarea>
		<input style="align-self:center;margin-top:20px;margin-bottom:20px;" type="submit" class="input3" value="提交"/>
</div>
</form>