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
    <title>车辆列表</title>

    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/common.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/themes/default/easyui.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/themes/icon.css" type="text/css">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/common/jquery.fileupload.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/spinners.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/system/carList.css" type="text/css">

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
                <th field="id" width="60">车辆编号</th>
                <th field="brand" width="60">品牌</th>
                <th field="model" width="60">车型</th>
                <th field="configuration" width="150">配置</th>
                <th field="seats" width="50">座位数</th>
                <th field="doors" width="40">门数</th>
                <th field="displacement" width="40">排量</th>
                <th field="navigator" width="50">导航仪</th>
                <th field="pdc" width="60">倒车雷达</th>
                <th field="drivenmode" width="60">驱动模式</th>
                <th field="fueltankage" width="40">油箱</th>
                <th field="gearbox" width="50">变速箱</th>
                <th field="skylight" width="40">天窗</th>
                <th field="aircell" width="60">安全气囊</th>
                <th field="operate" width="200">操作</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="garage" items="${garages }">
            <tr>
                <td>${garage.id }</td>
                <td>${garage.brand }</td>
                <td>${garage.model }</td>
                <td>${garage.configuration }</td>
                <td>${garage.seats }</td>
                <td>${garage.doors }</td>
                <td>${garage.displacement }</td>
                <td>${garage.navigator }</td>
                <td>${garage.pdc }</td>
                <td>${garage.drivenmode }</td>
                <td>${garage.fueltankage }</td>
                <td>${garage.gearbox }</td>
                <td>${garage.skylight }</td>
                <td>${garage.aircell }</td>
                <td>
                    <a href="javascript:void(0)" onclick="showImg('${garage.id }', '${garage.carphoto }');" class="easyui-linkbutton" iconCls="icon-search" plain="true">图片</a>
                    <a href="javascript:void(0)" onclick="removeCar('${garage.id }');" class="easyui-linkbutton" iconCls="icon-no" plain="true">删除</a>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="toolbar" style="padding: 20px; position: relative;">
        <a href="#" id="passBtn" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addCar()">添加</a>
        <a href="#" id="failBtn" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editCar()">修改</a><br/><br/>

		<form action="${pageContext.request.contextPath}/system/toCarList" method="post">
	    	<input type="hidden" name="pageNum" value="1"/>
	        <img src="${pageContext.request.contextPath}/images/system/brand.png"> <input name="brand" value="${brand }" placeholder="品牌查询">&nbsp;&nbsp;
	        <img src="${pageContext.request.contextPath}/images/system/model.png"> <input name="model" value="${model }" placeholder="车型查询">&nbsp;&nbsp;
	        <img src="${pageContext.request.contextPath}/images/system/configuration.png"> <input name="configuration" value="${configuration }" placeholder="配置查询">
	        <input type="submit" value="查询" style="background:#0089dc; color: #fff; border: 0; border-radius: 3%;">
	    </form>
        
        <div class="easyui-pagination" style="position: absolute; top:0; right:0;" data-options="
						total: ${total },
						pageSize: 5,  // 每页记录
						pageNumber: ${pageNum },  // 当前页码
						showPageList: false,
						showRefresh: false,
						displayMsg: '',
						onSelectPage: function(pageNumber, pageSize) {
							window.location.href='${pageContext.request.contextPath}/system/toCarList?pageNum=' + pageNumber + 
							'&brand=${brand }&model=${model }&configuration=${configuration }';
						}
					"></div>
    </div>

    <div class="easyui-dialog dlg" style="width:500px;height:260px;padding:10px 20px;"
         closed="true" buttons="#dlg-buttons" pagination="true">
    </div>
    <script>
        function addCar() {
            openEdit("添加汽车");
        }
        
        function editCar() {
            var row = $(".dg").datagrid("getSelected");
            if (row) {
                openEdit("修改汽车");
                setTimeout(function(){
	                $(".info-content").form("load", row);  
	                loadModel($(".brand").find("option:selected").attr("brandId"));  // 加载车型
                }, 1000);
                setTimeout(function(){
                	$(".info-content").form("load", row);  
	                loadConfiguration($(".model").find("option:selected").attr("modelId"));  // 加载配置
                }, 3000);
                setTimeout(function(){
                	$(".info-content").form("load", row);
                }, 3000);
                $(".id").val(row.id);
            }
        }
        
        // 打开编辑
        function openEdit(title) {
        	$.ajax({
        		type: "POST",
           		url: "http://api.jisuapi.com/car/brand",
           		dataType: "JSONP",
           		data: {
           			"appkey": "c625e563100c473b"
           		},
           		success: function(result) {
           			for (var i=0; i<result.result.length; i++) {
           				var brand = result.result[i].name;
           				var brandId = result.result[i].id;
           				$(".brand").append("<option brandId='" + brandId + "' value='" + brand + "'>" + brand + "</option>");
           			}
           		}
        	});
        	openEditDialog(title);  // 打开窗口
        }
        
        // 加载车型
        function loadModel(id) {
        	$.ajax({
        		type: "POST",
           		url: "http://api.jisuapi.com/car/type",
           		dataType: "JSONP",
           		data: {
           			"appkey": "c625e563100c473b",
           			"parentid": id
           		},
           		success: function(result) {
           			$(".model").empty();  // 清空
           			$(".model").append("<option value='0'>请选择</option>");
           			$(".configuration").empty();  // 清空
        			$(".configuration").append("<option value='0'>请选择</option>");
           			for (var i=0; i<result.result.length; i++) {
           				for (var j=0; j<result.result[i].list.length; j++) {
	           				var model = result.result[i].list[j].fullname;
	           				var modelId = result.result[i].list[j].id;
	           				$(".model").append("<option modelId='" + modelId + "' value='" + model + "'>" + model + "</option>");
           				}
           			}
           		}
        	});
        }
        
        // 加载配置
        function loadConfiguration(id) {
        	$.ajax({
        		type: "POST",
           		url: "http://api.jisuapi.com/car/car",
           		dataType: "JSONP",
           		data: {
           			"appkey": "c625e563100c473b",
           			"parentid": id
           		},
           		success: function(result) {
        			$(".configuration").empty();  // 清空
        			$(".configuration").append("<option value='0'>请选择</option>");
           			for (var i=0; i<result.result.list.length; i++) {
           				var configuration = result.result.list[i].name;
           				var conId = result.result.list[i].id;
           				$(".configuration").append("<option value='" + configuration + "'>" + configuration + "</option>");
           			}
           		}
        	});
        }
        
        // 打开编辑窗口
        function openEditDialog(title) {
        	layer.open({
                title: title,
                type: 1,
                closeBtn: 1,  // 调试用
                area: ['600px', '400px'], //宽高
                content:
                '<form action="${pageContext.request.contextPath}/system/saveGarage" onsubmit="return validateForm();" method="post" class="info-content">' +
                '<input type="hidden" class="id" name="id">' +
                '<table>' +
                    '<tr>' +
                        '<td>品牌</td>' +
                        '<td><select class="brand" name="brand" onchange="loadModel(options[this.options.selectedIndex].getAttribute(\'brandId\'))">' +
                                '<option value="0">请选择</option>' +
                            '</select></td>' +
                    '</tr>' +
                    '<tr>' +
                        '<td>车型</td>' +
                        '<td><select class="model" name="model" onchange="loadConfiguration(options[this.options.selectedIndex].getAttribute(\'modelId\'))">' +
                                '<option value="0">请选择</option>' +
                        '</select></td>' +
                    '</tr>' +
                    '<tr>' +
                        '<td>配置</td>' +
                        '<td><select class="configuration" name="configuration">' +
                            '<option value="0">请选择</option>' +
                        '</select></td>' +
                    '</tr>' +
                    '<tr>' +
                        '<td>座位数</td>' +
                        '<td><input class="seats" name="seats" required placeholder="输入座位数" maxlength="2"></td>' +
                    '</tr>' +
                    '<tr>' +
                        '<td>车门数</td>' +
                        '<td><input class="doors" name="doors" required placeholder="输入车门数" maxlength="2"></td>' +
                    '</tr>' +
                    '<tr>' +
                        '<td>排量</td>' +
                        '<td><input name="displacement" required placeholder="输入排量" maxlength="10"></td>' +
                    '</tr>' +
                    '<tr>' +
                        '<td>导航仪</td>' +
                        '<td><input id="has-nav" checked name="navigator" value="1" type="radio"><label for="has-nav">有</label>' +
                            '<input id="no-nav" name="navigator" value="2" type="radio"><label for="no-nav">无</label></td>' +
                    '</tr>' +
                    '<tr>' +
                        '<td>倒车雷达</td>' +
                        '<td><input id="has-pdc" checked name="pdc" value="1" type="radio"><label for="has-pdc">有</label>' +
                            '<input id="no-pdc" name="pdc" value="2" type="radio"><label for="no-pdc">无</label></td>' +
                    '</tr>' +
                    '<tr>' +
                        '<td>驱动模式</td>' +
                        '<td><select class="drivenmode" name="drivenmode">' +
                            '<option value="0">请选择</option>' +
                            '<option value="1">前驱</option>' +
                            '<option value="2">后驱</option>' +
                            '<option value="3">四驱</option>' +
                        '</select></td>' +
                    '</tr>' +
                    '<tr>' +
                        '<td>油箱</td>' +
                        '<td><input class="fueltankage" name="fueltankage" required placeholder="输入油箱大小" maxlength="3"></td>' +
                    '</tr>' +
                    '<tr>' +
                        '<td>变速箱</td>' +
                        '<td><select class="gearbox" name="gearbox">' +
                            '<option value="0">请选择</option>' +
                            '<option value="1">自动挡</option>' +
                            '<option value="2">手动挡</option>' +
                        '</select></td>' +
                    '</tr>' +
                    '<tr>' +
                        '<td>天窗</td>' +
                        '<td><input id="has-sky" checked name="skylight" value="1" type="radio"><label for="has-sky">有</label>' +
                            '<input id="no-sky" name="skylight" value="2" type="radio"><label for="no-sky">无</label></td>' +
                    '</tr>' +
                    '<tr>' +
                        '<td>安全气囊</td>' +
                        '<td><input class="aircell" name="aircell" required placeholder="输入安全气囊数量" maxlength="2"></td>' +
                    '</tr>' +
                '</table>' +
                '<input type="submit" value="提交" />' + 
                '</form>'
            });
        	
        	$(".aircell, .fueltankage, .seats, .doors").bind("keyup", function onlyNumber() {
        		this.value=this.value.replace(/\D/g,'');
        	});
    	}
        
        // 校验表单
        function validateForm() {
        	var brand = $.trim($(".brand").val());
        	var model = $.trim($(".model").val());
        	var configuration = $.trim($(".configuration").val());
        	var drivenmode = $.trim($(".drivenmode").val());
        	var gearbox = $.trim($(".gearbox").val());
        	if (brand == 0) {
        		layer.msg("请选择品牌");
        		return false;
        	}
        	if (model == 0) {
        		layer.msg("请选择型号");
        		return false;
        	}
        	if (configuration == 0) {
        		layer.msg("请选择配置");
        		return false;
        	}
        	if (drivenmode == 0) {
        		layer.msg("请选择驱动模式");
        		return false;
        	}
        	if (gearbox == 0) {
        		layer.msg("请选择变速箱");
        		return false;
        	}
        	return true;
        }
        
     // 图片上传和预览
 	function imgUploadAndPreview(inputBtn, id){
 		var imgError = $(".imgError");
         // 判断图片格式
 		var photoPath = $(inputBtn).val();
 		var photoSuffix = photoPath.substring(photoPath.lastIndexOf(".") + 1).toLowerCase();
 		if (photoSuffix != "jpg" && photoSuffix != "jpeg" && photoSuffix != "bmp" && 
 			photoSuffix != "gif" && photoSuffix != "png" ) {
 			layer.msg("格式错误");
 			return;
 		} else {
 			$(imgError).text("");
 		}
 		// 判断图片大小
 		var photoSize = $(inputBtn).get(0).files[0].size / 1024;  // kb
 		if (photoSize >= 2048) {
 			layer.msg("大小超过2m");
 			return;			
 		} else {
 			$(imgError).text();
 		}
 		
 		// 是否超过5张图片
		var photoCount = $(".img-box").find(".preview-box").length;
 		if (photoCount >= 5) {
 			layer.msg("超过5张");
 			return;
 		}
 		
 		//判断是否支持FileReader
         if (window.FileReader) {
             var reader = new FileReader();
         } else {
             alert("您的设备不支持图片上传和预览功能，请更新您的设备！");
             return;
         }
 		
 		var imgDiv = '<div class="preview-box">' +
 			'<img class="preview" />' + 
 			'<span class="spinner-loader"></span>' +
 		'</div>';
 		
 		// 异步上传
 		var formData = new FormData($("#imgUploadForm"));
 		formData.append("photo", $(inputBtn).get(0).files[0]);
 		formData.append("id", id);
          	
 		$.ajax({
 			type: "POST",
 			url: "${pageContext.request.contextPath }/system/uploadPhoto",
 			async: true,
 			data: formData,
 			contentType: false,
             processData: false,
             beforeSend: function() {
            	 $(".img-box").append(imgDiv);
             	 // 缓冲
             },
 			success: function(result) {
 				//读取完成
 		        reader.readAsDataURL(inputBtn.files[0]);
 		        reader.onload = function(e) {
 		            //图片路径设置为读取的图片
 		            $(".preview-box:last-child .preview").attr("src",e.target.result);
 		         	// 结束缓冲
 		         	$(".preview-box:last-child .spinner-loader").css("display", "none");
 		        };
 				//提示层
 				layer.msg("上传成功");
 			}
 		});
     }
     
    /**
     * 查看图片
      */
    function showImg(id, carphoto) {
		layer.open({
            title: '车辆图片',
            type: 1,
            closeBtn: 1,  // 调试用
            area: ['600px', '200px'], //宽高
            content: '<div class="img-content">' +
           	'<span class="fileinput-button">上传<input class="carphoto" type="file" multiple name="carphoto" onchange="imgUploadAndPreview(this, ' + id + 
           			')" /></span>' +
		    '<div class="red-text">最多5张，支持jpg/jpeg/bmp/png/gif格式，不大于2m的图片</div>' +
    		'<div class="img-box"></div>' +
		    '<form id="imgUploadForm"></form>' +
            '</div>'
        });
		
		// 加载图片
		if (carphoto != null && carphoto != "") {
			var carphotos = carphoto.split(";");
	    	for (var i=0; i<carphotos.length; i++) {
	    		var imgDiv = '<div class="preview-box">' + 
	    		'<img class="preview" src="${pageContext.request.contextPath}/uploads/' + carphotos[i] + 
	    		'" /></div>';
				$(".img-box").append(imgDiv);
	    	}
		}
    }
    
    /**
     * 删除汽车
      */
   function removeCar(id) {
      	layer.confirm('确认执行该操作？', {
	      		btn: ['确定', '取消']
	      	}, function() {
	      		window.location.href='${pageContext.request.contextPath}/system/removeCar?id=' + id;
	      	}, function() {
      	});
   }

   
    </script>
</body>
</html>
