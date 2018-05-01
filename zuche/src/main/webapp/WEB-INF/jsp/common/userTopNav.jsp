<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人中心头部</title>
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap-theme.min.css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/common.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/userTopNav.css">

    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/userTopNav.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=HHNwksT3c9XuGE9iwPrL0LLgSF0KzQsg"></script>
</head>
<body>
    <div class="my-cargo">
        <div class="public-container clearfloat">
            <div class="my-cargo-logo-content left-float">
                <img class="my-cargo-logo" src="${pageContext.request.contextPath }/images/my-cargo-logo.png"><br/>
                <div class="weacher-content">
                    <span class="address-text">北京</span>
                    <span class="weather-text">晴</span>
                    <span class="temp-text">20°</span>
                </div>
            </div>
            <div class="user-img-box left-float">
                <img class="user-img" src="${pageContext.request.contextPath }/images/user/head-if-non.png">
            </div>
            <div class="user-desc left-float">
            	<c:choose>
            		<c:when test="${user.username != null }">
            			<div class="user-name">${user.username }</div>	
            		</c:when>
            		<c:otherwise>
            			<div class="user-name">${user.phone }</div>	
            		</c:otherwise>
            	</c:choose>
                <div class="renter-text">租友</div>
            </div>
            <div class="date-content left-float clearfloat">
                <div class="calender left-float">
                    <div class="month">1月</div>
                    <div class="day">1日</div>
                </div>
                <div class="current-time left-float">00:00:00</div>
            </div>
            <div class="regist-time-content left-float">
                <img class="regist-time-png" src="${pageContext.request.contextPath }/images/regist-time.png"><!--
                    --><div class="regist-time"><fmt:formatDate value="${user.registtime }" pattern="yyyy-MM-dd HH:mm:ss"/>加入</div>
            </div>
        </div>
    </div>
    
    <script type="text/javascript">
    $(function() {
    	weatherReport();
    });
    
    function weatherReport() {
    	
    	if (window.navigator.geolocation) {
    		// 如果浏览器支持html5定位，就定位
    		window.navigator.geolocation.getCurrentPosition(handleSuccess, handleError);
    	} else {
    		weatherReportByLocation("39.915,116.404");  // 北京天气
    	}
    	// 定位成功
    	function handleSuccess(position){
            // 获取到当前位置经纬度 
            var lng = position.coords.longitude;
            var lat = position.coords.latitude;
            var location = lat + "," + lng;
            weatherReportByLocation(location);
        }
    	// 定位失败
        function handleError(error){
        	weatherReportByLocation("39.915,116.404");  // 北京天气
        }
    }
    
    // 根据经纬度查询天气
    function weatherReportByLocation(location) {
    	// 根据经纬度得到天气信息
        $.ajax({
			type: "POST",
			url: "http://api.jisuapi.com/weather/query",
			async: false,
			dataType: "JSONP",
			data: {
				"appkey": "c625e563100c473b",
				"location": location
			},
			success: function(result) {
				$(".address-text").text(result.result.city);
				$(".weather-text").text(result.result.weather);
				$(".temp-text").text(result.result.temp + "°");
			}
		});
    }
    </script>
</body>
</html>
