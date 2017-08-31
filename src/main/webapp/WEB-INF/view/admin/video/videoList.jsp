<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zz" uri="http://zhiyou100.com/common/" %>
<!DOCTYPE html>
<html>
<title></title>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath }/static/css/jquery-confirm.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath }/static/js/jquery-confirm.js"></script>
		<script type="text/javascript">
		
		var deleteNum = 0;
		function checkDelete(ele){
			if(ele.checked){
				deleteNum++;
			}else{
				deleteNum--;
			}
			$("#countSpan").text(deleteNum);
			if(deleteNum == $("input[name=checkid]").length){
				$("#checkAll").prop("checked",true);
			}else{
				$("#checkAll").prop("checked",false);
			}			
		}
		function checkAllElement(ele){
			$("input[name=checkid]").prop("checked",ele.checked);
			if(ele.checked){
				deleteNum = $("input[name=checkid]").length;
			}else{
				deleteNum = 0;
			}
			$("#countSpan").text(deleteNum);
			
		}
		function batchDelete(){
			if(deleteNum == 0){
				$.alert({
					title: '警告',
					content: '没选中,删什么删',
				});
				return;
			}
			$.confirm({
				title:'提示',
				content:'看清哦,可是全部删除!!',
				buttons: {
					confirm:{ 
						text: '非常肯定',
						
					action: function(){
						$("#deleteForm").submit();
						}
					},
					取消: function (){
						
					}					
				}
			});
		}
function deleteInfo(id){
	 $.confirm({
	   title: '提示',
	    content: '是否确认',
	   buttons: {
		confirm: {
		text: '非常肯定',
		action: function () {
	$.ajax({
	url:"${pageContext.request.contextPath}/video/deleteVideo.action",
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
							<a href="${pageContext.request.contextPath }/video/videoList.action">视频管理</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/speaker/speaker.action">主讲人管理</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/course/course.action">课程管理</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/video/statisticsList.action">统计分析</a>
						</li>
						<li style="left: 550px;" >
							<a href="#">${admin.loginName}</a>
						</li>
						<li style="left: 550px;">
							<a href="${pageContext.request.contextPath }/index.jsp" class="glyphicon glyphicon-log-out"></a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="container theme-showcase" role="main">
			<div class="jumbotron">
				<h2>视频列表-视频管理</h2>
			</div>
			<div>
				<a class="btn btn-primary" href="<c:url value="/video/addVideo.action" />">添加视频</a>
				<button class="btn btn-primary" type="button" onclick="batchDelete()">
				批量删除 <span class="badge" id="countSpan">0</span>
				</button>
				<div style="float: right;">
					<form class="form-inline" action="${pageContext.request.contextPath}/video/videoList.action ">
						<input type="text" class="form-control" placeholder="视频标题" name="videoTitle" value="${speakervo.videoTitle }">
						<select class="form-control" name="videoSpeaker">
							<option value="">请选择主讲人</option>
							<c:forEach items="${listSpeaker }" var="speaker">
							<option value="${speaker.id }" ${speaker.id==speakervo.videoSpeaker?"selected":"" }>${speaker.speakerName} </option>
							</c:forEach>
						</select>
						<select class="form-control" name="videoCourse">
							<option value="">请选择课程</option>
							<c:forEach items="${listCourse }" var="course">
							<option value="${course.id }" ${course.id==speakervo.videoCourse?"selected":"" }>${course.courseName} </option>
							</c:forEach>
						</select>
						<button type="submit" class="btn btn-primary">查询</button>
					</form>
				</div>							
			</div>

			<div class="bs-example" data-example-id="hoverable-table">
			<form action="${pageContext.request.contextPath }/video/batchDelete.action" id="deleteForm" method="get">
				<table class="table table-hover">
					<thead>
						<tr>
							<th><input type="checkbox" id="checkAll" onclick="checkAllElement(this)" ></th>
							<th class="col-md-0">序号</th>
							<th class="col-md-1">标题</th>
							<th class="col-md-12">简介</th>
							<th>讲师</th>
							<th class="col-md-1">课程</th>
							<th>时长(秒)</th>
							<th>播放次数</th>
							<th>编辑</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>
					<%-- <c:if test="${not empty page.rows }"> --%>
					<c:forEach var="video" items="${page.rows }" varStatus="status">
						<tr>
							<td scope="row"><input type="checkbox" name="checkid" value="${video.id }" onclick="checkDelete(this)" ></td>
							<td>${status.count+(page.page-1)*5}</td>
							<td>${video.videoTitle}</td>
							<td>${video.videoDescr}</td>
							<td>${video.speakerName}</td>
							<td>${video.courseName}</td>
							<td>${video.videoLength}</td>
							<td>${video.videoPlayTimes}</td>
							<td><a class="glyphicon glyphicon-edit" href="${pageContext.request.contextPath }/video/updateVideo.action?id=${video.id}"></a></td>
							<td><a class="glyphicon glyphicon-trash myClass" onclick="deleteInfo(${video.id})" ></a></td>
						</tr>
					</c:forEach>
					<%-- </c:if> --%>
					<c:if test="${empty page.rows }">
 					<tr><td>当前查询结果为空!</td></tr>
 				</c:if>
				</tbody>
				</table>
				</form>
			</div>
			<zz:page url="${pageContext.request.contextPath }/video/videoList.action"></zz:page>
		</div>
	</body>

</html>