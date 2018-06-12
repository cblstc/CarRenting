<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="favicon.ico" >
<link rel="Shortcut Icon" href="favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/store/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/store/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/store/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/store/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/store/static/h-ui.admin/css/style.css" />

<!-- webuploader图片上传插件需要引入：bootstrap、font-awesome(字体图标，需要引入font文件夹)、webuploader.css、style.css(定义了进度条的样式) -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/store/lib/webuploader/0.1.5/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/store/lib/webuploader/0.1.5/css/font-awesome.min.css"> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/store/lib/webuploader/0.1.5/webuploader.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/store/lib/webuploader/0.1.5/css/style.css">
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
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>添加车辆</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-article-add" onsubmit="return validateForm();" 
		method="post" action="${pageContext.request.contextPath }/store/saveCar">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>车辆品牌：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="brand" class="brand select" onchange="loadModel(options[this.options.selectedIndex].getAttribute('brandId'))">
					<option value="0">请选择</option>
				</select>
				</span>
				<span class="brandError" style="color: red; font-size:15px;"></span>
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
				<span class="modelError" style="color: red; font-size:15px;"></span>
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
				<span class="confError" style="color: red; font-size:15px;"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>座位数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text seats" value="" id="" name="seats" maxlength="2" placeholder="请输入座位数">
				<span class="seatsError" style="color: red; font-size:15px;"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>门数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text doors" value="" id="" name="doors" maxlength="2" placeholder="请输入门数">
				<span class="doorsError" style="color: red; font-size:15px;"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>排量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text displacement" value="" id="" name="displacement" maxlength="10"  placeholder="请输入排量，如：2.4L">
				<span class="displacementError" style="color: red; font-size:15px;"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>导航仪：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="navigator" class="navigator select">
					<option value="0">请选择</option>
					<option value="1">有</option>
					<option value="2">无</option>
				</select>
				</span>
				<span class="navigatorError" style="color: red; font-size:15px;"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>倒车雷达：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="pdc" class="pdc select">
					<option value="0">请选择</option>
					<option value="1">有</option>
					<option value="2">无</option>
				</select>
				</span>
				<span class="pdcError" style="color: red; font-size:15px;"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>驱动模式：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="drivenmode" class="drivenmode select">
					<option value="0">请选择</option>
					<option value="1">前驱</option>
					<option value="2">后驱</option>
					<option value="3">四驱</option>
				</select>
				</span>
				<span class="drivenmodeError" style="color: red; font-size:15px;"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>油箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text fueltankage" value="" id="" name="fueltankage" maxlength="4"  placeholder="请输入油箱大小">
				<span class="fueltankageError" style="color: red; font-size:15px;"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>变速箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="gearbox" class="gearbox select">
					<option value="0">请选择</option>
					<option value="1">自动</option>
					<option value="2">手动</option>
				</select>
				</span>
				<span class="gearboxError" style="color: red; font-size:15px;"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>天窗：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="skylight" class="skylight select">
					<option value="0">请选择</option>
					<option value="1">有</option>
					<option value="2">无</option>
				</select>
				</span>
				<span class="skylightError" style="color: red; font-size:15px;"></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>安全气囊：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text aircell" value="" id="" name="aircell" maxlength="2"  placeholder="请输入安全气囊个数">
				<span class="aircellError" style="color: red; font-size:15px;"></span>
			</div>
		</div>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 上传</button>

			</div>
		</div> -->
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="photoCommand">单个文件大小<2m，最多5张图片</span>
				<div class="uploader-thum-container">
					<div id="filePicker">选择图片</div>
					<div id="fileList" class="uploader-list"></div>
				</div>
			</div>
		</div>
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>

	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/store/static/h-ui.admin/js/H-ui.admin.page.js"></script> 
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
<script type="text/javascript">
$(function(){
	// 设置只能输入数字
	$(".aircell, .fueltankage, .seats, .doors").bind("keyup", function onlyNumber() {
		this.value=this.value.replace(/\D/g,'');
	});
	loadBrand();  // 加载车辆品牌
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	
	/* $list = $("#fileList"),
	$btn = $("#btn-star"),
	state = "pending",
	uploader; */
	
	// 初始化Web Uploader
    var uploader = WebUploader.create({
        auto: true,  /* 开启自动上传 */
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

    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on( 'uploadSuccess', function( file ) {
        $( '#'+file.id ).addClass('upload-state-done');
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

    // 完成上传完了，成功或者失败，先删除进度条。
    uploader.on( 'uploadComplete', function( file ) {
        $( '#'+file.id ).find('.progress').remove();
    });
    
    /* $("#uploadBtn").on('click', function() {
    	uploader.upload();
    }); */
	
	/* uploader.on('all', function (type) {
        if (type === 'startUpload') {
            state = 'uploading';
        } else if (type === 'stopUpload') {
            state = 'paused';
        } else if (type === 'uploadFinished') {
            state = 'done';
        }

        if (state === 'uploading') {
            $btn.text('暂停上传');
        } else {
            $btn.text('开始上传');
        }
    });

    $btn.on('click', function () {
        if (state === 'uploading') {
            uploader.stop();
        } else {
            uploader.upload();
        }
    }); */
	
	var ue = UE.getEditor('editor');
	
});

// 加载品牌
function loadBrand() {
	$.ajax({
		type: "POST",
   		url: "http://api.jisuapi.com/car/brand",
   		timeout: 3000,  // 超时时间：3秒钟
   		dataType: "JSONP",
   		data: {
   			"appkey": "c625e563100c473b"
   		},
   		success: function(result) {  // 请求成功，加载品牌
   			for (var i=0; i<result.result.length; i++) {
   				var brand = result.result[i].name;
   				var brandId = result.result[i].id;
   				$(".brand").append("<option brandId='" + brandId + "' value='" + brand + "'>" + brand + "</option>");
   			}
   		},
   		error: function(XMLHttpRequest,textStatus){  
   			if (textStatus == "timeout") {  // 请求超时，提示错误
   				// 超时处理
   				layer.msg("无法获取车辆数据，请检查网络或稍后再试！", {
   					closeBtn: 1,
   					icon: 2,
   					time: 10000,
   				});
   			}
   		}
	});
}

// 根据品牌加载车型
function loadModel(id) {
	$.ajax({
		type: "POST",
   		url: "http://api.jisuapi.com/car/type",
   		timeout: 3000,  // 超时时间：3秒钟
   		dataType: "JSONP",
   		data: {
   			"appkey": "c625e563100c473b",
   			"parentid": id
   		},
   		success: function(result) {  // 请求成功，加载车型
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
   		},
   		error: function(XMLHttpRequest,textStatus){  // 请求超时，提示错误
   			if (textStatus == "timeout") {
   				// 超时处理
   				layer.msg("无法获取车辆数据，请检查网络或稍后再试！", {
   					closeBtn: 1,
   					icon: 2,
   					time: 10000,
   				});
   			}
   		}
	});
}

// 根据车型加载配置
function loadConfiguration(id) {
	$.ajax({
		type: "POST",
   		url: "http://api.jisuapi.com/car/car",
   		timeout: 3000,  // 超时时间
   		dataType: "JSONP",
   		data: {
   			"appkey": "c625e563100c473b",
   			"parentid": id
   		},
   		success: function(result) {  // 请求成功，加载车辆配置
			$(".configuration").empty();  // 清空
			$(".configuration").append("<option value='0'>请选择</option>");
   			for (var i=0; i<result.result.list.length; i++) {
   				var configuration = result.result.list[i].name;
   				var conId = result.result.list[i].id;
   				$(".configuration").append("<option value='" + configuration + "'>" + configuration + "</option>");
   			}
   		},
   		error: function(XMLHttpRequest,textStatus){ // 请求超时，提示错误
   			if (textStatus == "timeout") {
   				// 超时处理
   				layer.msg("无法获取车辆数据，请检查网络或稍后再试！", {  
   					closeBtn: 1,
   					icon: 2,
   					time: 10000,
   				});
   			}
   		}
	});
}

// 校验表单
function validateForm() {
	var brand = $.trim($(".brand").val());  // 品牌
	var model = $.trim($(".model").val());  // 车型
	var configuration = $.trim($(".configuration").val());  // 型号
	var seats = $.trim($(".seats").val());  // 座位数
	var doors = $.trim($(".doors").val());  // 车门数
	var displacement = $.trim($(".displacement").val());  // 排量
	var navigator = $.trim($(".navigator").val());  // 导航仪
	var pdc = $.trim($(".pdc").val());  // 倒车雷达
	var drivenmode = $.trim($(".drivenmode").val());  // 驱动模式
	var fueltankage = $.trim($(".fueltankage").val());  // 油箱
	var gearbox = $.trim($(".gearbox").val());  // 变速箱
	var skylight = $.trim($(".skylight").val());  // 天窗
	var aircell = $.trim($(".aircell").val());  // 安全气囊
	
	/* 品牌非空校验 */
	if (brand == 0) {
		$(".brandError").text("请选择品牌");
		return false;
	} else {
		$(".brandError").text("");
	}
	
	/* 车型非空校验 */
	if (model == 0) {
		$(".modelError").text("请选择车型");
		return false;
	} else {
		$(".modelError").text("");
	}
	
	/* 座位数非空校验 */
	if (seats == "") {
		$(".seatsError").text("请输入座位数");
		return false;
	} else {
		$(".seatsError").text("");
	}
	
	/* 门数非空校验 */
	if (doors == "") {
		$(".doorsError").text("请输入门数");
		return false;
	} else {
		$(".doorsError").text("");
	}
	
	/* 排量非空校验 */
	if (displacement == "") {
		$(".displacementError").text("请输入排量");
		return false;
	} else {
		$(".displacementError").text("");
	}
	
	/* 导航仪非空校验 */
	if (navigator == 0) {
		$(".navigatorError").text("请选择导航仪");
		return false;
	} else {
		$(".navigatorError").text("");
	}

	/* 倒车雷达非空校验 */
	if (pdc == 0) {
		$(".pdcError").text("请选择倒车雷达");
		return false;
	} else {
		$(".pdcError").text("");
	}
	
	/* 驱动模式非空校验 */
	if (drivenmode == 0) {
		$(".drivenmodeError").text("请选择驱动模式");
		return false;
	} else {
		$(".drivenmodeError").text("");
	}
	
	/* 油箱非空校验 */
	if (fueltankage == "") {
		$(".fueltankageError").text("请输入油箱大小");
		return false;
	} else {
		$(".fueltankageError").text("");
	}
	
	/* 变速箱非空校验 */
	if (gearbox == 0) {
		$(".gearboxError").text("请选择变速箱类型");
		return false;
	} else {
		$(".gearboxError").text("");
	}
	
	/* 天窗非空校验 */
	if (skylight == 0) {
		$(".skylightError").text("请选择是否有天窗");
		return false;
	} else {
		$(".skylightError").text("");
	}
	
	/* 安全气囊非空校验 */
	if (aircell == "") {
		$(".aircellError").text("请输入安全气囊个数");
		return false;
	} else {
		$(".aircellError").text("");
	}
	return true;
}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
