<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户中心左边导航栏</title>
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap-theme.min.css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/common.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/userLeftNav.css">

    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/userLeftNav.js"></script>
</head>
<body>
    <!-- 左边导航 -->
    <div class="left-nav left-float">
        <dl>
            <dt class="nav-title">我的订单</dt>
            <a href="${pageContext.request.contextPath }/user/toImproveAccount"><dd class="nav-text active">租车</dd></a>
            <dt class="nav-title">我的账户</dt>
            <a href="${pageContext.request.contextPath }/user/toImproveAccount"><dd class="nav-text improve-text">登录信息完善</dd></a>
            <a href="${pageContext.request.contextPath }/user/toAuthenticationAccount"><dd class="nav-text auth-text">身份认证</dd></a>
        </dl>
    </div>
    
    <script type="text/javascript">
    /**
     * 切换nav
     * @param link 链接
     */
    /* function changeNav(link) {
        var dd = $(link).find("dd").get(0);
        $(".nav-text").removeClass("active");
        $(dd).addClass("active"); // 点击变色
    } */
    </script>
</body>
</html>
