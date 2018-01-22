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
                           	<c:choose>
                           		<c:when test="${user.username == null }"> 
			                           <form method="post" onsubmit="return validateUsername();" action="${pageContext.request.contextPath }/user/saveField">
			                           		<input type="hidden" name="token" value="${token}" />
				                        	<span class="content-text">用户名</span><!--
		                           			--><input class="content-input username" name="username" maxlength="12" placeholder="6-12位，由字母/数字/下划线组成"><!--
		                           			--><span class="content-error usernameError"></span><!--
		                           			--><input type="submit" class="content-btn" value="保存">
                           			   </form>
                           		</c:when>
                           		<c:otherwise>
                           			<span class="content-text">用户名</span><!--
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
                            <c:choose>
                           		<c:when test="${user.email == null }"> 
	                           		<form method="post" onsubmit="return validateEmail();" action="${pageContext.request.contextPath }/user/saveField">
	                           			<input type="hidden" name="token" value="${token}" />
				                           <span class="content-text">邮箱</span><!--
	                           			--><input class="content-input email" name="email" placeholder="正确的邮箱格式"><!--
	                           			--><span class="content-error emailError"></span><!--
	                           			--><input type="submit" class="content-btn" value="保存">
	                           		</form>
                           		</c:when>
                           		<c:otherwise>
                           			<span class="content-text">邮箱</span><!--
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
	$(function () {
	    $(".nav-text").removeClass("active");
	    $(".improve-text").addClass("active");
	});
	
	/**
	 * 校验用户名
	 */
	function validateUsername() {
		var username = $.trim($(".username").val());
		// 用户名是否为空
		if (username == "") {
			$(".usernameError").text("用户名为空");
			return false;
		} else {
			$(".usernameError").text("");
		}
		
		// 格式判断
		var reg = /^[a-zA-Z0-9_]{6,12}$/;  // 6到12位：字母，数字，下划线
		if (!reg.test(username)) {
			$(".usernameError").text("用户名格式不正确");
			return false;
		} else {
			$(".usernameError").text("");
		}
		
		var flag = false;
		
		// 异步校验用户名是否存在
	    $.ajax({
			type: "POST",
			url: "${pageContext.request.contextPath }/user/fieldValidate",
			async: false,
			data: {
				"username": username
			},
			success: function(result) {
				if (result == null) {
					// 用户名可以用
					$(".usernameError").text("");
					flag = true;
				} else {
					// 用户名已经存在
					$(".usernameError").text("用户名已经存在");
					flag = false;
				}
			}
		});
		
		return flag;
	}
	
	/**
	 * 校验邮箱
	 */
	function validateEmail() {
		var email = $.trim($(".email").val());
		// 是否为空
		if (email == "") {
			$(".emailError").text("邮箱为空");
			return false;
		} else {
			$(".emailError").text("");
		}
		
		// 格式判断
		var reg = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;  // email
		if (!reg.test(email)) {
			$(".emailError").text("邮箱格式不正确");
			return false;
		} else {
			$(".emailError").text("");
		}
		
		var flag = false;
		// 异步校验用户名是否存在
	    $.ajax({
			type: "POST",
			url: "${pageContext.request.contextPath }/user/fieldValidate",
			async: false,
			data: {
				"email": email
			},
			success: function(result) {
				if (result == null) {
					// 邮箱可以用
					$(".emailError").text("");
					flag = true;
				} else {
					// 邮箱已经存在
					$(".emailError").text("邮箱已经存在");
					flag = false;
				}
			}
		});
		
		return flag;
	}
	
	// 发送验证码
	function sendVCode() {
    	var phone = $.trim($(".phone").val());
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
    		$(".vCode-btn").text("正在发送...");
    		$(".vCode-btn").attr("disabled","disabled");
    		$(".vCode-btn").css("opacity", "0.5");
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
    						$(".phone").attr("readonly","readonly");
    						$(".vCode-btn").attr("disabled","disabled");
    						$(".vCode-btn").css("opacity", "0.5");
   							$(".commit-btn").css("opacity", "1");
   							$(".commit-btn").removeAttr("disabled");
   							$(".commit-btn").mouseover(function() {
   								$(".commit-btn").css("background", "#FF8650");
   							});
   							$(".registBtn").mouseout(function() {
   								$(".commit-btn").css("background", "#F9CA34");
   							});
    					} else {
    						$(".phone").removeAttr("readonly");
    						$(".vCode-btn").removeAttr("disabled");
    						$(".vCode-btn").css("opacity", "1.0");
   							$(".commit-btn").css("opacity", "0.5");
   							$(".commit-btn").attr("disabled","disabled");
    					}
    				});
    			}
    		});
    		
    		// 倒计时
    		var num = 10;
    		var interval = setInterval(function() {
    			if (num == 0) {
    				clearInterval(interval);	
    				$(".vCode-btn").removeAttr("disabled");
    				$(".vCode-btn").css("opacity", "1.0");
    				$(".vCode-btn").text("发送验证码");
    			} else {
    				$(".vCode-btn").text("重新发送(" + num-- + ")");
    			}
    		},1000);
    	}
	}
	
	/**
	 * 校验密码
	 */
	function validatePassword() {
		var oldPassword = $.trim($(".oldPassword").val());
		var password = $.trim($(".password").val());
		// 是否为空
		if (oldPassword == "") {
			$(".oldPasswordError").text("旧密码为空");
			return false;
		} else {
			$(".oldPasswordError").text("");
		}
		// 是否为空
		if (password == "") {
			$(".passwordError").text("新密码为空");
			return false;
		} else {
			$(".passwordError").text("");
		}
		// 长度校验
		if (password.length < 3) {
			$(".passwordError").text("新密码长度小于3");
			return false;
		} else {
			$(".passwordError").text("");
		}
		
		var flag = false;
		// 异步校验旧密码是否相同
	    $.ajax({
			type: "POST",
			url: "${pageContext.request.contextPath }/user/fieldValidate",
			async: false,
			data: {
				"oldPassword": oldPassword
			},
			success: function(result) {
				if (result == "1") {
					// 旧密码相同
					$(".oldPasswordError").text("");
					flag = true;
				} else {
					// 旧密码不相同
					$(".oldPasswordError").text("旧密码错误");
					flag = false;
				}
			}
		});
		
		return flag;
	}
	
	/**
	 * 打开修改用户名框
	 */
	function openEditUsername() {
	    // 修改用户名
	    layer.open({
	        title: '修改用户名',
	        type: 1,
	        closeBtn: 1,  // 调试用
	        area: ['480px', '220px'], //宽高
	        content: '<form method="post" onsubmit="return validateUsername();" action="${pageContext.request.contextPath }/user/saveField">' +
	        '<input type="hidden" name="token" value="${token}" />' +
	        '<div class="dialog-content">' +
	        '<span class="dialog-span">新用户名</span>' +
	        '<input class="dialog-input username" name="username" placeholder="6-12位，由字母/数字/下划线组成"><br/>' +
	        '<span class="red-text dialog-error usernameError"></span><br/>' +
	        '<input class="dialog-btn" type="submit" value="修改">' +
	        '</div>' + 
	        '</form>'
	    });
	}
	
	/**
	 * 打开修改联系电话框
	 */
	function openEditPhone() {
	    // 修改联系电话
	    layer.open({
	        title: '修改联系电话',
	        type: 1,
	        closeBtn: 1,  // 调试用
	        area: ['480px', '280px'], //宽高
	        content: '<form method="post" action="${pageContext.request.contextPath }/user/saveField">' + 
	        '<input type="hidden" name="token" value="${token}" />' + 
	        '<div class="dialog-content">' +
	        '<span class="dialog-span">新手机号</span>' +
	        '<input class="dialog-input phone-input phone" name="phone" oninput="judgePhone();" maxlength="11" placeholder="请输入新的手机号">' +
	        '<button type="button" class="vCode-btn" disabled onclick="sendVCode();">发送验证码</button><br/>' +
	        '<span class="red-text dialog-error phoneError"></span><br/>' +
	        '<span class="dialog-span">验证码</span>' +
	        '<input class="dialog-input vCode" name="vCode" placeholder="请输入验证码">' +
	        '<span class="red-text dialog-error"></span><br/>' +
	        '<input class="dialog-btn commit-btn" disabled type="submit" value="修改">' +
	        '</div>'
	    });
	}
	
	// 判断是否是电话
	function judgePhone() {
		var reg = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
		if (reg.test($(".phone").val())) {
			$(".vCode-btn").removeAttr("disabled");
			$(".vCode-btn").css("opacity", "1.0");
		} else {
			$(".vCode-btn").attr("disabled","disabled");
			$(".vCode-btn").css("opacity", "0.5");
		}
	}
	
	/**
	 * 打开修改邮箱框
	 */
	function openEditEmail() {
	    // 修改邮箱
	    layer.open({
	        title: '修改邮箱',
	        type: 1,
	        closeBtn: 1,  // 调试用
	        area: ['480px', '220px'], //宽高
	        content: '<form method="post" onsubmit="return validateEmail();" action="${pageContext.request.contextPath }/user/saveField">' +
	        '<input type="hidden" name="token" value="${token}" />' +
	        '<div class="dialog-content">' +
	        '<span class="dialog-span">新邮箱</span>' +
	        '<input class="dialog-input email" name="email" placeholder="正确的邮箱格式"><br/>' +
	        '<span class="red-text dialog-error emailError"></span><br/>' +
	        '<input class="dialog-btn" type="submit" value="修改">' +
	        '</div>' +
	        '</form>'
	    });
	}
	
	/**
	 * 打开修改密码框
	 */
	function openEditPassword() {
	    // 修改密码
	    layer.open({
	        title: '修改密码',
	        type: 1,
	        closeBtn: 1,  // 调试用
	        area: ['480px', '280px'], //宽高
	        content: '<form method="post" onsubmit="return validatePassword();" action="${pageContext.request.contextPath }/user/saveField">' +
	        '<input type="hidden" name="token" value="${token}" />' + 
	        '<div class="dialog-content">' +
	        '<span class="dialog-span">旧密码</span>' +
	        '<input class="dialog-input oldPassword" type="password" placeholder="请输入旧的密码" name="oldPassword"><br/>' +
	        '<span class="red-text dialog-error oldPasswordError" ></span><br/>' +
	        '<span class="dialog-span">新密码</span>' +
	        '<input class="dialog-input password" type="password" placeholder="3-12位密码"  name="password" maxlength="12"><br/>' +
	        '<span class="red-text dialog-error passwordError"></span><br/>' +
	        '<input class="dialog-btn" type="submit" value="修改">' +
	        '</div>'
	    });
	}
	</script>
</body>
</html>
