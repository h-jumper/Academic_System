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
					    	<h1 style="text-align: center;">修改课程信息</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form name="form" class="form-horizontal" role="form" action="/admin/editCourse" id="editfrom" method="post" onsubmit="return check()">
							  <div id="courseID" class="form-group has-feedback">
							    <label for="inputCourseID" class="col-sm-3 control-label">课程号</label>
							    <div class="col-sm-7">
							      	<input readonly="readonly"  type="number" class="form-control" id="inputCourseID" value="${course.courseID}" name="courseID" placeholder="请输入课程号">
									<span id="courseIDSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
								</div>
							  </div>
							  <div id="courseName" class="form-group has-feedback">
							    <label for="inputCourseName" class="col-sm-3 control-label">课程名称</label>
									<div class="col-sm-7">
							      		<input type="text" class="form-control" id="inputCourseName" name="courseName" value="${course.courseName}" placeholder="请输入课程名称">
										<span id="courseNameSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
									</div>
							  </div>
							  <div class="form-group">
								  <label for="teacherID" class="col-sm-3 control-label" name="teacherID">授课老师编号</label>
								  <div class="col-sm-7">
									  <select class="form-control" name="teacherID" id="teacherID">
										  <c:forEach items="${teacherList}" var="item">
											  <option value="${item.userID}">${item.userName}</option>
										  </c:forEach>
									  </select>
								  </div>
							  </div>
							<div id="courseTime" class="form-group has-feedback">
								<label for="inputCourseTime" class="col-sm-3 control-label">上课时间</label>
								<div class="col-sm-7">
									<input id="inputCourseTime" type="text" class="form-control" name="courseTime" value="${course.courseTime}" placeholder="请输入上课时间">
									<span id="courseTimeSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
								</div>
							</div>
							<div id="classRoom" class="form-group has-feedback">
								<label for="inputClassRoom" class="col-sm-3 control-label">上课地点</label>
								<div class="col-sm-7">
									<input id="inputClassRoom" type="text" class="form-control" name="classRoom" value="${course.classRoom}" placeholder="上课地点">
									<span id="classRoomSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
								</div>
							</div>
							<div id="courseWeek" class="form-group has-feedback">
								<label for="inputCourseWeek" class="col-sm-3 control-label">周数</label>
								<div class="col-sm-7">
									<input id="inputCourseWeek" type="number" class="form-control" name="courseWeek" value="${course.courseWeek}" placeholder="请输入周数">
									<span id="courseWeekSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
								</div>
							</div>
							<div class="form-group">
								<label for="inputCourseType" class="col-sm-3 control-label" name="courseType">课程的类型</label>
								<div class="col-sm-7">
									<select class="form-control" name="courseType" id="inputCourseType">
										<option value="必修课">必修课</option>
										<option value="选修课">选修课</option>
										<option value="公共课">公共课</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="inputCollegeID" class="col-sm-3 control-label" name="collegeID">所属院系</label>
								<div class="col-sm-7">
									<select  class="form-control" id="inputCollegeID" name="collegeID">
										<c:forEach items="${collegeList}" var="item">
											<option value="${item.collegeID}">${item.collegeName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div id="score" class="form-group has-feedback">
								<label for="inputScore" class="col-sm-3 control-label">学分</label>
								<div class="col-sm-7">
									<input id="inputScore" type="number" class="form-control" name="score" value="${course.score}" placeholder="请输入学分">
									<span id="scoreSpan" class="glyphicon form-control-feedback" aria-hidden="true"></span>
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
		$("#nav li:nth-child(1)").addClass("active")

        var collegeSelect = $("#collegeID option");
        for (var i=0; i<collegeSelect.length; i++) {
            if (collegeSelect[i].value == '${course.collegeID}') {
                collegeSelect[i].selected = true;
            }
        }

        var coursetypeSelect = $("#courseType option");
        for (var i=0; i<coursetypeSelect.length; i++) {
            if (coursetypeSelect[i].value == '${course.courseType}') {
                coursetypeSelect[i].selected = true;
            }
        }

        var teacheridSelect = $("#teacherID option");
        for (var i=0; i<teacheridSelect.length; i++) {
            if (teacheridSelect[i].value == '${course.teacherID}') {
                teacheridSelect[i].selected = true;
            }
        }

		function check() {
			var flag = true;
			if(form.courseName.value==""||form.courseName.value==null){
				$("#courseName").addClass("has-error");
				$("#courseNameSpan").addClass("glyphicon-remove");
				flag = false;
			}
			if(form.classRoom.value==""||form.classRoom.value==null){
				$("#classRoom").addClass("has-error");
				$("#classRoomSpan").addClass("glyphicon-remove");
				flag = false;
			}
			if(form.courseTime.value==""||form.courseTime.value==null){
				$("#courseTime").addClass("has-error");
				$("#courseTimeSpan").addClass("glyphicon-remove");
				flag = false;
			}
			if(form.courseWeek.value==""||form.courseWeek.value==null){
				$("#courseWeek").addClass("has-error");
				$("#courseWeekSpan").addClass("glyphicon-remove");
				flag = false;
			}
			if(form.score.value==""||form.score.value==null){
				$("#score").addClass("has-error");
				$("#scoreSpan").addClass("glyphicon-remove");
				flag = false;
			}
			if($("#courseID").hasClass("has-error"))
				flag = false;
			return flag;
		}

		$(function(){
			$("#inputCourseName").focus(function () {
				$("#courseName").removeClass("has-error");
				$("#courseNameSpan").removeClass("glyphicon-remove");
			}).blur(function () {
				if(form.courseName.value==""||form.courseName.value==null){
					$("#courseName").addClass("has-error");
					$("#courseNameSpan").addClass("glyphicon-remove");
				}
			});

			$("#inputClassRoom").focus(function () {
				$("#classRoom").removeClass("has-error");
				$("#classRoomSpan").removeClass("glyphicon-remove");
			}).blur(function () {
				if(form.classRoom.value==""||form.classRoom.value==null){
					$("#classRoom").addClass("has-error");
					$("#classRoomSpan").addClass("glyphicon-remove");
				}
			});

			$("#inputCourseTime").focus(function () {
				$("#courseTime").removeClass("has-error");
				$("#courseTimeSpan").removeClass("glyphicon-remove");
			}).blur(function () {
				if(form.courseTime.value==""||form.courseTime.value==null){
					$("#courseTime").addClass("has-error");
					$("#courseTimeSpan").addClass("glyphicon-remove");
				}
			});

			$("#inputCourseWeek").focus(function () {
				$("#courseWeek").removeClass("has-error");
				$("#courseWeekSpan").removeClass("glyphicon-remove");
			}).blur(function () {
				if(form.courseWeek.value==""||form.courseWeek.value==null){
					$("#courseWeek").addClass("has-error");
					$("#courseWeekSpan").addClass("glyphicon-remove");
				}
			});

			$("#inputScore").focus(function () {
				$("#score").removeClass("has-error");
				$("#scoreSpan").removeClass("glyphicon-remove");
			}).blur(function () {
				if(form.score.value==""||form.score.value==null){
					$("#score").addClass("has-error");
					$("#scoreSpan").addClass("glyphicon-remove");
				}
			})
		});

		function rs() {
			$("#courseName").removeClass("has-error");
			$("#courseNameSpan").removeClass("glyphicon-remove");
			$("#classRoom").removeClass("has-error");
			$("#classRoomSpan").removeClass("glyphicon-remove");
			$("#courseTime").removeClass("has-error");
			$("#courseTimeSpan").removeClass("glyphicon-remove");
			$("#courseWeek").removeClass("has-error");
			$("#courseWeekSpan").removeClass("glyphicon-remove");
			$("#score").removeClass("has-error");
			$("#scoreSpan").removeClass("glyphicon-remove");
		}

	</script>
</html>