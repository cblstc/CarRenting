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
    <title>门店地图</title>
    <%-- <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap-theme.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/jquery.raty.css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/common.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/carDetail.css"> --%>
</head>
  
  <body>
    <p class="store-name">${store.storename }</p>
    <div id="store-map" class="store-map"></div>
    <div class="store-desc">
        <dl>
            <dt class="store-title">门店地址：</dt>
            <dd class="store-content">${store.address }</dd>
            <dt class="store-title">门店详情：</dt>
            <dd class="store-content">${store.description }</dd>
            <dt class="store-title">交通指引：</dt>
            <dd class="store-content">${store.traffic }</dd>
            <dt class="store-title">营业时间：</dt>
            <dd class="store-content"><fmt:formatDate value="${store.starttime }" pattern="HH:mm"/>-<fmt:formatDate value="${store.endtime }" pattern="HH:mm"/></dd>
            <dt class="store-title">门店电话：</dt>
            <dd class="store-content">${store.phone }</dd>
            <dt class="store-title">客户评价：</dt>
            <dd class="store-content clearfloat"><div class="comment-star left-float"></div>&nbsp;<span class="avgStar orange-text">${store.avgstar }</span><a href="javascript:void(0)" onclick="showComment('store');" class="total-comment right-float">${store.totalcomment }条评论&gt;</a></dd>
        </dl>
    </div>
    
    <script type="text/javascript">
    $(function() {
        var storeMap = new BMap.Map("store-map");
        var storePoint = new BMap.Point("${store.longitude }", "${store.latitude}");  // 根据经纬度设置中心点
        storeMap.centerAndZoom(storePoint,12);  // 设置中心点和缩放级别，数字越大，显示的范围越小
        storeMap.enableScrollWheelZoom();  // 支持滚轮缩放
        storeMap.centerAndZoom(storePoint, 17);
        storeMap.addOverlay(new BMap.Marker(storePoint));    // 标注
        
        /* 显示评分的星星 */
        $('.comment-star').raty({
            starOn:'${pageContext.request.contextPath }/images/star-on.png',
            starOff:'${pageContext.request.contextPath }/images/star-off.png',
            halfShow: false,
            score: Math.round($(".avgStar").text()),
            readOnly: true
        });
    });
    </script>
  </body>
</html>
