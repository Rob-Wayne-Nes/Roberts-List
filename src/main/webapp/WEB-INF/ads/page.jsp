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
    <style>
    .invited{
        display: none;
    }
    </style>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="${ad.title}" />

    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<h1 class="text-center" style="font-family: Helvetica, sans-serif">This is the ad you selected </h1>
<h1 class="text-center">Welcome to Robert's List, ${sessionScope.user.username}</h1>




<form method="post" action="/ads/page?id=${adId}">
    <button name="edit" type="submit" value="1">edit</button>
</form>
<form method="post" action="/ads/page?id=${adId}">
    <button name="delete" type="submit" value="1">delete</button>


<div class="container">


    <h1 class="text-center">Welcome to Robert's List, ${sessionScope.user.username}</h1>
    <form method="post" action="/ads/page?id=${adId}">
        <button name="edit" type="submit" value="1">edit</button>
    </form>
    <form method="post" action="/ads/page?id=${adId}">
        <button name="delete" type="submit" value="1">delete</button>
    </form>
    <form method="post" action="/ads/page?id=${adId}">
        <button name="ban" type="submit" value="1">ban</button>
    </form>

    <h1>${ad.title}</h1>

    <p>${ad.description}</p>
    <p>${ad.category}</p>



    <form action="/delete" method="post">
        <label for="deactivate"></label>
        <button id="deactivate" name="deleteById" class="btn btn-danger" value="${ad.id}">delete</button>

        <label for="edit"></label>
        <button type="button" id="edit" name="editAd" class="btn btn-primary" value="${ad.id}" placeholder="edit">Edit</button>


<div class="admin" style="background-color: antiquewhite; display:${display}">
    <form method="post" action="/ads/page?id=${ad.id}">
        <button name="edit" type="submit" value="1">edit</button>
    </form>
    <form method="post" action="/ads/page?id=${ad.id}">
        <button name="delete" type="submit" value="1">delete</button>
    </form>
</div>

<div class="container">
        <div class="container">
            <div class="jumbotron">
                <p>Welcome to Robert's List, <span>${sessionScope.user.username}</span>.</p>
                <h1>This is the ad you selected</h1>
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
                <p>${ad.category}</p>
            </div>
            <div  style="display:${clase} ">
                <form action="/delete" method="post">
                    <label for="deactivate"></label>
                    <button id="deactivate" name="deleteById" class="btn btn-danger" value="${ad.id}">delete</button>

                    <label for="edit"></label>
                    <button type="button" id="edit" name="editAd" class="btn btn-primary" value="${ad.id}" placeholder="edit">Edit</button>
                </form>

                <form method="post" action="/ads/page?id=${adId}">
                <button name="ban" type="submit" value="1">ban</button>
                </form>
            </div>
        </div>

<form method="post" action="/ads/page?id=${adId}">
    <button name="ban" type="submit" value="1">ban</button>







</div>

<%@ include file="/WEB-INF/partials/script.jsp"%>

</body>
</html>
