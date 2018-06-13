<%--
  Created by IntelliJ IDEA.
  User: computer
  Date: 6/12/18
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>this is a ad page</h1>
<form method="post" action="/ads/page?id=${adId}">
    <button name="edit" type="submit" value="1">edit</button>
</form>
<form method="post" action="/ads/page?id=${adId}">
    <button name="delete" type="submit" value="1">delete</button>

</form>
<form method="post" action="/ads/page?id=${adId}">
    <button name="ban" type="submit" value="1">ban</button>

</form>

</body>
</html>
