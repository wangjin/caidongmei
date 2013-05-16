<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>前台根据2008级（12班）显示该级所有班级</title>
<script type="text/javascript" src="js/jquery-1.6.js"></script>
<link href="./css/index.css" rel="stylesheet" type="text/css" />
<link  href="./css/public.css" rel="stylesheet" type="text/css" />
<link  href="./css/global.css" rel="stylesheet" type="text/css" />
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
<form action="">
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
    <div class="logo"><img  src="./images/logo.gif" alt=""/></div>
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
                                                <!-- class/index:_body -->
<div>
    <div id="main_left">
<p><img src="./image/class_title.gif"/></p>
<div style="padding:4px 10px">
	    <form method="get" action="/classroom/list">
         <table>
             <tr>
                 <td style="text-align:right">搜索方式：</td>
                 <td><input type="radio" name="searchtype" value="specialty" checked/>按专业<input type="radio" name="searchtype" value="classmate"  />按同学</td>
             </tr>
             <tr>
                 <td style="text-align:right">入学年份：</td>
                 <td>		<select name="start_year" style="padding:1px 2px;">
       <option value="">年份不限</option>
		        		    <option value="2013"  >2013</option>
		        		    <option value="2012"  >2012</option>
		        		    <option value="2011"  selected>2011</option>
		        		    <option value="2010"  >2010</option>
		        		    <option value="2009"  >2009</option>
		        		    <option value="2008"  >2008</option>
		        		    <option value="2007"  >2007</option>
		        		    <option value="2006"  >2006</option>
		        		    <option value="2005"  >2005</option>
		        		    <option value="2004"  >2004</option>
		        		    <option value="2003"  >2003</option>
		        		    <option value="2002"  >2002</option>
		        		    <option value="2001"  >2001</option>
		        		    <option value="2000"  >2000</option>
		        		    <option value="1999"  >1999</option>
		        		    <option value="1998"  >1998</option>
		        		    <option value="1997"  >1997</option>
		        		    <option value="1996"  >1996</option>
		        		    <option value="1995"  >1995</option>
		        		    <option value="1994"  >1994</option>
		        		    <option value="1993"  >1993</option>
		        		    <option value="1992"  >1992</option>
		        		    <option value="1991"  >1991</option>
		        		    <option value="1990"  >1990</option>
		        		    <option value="1989"  >1989</option>
		        		    <option value="1988"  >1988</option>
		        		    <option value="1987"  >1987</option>
		        		    <option value="1986"  >1986</option>
		        		    <option value="1985"  >1985</option>
		        		    <option value="1984"  >1984</option>
		        		    <option value="1983"  >1983</option>
		        		    <option value="1982"  >1982</option>
		        		    <option value="1981"  >1981</option>
		        		    <option value="1980"  >1980</option>
		        		    <option value="1979"  >1979</option>
		        		    <option value="1978"  >1978</option>
		        		    <option value="1977"  >1977</option>
		        		    <option value="1976"  >1976</option>
		        		    <option value="1975"  >1975</option>
		        		    <option value="1974"  >1974</option>
		        		    <option value="1973"  >1973</option>
		        		    <option value="1972"  >1972</option>
		        		    <option value="1971"  >1971</option>
		        		    <option value="1970"  >1970</option>
		        		    <option value="1969"  >1969</option>
		        		    <option value="1968"  >1968</option>
		        		    <option value="1967"  >1967</option>
		        		    <option value="1966"  >1966</option>
		        		    <option value="1965"  >1965</option>
		        		    <option value="1964"  >1964</option>
		        		    <option value="1963"  >1963</option>
		        		    <option value="1962"  >1962</option>
		        		    <option value="1961"  >1961</option>
		        		    <option value="1960"  >1960</option>
		        		    <option value="1959"  >1959</option>
		        		    <option value="1958"  >1958</option>
		        		    <option value="1957"  >1957</option>
		        		    <option value="1956"  >1956</option>
		        		    <option value="1955"  >1955</option>
		        		    <option value="1954"  >1954</option>
		        		    <option value="1953"  >1953</option>
		        		    <option value="1952"  >1952</option>
		        		    <option value="1951"  >1951</option>
		        		    <option value="1950"  >1950</option>
		        		    <option value="1949"  >1949</option>
		        		    <option value="1948"  >1948</option>
		        		    <option value="1947"  >1947</option>
		        		    <option value="1946"  >1946</option>
		        		    <option value="1945"  >1945</option>
		        		    <option value="1944"  >1944</option>
		        		    <option value="1943"  >1943</option>
		        		    <option value="1942"  >1942</option>
		        		    <option value="1941"  >1941</option>
		        		    <option value="1940"  >1940</option>
		        		    <option value="1939"  >1939</option>
		        		    <option value="1938"  >1938</option>
		        		    <option value="1937"  >1937</option>
		        		    <option value="1936"  >1936</option>
		        		    <option value="1935"  >1935</option>
		        		    <option value="1934"  >1934</option>
		        		    <option value="1933"  >1933</option>
		        		    <option value="1932"  >1932</option>
		        		    <option value="1931"  >1931</option>
		        		    <option value="1930"  >1930</option>
		        		    <option value="1929"  >1929</option>
		        		    <option value="1928"  >1928</option>
		        		    <option value="1927"  >1927</option>
		        		    <option value="1926"  >1926</option>
		        		    <option value="1925"  >1925</option>
		        		    <option value="1924"  >1924</option>
		        		    <option value="1923"  >1923</option>
		        		    <option value="1922"  >1922</option>
		        		    <option value="1921"  >1921</option>
		        		    <option value="1920"  >1920</option>
		        		    <option value="1919"  >1919</option>
		        		    <option value="1918"  >1918</option>
		        		    <option value="1917"  >1917</option>
		        		    <option value="1916"  >1916</option>
		        		    <option value="1915"  >1915</option>
		        		    <option value="1914"  >1914</option>
		        		    <option value="1913"  >1913</option>
		        		    <option value="1912"  >1912</option>
		        		    <option value="1911"  >1911</option>
		        		    <option value="1910"  >1910</option>
		        		    <option value="1909"  >1909</option>
		        		    <option value="1908"  >1908</option>
		        		    <option value="1907"  >1907</option>
		        		    <option value="1906"  >1906</option>
		        		    <option value="1905"  >1905</option>
		        		    <option value="1904"  >1904</option>
		        		    <option value="1903"  >1903</option>
		        		    <option value="1902"  >1902</option>
		        		    <option value="1901"  >1901</option>
		        		    <option value="1900"  >1900</option>
		        		</select></td>
             </tr>
             <tr>
                 <td style="text-align:right">输入关键字：</td>
                 <td><input type="text" value="" id="name" name="keyword" size="60" class="input_text"  />&nbsp;&nbsp;<span style="color:#999">输入同学姓名或专业关键字</span></td>
             </tr>
             <tr>
                 <td>
                 </td>
                 <td>
                     <input type="submit" value="查找"  class="button_blue"/>
                 </td>
             </tr>
         </table>
    	    </form>


</div>

<div style="margin: 30px 10px">
    <h3>已经创建的班级：</h3>
    <table border="0" width="100%" id="class_table" cellspacing="0" cellpadding="0">
	<thead>
	    <tr>
		<th style="text-align:center">入学年份</th>
		<th  style="text-align:left">班级名称</th>
		<th style="text-align:center">人数</th>
		<!-- <th style="text-align:center">创建人</th> -->
		<th style="text-align:center">创建日期</th>

	    </tr>
	</thead>
	<tbody>
	  <c:forEach items="${pageModel.list}" var="m">		
       	    <tr>
		<td style="text-align:center">${m.entertime}</td>
		<td style="text-align:left"><a href="MyClass_showHomepage.action?entertime=${m.entertime}&&classname=${m.classname}" >${m.classdept.classdeptname}/${m.classname}</a></td>
		<td style="text-align:center">${m.peoplecount}</td>
		<!-- <td style="text-align:center">徐婵娜</td> -->
		<td style="text-align:center">${m.createtime}</td>

	    </tr>
    </c:forEach>	
    	 
    	
    	
    	</tbody>
    </table>

    </div>
    </div>
    <div id="sidebar_right">

<p class="sidebar_title" >人气排行榜</p>
<div class="sidebar_box">
	    			    	    <ul class="ranking" style="background: url('./image/topNum.gif') no-repeat">
					    		<c:forEach items="${classlistnine}" var="m">
					    		<li><a href="MyClass_showHomepage.action?entertime=${m.entertime}&&classname=${m.classname}">${m.entertime}级   ${m.classname}</a><span>(${m.peoplecount}人)</span></li>
					    		</c:forEach>
					    	    </ul>
	    </div>
</div>


    <div class="clear"></div>
</div>


<script type="text/javascript">
    candyPlaceholder('#aaa');
    candyHover('class_table', 'tr', '#f7f7f7');
</script>                                            
   <div class="clear"></div>
            </div>

 <div id="footer">
            <div class="clear"></div>
                                           

<!--footer-->
<div class="links">
        <a href="/aa">关于我们</a><a href="/help/file">档案查询</a><a href="http://zuaa.zju.edu.cn/mobile">3G版</a> <a href="/bbs/list?f=0&b=68">意见建议</a><a href="#">  隐私声明</a><a href="#">版权申明</a></div>
联系信箱：caidongmei@hotmail.com 地址：连云港市新浦66号淮海工学院校友总会 邮编：310058<br>
淮海工学院校友总会版权所有 All rights reserved by Zhejiang University Alumni Association 浙ICP备10048528号 <br>
为了您的安全及获得最佳浏览体验，建议您使用IE8、Firefox4、Chrom20或更高浏览器&nbsp;&nbsp;技术支持：<a href="http://www.usho.cn/" >王金</a>
</div></div>
</form>

</body>
</html>
