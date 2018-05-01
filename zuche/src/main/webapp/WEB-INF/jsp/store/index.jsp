<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!--_meta 作为公共模版分离出去-->
<div class="meta-box"></div>
<!--/meta 作为公共模版分离出去-->


<title>首页</title>
</head>
<body>
<!--_header 作为公共模版分离出去-->
<div class="header-box"></div>
<!--/_header 作为公共模版分离出去-->

<!--_menu 作为公共模版分离出去-->
<div class="menu-box"></div>
<!--/_menu 作为公共模版分离出去-->

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
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
    /* 加载尾部 */
    /*$.ajax({
        url : "_footer.html",
        cache : true,
        async : false,
        success : function(html) {
            $(".footer-box").html(html);
        }
    });*/
    /* 加载meta */
    $.ajax({
        url : "_meta.html",
        cache : true,
        async : false,
        success : function(html) {
            $(".meta-box").html(html);
        }
    });

    /* 加载头部 */
    $.ajax({
        url : "_header.html",
        cache : true,
        async : false,
        success : function(html) {
            $(".header-box").html(html);
        }
    });
    /* 加载菜单 */
    $.ajax({
        url : "_menu.html",
        cache : true,
        async : false,
        success : function(html) {
            $(".menu-box").html(html);
        }
    });
</script>
<!--/请在上方写此页面业务相关的脚本-->

</body>
</html>
