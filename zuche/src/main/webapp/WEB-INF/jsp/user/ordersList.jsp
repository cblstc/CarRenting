<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单列表</title>
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap-theme.min.css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/common.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/userLeftNav.css">
    <!--<link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/userRightContent.css">-->
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/userTopNav.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/user/userCenter.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/jquery.dataTables.min.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/jquery.raty.css">

    <style>
        /* 处理评分星星空格宽度太大 */
        .comment-star img {
            margin-right: -8px;
        }
    </style>

    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/userLeftNav.js"></script>
    <!--<script type="text/javascript" src="${pageContext.request.contextPath }/js/userCenter.js"></script>-->
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/layer/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery.raty.js"></script>

</head>
<body>
    <div class="header-box"></div>
         <!--头部-->
     <jsp:include page="../common/public-header.jsp"></jsp:include>


         <!-- 用户中心头部 -->
     <jsp:include page="../common/userTopNav.jsp"></jsp:include>


    <div class="main-content">
        <div class="public-container clearfloat">
            <!-- 左边导航 -->
              <jsp:include page="../common/userLeftNav.jsp"></jsp:include>


            <!-- 右边内容 -->
            <div class="right-content left-float">
                <dl>
                    <dt class="content-title">我的订单
                        <select onchange="searchOrders(this.value);">
                            <option value="0">请选择</option>
                            <option value="1">未付款</option>
                            <option value="2">已付款</option>
                            <option value="3">申请退款</option>
                            <option value="4">已退款</option>
                            <option value="5">正在租赁</option>
                            <option value="6">待评论</option>
                            <option value="7">已结束</option>
                        </select>
                    </dt>
                </dl>
                <table id="orderTable" class="table table-striped table-bordered" style="width: 870px;">
                    <thead>
                        <tr>
                            <th>订单号</th>
                            <th>时间</th>
                            <th>图片</th>
                            <th>门店</th>
                            <th>日均价</th>
                            <th>基本保险</th>
                            <th>不计免赔险</th>
                            <th>总计</th>
                            <th>订单状态</th>
                            <th>操作</th>
                        </tr>
                    </thead>

                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!--尾部-->
     <jsp:include page="../common/public-footer.jsp"></jsp:include>


    <script>
    var t = $('#orderTable').DataTable({
        ajax: {  // 数据获取
            // url: "jsondemo/datatable_demo_1.json"
            url: "${pageContext.request.contextPath }/order/queryOrders?pageNum=1"
        },
        pageLength: 3,  // 3条数据
        columns: [  // 数据绑定
            { "data": "orders.id" },
            { "data": "orders.time" },
            { "data": "storeCar.carphoto" },
            { "data": "store.storename" },
            { "data": "orders.price" },
            { "data": "orders.insurance" },
            { "data": "orders.nodeductibles" },
            { "data": "orders.totalmoney" },
            { "data": "orders.status" },
            { "data": "orders.status" }
        ],

        "columnDefs": [
			{   // 时间
			    "render": function(data, type, row, meta) {
			    	return timeStampToDate(data);
			    },
			    "targets": 1
			},
            {   // 图片
                "render": function(data, type, row, meta) {
                    return "<img style='width: 100px; height: 50px;' src='${pageContext.request.contextPath }/uploads/" + data.split(";")[0] + "'/>";
                },
                "targets": 2
            },
            {   // 日价格
			    "render": function(data, type, row, meta) {
			    	return data + "元";
			    },
			    "targets": 4
			},
			{   // 基本保险
			    "render": function(data, type, row, meta) {
			    	return data + "元";
			    },
			    "targets": 5
			},
			{   // 不计免赔
			    "render": function(data, type, row, meta) {
			    	return data + "元";
			    },
			    "targets": 6
			},
			{   // 总额
			    "render": function(data, type, row, meta) {
			    	return data + "元";
			    },
			    "targets": 7
			},
            {   // 状态
                "render": function(data, type, row, meta) {
                    var status = "";
                    var color = "";
                    switch (data) {
                        case 1:
                        	status = "未付款";
                            color = "red";
                            break;
                        case 2:
                        	status = "已付款";
                        	color = "blue";
                            break;
                        case 3:
                        	status = "申请退款";
                        	color = "red";
                            break;
                        case 4:
                        	status = "已退款";
                        	color = "blue";
                            break;
                        case 5:
                        	status = "正在租赁";
                        	color = "red";
                            break;
                        case 6:
                        	status = "待评论";
                        	color = "red";
                            break;
                        case 7:
                        	status = "已结束";
                        	color = "blue";
                            break;
                    }
                    return "<span style=\"color:" + color + "\">" + status + "</span>";
                },
                "targets": 8
            },
            {   // 操作方式
                "render": function(data, type, row, meta) {
                	var btns = "";
                	if (data == "1") {
                		var ordersId = row.orders.id;
	                    btns = "<button class='btn btn-primary btn-xs' onclick='javascript: window.location.href=\"${pageContext.request.contextPath }/order/pay?ordersId=" + ordersId + "\";'>付款</button><br/>";
                	} else if (data == "2") {
                		var ordersId = row.orders.id;
                		btns = "<button class='btn btn-danger btn-xs' onclick='javascript: layer.msg(\"提交申请\"); window.location.href=\"${pageContext.request.contextPath }/order/applyRefund?ordersId=" + ordersId + "\";'>退款</button><br/>";
                	} else if (data == "3") {
                		btns = "<span>等待批准</span>";
                	} else if (data == "4") {
                		btns = "<span>交易关闭</span>";
                	} else if (data == "5") {
                		btns = "<span>租赁中</span>";
                	} else if (data == "6") {
                		var ordersId = row.orders.id;
                		btns = "<button class='btn btn-info btn-xs' onclick='ev_comment_edit(\"" + ordersId + "\");'>评论</button><br/>";
                	} else if (data == "7") {
                		btns = "<button class='btn btn-info btn-xs' onclick='ev_comment_show(\"" + ordersId + "\");'>查看评论</button>";
                	}
                    return btns;
                },
                "targets": 9
            }
        ],

        // 国际化
        language: {
            "sProcessing": "处理中...",
            "sLengthMenu": "显示 _MENU_ 项结果",
            "sZeroRecords": "没有匹配结果",
            "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
            "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
            "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
            "sInfoPostFix": "",
            "sSearch": "搜索:",
            "sUrl": "",
            "sEmptyTable": "表中数据为空",
            "sLoadingRecords": "载入中...",
            "sInfoThousands": ",",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上页",
                "sNext": "下页",
                "sLast": "末页"
            },
            "oAria": {
                "sSortAscending": ": 以升序排列此列",
                "sSortDescending": ": 以降序排列此列"
            }
        }
    });
    
    /* 时间戳转时间 */
    function timeStampToDate(time) {
    	var date = new Date(time);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        Y = date.getFullYear() + '-';
        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        D = date.getDate() + ' ';
        h = date.getHours() + ':';
        m = date.getMinutes() + ':';
        s = date.getSeconds();
        return Y+M+D+h+m+s;
    }

    // 查询订单
    function searchOrders(value) {
        var status = value;
        var url = t.ajax.url("${pageContext.request.contextPath }/order/queryOrders?pageNum=1&status=" + status);
        url.load();
    }

    // 打开评论编辑窗口
    function ev_comment_edit(ordersId) {
    	$(".ordersId").val(ordersId);
        layer.open({
            title: "发布评论",
            type: 1,
            closeBtn: 1,
            area: ['550px', '350px'], //宽高
            content: $('.comment-edit-box'),  // 加载评论表单
            cancel: function(index, layero) {
                $(".comment-edit-box").css("display", "none");  // 隐藏评论表单
            }
        });
    }
    
 	// 打开评论查看窗口
    function ev_comment_show(ordersId) {
    	$.ajax({  
    	    type: "POST",  
    	    url: "${pageContext.request.contextPath }/comment/showComment",  
    	    data: {  
    	        "ordersId": ordersId,  
    	        "userId": "${user.id}" 
    	    },  
    	    success: function(result) {
    	    	$(".show-star").text(result.data.star + "星");
    	    	$(".show-content").text(result.data.content);
    	    	layer.open({
    	            title: "查看评论",
    	            type: 1,
    	            closeBtn: 1,
    	            area: ['550px', '350px'], //宽高
    	            content: $('.comment-show-box'),  // 加载评论表单
    	            cancel: function(index, layero) {
    	                $(".comment-show-box").css("display", "none");  // 隐藏评论表单
    	            }
    	        });
    	    }  
    	});  
    }

    /* 显示当前字符长度 */
    function showCurrentLength(item) {
        var currentLength = $(item).val().length;
        var next = $(item).next();
        $($(next).find("span").get(0)).text(currentLength);
    }
    </script>

    <!-- 操作方式 - 隐藏 -->
    <div class="op-box" style="display: none;">
        <button class='btn btn-primary btn-xs' onclick=''>付款</button><br/>
        <button class='btn btn-danger btn-xs' onclick=''>退款</button><br/>
        <button class='btn btn-info btn-xs' onclick='ev_comment_edit();'>评论</button><br/>
    </div>

    <!-- 发布评论 - 隐藏 -->
    <form role="form" class="comment-edit-box" method="post" action="${pageContext.request.contextPath }/comment/saveComment" style="display: none;">
    	<input type="hidden" name="ordersId" class="ordersId">
    	<input type="hidden" name="userId" class="userId" value="${user.id }">
        <div class="form-group">
            <label for="content">评分</label>
            <div class="comment-star"></div>
            <input type="hidden" name="star" class="star" value="3" />
        </div>
        <div class="form-group">
            <label for="content">评论内容</label>
            <div class="content-box"><textarea id="content" name="content" class="form-control content" maxlength="200" placeholder="填写评论，不超过200个字符" dragonfly="true" onKeyUp="showCurrentLength(this)"></textarea>
                <p class="remains"><span>0</span>/200</p></div>
            </div>
        <div class="form-group">
            <button class="btn btn-primary" type="submit">提交</button>
        </div>
    </form>
    
    <!-- 查看评论 - 隐藏 -->
    <form role="form" class="comment-show-box" method="post" action="${pageContext.request.contextPath }/comment/showComment" style="display: none;">
    	<input type="hidden" name="ordersId" class="ordersId">
    	<input type="hidden" name="userId" class="userId" value="${user.id }">
        <div class="form-group">
            <label for="content">评分</label>
            <div class="show-star">3星</div>
        </div>
        <div class="form-group">
            <label for="content">评论内容</label>
            <div class="show-content">很好</div>
        </div>
    </form>

    <script>
        /* 显示评分的星星 */
        $('.comment-star').raty({
            starOn:'${pageContext.request.contextPath }/images/star-on.png',
            starOff:'${pageContext.request.contextPath }/images/star-off.png',
            hints: ['差', '一般', '好', '非常好', '全五星'],
            halfShow: false,
            score:3,
            readOnly: false,
            click: function (score, evt) {
                $(".star").val(score);  // 把评分赋值给表单
            }
        });
    </script>
</body>
</html>
