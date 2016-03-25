<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String sessionID=request.getSession().getId();
	String userName="游客";
	String unitID="0";
	String plateHead="云00";
	String unitAddress = "";
	String Oper="无";
	if(request.getSession().getAttribute("username")==null){
		response.sendRedirect("./Pages/index.jsp");
	}else{
		userName=request.getSession().getAttribute("username").toString();
		unitID=request.getSession().getAttribute("unitid").toString();
		plateHead=request.getSession().getAttribute("platecode").toString();
		unitAddress=request.getSession().getAttribute("unitAddress").toString();
	}
	if(request.getSession().getAttribute("user")==null){
		response.sendRedirect("./Pages/index.jsp");
	}
	if(request.getSession().getAttribute("oper")!=null){
		Oper=request.getSession().getAttribute("oper").toString();
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>云南省曲靖市农机安全监理网络管理信息系统</title>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="Pragma" content="no-cache, must-revalidate, no-store"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%= path %>/Public/Css/icon.css"/>	
	<link rel="stylesheet" type="text/css" href="<%= path %>/Public/ExtJS/resources/css/ext-all.css" />
	<link rel="stylesheet" type="text/css" href="<%= path %>/Public/Css/loginView.css"/>
	<link rel="stylesheet" type="text/css" href="<%= path %>/Public/Css/ynzcExtendend.css"/>
	<link rel="stylesheet" type="text/css" href="<%= path %>/Public/Css/ynzcExtendend.css"/>
	<link rel="stylesheet" type="text/css" href="<%= path %>/Public/Css/Ext.ux.form.LovCombo.css"/>		
  </head>
  <body onbeforeunload="history.go(0)">
  	<div id="loading-mask" style="background-color: #90B0CC"></div>
  	<div id="loading" style="background-color: #90B0CC">
    	<div class="loading-indicator" style="background-color: #90B0CC">
    	<img src="Public/Images/desktop/loading32.gif" width="32" height="32" style="margin-right:8px;float:left;vertical-align:top;"/>
    	云南省曲靖市农机安全监理网络管理信息系统 <br>
    	<span id="loading-msg"></span>
    	</div>
 	</div>
 	<!-- LIBS -->
 	
    <script type="text/javascript">document.getElementById('loading-msg').innerHTML = '初始化核心代码...';</script>
 	<script type="text/javascript" src="<%= path %>/Public/ExtJS/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="<%= path %>/Public/ExtJS/ext-all.js"></script>  
 	<script type="text/javascript" src="<%= path %>/Public/ExtJS/ux/Toast.js"></script> 	
	<script type="text/javascript" src="<%= path %>/Public/ExtJS/ux/TabCloseMenu.js"></script>
	<script type="text/javascript" src="<%= path %>/Public/ExtJS/ux/Ext.ux.grid.Search.js"></script>
	<script type="text/javascript" src="<%= path %>/Public/ExtJS/ux/Ext.ux.grid.RowExpander.js"></script>
    <script type="text/javascript" src="<%= path %>/Public/ExtJS/zh_CN/ext-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%= path %>/Public/Scripts/Main/PicPanel.js"></script>
    <script type="text/javascript" src="<%= path %>/Public/Scripts/Main/ReportWin.js"></script>
    <script type="text/javascript" src="<%= path %>/Public/ExtJS/ux/Ext.ux.form.LovCombo.js"></script>  	 	
 	<!-- ENDLIBS -->			
 	
 	<script type="text/javascript"> var loginUser='<%=userName%>'</script>
 	<script type="text/javascript"> var UnitID='<%=unitID%>'</script>
 	<script type="text/javascript"> var PlateNumHead='<%=plateHead%>'</script>
 	<script type="text/javascript"> var UnitAddress='<%=unitAddress%>'</script>
 	<script type="text/javascript"> var SessionID='<%=sessionID%>'</script>
 	<script type="text/javascript"> var Oper='<%=Oper%>'</script>
 	
    <script type="text/javascript">document.getElementById('loading-msg').innerHTML = '初始化页面库...';</script>
    <script type="text/javascript">document.getElementById('loading-msg').innerHTML = '计算处理状态...';</script>
    <script type="text/javascript">document.getElementById('loading-msg').innerHTML = '初始化数据...';</script>
    <script type="text/javascript" src="<%= path %>/Public/Scripts/Main/PublicStore.js"></script>
    <script type="text/javascript" src="<%= path %>/Public/Scripts/Main/jsUtil.js"></script>
    <script type="text/javascript" src="<%= path %>/Public/Scripts/Main/SendInfoNewsIndex.js"></script>
  	<script type="text/javascript" src="<%= path %>/Public/Scripts/Main/SendInfoMessageIndex.js"></script>
  	<script type="text/javascript" src="<%= path %>/Public/Scripts/Main/SendInfoWelCome.js"></script>
  	<script type="text/javascript" src="<%= path %>/Public/Scripts/Desktop/desktop.js"></script>
  	<script type="text/javascript" src="<%= path %>/Public/Scripts/Desktop/MessagesWin.js"></script>
    <script type="text/javascript">document.getElementById('loading-msg').innerHTML = '欢迎进入系统...';</script>
    <div id='body'></div>
  </body>
</html>