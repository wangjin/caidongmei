<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申请加入班级</title>
<script type="text/javascript" src="js/jquery-1.6.js"></script>
<link href="../css/index.css" rel="stylesheet" type="text/css" />
<link  href="../css/public.css" rel="stylesheet" type="text/css" />
<link  href="../css/aa.css" rel="stylesheet" type="text/css" />
<style type="text/css">
    	    #class_table th{ background: #f8f8f8; border-bottom: 1px solid #ccc; height: 30px;line-height: 30px}
    	    #class_table td{ border-bottom: 1px solid #eee; height: 30px;line-height: 30px}
    	    #class_year li{ float: left; width: 155px;border:0px solid #ccc; margin:3px 5px; }
    	    #class_year li a{display: block;padding:4px 4px 4px 15px; }
    	    #class_year li a span{ color: #444}
    	    #class_year li a:link,#class_year li a:visited{ display: block;background-color: #F2F7FA}
    	    #class_year li a:hover{background-color: #E3EDF7}
    	</style>
</head>


<body style="background-image: url('../image/background.jpg'); repeat-x ">
<form action="MyClass_applyforenterClass.action">
        <div id="append_parent"></div>
        <div id="top_tool">
    <div class="cur_here"><a href="/">淮海工学院校友网</a> &gt; <a href="/classroom">班级录</a> &gt; ${user.graduation}级${classname}</div>
    <div class="user_nav">欢迎回来，<a href="/user_home" title="进入个人主页"> ${user.username}</a>&nbsp;&nbsp;<a href="/user_msg" title="站内信息"><img src="../image/user/email.gif" style="margin-right:2px; vertical-align: middle;border-width: 0"/><span id="pm_notice" >0</span></a>    &nbsp;&nbsp;
    <a href="/user/logout">退出</a>
</div>
</div>

<div id="hp_top" >
    <div id="hp_name">
        <span class="hp_logo"><img src="../image/xiaohui.jpg" /></span>
        <span class="hp_title"><a href="../image/xiaohui.jpg">${user.graduation}级${classname}</a></span>
        <span class="sign_members">${user.classone.peoplecount}人</span>
    </div>
    <div id="hp_nav">
        <ul class="menu" id="menus">
            <li><a href="/classroom_home?id=1000012427" >首页</a></li>
            <li><a href="/classroom_home/bbs?id=1000012427" >话题</a></li>
            <li><a href="/classroom_home/guestbook?id=1000012427" >留言板</a></li>
            <li><a href="/classroom_home/members?id=1000012427" >成员</a></li>
            <li><a href="/classroom_home/addressbook?id=1000012427" >通讯录</a></li>
            <li><a href="/classroom_home/album?id=1000012427" class="cur">相册</a></li>
                    </ul>
        <div class="clear"></div>
    </div>
</div>
        <div id="main">
                        <style type="text/css">
#class_room_deny{ font-size: 12px; padding: 10px; color: #f33; margin: 10px 20px; clear: both; height: 300px }
</style>

<div id="main_left" style="width: 680px;">
<div class="span-15" id="class_room_deny">
    很抱歉，您还不是本班成员(该班级已创建，只能申请加入)，暂时不能浏览该页信息。
</div>
</div>

<div id="main_right">
<div class="rightbox">
            <div class="userbox_left">
            <img src="../image/default.jpg" style="width:84px;height: 84px"/>
        </div>
        <div class="userbox_right">
            <span class="username">acai</span><br>
            <span>你还没有加入<br>现在就加入吧！</span>
        </div>
        <div class="clear"></div>
        <div style="text-align: center; padding: 10px 0">
            <input type="submit" class="sign_button_green" value="" "/>
        </div>
    </div>

</div>

<div class="clear"></div>            <div class="clear"></div>
        </div>
        <div id="footer">
           

<!--footer-->
<div class="links">
        <a href="/aa">关于我们</a><a href="/help/file">档案查询</a><a href="http://zuaa.zju.edu.cn/mobile">3G版</a> <a href="/bbs/list?f=0&b=68">意见建议</a><a href="#">  隐私声明</a><a href="#">版权申明</a></div>
联系信箱：zuaa@zju.edu.cn 地址：杭州西湖区余杭塘路866号浙江大学校友总会 邮编：310058<br>
浙江大学校友总会版权所有 All rights reserved by Zhejiang University Alumni Association 浙ICP备10048528号 <br>
为了您的安全及获得最佳浏览体验，建议您使用IE8、Firefox4、Chrom20或更高浏览器&nbsp;&nbsp;技术支持：<a href="http://www.usho.cn/" >友笑网络</a>


</div>

</form>
</body>

</html>
