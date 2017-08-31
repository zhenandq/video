<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath }/static/js/echarts-all.js"></script>  
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
							<a href="${pageContext.request.contextPath }/video/videoList.action">视频管理</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/speaker/speaker.action">主讲人管理</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/course/course.action">课程管理</a>
						</li>
						<li  class="active">
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
				<h2>统计-统计分析</h2>
			</div>
		
    <div id="main" style="height:400px"></div>
    
     <script type="text/javascript">
        // 基于准备好的dom，初始化echarts图表
        var myChart = echarts.init(document.getElementById('main')); 
        
        var option = {
            tooltip: {
                show: true
            },
            legend: {
                data:['课程平均播放次数']
            },
            xAxis : [
                {
                    type : 'category',
                    data : ${courseName}
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                { 
                    "name":"课程平均播放次数",
                    "type":"bar",
                    "data":${times}
                }
            ]
        };
        myChart.setOption(option); 
    </script>
    </div>
</body>
</html>