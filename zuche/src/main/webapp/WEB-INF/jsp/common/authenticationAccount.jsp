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
    <title>实名认证</title>
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap-theme.min.css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/common.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/userTopNav.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/authenticationAccount.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/user/authenticationAccount.js"></script>
</head>
<body>
    <!--头部-->
    <div class="header-box"></div>
    <script>
        $(".header-box").load("../common/public-header.html");
    </script>

    <!-- 用户中心头部 -->
    <div class="top-box"></div>
    <script>
        $(".top-box").load("../common/userTopNav.html");
    </script>

    <div class="main-content">
        <div class="public-container clearfloat">
            <!-- 左边导航 -->
            <div class="left-box"></div>
            <script>
                $(".left-box").load("../common/userLeftNav.html");
            </script>
            <!-- 右边内容 -->
            <div class="right-content left-float">
                <dl>
                    <table>
                        <dt class="content-title">实名认证 </dt>
                        <dd class="content-input-box">
                            <span class="content-text">姓名</span><!--
                             --><input class="content-input" placeholder="请输入姓名"><!--
                             --><span class="content-error">姓名错误</span><!--
                             --><a class="content-link" href="javascript:void(0)" onclick="openEditName();">修改</a>
                            <!--<a class="content-link" href="#">保存</a>-->
                        </dd>
                        <dd class="content-input-box">
                            <span class="content-text">性别</span><!--
                             --><div class="content-input-radio"><input id="m-sex" type="radio" name="sex" checked><label class="sex-text"  for="m-sex">&nbsp;男</label></div><!--
                            --><div class="content-input-radio"><input id="fm-sex" type="radio" name="sex"><label class="sex-text" for="fm-sex">&nbsp;女</label></div><!--
                            --><span class="content-error">性别错误</span><!--
                             --><a class="content-link" href="javascript:void(0)" onclick="openEditSex();">修改</a>
                            <!--<a class="content-link" href="#">保存</a>-->
                        </dd>
                        <dd class="content-input-box">
                            <span class="content-text">身份证号码</span><!--
                             --><input class="content-input" placeholder="请输入身份证号码"><!--
                             --><span class="content-error">身份证号码格式错误</span><!--
                             --><a class="content-link" href="javascript:void(0)" onclick="openEditIdCard();">修改</a>
                            <!--<a class="content-link" href="#">保存</a>-->
                        </dd>
                    </table>
                </dl>
            </div>
            <!-- 右边内容 -->
            <div class="right-content right-content-second left-float">
                <dl>
                    <table>
                        <dt class="content-title">证件上传</dt>
                        <dd class="content-input-box">
                            <span class="content-text">身份证正面</span><!--
                             --><input class="content-input" placeholder="未完待续"><!--
                             --><span class="content-error">未完待续</span><!--
                             --><a class="content-link" href="javascript:void(0)" onclick="openEditName();">修改</a>
                            <!--<a class="content-link" href="#">保存</a>-->
                        </dd>
                        <dd class="content-input-box">
                            <span class="content-text">驾驶证正面</span><!--
                             --><input class="content-input" placeholder="未完待续"><!--
                             --><span class="content-error">未完待续</span><!--
                             --><a class="content-link" href="javascript:void(0)" onclick="openEditName();">修改</a>
                            <!--<a class="content-link" href="#">保存</a>-->
                        </dd>
                        <dd class="content-input-box">
                            <span class="content-text">驾驶证副页</span><!--
                             --><input class="content-input" placeholder="未完待续"><!--
                             --><span class="content-error">未完待续</span><!--
                             --><a class="content-link" href="javascript:void(0)" onclick="openEditName();">修改</a>
                            <!--<a class="content-link" href="#">保存</a>-->
                        </dd>
                    </table>
                </dl>
            </div>
        </div>
    </div>

    <!--尾部-->
    <div class="footer-box"></div>
    <script>
        $(".footer-box").load("../common/public-footer.html");
    </script>
</body>
</html>
