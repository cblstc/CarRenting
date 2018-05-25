<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>门店列表</title>

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
            <th field="id" width="100">门店编号</th>
            <th field="storename" width="150">门店名称</th>
            <th field="address" width="250">地址</th>
            <th field="phone" width="100">联系电话</th>
            <th field="username" width="100">账号名称</th>
            <th field="status" width="60">门店状态</th>
            <th field="ustatus" width="60">账号状态</th>
            <th field="operate" width="250">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="userStore" items="${storeUserAndStores }">
            <tr>
                <td>${userStore.store.id }</td>
                <td>${userStore.store.storename }</td>
                <td>${userStore.store.address }</td>
                <td>${userStore.store.phone }</td>
                <td>${userStore.storeUser.username }</td>
                <td>
                	<c:choose>
                		<c:when test="${userStore.store.status == 1 }">
                			<span style="color: blue;">可用</span>
                		</c:when>
                		<c:otherwise>
                			<span style="color: red;">已冻结</span>
                		</c:otherwise>
                	</c:choose>
                </td>
                <td>
                	<c:choose>
                		<c:when test="${userStore.storeUser.status == 1 }">
                			<span style="color: blue;">可用</span>
                		</c:when>
                		<c:otherwise>
                			<span style="color: red;">已冻结</span>
                		</c:otherwise>
                	</c:choose>
                </td>
                <td>
                	<a href="javascript:void(0)" onclick="showInfo('${userStore.store}');" class="easyui-linkbutton" iconCls="icon-search" plain="true">详细信息</a>
                	<c:choose>
                		<c:when test="${userStore.store.status == 1 && userStore.storeUser.status == 1}">
			                <a href="javascript:void(0)" onclick="changeStatus('${userStore.store.id }', 'store', 'stop');" class="easyui-linkbutton" iconCls="icon-no" plain="true">停用门店</a>
			                <a href="javascript:void(0)" onclick="changeStatus('${userStore.storeUser.id }', 'storeUser', 'stop');" class="easyui-linkbutton" iconCls="icon-no" plain="true">停用账号</a>
                		</c:when>
                		<c:when test="${userStore.store.status == 1 && userStore.storeUser.status == 2}">
			                <a href="javascript:void(0)" onclick="changeStatus('${userStore.store.id }', 'store', 'stop');" class="easyui-linkbutton" iconCls="icon-no" plain="true">停用门店</a>
			                <a href="javascript:void(0)" onclick="changeStatus('${userStore.storeUser.id }', 'storeUser', 'start');" class="easyui-linkbutton" iconCls="icon-ok" plain="true">启用账号</a>
                		</c:when>
                		<c:when test="${userStore.store.status == 2 && userStore.storeUser.status == 1}">
                			<a href="javascript:void(0)" onclick="changeStatus('${userStore.store.id }', 'store', 'start');" class="easyui-linkbutton" iconCls="icon-ok" plain="true">启用门店</a>
			                <a href="javascript:void(0)" onclick="changeStatus('${userStore.storeUser.id }', 'storeUser', 'stop');" class="easyui-linkbutton" iconCls="icon-no" plain="true">停用账号</a>
                		</c:when>
                		<c:when test="${userStore.store.status == 2 && userStore.storeUser.status == 2}">
                			<a href="javascript:void(0)" onclick="changeStatus('${userStore.store.id }', 'store', 'start');" class="easyui-linkbutton" iconCls="icon-ok" plain="true">启用门店</a>
			                <a href="javascript:void(0)" onclick="changeStatus('${userStore.storeUser.id }', 'storeUser', 'start');" class="easyui-linkbutton" iconCls="icon-ok" plain="true">启用账号</a>
                		</c:when>
                	</c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    
	    <div class="toolbar" style="padding: 20px; position: relative;">
		    <form action="${pageContext.request.contextPath }/system/toStoreList" method="post">
		    	<input type="hidden" name="pageNum" value="1"/>
			        <img src="${pageContext.request.contextPath }/images/system/storename.png"> <input class="storename" name="storename" placeholder="门店名称查询" value="${storename }">&nbsp;&nbsp;
			        <img src="${pageContext.request.contextPath }/images/system/address.png"> <input class="address" name="address" placeholder="地址查询" value="${address }">&nbsp;&nbsp;
			        <img src="${pageContext.request.contextPath }/images/system/phone.png"> <input class="phone" name="phone" placeholder="联系电话查询" value="${phone }">&nbsp;&nbsp;
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
							window.location.href='${pageContext.request.contextPath}/system/toStoreList?pageNum=' + pageNumber + 
							'&storename=${storename }&address=${address }&phone=${phone }';
						}
					"></div>

    <div class="easyui-dialog dlg" style="width:500px;height:260px;padding:10px 20px;"
         closed="true" buttons="#dlg-buttons" pagination="true">
    </div>

    <script>
        /**
         * 查看详情
         */
        function showInfo(store) {
            $(".detail-storename").text(resolveStoreStr(store, "storename"));
            var starttime = resolveStoreStr(store, "starttime");
            var endtime = resolveStoreStr(store, "endtime");
            console.log(starttime);
            console.log(endtime);
            console.log(getTaskTime(starttime));
            $(".detail-time").text(getTaskTime(starttime)+"-"+getTaskTime(endtime));
            $(".detail-address").text(resolveStoreStr(store, "address"));
            $(".detail-description").text(resolveStoreStr(store, "description"));
            $(".detail-traffic").text(resolveStoreStr(store, "traffic"));
            var row = $(".dg").datagrid("getSelected");
            if (row) {
                layer.open({
                    title: '门店详情',
                    type: 1,
                    closeBtn: 1,  // 调试用
                    area: ['600px', '400px'], //宽高
                    content: $('.info-box'),
                    cancel: function(index, layero) {
                        $(".info-box").css("display", "none");  // 隐藏
                    }
                });
            }
        }
        
        /* 解析store el字符串 */
        function resolveStoreStr(store, field) {
        	return store.substring(store.indexOf(field) + (field.length + 1)).split(",")[0];
        }
        
      //Thu Aug 18 20:38:54 CST 2016，时间格式转换  
      //输出格式：HH:mm 
      function getTaskTime(strDate) {   
          if(null==strDate || ""==strDate){  
              return "";  
          }  
          var dateStr=strDate.trim().split(" ");  
          var strGMT = dateStr[0]+" "+dateStr[1]+" "+dateStr[2]+" "+dateStr[5]+" "+dateStr[3]+" GMT+0800";  
          var date = new Date(Date.parse(strGMT));  
          var y = date.getFullYear();  
          var m = date.getMonth() + 1;    
          m = m < 10 ? ('0' + m) : m;  
          var d = date.getDate();    
          d = d < 10 ? ('0' + d) : d;  
          var h = date.getHours();  
          var minute = date.getMinutes();    
          minute = minute < 10 ? ('0' + minute) : minute;  
          var second = date.getSeconds();  
          second = second < 10 ? ('0' + second) : second;  
            
          // return y+"-"+m+"-"+d+" "+h+":"+minute+":"+second;
          return h+":"+minute;
      };
        
        /* 改变状态：启用/停用 */
        function changeStatus(id, table, operate) {
        	layer.confirm('确认执行该操作？', {
        		btn: ['确定', '取消']
        	}, function() {
        		// 启用用户
        		window.location.href='${pageContext.request.contextPath}/system/changeStatus?id=' + id + '&table=' + table + '&operate=' + operate;
        	}, function() {
        	});
        }
    </script>

    <div class="info-box" style="display: none;">
        <div class="info-content">
            <div class="content-text"><em>门店名称：</em><span class="detail-storename">天河门店</span></div>
            <div class="content-text"><em>营业时间：</em><span class="detail-time"><fmt:formatDate value="${store.starttime }" pattern="HH:mm"/>-19:00</span></div>
            <div class="content-text"><em>地址：</em><span class="detail-address">广州市天河区</span></div>
            <div class="content-text"><em>门店详情：</em><span class="detail-description">优惠多多</span></div>
            <div class="content-text"><em>交通：</em><span class="detail-traffic">地铁三号线珠江新城站下车</span></div>
        </div>
    </div>
</body>
</html>
