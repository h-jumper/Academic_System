<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
						<h1 style="text-align: center;">添加课程信息</h1>
					</div>
				</div>
				<div class="panel-body">
					<form name="form" class="form-horizontal" role="form" action="/admin/addCourse" id="editfrom" method="post" onsubmit="return check()">
						<div id="courseID" class="form-group has-feedback">
							<label for="inputEmail3" class="col-sm-3 control-label">课程号</label>
							<div class="col-sm-7">
								<input type="number" class="form-control" id="inputEmail3" name="courseID" placeholder="请输入课程号">
								<span id="courseIDSpan" class="glyphicon-remove form-control-feedback" aria-hidden="true"></span>
							</div>
						</div>
						<div id="courseName" class="form-group has-feedback">
							<label for="inputPassword3" class="col-sm-3 control-label">课程名称</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="inputPassword3" name="courseName" placeholder="请输入课程名称">
								<span id="courseNameSpan" class="glyphicon-remove form-control-feedback" aria-hidden="true"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label" name="grade">授课老师编号</label>
							<div class="col-sm-7">
								<select class="form-control" name="teacherID">
									<c:forEach items="${teacherList}" var="item">
										<option value="${item.userID}">${item.userName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div id="courseTime" class="form-group has-feedback">
							<label for="inputPassword3" class="col-sm-3 control-label">上课时间</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="courseTime" placeholder="请输入上课时间">
								<span id="courseTimeSpan" class="glyphicon-remove form-control-feedback" aria-hidden="true"></span>
							</div>
						</div>
						<div id="classRoom" class="form-group has-feedback">
							<label for="inputPassword3" class="col-sm-3 control-label">上课地点</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="classRoom" placeholder="上课地点">
								<span id="classRoomSpan" class="glyphicon-remove form-control-feedback" aria-hidden="true"></span>
							</div>
						</div>
						<div id="courseWeek" class="form-group has-feedback">
							<label for="inputEmail3" class="col-sm-3 control-label">周数</label>
							<div class="col-sm-7">
								<input type="number" class="form-control" name="courseWeek" placeholder="请输入周数">
								<span id="courseWeekSpan" class="glyphicon-remove form-control-feedback" aria-hidden="true"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label" name="courseType">课程的类型</label>
							<div class="col-sm-7">
								<select class="form-control" name="courseType">
									<option value="必修课">必修课</option>
									<option value="选修课">选修课</option>
									<option value="公共课">公共课</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label" name="collegeID">所属院系</label>
							<div class="col-sm-7">
								<select class="form-control" name="collegeID">
									<c:forEach items="${collegeList}" var="item">
										<option value="${item.collegeID}">${item.collegeName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div id="score" class="form-group has-feedback">
							<label for="inputEmail3" class="col-sm-3 control-label">学分</label>
							<div class="col-sm-7">
								<input type="number" class="form-control" name="score" placeholder="请输入学分">
								<span id="scoreSpan" class="glyphicon-remove form-control-feedback" aria-hidden="true"></span>
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
    $("#nav li:nth-child(1)").addClass("active")

	function check() {
		var flag = true;
		if(form.courseID.value==""||form.courseID.value==null){
			$("#courseID").addClass("has-error");
			$("#courseIDSpan").addClass("glyphicon");
			flag = false;
		}else{
			$("#courseID").removeClass("has-error");
			$("#courseIDSpan").removeClass("glyphicon");
		}
		if(form.courseName.value==""||form.courseName.value==null){
			$("#courseName").addClass("has-error");
			$("#courseNameSpan").addClass("glyphicon");
			flag = false;
		}else{
			$("#courseName").removeClass("has-error");
			$("#courseNameSpan").removeClass("glyphicon");
		}
		if(form.classRoom.value==""||form.classRoom.value==null){
			$("#classRoom").addClass("has-error");
			$("#classRoomSpan").addClass("glyphicon");
			flag = false;
		}else{
			$("#classRoom").removeClass("has-error");
			$("#classRoomSpan").removeClass("glyphicon");
		}
		if(form.courseTime.value==""||form.courseTime.value==null){
			$("#courseTime").addClass("has-error");
			$("#courseTimeSpan").addClass("glyphicon");
			flag = false;
		}else{
			$("#courseTime").removeClass("has-error");
			$("#courseTimeSpan").removeClass("glyphicon");
		}
		if(form.courseWeek.value==""||form.courseWeek.value==null){
			$("#courseWeek").addClass("has-error");
			$("#courseWeekSpan").addClass("glyphicon");
			flag = false;
		}else{
			$("#courseWeek").removeClass("has-error");
			$("#courseWeekSpan").removeClass("glyphicon");
		}
		if(form.score.value==""||form.score.value==null){
			$("#score").addClass("has-error");
			$("#scoreSpan").addClass("glyphicon");
			flag = false;
		}else{
			$("#score").removeClass("has-error");
			$("#scoreSpan").removeClass("glyphicon");
		}
		return flag;
	}

</script>
</html>