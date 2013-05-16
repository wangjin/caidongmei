<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>根据条件显示班级</title>
<script type="text/javascript" src="js/jquery-1.6.js"></script>
<link href="./css/index.css" rel="stylesheet" type="text/css" />
<link  href="./css/public.css" rel="stylesheet" type="text/css" />
<link  href="./css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">


</script><style type="text/css">
    	    #class_table th{ background: #f8f8f8; border-bottom: 1px solid #ccc; height: 30px;line-height: 30px}
    	    #class_table td{ border-bottom: 1px solid #eee; height: 30px;line-height: 30px}
    	    #class_year li{ float: left; width: 155px;border:0px solid #ccc; margin:3px 5px; }
    	    #class_year li a{display: block;padding:4px 4px 4px 15px; }
    	    #class_year li a span{ color: #444}
    	    #class_year li a:link,#class_year li a:visited{ display: block;background-color: #F2F7FA}
    	    #class_year li a:hover{background-color: #E3EDF7}
    	</style>
</head>

<body>

<div style="margin: 30px 10px">
    <h3>已经创建的班级：</h3>
    <table border="0" width="100%" id="class_table" cellspacing="0" cellpadding="0">
	<thead>
	    <tr>
		<th style="text-align:center">入学年份</th>
		<th  style="text-align:center">班级名称</th>
		<th style="text-align:center">人数</th>
		<th style="text-align:center">创建日期</th>

	    </tr>
	</thead>
	<tbody>
	  <c:forEach items="${classlist}" var="m">	  
                 <tr>
		<td style="text-align:center">${m.entertime}</td>
		<td style="text-align:center"><a href="MyClass_showHomepage.action?entertime=${m.entertime}&&classname=${m.classname}" >${m.classdept.classdeptname}/${m.classname}</a></td>
		<td style="text-align:center">${m.peoplecount}</td>
		<td style="text-align:center">${m.createtime}</td>
	    </tr>
    </c:forEach>	   	
    	</tbody>
    </table>
    </div>
</body>
</html>
