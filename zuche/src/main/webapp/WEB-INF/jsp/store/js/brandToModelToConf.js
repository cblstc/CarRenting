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