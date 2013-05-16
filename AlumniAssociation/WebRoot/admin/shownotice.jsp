<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台显示公告</title>
 <link rel="stylesheet" type="text/css" href="css/manage/style.css" />
 <link rel="stylesheet" type="text/css" href="css/manage/icon.css" />
 <link rel="stylesheet" type="text/css" href="css/manage/main.css" />
</head>
 <script type="text/javascript">
 var all= document.getElementsByName("keep[]");
 function selectall()
 {    
    for( var i=0;i<all.length ;i++)
    { if( all[i].checked="false")
       all[i].checked="ture"; 
    }
    return;
 }

 
  function selectnone()
 {   
    for( var i=0;i<all.length ;i++)
    { 
    if(all[i].checked)
     all[i].checked=""; 
    }
    return;
 }
 
 function selectop()
 {
  for( var i=0;i<all.length ;i++)
  if( all[i].checked)
    all[i].checked=""; 
  else
    all[i].checked="true"; 
 
 }
  function showMain(el){

   var url = $(el).attr("url");

	$.get(url,function(result){
		$("div#main").html(result);
		return false;
	});
	return false;
}
  function showMain1(el){
		var de=$("#noticeid").val();
		var de1=1;
		var url = $(el).attr("url");//请求路径； {name:na}参数传递
		$.get(url,{noticeid:de,selectid:de1},function(result){
			$("div#main").html(result);
			return false;
		});
	    return false;
     }
  function showMain4(el){
		var de = [];
		$(":checked[name='keep[]']").each(function(){
			de.push($(this).val());
		});
		var url = $(el).attr("url");//请求路径； {name:na}参数传递
		$.get(url,{keep:de},function(result){
			$("div#main").html(result);
			return false;
		});
	    return false;
   }
  function showMain3(el){
		var de=$("#noticeid").val();
		var de1=1;
		var url = $(el).attr("url");//请求路径； {name:na}参数传递
		$.get(url,{noticeid:de,selectid:de1},function(result){
			$("div#main").html(result);
			return false;
		});
	    return false;
   }
  function showMain2(el){
		var de=$("#title").val();
		var url = $(el).attr("url");//请求路径； {name:na}参数传递
		$.get(url,{title:de},function(result){//1,后台查询
			$("div#main").html(result);
			return false;
		});
	    return false;
   }
    function changePage() {
				var currPage = document.getElementById("currPage").value;
				var url= "Notice_showNotice.action?currPage="
						+ currPage;
				$.get(url,function(result){
		        $("div#main").html(result);
		        return false;
	});		
			}
</script>
<body>
<p class="location"><span>动态信息 -> 校园公告</span></p>
	    <div>  	
        <p class=" clear"></p>
    </div>
    <div class="tabdcp">
        <div class="searchd">
       	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="setab">
              <tr>
                <td width="10%" height="39"  valign="middle" >公告标题:</td>
			    <td width="20%" ><input type="text" size="30" name="title" id="title"/></td>            
				<td width="10%"><p class="s_earch"><a href="javascript:void(0)" onclick="showMain2(this)"url="Notice_searchNotice.action">查询</a></p></td>
           
              </tr>
            </table>
            <table width="97%" border="1" cellpadding="0" cellspacing="0" class="senr">
                <tbody class="tbdone">
                  <tr bgcolor="#4d97d2">
                    <td width="10%" height="30">选择</td>
                    <td width="10%" height="30">公告标题</td>   
                    <td width="10%" height="30">公告内容</td>               
                    <td width="9%">发布时间</td>              
                    <td width="10%">操作</td>		
                  </tr>
                  </tbody>
                  <tbody class="tbdtwo">                 
                  <tr>
                    <c:forEach items="${pageModel.list}" var="m">		
			 	
				<tr>		
			<td>	<input  id="keep" name="keep[]" value="${m.noticeid}" type="checkbox">		
			  <c:choose>    
			 <c:when test="${fn:length(m.title) > 10}">  
              <td > <a href="javascript:void(0)" url="searchOneBynoticeid.action?noticeid=${m.noticeid}" onclick="showMain1(this)"> <font color="red"> <c:out value="${fn:substring(m.title, 0, 10)}..." /></font></a> </td >
             
              </c:when>  
              <c:otherwise>  
              <td > <a href="javascript:void(0)" url="searchOneBynoticeid.action?noticeid=${m.noticeid}" onclick="showMain1(this)"> <font color="red"> <c:out value="${m.title}" /></font></a> </td >
              </c:otherwise>  
 	          </c:choose>
 	        
				<c:choose>  
              <c:when test="${fn:length(m.content) > 10}">  
              <td >  <c:out value="${fn:substring(m.content, 0, 10)}..." />  </td >
              </c:when>  
              <c:otherwise>  
              <td >  <c:out value="${m.content}" /> </td >
              </c:otherwise>  
              </c:choose>  			
				<td >${m.pubtime}</td>
               
				<td >	
				 	
				  <a href="javascript:void(0)" url="Notice_searchOneBynoticeid.action?noticeid=${m.noticeid}" onclick="showMain3(this)"><img alt="" src="./image/xiugai.jpg">修改</a>				     
				 
<br>			
				 </td>						
		       	</tr>			
		     </c:forEach>				
					  </tr>					
                  </tbody>
                  <!-- 修改好的代码 -->
              <tfoot>
						<tr>              
							<td colspan="8">	
								<div class="tdleft">
								<a href="javascript:void(0)" url="./admin/addnotice.jsp" onclick="showMain1(this)"><img alt="" src="./image/tianjia.jpg">添加公告</a>
								<a href="javascript:void(0)" url="Notice_deleteNotice.action" onclick="showMain4(this)"><img alt="" src="./image/shanchu.jpg">删除</a>
								</div>
								<div class="page">
								共	${pageModel.totalRecords}条记录
								当前${pageModel.currPage}/${pageModel.totalPage}页
									<<
									 <a onclick="showMain(this)" href="javascript:void(0)" url="Notice_showNotice.action?currPage=<%=1%>">&nbsp;&nbsp;</a>
										<a  href="javascript:void(0)" url="Notice_showNotice.action?currPage=${pageModel.previousPage}"  onclick="showMain(this)">
		上一页
			</a>
				<c:forEach begin="1" end="${pageModel.totalPage}" varStatus="vs">
			
			<a href="javascript:void(0)" url="Notice_showNotice.action?currPage=${vs.count}" onclick="showMain(this)" class="selected"><c:out value="${vs.count}"></c:out></a>
			</c:forEach>
			
			
			<a href="javascript:void(0)" url="Notice_showNotice.action?currPage=${pageModel.nextPage}" onclick="showMain(this)">
		</a>
           <a href="javascript:void(0)" url="Notice_showNotice.action?currPage=${pageModel.totalPage}" onclick="showMain(this)">
		
			下一页
			>></a>
									<%-- 共${pageModel.totalPage }页到 第 
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
			</select> --%>
								 <input type = "button" value = "全选" onclick="selectall()">
      <input type = "button" value = "全不选" onclick="selectnone()">
      <input type = "button" value = "反选" onclick="selectop()">
								</div>
							</td>
						</tr>
					</tfoot>
                </table>
</div>
    </div>
 <p class="clear"></p>
<script>
$(function(){
    $(".wmenu ul p:not(:first)").hide();
	$(".tbdtwo tr:even").addClass("treven");
	$(".tacaidan ul li").click(function(){
					$(this).addClass("clickd").siblings().removeClass("clickd");
					var indexli=$(".tacaidan ul li").index(this);
					$(".tabdcp > .searchd").eq(indexli).show().siblings(".searchd").hide();				  
			}) 
	$(".wmenu ul li").click(function(){
					$(this).addClass("clickcdbj").siblings("li").removeClass("clickcdbj").addClass("cdbj");				 
					$(this).next("p").slideToggle("slow").siblings("p").slideUp("slow");
					})
	$(".wmenu ul p a").click(function(){
					$(this).addClass("pbjclic").siblings("a").removeClass("pbjclic").addClass("pbj");				 
					//var indexw=$(".wmenu ul li").index(this);			 
					})
	$(".tbdtwo tr").hover(function(){
					$(this).addClass("trhove");	   
								   },function(){
					$(this).removeClass("trhove")							
												})
	})
</script>
</body>
</html>