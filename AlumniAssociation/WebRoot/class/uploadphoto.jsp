<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传照片</title>
<script type="text/javascript" src="js/jquery-1.6.js"></script>
<script type="text/javascript">
  function showMain(el){
   var url = $(el).attr("url");
	$.get(url,function(result){
		$("div.main_left").html(result);
		return false;
	});
	return false;
}
 </script>
</head>
<body>
<form action="Images_uploadNews.action?method=6" method="post" enctype="multipart/form-data">
<a href="javascript:void(0)" onclick="showMain(this)" url="MyClass_showClassphoto.action">相册</a>>>上传照片<br><br>
照片名称：<input type="text" name="photoname" id="photoname"/>
上传到：<select id="kindname" name="kindname" >				                        	
	                <c:forEach items="${pklist}" var="m">						             
					 <option > 
					      ${m.kindname}   </option>				
		             </c:forEach>
				                </select>　
 
选择图片： <input type="file" name="myFile" /> <input type="submit" value="上传" />
</form>
</body>
</html>