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
	<h1>订单信息</h1>
	<form action="${pageContext.request.contextPath }/order/generateOrder" method="post">
		品牌：大众<br/>
		型号：凯美瑞<br/>
		配置：高配版<br/>
		变速箱：${car.gearbox }<br/>
		日均价：${car.price }<br/>
		保险：300<br/>
		不计免赔：50<br/>
		总计：500<br/>
		<span>您需在线支付押金，订单完成、未接单四小时后自动退款，接单后四小时内可手动退款，超过四小时无法退款。</span><br/>
		押金：${car.disposit }<br/>	
		<input type="submit" value="支付押金" />
		<hr>
	</form>
</body>
</html>

