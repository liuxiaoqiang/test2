<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	
	
		<base href="<%=basePath%>">

		<title>云南省曲靖市农机安全监理网络管理信息系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="农机,农机安全,农机监理网络管理信息系统">
		<meta http-equiv="description" content="云南省曲靖市农机安全监理网络管理信息系统">
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/Public/ExtJS/resources/css/ext-all.css" />
		<script type="text/javascript"
			src="<%=path%>/Public/ExtJS/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="<%=path%>/Public/ExtJS/ext-all.js"></script>
		<script type="text/javascript" src="<%=path%>/Public/ExtJS/ux/Toast.js"></script>

		<!-- MAIN WINDOW -->
		<script type="text/javascript" src="<%=path%>/Public/Scripts/Login/Login.js"></script>
	</head>

	<body bgcolor="#90B0CC">
		<div id="body"></div>
	</body>
</html>


