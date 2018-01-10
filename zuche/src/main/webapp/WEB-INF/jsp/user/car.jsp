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
	<h1>我的车辆</h1>
	<a href="${pageContext.request.contextPath }/user/toAddCar">添加车辆</a>
</body>
</html>

