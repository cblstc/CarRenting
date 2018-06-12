<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!--_meta 作为公共模版分离出去-->
<jsp:include page="_meta.jsp"></jsp:include>
<!--/meta 作为公共模版分离出去-->

<!-- webuploader图片上传插件需要引入：bootstrap、font-awesome(字体图标，需要引入font文件夹)、webuploader.css、login.css(定义了进度条的样式) -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/store/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/store/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/store/lib/webuploader/0.1.5/webuploader.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/store/css/style.css">
<style>
	/* 上传图片要求  */
	.photoCommand {
		font-size: 14px;
	}
	/* 设置图片上传按钮的风格  */
	.webuploader-pick {
		padding: 6px;
		font-size: 15px;
		margin: 10px 0 10px 0;
	}
	/* 设置进度条的长度 */
	.progress {
		width: 100px;
	}
</style>

<title>车辆添加</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-car-add" target="_parent"
		  method="post" action="${pageContext.request.contextPath }/store/saveCar">
		  <input type="hidden" name="id" value="${storeCar.id }">
		  <input type="hidden" class="carphoto" name="carphoto" value="${storeCar.carphoto }">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>车辆品牌：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="brand" class="brand select" onchange="loadModel(options[this.options.selectedIndex].getAttribute('brandId'))">
					<option value="0">请选择</option>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>车型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="model" class="model select" onchange="loadConfiguration(options[this.options.selectedIndex].getAttribute('modelId'))">
					<option value="0">请选择</option>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">配置：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="configuration" class="configuration select">
					<option value="0">请选择</option>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>座位数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text seats" value="${storeCar.seats }" required name="seats" maxlength="2" placeholder="请输入座位数">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>门数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text doors" value="${storeCar.doors }" required name="doors" maxlength="2" placeholder="请输入门数">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>排量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text displacement" value="${storeCar.displacement }" required name="displacement" maxlength="10"  placeholder="请输入排量，如：2.4L">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>导航仪：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="navigator" class="navigator select">
					<option value="0">请选择</option>
					<option value="1" <c:if test="${storeCar.navigator == 1 }">selected</c:if>>有</option>
					<option value="2"  <c:if test="${storeCar.navigator == 2 }">selected</c:if>>无</option>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>倒车雷达：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="pdc" class="pdc select">
					<option value="0">请选择</option>
					<option value="1" <c:if test="${storeCar.pdc == 1 }">selected</c:if>>有</option>
					<option value="2" <c:if test="${storeCar.pdc == 2 }">selected</c:if>>无</option>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>驱动模式：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="drivenmode" class="drivenmode select">
					<option value="0">请选择</option>
					<option value="1" <c:if test="${storeCar.drivenmode == 1 }">selected</c:if>>前驱</option>
					<option value="2" <c:if test="${storeCar.drivenmode == 2 }">selected</c:if>>后驱</option>
					<option value="3" <c:if test="${storeCar.drivenmode == 3 }">selected</c:if>>四驱</option>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>油箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text fueltankage" name="fueltankage" value="${storeCar.fueltankage }" maxlength="4"  placeholder="请输入油箱大小">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>变速箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="gearbox" class="gearbox select">
					<option value="0">请选择</option>
					<option value="1" <c:if test="${storeCar.gearbox == 1 }">selected</c:if>>自动</option>
					<option value="2" <c:if test="${storeCar.gearbox == 2 }">selected</c:if>>手动</option>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>天窗：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="skylight" class="skylight select">
					<option value="0">请选择</option>
					<option value="1" <c:if test="${storeCar.skylight == 1 }">selected</c:if>>有</option>
					<option value="2" <c:if test="${storeCar.skylight == 2 }">selected</c:if>>无</option>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>安全气囊：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text aircell" value="${storeCar.aircell }" required name="aircell" maxlength="2"  placeholder="请输入安全气囊个数">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>日均价：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text price" value="${storeCar.price }" required name="price" maxlength="10"  placeholder="请输入租赁一天的价格(元)">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>基本保险：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text insurance" value="${storeCar.insurance }" required name="insurance" maxlength="10"  placeholder="请输入租赁一天的基本保险(元)">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>不计免赔险：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text nodeductibles" value="${storeCar.nodeductibles }" required name="nodeductibles" maxlength="10"  placeholder="请租赁一天的不计免赔险(元)">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>数量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text count" value="${storeCar.count }" required name="count" maxlength="10"  placeholder="请输入车辆的数量">
			</div>
		</div>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 上传</button>

			</div>
		</div> -->
		
		<c:if test="${storeCar.id == null }">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="photoCommand">单个文件大小<2m，最多5张图片</span>
				<div class="uploader-thum-container">
					<div id="filePicker">选择图片</div>
					<div id="fileList" class="uploader-list">
						<%-- <c:forEach var="carphoto" items="${fn:split(storeCar.carphoto, ';') }">
							<div id=""  class="file-item thumbnail">
								<img width="100" height="100" src="${pageContext.request.contextPath }/uploads/${carphoto }">
							</div>
						</c:forEach> --%>
					</div>
				</div>
			</div>
		</div>
		</c:if>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<jsp:include page="_footer.jsp"></jsp:include>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/jquery.validation/1.14.0/messages_zh.js"></script>   
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/ueditor/1.4.3/ueditor.config.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/ueditor/1.4.3/ueditor.all.min.js"> </script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<!-- 品牌、车型、配置三级联动 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/js/brandToModelToConf.js"></script>

<script type="text/javascript">
$(function(){
    // 设置只能输入数字
    $(".aircell, .fueltankage, .seats, .doors, .count").bind("keyup", function onlyNumber() {
        this.value=this.value.replace(/\D/g,'');
    });

    // 设置只能输入数字和小数点，但不保证小数格式正确，所以还要在提交的时候判断
    $(".price, .insurance, .nodeductibles").bind("keyup", function onlyNumber() {
        this.value=this.value.replace(/[^\d.]/g,'');
    });

    loadBrand();  // 加载车辆品牌

	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});

    // 使用web uploader插件，初始化Web Uploader
    var uploader = WebUploader.create({
        auto: false,  /* 开启自动上传 */
        swf: '${pageContext.request.contextPath }/jsp/store/lib/ueditor/1.4.3/third-party/webuploader/Uploader.swf', /* swf文件路径 */
        server: '${pageContext.request.contextPath }/store/uploads',  /* 服务器处理路径 */

        // 选择文件的按钮。可选。
        // 内部根据当前运行时创建，可能是input元素，也可能是flash.
        pick: '#filePicker',

        // 只允许选择图片文件。
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        },

        fileNumLimit: 5,  /* 最多上传5张图片 */
        fileSingleSizeLimit: 2 * 1024 * 1024,  /* 每张图片大小不超过2m */
        fileVal: 'file' /* 设置上传图片的name属性：默认file  */
    });
    
    // 当有文件添加进来的时候
    uploader.on( 'fileQueued', function( file ) {
        var $list = $("#fileList");
        var $li = $(
            '<div id="' + file.id + '" class="file-item thumbnail">' +
            '<img>' +
            '<div class="info">' + file.name + '</div>' +
            '</div>'
            ),
            $img = $li.find('img');

        // $list为容器jQuery实例
        $list.append( $li );

        // 创建缩略图
        // 如果为非图片文件，可以不用调用此方法。
        // thumbnailWidth x thumbnailHeight 为 100 x 100
        var thumbnailWidth = 100;
        var thumbnailHeight = 100;
        uploader.makeThumb( file, function( error, src ) {
            if ( error ) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr( 'src', src );
        }, thumbnailWidth, thumbnailHeight );
    });

    // 文件上传过程中创建进度条实时显示。
    uploader.on( 'uploadProgress', function( file, percentage ) {
        var $li = $( '#'+file.id ),
            $percent = $li.find('.progress span');

        // 避免重复创建
        if ( !$percent.length ) {
            $percent = $('<p class="progress"><span></span></p>')
                .appendTo( $li )
                .find('span');
        }

        $percent.css( 'width', percentage * 100 + '%' );
    });
    
 	// 完成上传完了，成功或者失败，先删除进度条。x
    uploader.on( 'uploadComplete', function( file ) {
    	$( '#'+file.id ).find('.progress').remove();
    });

    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on( 'uploadSuccess', function( file, response ) {
        // $( '#'+file.id ).addClass('upload-state-done');
        var carphoto = $(".carphoto").val();
        var filename = response.fileName;  // 上传的文件名
        if (carphoto == "") {
        	carphoto = filename;
        } else {
        	carphoto = carphoto + ";" + filename;
        }
        $(".carphoto").val(carphoto);
    });

    // 文件上传失败，显示上传出错。
    uploader.on( 'uploadError', function( file ) {
        var $li = $( '#'+file.id ),
            $error = $li.find('div.error');

        // 避免重复创建
        if ( !$error.length ) {
            $error = $('<div class="error"></div>').appendTo( $li );
        }

        $error.text('上传失败');
    });
	
    
	/* var ue = UE.getEditor('editor'); */
	
    /* 自定义验证：判断下拉框是否选中 */
    jQuery.validator.addMethod("isSelect", function (value, element) {
		return value != "0";
    }, "请选择一个选项");
    /* 自定义验证：判断数字是否是合法的正数 */
    jQuery.validator.addMethod("isPositive", function (value, element) {
        var regx = /^\d+(\.\d{1,2})?$/;
        return regx.test(value);
    }, "只能输入正整数或两位以内的小数");

    /* 表单校验 */
    $("#form-car-add").validate({
		rules: {
			brand: "isSelect",
            model: "isSelect",
            navigator: "isSelect",
            pdc: "isSelect",
            drivenmode: "isSelect",
            gearbox: "isSelect",
            skylight: "isSelect",
            price: "isPositive",
            insurance: "isPositive",
            nodeductibles: "isPositive"
        }, 
        submitHandler: function(form) {
        	layer.msg("正在上传图片，请稍等...");
        	uploader.upload();  // 开始上传
        	uploader.on("uploadFinished", function() {
        		form.submit(); // 所有文件上传成功后提交
        	});
        }
	});
});

/* 加载meta */
$.ajax({
    url : "_meta.html",
    cache : true,
    async : false,
    success : function(html) {
        $(".meta-box").html(html);
    }
});
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>

<!--
@Todo 非常棘手的图片上传
@Todo 提交表单
-->
