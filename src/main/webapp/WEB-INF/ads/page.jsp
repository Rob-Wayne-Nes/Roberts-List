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

    <h1 class="text-center">Welcome to Robert's List, ${sessionScope.user.username}</h1>
    <h1>${ad.title}</h1>

    <p>${ad.description}</p>
    <p>${ad.category}</p>



    <form action="/delete" method="post">
        <label for="deactivate"></label>
        <button id="deactivate" name="deleteById" class="btn btn-danger" value="${ad.id}">delete</button>

        <label for="edit"></label>
        <button type="button" id="edit" name="editAd" class="btn btn-primary" value="${ad.id}" placeholder="edit">Edit</button>

    </form>




</div>
<%@ include file="/WEB-INF/partials/script.jsp"%>
</body>
</html>
