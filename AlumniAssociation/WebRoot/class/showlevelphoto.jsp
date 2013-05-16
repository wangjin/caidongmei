<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>某个相册的所有照片</title>
<script type="text/javascript" src="js/jquery-1.6.js"></script>
<link href="./css/index.css" rel="stylesheet" type="text/css" />
<link href="./css/public.css" rel="stylesheet" type="text/css" />
<link href="./css/aa.css" rel="stylesheet" type="text/css" />
<link href="./css/photo_v3.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.abook {
	margin: 10px 0 0 0;
	padding: 10px;
	border: 1px solid #f6f6f6;
	width: 250px;
	height: 20px;
	float: left;
	margin-right: 10px
}

.abook:hover {
	border: 1px solid #ddd;
	background: #f5f5f5;
}

.abook .abook_left {
	float: left;
	text-align: center;
	width: 60px
}

.abook .abook_right {
	float: left;
	width: 250px;
	height: 200px;
	color: #666;
	margin-left: 10px;
}
</style>
<style type="text/css">
#class_table th {
	background: #f8f8f8;
	border-bottom: 1px solid #ccc;
	height: 30px;
	line-height: 30px
}

#class_table td {
	border-bottom: 1px solid #eee;
	height: 30px;
	line-height: 30px
}

#class_year li {
	float: left;
	width: 155px;
	border: 0px solid #ccc;
	margin: 3px 5px;
}

#class_year li a {
	display: block;
	padding: 4px 4px 4px 15px;
}

#class_year li a span {
	color: #444
}

#class_year li a:link,#class_year li a:visited {
	display: block;
	background-color: #F2F7FA
}

#class_year li a:hover {
	background-color: #E3EDF7
}
</style>
<script type="text/javascript">
	function showMain(el) {

		var url = $(el).attr("url");

		$.get(url, function(result) {
			$("div.main_left").html(result);
			return false;
		});
		return false;
	}
	function showMain1(el) {
		var de = $("#kindid").val();

		var url = $(el).attr("url");//请求路径； {name:na}参数传递
		$.get(url, {
			kindid : de
		}, function(result) {
			$("div.main_left").html(result);
			return false;
		});
		return false;
	}
</script>
</head>

<body style="background-image: url('./image/showphoto.jpg');">
					
				<a href="javascript:void(0)" onclick="showMain(this)" url="MyClass_showClassphoto.action">相册</a>>>【${albumname}】的照片	
	<s:iterator value="lvlPhotolist" var="photo">
	
		<div class="abook">
			<div class="abook_left">
				<a href="##"> <img src="./${photo.url}"
					style="height: 200px; width: 250px; border-width: 0"><br><br>
				</a>${photo.name}<br><br><br><br>
			</div>
			<br>
			<br>
			<br>
			<br>
		</div>
	</s:iterator>
</body>
</html>