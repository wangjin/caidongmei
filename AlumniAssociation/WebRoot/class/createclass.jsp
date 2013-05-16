<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>创建班级</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-1.6.js"></script>
<link href="../css/index.css" rel="stylesheet" type="text/css" />
<link  href="../css/public.css" rel="stylesheet" type="text/css" />
<link  href="../css/global.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">


</script><style type="text/css">
    	    #class_table th{ background: #f8f8f8; border-bottom: 1px solid #ccc; height: 30px;line-height: 30px}
    	    #class_table td{ border-bottom: 1px solid #eee; height: 30px;line-height: 30px}
    	    #class_year li{ float: left; width: 155px;border:0px solid #ccc; margin:3px 5px; }
    	    #class_year li a{display: block;padding:4px 4px 4px 15px; }
    	    #class_year li a span{ color: #444}
    	    #class_year li a:link,#class_year li a:visited{ display: block;background-color: #F2F7FA}
    	    #class_year li a:hover{background-color: #E3EDF7}
    	</style>
</head>

<body>
<form action="MyClass_createClass.action" method="post">
<div class=" content">
  <div class="head">
    <div class="top">
      <ul class="linklist1 top_link cf">
        <li> <a  title="处长信箱" href="#" target="_blank">处长信箱 | </a> </li>
        <li> <a title="淮工首页" href="#" target="_blank">淮工首页 |</a> </li>
        <li> <a  title="办公系统" href="#" target="_blank">办公系统 |</a> </li>
        <li > <a  title="联系我们" href="#" target="_blank">联系我们</a> </li>
      </ul>
    </div>
    <div class="logo"><img  src="../images/logo.gif" alt=""/></div>
    <div  class="mani_nav">
      <div class="main_nav_left"></div>
      <div class="main_nav_center">
        <div class="menu">
          <ul>
            <li><a href="IndexBefore_getTopNews.action">首 页</a></li>
            <li class="mainlevel" ><a  href="main.jsp">动态信息</a>
            <div id="submenu1" style="display:block" >
              <ul>
                <li><a  href="javascript:;">工作职责</a></li>
                <li><a  href="javascript:;">管理队伍</a></li>
              </ul>
              </div>
            </li>
            <li class="mainlevel"><a  href="javascript:;">规章制度</a>
              <ul>
                <li><a  href="javascript:;">教学研究</a></li>
                <li><a  href="javascript:;">教学运行</a></li>
                <li><a  href="javascript:;">考试管理</a></li>
                <li><a  href="javascript:;">学籍管理</a></li>
                <li><a  href="javascript:;">实践教学</a></li>
                <li><a  href="javascript:;">教学研究</a></li>
              </ul>
            </li>
            <li class="mainlevel"><a  href="javascript:;">管理文件</a>
              <ul>
                <li><a  href="javascript:;">学校文件</a></li>
                <li><a  href="javascript:;">教务处文件</a></li>
              </ul>
            </li>
            <li class="mainlevel"><a  href="javascript:;">人才培养</a>
              <ul>
                <li><a  href="javascript:;">专业设置</a></li>
                <li><a  href="javascript:;">培养方案</a></li>
                <li><a  href="javascript:;">课程库</a></li>
              </ul>
            </li>
            <li class="mainlevel"><a  href="javascript:;">教学改革</a>
              <ul>
                <li><a  href="javascript:;">完全学分制改革</a></li>
                <li><a  href="javascript:;">大类培养改革</a></li>
                <li><a  href="javascript:;">考试改革</a></li>
              </ul>
            </li>
            <li class="mainlevel"><a href="javascript:;">实践教学</a>
              <ul>
                <li><a  href="javascript:;">完全学分制改革</a></li>
                <li><a  href="javascript:;">大类培养改革</a></li>
                <li><a  href="javascript:;">考试改革</a></li
            >
              </ul>
            </li>
            <li class="mainlevel"><a href="javascript:;">工作流程</a>
              <ul>
                <li><a  href="javascript:;">完全学分制改革</a></li>
                <li><a  href="javascript:;">大类培养改革</a></li>
                <li><a  href="javascript:;">考试改革</a></li>
              </ul>
            </li>
            <li class="mainlevel"><a  href="javascript:;">下载专区</a>
              <ul>
                <li><a  href="javascript:;">完全学分制改革</a></li>
                <li><a  href="javascript:;">大类培养改革</a></li>
                <li><a  href="javascript:;">考试改革</a></li>
              </ul>
            </li>
            <li class="mainlevel"><a href="javascript:;">教学简报</a>
              <ul>
                <li><a  href="javascript:;">完全学分制改革</a></li>
                <li><a  href="javascript:;">大类培养改革</a></li>
                <li><a  href="javascript:;">考试改革</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
      <div  class="main_nav_right"></div>
    </div>
  </div>
  <div class="clear"></div>
  <!--头部结束-->
   
  <div id="body">
                <div class="clear"></div>
                                                <!-- classroom/create:body -->
<div>
    <div id="main_left">
<p><img src="../image/class_title.gif" /></p>

<div style="margin: 15px 10px">
    <h3>新建班级：</h3>
    

	<table>
	    <tr>
		<td style="text-align:right;width:150px"><span style="color:#f00">*</span>&nbsp;入学及毕业年份：</td>
		<td><input type="text" name="entertime" style="width:80px" class="input_text" readonly="readonly" value="${entertime}"/> ~ <input type="text" name="finish_year" style="width:80px" class="input_text"/>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#999">提示：毕业年份可以不填</span></td>
	    </tr>

	    <tr>
		<td style="text-align:right"><span style="color:#f00">*</span>&nbsp;班級名称：</td>
		<td><input type="text" name="classname" style="width:300px" value="${classname}" readonly="readonly" class="input_text"/>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#999">例如：机械设计与制造</span></td>
	    </tr>

	    <tr>
		<td style="text-align:right"><span style="color:#f00">*</span>&nbsp;所属学院(系)：</td>
		<td><input type="text" name="classdeptname" style="width:300px" value="${classdeptname}" readonly="readonly" class="input_text"/>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#999">例如：工程技术学院</span></td>
	    </tr>
	    <tr>
		<td></td>
		<td>
		    <input type="submit" value="确定创建"  class="button_blue" />
		    <input type="button" onclick="window.history.back()" class="button_gray" value="取消"/>
		</td>
	    </tr>
	</table>
   
    </div>
    </div>

    <div class="clear"></div>
</div>
                <div class="clear"></div>
            </div>


</div>
 <div id="footer">
                <div class="clear"></div>
                                              
<!--footer-->
<div class="links">
        <a href="/aa">关于我们</a><a href="/help/file">档案查询</a><a href="http://zuaa.zju.edu.cn/mobile">3G版</a> <a href="/bbs/list?f=0&b=68">意见建议</a><a href="#">  隐私声明</a><a href="#">版权申明</a></div>
联系信箱：caidongmei@hotmail.com 地址：连云港市新浦66号淮海工学院校友总会 邮编：310058<br>
淮海工学院校友总会版权所有 All rights reserved by Zhejiang University Alumni Association 浙ICP备10048528号 <br>
为了您的安全及获得最佳浏览体验，建议您使用IE8、Firefox4、Chrom20或更高浏览器&nbsp;&nbsp;技术支持：<a href="http://www.usho.cn/" >王金</a>
</div>
</form>

</body>
</html>
