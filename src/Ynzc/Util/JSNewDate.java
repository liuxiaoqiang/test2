package Ynzc.Util;
/**
 * 
 * TODO:JS日期控件
 * <br>
 * <b>Company</b>:
 *             云艺网络
 * <br>
 * <b>Writer</b>: 
 *          　　<a href="mailto:yinyiyin@126.com">云艺网络</a><br> 
 * <b>CreateTime<b>:
 *          　　2009-12-21 上午10:37:36
 */
public class JSNewDate {
	public static StringBuffer getPrintJSNewDate(){
		StringBuffer sb=new StringBuffer();
		sb.append("<script type='text/javascript'>");
		sb.append("<!-- \n");
		sb.append(" var bMoveable=true;	 \n");
		sb.append(" var _VersionInfo='';	  \n");
		sb.append("  \n");
		sb.append("var strFrame;	 \n");
		sb.append("document.writeln('<iframe id=meizzDateLayer  frameborder=0 style=\"position: absolute; width: 144; height: 211; z-index: 9998; display: none\"></iframe>');  \n");
		sb.append("strFrame='<style>'; \n");
		sb.append("strFrame+='INPUT.button{BORDER-RIGHT: #9496E1 1px solid;BORDER-TOP: #9496E1 1px solid;BORDER-LEFT: #9496E1 1px solid;'; \n");
		sb.append("strFrame+='BORDER-BOTTOM: #9496E1 1px solid;BACKGROUND-COLOR: #fff8ec;font-family:宋体;}'; \n");
		sb.append("strFrame+='TD{FONT-SIZE: 9pt;font-family:宋体;}'; \n");
		sb.append("strFrame+='</style>'; \n");
		sb.append("strFrame+='<scr' + 'ipt>'; \n");
		sb.append("strFrame+='var datelayerx,datelayery'; \n");
		sb.append("strFrame+='var bDrag'; \n");
		sb.append("strFrame+='function document.onmousemove()	/*在鼠标移动事件中，如果开始拖动日历，则移动日历*/';  \n");
		sb.append("strFrame+='{if(bDrag && window.event.button==1)'; \n");
		sb.append("strFrame+='	{var DateLayer=parent.document.all.meizzDateLayer.style;'; \n");
		sb.append("strFrame+='		DateLayer.posLeft += window.event.clientX-datelayerx;/*由于每次移动以后鼠标位置都恢复为初始的位置，因此写法与div中不同*/'; \n");
		sb.append("strFrame+='		DateLayer.posTop += window.event.clientY-datelayery;}}'; \n");
		sb.append("strFrame+='function DragStart()		/*开始日历拖动*/'; \n");
		sb.append("strFrame+='{var DateLayer=parent.document.all.meizzDateLayer.style;'; \n");
		sb.append("strFrame+='	datelayerx=window.event.clientX;'; \n");
		sb.append("strFrame+='	datelayery=window.event.clientY;'; \n");
		sb.append("strFrame+='	bDrag=true;}'; \n");
		sb.append("strFrame+='function DragEnd(){		/*结束日历拖动*/'; \n");
		sb.append("strFrame+='	bDrag=false;}'; \n");
		sb.append("strFrame+='</scr' + 'ipt>'; \n");
		sb.append("strFrame+='<div style=\"z-index:9999;position: absolute; left:0; top:0;\" onselectstart=\"return false\"><span id=tmpSelectYearLayer  style=\"z-index: 9999;position: absolute;top: 3; left: 19;display: none\"></span>'; \n");
		sb.append("strFrame+='<span id=tmpSelectMonthLayer  style=\"z-index: 9999;position: absolute;top: 3; left: 78;display: none\"></span>'; \n");
		sb.append("strFrame+='<table border=1 cellspacing=0 cellpadding=0 width=142 height=160 bordercolor=#9496E1 bgcolor=#9496E1 >'; \n");
		sb.append("strFrame+='  <tr ><td width=142 height=23  bgcolor=#FFFFFF><table border=0 cellspacing=1 cellpadding=0 width=140  height=23>'; \n");
		sb.append("strFrame+='      <tr align=center ><td width=16 align=center bgcolor=#9496E1 style=\"font-size:12px;cursor: hand;color: #FFFFFF\" '; \n");
		sb.append("strFrame+='        onclick=\"parent.meizzPrevM()\" title=\"向前翻 1 月\" ><b >&lt;</b>'; \n");
		sb.append("strFrame+='        </td><td width=60 align=center style=\"font-size:12px;cursor:default\"  '; \n");
		sb.append("strFrame+='onmouseover=\"style.backgroundColor=\\'#C6C7EF\\'\" onmouseout=\"style.backgroundColor=\\'white\\'\" '; \n");
		sb.append("strFrame+='onclick=\"parent.tmpSelectYearInnerHTML(this.innerText.substring(0,4))\" title=\"点击这里选择年份\"><span  id=meizzYearHead></span></td>'; \n");
		sb.append("strFrame+='<td width=48 align=center style=\"font-size:12px;cursor:default\"  onmouseover=\"style.backgroundColor=\\'#C6C7EF\\'\" '; \n");
		sb.append("strFrame+=' onmouseout=\"style.backgroundColor=\\'white\\'\" onclick=\"parent.tmpSelectMonthInnerHTML(this.innerText.length==3?this.innerText.substring(0,1):this.innerText.substring(0,2))\"'; \n");
		sb.append("strFrame+='        title=\"点击这里选择月份\"><span id=meizzMonthHead ></span></td>'; \n");
		sb.append("strFrame+='        <td width=16 bgcolor=#9496E1 align=center style=\"font-size:12px;cursor: hand;color: #FFFFFF\" '; \n");
		sb.append("strFrame+='         onclick=\"parent.meizzNextM()\" title=\"向后翻 1 月\" ><b >&gt;</b></td></tr>'; \n");
		sb.append("strFrame+='    </table></td></tr>'; \n");
		sb.append("strFrame+='  <tr ><td width=142 height=18 >'; \n");
		sb.append("strFrame+='<table border=1 cellspacing=0 cellpadding=0 bgcolor=#9496E1 ' + (bMoveable? 'onmousedown=\"DragStart()\" onmouseup=\"DragEnd()\"':''); \n");
		sb.append("strFrame+=' BORDERCOLORLIGHT=#9496E1 BORDERCOLORDARK=#FFFFFF width=140 height=20  style=\"cursor:' + (bMoveable ? 'move':'default') + '\">'; \n");
		sb.append("strFrame+='<tr  align=center valign=bottom><td style=\"font-size:12px;color:#FFFFFF\" >日</td>'; \n");
		sb.append("strFrame+='<td style=\"font-size:12px;color:#FFFFFF\" >一</td><td style=\"font-size:12px;color:#FFFFFF\" >二</td>'; \n");
		sb.append("strFrame+='<td style=\"font-size:12px;color:#FFFFFF\" >三</td><td style=\"font-size:12px;color:#FFFFFF\" >四</td>'; \n");
		sb.append("strFrame+='<td style=\"font-size:12px;color:#FFFFFF\" >五</td><td style=\"font-size:12px;color:#FFFFFF\" >六</td></tr>'; \n");
		sb.append("strFrame+='</table></td></tr>'; \n");
		sb.append("strFrame+='  <tr ><td width=142 height=120 >'; \n");
		sb.append("strFrame+='    <table border=1 cellspacing=2 cellpadding=0 BORDERCOLORLIGHT=#9496E1 BORDERCOLORDARK=#FFFFFF bgcolor=#fff8ec width=140 height=120 >'; \n");
		sb.append("var n=0; for (j=0;j<5;j++){ strFrame+= ' <tr align=center >'; for (i=0;i<7;i++){ \n");
		sb.append("strFrame+='<td width=20 height=20 id=meizzDay'+n+' style=\"font-size:12px\"  onclick=parent.meizzDayClick(this.innerText,0)></td>';n++;} \n");
		sb.append("strFrame+='</tr>'; \n } \n");
		sb.append("strFrame+='      <tr align=center >'; \n");
		sb.append("for (i=35;i<39;i++)strFrame+='<td width=20 height=20 id=meizzDay'+i+' style=\"font-size:12px\"  onclick=\"parent.meizzDayClick(this.innerText,0)\"></td>'; \n");
		sb.append("strFrame+='        <td colspan=3 align=right ><span onclick=parent.closeLayer() style=\"font-size:12px;cursor: hand\"'; \n");
		sb.append("strFrame+='          title=\"' + _VersionInfo + '\"><u>关闭</u></span>&nbsp;</td></tr>'; \n");
		sb.append("strFrame+='    </table></td></tr><tr ><td >'; \n");
		sb.append("strFrame+='        <table border=0 cellspacing=1 cellpadding=0 width=100%  bgcolor=#FFFFFF>'; \n");
		sb.append("strFrame+='          <tr ><td  align=left><input  type=button class=button value=\"<<\" title=\"向前翻 1 年\" onclick=\"parent.meizzPrevY()\" '; \n");
		sb.append("strFrame+='             onfocus=\"this.blur()\" style=\"font-size: 12px; height: 20px\"><input  class=button title=\"向前翻 1 月\" type=button '; \n");
		sb.append("strFrame+='             value=\"< \" onclick=\"parent.meizzPrevM()\" onfocus=\"this.blur()\" style=\"font-size: 12px; height: 20px\"></td><td '; \n");
		sb.append("strFrame+='              align=center><input  type=button class=button value=今天 onclick=\"parent.meizzToday()\" '; \n");
		sb.append("strFrame+='             onfocus=\"this.blur()\" title=\"当前日期\" style=\"font-size: 12px; height: 20px; cursor:hand\"></td><td '; \n");
		sb.append("strFrame+='              align=right><input  type=button class=button value=\" >\" onclick=\"parent.meizzNextM()\" '; \n");
		sb.append("strFrame+='             onfocus=\"this.blur()\" title=\"向后翻 1 月\" class=button style=\"font-size: 12px; height: 20px\"><input '; \n");
		sb.append("strFrame+='              type=button class=button value=\">>\" title=\"向后翻 1 年\" onclick=\"parent.meizzNextY()\"'; \n");
		sb.append("strFrame+='             onfocus=\"this.blur()\" style=\"font-size: 12px; height: 20px\"></td>'; \n");
		sb.append("strFrame+='</tr></table></td></tr></table></div>'; \n");
		sb.append("window.frames.meizzDateLayer.document.writeln(strFrame); \n");
		sb.append("window.frames.meizzDateLayer.document.close();		//解决ie进度条不结束的问题 \n");
		sb.append("//==================================================== WEB 页面显示部分 ====================================================== \n");
		sb.append("var outObject; \n");
		sb.append("var outButton;		//点击的按钮 \n");
		sb.append("var outDate=\"\";		//存放对象的日期 \n");
		sb.append("var odatelayer=window.frames.meizzDateLayer.document.all;		//存放日历对象 \n");
		sb.append("function setday(tt,obj) //主调函数 \n");
		sb.append("{ \n");
		sb.append("if (arguments.length >  2){alert(\"对不起！传入本控件的参数太多！\");return;} \n");
		sb.append("if (arguments.length == 0){alert(\"对不起！您没有传回本控件任何参数！\");return;} \n");
		sb.append("var dads  = document.all.meizzDateLayer.style; \n");
		sb.append("var th = tt; \n");
		sb.append("var ttop  = tt.offsetTop;     //TT控件的定位点高 \n");
		sb.append("var thei  = tt.clientHeight;  //TT控件本身的高 \n");
		sb.append("var tleft = tt.offsetLeft;    //TT控件的定位点宽 \n");
		sb.append("var ttyp  = tt.type;          //TT控件的类型 \n");
		sb.append("while (tt = tt.offsetParent){ttop+=tt.offsetTop; tleft+=tt.offsetLeft;} \n");
		sb.append("dads.top  = (ttyp==\"image\")? ttop+thei : ttop+thei+6; \n");
		sb.append("dads.left = tleft; \n");
		sb.append("outObject = (arguments.length == 1) ? th : obj; \n");
		sb.append("outButton = (arguments.length == 1) ? null : th;	//设定外部点击的按钮 \n");
		sb.append("//根据当前输入框的日期显示日历的年月\n");
		sb.append("var reg = /^(\\d+)-(\\d{1,2})-(\\d{1,2})$/; \n");
		sb.append("var r = outObject.value.match(reg); \n");
		sb.append("if(r!=null){ \n");
		sb.append("r[2]=r[2]-1; \n");
		sb.append("var d= new Date(r[1], r[2],r[3]); \n");
		sb.append("if(d.getFullYear()==r[1] && d.getMonth()==r[2] && d.getDate()==r[3]){ \n");
		sb.append("outDate=d;		//保存外部传入的日期 \n");
		sb.append("} \n");
		sb.append("else outDate=\"\"; \n");
		sb.append("meizzSetDay(r[1],r[2]+1); \n");
		sb.append("} \n");
		sb.append("else{ \n");
		sb.append("outDate=\"\"; \n");
		sb.append("meizzSetDay(new Date().getFullYear(), new Date().getMonth() + 1); \n");
		sb.append("} \n");
		sb.append("dads.display = ''; \n");
		sb.append("event.returnValue=false; \n");
		sb.append("} \n");
		sb.append("var MonHead = new Array(12);    		   //定义阳历中每个月的最大天数 \n");
		sb.append("MonHead[0] = 31; MonHead[1] = 28; MonHead[2] = 31; MonHead[3] = 30; MonHead[4]  = 31; MonHead[5]  = 30; \n");
		sb.append("MonHead[6] = 31; MonHead[7] = 31; MonHead[8] = 30; MonHead[9] = 31; MonHead[10] = 30; MonHead[11] = 31; \n");
		sb.append("var meizzTheYear=new Date().getFullYear(); //定义年的变量的初始值 \n");
		sb.append("var meizzTheMonth=new Date().getMonth()+1; //定义月的变量的初始值 \n");
		sb.append("var meizzWDay=new Array(39);               //定义写日期的数组 \n");
		sb.append("function document.onclick() //任意点击时关闭该控件	//ie6的情况可以由下面的切换焦点处理代替 \n");
		sb.append("{ \n");
		sb.append(" with(window.event) \n");
		sb.append("{ if (srcElement.getAttribute(\"Author\")==null && srcElement != outObject && srcElement != outButton) \n");
		sb.append("  closeLayer(); \n");
		sb.append("  } \n");
		sb.append(" } \n");
		sb.append(" function document.onkeyup()		//按Esc键关闭，切换焦点关闭 \n");
		sb.append("  { \n");
		sb.append("    if (window.event.keyCode==27){ \n");
		sb.append("		if(outObject)outObject.blur(); \n");
		sb.append("		closeLayer(); \n");
		sb.append("	} \n");
		sb.append("	else if(document.activeElement) \n");
		sb.append("		if(document.activeElement.getAttribute(\"Author\")==null && document.activeElement != outObject && document.activeElement != outButton) \n");
		sb.append("		{ \n");
		sb.append("			closeLayer(); \n");
		sb.append("		} \n");
		sb.append("  } \n");
		sb.append("  function meizzWriteHead(yy,mm)  //往 head 中写入当前的年与月 \n");
		sb.append("  { \n");
		sb.append("	odatelayer.meizzYearHead.innerText  = yy + \" 年\"; \n");
		sb.append("    odatelayer.meizzMonthHead.innerText = mm + \" 月\"; \n");
		sb.append("  } \n");
		sb.append("  function tmpSelectYearInnerHTML(strYear) //年份的下拉框 \n");
		sb.append(" { \n");
		sb.append("  if (strYear.match(/\\D/)!=null){alert(\"年份输入参数不是数字！\");return;} \n");
		sb.append("  var m = (strYear) ? strYear : new Date().getFullYear();");
		sb.append("  if (m < 1000 || m > 9999) {alert(\"年份值不在 1000 到 9999 之间！\");return;}");
		sb.append("  var n = m - 10; \n");
		sb.append("  if (n < 1000) n = 1000; \n");
		sb.append("  if (n + 26 > 9999) n = 9974; \n");
		sb.append("  var s = \"<select  name=tmpSelectYear style='font-size: 12px' \" \n");
		sb.append("     s += \"onblur='document.all.tmpSelectYearLayer.style.display=\\\"none\\\"' \" \n");
		sb.append("     s += \"onchange='document.all.tmpSelectYearLayer.style.display=\\\"none\\\";\" \n");
		sb.append("     s += \"parent.meizzTheYear = this.value; parent.meizzSetDay(parent.meizzTheYear,parent.meizzTheMonth)'>\\r\\n\"; \n");
		sb.append("  var selectInnerHTML = s; \n");
		sb.append("  for (var i = n; i < n + 26; i++) \n");
		sb.append("  { \n");
		sb.append("    if (i == m) \n");
		sb.append("       {selectInnerHTML += \"<option  value='\" + i + \"' selected>\" + i + \"年\" + \"</option>\\r\\n\";} \n");
		sb.append("    else {selectInnerHTML += \"<option  value='\" + i + \"'>\" + i + \"年\" + \"</option>\\r\\n\";} \n");
		sb.append("  } \n");
		sb.append("  selectInnerHTML += \"</select>\"; \n");
		sb.append("  odatelayer.tmpSelectYearLayer.style.display=\"\"; \n");
		sb.append("  odatelayer.tmpSelectYearLayer.innerHTML = selectInnerHTML; \n");
		sb.append("  odatelayer.tmpSelectYear.focus(); \n");
		sb.append("  } \n");
		sb.append("  function tmpSelectMonthInnerHTML(strMonth) //月份的下拉框 \n");
		sb.append(" { \n");
		sb.append("  if (strMonth.match(/\\D/)!=null){alert(\"月份输入参数不是数字！\");return;} \n");
		sb.append("  var m = (strMonth) ? strMonth : new Date().getMonth() + 1; \n");
		sb.append("  var s = \"<select  name=tmpSelectMonth style='font-size: 12px' \" \n");
		sb.append("     s += \"onblur='document.all.tmpSelectMonthLayer.style.display=\\\"none\\\"' \" \n");
		sb.append("     s += \"onchange='document.all.tmpSelectMonthLayer.style.display=\\\"none\\\";\" \n");
		sb.append("     s += \"parent.meizzTheMonth = this.value; parent.meizzSetDay(parent.meizzTheYear,parent.meizzTheMonth)'>\\r\\n\"; \n");
		sb.append("  var selectInnerHTML = s; \n");
		sb.append("  for (var i = 1; i < 13; i++) \n");
		sb.append("  { \n");
		sb.append("    if (i == m) \n");
		sb.append("       {selectInnerHTML += \"<option  value='\"+i+\"' selected>\"+i+\"月\"+\"</option>\\r\\n\";} \n");
		sb.append("    else {selectInnerHTML += \"<option  value='\"+i+\"'>\"+i+\"月\"+\"</option>\\r\\n\";} \n");
		sb.append("  } \n");
		sb.append("  selectInnerHTML += \"</select>\"; \n");
		sb.append("  odatelayer.tmpSelectMonthLayer.style.display=\"\"; \n");
		sb.append("  odatelayer.tmpSelectMonthLayer.innerHTML = selectInnerHTML; \n");
		sb.append("  odatelayer.tmpSelectMonth.focus(); \n");
		sb.append(" } \n");
		sb.append("  function closeLayer()               //这个层的关闭 \n");
		sb.append("  { \n");
		sb.append("    document.all.meizzDateLayer.style.display=\"none\"; \n");
		sb.append("  }");
		sb.append("  function IsPinYear(year)            //判断是否闰平年 \n");
		sb.append("  { \n");
		sb.append("    if (0==year%4&&((year%100!=0)||(year%400==0))) return true;else return false; \n");
		sb.append("  } \n");
		sb.append("  function GetMonthCount(year,month)  //闰年二月为29天 \n");
		sb.append("  { \n");
		sb.append("    var c=MonHead[month-1];if((month==2)&&IsPinYear(year)) c++;return c; \n");
		sb.append("  } \n");
		sb.append("  function GetDOW(day,month,year)     //求某天的星期几 \n");
		sb.append("  { \n");
		sb.append("    var dt=new Date(year,month-1,day).getDay()/7; return dt; \n");
		sb.append("  } \n");
		sb.append("  function meizzPrevY()  //往前翻 Year \n");
		sb.append("  { \n");
		sb.append("    if(meizzTheYear > 999 && meizzTheYear <10000){meizzTheYear--;} \n");
		sb.append("    else{alert(\"年份超出范围（1000-9999）！\");} \n");
		sb.append("    meizzSetDay(meizzTheYear,meizzTheMonth); \n");
		sb.append("  } \n");
		sb.append("  function meizzNextY()  //往后翻 Year\n");
		sb.append("  { \n");
		sb.append("    if(meizzTheYear > 999 && meizzTheYear <10000){meizzTheYear++;} \n");
		sb.append("    else{alert(\"年份超出范围（1000-9999）！\");} \n");
		sb.append("    meizzSetDay(meizzTheYear,meizzTheMonth); \n");
		sb.append("  }");
		sb.append("  function meizzToday()  //Today Button \n");
		sb.append("  { \n");
		sb.append("	var today;");
		sb.append("    meizzTheYear = new Date().getFullYear(); \n");
		sb.append("    meizzTheMonth = new Date().getMonth()+1; \n");
		sb.append("    if(meizzTheMonth < 10){meizzTheMonth = \"0\" + meizzTheMonth;} \n");
		sb.append("    today=new Date().getDate(); \n");
		sb.append("    if(today < 10){today = \"0\" + today;} \n");
		sb.append("    if(outObject){ \n");
		sb.append("		outObject.value=meizzTheYear + \"-\" + meizzTheMonth + \"-\" + today; \n");
		sb.append("    } \n");
		sb.append("    closeLayer(); \n");
		sb.append("  }");
		sb.append(" function meizzPrevM()  //往前翻月份 \n");
		sb.append("  { \n");
		sb.append("    if(meizzTheMonth>1){meizzTheMonth--}else{meizzTheYear--;meizzTheMonth=12;} \n");
		sb.append("    meizzSetDay(meizzTheYear,meizzTheMonth); \n");
		sb.append("  } \n");
		sb.append("  function meizzNextM()  //往后翻月份 \n");
		sb.append("  { \n");
		sb.append("    if(meizzTheMonth==12){meizzTheYear++;meizzTheMonth=1}else{meizzTheMonth++} \n");
		sb.append("    meizzSetDay(meizzTheYear,meizzTheMonth); \n");
		sb.append("  } \n");
		sb.append("  function meizzSetDay(yy,mm)   //主要的写程序********** \n");
		sb.append("  {   \n");
		sb.append("  meizzWriteHead(yy,mm); \n");
		sb.append("  //设置当前年月的公共变量为传入值 \n");
		sb.append("  meizzTheYear=yy; \n");
		sb.append("  meizzTheMonth=mm; \n");
		sb.append("  for (var i = 0; i < 39; i++){meizzWDay[i]=\"\"};  //将显示框的内容全部清空 \n");
		sb.append("  var day1 = 1,day2=1,firstday = new Date(yy,mm-1,1).getDay();  //某月第一天的星期几 \n");
		sb.append("  for (i=0;i<firstday;i++)meizzWDay[i]=GetMonthCount(mm==1?yy-1:yy,mm==1?12:mm-1)-firstday+i+1	//上个月的最后几天 \n");
		sb.append("  for (i = firstday; day1 < GetMonthCount(yy,mm)+1; i++){meizzWDay[i]=day1;day1++;} \n");
		sb.append("  for (i=firstday+GetMonthCount(yy,mm);i<39;i++){meizzWDay[i]=day2;day2++} \n");
		sb.append("  for (i = 0; i < 39; i++) \n");
		sb.append("  { var da = eval(\"odatelayer.meizzDay\"+i)     //书写新的一个月的日期星期排列 \n");
		sb.append("    if (meizzWDay[i]!=\"\") \n");
		sb.append("      { \n");
		sb.append("		//初始化边框 \n");
		sb.append("		da.borderColorLight=\"#9496E1\"; \n");
		sb.append("		da.borderColorDark=\"#FFFFFF\"; \n");
		sb.append("		if(i<firstday)		//上个月的部分 \n");
		sb.append("		{ \n");
		sb.append("			da.innerHTML=\"<b><font color=gray>\" + meizzWDay[i] + \"</font></b>\"; \n");
		sb.append("			da.title=(mm==1?12:mm-1) +\"月\" + meizzWDay[i] + \"日\"; \n");
		sb.append("			da.onclick=Function(\"meizzDayClick(this.innerText,-1)\"); \n");
		sb.append("			if(!outDate) \n");
		sb.append("				da.style.backgroundColor = ((mm==1?yy-1:yy) == new Date().getFullYear() && \n");
		sb.append("					(mm==1?12:mm-1) == new Date().getMonth()+1 && meizzWDay[i] == new Date().getDate()) ?  \"#C6C7EF\":\"#E0E0E0\"; \n");
		sb.append("			else  \n");
		sb.append("			{ \n");
		sb.append("				da.style.backgroundColor =((mm==1?yy-1:yy)==outDate.getFullYear() && (mm==1?12:mm-1)== outDate.getMonth() + 1 &&  ");
		sb.append("				meizzWDay[i]==outDate.getDate())? \"#FFD700\" : ");
		sb.append("				(((mm==1?yy-1:yy) == new Date().getFullYear() && (mm==1?12:mm-1) == new Date().getMonth()+1 && ");
		sb.append("				meizzWDay[i] == new Date().getDate()) ? \"#C6C7EF\":\"#E0E0E0\"); \n");
		sb.append("				//将选中的日期显示为凹下去  \n");
		sb.append("				if((mm==1?yy-1:yy)==outDate.getFullYear() && (mm==1?12:mm-1)== outDate.getMonth() + 1 && ");
		sb.append("				meizzWDay[i]==outDate.getDate())  \n");
		sb.append("				{  \n");
		sb.append("					da.borderColorLight=\"#FFFFFF\";  \n");
		sb.append("					da.borderColorDark=\"#9496E1\";  \n");
		sb.append("				} \n");
		sb.append("			} \n");
		sb.append("		} \n");
		sb.append("		else if (i>=firstday+GetMonthCount(yy,mm))		//下个月的部分  \n");
		sb.append("		{ \n");
		sb.append("			da.innerHTML=\"<b><font color=gray>\" + meizzWDay[i] + \"</font></b>\"; \n");
		sb.append("			da.title=(mm==12?1:mm+1) +\"月\" + meizzWDay[i] + \"日\"; \n");
		sb.append("			da.onclick=Function(\"meizzDayClick(this.innerText,1)\"); \n");
		sb.append("			if(!outDate) \n");
		sb.append("				da.style.backgroundColor = ((mm==12?yy+1:yy) == new Date().getFullYear() && ");
		sb.append("					(mm==12?1:mm+1) == new Date().getMonth()+1 && meizzWDay[i] == new Date().getDate()) ?   \"#C6C7EF\":\"#E0E0E0\";  \n");
		sb.append("			else  \n");
		sb.append("			{  \n");
		sb.append("				da.style.backgroundColor =((mm==12?yy+1:yy)==outDate.getFullYear() && (mm==12?1:mm+1)== outDate.getMonth() + 1 && ");
		sb.append("				meizzWDay[i]==outDate.getDate())? \"#FFD700\" : ");
		sb.append("				(((mm==12?yy+1:yy) == new Date().getFullYear() && (mm==12?1:mm+1) == new Date().getMonth()+1 && meizzWDay[i] == new Date().getDate()) ? \"#C6C7EF\":\"#E0E0E0\");  \n");
		sb.append("//将选中的日期显示为凹下去  \n");
		sb.append("				if((mm==12?yy+1:yy)==outDate.getFullYear() && (mm==12?1:mm+1)== outDate.getMonth() + 1 && ");
		sb.append("				meizzWDay[i]==outDate.getDate())");
		sb.append("				{  \n");
		sb.append("					da.borderColorLight=\"#FFFFFF\"; \n");
		sb.append("					da.borderColorDark=\"#9496E1\"; \n");
		sb.append("				} \n");
		sb.append("			} \n");
		sb.append("		} \n");
		sb.append("		else		//本月的部分  \n");
		sb.append("		{ \n");
		sb.append("			da.innerHTML=\"<b>\" + meizzWDay[i] + \"</b>\"; \n");
		sb.append("			da.title=mm +\"月\" + meizzWDay[i] + \"日\"; \n");
		sb.append("			da.onclick=Function(\"meizzDayClick(this.innerText,0)\");		//给td赋予onclick事件的处理  \n");
		sb.append("			//如果是当前选择的日期，则显示暗黄色的背景；如果是当前日期，则显示亮紫色的背景 \n");
		sb.append("			if(!outDate) \n");
		sb.append("				da.style.backgroundColor = (yy == new Date().getFullYear() && mm == new Date().getMonth()+1 && meizzWDay[i] == new Date().getDate())? \"#C6C7EF\":\"#E0E0E0\"; \n");
		sb.append("			else  \n");
		sb.append("			{ \n");
		sb.append("				da.style.backgroundColor =(yy==outDate.getFullYear() && mm== outDate.getMonth() + 1 && meizzWDay[i]==outDate.getDate())? \"#FFD700\":((yy == new Date().getFullYear() && mm == new Date().getMonth()+1 && meizzWDay[i] == new Date().getDate())? \"#C6C7EF\":\"#E0E0E0\"); \n");
		sb.append("//将选中的日期显示为凹下去 \n");
		sb.append("				if(yy==outDate.getFullYear() && mm== outDate.getMonth() + 1 && meizzWDay[i]==outDate.getDate()) \n");
		sb.append("				{ \n");
		sb.append("					da.borderColorLight=\"#FFFFFF\"; \n");
		sb.append("					da.borderColorDark=\"#9496E1\"; \n");
		sb.append("				} \n");
		sb.append("			} \n");
		sb.append("		} \n");
		sb.append("        da.style.cursor=\"hand\"; \n");
		sb.append("      }");
		sb.append("    else{da.innerHTML=\"\";da.style.backgroundColor=\"\";da.style.cursor=\"default\";} \n");
		sb.append("  }");
		sb.append(" }");
		sb.append("  function meizzDayClick(n,ex)  //点击显示框选取日期，主输入函数************* \n");
		sb.append("  { \n");
		sb.append("  var yy=meizzTheYear; \n");
		sb.append("  var mm = parseInt(meizzTheMonth)+ex;	//ex表示偏移量，用于选择上个月份和下个月份的日期 \n");
		sb.append("	//判断月份，并进行对应的处理 \n");
		sb.append("	if(mm<1){ \n");
		sb.append("		yy--; \n");
		sb.append("		mm=12+mm; \n");
		sb.append("	} \n");
		sb.append("	else if(mm>12){ \n");
		sb.append("		yy++; \n");
		sb.append("		mm=mm-12; \n");
		sb.append("	} \n");
		sb.append("  if (mm < 10){mm = \"0\" + mm;} \n");
		sb.append("  if (outObject) \n");
		sb.append("  { \n");
		sb.append("    if (!n) { \n");
		sb.append("      return;} \n");
		sb.append("    if ( n < 10){n = \"0\" + n;} \n");
		sb.append("    outObject.value= yy + \"-\" + mm + \"-\" + n ;  //注：在这里你可以输出改成你想要的格式 \n");
		sb.append("    closeLayer(); \n");
		sb.append("  } \n");
		sb.append("  else {closeLayer(); alert(\"您所要输出的控件对象并不存在！\");} \n");
		sb.append("} \n");
		sb.append(" //--> \n");
		sb.append("</script>");
		return sb;
		
	}

}
