<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人中心首页</title>
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap-theme.min.css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/common.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/userLeftNav.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/userTopNav.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/user/index.css">

    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/userLeftNav.js"></script>
</head>
<body>
    <!--头部-->
	<jsp:include page="../common/public-header.jsp"></jsp:include>

    <!-- 用户中心头部 -->
	<jsp:include page="../common/userTopNav.jsp"></jsp:include>

    <div class="main-content">
        <div class="public-container clearfloat">
            <!-- 左边导航 -->
			<jsp:include page="../common/userLeftNav.jsp"></jsp:include>

            <!-- 右边内容 -->
            <div class="right-content left-float">
                <dl>
                    <dt class="content-title">首页
                    </dt>
                </dl>
                欢迎进入个人中心！
            </div>
        </div>
    </div>

    <!--尾部-->
	<jsp:include page="../common/public-footer.jsp"></jsp:include>


    <script>
        $(function () {
            $(".nav-text").removeClass("active");
        });
    </script>
</body>
</html>
