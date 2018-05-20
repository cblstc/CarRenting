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
    <title>订单预览</title>
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap-theme.min.css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/common.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/customer/orderPreview.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/customer/orderPreview.js"></script>
</head>
<body>
    <div class="header-box"></div>
     <!--头部-->
     <jsp:include page="../common/public-header.jsp"></jsp:include>

    <div class="main-content">
        <div class="public-container car-container">
            <div class="car-content clearfloat">
                <img class="car-img left-float" src="${pageContext.request.contextPath }/images/car-1.jpg">
                <div class="car-desc-box left-float">
                    <dl>
                        <dt class="car-name">${storeCar.model }</dt>
                        <dd class="car-desc">${storeCar.displacement }|${storeCar.seats }人|${storeCar.brand }人</dd>
                        <dd><button class="conf-btn" onclick="javascript: window.open('carDetail.html');">查看配置信息</button></dd>
                    </dl>
                </div>
                <div class="date-address-box left-float">
                    <div class="date-address-title date-address-common clearfloat">
                        <img class="icon-common left-float" src="${pageContext.request.contextPath }/images/date-address/get-car.png"> <p class="text-common title-text left-float">取车</p><br>
                    </div>
                    <div class="date-text date-address-common clearfloat">
                        <img class="icon-common left-float" src="${pageContext.request.contextPath }/images/date-address/date.png"> <p class="text-common left-float">${getDate }</p><br>
                    </div>
                    <div class="address-text date-address-common clearfloat">
                        <img class="icon-common left-float" src="${pageContext.request.contextPath }/images/date-address/address.png"> <p class="text-common left-float">${store.storename }</p>
                    </div>
                </div>
                <div class="date-address-box left-float">
                    <div class="date-address-title date-address-common clearfloat">
                        <img class="icon-common left-float" src="${pageContext.request.contextPath }/images/date-address/return-car.png"> <p class="text-common title-text left-float">还车</p><br>
                    </div>
                    <div class="date-text date-address-common clearfloat">
                        <img class="icon-common left-float" src="${pageContext.request.contextPath }/images/date-address/date.png"> <p class="text-common left-float">${returnDate }</p><br>
                    </div>
                    <div class="address-text date-address-common clearfloat">
                        <img class="icon-common left-float" src="${pageContext.request.contextPath }/images/date-address/address.png"> <p class="text-common left-float">${store.storename }</p>
                    </div>
                </div>
            </div>

            <div class="price-content">
                <dl>
                    <dt class="price-title">费用明细</dt>
                    <dd class="price-text clearfloat"><p class="left-float">车辆租赁费</p><p id="sub-price" class="sub-price right-float">&yen;${storeCar.price * rentdays }</p><p class="calc-price right-float">${storeCar.price }x${rentdays }</p></dd>
                    <dd class="price-text clearfloat"><p class="left-float">基本保险费</p><p id="sub-insurance" class="sub-price right-float">&yen;${storeCar.insurance * rentdays }</p><p class="calc-price right-float">${storeCar.insurance }x${rentdays }</p></dd>
                    <dd class="price-text clearfloat"><p class="left-float"><label for="nodebuct" class="nodebuct-label">不计免赔险（非强制性）</label><input id="nodebuct" type="checkbox" onclick="calcTotal();"></p><p id="sub-nodebuct" class="sub-price right-float">&yen;${storeCar.nodeductibles * rentdays }</p><p class="calc-price right-float">${storeCar.nodeductibles }x${rentdays }</p></dd>
                    <form id="orderForm" action="${pageContext.request.contextPath }/order/generateOrder" method="post">
                    	<input type="hidden" class="storeCarId" name="storeCarId" value="${storeCar.id }">
	                	<input type="hidden" class="price" name="price" value="">
	                	<input type="hidden" class="insurance" name="insurance" value="">
	                	<input type="hidden" class="nodeductibles" name="nodeductibles" value="">
	                	<input type="hidden" class="totalmoney" name="totalmoney" value="">
                    	<dd class="total-text clearfloat"><p class="left-float">合计<span id="total-money" class="real-money">&yen;${storeCar.price * rentdays + storeCar.insurance * rentdays }</span></p> <button class="submit-btn right-float" onclick="submitOrder();">提交订单</button></dd>
                	</form>
                </dl>
            </div>

            <div class="caution-content">
                <div class="caution-title">常见问题</div>
                <dl>
                    <dt>租车费用包括什么？</dt>
                    <dd>租车费用包括车辆租赁费、基本保险费、不计免赔险、手续费。其中不计免赔险是不强制性的。</dd><br/>
                    <dt>为什么一定要交基本保险费？</dt>
                    <dd>基本保险费为强制性费用，如车辆租赁期间出险，保险理赔范围内的损失，客户仅需承担1500元以内的车辆损失部分，不用承担其他损失。<br/>
                        承保范围：车辆损失险（1500元以内的损失由客户方承担）；第三者责任险 20万元；车上人员责任险（驾驶员）5万元；全车盗抢险；玻璃单独爆裂险；自燃损失险。
                        本服务按天计费，超时4小时以上按1天计费，超时4小时以内不另计费。</dd><br/>
                    <dt>不计免赔险有什么用？</dt>
                    <dd>不计免赔险是不强制性的。不计免赔险就是对你商业险中的车损，三责，座位，
                        盗抢险这些险种的完善，也就是说，如果车有什么事故的话，
                        不计免赔是100%包赔，假如你的车坏了，需要去修，
                        那你直接开到修理厂去修，到时候拿着发票去给保险公司，
                        你自己不会花一分钱的，如果没有这个不计免赔的话，
                        保险公司只会给你拿一部分，剩下的就只有你自己拿了
                        ，总之，有这个不计免赔，对客户自身是有好处的。为了您的利益，还是非常建议购买的。</dd><br/>
                </dl>
            </div>
        </div>
    </div>


    <!--尾部-->
     <jsp:include page="../common/public-footer.jsp"></jsp:include>


    <script>
        $(function() {
           calcTotal();
        });

        /* 计算合计 */
        function calcTotal() {
            var subPrice = parseInt($("#sub-price").text().replace(/¥/, "")); // 车辆租赁费/天
            var subInsurant = parseInt($("#sub-insurance").text().replace(/¥/, ""));  // 基本保险费/天
            var subNodebuct = 0;  // 不计免赔险

            var isChecked = $("#nodebuct").prop("checked");  // 不计免赔是否选中
            if (isChecked) {
                subNodebuct = parseInt($("#sub-nodebuct").text().replace(/¥/, ""));  // 不计免赔险
            }
            

            var total = subPrice + subInsurant + subNodebuct;  // 合计
            // 给表单赋值
            $(".price").val(subPrice);
        	$(".insurance").val(subInsurant);
        	$(".nodeductibles").val(subNodebuct);
        	$(".totalmoney").val(total);
        	
            $("#total-money").text("¥" + total);
        }
    </script>
</body>
</html>
