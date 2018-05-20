<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>车辆详情</title>
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap-theme.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/jquery.raty.css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/common.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/customer/carDetail.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=HHNwksT3c9XuGE9iwPrL0LLgSF0KzQsg"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.raty.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/carDetail.js"></script>
</head>
<body>
    <!--头部-->
	<jsp:include page="../common/public-header.jsp"></jsp:include>

    <div class="main-content">
        <div class="public-container clearfloat">
            <div class="car-desc-box left-float">
                <div class="car-title">${storeCar.model }/${storeCar.displacement }/${storeCar.seats }人</div>
                <div class="car-img-box">
                <c:if test="${storeCar.carphoto != null }">
                    <img class="car-img-big" src="${pageContext.request.contextPath}/uploads/${fn:split(storeCar.carphoto, ';')[0]}">
                    <ul class="clearfloat car-img-small-box">
                    <c:forEach items="${fn:split(storeCar.carphoto, ';')}" var="carphoto">
                        <li class="left-float"><a href="javascript:void(0)" onclick="changeCarImg(this);"><img class="car-img-small" src="${pageContext.request.contextPath}/uploads/${carphoto}"></a></li>
                    </c:forEach>
                    </ul>
                </c:if>
                <c:if test="${storeCar.carphoto == null }">
                	<img class="car-img-big" src="${pageContext.request.contextPath}/images/non-car.png">
                </c:if>
                </div>
                <div class="car-base-info-box">
                    <dl>
                        <dt class="base-info-title">${storeCar.model }租车基本信息</dt>
                        <dd class="base-info-content">
                            <table class="base-info-content-box">
                                <tr>
                                    <td><img src="${pageContext.request.contextPath}/images/car-conf/brand.png"> 品牌：${storeCar.brand }</td>
                                    <td><img src="${pageContext.request.contextPath}/images/car-conf/model.png"> 车系：${storeCar.model }</td>
                                </tr>
                                <tr>
                                    <td><img src="${pageContext.request.contextPath}/images/car-conf/year.png"> 年代：${fn:substring(storeCar.configuration, 0, 5) }</td>
                                    <td><img src="${pageContext.request.contextPath}/images/car-conf/conf.png"> 配置：${storeCar.configuration }</td>
                                </tr>
                            </table>
                        </dd>
                    </dl>
                </div>
                <div class="car-base-info-box">
                    <dl>
                        <dt class="base-info-title">别克英朗租车配置信息</dt>
                        <dd class="base-info-content">
                            <table class="base-info-content-box">
                                <tr>
                                    <td><img src="${pageContext.request.contextPath}/images/car-conf/seat.png"> 座位数：${storeCar.seats }</td>
                                    <td><img src="${pageContext.request.contextPath}/images/car-conf/door.png"> 车门数：${storeCar.doors }</td>
                                </tr>
                                <tr>
                                    <td><img src="${pageContext.request.contextPath}/images/car-conf/displacement.png"> 排量：${storeCar.displacement }</td>
                                    <td><img src="${pageContext.request.contextPath}/images/car-conf/navigator.png"> 导航仪：<!-- 
                                    --><c:if test="${storeCar.navigator == 1 }">有</c:if><c:if test="${storeCar.navigator == 2 }">无</c:if></td>
                                </tr>
                                <tr>
                                    <td><img src="${pageContext.request.contextPath}/images/car-conf/pdc.png"> 倒车雷达：<c:if test="${storeCar.pdc == 1 }">有</c:if><c:if test="${storeCar.pdc == 2 }">无</c:if></td>
                                    <td><img src="${pageContext.request.contextPath}/images/car-conf/driven.png"> 驱动模式：<c:if test="${storeCar.drivenmode == 1 }">前驱</c:if><!-- 
                                     --><c:if test="${storeCar.drivenmode == 2 }">后驱</c:if><c:if test="${storeCar.drivenmode == 3 }">四驱</c:if></td>
                                </tr>
                                <tr>
                                    <td><img src="${pageContext.request.contextPath}/images/car-conf/navigator.png"> 油箱：${storeCar.fueltankage }L</td>
                                    <td><img src="${pageContext.request.contextPath}/images/car-conf/gear.png"> 变速箱：<c:if test="${storeCar.gearbox == 1 }">手动</c:if><!-- 
                                     --><c:if test="${storeCar.gearbox == 2 }">后驱</c:if></td>
                                </tr>
                                <tr>
                                    <td><img src="${pageContext.request.contextPath}/images/car-conf/sky.png"> 天窗：<c:if test="${storeCar.skylight == 1 }">有</c:if><!-- 
                                     --><c:if test="${storeCar.skylight == 2 }">无</c:if></td>
                                    <td><img src="${pageContext.request.contextPath}/images/car-conf/cell.png"> 安全气囊：${storeCar.aircell }</td>
                                </tr>
                            </table>
                        </dd>
                    </dl>
                </div>
                <div class="order-btn-box">
                    <button class="order-btn" onclick="location.href='${pageContext.request.contextPath}/toOrderPreview?id=${storeCar.id}'">立刻预定</button>
                </div>
            </div>
            <div class="car-store left-float">
            	<!--门店地图-->
				<jsp:include page="../common/storeMap.jsp"></jsp:include>
            </div>
        </div>
    </div>

    <!--尾部-->
	<jsp:include page="../common/public-footer.jsp"></jsp:include>

    <script>
        // 星星
        $('.comment-star').raty({
            starOn:'${pageContext.request.contextPath}/images/star-on.png',
            starOff:'${pageContext.request.contextPath}/images/star-off.png',
            halfShow: false,
            score:3,
            readOnly: true,
        });

    </script>
</body>
</html>
