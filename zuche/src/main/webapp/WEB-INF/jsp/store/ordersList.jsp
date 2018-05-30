<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
			<form action="${pageContext.request.contextPath }/store/toOrdersList" method="post">
				订单状态
				<span class="select-box inline">
					<select name="status" class="s select">
						<option value="0">请选择</option>
						<option value="1" <c:if test="${status == 1}">selected</c:if>>未付款</option>
						<option value="2" <c:if test="${status == 2}">selected</c:if>>已付款</option>
						<option value="3" <c:if test="${status == 3}">selected</c:if>>退单申请中</option>
						<option value="4" <c:if test="${status == 4}">selected</c:if>>已退单</option>
						<option value="5" <c:if test="${status == 5}">selected</c:if>>租赁开始中</option>
						<option value="5" <c:if test="${status == 6}">selected</c:if>>待评论</option>
						<option value="6" <c:if test="${status == 7}">selected</c:if>>已结束</option>
					</select>
				</span>
				<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜订单</button>
			</form>
			</div>
			<div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="r">共有数据：<strong>54</strong> 条</span>
			</div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-bg table-hover table-sort">
					<thead>
						<tr class="text-c">
							<th width="150">ID</th>
							<th width="50">日均价(元)</th>
							<th width="50">基本保险(元)</th>
							<th width="50">不计免赔险(元)</th>
							<th width="50">总额(元)</th>
							<th width="100">取车时间</th>
							<th width="100">还车时间</th>
							<th width="100">订单时间</th>
							<th width="30">车辆ID</th>
							<th width="30">用户ID</th>
							<th width="50">订单状态</th>
							<th width="40">操作</th>
						</tr>
					</thead>
					
					<tbody>
					<c:forEach var="orders" items="${orderss }">
						<tr class="text-c">
							<td>${orders.id }</td>
							<td>${orders.price }</td>
							<td>${orders.insurance }</td>
							<td>${orders.nodeductibles }</td>
							<td>${orders.totalmoney }</td>
							<td><fmt:formatDate value="${orders.gettime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td><fmt:formatDate value="${orders.returntime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td><fmt:formatDate value="${orders.time }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${orders.storeCarId }</td>
							<td>${orders.userId }</td>
							<td class="td-status">
								<c:if test="${orders.status == 1}">
									<span class="label label-danger radius">未付款</span>
								</c:if>
								<c:if test="${orders.status == 2}">
									<span class="label label-primary radius">已付款</span>
								</c:if>
								<c:if test="${orders.status == 3}">
									<span class="label label-warning radius">退单申请中</span>
								</c:if>
								<c:if test="${orders.status == 4}">
									<span class="label label-success radius">已退单</span>
								</c:if>
								<c:if test="${orders.status == 5}">
									<span class="label label-warning radius">租赁开始中</span>
								</c:if>
								<c:if test="${orders.status == 6}">
									<span class="label label-primary radius">待评论</span>
								</c:if>
								<c:if test="${orders.status == 7}">
									<span class="label label-success radius">已结束</span>
								</c:if>
							</td>
							<td class="f-14 td-manage">
								<c:choose>
									<c:when test="${orders.status == 2}">
										<button class="btn btn-primary btn-xs" onclick="javascript: window.location.href='${pageContext.request.contextPath }/store/changeOrdersStatus?id=${orders.id}&status=2'">开始租赁</button>
									</c:when>
									<c:when test="${orders.status == 3}">
										<button class="btn btn-primary btn-xs" onclick="javascript: window.location.href='${pageContext.request.contextPath }/store/changeOrdersStatus?id=${orders.id}&status=3'"">批准退款</button>
									</c:when>
									<c:when test="${orders.status == 5}">
										<button class="btn btn-danger btn-xs" onclick="javascript: window.location.href='${pageContext.request.contextPath }/store/changeOrdersStatus?id=${orders.id}&status=5'"">结束租赁</button>
									</c:when>
									<c:otherwise>
										无
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
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
	"aaSorting": [[ 7, "desc" ]],//默认第8个排序 - 按照时间排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
		//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		{"orderable":false,"aTargets":[0,11]}// 不参与排序的列
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
