<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

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
					    	<h1 style="text-align: center;">修改教师信息</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form name="form" class="form-horizontal" role="form" action="/admin/editTeacher" id="editfrom" method="post" onsubmit="return check()">
							  <div id="userID" class="form-group has-feedback">
							    <label for="inputEmail3" class="col-sm-3 control-label">工号</label>
							    <div class="col-sm-7">
							      <input readonly="readonly" type="number" class="form-control" id="inputEmail3" name="userID" placeholder="请输入工号" value="${teacher.userID}">
								  <span id="userIDSpan" class="glyphicon-remove form-control-feedback" aria-hidden="true"></span>
								</div>
							  </div>
							  <div id="userName" class="form-group has-feedback">
							    <label for="inputPassword3" class="col-sm-3 control-label">姓名</label>
							    <div class="col-sm-7">
							      <input type="text" class="form-control" id="inputPassword3" name="userName" placeholder="请输入姓名" value="${teacher.userName}">
								  <span id="userNameSpan" class="glyphicon-remove form-control-feedback" aria-hidden="true"></span>
								</div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-3 control-label">性别</label>
							    <div class="col-sm-7">
								    <label class="checkbox-inline">
										<input type="radio" name="sex" value="男" <c:if test="${teacher.sex == '男'}">checked</c:if>>男
									</label>
									<label class="checkbox-inline">
										<input type="radio" name="sex" value="女" <c:if test="${teacher.sex == '女'}">checked</c:if>>女
									</label>
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-3 control-label">出生年份</label>
							    <div class="col-sm-7">
								    <input type="date" value="<fmt:formatDate value="${teacher.birthYear}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="birthYear"/>
							    </div>
							  </div>
							  <div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label" name="degree">学历</label>
								<div class="col-sm-7">
									<select class="form-control" name="degree" id="degree">
										<option value="本科">本科</option>
										<option value="硕士">硕士</option>
										<option value="博士">博士</option>
									</select>
								</div>
							  </div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label" name="title" >职称</label>
								<div class="col-sm-7">
									<select class="form-control" name="title" id="title">
										<option value="普通教师">普通教师</option>
										<option value="助教">助教</option>
										<option value="讲师">讲师</option>
										<option value="副教授">副教授</option>
										<option value="教授">教授</option>
									</select>
								</div>
							</div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-3 control-label" name="grade">入职时间</label>
							    <div class="col-sm-7">
								    <input type="date" value="<fmt:formatDate value="${teacher.grade}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="grade"/>
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputPassword3" class="col-sm-3 control-label" name="grade">所属院系</label>
							    <div class="col-sm-7">
								    <select class="form-control" name="collegeID" id="college">
										<c:forEach items="${collegeList}" var="item">
											<option value="${item.collegeID}">${item.collegeName}</option>
										</c:forEach>
								    </select>
							    </div>
							  </div>
							  <div class="form-group" style="text-align: center">
								<button class="btn btn-default" type="submit">提交</button>
								<button class="btn btn-default" type="reset">重置</button>
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
		$("#nav li:nth-child(3)").addClass("active");

        var collegeSelect = $("#college option");
        for (var i=0; i<collegeSelect.length; i++) {
            if (collegeSelect[i].value == '${teacher.collegeID}') {
                collegeSelect[i].selected = true;
            }
        }

        var degreeSelect = $("#degree option");
        var titleSelect = $("#title option");

        for (var i=0; i<degreeSelect.length; i++) {
            if (degreeSelect[i].value == '${teacher.degree}') {
                degreeSelect[i].selected = true;
            }
        }
        for (var i=0; i<titleSelect.length; i++) {
            if (titleSelect[i].value == '${teacher.title}') {
                titleSelect[i].selected = true;
            }
        }

		function check() {
			var flag = true;
			if(form.userID.value==""||form.userID.value==null){
				$("#userID").addClass("has-error");
				$("#userIDSpan").addClass("glyphicon");
				flag = false;
			}else{
				$("#userID").removeClass("has-error");
				$("#userIDSpan").removeClass("glyphicon");
			}
			if(form.userName.value==""||form.userName.value==null){
				$("#userName").addClass("has-error");
				$("#userNameSpan").addClass("glyphicon");
				flag = false;
			}else{
				$("#userName").removeClass("has-error");
				$("#userNameSpan").removeClass("glyphicon");
			}
			return flag;
		}
	</script>
</html>