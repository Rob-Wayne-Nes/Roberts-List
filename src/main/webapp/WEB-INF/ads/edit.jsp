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

<form method="post" action="/ads/edit">
    <div class="container">

        <label for="category">Select category:</label>
        <select class="form-control" id="category" name="category" type="radio" style="width: 15%">
            <option>for rent</option>
            <option>for sale</option>
            <option>for free</option>
            <option>discounted</option>
        </select>

    <div class="form-group">
            <label for="title">Title</label>
            <input type="text" name="title" id="title" class="form-control" value="${title}">
    </div>

     <div class="form-group">
        <%--todo form group is shitting itsself--%>

        <label for="description">Description</label>
        <textarea id="description" name="description" class="form-control" type="text">${description}</textarea>

    </div>

        <input name="adId" value="${adId}" type="hidden">

        <input type="submit" class="btn btn-block btn-primary">
    </div>
</form>

<%@ include file="/WEB-INF/partials/script.jsp"%>
    </body>
</html>
