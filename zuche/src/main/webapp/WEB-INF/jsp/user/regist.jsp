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
    <title>注册页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/bootstrap.min.css" type="text/css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap-theme.min.css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user/regist.css" type="text/css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.min.js"></script>
</head>

<body>
<!--头部-->
<jsp:include page="../common/public-header.jsp"></jsp:include>

<div class="main-content">
    <div class="registBox">
        <form action="${pageContext.request.contextPath }/user/regist" class="form-horizontal" method="post">
            <div class="heading">用户注册</div>
            <input type="hidden" name="token" value="${token}" />
            <div>
                <div class="form-group">
                    <input type="text" class="form-control phone" name="phone" oninput="judgePhone();" placeholder="手机号" maxlength="11"><!--
                     --><button class="btn btn-info vCodeBtn" type="button" disabled="disabled" onclick="sendVCode();">发送验证码</button>
                    <span class="phoneError"></span>
                </div>

                <div class="form-group help">
                    <input class="form-control vCode" name="vCode" placeholder="验证码" maxlength="6">
                    <span class="vCodeError"></span>
                    <span class="registError">${registError }</span>
                </div>
            </div>

            <div class="form-group help">
                <input type="password" class="form-control password" readonly="readonly" oninput="judgePassword();" name="password" placeholder="3-12位的密码" maxlength="12">
                <span class="passwordError"></span>
            </div>

            <div class="form-group">
                <input type="submit" class="registBtn" disabled="disabled" value="注册" />
                <a class="loginLink" href="${pageContext.request.contextPath }/user/toLogin"><span>已有账号？前往</span>登录</a>
            </div>
        </form>
    </div>
</div>
<!--尾部-->
<jsp:include page="../common/public-footer.jsp"></jsp:include>

<script type="text/javascript">
	// 判断是否是电话
	function judgePhone() {
		var reg = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
		if (reg.test($(".phone").val())) {
			$(".vCodeBtn").removeAttr("disabled");
		} else {
			$(".vCodeBtn").attr("disabled","disabled");
		}
	}
	
	// 判断密码是否合法
	function judgePassword() {
		var password = $(".password").val();
		if (password.length >= 3 && password.length <= 12) {
			$(".registBtn").css("opacity", "1");
			$(".registBtn").removeAttr("disabled");
			$(".registBtn").mouseover(function() {
				$(".registBtn").css("background", "#FF8650");
			});
			$(".registBtn").mouseout(function() {
				$(".registBtn").css("background", "#F9CA34");
			});
		} else {
			$(".registBtn").css("opacity", "0.5");
			$(".registBtn").attr("disabled","disabled");
		}
	}
	
 	// 发送验证码
	function sendVCode() {
    	var phone = $(".phone").val();
   		var flag = false;
    	// 手机唯一性校验
		$.ajax({
			type: "POST",
			url: "${pageContext.request.contextPath }/user/fieldValidate",
			async: false,
			data: {
				"phone": phone
			},
			success: function(result) {
				if (result == null) {
					// 手机号可以用
					$(".phoneError").text("");
					flag = true;
				} else {
					// 手机号已经存在
					$(".phoneError").text("手机号已经存在");
					flag = false;
				}
			}
		});
    	
    	if (flag) {
    		$(".vCodeBtn").text("正在发送...");
    		$(".vCodeBtn").attr("disabled","disabled");
    		$.ajax({
    			type: "POST",
    			url: "${pageContext.request.contextPath }/utils/sendVCode",
    			async: false,
    			data: {
    				"phone": phone
    			},
    			success: function(result) {
    				alert("测试用验证码：" + result);
    				var vCode = result;
    				$(".vCode").bind("input", function() {
    					// 如果相同，那么按钮可点击
    					if (vCode == $(".vCode").val()) {
    						$(".password").removeAttr("readonly");
    						$(".vCode").attr("readonly","readonly");
    						$(".phone").attr("readonly","readonly");
    						$(".vCodeBtn").attr("disabled","disabled");
    					} else {
    						$(".password").attr("readonly","readonly");
    						$(".vCode").removeAttr("readonly");
    						$(".phone").removeAttr("readonly");
    						$(".vCodeBtn").removeAttr("disabled");
    					}
    				});
    			}
    		});
    		
    		// 倒计时
    		var num = 10;
    		var interval = setInterval(function() {
    			if (num == 0) {
    				clearInterval(interval);	
    				$(".vCodeBtn").removeAttr("disabled");
    				$(".vCodeBtn").text("发送验证码");
    			} else {
    				$(".vCodeBtn").text("重新发送(" + num-- + ")");
    			}
    		},1000);
    	}
	}
	</script>
</body>
</html>

