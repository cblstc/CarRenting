<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="_meta.jsp"></jsp:include>
<title>汽车列表</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>


<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
		<span class="c-gray en">&gt;</span>
		车辆管理
		<span class="c-gray en">&gt;</span>
		车辆列表
	</nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<div class="text-c">
				<form action="${pageContext.request.contextPath }/store/toCarList?pageNum=1" method="post">
				品牌
				<span class="select-box inline">
					<select name="brand" class="brand select" onchange="loadModel(options[this.options.selectedIndex].getAttribute('brandId'))">
						<option value="0">请选择</option>
					</select>
				</span>
				车型
				<span class="select-box inline">

					<select name="model" class="model select" onchange="loadConfiguration(options[this.options.selectedIndex].getAttribute('modelId'))">
						<option value="0">请选择</option>
					</select>
				</span>
				配置
				<span class="select-box inline">
					<select name="configuration" class="configuration select">
						<option value="0">请选择</option>
					</select>
				</span>
				<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜车辆</button>
				</form>
			</div>
			<div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">
				<a class="btn btn-primary radius" data-title="添加车辆" _href="" onclick="car_add('添加车辆','${pageContext.request.contextPath }/store/toEditCar')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加车辆</a>
				</span>
				<span class="r">共有数据：<strong>54</strong> 条</span>
			</div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-bg table-hover table-sort">
					<thead>
						<tr class="text-c">
							<th width="40">ID</th>
							<th width="80">品牌</th>
							<th width="80">车型</th>
							<th width="100">配置</th>
							<th width="40">座位数</th>
							<th width="40">门数</th>
							<th width="50">排量</th>
							<th width="40">导航仪</th>
							<th width="40">倒车雷达</th>
							<th width="50">驱动模式</th>
							<th width="50">油箱</th>
							<th width="50">变速箱</th>
							<th width="40">天窗</th>
							<th width="40">安全气囊数</th>
							<th width="40">日均价</th>
							<th width="40">基本保险</th>
							<th width="40">不计免赔险</th>
							<th width="40">数量</th>
							<th width="80">状态</th>
							<th width="80">操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="storeCar" items="${storeCars }">
						<tr class="text-c">
							<td>${storeCar.id }</td>
							<td>${storeCar.brand }</td>
							<td>${storeCar.model }</td>
							<td>${storeCar.configuration }</td>
							<td>${storeCar.seats }</td>
							<td>${storeCar.doors }</td>
							<td>${storeCar.displacement }</td>
							<td>
								<c:if test="${storeCar.navigator == 1 }">有</c:if>
								<c:if test="${storeCar.navigator == 2 }">无</c:if>
							</td>
							<td>${storeCar.pdc }</td>
							<td>
								<c:if test="${storeCar.drivenmode == 1 }">前驱</c:if>
								<c:if test="${storeCar.drivenmode == 2 }">后驱</c:if>
								<c:if test="${storeCar.drivenmode == 3 }">四驱</c:if>
							</td>
							<td>${storeCar.fueltankage }</td>
							<td>
								<c:if test="${storeCar.gearbox == 1 }">自动</c:if>
								<c:if test="${storeCar.gearbox == 2 }">手动</c:if>
							</td>
							<td>
								<c:if test="${storeCar.skylight == 1 }">有</c:if>
								<c:if test="${storeCar.skylight == 2 }">无</c:if>
							</td>
							<td>${storeCar.aircell }</td>
							<td>${storeCar.price }</td>
							<td>${storeCar.insurance }</td>
							<td>${storeCar.nodeductibles }</td>
							<td>${storeCar.count }</td>
							<td class="td-status">
								<c:if test="${storeCar.status == 1 }"><span class="label label-success radius">已上架</span></c:if>
								<c:if test="${storeCar.status == 2 }"><span class="label label-danger radius">已下架</span></c:if>
							</td>
							<td class="f-14 td-manage">
							<c:if test="${storeCar.status == 1 }">
								<a style="text-decoration:none" onClick="car_stop(this,this.parentNode.parentNode.children[0].innerHTML)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>
							</c:if>
							<c:if test="${storeCar.status == 2 }">
								<a style="text-decoration:none" onClick="car_start(this,this.parentNode.parentNode.children[0].innerHTML)" href="javascript:;" title="上架"><i class="Hui-iconfont">&#xe6dc;</i></a>
							</c:if>
								<a style="text-decoration:none" class="ml-5" onClick="car_edit('车辆编辑','${pageContext.request.contextPath }/store/toEditCar', this.parentNode.parentNode.children[0].innerHTML)" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</article>
	</div>
</section>

<!--_footer 作为公共模版分离出去-->
<jsp:include page="_footer.jsp"></jsp:include>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/laypage/1.2/laypage.js"></script>
<!-- 品牌、车型、配置三级联动 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/js/brandToModelToConf.js"></script>

<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
		//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		{"orderable":false,"aTargets":[0,19]}// 不参与排序的列
	]
});
loadBrand();  // 加载车辆品牌
/*车辆-添加*/
function car_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*车辆-编辑*/
function car_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url + "?id=" + id + "&operate=edit"
	});
	layer.full(index);
}

/*车辆-下架*/
function car_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		window.location.href = "${pageContext.request.contextPath }/store/changeStatus?operate=carDown&id=" + id;
	});
}

/*车辆-上架*/
function car_start(obj,id){
	layer.confirm('确认要上架吗？',function(index){
		window.location.href = "${pageContext.request.contextPath }/store/changeStatus?operate=carUp&id=" + id;
	});
}

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
