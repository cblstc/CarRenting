<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="_meta.jsp"></jsp:include>
<title>订单评论管理</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>


<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
		<span class="c-gray en">&gt;</span>
		订单评论管理
		<span class="c-gray en">&gt;</span>
		订单评论列表
	</nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="r">共有数据：<strong>54</strong> 条</span>
			</div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-bg table-hover table-sort">
					<thead>
					<tr class="text-c">
						<th width="40">ID</th>
						<th width="80">内容</th>
						<th width="80">评分</th>
						<th width="100">时间</th>
						<th width="50">订单ID</th>
						<th width="50">用户ID</th>
						<th width="50">车辆ID</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="ordersComment" items="${ordersComments }">
					<tr class="text-c">
						<td>${ordersComment.id }</td>
						<td>${ordersComment.content }</td>
						<td>${ordersComment.star }</td>
						<td><fmt:formatDate value="${ordersComment.time }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>${ordersComment.ordersId }</td>
						<td>${ordersComment.userId }</td>
						<td>${ordersComment.storeCarId }</td>
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
	"aaSorting": [[ 3, "desc" ]],//默认第3个排序：按照时间排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
		//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		{"orderable":false,"aTargets":[0,5]}// 不参与排序的列
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

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
