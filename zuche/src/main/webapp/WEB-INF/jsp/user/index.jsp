<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<%-- <link rel="stylesheet" href="${pageContext.request.contextPath }/css/menu.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/zTreeStyle.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.ztree.core.js"></script> --%>
	<script type="text/javascript">
	</script>
	<style type="text/css">
	</style>
 </head>

<body>
	<c:if test="${user == null }">
		<a href="${pageContext.request.contextPath }/user/toRegist">注册</a> | 
		<a href="${pageContext.request.contextPath }/user/toLogin">登录</a>
	</c:if>
	<c:if test="${user != null }">
		<span>${user.phone }</span> | 
		<a href="${pageContext.request.contextPath }/user/toEditInfo">完善信息</a> | 
		<a href="${pageContext.request.contextPath }/user/toMyCar">我的车辆</a> | 
		<a href="${pageContext.request.contextPath }/user/logout">退出登录</a>
	</c:if>
</body>
</html>

