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
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/user/authenticationAccount.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/jquery.fileupload.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/spinners.css" type="text/css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/user/authenticationAccount.js"></script>
    
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
            <div class="right-content right-float">
                <dl>
                    <table>
                        <dt class="content-title">实名认证 </dt>
                        <dd class="content-input-box">
                        	<c:choose>
                           		<c:when test="${userInfo.name == null }"> 
			                           <form method="post" onsubmit="return validateName();" action="${pageContext.request.contextPath }/user/saveInfoField">
			                           		<input type="hidden" name="token" value="${token}" />
				                        	<span class="content-text">姓名</span><!--
		                           			--><input class="content-input name" name="name" maxlength="10" placeholder="输入姓名"><!--
		                           			--><span class="content-error nameError"></span><!--
		                           			--><input type="submit" class="content-btn" value="保存">
                           			   </form>
                           		</c:when>
                           		<c:otherwise>
                           			<span class="content-text">姓名</span><!--
                           			--><span class="content-span">${userInfo.name }</span><!--
                           			--><span class="content-error"></span><!--
                           			--><a class="content-link" href="javascript:void(0)" onclick="openEditName();">修改</a>
                           		</c:otherwise>
                           	</c:choose>
                        </dd>
                        <dd class="content-input-box">
                       	   <c:choose>
                           		<c:when test="${userInfo.sex == null }"> 
			                           <form method="post" action="${pageContext.request.contextPath }/user/saveInfoField">
			                           		<input type="hidden" name="token" value="${token}" />
			                           		<span class="content-text">性别</span><!--
				                        	--><div class="content-input-radio"><input id="m-sex" type="radio" class="sex" name="sex" value="1" checked><label class="sex-text"  for="m-sex">&nbsp;男</label></div><!--
                            				--><div class="content-input-radio"><input id="fm-sex" type="radio" class="sex" name="sex" value="2"><label class="sex-text" for="fm-sex">&nbsp;女</label></div><!--
		                           			--><span class="content-error sexError"></span><!--
		                           			--><input type="submit" class="content-btn" value="保存">
                           			   </form>
                           		</c:when>
                           		<c:otherwise>
                           			<span class="content-text">性别</span><!--
                           			--><span class="content-span">
                           				<c:choose>
                           					<c:when test="${userInfo.sex == 1 }">男</c:when>
                           					<c:otherwise>女</c:otherwise>
                           				</c:choose>
                           			</span><!--
                           			--><span class="content-error sexError"></span><!--
                           			--><a class="content-link" href="javascript:void(0)" onclick="openEditSex();">修改</a>
                           		</c:otherwise>
                           	</c:choose>
                        </dd>
                        
                        <dd class="content-input-box">
                        	<c:choose>
                           		<c:when test="${userInfo.idcard == null }"> 
			                           <form method="post" onsubmit="return validateIdCard();"  action="${pageContext.request.contextPath }/user/saveInfoField">
			                           		<input type="hidden" name="token" value="${token}" />
				                        	<span class="content-text">身份证号码</span><!--
		                           			--><input class="content-input idcard" name="idcard" maxlength="18" placeholder="输入身份证号码"><!--
		                           			--><span class="content-error idcardError"></span><!--
		                           			--><input type="submit" class="content-btn" value="保存">
                           			   </form>
                           		</c:when>
                           		<c:otherwise>
                           			<span class="content-text">身份证号码</span><!--
                           			--><span class="content-span">${userInfo.idcard }</span><!--
                           			--><span class="content-error"></span><!--
                           			--><a class="content-link" href="javascript:void(0)" onclick="openEditIdCard();">修改</a>
                           		</c:otherwise>
                           	</c:choose>
                        </dd>
                    </table>
                </dl>
            </div>
            
            <!-- 右边内容 -->
            <div class="right-content right-content-second right-float">
                <dl>
                    <table>
                        <dt class="content-title">证件上传<span class="red-text size14">（支持jpg/jpeg/bmp/png/gif格式，不大于2m的图片）</span></dt>
                        <form id="uploadForm"></form>
                        <dd class="content-input-box">
                            <span class="content-text">身份证正面</span><!-- 
                             --><div class="preview-box">
		                             <c:choose>
		                             	<c:when test="${userInfo.idcardphoto == null }">
		                             		<img id="preview" class="preview" src="${pageContext.request.contextPath }/images/common/blank.png" />
		                             	</c:when>
		                             	<c:otherwise>
		                             		<img id="preview" class="preview" src="${pageContext.request.contextPath }/uploads/${userInfo.idcardphoto}" />
		                             	</c:otherwise>
		                             </c:choose>
                             	<span class="spinner-loader"></span></div><!--
                             --><span class="content-error"></span><!--
                             --><span class="content-blank"></span><!--
                             --><span class="fileinput-button">
							        上传<input type="file" name="idcardPhoto" onchange="imgUploadAndPreview(this)" />
							    </span><!--
                             --><!-- <a class="content-link" href="javascript:void(0)" onclick="openEditName();">修改</a> -->
                            <!--<a class="content-link" href="#">保存</a>-->
                        </dd>
                        
                        <dd class="content-input-box">
                            <span class="content-text">驾驶证正面</span><!--
                            --><div class="preview-box">
                            <c:choose>
                             	<c:when test="${userInfo.licencephoto == null }">
                             		<img id="preview" class="preview" src="${pageContext.request.contextPath }/images/common/blank.png" />
                             	</c:when>
                             	<c:otherwise>
                             		<img id="preview" class="preview" src="${pageContext.request.contextPath }/uploads/${userInfo.licencephoto}" />
                             	</c:otherwise>
                             </c:choose>
                            <span class="spinner-loader"></span></div><!--
                             --><span class="content-error"></span><!--
                             --><span class="content-blank"></span><!--
                             --><span class="fileinput-button">
							        上传<input type="file" name="licencePhoto" onchange="imgUploadAndPreview(this)" />
							    </span><!--
                             --><!-- <a class="content-link" href="javascript:void(0)" onclick="openEditName();">修改</a> -->
                            <!--<a class="content-link" href="#">保存</a>-->
                        </dd>
                        <dd class="content-input-box">
                            <span class="content-text">驾驶证副页</span><!--
                            --><div class="preview-box">
                            <c:choose>
                             	<c:when test="${userInfo.licencevicephoto == null }">
                             		<img id="preview" class="preview" src="${pageContext.request.contextPath }/images/common/blank.png" />
                             	</c:when>
                             	<c:otherwise>
                             		<img id="preview" class="preview" src="${pageContext.request.contextPath }/uploads/${userInfo.licencevicephoto}" />
                             	</c:otherwise>
                             </c:choose>
							<span class="spinner-loader"></span></div><!--
                             --><span class="content-error"></span><!--
                             --><span class="content-blank"></span><!--
                             --><span class="fileinput-button">
							        <span>上传</span><input type="file" name="licenceVicePhoto" onchange="imgUploadAndPreview(this)" />
							    </span><!--
                             --><!-- <a class="content-link" href="javascript:void(0)" onclick="openEditName();">修改</a> -->
                            <!--<a class="content-link" href="#">保存</a>-->
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
	    $(".auth-text").addClass("active");
	});
	
	/**
	 * 姓名校验
	 */
	function validateName() {
		var name = $.trim($(".name").val());
		// 姓名是否为空
		if (name == "") {
			$(".nameError").text("姓名为空");
			return false;
		} else {
			$(".nameError").text("");
		}
		
		// 姓名格式判断
		var reg =  /^[\u4E00-\u9FA5A-Za-z]+$/;
		if (!reg.test(name)) {
			$(".nameError").text("姓名格式不正确");
			return false;
		} else {
			$(".nameError").text("");
		}
	}
	
	/**
	 * 校验身份证号码
	 */
	function validateIdCard() {
		var idcard = $.trim($(".idcard").val());
		// 身份证是否为空
		if (idcard == "") {
			$(".idcardError").text("身份证为空");
			return false;
		} else {
			$(".idcardError").text("");
		}
		
		// 身份证号码格式判断
		var reg = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
		if (!reg.test(idcard)) {
			$(".idcardError").text("身份证号码格式不正确");
			return false;
		} else {
			$(".idcardError").text("");
		}
		
		var flag = false;
		
		// 异步校验身份证号码是否存在
	    $.ajax({
			type: "POST",
			url: "${pageContext.request.contextPath }/user/fieldValidate",
			async: false,
			data: {
				"idcard": idcard
			},
			success: function(result) {
				if (result == null) {
					// 身份证可以用
					$(".idcardError").text("");
					flag = true;
				} else {
					// 身份证号码已经存在
					$(".idcardError").text("身份证号码已经存在");
					flag = false;
				}
			}
		});
		
		return flag;
	}
	
	/**
	 * 打开修改姓名框
	 */
	function openEditName() {
	    // 修改姓名
	    layer.open({
	        title: '修改姓名',
	        type: 1,
	        closeBtn: 1,  // 调试用
	        area: ['480px', '220px'], //宽高
	        content: '<form method="post" onsubmit="return validateName();" action="${pageContext.request.contextPath }/user/saveInfoField">' +
	        '<input type="hidden" name="token" value="${token}" />' +
	        '<div class="dialog-content">' +
	        '<span class="dialog-span">新姓名</span>' +
	        '<input class="dialog-input name" name="name" placeholder="请输入姓名"><br/>' +
	        '<span class="red-text dialog-error nameError"></span><br/>' +
	        '<input class="dialog-btn" type="submit" value="修改">' +
	        '</div>' + 
	        '</form>'
	    });
	}
	
	/**
	 * 打开修改性别框
	 */
	function openEditSex() {
	    // 修改性别
	    layer.open({
	        title: '修改性别',
	        type: 1,
	        closeBtn: 1,  // 调试用
	        area: ['480px', '220px'], //宽高
	        content: '<form method="post" action="${pageContext.request.contextPath }/user/saveInfoField">' +
	        '<input type="hidden" name="token" value="${token}" />' +
	        '<div class="dialog-content">' +
	        '<span class="dialog-span">新性别</span>' +
	        '<div class="dialog-input-radio"><input id="m-sex" type="radio" class="sex" name="sex" value="1" checked><label class="sex-text"  for="m-sex">&nbsp;男</label></div>' +
			'<div class="dialog-input-radio"><input id="fm-sex" type="radio" class="sex" name="sex" value="2"><label class="sex-text" for="fm-sex">&nbsp;女</label></div>' +
	        '<span class="red-text dialog-error nameError"></span><br/>' +
	        '<input class="dialog-btn" type="submit" value="修改">' +
	        '</div>' + 
	        '</form>'
	    });
	}
	
	/**
	 * 打开修改身份证号码框
	 */
	function openEditIdCard() {
	    // 修改姓名
	    layer.open({
	        title: '修改身份证号码',
	        type: 1,
	        closeBtn: 1,  // 调试用
	        area: ['480px', '220px'], //宽高
	        content: '<form method="post" onsubmit="return validateIdCard();" action="${pageContext.request.contextPath }/user/saveInfoField">' +
	        '<input type="hidden" name="token" value="${token}" />' +
	        '<div class="dialog-content">' +
	        '<span class="dialog-span">新身份证号码</span>' +
	        '<input class="dialog-input idcard" name="idcard" placeholder="请输入身份证号码"><br/>' +
	        '<span class="red-text dialog-error idcardError"></span><br/>' +
	        '<input class="dialog-btn" type="submit" value="修改">' +
	        '</div>' + 
	        '</form>'
	    });
	}
	
	// 图片上传和预览
	function imgUploadAndPreview(inputBtn){
		var errorSpan = $(inputBtn).parent().parent().find("span").get(2);
        // 判断图片格式
		var photoPath = $(inputBtn).val();
		var photoSuffix = photoPath.substring(photoPath.lastIndexOf(".") + 1).toLowerCase();
		if (photoSuffix != "jpg" && photoSuffix != "jpeg" && photoSuffix != "bmp" && 
			photoSuffix != "gif" && photoSuffix != "png" ) {
			$(errorSpan).text("格式错误");
			return;
		} else {
			$(errorSpan).text("");
		}
		// 判断图片大小
		var photoSize = $(inputBtn).get(0).files[0].size / 1024;  // kb
		if (photoSize >= 2048) {
			$(errorSpan).text("大小超过2m");
			return;			
		} else {
			$(errorSpan).text();
		}
		//判断是否支持FileReader
        if (window.FileReader) {
            var reader = new FileReader();
        } else {
            alert("您的设备不支持图片上传和预览功能，请更新您的设备！");
            return;
        }
		
        var imgDiv = $(inputBtn).parent().parent().find("div").get(0);  // 存放图片的div  
        var img = $(imgDiv).find("img").get(0);  // 图片
		var loading = $(imgDiv).find("span").get(0);  // 缓冲动画
		
		// 异步上传
		var formData = new FormData($("#uploadForm"));
		formData.append("photo", $(inputBtn).get(0).files[0]);
		formData.append("photoName", $(inputBtn).attr("name"));
         	
		$.ajax({
			type: "POST",
			url: "${pageContext.request.contextPath }/user/uploadPhoto",
			async: true,
			data: formData,
			contentType: false,
            processData: false,
            beforeSend: function() {
            	// 缓冲
         		$(loading).css("display", "inline-block");
            },
			success: function(result) {
				//读取完成
		        reader.readAsDataURL(inputBtn.files[0]);
		        reader.onload = function(e) {
		            //图片路径设置为读取的图片
		            $(img).attr("src",e.target.result);
		         	// 结束缓冲
		        };
				$(loading).css("display", "none");
				//提示层
				layer.msg("上传成功");
			}
		});
    }
	</script>
</body>
</html>
