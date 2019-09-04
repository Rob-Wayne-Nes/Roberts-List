<%--
  Created by IntelliJ IDEA.
  User: computer
  Date: 6/12/18
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">

        <jsp:param name="title" value="${ad.title}" />

    </jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="admin container" style="background-color: antiquewhite; display:${display}; max-width: 75%; min-height: 50px">
    <form method="post" action="/ads/page?id=${ad.id}">
        <p>User Dashboard</p>
        <label for="editadmin"></label>
        <button name="edit" type="submit" id ="editadmin" value="1" class="btn" style="display: inline-block;">edit</button>
        <label for="deleteAdmin"></label>
        <button name="delete" id="deleteAdmin" type="submit" value="1" class="btn" style="display: inline-block">delete</button>
    </form>
</div>

<div class="container">
    <div class="container">
        <div class="jumbotron">
            <p>Welcome to the Ad's Lister, <span>${sessionScope.user.username}</span>.</p>
            <h1>This is the ad you selected</h1>
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <p>${ad.category}</p>

            <div class="container">
            <div class="thumbnail">
                <!-- because of it's location in the structure of the server, we have to make the dir back out one below -->
                <c:set var="filepath" scope="request" value="target/adlister-1.0-SNAPSHOT/" />
                <c:set var="imageText" scope="request" value="${ad.image}"/>
                <c:choose>
                    <c:when test="${fn:contains(imageText, filepath)}">
                        <img class="container" src="/target/adlister-1.0-SNAPSHOT/${ad.image}" alt="">
                    </c:when>
                    <c:otherwise>
                        <a href="#">
                        <img class="container" src="/target/adlister-1.0-SNAPSHOT/${ad.image}" alt="">
                        </a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <div  style="display:${clase} ">
            <form action="/delete" method="post">
                <label for="deactivate"></label>
                <button id="deactivate" name="deleteById" class="btn btn-danger" value="${ad.id}">delete</button>
            </form>
            <a href="/ads/edit?id=${ad.id}">
                <label for="edit"></label>
                <button type="button" id="edit" name="editAd" class="btn btn-primary" value="${ad.id}" placeholder="edit">Edit</button>
            </a>

        </div>
    </div>

</div>

<%@ include file="/WEB-INF/partials/script.jsp"%>

</body>
</html>


1 CommentCollapse 
