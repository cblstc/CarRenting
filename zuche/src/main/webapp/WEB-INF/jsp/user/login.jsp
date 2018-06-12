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
    <title>登录页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/bootstrap.min.css" type="text/css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap-theme.min.css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user/login.css" type="text/css">
    

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/layer/layer.js"></script>
    
</head>

<body>
<!--头部-->
<jsp:include page="../common/public-header.jsp"></jsp:include>

<div class="main-content">
    <div class="bg-img"></div>
    <div class="transparent"></div>
    <div class="loginBox">
        <form action="${pageContext.request.contextPath }/user/login" class="form-horizontal" onsubmit="return validate();" method="post">
        	<input type="hidden" name="token" value="${token}" />
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
                <a id="register" class="registLink" href="${pageContext.request.contextPath}/user/toRegist"><span>还没账号？</span>快速注册</a>
                <a class="forgetLink" id="forgetPwd" href="${pageContext.request.contextPath}/user/toForgetPassword">忘记密码?</a>
            </div>
        </form>
    </div>
</div>
<!--尾部-->
<jsp:include page="../common/public-footer.jsp"></jsp:include>

<script type="text/javascript">
	var flag = "${preLogin}";
	if (flag != null && flag != "") {
		layer.msg(flag, {
            icon: 3,
            time: 10000,
            offset: '60px'
        });
	}
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
