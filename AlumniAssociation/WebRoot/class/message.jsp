<%@ page contentType="text/html; charset=GBK" language="java" %>
<html>
<head>
<title>��������</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="../css/message.css" rel="stylesheet">
<script src="../js/UBBCode.js"></script>
<script type="text/javascript" >
function checkform(myform){
	form1.content.value=oEditor.document.body.innerHTML;
	for(i=0;i<myform.length;i++){
		if(myform.elements[i].value==""){
			alert(myform.elements[i].title+"����Ϊ�գ�");
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
        <td width="16%" height="27" align="center">�ռ��ˣ�</td>
        <td width="84%" colspan="2" align="left"><input name="to" type="text" id="to" title="�ռ���" size="60" value="songkun666888@sohu.com"></td>
      </tr>
      <tr>
        <td height="27" align="center">�����ˣ�</td>
        <td colspan="2" align="left"><input name="from" type="text" id="from" title="������" size="60" value="wgh717@sohu.com"></td>
      </tr>
      <tr>
        <td height="27" align="center">��&nbsp;&nbsp;�룺</td>
        <td colspan="2" align="left"><input name="password" type="password" id="password" title="��������������" size="60" value="111111"></td>
      </tr>
      <tr>
        <td height="27" align="center">��&nbsp;&nbsp;�⣺</td>
        <td colspan="2" align="left"><input name="subject" type="text" id="subject" title="�ʼ�����" size="60"></td>
      </tr>
      <tr>
        <td height="27" align="center">&nbsp;</td>
        <td colspan="2" align="left"><table width="98%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="35%"><img src="../images/UBB/B.gif" width="21" height="20" onClick="bold()"><img src="../images/UBB/I.gif" width="21" height="20" onClick="italic()"><img src="../images/UBB/U.gif" width="21" height="20" onClick="underline()"> <img src="../images/UBB/left.gif" width="14" height="14" onClick="left()"> <img src="../images/UBB/center.gif" width="14" height="14" onClick="center()"> <img src="../images/UBB/right.gif" width="14" height="14" onClick="right()"></td>
            <td width="65%">����
              <select name="font" class="wenbenkuang" id="font" onChange="txtFont(this.options[this.selectedIndex].value)">
                  <option value="����" selected>����</option>
                  <option value="����">����</option>
                  <option value="����">����</option>
                  <option value="�����п�">�п�</option>
				  <option value="����_GB2312">����</option>
                </select>
              �ֺ�
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
              <option selected  value="#000000">Ĭ����ɫ</option>
              <option style="color:#FF0000" value="#FF0000">��ɫ����</option>
              <option style="color:#0000FF" value="#0000ff">��ɫ����</option>
              <option style="color:#ff00ff" value="#ff00ff">��ɫ����</option>
              <option style="color:#009900" value="#009900">��ɫ�ഺ</option>
              <option style="color:#009999" value="#009999">��ɫ��ˬ</option>
              <option style="color:#990099" value="#990099">��ɫ�н�</option>
              <option style="color:#990000" value="#990000">��ҹ�˷�</option>
              <option style="color:#000099" value="#000099">��������</option>
              <option style="color:#999900" value="#999900">�����Ʒ�</option>
              <option style="color:#ff9900" value="#ff9900">�ֽ�����</option>
              <option style="color:#0099ff" value="#0099ff">��������</option>
              <option style="color:#9900ff" value="#9900ff">��������</option>
              <option style="color:#ff0099" value="#ff0099">���İ�ʾ</option>
              <option style="color:#006600" value="#006600">ī�����</option>
              <option style="color:#999999" value="#999999">��������</option>
            </select>              </td>
              </tr>
          </table></td>
      </tr>
      <tr>
        <td height="116" align="center">��&nbsp;&nbsp;�ݣ�
          <input type="hidden" name="content" title="�ʼ�����"></td>
        <td colspan="2" align="left"><iframe src="../class/blank.htm" width="386" height="100" class="noborder" id="oEditor"></iframe></td>
      </tr>
      <tr>
        <td height="30" align="center">&nbsp;</td>
        <td height="40" align="right"><input name="Submit" type="submit" class="btn_bg" value="����">
          &nbsp;
          <input name="Submit2" type="reset" class="btn_bg" value="����">
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
