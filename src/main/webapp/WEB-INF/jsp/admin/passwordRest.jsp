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
                        <h1 style="text-align: center;">重置密码</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form name="form" class="form-horizontal" role="form" action="/admin/passwordRest" id="editfrom" method="post" onsubmit="return check()">
                        <div id="oldPassword" class="form-group has-feedback">
                            <label for="inputOldPassword" class="col-sm-3 control-label">旧密码</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="oldPassword" id="inputOldPassword" placeholder="请输入旧密码">
                                <span id="oldPasswordSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
                            </div>
                            <span id="oldPasswordCheck" class="col-sm-2 form-control-static" style="color: red"></span>
                        </div>
                        <div id="password" class="form-group has-feedback">
                            <label for="inputPassword" class="col-sm-3 control-label">新密码</label>
                            <div class="col-sm-7">
                                <input type="password" name="password" class="form-control" id="inputPassword" placeholder="请输入密码">
                                <span id="passwordSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
                            </div>
                            <span id="passwordCheck" class="col-sm-2 form-control-static" style="color: red"></span>
                        </div>
                        <div id="password2" class="form-group has-feedback">
                            <label for="inputPassword2" class="col-sm-3 control-label">确认密码</label>
                            <div class="col-sm-7">
                                <input type="password" name="password2" class="form-control" id="inputPassword2" placeholder="请再次输入密码">
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
    $("#nav li:nth-child(5)").addClass("active")

    function check() {
        var flag = true;
        if (form.oldPassword.value == "" || form.oldPassword.value == null) {
            $("#oldPassword").addClass("has-error");
            $("#oldPasswordSpan").addClass("glyphicon-remove");
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
        if ($("#oldPassword").hasClass("has-error"))
            flag = false;
        if ($("#password").hasClass("has-error"))
            flag = false;
        return flag;
    }

    $(function () {
        $("#inputOldPassword").focus(function () {
            $("#oldPassword").removeClass("has-error has-success");
            $("#oldPasswordSpan").removeClass("glyphicon-remove glyphicon-ok");
            $("#oldPasswordCheck").text("");
        }).blur(function () {
            if (form.oldPassword.value == "" || form.oldPassword.value == null) {
                $("#oldPassword").addClass("has-error");
                $("#oldPasswordSpan").addClass("glyphicon-remove");
            } else {
                $.get({
                    url: "/admin/passwordRestCheck",
                    data: {"oldPassword": $("#inputOldPassword").val()},
                    cache:false,
                    success: function (data) {
                        if (data == "true") {
                            $("#oldPassword").addClass("has-success");
                            $("#oldPasswordSpan").addClass("glyphicon-ok");
                        } else {
                            $("#oldPassword").addClass("has-error");
                            $("#oldPasswordSpan").addClass("glyphicon-remove");
                            $("#oldPasswordCheck").text("旧密码错误");
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
            } else if (form.password2.value != "" && form.password2.value != null) {
                if (form.password.value == form.password2.value) {
                    $("#password").removeClass("has-error has-success").addClass("has-success");
                    $("#passwordSpan").removeClass("glyphicon-remove glyphicon-ok").addClass("glyphicon-ok");
                    $("#password2").removeClass("has-error has-success").addClass("has-success");
                    $("#password2Span").removeClass("glyphicon-remove glyphicon-ok").addClass("glyphicon-ok");
                    $("#passwordCheck").text("");
                    $("#password2Check").text("");
                } else {
                    $("#password").removeClass("has-error has-success").addClass("has-error");
                    $("#passwordSpan").removeClass("glyphicon-remove glyphicon-ok").addClass("glyphicon-remove");
                    $("#password2").removeClass("has-error has-success").addClass("has-error");
                    $("#password2Span").removeClass("glyphicon-remove glyphicon-ok").addClass("glyphicon-remove");
                    $("#passwordCheck").text("两次密码不一致");
                    $("#password2Check").text("两次密码不一致");
                }
                x
            }
        });

        $("#inputPassword2").focus(function () {
            $("#password2").removeClass("has-error has-success");
            $("#password2Span").removeClass("glyphicon-remove glyphicon-ok");
        }).blur(function () {
            if (form.password2.value == "" || form.password2.value == null) {
                $("#password2").addClass("has-error");
                $("#password2Span").addClass("glyphicon-remove");
            } else if (form.password.value != "" && form.password.value != null) {
                if (form.password.value == form.password2.value) {
                    $("#password").removeClass("has-error has-success").addClass("has-success");
                    $("#passwordSpan").removeClass("glyphicon-remove glyphicon-ok").addClass("glyphicon-ok");
                    $("#password2").removeClass("has-error has-success").addClass("has-success");
                    $("#password2Span").removeClass("glyphicon-remove glyphicon-ok").addClass("glyphicon-ok");
                    $("#passwordCheck").text("");
                    $("#password2Check").text("");
                } else {
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
        $("#oldPassword").removeClass("has-error has-success");
        $("#oldPasswordSpan").removeClass("glyphicon-remove glyphicon-ok");
        $("#oldPasswordCheck").text("");
        $("#password").removeClass("has-error has-success");
        $("#passwordSpan").removeClass("glyphicon-remove glyphicon-ok");
        $("#passwordCheck").text("");
        $("#password2").removeClass("has-error has-success");
        $("#password2Span").removeClass("glyphicon-remove glyphicon-ok");
        $("#password2Check").text("");
    }

</script>
</html>