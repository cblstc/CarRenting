<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="_meta.jsp"></jsp:include>

<title>首页</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>

<jsp:include page="_menu.jsp"></jsp:include>

<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
	</nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<p class="f-20 text-success">欢迎使用Cargo租车门店版！</p>
		</article>
	</div>
</section>

<!--_footer 作为公共模版分离出去-->
<jsp:include page="_footer.jsp"></jsp:include>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
$(function() {
	// 判断门店信息是否存在
	var isNew = ("${isNew }" == "isNew") ? true : false;
	if (isNew) {
		// 打开门店信息编辑框
		var index = layer.open({
	        type: 2,
	        title: "门店信息",
	        content: "${pageContext.request.contextPath }/store/toStoreInfo?operate=add",
	        cancel: function(index, layero) {
	       		// 关闭时返回登录页面
	            window.location.href = "${pageContext.request.contextPath }/store/toLogin";
	        }
	    });
	    layer.full(index);
	}
});
</script>
<!--/请在上方写此页面业务相关的脚本-->

</body>
</html>
