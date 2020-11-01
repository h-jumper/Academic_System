<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                        <h1 style="text-align: center;">添加学生信息</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form name="form" class="form-horizontal" role="form" action="/admin/addStudent" id="editfrom" method="post" onsubmit="return check()">
                        <div id="userID" class="form-group has-feedback">
                            <label for="inputUserID" class="col-sm-3 control-label">学号</label>
                            <div class="col-sm-7">
                                <input type="number" class="form-control" id="inputUserID" name="userID" placeholder="请输入学号">
                                <span id="userIDSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
                            </div>
                            <span id="userIDCheck" class="col-sm-2 form-control-static" style="color: red"></span>
                        </div>
                        <div id="userName" class="form-group has-feedback">
                            <label for="inputUserName" class="col-sm-3 control-label">姓名</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="inputUserName" name="userName" placeholder="请输入姓名">
                                <span id="userNameSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别</label>
                            <div class="col-sm-7">
                                <label class="checkbox-inline">
                                    <input type="radio" name="sex" value="男" checked>男
                                </label>
                                <label class="checkbox-inline">
                                    <input type="radio" name="sex" value="女">女
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputBirthYear" class="col-sm-3 control-label">出生年份</label>
                            <div class="col-sm-7">
                                <input type="date" value="2015-05-01" id="inputBirthYear" name="birthYear"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="grade" class="col-sm-3 control-label" name="grade">入学时间</label>
                            <div class="col-sm-7">
                                <input type="date" value="2020-10-20" id="grade" name="grade"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="collegeID" class="col-sm-3 control-label" name="collegeID">所属院系</label>
                            <div class="col-sm-7">
                                <select class="form-control" id="collegeID" name="collegeID">
                                    <c:forEach items="${collegeList}" var="item">
                                        <option value="${item.collegeID}">${item.collegeName}</option>
                                    </c:forEach>
                                </select>
                            </div>
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
<script type="text/javascript">
    $("#nav li:nth-child(2)").addClass("active")

    function check() {
        var flag = true;
        if (form.userID.value == "" || form.userID.value == null) {
            $("#userID").addClass("has-error");
            $("#userIDSpan").addClass("glyphicon-remove");
            flag = false;
        }
        if (form.userName.value == "" || form.userName.value == null) {
            $("#userName").addClass("has-error");
            $("#userNameSpan").addClass("glyphicon-remove");
            flag = false;
        }
        if ($("#userID").hasClass("has-error"))
            flag = false;
        return flag;
    }

    $(function () {
        $("#inputUserID").focus(function () {
            $("#userID").removeClass("has-error has-success");
            $("#userIDSpan").removeClass("glyphicon-remove glyphicon-ok");
            $("#userIDCheck").text("");
        }).blur(function () {
            if (form.userID.value == "" || form.userID.value == null) {
                $("#userID").addClass("has-error");
                $("#userIDSpan").addClass("glyphicon-remove");
            } else {
                $.get({
                    url: "/admin/addStudentCheck",
                    data: {"userID": $("#inputUserID").val()},
                    cache:false,
                    success: function (data) {
                        if (data == "true") {
                            $("#userID").addClass("has-success");
                            $("#userIDSpan").addClass("glyphicon-ok");
                        } else {
                            $("#userID").addClass("has-error");
                            $("#userIDSpan").addClass("glyphicon-remove");
                            $("#userIDCheck").text("学号重复");
                        }
                    }
                })
            }
        });

        $("#inputUserName").focus(function () {
            $("#userName").removeClass("has-error");
            $("#userNameSpan").removeClass("glyphicon-remove");
        }).blur(function () {
            if (form.userName.value == "" || form.userName.value == null) {
                $("#userName").addClass("has-error");
                $("#userNameSpan").addClass("glyphicon-remove");
            }
        });
    });

    function rs() {
        $("#userID").removeClass("has-error has-success");
        $("#userIDSpan").removeClass("glyphicon-remove glyphicon-ok");
        $("#userIDCheck").text("");
        $("#userName").removeClass("has-error");
        $("#userNameSpan").removeClass("glyphicon-remove");
    }
</script>
</html>