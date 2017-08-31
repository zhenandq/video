<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
	</head>
  
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
					<a class="navbar-brand" href="#">视频管理系统</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li>
							<a href="#">视频管理</a>
						</li>
						<li>
							<a href="#about">主讲人管理</a>
						</li>
						<li class="active">
							<a href="#contact">课程管理</a>
						</li>
						
						<li style="left: 600px;">
							<a href="#navbar" class="glyphicon glyphicon-log-out"></a>
						</li>
					</ul>

				</div>
			</div>
		</nav>
		<div class="container theme-showcase" role="main">

			<div class="jumbotron">
				<h2>修改课程</h2>
			</div>

			<form class="form-horizontal" action="${pageContext.request.contextPath}/course/updateCourse.action" method="post">
				<div class="form-group">
				<label class="col-md-2 control-label">所属学科</label>
				<div class="col-md-10">
					<select class="form-control" name="subjectId">
						<option value="">请选择所属学科</option>
						<c:forEach items="${listSubject }" var="subject">
						<option value="${subject.id }" ${subject.id==course.subjectId?"selected":"" }>${subject.subjectName }</option>
						</c:forEach>
					</select>
				</div>
			</div>

				<div class="form-group">
					<label class="col-md-2 control-label">标题</label>
					<div class="col-md-10">
						<input type="text" name="courseName" value="${course.courseName}" class="form-control" placeholder="课程标题">
					</div>
				</div>
				

				<div class="form-group">
					<label class="col-md-2 control-label">简介</label>
					<div class="col-md-10">
						<textarea class="form-control" name="courseDescr" style="height: 100px;">${course.courseDescr }</textarea>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-offset-2 col-md-10">
					<input type="hidden" name="id" value="${course.id }">
						<button type="submit" class="btn btn-primary">保存</button>
						<a class="btn btn-default" href="javascript:history.go(-1)">返回列表</a>

					</div>
				</div>
			</form>
			
		</div>
	</body>

</html>