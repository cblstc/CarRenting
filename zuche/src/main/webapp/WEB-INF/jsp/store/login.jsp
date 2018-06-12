<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link href="${pageContext.request.contextPath }/jsp/store/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/jsp/store/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/jsp/store/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/jsp/store/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
	<style>
/* 需要校验的文本框 */
#username, #password {
	position: relative;
}
/* 设置错误提示的样式和位置 */
label.error {
	position: absolute;
	right: 60px;
	top: 10px;
	color: #ef392b;
	font-size: 14px;
}
	</style>
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script><![endif]-->
<title>后台登录</title>
</head>
<body>
<div class="header"></div>
<div class="loginWraper">
	<div id="loginform" class="loginBox">
		<form id="login-form" class="form form-horizontal" action="${pageContext.request.contextPath }/store/login" method="post">
		<input type="hidden" name="token" value="${token}" />
			<div class="row cl">
				<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
				<div class="formControls col-xs-8">
					<input id="username" name="username" type="text" placeholder="账户" required class="input-text size-L">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
				<div class="formControls col-xs-8">
					<input id="password" name="password" type="password" placeholder="密码" required class="input-text size-L">
					<br/><span class="loginError" style="color: red; font-size: 14px;">${loginError }</span>
				</div>
			</div>
			<div class="row cl">
				<div class="formControls col-xs-8 col-xs-offset-3">
					<input type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
				</div>
			</div>
		</form>
	</div>
</div>
<div class="footer">Copyright 广东海洋大学软件学院所有</div>

<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/layer/layer.js"></script>
<script>
/*var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();*/
var flag = "${preLogin}";
if (flag != null && flag != "") {
	layer.msg(flag, {
        icon: 3,
        time: 10000,
        offset: '60px'
    });
}


/* 校验表单 */
$('#login-form').validate({});
</script>
</body>
</html>
