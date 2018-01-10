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
	<h1>添加车辆</h1>
	<form action="${pageContext.request.contextPath }/user/saveCar/${method}" method="post">
		品牌：
		<select name="brandId">
			<option>-请选择-</option>
			<c:forEach var="brand" items="${brands }">
				<option value="${brand.id }">${brand.name }</option>
			</c:forEach>
		</select><br/>
		车型：
		<select name="modelId">
			<option>-请选择-</option>
			<c:forEach var="model" items="${models }">
				<option value="${model.id }">${model.name }</option>
			</c:forEach>
		</select><br/>
		配置：
		<select name="configurationId">
			<option>-请选择-</option>
			<c:forEach var="configuration" items="${configurations }">
				<option value="${configuration.id }">${configuration.name }</option>
			</c:forEach>
		</select><br/>
		车牌号：<input name="platenumber" value="粤D11111" /><br/>
		年份：<input name="year" value="2017" /><br/>
		车辆图片：<input type="file" name="carPhoto" /><br/>
		变速箱类型：
		<select name="gearbox">
			<option value="0">-请选择-</option>
			<option value="1" selected="selected">手动挡</option>
			<option value="2">自动挡</option>
		</select><br/>
		排量：<input name="displacement" value="10L" /><br/>
		导航仪：<input type="radio" name="navigator" value="1" checked="checked" />有<input type="radio" name="navigator" value="2" />无<br/>
		倒车雷达：<input type="radio" name="pdc" value="1" checked="checked" />有<input type="radio" name="pdc" value="2" />无<br/>
		驱动模式：
		<select name="drivenmode">
			<option value="0">-请选择-</option>
			<option value="1" selected="selected">前驱</option>
			<option value="2">后驱</option>
			<option value="2">四驱</option>
		</select><br/>
		驾驶里程：<input name="mileage" value="4000" /><br/>
		载客量：<input name="capacity" value="4" /><br/>
		油箱：<input name="fueltankage" value="40" /><br/>
		描述：<input name="description" value="好车" /><br/>
		日租价：<input name="price" value="200" /><br/>
		押金：<input name="disposit" value="100" /><br/>
		<input type="submit" value="保存" />
	</form>
</body>
</html>

