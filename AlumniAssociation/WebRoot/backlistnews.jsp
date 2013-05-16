<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>前台列表显示单条新闻</title>
<script type="text/javascript" src="js/jquery-1.6.js"></script>
<link href="css/homepage/Index.css" rel="stylesheet" type="text/css" />
<link href="css/homepage/lanrentuku.css" rel="stylesheet" type="text/css" />
<link href="css/homepage/kefu.css" rel="stylesheet" type="text/css" />

</head>

<body>
<form action="IndexBefore_getTopNews.action">
  <!--头部结束-->
    <c:forEach items="${newslist}" var="m">	
 <table width="978" height="179" border="0" bgcolor="#EDF8FE">
  <tr>

    <td height="53"> <p>&nbsp;</p>
      <div align="center">
      <h1>${m.newstitle}</h1>
      <p>&nbsp;</p>
      <p>日期：<span id="aa">${m.pubtime}</span> <span id="">发布部门：校友会管理处</span>  点击： <span id="">${m.browsevolume}</span></p>
      <font color="#CCFFCC">  <hr /></font>
      <p align="left">&nbsp;&nbsp;&nbsp;&nbsp;${m.newscontent}</p> 
      <p>&nbsp;</p>
      </div>
   </td>
 </tr>
  <tr>
    <td height="58">
    <div align="center">
              <c:choose>    
			 <c:when test="${fn:length(m.url)!= 0}">  
             <img src="./${m.url}" width=600 height=500/>
             </c:when>
              <c:otherwise>
              </c:otherwise>
              </c:choose>
   </div>
    <p align="center"> <a href="News_showNews.action?currPage=1&&selectshowid=2" ><font color="red">【关闭窗口】</font></a></p></td>
  </tr>

  <tr>
    <td height="58">

 <div class="clear"></div>
</td>
  </tr>
</table>   
 </c:forEach>
</form>
</body>
</html>
