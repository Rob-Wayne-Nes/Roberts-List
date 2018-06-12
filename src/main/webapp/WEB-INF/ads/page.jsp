<%--
  Created by IntelliJ IDEA.
  User: nestorsalinas
  Date: 6/12/18
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Check it out!" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>this is the page JSP </h1>

    <form action="/ads/page" method="post">
        <input type="button" class="btn btn-danger" name="submit">
        <input type="button" class="btn btn-danger" name="submit">
        <input type="button" class="btn btn-danger" name="submit">
    </form>



</div>
<%@ include file="/WEB-INF/partials/script.jsp"%>
</body>
</html>
