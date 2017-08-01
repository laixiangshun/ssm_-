<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>登陆</title>  
<style type="text/css">  
/* @CHARSET "UTF-8";   */
* {  
    margin:0;  
    padding:0;  
}  
  
body {  
    font-size: 12px;  
    font-family: "宋体";  
    text-align: center;  
}  
  
a {  
    color: #e3e3e3;  
    text-decoration: none;  
    padding: 2px;  
}  
  
a:hover {  
    color: #e3e3e3;  
    background-color: #606870;  
}  
  
ul {  
    list-style: none;  
    margin: 10px auto;  
}  
  
li {  
    margin: 3px 1px;  
    line-height: 24px;  
    height: 24px;  
}  
  
li:hover {  
    background-color: #eee;  
}  
  
button {  
    line-height: 24px;  
    height: 26px;  
}  
  
fieldset {  
    height: 120px;  
    width: 250px;  
    padding: 5px;  
}  
  
label {  
    width: 80px;  
    float: left;  
    text-align: right;  
}  
  
input {  
    width: 150px;  
}  
</style>  
  
<script type="text/javascript"
	src="${pageContext.request.contextPath }/easyui/jquery-2.2.4.min.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){  
	    //全局ajax开始事件  
	    $("#msg").ajaxStart(function(){  
	    	alert("hello")
	        $(this).html("正在登陆聊天室中···")  
	    })  
	  
	    $("#btnLogin").bind("click",function(){  
	        var $loginname = $("#txtName")
	        var $password = $("#txtPassword")
	        if($loginname.val()==""){  
	            alert("用户名不能为空")  
	            $loginname.focus()  
	            return false  
	        }else if($password.val()==""){  
	            alert("密码不能为空")  
	            $password.focus()  
	            return false  
	        }else{  
	            userLogin($loginname.val(),$password.val())  
	        }  
	    })  
	})  
	  
	//ajax登陆处理  
	function userLogin(loginname,password){  
	    $.ajax({  
	        type:"post",  
	        url:"login.html",  
	        data:{"loginname":loginname,"password":password},  
	        dataType:'text',  
	        success:function(data){  
	            if(data == "success"){  
	                window.location.href="toChatMain.html";  
	            }else{  
	                $("#msg").html("用户名或密码错误，请重新登录")  
	                return false  
	            }  
	        }  
	    })  
	}
  </script>
</head>  
<body>  
<!-- <form action="" method="post"> -->
<fieldset><legend>登录</legend>  
  
    <ul>  
        <li><span>用户名:</span><input type="text" id="txtName" name="loginname"></input></li>  
        <li><span>密码:</span><input type="password" id="txtPassword" name="password"></input></li>  
        <li>  
        <button id="btnLogin">登录</button>  
        <button id="btnReset" type="reset">重置</button>  
        </li>  
    </ul>  
    <span id="msg"></span>  
</fieldset>  
<!-- </form> -->
</body>  
</html>