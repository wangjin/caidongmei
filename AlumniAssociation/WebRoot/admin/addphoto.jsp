<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台添加校园图片</title>
<link rel="stylesheet" type="text/css" href="css/manage/style.css" />
<link rel="stylesheet" type="text/css" href="css/manage/icon.css" />
<link rel="stylesheet" type="text/css" href="css/manage/main.css" />
<script type="text/javascript">
function submitForm(form, action) {
	form.action=action;
	form.submit();
}
</script>
</head>
<body>
<form name="addphotoform" action="Images_uploadNews.action?method=4" method="post"
		enctype="multipart/form-data">
<p class="location">
		<span> 动态信息>>校园风景 >>添加校园图片</span>
	</p>
	<div>
	
	      <p class="add floatLeft">
				<a href="javascript:submitForm(addphotoform,'Images_uploadNews.action?method=4');">保存</a>
			</p>
			<p class="add floatLeft">
			<a href="javascript:void(0)" url="SchoolPhoto_showPhoto.action"
									onclick="showMain(this)"><font color="red">返回</font></a>
			</p>
		<p class=" clear"></p>
	</div>
	<div class="tabdcp">
		<div class="searchd">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="setab">
					<tr>
						<td width="6%" height="39" valign="middle">图片名称</td>
						<td width="34%"><input type="text" size="40"
							 name="newstitle" id="newstitle" /></td>
					</tr>				
					<tr>
						<td width="6%" height="39" valign="middle">上传图片</td>
						<td width="34%"> <input type="file" name="myFile" /> 
						
					</tr>
			</table>
		</div>
	</div>
	<p class="clear"></p>
</form>
<!-- <form action="Images_uploadNews.action?method=4" method="post"
		enctype="multipart/form-data">
		<div class="now">
			当前的位置： <a href="main.jsp">首页</a> > <a href="showemployee.jsp">校园图片</a>
			> 添加图片
		</div>
		<ul class="submit">
			<li>图片名称：<input type="text" name="newstitle" id="newstitle"
				class="inp" /></li>
			<li>上传图片： <input type="file" name="myFile" /> <input
				type="submit" value="上传" />
		</ul>
	</form> -->
</body>
</html>