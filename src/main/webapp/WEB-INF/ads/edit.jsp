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

    <div class="form-group">
        <label for="title">Title</label>
        <input id="title" name="title" class="form-control" type="text" value="${title}>
    </div>


     <div class="form-group">
        <%--todo form group is shitting itsself--%>

        <label for="description">Description</label>
        <textarea id="description" name="description" class="form-control" value="${description}" type="text"></textarea>
    </div>


        <input name="adId" value="${adId}" type="hidden">



        <input type="submit" class="btn btn-block btn-primary">
    </div>
</form>

    <%--***************--%>
    <%--<input name="title" type="text" value="${title}">--%>
        <%--<div class="form-group">--%>
        <%--<label for="description" ">Description</label>--%>

        <%--</textarea>--%>
        <%--</div>--%>
    <%--<input name="adId" value="${adId}" type="hidden">--%>
    <%--<button name="delete" type="submit" value="1">Update</button>--%>
    <%--</div>--%>
<%--</form>--%>

<%@ include file="/WEB-INF/partials/script.jsp"%>
    </body>
</html>
