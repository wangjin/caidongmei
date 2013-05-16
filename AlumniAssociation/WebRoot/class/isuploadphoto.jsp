<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>是否上传图片</title>
<script type="text/javascript" src="js/jquery-1.6.js"></script>
</head>
<script type="text/javascript">
	function showMain(el) {
		var url = $(el).attr("url");

		$.get(url, function(result) {
			$("div.main_left").html(result);
			return false;
		});
		return false;
	}
	//创建 相册
	function create_album(el) {
	    var data = "selectphoto";
		var url = $(el).attr("url");
		$.get(url,{selectphoto:data}, function(result) {
			$("div.main_left").html(result);
			return false;
		});
		return false;
	}
	
	//取消相册
	function cancel_album(el) {
		document.getElementById('create_album').style.display = "none";
	}
	
</script>
<body>
<div style="background-color:red">
相册${albumname}创建成功，是否马上上传照片到这个相册？</div>
<a href="javascript:void(0)" url="MyClass_showClassphoto.action" onclick="create_album(this)">是</a>
<a href="javascript:void(0)" url="" onclick="cancel_album(this)">否</a>
</body>
</html>