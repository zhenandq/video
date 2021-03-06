<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="zz" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css"rel="stylesheet">
<link href="${pageContext.request.contextPath }/static/css/jquery-confirm.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery-confirm.js"></script>
</head>

<script type="text/javascript">
function deleteInfo(id){
	 $.confirm({
	   title: '提示',
	    content: '是否确认',
	   buttons: {
		confirm: {
		text: '非常肯定',
		action: function () {
	$.ajax({
	url:"${pageContext.request.contextPath}/speaker/deleteSpeaker.action",
		dataType:"text",
		type:"post",
		data:{"id":id},
		success:function(msg){
		if(msg=="success"){
		location.reload();
				 		}
					}
				});
			}
			  },
				取消: function () {		
					
				 }				       
			 }
		});
	 }		
</script>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">视频管理系统</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a
						href="${pageContext.request.contextPath }/video/videoList.action">视频管理</a>
					</li>
					<li class="active"><a
						href="${pageContext.request.contextPath }/speaker/speaker.action">主讲人管理</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath }/course/course.action">课程管理</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath }/video/statisticsList.action">统计分析</a>
					</li>
					<li style="left: 550px;"><a href="#">${admin.loginName}</a></li>
					<li style="left: 550px;"><a
						href="${pageContext.request.contextPath }/index.jsp"
						class="glyphicon glyphicon-log-out"></a></li>
				</ul>

			</div>
		</div>
	</nav>
	<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h2>主讲人列表-主讲人管理</h2>
		</div>
		<div>
			<a class="btn btn-primary"
				href="<c:url value="/speaker/addTeacher.action" />">添加主讲人</a>

			<div style="float: right;">
				<form id="searchForm"
					action="<c:url value="/speaker/speaker.action" />" method="get">
					<span>名称</span> <input type="text" name="speakerName"
						placeholder="主讲人名称" value="${speakerName }"> <span>职位</span>
					<input type="text" name="speakerJob" placeholder="主讲人职位"
						value="${speakerJob }"> <input type="submit"
						class="btn btn-primary" value="搜索">
				</form>
			</div>
		</div>

		<div class="bs-example" data-example-id="hoverable-table">
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="col-md-0">序号</th>
						<th class="col-md-1">名称</th>
						<th class="col-md-1">职位</th>
						<th class="col-md-10">简介</th>
						<th class="col-md-1">编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="speaker" items="${page.rows }" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${speaker.speakerName}</td>
							<td>${speaker.speakerJob}</td>
							<td>${speaker.speakerDescr}</td>
							<td><a class="glyphicon glyphicon-edit"
								href="${pageContext.request.contextPath }/speaker/updateSpeaker.action?id=${speaker.id}"></a></td>
							<td><a class="glyphicon glyphicon-trash"
								onclick="deleteInfo(${speaker.id})"></a></td>
						</tr>
					</c:forEach>
					<c:if test="${empty page.rows }">
						<tr>
							<td>当前查询结果为空!</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div>
		<zz:page
			url="${pageContext.request.contextPath }/speaker/speaker.action"></zz:page>
	</div>
</body>

</html>