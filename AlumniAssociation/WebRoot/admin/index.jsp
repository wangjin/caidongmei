<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>导入学生信息</title>
<link rel="stylesheet" type="text/css" href="css/manage/style.css" />
<link rel="stylesheet" type="text/css" href="css/manage/icon.css" />
<link rel="stylesheet" type="text/css" href="css/manage/main.css" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<script type="text/javascript">
function submitForm(form, action) {
	form.action=action;
	form.submit();
}
</script>
<body>
	<p class="location" style="width: 200%;">
		<span>学生管理 -> 信息导入 </span>
	</p>
	<form action="File_upload.action" id="logform" name="logform"
		method="post" enctype="multipart/form-data">
		<div>
			<p class="add floatLeft">
				<a href="javascript:submitForm(logform,'File_upload.action');">保存</a>
			</p>
			<p class="add floatLeft">
				<a href="main.jsp">取消</a>
			</p>
			<p class=" clear"></p>
		</div>
		<div class="tabdcp">
			<div class="searchd">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="setab">
					<tr>
						<td width="10%" height="39" valign="middle">附件名字</td>
						<td width="34%"><input type="file" name="file"></td>

					</tr>
				</table>

			</div>
		</div>
		<p class="clear"></p>
		<div></div>
	</form>
</body>
</html>
