<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/30
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script type="text/javascript">
    document.createElement('main');
  </script>
</head>
<body>
<form action="http://t-bms.xianchida.com/_upload" method="post" enctype="multipart/form-data" target="getJsonText" class="entry">
  <table>
    <tr class="file">
      <th class="required">文件</th>
      <td><input type="file" name="image"></td>
    </tr>
  </table>
  <p class="button"><input type="submit" value="上传"></p>
  <input type="button" name="image" value="获取id" onclick="alert( document.getElementById('getJsonText').contentWindow.document.getElementsByTagName('pre')[0].innerHTML)">
  <p class="note">↓↓实际是用「display: none;」来隐藏的iframe↓↓</p>
  <iframe class="hideIframe" id="getJsonText" name="getJsonText"></iframe>
</form>
</body>
</html>
