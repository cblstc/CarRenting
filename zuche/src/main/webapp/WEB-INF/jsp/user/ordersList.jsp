<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/user/improveAccount.css">
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
                            <option value="3">正在租赁</option>
                            <option value="4">已结束</option>
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
                            <th>租赁时长</th>
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
            url: "jsondemo/datatable_demo_1.json"
        },
        pageLength: 3,  // 3条数据
        columns: [  // 数据绑定
            { "data": "id" },
            { "data": "time" },
            { "data": "photo" },
            { "data": null },
            { "data": "totaltime" },
            { "data": "price" },
            { "data": "insurance" },
            { "data": "nodeductibles" },
            { "data": "total" },
            { "data": "state" },
            { "data": null }
        ],

        "columnDefs": [
            {   // 图片
                "render": function(data, type, row, meta) {
                    return "<img style='width: 100px; height: 50px;' src='${pageContext.request.contextPath }/" + data + "'/>";
                },
                "targets": 2
            },
            {   // 门店
                "render": function(data, type, row, meta) {
                    return "广东门店";
                },
                "targets": 3
            },
            {   // 状态
                "render": function(data, type, row, meta) {
                    var state = "";
                    switch (data) {
                        case 1:
                            state = "未付款";
                            break;
                        case 2:
                            state = "已付款";
                            break;
                        case 3:
                            state = "正在租赁";
                            break;
                        case 4:
                            state = "已结束";
                            break;
                    }
                    return state;
                },
                "targets": 9
            },
            {   // 操作方式
                "render": function(data, type, row, meta) {
                    var btns = "<button class='btn btn-primary btn-xs' onclick=''>付款</button><br/>" +
                        "<button class='btn btn-danger btn-xs' onclick=''>退款</button><br/>" +
                        "<button class='btn btn-info btn-xs' onclick='ev_comment_edit();'>评论</button><br/>";
                    return btns;
                },
                "targets": 10
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

    // 查询订单
    function searchOrders(value) {
        var state = value;
        var url = t.ajax.url("jsondemo/datatable_demo_" + state + ".json");
        url.load();
    }

    // 打开评论编辑窗口
    function ev_comment_edit() {
        layer.open({
            title: '评论编辑',
            type: 1,
            closeBtn: 1,
            area: ['550px', '350px'], //宽高
            content: $('.comment-edit-box'),  // 加载评论表单
            cancel: function(index, layero) {
                $(".comment-edit-box").css("display", "none");  // 隐藏评论表单
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

    <!-- 评论弹框 - 隐藏 -->
    <form role="form" class="comment-edit-box" method="post" action="" style="display: none;">
        <div class="form-group">
            <label for="content">评分</label>
            <div class="comment-star"></div>
            <input type="hidden" name="star" class="star" />
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
