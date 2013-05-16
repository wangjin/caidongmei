<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传成功，返回页面</title>
<script type="text/javascript" src="js/jquery-1.6.js"></script>
<link href="./css/index.css" rel="stylesheet" type="text/css" />
<link href="./css/public.css" rel="stylesheet" type="text/css" />
<link href="./css/aa.css" rel="stylesheet" type="text/css" />

<style type="text/css">
.abook {
	margin: 10px 0 0 0;
	padding: 10px;
	border: 1px solid #f6f6f6;
	width: 350px;
	height: 90px;
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
	width: 210px;
	height: 100px;
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
	//创建 相册
	function create_album(el) {
		document.getElementById('create_album').style.display = "block";
	    var data = $("#createForm").serializeArray();
		var url = $(el).attr("url");//请求路径； {name:na}参数传递
		$.get(url,data, function(result) {
			$("div#create_album").html(result);
			return false;
		});
		return false;
	}
	//显示相册
	function show_album(el) {
		//  $("#create_album").show();两种方法均可以
		document.getElementById('create_album').style.display = "block";
		var url = $(el).attr("url");//请求路径； {name:na}参数传递
		$.get(url, {
			kindid : de
		}, function(result) {
			$("div.main_left").html(result);
			return false;
		});
		return false;
	}
	//取消相册
	function cancel_album(el) {
		document.getElementById('create_album').style.display = "none";
		var url = $(el).attr("url");//请求路径； {name:na}参数传递
		$.get(url, {
			kindid : de
		}, function(result) {
			$("div.main_left").html(result);
			return false;
		});
		return false;
	}
	function showMainz(el) {
	    var data = "selectphoto";
		var url = $(el).attr("url");
		$.get(url,{selectphoto:data}, function(result) {
			$("div.main_left").html(result);
			return false;
		});
		return false;
	}
</script>
</head>

<body style="background-image: url('./image/showphoto.jpg');">
<div id="hp_top" >
    <div id="hp_name">
        <span class="hp_logo"><img src="./image/xiaohui.jpg" /></span>
        <span class="hp_title"><a href="./image/xiaohui.jpg">${user.graduation}级${classname}</a></span>
        <span class="sign_members">${user.classone.peoplecount}人</span>
    </div>
    <div id="hp_nav">
        <ul class="menu" id="menus">
            <li><a href="javascript:void(0)" onclick="showMain(this)" url="./class/blank.htm">首页</a></li>
            <li><a href="javascript:void(0)" onclick="showMain(this)" url="">话题</a></li>
            <li><a href="javascript:void(0)" onclick="showMain(this)" url="">留言板</a></li>
            <li><a href="javascript:void(0)" onclick="showMain(this)" url="">成员</a></li>
            <li><a href="javascript:void(0)" onclick="showMain(this)" url="MyClass_addressBook.action">通讯录</a></li>
            <li><a href="javascript:void(0)" onclick="showMain(this)" url="MyClass_showClassphoto.action">相册</a></li>
                    </ul>
        <div class="clear"></div>
    </div>
</div>

<div class="main_left" id="main_left" style="width: 680px;margin-left:276px">
<div class="span-15" id="class_room_deny" >
  
</div>
</div><div class="rightbox">
            <div class="userbox_left">
           
         <%--    <c:if test="${user.remark==null}" var="">
               <img src="./image/default.jpg" style="width:84px;height: 84px"/> 
              </c:if> --%>
              
                  <img src="./${user.remark}" width=80px height=125px /> 
              
              
        </div>
        <div class="userbox_right">
            <span class="username">acai</span><br>
            <span>你已经加入<br>该班级！</span>
        </div>
        <div class="clear"></div>
        <div style="text-align: center; padding: 10px 0">
        <input type="file" name="myFile" value="选择图片" /> <input
				type="submit" value="上传 " />
        </div>
    </div>

	<div id="main">
		<table cellspan="0" border="0">
			<tr>

				<td><a href="javascript:void(0)" onclick="showMainz(this)"
						url="MyClass_showClassphoto.action"> <img
						src="./images/uploadphoto.jpg" /></a></td>
				<td><a href="javascript:show_album(this)" >创建相册</a></td>
			</tr>
		</table>
		<c:forEach items="${photolist}" var="m">
			<div class="abook">
				<div class="abook_left">
					<a href="javascript:void(0)" onclick="showMain1(this)"
						url="MyClass_getLevelPhotolist.action"> <img src="./${m.url}"
						style="height: 48px; width: 55px; border-width: 0">
					</a> <input type="hidden" value="${m.photokind.kindid}" name="kindid"
						id="kindid" /> <a href="javascript:void(0)"
						onclick="showMain1(this)" url="MyClass_getLevelPhotolist.action">${m.photokind.kindname}</a>
				</div>

			</div>
		</c:forEach>
   <c:forEach items="${photokindlist}" var="m">
			<div class="abook">
				<div class="abook_left">
					
						 <img src="./image/nophoto.gif"
						style="height: 48px; width: 55px; border-width: 0"/>
					        ${m.kindname}
				</div>

			</div>
		</c:forEach>
	</div>
<form id="createForm">
	<div id="create_album" 
		style="height: auto; overflow: hidden; display: none; z-index:200">
		<p>
			<span class="form_name"><label for="album_name">相册名称：</label></span>
			<input type="text" id="name" name="name" class="int_txt"
				onkeyup="QPHOTO.util.onWrite(this.value,30,$('name_word'),$('name_tips'),'<i></i>');"
				maxlength="30" /> <span class="count_txt"><span
				id="name_word">0</span>/30</span>
		</p>
		<p id="name_tips" class="bg c_tx notice" style="display: none"></p>
		<p>
			<span class="form_name"><label for="album_desc">相册描述：</label></span>
			<textarea  id="description"
				name="description" 
				style="font-size: 12px;"
				onkeyup="QPHOTO.util.onWrite(this.value,200,$('desc_word'),$('desc_tips'),'<i></i>');"></textarea>
			<span class="count_txt"><span id="desc_word">0</span>/200</span>
		</p>
		<p id="desc_tips" class="bg c_tx notice" style="display: none"></p>
		<p>
			<span class="form_name">
			
			<a href="javascript:void(0)" url="MyClass_createAlbum.action" onclick="create_album(this)">创建</a>
			<a href="javascript:cancel_album(this)">取消</a></span>
				
	</div>
</form>
</body>
</html>