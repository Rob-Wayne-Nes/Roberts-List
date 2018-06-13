<%--
  Created by IntelliJ IDEA.
  User: computer
  Date: 6/12/18
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your profile!" />
    </jsp:include>


</head>
<body>
<%@ include file="/WEB-INF/partials/navbar.jsp"%>

    <form action="">

    <input type="text" placeholder="${title}">
    </form>

<%@ include file="/WEB-INF/partials/script.jsp"%>
    </body>
</html>
