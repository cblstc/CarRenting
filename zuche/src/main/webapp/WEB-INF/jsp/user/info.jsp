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
	<h1>完善信息</h1>
	<form action="${pageContext.request.contextPath }/user/editInfo" method="post">
		<!-- 用户名：<input name="username" /><br/>
		邮箱：<input name="email" /><br/> -->
		姓名：<input name="name" /><br/>
		身份证号：<input name="idcard" maxlength="18" /><br/>
		性别：<input type="radio" name="sex" value="1" />男<input type="radio" name="sex" value="2" />女<br/>
		头像：<input name="photo" /><br/>
		身份证正面：<input type="file" name="idcardPhoto" /><br/>
		驾驶证正面：<input type="file" name="licencePhoto" /><br/>
		驾驶证副页：<input type="file" name="licenceVicePhoto" /><br/>
		<input type="submit" value="保存" />
	</form>
</body>
</html>

