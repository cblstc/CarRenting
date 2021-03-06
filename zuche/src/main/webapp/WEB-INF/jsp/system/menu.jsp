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
    <title>系统后台菜单</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/themes/default/easyui.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/themes/icon.css" type="text/css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/common.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/easyui-loading.js"></script>
    <style>
        a {
            color: #0000FF;
        }
    </style>
</head>
<body>
    <div class="easyui-layout" style="width:100%;height:675px;margin:0 auto;">
        <div region="north" style="width:100%; height: 70px; background: #0089dc; border-bottom: 1px solid white; position: relative;">
            <a href="#"><img style="margin: 15px 10px 0 25px;" src="${pageContext.request.contextPath}/images/system/admin-logo.png"></a>
            <span style="color: #ffffff; font-size: 15px; position:absolute; right: 70px; top: 25px;">管理员：${adminUser.username }</span>
            <a href="${pageContext.request.contextPath}/system/logout"><span style="color: #ffffff; font-size: 15px; position:absolute; right: 25px; top: 25px;">退出</span></a>
        </div>
        <div region="south" style="width:100%; height: 50px; line-height: 50px; background: #0089dc; border-top: 1px solid white; color: white; text-align: center; font-size: 15px;">所有权：Cargo租车有限公司</div>
        <div class="easyui-accordion" region="west" split="true" title="功能" style="width:15%;">
            <div title="用户管理">
                <ul class="easyui-tree">
                    <li><a href="javascript:void(0)" onclick="addTab('用户列表','${pageContext.request.contextPath}/system/toUserList?pageNum=1')">用户列表</a></li>
                </ul>
            </div>
            <div title="门店管理">
                <ul class="easyui-tree">
                    <li><a href="javascript:void(0)" onclick="addTab('门店列表','${pageContext.request.contextPath}/system/toStoreList?pageNum=1')">门店列表</a></li>
                    <li><a href="javascript:void(0)" onclick="addTab('加盟列表','${pageContext.request.contextPath}/system/toJoinsList?pageNum=1')">加盟列表</a></li>
                </ul>
            </div>
        </div>
        <div id="content" region="center" style="">
            <div id="tt" class="easyui-tabs" style="width:100%;height:100%;">
                <div title="首页">
                	<div style="padding: 20px; font-size: 15px;">欢迎使用后台管理平台！</div>
                </div>
            </div>
        </div>
    </div>

    <script>
    function addTab(title, url){
        if ($('#tt').tabs('exists', title)){
            $('#tt').tabs('select', title);
        } else {
            var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
            $('#tt').tabs('add',{
                title:title,
                content:content,
                closable:true
            });
        }
    }
    </script>
</body>
</html>
