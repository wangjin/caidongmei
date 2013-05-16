<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.6.js"></script>
<link rel="stylesheet" type="text/css" href="css/manage/style.css" />
<link rel="stylesheet" type="text/css" href="css/manage/icon.css" />
<link rel="stylesheet" type="text/css" href="css/manage/main.css" />
<title>后台添加新闻</title>
<script type="text/javascript">
function submitForm(form, action) {
	form.action=action;
	form.submit();
}
</script> 
</head>

<body>
<form name="addnewform" action="Images_uploadNews.action?method=1" method="post"
		enctype="multipart/form-data">
<p class="location">
		<span> 动态信息>>新闻管理 >>添加新闻</span>
	</p>
	<div>
	
	      <p class="add floatLeft">
				<a href="javascript:submitForm(addnewform,'Images_uploadNews.action?method=1');">保存</a>
			</p>
			<p class="add floatLeft">
			<a href="javascript:void(0)" url="News_showNews.action"
									onclick="showMain(this)"><font color="red">返回</font></a>
			</p>
		<p class=" clear"></p>
	</div>
	<div class="tabdcp">
		<div class="searchd">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="setab">
					<tr>
						<td width="6%" height="39" valign="middle">新闻标题</td>
						<td width="34%"><input type="text" size="40"
							value="${m.newstitle}" name="newstitle" id="newstitle" /></td>
					</tr>
					
					<tr>
						<td width="6%" height="39" valign="middle">新闻内容</td>
						<td width="34%"><textarea name="newscontent" cols="100"
								rows="15" id="newscontent" name="newscontent">${m.newscontent}</textarea>
							<input type="hidden" id="newsid" name="newsid"
							value="${m.newsid}" /></td>
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
</body>
</html>
