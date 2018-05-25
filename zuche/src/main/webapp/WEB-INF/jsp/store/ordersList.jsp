<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="_meta.jsp"></jsp:include>
<title>订单列表</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>


<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
		<span class="c-gray en">&gt;</span>
		订单管理
		<span class="c-gray en">&gt;</span>
		订单列表
	</nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<div class="text-c">
				订单状态
				<span class="select-box inline">
					<select name="brand" class="brand select" onchange="loadModel(options[this.options.selectedIndex].getAttribute('brandId'))">
						<option value="0">请选择</option>
						<option value="1">未付款</option>
						<option value="2">已付款</option>
						<option value="3">租赁开始中</option>
						<option value="4">已结束</option>
						<option value="5">退单申请中</option>
						<option value="6">已退单</option>
					</select>
				</span>
				<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜订单</button>
			</div>
			<div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="r">共有数据：<strong>54</strong> 条</span>
			</div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-bg table-hover table-sort">
					<thead>
						<tr class="text-c">
							<th width="40">ID</th>
							<th width="80">日均价(元)</th>
							<th width="80">基本保险(元)</th>
							<th width="100">不计免赔险(元)</th>
							<th width="40">总额(元)</th>
							<th width="50">取车时间</th>
							<th width="40">还车时间</th>
							<th width="40">天数</th>
							<th width="50">订单时间</th>
							<th width="50">车辆ID</th>
							<th width="50">用户名</th>
							<th width="80">订单状态</th>
							<th width="80">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr class="text-c">
							<td>112321321</td>
							<td>120</td>
							<td>120</td>
							<td>50</td>
							<td>400</td>
							<td>2016-12-1 14:00:00</td>
							<td>2016-12-2 16:00:00</td>
							<td>2</td>
							<td>2016-12-1 10:00:00</td>
							<td>2323</td>
							<td>12343232323</td>
							<td class="td-status">
								<!-- 未付款，状态1，@Todo 顾客4小时未付款自动取消订单，并删除订单 -->
								<!-- <span class="label label-danger radius">未付款</span>
								已付款，状态2
								<span class="label label-primary radius">已付款</span>
								租赁开始中，状态3
								<span class="label label-warning radius">租赁开始中</span>
								已结束，状态4
								<span class="label label-success radius">已结束</span> -->
								<!-- 退单申请中，状态5，
									租赁开始，4小时前可以全额退款；
									租赁开始，4小时内只能半价退款，超过时间无法退款
									@Todo 门店可以批准申请，也可以拒绝申请。
								-->
								<span class="label label-danger radius">退单申请中</span>
								<!-- 已退单，状态6 -->
								<!-- <span class="label label-success radius">已退单</span> -->
							</td>
							<td class="f-14 td-manage">
								<a style="text-decoration:none" onClick="refund_approve(this,'10001')" href="javascript:;" title="批准退款"><i class="Hui-iconfont">&#xe66d;</i></a>
								<a style="text-decoration:none" onClick="refund_refuse(this,'10001')" href="javascript:;" title="拒绝退款"><i class="Hui-iconfont">&#xe66e;</i></a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</article>
	</div>
</section>

<jsp:include page="_footer.jsp"></jsp:include>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/laypage/1.2/laypage.js"></script>
<!-- 品牌、车型、配置三级联动 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/js/brandToModelToConf.js"></script>

<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 8, "desc" ]],//默认第8个排序 - 按照时间排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
		//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		{"orderable":false,"aTargets":[0,12]}// 不参与排序的列
	]
});

/*批准退款*/
function refund_approve(obj,id){
    layer.confirm('确认退款？',function(index){
        $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="car_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
        $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
        $(obj).remove();
        layer.msg('已上架!',{icon: 6,time:1000});
    });
}

/*拒绝退款*/
function refund_refuse(obj,id){
	layer.confirm('拒绝退款？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="car_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}


/* 加载尾部 */
/*$.ajax({
    url : "_footer.html",
    cache : true,
    async : false,
    success : function(html) {
        $(".footer-box").html(html);
    }
});*/
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
