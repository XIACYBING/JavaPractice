<%--
  Created by IntelliJ IDEA.
  User: Wangy
  Date: 5/31/2019
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadFile</title>
</head>
<body>
    <form action="upload" method="POST" enctype="multipart/form-data">
        <input type="file" id="file" name="file">
        <input type="submit" value="上传">
    </form>
</body>
</html>
