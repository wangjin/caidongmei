<%@ page contentType="text/html; charset=GBK" language="java" %>
<html>
<head>
<title>发表留言</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="../css/message.css" rel="stylesheet">
<script src="../js/UBBCode.js"></script>
<script type="text/javascript" >
function checkform(myform){
	form1.content.value=oEditor.document.body.innerHTML;
	for(i=0;i<myform.length;i++){
		if(myform.elements[i].value==""){
			alert(myform.elements[i].title+"不能为空！");
			myform.elements[i].focus();
			return false;
		}
	}
}
</script>
</head>
<body>
<form name="form1" method="post" action="Mail" onSubmit="return checkform(form1)">
<table width="588" height="389"  border="0" align="center" cellpadding="0" cellspacing="0" background="./images/bg.jpg">
  <tr>
    <td width="60" height="73" background="../images/board_left.gif">&nbsp;</td>
    <td width="486" background="../images/board_left.gif">&nbsp;</td>
    <td width="46" background="../images/board_left.gif">&nbsp;</td>
  </tr>
  <tr valign="top">
    <td height="247">&nbsp;</td>
    <td valign="top"><table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="16%" height="27" align="center">收件人：</td>
        <td width="84%" colspan="2" align="left"><input name="to" type="text" id="to" title="收件人" size="60" value="songkun666888@sohu.com"></td>
      </tr>
      <tr>
        <td height="27" align="center">发件人：</td>
        <td colspan="2" align="left"><input name="from" type="text" id="from" title="发件人" size="60" value="wgh717@sohu.com"></td>
      </tr>
      <tr>
        <td height="27" align="center">密&nbsp;&nbsp;码：</td>
        <td colspan="2" align="left"><input name="password" type="password" id="password" title="发件人信箱密码" size="60" value="111111"></td>
      </tr>
      <tr>
        <td height="27" align="center">主&nbsp;&nbsp;题：</td>
        <td colspan="2" align="left"><input name="subject" type="text" id="subject" title="邮件主题" size="60"></td>
      </tr>
      <tr>
        <td height="27" align="center">&nbsp;</td>
        <td colspan="2" align="left"><table width="98%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="35%"><img src="../images/UBB/B.gif" width="21" height="20" onClick="bold()"><img src="../images/UBB/I.gif" width="21" height="20" onClick="italic()"><img src="../images/UBB/U.gif" width="21" height="20" onClick="underline()"> <img src="../images/UBB/left.gif" width="14" height="14" onClick="left()"> <img src="../images/UBB/center.gif" width="14" height="14" onClick="center()"> <img src="../images/UBB/right.gif" width="14" height="14" onClick="right()"></td>
            <td width="65%">字体
              <select name="font" class="wenbenkuang" id="font" onChange="txtFont(this.options[this.selectedIndex].value)">
                  <option value="宋体" selected>宋体</option>
                  <option value="黑体">黑体</option>
                  <option value="隶书">隶书</option>
                  <option value="华文行楷">行楷</option>
				  <option value="楷体_GB2312">楷体</option>
                </select>
              字号
                <select
      name="size" class="wenbenkuang" onChange="txtFontSize(this.options[this.selectedIndex].value)">
                  <option value=1>1</option>
                  <option value=2>2</option>
                  <option value=3 selected>3</option>
                  <option value=4>4</option>
                  <option value="5">5</option>
                  <option value="6">6</option>
                  <option value="7">7</option>
                </select>
              <select onChange="txtColor(this.options[this.selectedIndex].value)" name="color" size="1" class="wenbenkuang" id="color">
              <option selected  value="#000000">默认颜色</option>
              <option style="color:#FF0000" value="#FF0000">红色热情</option>
              <option style="color:#0000FF" value="#0000ff">蓝色开朗</option>
              <option style="color:#ff00ff" value="#ff00ff">桃色浪漫</option>
              <option style="color:#009900" value="#009900">绿色青春</option>
              <option style="color:#009999" value="#009999">青色清爽</option>
              <option style="color:#990099" value="#990099">紫色拘谨</option>
              <option style="color:#990000" value="#990000">暗夜兴奋</option>
              <option style="color:#000099" value="#000099">深蓝忧郁</option>
              <option style="color:#999900" value="#999900">卡其制服</option>
              <option style="color:#ff9900" value="#ff9900">镏金岁月</option>
              <option style="color:#0099ff" value="#0099ff">湖波荡漾</option>
              <option style="color:#9900ff" value="#9900ff">发亮蓝紫</option>
              <option style="color:#ff0099" value="#ff0099">爱的暗示</option>
              <option style="color:#006600" value="#006600">墨绿深沉</option>
              <option style="color:#999999" value="#999999">烟雨蒙蒙</option>
            </select>              </td>
              </tr>
          </table></td>
      </tr>
      <tr>
        <td height="116" align="center">内&nbsp;&nbsp;容：
          <input type="hidden" name="content" title="邮件内容"></td>
        <td colspan="2" align="left"><iframe src="../class/blank.htm" width="386" height="100" class="noborder" id="oEditor"></iframe></td>
      </tr>
      <tr>
        <td height="30" align="center">&nbsp;</td>
        <td height="40" align="right"><input name="Submit" type="submit" class="btn_bg" value="发送">
          &nbsp;
          <input name="Submit2" type="reset" class="btn_bg" value="重置">
          &nbsp;
</td>
        <td align="left">&nbsp;</td>
      </tr>
    </table></td>
    <td>&nbsp;</td>
  </tr>
  <tr valign="top">
    <td height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</form>
</body>
</html>
