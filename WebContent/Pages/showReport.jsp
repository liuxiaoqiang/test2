<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<script type="text/javascript">
			function isAcrobatPluginInstall(){
				var flag = false;
				// 如果是firefox浏览器
				if (navigator.plugins && navigator.plugins.length) {
					for (x = 0; x < navigator.plugins.length; x++) {
						if (navigator.plugins[x].name == 'Adobe Acrobat') {
							flag = true;
						}
					}
				}else if (window.ActiveXObject) { // 下面代码都是处理IE浏览器的情况 
					for (x = 2; x < 10; x++) {
						try {
							oAcro = eval("new ActiveXObject('PDF.PdfCtrl." + x + "');");
							if(oAcro){
								flag = true;
							}
						}catch(e){
							flag = false;
						}
					}
					try {
						oAcro4 = new ActiveXObject('PDF.PdfCtrl.1');
						if (oAcro4){
							flag = true;
						}
					} catch (e) {
						flag = false;
					}
					try {
						oAcro7 = new ActiveXObject('AcroPDF.PDF.1');
							if (oAcro7){
								flag = true;
							}
					}catch(e){
						flag = false;
					}
				}
				if(flag){
					return true;
				}else{
					alert("对不起,您还没有安装PDF阅读器软件呢,为了方便预览PDF文档,请选择安装！");
					location = 'http://ardownload.adobe.com/pub/adobe/reader/win/9.x/9.3/chs/AdbeRdr930_zh_CN.exe';
				}
				return flag;
			}
		</script>
		<title>ReportJSP</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body onload="isAcrobatPluginInstall()">
<!--		<c:redirect url="/main/tractorInfo.html?action=tractorSteerReport"></c:redirect>-->
		<!--<a href="<c:url value="/report/pdf" />"> <img border=0 src="./Public/Images/icon/pdf.gif" />导出PDF打印</a>-->
		<!--<%-->
<!--	JasperPrint jasperPrint = (JasperPrint)request.getSession().getAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE);-->
<!--	JRHtmlExporter exporter = new JRHtmlExporter();-->
<!--	StringBuffer sbuffer = new StringBuffer();-->
<!--	exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);-->
<!--	exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);-->
<!--	exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);-->
<!--	exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "servlets/image?image=");-->
<!--	exporter.exportReport();-->
<!--%>-->
<div id="showReport"></div>
	</body>
</html>
