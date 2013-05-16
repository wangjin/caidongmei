<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>进度条</title>
    <style type="text/css">
.td {
 color: #FF0000
}
</style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <script type="text/javascript">
function showMain(el){

	   var url = $(el).attr("url");

		$.get(url,function(result){
			$("div.main").html(result);
			return false;
		});
		return false;
}
</script>
<script language="javascript"> 
var times=6; 
clock(); 
function clock() //自动跳转
{
   window.setTimeout('clock()',1000); 
   times=times-1; 
 //  time.innerHTML =times; 
   if(times==0)
   window.location="main.jsp";
} 
</script>
  <body>
      <div id="processbar"  
            style="position: absolute; width: 100%; height: 100%; left: 0px; top: 0px; background-color: #ffffff; filter: alpha (     opacity =     100 ); z-index: 50000">  
            <div style="text-align: center; padding-top: 200px">  
                <table align="center" border="1" width="37%" cellspacing="0"  
                    cellpadding="4" style="border-collapse: collapse" bgcolor="#FFFFEC"  
                    height="87">  
                    <tr>  
                        <td bgcolor="#3399FF" style="font-size: 12px;" height="24"  
                            align="center">  
                            友情提示, 数据正在载入中...  
                        </td>  
                    </tr>  
                    <tr>  
                        <td style="font-size: 12px; line-height: 200%" align="center">  
                            网页正在载入数据中.请耐心等待...  
                            <marquee style="border: 1px solid #000000" direction="right"  
                                width="300" scrollamount="5" scrolldelay="10" bgcolor="#ECF2FF">  
                                <table cellspacing="1" cellpadding="0">  
                                    <tr height=8>  
                                        <td bgcolor=#3399FF width=8></td>  
                                        <td></td>  
                                        <td bgcolor=#3399FF width=8></td>  
                                        <td></td>  
                                        <td bgcolor=#3399FF width=8></td>  
                                        <td></td>  
                                        <td bgcolor=#3399FF width=8></td>  
                                        <td></td>  
                                    </tr>  
                                </table>  
                            </marquee>  
                        </td>  
                    </tr>  
                </table>  
            </div>  
        </div> 
  </body>
</html>
