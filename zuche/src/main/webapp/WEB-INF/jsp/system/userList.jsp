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
    <title>用户列表</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/themes/default/easyui.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/system/userList.css" type="text/css">

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/common.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/easyui-loading.js"></script>

    <style>
    </style>
</head>
<body>
    <table class="easyui-datagrid dg" width="100%" height="100%"
           toolbar=".toolbar" rownumbers="true" fitColumns="false" singleSelect="true">
        <thead>
            <tr>
                <th field="id" width="150">用户编号</th>
                <th field="photo" width="70">用户头像</th>
                <th field="phone" width="150">联系电话</th>
                <th field="username" width="150">用户名</th>
                <th field="email" width="150">邮箱</th>
                <th field="status" width="150">账户状态</th>
                <th field="operate" width="180">操作</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="userAndInfo" items="${userAndInfos }">
            <tr>
                <td>${userAndInfo.user.id }</td>
                <td><a href="${pageContext.request.contextPath}/uploads/${userAndInfo.userInfo.idcardphoto}" target="_blank"><img src="${pageContext.request.contextPath}/uploads/${userAndInfo.userInfo.idcardphoto}" style="width: 30px; height: 30px;"></a></td>
                <td>${userAndInfo.user.phone }</td>
                <td>${userAndInfo.user.username }</td>
                <td>${userAndInfo.user.email }</td>
                <td>
                	<c:choose>
                		<c:when test="${userAndInfo.user.status == 1 }">
                			已启用
                		</c:when>
                		<c:otherwise>
                			<span class="red-text">已停用</span>
                		</c:otherwise>
                	</c:choose>
                </td>
                <td>
                    <a href="javascript:void(0)" onclick="showInfo('${userAndInfo.user.id }');" class="easyui-linkbutton" iconCls="icon-search" plain="true">认证信息</a>
                    <c:choose>
                		<c:when test="${userAndInfo.user.status == 1 }">
                    		<a href="javascript:void(0)" onclick="stopUser('${userAndInfo.user.id }');" class="easyui-linkbutton" iconCls="icon-no" plain="true">停用</a>
                		</c:when>
                		<c:otherwise>
                			<a href="javascript:void(0)" onclick="startUser('${userAndInfo.user.id }');" class="easyui-linkbutton" iconCls="icon-ok" plain="true">启用</a>
                		</c:otherwise>
                	</c:choose>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="toolbar" style="padding: 20px; position: relative;">
	    <form action="${pageContext.request.contextPath}/system/toUserList" method="post">
	    	<input type="hidden" name="pageNum" value="1"/>
	        <img src="${pageContext.request.contextPath}/images/system/username.png"> <input class="username" name="username" value="${username }" placeholder="用户名查询">&nbsp;&nbsp;
	        <img src="${pageContext.request.contextPath}/images/system/phone.png"> <input class="phone" name="phone" value="${phone }" placeholder="联系电话查询">&nbsp;&nbsp;
	        <img src="${pageContext.request.contextPath}/images/system/email.png"> <input class="email" name="email" value="${email }" placeholder="邮箱查询">&nbsp;&nbsp;
	        <input type="submit" value="查询" style="width: 40px; background:#0089dc; color: #fff; border: 0; border-radius: 3%;">
	    </form>
        
        <div class="easyui-pagination" style="position: absolute; top:0; right:0;" data-options="
						total: ${total },
						pageSize: 5,  // 每页记录
						pageNumber: ${pageNum },  // 当前页码
						showPageList: false,
						showRefresh: false,
						displayMsg: '',
						onSelectPage: function(pageNumber, pageSize) {
							window.location.href='${pageContext.request.contextPath}/system/toUserList?pageNum=' + pageNumber + 
							'&username=${username }&phone=${phone }&email=${email }';
						}
					"></div>
    </div>

    <div class="easyui-dialog dlg" style="width:500px;height:260px;padding:10px 20px;"
         closed="true" buttons="#dlg-buttons" pagination="true">
    </div>

    <script>
    /**
     * 查看认证信息
      */
    function showInfo(id) {
       	$.ajax({
       		type: "POST",
       		url: "${pageContext.request.contextPath }/system/getUserInfoJSON",
       		data: {
       			"id": id
       		},
       		success: function(result) {
       			if (result == null) {
       				layer.msg('该用户还没有认证信息！');
       				return;
       			}
       			var name = result.name;
       			var sex = result.sex == 1? "男":"女";
       			var idcardPhoto = result.idcardphoto;
       			var licencePhoto = result.licencephoto;
       			var licencevicePhoto = result.licencevicephoto;
       			layer.open({
                       title: '认证信息',
                       type: 1,
                       closeBtn: 1,  // 调试用
                       area: ['600px', '400px'], //宽高
                       content: '<div class="info-content">' +
                           '<div class="content-text"><em>姓名：</em>' + name + '</div>' +
                           '<div class="content-text"><em>性别：</em>' + sex + '</div>' +
                           '<div class="content-text"><em>身份证正面：</em></div>' +
                           '<a href="${pageContext.request.contextPath}/uploads/' + idcardPhoto + '" target="_blank"><img class="content-img" src="${pageContext.request.contextPath}/uploads/' + idcardPhoto + '"></a>' +
                           '<div class="content-text"><em>驾驶证正面：</em></div>' +
                           '<a href="${pageContext.request.contextPath}/uploads/' + licencePhoto + '" target="_blank"><img class="content-img" src="${pageContext.request.contextPath}/uploads/' + licencePhoto + '"></a>' +
                           '<div class="content-text"><em>驾驶证副页：</em></div>' +
                           '<a href="${pageContext.request.contextPath}/uploads/' + licencevicePhoto + '" target="_blank"><img class="content-img" src="${pageContext.request.contextPath}/uploads/' + licencevicePhoto + '"></a>' +
                           '</div>'
                   });
       		}
       	});
    }
    
    // 停用用户
    function stopUser(id) {
        	layer.confirm('确认执行该操作？', {
        		btn: ['确定', '取消']
        	}, function() {
        		// 停用用户
        		window.location.href='${pageContext.request.contextPath}/system/stopUser?id=' + id;
        	}, function() {
        	});
    }
    
    // 启用用户
    function startUser(id) {
        	layer.confirm('确认执行该操作？', {
        		btn: ['确定', '取消']
        	}, function() {
        		// 启用用户
        		window.location.href='${pageContext.request.contextPath}/system/startUser?id=' + id;
        	}, function() {
        	});
    }
    </script>
</body>
</html>
