<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="_meta.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/store/css/bootstrap-datetimepicker.min.css" />

<title>门店信息</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-store-info" target="_parent"
		  method="post" action="${pageContext.request.contextPath }/store/saveStoreInfo">
		  <input type="hidden" value="${store.id }" name="id"/>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>门店名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text storename" required minlength="3" value="${store.storename }" name="storename" maxlength="50" placeholder="请输入门店名称，3-50个字符">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>联系电话：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text phone" required value="${store.phone }" name="phone" maxlength="50" placeholder="请输入联系电话，不超过50个字符">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>开店时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="time" class="input-text starttime" required value="<fmt:formatDate value="${store.starttime }" pattern="HH:mm"/>" name="startTime">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>关店时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="time" class="input-text endtime" required value="<fmt:formatDate value="${store.endtime }" pattern="HH:mm"/>" name="endTime">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text address" required value="${store.address }" name="address" maxlength="100" placeholder="请输入地址，不超过100个字符">
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>经度：</label>
			<a href="javascript:void(0)" onclick="openMap($('.address').val());">地图</a>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text longitude" required readonly value="${store.longitude }" name="longitude" placeholder="请在地图上选点">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>纬度：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text latitude" required readonly value="${store.latitude }" name="latitude" placeholder="请在地图上选点">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">门店简介：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea class="textarea description" name="description" maxlength="200" placeholder="门店简介，不超过200个字符" dragonfly="true"
						  onKeyUp="showCurrentLength(this)">${store.description }</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">交通指引：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea class="textarea traffic" name="traffic" maxlength="200" placeholder="交通指引，不超过200个字符" dragonfly="true"
						  onKeyUp="showCurrentLength(this)">${store.traffic }</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
            </div>
		</div>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<jsp:include page="_footer.jsp"></jsp:include>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/js/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript">
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });
        var ue = UE.getEditor('editor');

        $("#form-store-info").validate({
			/*rules: {
                storename: "required"
			},
			messages: {
			    storename: "请输入。。。"
			}*/
		});  // 校验表单
    });

    /* 显示当前字符长度 */
    function showCurrentLength(item) {
        var currentLength = $(item).val().length;
        var next = $(item).next();
        $($(next).find("em").get(0)).text(currentLength);
	}

</script>

<link href="${pageContext.request.contextPath }/jsp/store/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/jsp/store/css/showMap.css" rel="stylesheet">
<!-- 百度地图api引入 -->
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=HHNwksT3c9XuGE9iwPrL0LLgSF0KzQsg"></script>
<script>
    // 打开百度地图
    function openMap(address) {
        var longitude = null; // 经度
        var latitude = null;  // 纬度
        // 弹出地图框
        layer.open({
            title: '地址选择',
            type: 1,
            closeBtn: 1,  // 调试用
            area: ['650px', '550px'], //宽高
            content: '<div id="r-result"><input id="suggestId"  class="form-control searchInput" type="text" placeholder="地址搜索框" /></div> ' +
            '<button class="btn btn-primary confirmBtn">提交定位</button>' +
            '<div id="searchResultPanel"></div>' +
            '<div class="searchTip">请在地图上点击一个合适的点作为门店地址</div>' +
            '<div id="allmap"></div>'
        });
        // 初始化地图：中心位置北京天安门
        var map = new BMap.Map("allmap");  // 创建一个地图对象
        var point = new BMap.Point(116.404, 39.915);  // 根据经纬度设置中心点:天安门
        map.centerAndZoom(point,12);  // 设置中心点和缩放级别，数字越大，显示的范围越小
        map.enableScrollWheelZoom();  // 支持滚轮缩放
        map.addControl(new BMap.NavigationControl());  // 左上角添加平移缩放控件
        map.addControl(new BMap.ScaleControl());  // 左下方显示比例
        // 自动补全搜索
        var ac = new BMap.Autocomplete({    //建立一个自动完成的对象
            "input" : "suggestId",
            "location" : map
        });

        ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
            var str = "";
            var _value = e.fromitem.value;
            var value = "";
            if (e.fromitem.index > -1) {
                value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
            }
            str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

            value = "";
            if (e.toitem.index > -1) {
                _value = e.toitem.value;
                value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
            }
            str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
            $("#searchResultPanel").html(str);
        });

        var myValue;
        ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
            var _value = e.item.value;
            myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
            $("#searchResultPanel").html("onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue);
            map.clearOverlays();    //清除地图上所有覆盖物
            function myFun(){
                var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
                map.centerAndZoom(pp, 18);
                map.addOverlay(new BMap.Marker(pp));    //添加标注
            }
            var local = new BMap.LocalSearch(map, { //智能搜索
                onSearchComplete: myFun
            });
            local.search(myValue);
        });

        // 如果地址为空
        if (address == "") {
            // 根据ip获取地址：初步定位到城市
            function myFun(result){
                var cityName = result.name;
                map.setCenter(cityName);
            }

            var myCity = new BMap.LocalCity();
            myCity.get(myFun);
        }

        // 根据地址在地图上显示
        var myGeo = new BMap.Geocoder();
        myGeo.getPoint(address, function(point) {
            if (point) {
                map.centerAndZoom(point, 17);
                map.addOverlay(new BMap.Marker(point));    // 标注
                longitude = point.lng;
                latitude = point.lat;
            }
        });

        // 鼠标点击获取地址并添加标记
        map.addEventListener("click", function(e) {
            map.clearOverlays();  // 清空所有覆盖物
            newMarker = new BMap.Marker(e.point);
            map.addOverlay(newMarker);
            var pt = e.point;
            myGeo.getLocation(pt, function(rs) {
                var addComp = rs.addressComponents;
                longitude = pt.lng;
                latitude = pt.lat;
                // alert(addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber);
            });
        });

        // 更新经纬度
        $(".confirmBtn").click(function() {
            $(".longitude").val(longitude);
            $(".latitude").val(latitude);
            // 手动触发blur事件，便于jquery.validate的校验
            $('.longitude').trigger("blur");
            $('.latitude').trigger("blur");
            layer.closeAll();  // 关闭所有窗口
        });
    }
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>

<!--
@Todo 门店名称唯一性校验
@Todo 表单提交
-->
