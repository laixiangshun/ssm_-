<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大家的聊天室</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/easyui/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
	$(function() {
		//绑定全局ajaxStart事件  
		//  $("#divMsg").ajaxStart(function(){  
		//  $(this).show()  
		//})  
		//绑定全局ajaxStop事件  
		//  $("#divMsg").ajaxStop(function(){  
		//  $(this).hide()  
		//  })  
		initFace();//初始化表情  
		getMessageList();//取得聊天信息  
		getOnlineList();//取得在线人员  
		/** 
		 * 点击发送按钮 
		 */
		$("#btnSend").bind("click", function() {
			var $content = $("#txtContent")
			if ($content.val() != "") {
				sendContent($content.val())
			} else {
				alert("发送内容不能为空")
				$content.foucus()
				return false
			}
		})
		/** 
		 * 点击表情图标 
		 */
		$("table tr td img").bind("click", function() {
			var strContent = $("#txtContent").val() + "<:"+this.id+":>"
			$("#txtContent").val(strContent)
		})
	})

	/** 
	 * 发送聊天内容函数 
	 * @param content 聊天内容 
	 */
	function sendContent(content) {
		$.ajax({
			type : 'get',
			data : {
				"content" : content
			},
			url : 'sentContent.html',
			dataType : 'text',
			success : function(data) {
				if (data == "success") {
					getMessageList();
					$("#txtContent").val("")
				} else {
					alert("发送失败")
					return false
				}
			}
		})
	}

	/** 
	 * 取得聊天内容数据 
	 */
	function getMessageList() {
		$.ajax({
			type : "get",
			url : "getMassageList.html",
			dataType : "text",
			success : function(data) {
				$("#divContent").html(data)
			}
		})
		autoUpdContent() //定时获取聊天信息  
	}

	/** 
	 * 获取在线用户 
	 */
	function getOnlineList() {
		$.ajax({
			type : "get",
			url : "getOnlineList.html",
			dataType : "text",
			success : function(data) {
				$("#divOnLine").html(data)
			}
		})
	}

	/** 
	 * 设置表情图标函数 
	 */
	function initFace() {
		var strHTML = "";
		for (var i = 1; i <= 5; i++) {
			strHTML += "<img src='/ssm3/images/face/"+i+".bmp' id='"+i+"'/>"
		}
		$("#divFace").html(strHTML)
	}

	/** 
	 * 定时返回聊天内容和在线人数 
	 */
	function autoUpdContent() {
		setTimeout(getMessageList, 5000)
		setTimeout(getOnlineList, 6000)
	}
</script>
<style type="text/css">
body {
	font-size: 11px
}

h3 {
	margin: 0px
}

.divShow {
	border: solid 1px #ccc;
	height: 300px;
	padding: 5px;
	font-size: 12px;
	overflow-y: scroll
}

#divMain {
	border: soild 5px #ccc
}

#divMain .divTop {
	padding: 10px
}

#divMain .divTop .divL {
	float: left;
	width: 78%
}

#divMain .divTop .divR {
	float: right;
	width: 20%
}

#divMain .divBot {
	clear: both;
	padding: 10px
}

#divMain .divBot .pb {
	padding-bottom: 3px
}

#divMain .divBot .pl {
	padding-left: 12px
}

#divMain .divBot .pt {
	padding-top: 3px;
	color: #555
}

.clsTip {
	position: absolute;
	width: 160px;
	text-align: center;
	font-size: 13px;
	border: soild 1px #cc3300;
	margin-top: 5px;
	padding: 2px;
	margin-bottom: 5px;
	backgroudn-color: #ffe0a3;
	display: none
}

.btn {
	border: soild 1px #666;
	padding: 2px;
	width: 135px;
	height: 54px;
	font-size: 16px;
	filter: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#ECE9D8)
}

.txt {
	border: #666 1px solid;
	padding: 2px;
	margin-right: 3px
}
</style>
</head>
<body>
	<div id="divMain">
		<div class="divTop">
			<div class="divL">
				<h3>大家的聊天室</h3>
				<div class="divShow" id="divContent"></div>
			</div>
			<div class="divR">
				<h3>当前在线人员</h3>
				<div class="divShow" id="divOnLine"></div>
			</div>
		</div>
		<div class="divBot">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="2" id="divFace" class="pb"></td>
				</tr>
				<tr>
					<td><textarea rows="3" cols="64" id="txtContent"></textarea></td>
					<td class="p1"><input type="button" id="btnSend" value="发送"
						class="btn"> </input></td>
				</tr>
				<tr>
					<td colspan="2" class="pt">发送内容不能为空</td>
				</tr>
			</table>
		</div>
		<span id="divMsg" class="clsTip">正在发送数据。。。</span>
	</div>