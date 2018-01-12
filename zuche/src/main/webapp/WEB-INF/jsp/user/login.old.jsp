<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>登陆页面</title>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" type="text/css">
<style type="text/css">
.loginBox {
	width: 450px;
	min-height: 420px;
	margin: 0 auto;
	margin-top: 130px;
}
.heading {
	text-align: center;
	font-size: 30px;
	font-weight: bold;
	margin-bottom: 20px;
	color: #28a3ff;
}
.username, .password, .loginBtn {
	width: 350px;
	height: 40px;
	margin: 0 auto;
	display: block;
}
.usernameError, .passwordError, .loginError {
	display: block;
	margin-left: 70px;
	color: red;
	font-size: 15px;
}
.loginBtn, .loginBtn:hover, .loginBtn:visited, .loginBtn:active {
	background: #4cd96f;
	border: 0;
	color: white;
	border-radius: 5px;
}
.registLink, .forgetLink {
	display: block;
	margin-top: 10px;
	color: #2395ff;
}
a:hover {
	text-decoration: none;
	color: #2395ff;
} 
.registLink {
	float: left;
	margin-left: 65px;
}
.forgetLink {
	float: right;
	margin-right: 65px;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
</head>

<body>
	<div class="container">
		<div class="loginBox">
			<form action="${pageContext.request.contextPath }/user/login" class="form-horizontal" onsubmit="return validate();" method="post">
				<div class="heading">用户登录</div>
				<div class="form-group">
					<input type="text" class="form-control username" name="username" placeholder="用户名/手机号/邮箱" maxlength="50"> 
					<span class="usernameError"></span>
				</div>

				<div class="form-group help">
					<input type="password" class="form-control password" name="password" placeholder="密码" maxlength="20"> 
					<span class="passwordError"></span>
					<span class="loginError">${loginError }</span>
				</div>
				<div class="form-group">
					<input type="submit" class="loginBtn" id="login" value="登录" /> 
					<a id="register" class="registLink" href="<%=basePath%>user/toRegist"><span>还没账号？</span>快速注册</a> 
					<a class="forgetLink" id="forgetPwd" href="<%=basePath%>user/toForgetPassword">忘记密码?</a>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
	// 登录前台校验
    function validate() {
    	var username = $(".username").val();
    	var password = $(".password").val();
    	// 用户名和密码非空校验
    	if (username == "") {
			$(".usernameError").text("用户名为空");    		
			return false;
    	} else {
    		$(".usernameError").text("");
    	}
    	if (password == "") {
			$(".passwordError").text("密码为空");    		
			return false;
    	} else {
    		$(".passwordError").text("");    
    	}
    	
    	// 判断用户输入内容是：用户名/手机号还是邮箱
    	if (!isNaN(username)) {
    		$(".username").attr("name", "phone"); // 手机号
    	}
    	else if (username.indexOf("@") != -1) {
    		$(".username").attr("name", "email"); // 邮箱
    	}
    	else {
    		$(".username").attr("name", "username"); // 用户名
    	}
    	return true;
	}
	</script>
</body>
</html>
