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
                        <h1 style="text-align: center;">学生打分</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form name="form" class="form-horizontal" role="form" action="/teacher/mark" id="editfrom" method="post" onsubmit="return check()">
                        <div class="form-group">
                            <div class="col-sm-7">
                                <input readonly="readonly" type="hidden" class="form-control" name="courseID" id="courseID" value="${studentMark.courseID}">
                            </div>
                        </div>
                        <div id="userID" class="form-group has-feedback">
                            <label for="inputUserID" class="col-sm-3 control-label">学号</label>
                            <div class="col-sm-7">
                                <input readonly="readonly" type="text" class="form-control" name="userID" id="inputUserID" value="${studentMark.userID}">
                                <span id="userIDSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
                            </div>
                        </div>
                        <div id="userName" class="form-group has-feedback">
                            <label for="inputUserName" class="col-sm-3 control-label">姓名</label>
                            <div class="col-sm-7">
                                <input readonly="readonly" type="text" name="userName" class="form-control" id="inputUserName" value="${studentMark.userName}">
                                <span id="userNameSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
                            </div>
                        </div>
                        <div id="mark" class="form-group has-feedback">
                            <label for="inputMark" class="col-sm-3 control-label">成绩</label>
                            <div class="col-sm-7">
                                <input type="number" name="mark" class="form-control" id="inputMark" placeholder="请输入成绩">
                                <span id="markSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
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
<script>
    $("#nav li:nth-child(1)").addClass("active")

    function check() {
        var flag = true;
        if(form.mark.value==""||form.mark.value==null){
            $("#mark").addClass("has-error");
            $("#markSpan").addClass("glyphicon-remove");
            flag = false;
        }
        return flag;
    }

    $(function(){
        $("#inputMark").focus(function(){
            $("#mark").removeClass("has-error");
            $("#markSpan").removeClass("glyphicon-remove");
        }).blur(function(){
            if(form.mark.value==""||form.mark.value==null){
                $("#mark").addClass("has-error");
                $("#markSpan").addClass("glyphicon-remove");
            }
        });
    });

    function rs() {
        $("#mark").removeClass("has-error");
        $("#markSpan").removeClass("glyphicon-remove");
    }
</script>
</html>