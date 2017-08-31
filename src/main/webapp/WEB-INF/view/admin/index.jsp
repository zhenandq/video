<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<!--引入模版-->
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/messages_zh.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    $(function(){
    	$("#loginForm").validate({
    		rules:{
    			loginName:{			
    				required:true,
    				//光标离开就能触发
    				minlength:5			
    			},
    			loginPwd:{
    				required:true
    			},
    			rloginPwd:{
    				required:true,
    				//属性选择器
    				equalTo:"input[name=loginPwd]"
    			}		
    		},
    		messages:{
    			loginName:{
    				required:"用户名不能为空",
    				//光标离开就能触发
    				minlength:"长度太小",				
    			},loginPwd:{
    				required:"输入密码"
    			},
    			rloginPwd:{
    				required:"请确认密码",
    				equalTo:"密码不一致"
    			}
    		}				
    	});
    });

    </script>
  </head>
  <body>
  <div style="width: 300px; margin:300px auto;" >
        <img src="${pageContext.request.contextPath }/static/img/logo.png" />
        <form action="${pageContext.request.contextPath }/adminLogin.action" id="loginForm" method="post">
            <div class="form-group">
                <input type="text" class="form-control"  name="loginName" placeholder="用户名" value="admin">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="loginPwd" placeholder="登录密码" value="admin">
               </div>
            <div class="form-group">
                <input type="password" class="form-control" name="rloginPwd" placeholder="请再次输入登录密码" value="">
               </div>
            <div class="form-group">
				
               </div>
           
               <div>
               <button type="submit" class="form-control btn btn-success">登录</button>
            </div>
        </form>
    </div>
  </body>
</html>
