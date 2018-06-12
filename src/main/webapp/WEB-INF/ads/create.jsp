<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Post on my List</h1>
    <form action="/ads/create" method="post">
        <div class="form-group">
            <label for="category">Select category:</label>
            <select class="form-control" id="category" name="category" type="radio" style="width: 15%">
                <option>for rent</option>
                <option>for sale</option>
                <option>for free</option>
                <option>discounted</option>
            </select>
        </div>

        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text">
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text"></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
<%@ include file="/WEB-INF/partials/script.jsp"%>


</body>
</html>
