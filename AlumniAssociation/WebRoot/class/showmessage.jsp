<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示留言</title>
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
<script type="text/javascript">
  function showMain(el){
	  var de=$("#messagecontent").val();
	  var value= $('input:radio[name="expressionselect"]:checked').val();
      var url = $(el).attr("url");

	$.get(url,{messagecontent:de,code:value},function(result){
		$("div.main_left").html(result);
		return false;
	});
	return false;
}
  //显示表情
  function showExpression(el){
		document.getElementById('expression').style.display = "block";
	
	}
  //显示选择的表情
  function showselect1(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
            if(value!=null)   
            { 
          	  document.getElementById('expression').style.display= "none";	
          	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
          	document.getElementById("message1").innerHTML="<img src='./image/think.gif'/>";
            } 		  
         
	}
  function showselect2(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
         if(value!=null)   
         { 
       	  document.getElementById('expression').style.display= "none";	
       	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
       	document.getElementById("message1").innerHTML="<img src='./image/zhuakuang.gif'/>";
         } 		  
      
	}
  function showselect3(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
         if(value!=null)   
         { 
       	  document.getElementById('expression').style.display= "none";	
       	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
       	document.getElementById("message1").innerHTML="<img src='./image/hua.gif'/>";
         } 		  
      
	}
  function showselect4(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
         if(value!=null)   
         { 
       	  document.getElementById('expression').style.display= "none";	
       	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
       	document.getElementById("message1").innerHTML="<img src='./image/ku.gif'/>";
         } 		  
      
	}
  function showselect5(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
         if(value!=null)   
         { 
       	  document.getElementById('expression').style.display= "none";	
       	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
       	document.getElementById("message1").innerHTML="<img src='./image/liuhan.gif'/>";
         } 		  
      
	}
  function showselect6(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
         if(value!=null)   
         { 
       	  document.getElementById('expression').style.display= "none";	
       	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
       	document.getElementById("message1").innerHTML="<img src='./image/yun.gif'/>";
         } 		  
      
	}
  function showselect7(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
         if(value!=null)   
         { 
       	  document.getElementById('expression').style.display= "none";	
       	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
       	document.getElementById("message1").innerHTML="<img src='./image/hag.gif'/>";
         } 		  
      
	}
  function showselect8(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
         if(value!=null)   
         { 
       	  document.getElementById('expression').style.display= "none";	
       	document.getElementById("message1").innerHTML="<img src='./image/kiss.gif'/>";
         } 		  
      
	}
  function showselect9(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
         if(value!=null)   
         { 
       	  document.getElementById('expression').style.display= "none";	
       	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
       	document.getElementById("message1").innerHTML="<img src='./image/weixiao.gif'/>";
         } 		  
      
	}
  function showselect10(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
      if(value!=null)   
      { 
    	  document.getElementById('expression').style.display= "none";	
    	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
    	document.getElementById("message1").innerHTML="<img src='./image/scar.gif'/>";
      } 		  
   
	}
  function showselect11(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
      if(value!=null)   
      { 
    	  document.getElementById('expression').style.display= "none";	
    	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
    	document.getElementById("message1").innerHTML="<img src='./image/zhadan.gif'/>";
      } 		  
   
	}
function showselect12(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
      if(value!=null)   
      { 
    	  document.getElementById('expression').style.display= "none";	
    	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
    	document.getElementById("message1").innerHTML="<img src='./image/bishi.gif'/>";
      } 		  
   
	}
function showselect13(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
      if(value!=null)   
      { 
    	  document.getElementById('expression').style.display= "none";	
    	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
    	document.getElementById("message1").innerHTML="<img src='./image/kuwei.gif'/>";
      } 		  
   
	}
function showselect14(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
      if(value!=null)   
      { 
    	  document.getElementById('expression').style.display= "none";	
    	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
    	document.getElementById("message1").innerHTML="<img src='./image/caidao.gif'/>";
      } 		  
   
	}
function showselect15(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
      if(value!=null)   
      { 
    	  document.getElementById('expression').style.display= "none";	
    	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
    	document.getElementById("message1").innerHTML="<img src='./image/love.gif'/>";
      } 		  
   
	}
function showselect16(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
      if(value!=null)   
      { 
    	  document.getElementById('expression').style.display= "none";	
    	document.getElementById("message1").innerHTML="<img src='./image/sui.gif'/>";
      } 		  
   
	}
function showselect17(el){
		 var value= $('input:radio[name="expressionselect"]:checked').val();
      if(value!=null)   
      { 
    	  document.getElementById('expression').style.display= "none";	
    	 // document.getElementById("message1").innerHTML="<img src='./image/value.gif'/>";
    	document.getElementById("message1").innerHTML="<img src='./image/nu.gif'/>";
      } 		  
   
	}
</script>
</head>

<body style="background-image: url('./image/background.jpg');">
		<div id="main">
		<h>班级寄语：</h><br>
                  <h>   料峭春风吹酒醒，微冷，</h><br>
                     <h>山头斜照却相迎。</h><br>
                    <h> 回首向来萧瑟处，归去，</h><br>
                   <h>  也无风雨也无晴。</h><br><br>
	<div id="message1"  onclick="showExpression()"><img alt="" src="./image/think.gif" onclick="showExpression()"></div>	
		<div style="display: none;"  id="expression">
		<a href="javascript:void(0)" onclick="showselect1(this)"><input type="radio" name="expressionselect"  id="expressionselect" value="think"/><img alt="" src="./image/think.gif" ></a>
		<a href="javascript:void(0)" onclick="showselect2(this)"><input type="radio" name="expressionselect"  id="expressionselect"  value="zhuakuang"/><img alt="" src="./image/zhuakuang.gif"></a>
		<a href="javascript:void(0)" onclick="showselect3(this)"><input type="radio" name="expressionselect"  id="expressionselect"  value="hua"/><img alt="" src="./image/hua.gif" ></a>
		<a href="javascript:void(0)" onclick="showselect4(this)"><input type="radio" name="expressionselect"  id="expressionselect"  value="ku"/><img alt="" src="./image/ku.gif"></a>
		<a href="javascript:void(0)" onclick="showselect5(this)"><input type="radio" name="expressionselect"  id="expressionselect"  value="liuyan"/><img alt="" src="./image/liuhan.gif"></a>
		<a href="javascript:void(0)" onclick="showselect6(this)"><input type="radio" name="expressionselect"  id="expressionselect"  value="yun"/><img alt="" src="./image/yun.gif"></a>
		<a href="javascript:void(0)" onclick="showselect7(this)"><input type="radio" name="expressionselect"  id="expressionselect"  value="hag"/><img alt="" src="./image/hag.gif"></a>
		<a href="javascript:void(0)" onclick="showselect8(this)"><input type="radio" name="expressionselect"  id="expressionselect"  value="kiss"/><img alt="" src="./image/kiss.gif"></a>
		<a href="javascript:void(0)" onclick="showselect9(this)"><input type="radio" name="expressionselect"  id="expressionselect" value="weixiao"/><img alt="" src="./image/weixiao.gif"></a>
		<a href="javascript:void(0)" onclick="showselect10(this)"><input type="radio" name="expressionselect"  id="expressionselect" value="scar"/><img alt="" src="./image/scar.gif"></a>
        <a href="javascript:void(0)" onclick="showselect11(this)"> <input type="radio" name="expressionselect"  id="expressionselect"  value="zhadan"/><img alt="" src="./image/zhadan.gif"></a>
		<a href="javascript:void(0)" onclick="showselect12(this)"><input type="radio" name="expressionselect"  id="expressionselect"  value="bishi"/><img alt="" src="./image/bishi.gif"></a>
		<a href="javascript:void(0)" onclick="showselect13(this)"><input type="radio" name="expressionselect"  id="expressionselect"  value="kuwei"/><img alt="" src="./image/kuwei.gif"><br></a>
		<a href="javascript:void(0)" onclick="showselect14(this)"><input type="radio" name="expressionselect"  id="expressionselect"  value="caidao"/><img alt="" src="./image/caidao.gif"></a>
		<a href="javascript:void(0)" onclick="showselect15(this)"><input type="radio" name="expressionselect"  id="expressionselect"  value="love"/><img alt="" src="./image/love.gif"></a>
		<a href="javascript:void(0)" onclick="showselect16(this)"><input type="radio" name="expressionselect"  id="expressionselect"  value="sui"/><img alt="" src="./image/sui.gif"></a>
		<a href="javascript:void(0)" onclick="showselect17(this)"><input type="radio" name="expressionselect"  id="expressionselect"  value="nu"/><img alt="" src="./image/nu.gif"></a>	
		</div>
		<br>
		<textarea rows="10" cols="70" style="margin: 2px; width: 687px; height: 153px;" id="messagecontent" name="messagecontent">留言。。。</textarea><br>
		<!-- <div style="margin: 2px; width: 687px; height: 153px;" id="message1" name="message1">留言。。。</div><br> -->
		 <a href="javascript:void(0)" url="MyClass_addMessage.action" onclick="showMain(this)">发表 </a>
		<c:forEach items="${pageModel.list}" var="m" varStatus="">	
		<table width="715" height="194" border="0">
  <tr>
    <td width="90" rowspan="4"><p><img src="./${m.user.remark}" width="88" height="98" /></p>
      <!-- <p>&nbsp;</p> -->
    </td>
    <td width="19" rowspan="4">&nbsp;</td>
   
  </tr>
  <tr>
    <td height="31" colspan="2"><p>第1楼  ${m.pubtime} 留言                               <a href="">回复 </a>  
    </p>   </td>
  </tr>
  <tr>
   <td colspan="2" align="left">
   <c:if test="${m.code!=null}">
   <img src="./image/${m.code}.gif">
   </c:if>
   ${m.content}
   </td>
   </tr>
   <c:forEach items="${messagelist}" var="n">
   <c:if test="${n.hostid==m.messageid}">
  
  <tr>
    <td width="53" height="44" rowspan="2"><img src="./${n.user.remark}" width="48" height="48" />${n.user.username}</td>
    <td width="485" height="36" style="text-align:inherit;">
    <table height="36" width="485">
    <tr></tr>
    <tr><td> ${n.content}      <a href="">回复 </a> </td></tr>
    <tr></tr><tr></tr>
    </table>
    
    </td>
  </tr>
  <tr>
    <td height="26">${n.pubtime} </td>
  </tr>
  </c:if>
  </c:forEach>
  
   <tr>
    <td colspan="2">笑脸选择</td>
  </tr>
  <tr>
    <td colspan="2">${m.user.username} <br>详细信息</td>
    <td colspan="2">
    
   <input type="text" name="" value="我也说一句..." onfocus="fabiao(this)"><div id="fabiao"><a href="">发表</a></div>
     </td>
  </tr>
   
</table>	
	</c:forEach>	
				<div class="clear"></div> 
				<div class="comment_pager">
					<span class="total">共&nbsp;${pageModel.totalRecords}&nbsp;条记录&nbsp;</span> 
					
				<a  href="javascript:void(0)" url="MyClass_showMessage.action?currPage=${pageModel.previousPage}"  onclick="showMain(this)">
			上一页
			</a>
				<c:forEach begin="1" end="${pageModel.totalPage}" varStatus="vs">
			
			<a href="javascript:void(0)" url="MyClass_showMessage.action?currPage=${vs.count}" onclick="showMain(this)" class="selected"><c:out value="${vs.count}"></c:out></a>
			</c:forEach>
			
			
			<a href="javascript:void(0)" url="MyClass_showMessage.action?currPage=${pageModel.nextPage}" onclick="showMain(this)">
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
			</div>
			<div class="clear"></div>
</body>
</html>