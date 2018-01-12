/**
 * 价格区间切换
 * @param link 链接
 * @param minPrice 最低价
 * @param maxPrice 最高价
 */
function selectPrice(link, minPrice, maxPrice) {
    var div = $(link).find("div").get(0);
    // line初始化灰色
    $(".price-line-common").css("border-bottom", "5px solid #E9EBEE");
    // 指定line黄色
    $(div).css("border-bottom", "5px solid #fabe00");

    // 价格初始化灰色
    $(".price-text span").css("color", "#93939E");
    // 指定最低价格和最高价格黄色
    $(minPrice).css("color", "#fabe00");
    $(maxPrice).css("color", "#fabe00");
}

/**
 * 品牌切换
 * @param link
 */
function selectBrand(link) {
    var p = $(link).find("p").get(0);
    // 初始化字体颜色灰色
    $(".brand-name-common").css("color", "#93939e");
    // 指定选中字体黄色
    $(p).css("color", "#fabe00");
}

/**
 * 开关切换
 * @param link 链接
 */
function switchChange(link) {
    var img = $(link).find("img").get(0);
    if ($(img).attr("alt") == "switch-on") {
        // 如果初始化是开状态，那么关
        $(img).attr("src", "../../images/switch-off.png");
        $(img).attr("alt", "switch-off");
    } else {
        $(img).attr("src", "../../images/switch-on.png");
        $(img).attr("alt", "switch-on");
    }
}