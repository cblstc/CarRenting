<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
			</div>
			<div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">
				<a class="btn btn-primary radius" data-title="添加车辆" _href="car-add.html" onclick="car_add('添加车辆','${pageContext.request.contextPath }/store/toEditCar')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加车辆</a>
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
						<tr class="text-c">
							<td>1</td>
							<td>保时捷</td>
							<td>911 GT</td>
							<td>2015年基本版</td>
							<td>2</td>
							<td>2</td>
							<td>2.4L</td>
							<td>有</td>
							<td>有</td>
							<td>前驱</td>
							<td>70</td>
							<td>手动</td>
							<td>有</td>
							<td>4</td>
							<td>120</td>
							<td>40</td>
							<td>20</td>
							<td>10</td>
							<td class="td-status"><span class="label label-success radius">已上架</span><span class="label label-danger radius">已下架</span></td>
							<td class="f-14 td-manage">
								<a style="text-decoration:none" onClick="car_start(this,'10001')" href="javascript:;" title="上架"><i class="Hui-iconfont">&#xe6dc;</i></a>
								<a style="text-decoration:none" onClick="car_stop(this,'10001')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>
								<a style="text-decoration:none" class="ml-5" onClick="car_edit('车辆编辑','car-add.html','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
							</td>
						</tr>
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
		content: url
	});
	layer.full(index);
}

/*车辆-下架*/
function car_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="car_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}

/*车辆-上架*/
function car_start(obj,id){
	layer.confirm('确认要上架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="car_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已上架!',{icon: 6,time:1000});
	});
}

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
