<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台添加简介</title>
<link rel="stylesheet" type="text/css" href="css/manage/style.css" />
<link rel="stylesheet" type="text/css" href="css/manage/icon.css" />
<link rel="stylesheet" type="text/css" href="css/manage/main.css" />
</head>
<script type="text/javascript">
function submitForm(form, action) {
	form.action=action;
	form.submit();
}
</script> 
<body>
<form name="addbriefform" action="Images_uploadNews.action?method=2" method="post"
		enctype="multipart/form-data">
<p class="location">
		<span> 动态信息>>校园简介 >>添加简介</span>
	</p>
	<div>
	
	      <p class="add floatLeft">
				<a href="javascript:submitForm(addbriefform,'Images_uploadNews.action?method=2');">保存</a>
			</p>
			<p class="add floatLeft">
			<a href="javascript:void(0)" url="Brief_showBrief.action"
									onclick="showMain(this)"><font color="red">返回</font></a>
			</p>
		<p class=" clear"></p>
	</div>
	<div class="tabdcp">
		<div class="searchd">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="setab">
					<tr>
						<td width="6%" height="39" valign="middle">简介标题</td>
						<td width="34%"><input type="text" size="40"
							value="${m.newstitle}" name="newstitle" id="newstitle" /></td>
					</tr>
					
					<tr>
						<td width="6%" height="39" valign="middle">简介内容</td>
						<td width="34%"><textarea name="newscontent" cols="100"
								rows="15" id="newscontent" name="newscontent"></textarea>
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