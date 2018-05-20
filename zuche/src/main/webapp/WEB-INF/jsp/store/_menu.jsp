<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<body>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-car">
			<dt><i class="Hui-iconfont">&#xe669;</i> 车辆管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="${pageContext.request.contextPath }/store/toCarList?pageNum=1" title="车辆管理">车辆管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-orders">
			<dt><i class="Hui-iconfont">&#xe627;</i> 订单管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="${pageContext.request.contextPath }/store/toOrdersList" title="订单管理">订单管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-comments">
			<dt><i class="Hui-iconfont">&#xe622;</i> 评论管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="${pageContext.request.contextPath }/store/toOrdersCommentList" title="订单评论管理">订单评论管理</a></li>
					<li><a href="#" title="门店评论管理">门店评论管理</a></li>
				</ul>
			</dd>
		</dl>
	</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
</body>
</html>