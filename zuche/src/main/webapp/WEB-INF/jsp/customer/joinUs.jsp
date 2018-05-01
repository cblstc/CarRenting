<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>加盟</title>
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath }/css/common/common.css">
    <link href="${pageContext.request.contextPath }/css/common/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
    <link href="${pageContext.request.contextPath }/css/customer/joinUs.css" rel="stylesheet" type="text/css" media="all" />

    <style>
        .company-input, .name-input, .phone-input, .email-input, .note-input {
            position: relative;
        }
        /* 设置错误提示的样式和位置 */
        label.error {
            position: absolute;
            right: 15px;
            top: 0px;
            color: #ef392b;
            font-size: 12px;
            z-index: 1000000;
        }
        .note-input label.error {
            top: 120px;
        }
    </style>

    <!-- js -->
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery.validation/1.14.0/jquery.validate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery.validation/1.14.0/validate-methods.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common/jquery.validation/1.14.0/messages_zh.js"></script>
</head>

<body>
<!--头部-->
<jsp:include page="../common/public-header.jsp"></jsp:include>


<!-- welcome -->
<div class="welcome">
    <div class="container">
        <h2>欢迎加盟</h2>
        <p class="ever">我们讲竭诚为您服务</p>
        <div class="welcome-grids">
            <div class="col-md-3 welcome-grid">
                <div class="welcome-grd">
                    <div class="icons">
                        <span class="glyphicon glyphicon-home"></span>
                    </div>
                    <h4>广阔平台</h4>
                    <p>我们是一家实力雄厚的租车公司，提供给加盟商非常优质的平台，以人为本，努力提升用户体验</p>
                </div>
            </div>
            <div class="col-md-3 welcome-grid">
                <div class="welcome-grd">
                    <div class="icons">
                        <span class="glyphicon glyphicon-leaf" aria-hidden="true"></span>
                    </div>
                    <h4>优质服务</h4>
                    <p>我们对加盟商提供非常优质和人性化的服务，服务他人，也是服务自己</p>
                </div>
            </div>
            <div class="col-md-3 welcome-grid">
                <div class="welcome-grd">
                    <div class="icons">
                        <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
                    </div>
                    <h4>前景光明</h4>
                    <p>汽车的需求在近几年不断扩大，有理由相信，我们跟上了一个前景光明的时代</p>
                </div>
            </div>
            <div class="col-md-3 welcome-grid">
                <div class="welcome-grd">
                    <div class="icons">
                        <span class="glyphicon glyphicon-send" aria-hidden="true"></span>
                    </div>
                    <h4>加入我们</h4>
                    <p>心动不如行动，赶紧加入我们，和我们取得联系</p>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!-- //welcome -->

<!-- contact -->
<div id="contact" class="contact">
    <div class="container">
        <h3>联系我们</h3>
        <p class="ever">请填写相关信息，方便我们后期与您联系</p>
        <div class="contact-us1-bottom w3layouts-agile">
            <form id="join-form" action="${pageContext.request.contextPath }/joinUs" method="post">
            	<input type="hidden" name="token" value="${token}" />
                <span class="company-input">
                    <input class="company" name="company" type="text" placeholder="公司" required />
                </span>
                <span class="name-input">
                    <input class="name" name="name" type="text" placeholder="姓名" required />
                </span>
                <span class="phone-input">
                    <input class="phone" name="phone" type="text" placeholder="手机" required />
                </span>
                <span class="email-input">
                    <input class="email" name="email" type="text" placeholder="邮箱" required />
                </span>
                <span class="note-input">
                    <textarea class="note" name="note" placeholder="备注"></textarea>
                </span>
                <input type="submit" value="提交" >
            </form>
            <div class="home-radio-clock">
                <ul>
                    <li><i class="glyphicon glyphicon-home" aria-hidden="true"></i>地址</li>
                    <li><i class="glyphicon glyphicon-bullhorn" aria-hidden="true"></i>联系方式</li>
                </ul>
            </div>
            <div class="home-radio-clock-right">
                <ul>
                    <li>广东海洋大学
                        <span>软件学院</span></li>
                    <li class="lst">13432825705</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- //contact -->

<!--尾部-->
<jsp:include page="../common/public-footer.jsp"></jsp:include>


<script>

    /* 自定义验证：判断是否手机格式是否正确 */
    jQuery.validator.addMethod("phone", function (value, element) {
        var regx = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
        return regx.test(value);
    }, "手机格式不正确");
    // 校验
    $('#join-form').validate({
        rules: {
            company: {
                maxlength: 50
            },
            name: {
                maxlength: 20
            },
            phone: {
                phone: true
            },
            email: {
                email: true
            },
            note: {
                maxlength: 200
            }
        },
        messages: {
            company: {
                maxlength: "超过50个字符"
            },
            name: {
                maxlength: "超过20个字符"
            },
            email: {
                email: "邮箱格式不正确"
            },
            note: {
                maxlength: "超过200个字符"
            }
        }
    });
</script>


</body>
</html>
