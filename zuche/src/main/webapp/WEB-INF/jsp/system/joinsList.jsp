<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>加盟列表</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/themes/default/easyui.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/system/userList.css" type="text/css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/common.css">

    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/layer/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/easyui-loading.js"></script>
</head>
<body>
    <table class="easyui-datagrid dg" width="100%" height="100%"
           toolbar=".toolbar" rownumbers="true" fitColumns="false" singleSelect="true">
        <thead>
        <tr>
            <th field="id" width="100">加盟编号</th>
            <th field="company" width="150">公司</th>
            <th field="name" width="100">姓名</th>
            <th field="phone" width="100">联系电话</th>
            <th field="email" width="150">邮箱</th>
            <th field="note" width="300">备注</th>
            <th field="status" width="60">状态</th>
            <th field="operate" width="200">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="joins" items="${joinss }">
            <tr>
                <td>${joins.id }</td>
                <td>${joins.company }</td>
                <td>${joins.name }</td>
                <td>${joins.phone }</td>
                <td>${joins.email }</td>
                <td>${joins.note }</td>
                <td>
                	<c:choose>
                		<c:when test="${joins.status == 1 }">
                			<span style="color: blue;">正在申请</span>
                		</c:when>
                		<c:when test="${joins.status == 2 }">
                			<span style="color: green;">已通过</span>
                		</c:when>
                		<c:otherwise>
                			<span style="color: red;">已拒绝</span>
                		</c:otherwise>
                	</c:choose>
                </td>
                <td>
                    <c:choose>
                		<c:when test="${joins.status == 1 }">
                			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="passJoins('${joins.id }');" iconCls="icon-ok" plain="true">通过</a>
                			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="failJoins('${joins.id }');" iconCls="icon-no" plain="true">拒绝</a>
                		</c:when>
                		<c:when test="${joins.status == 2 }">
                		</c:when>
                		<c:otherwise>
                			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="passJoins('${joins.id }');" iconCls="icon-ok" plain="true">通过</a>
                		</c:otherwise>
                	</c:choose>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="toolbar" style="padding: 20px; position: relative;">
	    <form action="${pageContext.request.contextPath }/system/toJoinsList" method="post">
	    	<input type="hidden" name="pageNum" value="1"/>
	        <img src="${pageContext.request.contextPath }/images/system/username.png"> <input class="name" name="name" value="${name }" placeholder="姓名查询">&nbsp;&nbsp;
	        <img src="${pageContext.request.contextPath }/images/system/phone.png"> <input class="phone" name="phone" value="${phone }" placeholder="联系电话查询">&nbsp;&nbsp;
	        <img src="${pageContext.request.contextPath }/images/system/status.png">
	        <select style="height: 22px;" name="status">
	            <option value="0">请选择</option>
	            <option <c:if test="${status == 1 }">selected</c:if> value="1">正在申请</option>
	            <option <c:if test="${status == 2 }">selected</c:if> value="2">通过申请</option>
	            <option <c:if test="${status == 3 }">selected</c:if> value="3">拒绝申请</option>
	        </select>&nbsp;&nbsp;
	        <input type="submit" value="查询" style="width: 40px; background:#0089dc; color: #fff; border: 0; border-radius: 3%;">
	    </form>
	</div>
    
    <div class="easyui-pagination" style="position: absolute; top:0; right:0;" data-options="
						total: ${total },
						pageSize: 5,  // 每页记录
						pageNumber: ${pageNum },  // 当前页码
						showPageList: false,
						showRefresh: false,
						displayMsg: '',
						onSelectPage: function(pageNumber, pageSize) {
							window.location.href='${pageContext.request.contextPath}/system/toJoinsList?pageNum=' + pageNumber + 
							'&name=${name }&phone=${phone }&status=${status }';
						}
					"></div>

    <div class="easyui-dialog dlg" style="width:500px;height:260px;padding:10px 20px;"
         closed="true" buttons="#dlg-buttons" pagination="true">
    </div>


	<script>
	// 通过申请
    function passJoins(id) {
        	layer.confirm('确定通过审核？通过之后会注册一个门店账号，发送给申请人的邮箱。', {
        		btn: ['确定', '取消']
        	}, function() {
        		window.location.href='${pageContext.request.contextPath}/system/passJoins?id=' + id;
        	}, function() {
        	});
    }
    
    // 拒绝申请
    function failJoins(id) {
        	layer.confirm('确认执行该操作？', {
        		btn: ['确定', '取消']
        	}, function() {
        		window.location.href='${pageContext.request.contextPath}/system/failJoins?id=' + id;
        	}, function() {
        	});
    }
	</script>
</body>
</html>
