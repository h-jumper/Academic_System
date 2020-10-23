<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>学生信息显示</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="/js/jquery-3.2.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>

	<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

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
					    	<h1 class="col-md-5">学生名单管理</h1>
							<form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="/admin/selectStudent" id="form1" method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入姓名" name="studentName">
									<span class="input-group-addon btn" id="sub">搜索</span>
								</div>
							</form>
							<button class="btn btn-default col-md-2" style="margin-top: 20px" onClick="location.href='/admin/addStudent'">
								添加用户信息
								<sapn class="glyphicon glyphicon-plus"/>
							</button>

						</div>
				    </div>
				    <table class="table table-bordered">
					        <thead>
					            <tr>
					                <th>学号</th>
				  					<th>姓名</th>
				  					<th>性别</th>
				  					<th>出生年份</th>
				  					<th>入学时间</th>
				  					<th>学院</th>
				  					<th>操作</th>
					            </tr>
					        </thead>
					        <tbody>
							<c:forEach  items="${studentList}" var="item">
								<tr>
									<td>${item.userID}</td>
									<td>${item.userName}</td>
									<td>${item.sex}</td>
									<td><fmt:formatDate value="${item.birthYear}" dateStyle="medium" /></td>
									<td><fmt:formatDate value="${item.grade}" dateStyle="medium" /></td>
									<td>${item.collegeName}</td>
									<td>
										<button class="btn btn-default btn-xs btn-info" onClick="location.href='/admin/editStudent?id=${item.userID}'">修改</button>
										<button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='/admin/removeStudent?id=${item.userID}'">删除</button>
										<!--弹出框-->
									</td>
								</tr>
							</c:forEach>
					        </tbody>
				    </table>
				    <div class="panel-footer">
						<c:if test="${page != null}">
							<nav style="text-align: center">
								<ul class="pagination">
									<li><a href="/admin/showStudent?page=${page.upPageNo}">&laquo;上一页</a></li>
									<li class="active"><a href="/admin/showStudent?page=${page.currentPageNo}">${page.currentPageNo}</a></li>
									<c:if test="${page.currentPageNo+1 <= page.totalCount}">
										<li><a href="/admin/showStudent?page=${page.currentPageNo+1}">${page.currentPageNo+1}</a></li>
									</c:if>
									<c:if test="${page.currentPageNo+2 <= page.totalCount}">
										<li><a href="/admin/showStudent?page=${page.currentPageNo+2}">${page.currentPageNo+2}</a></li>
									</c:if>
									<c:if test="${page.currentPageNo+3 <= page.totalCount}">
										<li><a href="/admin/showStudent?page=${page.currentPageNo+3}">${page.currentPageNo+3}</a></li>
									</c:if>
									<c:if test="${page.currentPageNo+4 <= page.totalCount}">
										<li><a href="/admin/showStudent?page=${page.currentPageNo+4}">${page.currentPageNo+4}</a></li>
									</c:if>
									<li><a href="/admin/showStudent?page=${page.totalCount}">最后一页&raquo;</a></li>
								</ul>
							</nav>
						</c:if>
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
		$("#nav li:nth-child(2)").addClass("active");

        function confirmd() {
            var msg = "您真的确定要删除吗？！";
            if (confirm(msg)==true){
                return true;
            }else{
                return false;
            }
        };

        $("#sub").click(function () {
            $("#form1").submit();
        });

        <c:if test="${page != null}">
			if (${page.currentPageNo} == ${page.totalCount}) {
				$(".pagination li:last-child").addClass("disabled")
			};

			if (${page.currentPageNo} == ${1}) {
				$(".pagination li:nth-child(1)").addClass("disabled")
			};
        </c:if>
	</script>
</html>