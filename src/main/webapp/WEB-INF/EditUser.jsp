<%--
  Created by IntelliJ IDEA.
  User: computer
  Date: 6/15/18
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Please fill in your information.</h1>
    <form action="/profile/edit" method="post">
        <input value="${sessionScope.user.id}" name="id" type="hidden">
        <div class="form-group">
            <label for="username">Username</label>
            <input value="${sessionScope.user.username}" id="username" name="username" class="form-control" autocomplete="off" type="text">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input value="${sessionScope.user.email}" id="email" name="email" class="form-control" autocomplete="off" type="text">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input  id="password" name="password" class="form-control" autocomplete="off" type="password">
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</div>

</body>
</html>
