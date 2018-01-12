$(function () {
    $(".nav-text").removeClass("active");
    $(".improve-text").addClass("active");

    setInterval("setTime()", 1000);
});

/**
 * 动态加载时间
 */
function setTime() {
    // 动态加载时间
    var now = new Date();
    var month = now.getMonth() + 1;
    var day = now.getDate();
    var hours = now.getHours();
    var minutes = now.getMinutes();
    var seconds = now.getSeconds();
    if (hours.toString().length == 1) {
        hours = "0" + hours;
    }
    if (minutes.toString().length == 1) {
        minutes = "0" + minutes;
    }
    if (seconds.toString().length == 1) {
        seconds = "0" + seconds;
    }
    $(".month").text(month + "月");
    $(".day").text(day + "日");
    $(".current-time").text(hours + ":" + minutes + ":" + seconds);
}









/**
 * 打开修改密码框
 */
function openEditPassword() {
    // 修改密码
    layer.open({
        title: '修改密码',
        type: 1,
        closeBtn: 1,  // 调试用
        area: ['480px', '280px'], //宽高
        content: '<div class="dialog-content">' +
        '<span class="dialog-span">旧密码</span>' +
        '<input class="dialog-input" placeholder="请输入旧的密码"><br/>' +
        '<span class="red-text dialog-error">密码格式错误</span><br/>' +
        '<span class="dialog-span">新密码</span>' +
        '<input class="dialog-input" placeholder="请输入新的密码"><br/>' +
        '<span class="red-text dialog-error">密码格式错误</span><br/>' +
        '<input class="dialog-btn" type="submit" value="修改">' +
        '</div>'
    });
}