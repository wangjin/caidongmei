<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台修改校园简介</title>
<link rel="stylesheet" type="text/css" href="css/manage/style.css" />
<link rel="stylesheet" type="text/css" href="css/manage/icon.css" />
<link rel="stylesheet" type="text/css" href="css/manage/main.css" />
<script type="text/javascript">
 function showMain(el){
	var de=$("#title").val();
	var de1=$("#pubtime").val();
	var de2=$("#content").val();
	var de3=$("#briefid").val();
	var url = $(el).attr("url");//请求路径； {name:na}参数传递
	$.get(url,{title:de,pubtime:de1,content:de2,briefid:de3},function(result){
		$("div#main").html(result);
		return false;
	});
    return false;
	
}
</script>
  </head>
  
  <body>
  <p class="location">
		<span> 动态信息>>校园简介 >>修改简介</span>
	</p>
	<div>
		<p class=" clear"></p>
	</div>
	<div class="tabdcp">
		<div class="searchd">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="setab">
				<c:forEach items="${brieflist}" var="m">
					<tr>
						<td width="6%" height="39" valign="middle">简介标题</td>
						<td width="34%"><input type="text" size="40"
							value="${m.title}" name="title" id="title" /></td>
					</tr>
					<tr>
						<td width="6%" height="39" valign="middle">发布时间</td>
						<td width="34%"><input type="text" size="40"
							value="${m.pubtime}" name="pubtime" id="pubtime" readonly="readonly"></td>
					</tr>
					<tr>
						<td width="6%" height="39" valign="middle">简介内容</td>
						<td width="34%"><textarea name="content" cols="100"
								rows="15" id="content" >${m.content}</textarea>
						<%-- 	<input type="hidden" id="newsid" name="newsid"
							value="${m.newsid}" /> --%></td>

					</tr>
					<tr>
						<td>
							<p class="add floatLeft">
								 <a href="javascript:void(0)" url="Brief_updateBrief.action?briefid=${m.briefid}" onclick="showMain(this)"><font color="red">更新</font></a>
							</p>
							<p class="add floatLeft">
								 <a href="javascript:void(0)" url="Brief_showBrief.action?currPage=1" onclick="showMain(this)"><font color="red">返回</font></a>
							</p>
						</td>
					</tr>
				</c:forEach>

			</table>

		</div>
	</div>
	<p class="clear"></p>
  </body>
</html>
