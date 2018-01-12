<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>结果页面</title>
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap-theme.min.css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/common.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/result.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery-3.2.1.min.js"></script>
</head>
<body>

    <div class="main-content">
        <div class="result-content">
            <div class="title-content">
            	<c:choose>
            		<c:when test="${resultCode == 1 }">
            			<img class="title-img" src="${pageContext.request.contextPath }/images/common/success.png">	
            		</c:when>
            		<c:otherwise>
            			<img class="title-img" src="${pageContext.request.contextPath }/images/common/fail.png">
            		</c:otherwise>
            	</c:choose>
                
                <span class="title-text">${resultText }</span>
            </div>
            <div class="redirect-content">
                <span>马上去 <a class="login-link" href="#">${redirectText }</a></span>
            </div>
            <div class="auto-content">
                <span>该页将在<span class="seconds-text">5s</span>后自动跳转</span>
            </div>
        </div>
    </div>


    <script>
        $(function() {
        	// 倒计时
            var num = 5;
            var interval = setInterval(function() {
            	if (num == 1)
    				clearInterval(interval);	
                $(".seconds-text").text(--num + "s");
            },1000);
            var redirectUrl = "${pageContext.request.contextPath}/" + "${redirectUrl}";
            setTimeout("window.location='" + redirectUrl + "'", 5000);
        });
    </script>
</body>
</html>
