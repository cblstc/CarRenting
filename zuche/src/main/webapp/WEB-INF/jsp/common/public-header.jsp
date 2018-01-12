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
    <title>公共头部</title>

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/common.css">
</head>
<body>
    <div class="public-header">
        <div class="public-container clearfloat">
            <div class="header-logo left-float"><a href="#"><img src="${pageContext.request.contextPath }/images/logo.png"></a></div>
            <ul class="header-nav clearfloat">
                <!--导航栏-->
                <li class="item left-float"><a class="nav-link first-link" href="#">首页</a></li>
                <li class="item left-float"><a class="nav-link" href="#">租车</a></li>
                <li class="item left-float"><a class="nav-link" href="#">租私家车</a></li>
                <li class="item left-float"><a class="nav-link" href="#">我有车辆</a></li>
                <li class="item left-float"><a class="nav-link" href="#">以租代购</a></li>
                <li class="item left-float"><a class="nav-link" href="#">门店</a></li>
				
				<c:choose>
					<c:when test="${user == null }">
						<!-- 如果没登陆 -->
						<li class="item right-float">
		                    <a class="nav-link regist-link" href="#">注册</a><span class="slash-text">/</span><a class="nav-link login-link" href="#">登录</a>
		                </li>
					</c:when>
					
					<c:otherwise>
						<!-- 如果登陆 -->
		                <li class="item right-float"><a class="nav-link mycargo-link" href="#">我的Cargo</a></li>
		                <c:choose>
		                	<c:when test="${user.username != null }">
		                		<!-- 如果用户名存在 -->
				                <li class="item right-float"><span class="hello-text">您好，${user.username }</span></li>
		                	</c:when>
		                	
		                	<c:otherwise>
		                		<!-- 如果用户名不存在 -->
			                	<li class="item right-float"><span class="hello-text">您好，${user.phone }</span></li>	
		                	</c:otherwise>
		                </c:choose>
					</c:otherwise>
				</c:choose>

            </ul>
        </div>
    </div>
</body>
</html>
