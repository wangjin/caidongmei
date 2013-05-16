<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级通讯录</title>
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
  function showMain(el){

   var url = $(el).attr("url");

	$.post(url,function(result){
		$("div.main_left").html(result);
		return false;
	});
	return false;
}

</script>
</head>

<body style="background-image: url('./image/background.jpg');">
	<form action="Images_fileDownloadExcelUser.action">
		<div id="main">
			<div id="admin950">
				<table cellspan="0" border="0">
					<tr>
						<td><img src="./image/page_excel.gif" /></td>
						<td><a href="Images_fileDownloadExcelUser.action">下载班级通讯录</a></td>
					</tr>
				</table>
				<c:forEach items="${pageModel.list}" var="m">
					<div class="abook">
						<div class="abook_left">
							<a href="/user_home?id=5415"><div class="user_avatar"
									style="width: 48px">
									<img src="./${m.remark}"
										style="height: 48px; width: 55px; border-width: 0">
								</div>${m.username}</a>
						</div>
						<div class="abook_right">
							电话:${m.cellphone}</br> 邮箱: ${m.email}</br> 地址: ${m.contactaddress}
						</div>

					</div>
				</c:forEach>


				<div class="clear"></div> 
				<div class="comment_pager">
					<span class="total">共&nbsp;${pageModel.totalRecords}&nbsp;条记录&nbsp;</span> 
					
				<a  href="javascript:void(0)" url="MyClass_addressBook.action?currPage=${pageModel.previousPage}"  onclick="showMain(this)">
			上一页
			</a>
				<c:forEach begin="1" end="${pageModel.totalPage}" varStatus="vs">
			
			<a href="javascript:void(0)" url="MyClass_addressBook.action?currPage=${vs.count}" onclick="showMain(this)" class="selected"><c:out value="${vs.count}"></c:out></a>
			</c:forEach>
			
			
			<a href="javascript:void(0)" url="MyClass_addressBook.action?currPage=${pageModel.nextPage}" onclick="showMain(this)">
			下一页
			
			>></a>
									共${pageModel.totalPage }页到 第 
			<select id="currpage" onchange="changePage()">
			<c:forEach begin="1" end="${pageModel.totalPage}" varStatus="vs">
			<c:choose>
			<c:when test="${pageModel.currPage ne vs.count}">
			<option value="${vs.count}">第${vs.count}页</option>
			</c:when>
			<c:otherwise>
					<option value="${vs.count}" selected="selected">第${vs.count}页</option>
			</c:otherwise>
			</c:choose>
			</c:forEach>
			</select>			
				</div>
				<!-- .pagination -->
			</div>
			<div class="clear"></div>
		</div>



	</form>
</body>
</html>