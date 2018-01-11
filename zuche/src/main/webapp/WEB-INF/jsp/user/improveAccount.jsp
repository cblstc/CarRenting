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
    <title>完善账户</title>
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap-theme.min.css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/common.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/improveAccount.css">

    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/layer/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/user/improveAccount.js"></script>
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
                    <table>
                        <dt class="content-title">账户信息 </dt>
                        <dd class="content-input-box">
                            <span class="content-text">用户名</span><!--
                           	<c:choose>
                           		<c:when test="${user.username == null }"> 
                           			--><input class="content-input username" name="username" maxlength="12" placeholder="请输入用户名"><!--
                           			--><span class="content-error"></span><!--
                           			--><a class="content-link" href="javascript:void(0)" onclick="saveUsername();">保存</a>
                           		</c:when>
                           		<c:otherwise>
                           			--><span class="content-span">${user.username }</span><!--
                           			--><span class="content-error"></span><!--
                           			--><a class="content-link" href="javascript:void(0)" onclick="openEditUsername();">修改</a>
                           		</c:otherwise>
                           	</c:choose>
                        </dd>
                        <dd class="content-input-box">
                            <span class="content-text">电话</span><!--
                            --><span class="content-span">${user.phone }</span><!--
                            --><span class="content-error"></span><!--
                            --><a class="content-link" href="javascript:void(0)" onclick="openEditPhone();">修改</a>
                        </dd>
                        <dd class="content-input-box">
                            <span class="content-text">邮箱</span><!--
                            <c:choose>
                           		<c:when test="${user.email == null }"> 
                           			--><input class="content-input" placeholder="请输入邮箱号"><!--
                           			--><span class="content-error"></span><!--
                           			--><a class="content-link" href="#">保存</a>
                           		</c:when>
                           		<c:otherwise>
                           			--><span class="content-span">${user.email }</span><!--
                           			--><span class="content-error"></span><!--
                            		--><a class="content-link" href="javascript:void(0)" onclick="openEditEmail();">修改</a>
                           		</c:otherwise>
                           	</c:choose>
                            
                        </dd>
                        <dd class="content-input-box">
                            <span class="content-text">密码</span><!--
                            --><span class="content-span">******</span><!--
                            --><span class="content-error"></span><!--
                            --><a class="content-link" href="javascript:void(0)" onclick="openEditPassword();">修改</a>
                        </dd>
                    </table>
                </dl>
            </div>
        </div>
    </div>

    <!--尾部-->
	<jsp:include page="../common/public-footer.jsp"></jsp:include>
	
	<script type="text/javascript">
	/**
	 * 保存用户名
	 */
	function saveUsername() {
		// 根据经纬度得到天气信息
	    $.ajax({
			type: "POST",
			url: "${pageContext.request.contextPath }/user/saveInfo",
			async: false,
			data: {
				"username": $(".username").val()
			},
			success: function(result) {
				alert(result.username);
			}
		});
	}
	</script>
</body>
</html>
