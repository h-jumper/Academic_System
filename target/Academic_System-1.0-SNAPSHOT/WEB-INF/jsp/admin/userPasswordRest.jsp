<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 顶栏 -->
<jsp:include page="top.jsp"></jsp:include>
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">重置其他用户密码</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" name="form" role="form" action="/admin/userPasswordRest" id="editfrom" method="post" onsubmit="return check()">
                        <div id="userName" class="form-group has-feedback">
                            <label for="inputUserName" class="col-sm-3 control-label">账号(非管理员账号)</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="userName" id="inputUserName" placeholder="请输入用户名">
                                <span id="userNameSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
                            </div>
                            <span id="userNameCheck" class="col-sm-2 form-control-static" style="color: red"></span>
                        </div>
                        <div id="password" class="form-group has-feedback">
                            <label for="inputPassword" class="col-sm-3 control-label">密码</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" id="inputPassword" placeholder="请输入密码" name="password">
                                <span id="passwordSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
                            </div>
                            <span id="passwordCheck" class="col-sm-2 form-control-static" style="color: red"></span>
                        </div>
                        <div id="password2" class="form-group has-feedback">
                            <label for="inputPassword2" class="col-sm-3 control-label">确认密码</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" id="inputPassword2" placeholder="请再次输入密码" name="password2">
                                <span id="password2Span" class="glyphicon form-control-feedback" aria-hidden="true"></span>
                            </div>
                            <span id="password2Check" class="col-sm-2 form-control-static" style="color: red"></span>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default" type="submit">提交</button>
                            <button class="btn btn-default" type="reset" onclick="rs()">重置</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container" id="footer">
    <div class="row">
        <div class="col-md-12"></div>
    </div>
</div>
</body>
<script>
    $("#nav li:nth-child(4)").addClass("active")

    function check() {
        var flag = true;
        if (form.userName.value == "" || form.userName.value == null) {
            $("#userName").addClass("has-error");
            $("#userNameSpan").addClass("glyphicon-remove");
            flag = false;
        }
        if (form.password.value == "" || form.password.value == null) {
            $("#password").addClass("has-error");
            $("#passwordSpan").addClass("glyphicon-remove");
            flag = false;
        }
        if (form.password2.value == "" || form.password2.value == null) {
            $("#password2").addClass("has-error");
            $("#password2Span").addClass("glyphicon-remove");
            flag = false;
        }
        if ($("#userName").hasClass("has-error"))
            flag = false;
        if ($("#password").hasClass("has-error"))
            flag = false;
        return flag;
    }

    $(function () {
        $("#inputUserName").focus(function () {
            $("#userName").removeClass("has-error has-success");
            $("#userNameSpan").removeClass("glyphicon-remove glyphicon-ok");
            $("#userNameCheck").text("");
        }).blur(function () {
            if (form.userName.value == "" || form.userName.value == null) {
                $("#userName").addClass("has-error");
                $("#userNameSpan").addClass("glyphicon-remove");
            } else {
                $.get({
                    url: "/admin/usePasswordRestCheck",
                    data: {"userName": $("#inputUserName").val()},
                    success: function (data) {
                        if (data == "true") {
                            $("#userName").addClass("has-success");
                            $("#userNameSpan").addClass("glyphicon-ok");
                        } else {
                            $("#userName").addClass("has-error");
                            $("#userNameSpan").addClass("glyphicon-remove");
                            $("#userNameCheck").text("没有此账号");
                        }
                    }
                })
            }
        });

        $("#inputPassword").focus(function () {
            $("#password").removeClass("has-error has-success");
            $("#passwordSpan").removeClass("glyphicon-remove glyphicon-ok");
        }).blur(function () {
            if (form.password.value == "" || form.password.value == null) {
                $("#password").addClass("has-error");
                $("#passwordSpan").addClass("glyphicon-remove");
            }else if (form.password2.value != "" && form.password2.value != null){
                if(form.password.value == form.password2.value){
                    $("#password").removeClass("has-error has-success").addClass("has-success");
                    $("#passwordSpan").removeClass("glyphicon-remove glyphicon-ok").addClass("glyphicon-ok");
                    $("#password2").removeClass("has-error has-success").addClass("has-success");
                    $("#password2Span").removeClass("glyphicon-remove glyphicon-ok").addClass("glyphicon-ok");
                    $("#passwordCheck").text("");
                    $("#password2Check").text("");
                }else{
                    $("#password").removeClass("has-error has-success").addClass("has-error");
                    $("#passwordSpan").removeClass("glyphicon-remove glyphicon-ok").addClass("glyphicon-remove");
                    $("#password2").removeClass("has-error has-success").addClass("has-error");
                    $("#password2Span").removeClass("glyphicon-remove glyphicon-ok").addClass("glyphicon-remove");
                    $("#passwordCheck").text("两次密码不一致");
                    $("#password2Check").text("两次密码不一致");
                }x
            }
        });

        $("#inputPassword2").focus(function () {
            $("#password2").removeClass("has-error has-success");
            $("#password2Span").removeClass("glyphicon-remove glyphicon-ok");
        }).blur(function () {
            if (form.password2.value == "" || form.password2.value == null) {
                $("#password2").addClass("has-error");
                $("#password2Span").addClass("glyphicon-remove");
            }else if (form.password.value != "" && form.password.value != null){
                if(form.password.value == form.password2.value){
                    $("#password").removeClass("has-error has-success").addClass("has-success");
                    $("#passwordSpan").removeClass("glyphicon-remove glyphicon-ok").addClass("glyphicon-ok");
                    $("#password2").removeClass("has-error has-success").addClass("has-success");
                    $("#password2Span").removeClass("glyphicon-remove glyphicon-ok").addClass("glyphicon-ok");
                    $("#passwordCheck").text("");
                    $("#password2Check").text("");
                }else{
                    $("#password").removeClass("has-error has-success").addClass("has-error");
                    $("#passwordSpan").removeClass("glyphicon-remove glyphicon-ok").addClass("glyphicon-remove");
                    $("#password2").removeClass("has-error has-success").addClass("has-error");
                    $("#password2Span").removeClass("glyphicon-remove glyphicon-ok").addClass("glyphicon-remove");
                    $("#passwordCheck").text("两次密码不一致");
                    $("#password2Check").text("两次密码不一致");
                }
            }
        })
    })

    function rs() {
        $("#userName").removeClass("has-error has-success");
        $("#userNameSpan").removeClass("glyphicon-remove glyphicon-ok");
        $("#userNameCheck").text("");
        $("#password").removeClass("has-error has-success");
        $("#passwordSpan").removeClass("glyphicon-remove glyphicon-ok");
        $("#passwordCheck").text("");
        $("#password2").removeClass("has-error has-success");
        $("#password2Span").removeClass("glyphicon-remove glyphicon-ok");
        $("#password2Check").text("");
    }
</script>
</html>