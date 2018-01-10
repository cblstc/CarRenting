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
	<h1>车辆</h1>
	<c:forEach var="car" items="${cars }">
		<form action="${pageContext.request.contextPath }/order/toReserve" method="post">
			品牌：大众
			型号：凯美瑞
			配置：高配版
			变速箱：${car.gearbox }	
			<input type="submit" value="立即预定" />
			<hr>
		</form>
	</c:forEach>
</body>
</html>

