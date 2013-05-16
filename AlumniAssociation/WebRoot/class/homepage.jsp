<%@ page language="java" import="java.util.*" pageEncoding="utf-8"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>班级首页</title>
<script type="text/javascript" src="js/jquery-1.6.js"></script>
<link href="./css/index.css" rel="stylesheet" type="text/css" />
<link  href="./css/public.css" rel="stylesheet" type="text/css" />
<link  href="./css/aa.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
  function showMain(el){

   var url = $(el).attr("url");

	$.get(url,function(result){
		$("div.main_left").html(result);
		return false;
	});
	return false;
}
 
</script>
</head>


<body style="background-image: url('./image/showphoto.jpg'); repeat-x ">
<form action="Images_uploadNews.action?method=5" method="post"
		enctype="multipart/form-data">
        <div id="append_parent"></div>
        <div id="top_tool">
    <div class="cur_here"><a href="/">淮海工学院校友网</a> &gt; <a href="/classroom">班级录</a> &gt; ${user.graduation}级${classname}</div>
    <div class="user_nav">欢迎回来，<a href="/user_home" title="进入个人主页"> ${user.username}</a>&nbsp;&nbsp;<a href="/user_msg" title="站内信息"><img src="../image/user/email.gif" style="margin-right:2px; vertical-align: middle;border-width: 0"/><span id="pm_notice" >0</span></a>    &nbsp;&nbsp;
    <a href="/user/logout">退出</a>
</div>
</div>

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
            <li><a href="javascript:void(0)" onclick="showMain(this)" url="MyClass_showMessage.action">留言板</a></li>
            <li><a href="javascript:void(0)" onclick="showMain(this)" url="">成员</a></li>
            <li><a href="javascript:void(0)" onclick="showMain(this)" url="MyClass_addressBook.action">通讯录</a></li>
            <li><a href="javascript:void(0)" onclick="showMain(this)" url="MyClass_showClassphoto.action">相册</a></li>
                    </ul>
        <div class="clear"></div>
    </div>
</div>
        <div id="main">
                    <!--  <style type="text/css">
#class_room_deny{ font-size: 12px; padding: 10px; color: #f33; margin: 10px 20px; clear: both; height: 300px }
</style>  -->
<div id="homepage">
<div class="main_left" id="main_left" style="width: 680px;">
<div class="span-15" id="class_room_deny" >
  
</div>
</div>

<%-- <div id="main_right">
<div class="rightbox">
            <div class="userbox_left">
           
            <c:if test="${user.remark==null}" var="">
               <img src="./image/default.jpg" style="width:84px;height: 84px"/> 
              </c:if>
              
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

</div> --%>




</div>
<div class="clear"></div>            <div class="clear"></div>
        </div>
        <div id="footer">
           

<!--footer-->
<div class="links">
        <a href="/aa">关于我们</a><a href="/help/file">档案查询</a><a href="http://zuaa.zju.edu.cn/mobile">3G版</a> <a href="/bbs/list?f=0&b=68">意见建议</a><a href="#">  隐私声明</a><a href="#">版权申明</a></div>
联系信箱：zuaa@zju.edu.cn 



</div>

</form>
</body>

</html>
