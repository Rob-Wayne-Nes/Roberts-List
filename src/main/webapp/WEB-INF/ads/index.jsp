<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your profile!" />
    </jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Welcome to Robert's List, ${sessionScope.user.username}</h1>


    <div class="row mt-5">
        <c:forEach var="ad" items="${ads}">

            <div class="mb-2 col-sm-2 text-center">

            <a href="/ads/page?id=${ad.id}">
                <div class="card" style="background-color: aqua">
                    <div class="card-body">
                        <h3 class="card-title " style="font-family: 'Jua', sans-serif" >${ad.title}</h3>
                        <p class="card-text head">${ad.description}</p>
                            <%--todo The add.category isn't apart of the ad dao. fix it.--%>
                        <p class="card-text head">${ad.category}</p>
                        <form action="/delete" method="post">
                            <button name="deleteById" class="btn btn-danger" value="${ad.id}">delete</button>
                        </form>
                    </div>
                </div>
            </div>
            </a>
        </c:forEach>
    </div>


</div>
<%@ include file="/WEB-INF/partials/script.jsp"%>

</body>
</html>

