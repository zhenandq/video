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
					<li class="active">
						<a href="#">视频管理</a>
					</li>
					<li>
						<a href="#about">主讲人管理</a>
					</li>
					<li>
						<a href="#contact">课程管理</a>
					</li>
					<li>
						<a href="#navbar">统计分析</a>
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
			<h2>添加视频信息-视频管理</h2>
		</div>

		<form class="form-horizontal" action="${pageContext.request.contextPath}/video/addVideo.action" method="post">
			<div class="form-group">
				<label class="col-md-2 control-label">视频标题</label>
				<div class="col-md-10">
					<input type="text" name="videoTitle" class="form-control" placeholder="视频标题">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">主讲人</label>
				<div class="col-md-10">
					<select class="form-control" name="speakerId">
						<option value="">请选择主讲人</option>
						<c:forEach items="${listSpeaker }" var="speaker">
						<option value="${speaker.id }">${speaker.speakerName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">所属课程</label>
				<div class="col-md-10">
					<select class="form-control" name="courseId">
						<option value="">请选择课程</option>
						<c:forEach items="${listCourse }" var="course">
						<option value="${course.id}">${course.courseName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">视频时长</label>
				<div class="col-md-10">
					<input type="text" name="videoLength"  class="form-control" placeholder="视频时长(秒)">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">封面图片</label>
				<div class="col-md-10">
					<input type="text" name="videoImageUrl"  class="form-control" placeholder="视频封面图片地址,网络图片">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">视频播放地址</label>
				<div class="col-md-10">
					<input type="text" name="videoUrl" class="form-control" placeholder="视频播放地址,网络地址">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">视频简介</label>
				<div class="col-md-10">
					<textarea class="form-control" name="videoDescr" style="height: 100px;"></textarea>
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-offset-2 col-md-10">
					<button type="submit" class="btn btn-primary">保存</button>
					<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>

				</div>
			</div>
		</form>
	</div>
</body>

</html>
