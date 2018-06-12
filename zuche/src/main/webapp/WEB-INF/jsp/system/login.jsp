<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/system/login.css">
  <style>
    /* 需要校验的文本框 */
    /*#username, #password {
      position: relative;
    }*/
    /* 设置错误提示的样式和位置 */
    label.error {
      /*position: absolute;
      right: 60px;
      top: 10px;*/
      color: #ef392b;
      font-size: 14px;
    }
  </style>
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
  <section class="container">
    <div class="login">
      <h1>管理员登录</h1>
      <form id="login-form" method="post" action="${pageContext.request.contextPath }/system/login">
        <p><input id="username" required type="text" name="username" value="" placeholder="用户名"></p>
        <p><input id="password" required type="password" name="password" value="" placeholder="密码"></p>
        <span class="loginError" style="color: red; font-size: 14px;">${loginError }</span>
        <p class="submit"><input type="submit" name="commit" value="登录"></p>
      </form>
    </div>
  </section>

  <div style="text-align:center;">
    <p style="color: #f0f0f0;">版权所有：广东海洋大学软件学院</p>
  </div>

  <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery.validation/1.14.0/jquery.validate.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery.validation/1.14.0/validate-methods.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery.validation/1.14.0/messages_zh.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/layer/layer.js"></script>
  <script>
  var flag = "${preLogin}";
  if (flag != null && flag != "") {
  	layer.msg(flag, {
          icon: 3,
          time: 10000,
          offset: '10px'
      });
  }
    /* 表单校验 */
    $('#login-form').validate();
  </script>
</body>
</html>


