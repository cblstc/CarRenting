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

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/common.css">
</head>
<body>

	<div class="public-header">
        <div class="public-container clearfloat">
            <div class="header-logo left-float"><a href="${pageContext.request.contextPath }/toIndex"><img src="${pageContext.request.contextPath }/images/logo.png"></a></div>
            <ul class="header-nav clearfloat">
                <!--导航栏-->
                <li class="item left-float"><a class="nav-link nav-index active" href="${pageContext.request.contextPath }/toIndex">首页</a></li>
                <li class="item left-float"><a class="nav-link nav-carlist" href="${pageContext.request.contextPath }/toCarList">租车</a></li>
                <li class="item left-float"><a class="nav-link nav-joinus" href="${pageContext.request.contextPath }/toJoinUs">加盟</a></li>
                
                <c:choose>
					<c:when test="${user == null }">
						<!--未登录-->
		                <li class="item right-float">
		                    <a class="nav-link regist-link" href="${pageContext.request.contextPath }/user/toRegist">注册</a><span class="slash-text">/</span><a class="nav-link login-link" href="${pageContext.request.contextPath }/user/toLogin">登录</a>
		                </li>
					</c:when>
					
					<c:otherwise>
						<!-- 如果登陆 -->
		                <li class="item right-float"><a class="nav-link mycargo-link" href="${pageContext.request.contextPath }/user/logout">退出</a></li>
						<li class="item right-float"><a class="nav-link mycargo-link" href="${pageContext.request.contextPath }/user/toIndex">个人中心</a></li>
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
