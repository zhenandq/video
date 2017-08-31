<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<li class="active">
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
				<h2>编辑主讲人信息-主讲人管理</h2>
			</div>

			<form class="form-horizontal" action="${pageContext.request.contextPath }/speaker/updateSpeaker.action" method="post">
				<div class="form-group">
					<label class="col-md-2 control-label">名字</label>
					<div class="col-md-10">
						<input type="text" name="s.speakerName" value="${speaker.speakerName}" class="form-control" placeholder="主讲人姓名">
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-2 control-label">职业</label>
					<div class="col-md-10">
						<input type="text" name="s.speakerJob" value="${speaker.speakerJob}" class="form-control" placeholder="主讲人职业">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">头像图片</label>
					<div class="col-md-10">
						<input type="text" name="s.speakerHeadUrl" value="${speaker.speakerHeadUrl}" class="form-control" placeholder="主讲人头像图片,网络图片">
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-2 control-label">简介</label>
					<div class="col-md-10">
						<textarea class="form-control" name="s.speakerDescr"  style="height: 100px;">${speaker.speakerDescr}</textarea>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-offset-2 col-md-10">
						<input type="hidden" name="s.id" value="${speaker.id }">
						<button type="submit" class="btn btn-primary">保存</button>
						<a class="btn btn-default" href="javascript:history.go(-1)">返回列表</a>

					</div>
				</div>
			</form>
			
		</div>
	</body>

</html>