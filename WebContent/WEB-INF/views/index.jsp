<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>酒店首页</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/easyui/demo/demo.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/easyui/jquery-2.2.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/easyui/easyui-lang-zh_CN.js"></script>
<script language="JavaScript">
	$(document)
			.ready(
					function() {
						$('.easyui-accordion li a').click(
								function() {
									var tabTitle = $(this).text();
									var url = $(this).attr("href");
									addTab(tabTitle, url);
									$('.easyui-accordion li div').removeClass(
											"selected");
									$(this).parent().addClass("selected");
								}).hover(function() {
							$(this).parent().addClass("hover");
						}, function() {
							$(this).parent().removeClass("hover");
						});

						function addTab(subtitle, url) {
							if (!$('#tabs').tabs('exists', subtitle)) {
								$('#tabs').tabs('add', {
									title : subtitle,
									content : createFrame(url),
									closable : true,
									width : $('#mainPanle').width() - 10,
									height : $('#mainPanle').height() - 26
								});
							} else {
								$('#tabs').tabs('select', subtitle);
							}
							tabClose();
						}

						function createFrame(url) {
							var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="'
									+ url
									+ '" style="width:100%;height:100%;"></iframe>';
							return s;
						}

						function tabClose() {
							/*双击关闭TAB选项卡*/
							$(".tabs-inner").dblclick(function() {
								var subtitle = $(this).children("span").text();
								$('#tabs').tabs('close', subtitle);
							})

							$(".tabs-inner").bind('contextmenu', function(e) {
								$('#mm').menu('show', {
									left : e.pageX,
									top : e.pageY,
								});
								var subtitle = $(this).children("span").text();
								$('#mm').data("currtab", subtitle);
								return false;
							});
						}

						//绑定右键菜单事件
						function tabCloseEven() {
							//关闭当前
							$('#mm-tabclose').click(function() {
								var currtab_title = $('#mm').data("currtab");
								$('#tabs').tabs('close', currtab_title);
							})
							//全部关闭
							$('#mm-tabcloseall').click(function() {
								$('.tabs-inner span').each(function(i, n) {
									var t = $(n).text();
									$('#tabs').tabs('close', t);
								});
							});

							//关闭除当前之外的TAB
							$('#mm-tabcloseother').click(function() {
								var currtab_title = $('#mm').data("currtab");
								$('.tabs-inner span').each(function(i, n) {
									var t = $(n).text();
									if (t != currtab_title)
										$('#tabs').tabs('close', t);
								});
							});
							//关闭当前右侧的TAB
							$('#mm-tabcloseright').click(function() {
								var nextall = $('.tabs-selected').nextAll();
								if (nextall.length == 0) {
									//msgShow('系统提示','后边没有啦~~','error');
									alert('后边没有啦~~');
									return false;
								}
								nextall.each(function(i, n) {
									var t = $('a:eq(0) span', $(n)).text();
									$('#tabs').tabs('close', t);
								});
								return false;
							});
							//关闭当前左侧的TAB
							$('#mm-tabcloseleft').click(function() {
								var prevall = $('.tabs-selected').prevAll();
								if (prevall.length == 0) {
									alert('到头了，前边没有啦~~');
									return false;
								}
								prevall.each(function(i, n) {
									var t = $('a:eq(0) span', $(n)).text();
									$('#tabs').tabs('close', t);
								});
								return false;
							});

							//退出
							$("#mm-exit").click(function() {
								$('#mm').menu('hide');

							})
						}
					});
	
	var url;
	
	function openUserAddDialog() {
		$("#dlg").dialog("open").dialog("setTitle", "登录框");
		url = "${pageContext.request.contextPath}/login.html";
	}
	
	function closeUserDialog() {
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function resetValue() {
		$("#loginname").val("");
		$("#password").val("");
	}
	
	function saveUser() {
		$("#fm").form("submit", {
			url :url,
			success : function(data) {
				alert("nihao")
// 				var data = eval('(' +data+ ')');
				if (data == "success") {
					window.location.href="toChatMain.html";
					$.messager.alert("系统提示", "即将进入主页面");
					resetValue();
					$("#dlg").dialog("close");
				} else {
					$.messager.alert("系统提示", "登录失败！");
					return;
				}
			}
		});
	}
	
</script>
<style>
.footer {
	width: 100%;
	text-align: center;
	line-height: 35px;
}

.top-bg {
	background-color: #d8e4fe;
	height: 80px;
}
</style>
</head>

<body class="easyui-layout" style="overflow: scroll;">
	<div region="north" border="true">
		<div class="top-bg">
			<div style="font-size: 30px; line-height: 50px; font-weight: bold;"
				align="center">菜&nbsp;&nbsp;鸟&nbsp;&nbsp;集&nbsp;&nbsp;团&nbsp;&nbsp;酒&nbsp;&nbsp;店&nbsp;&nbsp;管&nbsp;&nbsp;理&nbsp;&nbsp;系&nbsp;&nbsp;统</div>
			<div>
<!-- 			<a href="javascript:openUserAddDialog()" class="easyui-linkbutton" -->
<!-- 			iconCls="icon-add" plain="true">添加</a> -->
				<a name="login" value="退出系统" class="easyui-linkbutton" plain="true"
				href='${pageContext.request.contextPath}/login1' style="font-size:18px;">退出</a>
				&nbsp;&nbsp;<span style="color: green;">${username}</span>
				<a href="javascript:openUserAddDialog()" class="easyui-linkbutton"
			iconCls="icon-add" plain="true">群聊</a>
			</div>
		</div>
	</div>

	<div region="south" border="true"
		style="overflow: hidden; height: 40px;">
		<div class="footer">
			版权所有：<a
				href="https://mail.qq.com/cgi-bin/frame_html?sid=aq4ZfxoEiDEqgBFJ&r=4f9c574117f46fd5d54f4aceedcb4530"
				style="text-decoration: none">6518-菜鸟小组工作室</a>
		</div>
	</div>
	<div region="west" title="功能菜单" style="width: 200px;">

		<div id="aa" class="easyui-accordion"
			style="position: absolute; top: 27px; left: 0px; right: 0px; bottom: 0px; overflow: scroll;">

			<div title="前台管理" selected="true"
				style="overflow: scroll; padding: 10px; background-color: #F8FAFF">
				<ul class="easyui-tree">
					<li><span>预定房间</span></li>
					<li><span>预定退房</span></li>
					<li><span>开房操作</span></li>
					<li><span>换房操作</span></li>
					<li><span>交款续房</span></li>
					<li><span>销售商品</span></li>
					<li><span>赔偿操作</span></li>
					<li><span>其它消费</span></li>
					<li><span><a href="#"
					style="text-decoration: none; color: black;">退房操作</a></span></li>
				</ul>
			</div>
			<div title="客房管理" style="padding: 10px;">content2</div>
			<div title="订餐管理">content3</div>
			<div title="仓库管理">content4</div>
			<div title="房卡管理">content5</div>
			<div title="财务管理">content6</div>
			<div title="人事管理">content7</div>
			<div title="用户管理">content8</div>
			<div title="查询统计">content9</div>
			<div title="加盟商管理">
				<a href="${pageContext.request.contextPath }/l"
					style="text-decoration: none; color: black;">查看信息</a>
			</div>
			<div title="娱乐服务管理">content11</div>
			<div title="在线人工咨询">content12</div>
			<div title="客户意见反馈">content13</div>
			<div title="挂账管理">content14</div>
			<div title="系统初始化设置">content16</div>
		</div>
	</div>
	<div id="mainPanle" region="center" border="false">
		<div id="tabs" class="easyui-tabs" fit="true">
			<div title="客房经营" style="padding: 20px;" id="home">
				<h1>Welcome to jQuery UI!</h1>
			</div>
			<div title="订餐菜品" style="padding: 20px;" id="home1">
				<h1>Welcome to jQuery</h1>
			</div>
			<div title="订单详情" style="padding: 20px;" id="home2">
				<h1>Welcome</h1>
			</div>
			<div title="受欢迎度" style="padding: 20px;" id="home2">
			
			<div id="dlg" class="easyui-dialog"
			style="width: 400px;height:200px;padding:10px 10px;" closed="true"
			buttons="#dlg-buttons">
			<form method="post" id="fm">
				<table cellspacing="8px;">
					<tr>
						<td>登录名：</td>
						<td><input type="text" id="loginname" name="loginname"
							class="easyui-validatebox" required="true" /> <span
							style="color: red">*</span>
						</td>
					<tr>
						<td>密码：</td>
						<td><input type="password" id="password" name="password"
							class="easyui-validatebox" required="true" /> <span
							style="color: red">*</span>
						</td>
						<td>	</td>
							
					</tr>
					
				</table>
				<div id="dlg-buttons">
					<a href="javascript:saveUser()" class="easyui-linkbutton"
					iconCls="icon-ok">发送</a> <a href="javascript:closeUserDialog()"
					class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
				<div id="msg"></div>
				</div>
			</form>
			</div>
		</div>
	</div>
	</div>
</body>
</html>