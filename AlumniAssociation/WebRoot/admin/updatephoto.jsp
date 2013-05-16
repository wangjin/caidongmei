<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台修改校园风景</title>
<script type="text/javascript">
 function showMain(el){
	var de=$("#name").val();
	var de1=$("#pubtime").val();
	var de3=$("#photoid").val();
	var url = $(el).attr("url");//请求路径； {name:na}参数传递
	$.get(url,{name:de,pubtime:de1,photoid:de3},function(result){
		$("div#main").html(result);
		return false;
	});
    return false;
	
}
</script>
  </head>
  
  <body>
 <p class="location">
		<span> 动态信息>>校园风景 >>修改校园图片</span>
	</p>
	<div>
		<p class=" clear"></p>
	</div>
	<div class="tabdcp">
		<div class="searchd">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="setab">
				<c:forEach items="${photolist}" var="m">
					<tr>
						<td width="6%" height="39" valign="middle">图片名称</td>
						<td width="34%"><input type="text" size="40"
							value="${m.name}" name="name" id="name" /></td>
					</tr>
					<tr>
						<td width="6%" height="39" valign="middle">发布时间</td>
						<td width="34%"><input type="text" size="40"
							value="${m.pubtime}" name="pubtime" id="pubtime" ></td>
					</tr>
					<tr>
						<td>
							<p class="add floatLeft">
								  <a href="javascript:void(0)" url="SchoolPhoto_updatePhoto.action?photoid=${m.photoid}" onclick="showMain(this)"><font color="red">更新</font></a>
							</p>
							<p class="add floatLeft">
								<a href="javascript:void(0)" url="SchoolPhoto_showPhoto.action?currPage=1" onclick="showMain(this)"><font color="red">返回</font></a>
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
