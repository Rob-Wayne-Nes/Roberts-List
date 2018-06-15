<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">

    <a class="navbar-brand" href="/ads">Robert's List</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <c:if test="${loggedin == true}">
                <li class="nav-item">
                    <a class="nav-link" href="/logout">logout</a>
                </li>
            </c:if>
            <c:if test="${loggedin == false}">
                <li class="nav-item">
                    <a class="nav-link" href="/login">Login</a>
                </li>
                <li  class="nav-item">
                    <a class="nav-link " href="/register">register</a>
                </li>
            </c:if>
            <li class="nav-item">
                <a class="nav-link " href="/ads/create">create post</a>
            </li>
            <c:if test="${loggedin == true && location == \"ads\"}">
                <li class="nav-item">
                    <a class="nav-link" href="/profile">Profile</a>
                </li>
            </c:if>
            <c:if test="${location == \"login\"}">
                <li class="nav-item">
                    <a class="nav-link" href="/ads">See Ads</a>
                </li>

            </c:if>
            <c:if test="${location == \"profile\"}">
                <li class="nav-item">
                    <a class="nav-link" href="/ads">See Ads</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/profile/edit">Edit Profile</a>
                </li>
            </c:if>
            <c:if test="${location == \"edit\"}">
                <li class="nav-item">
                    <a class="nav-link" href="/ads">See Ads</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/profile">View Profile</a>
                </li>
            </c:if>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="/search" method="POST">
            <label for="input"></label>
            <input class="form-control w-2" type="search" placeholder="Search" id="input" name="input">
            <button class="btn btn-outline-success my-2 my-sm-0 ml-4 text-center" type="submit">Search</button>
        </form>
    </div>
</nav>



<%--*******--%>
<%--<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">--%>
    <%--<a class="navbar-brand" href="/ads">Robert's List</a>--%>
    <%--<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">--%>
        <%--<span class="navbar-toggler-icon"></span>--%>
    <%--</button>--%>

    <%--<div class="collapse navbar-collapse" id="navbarTogglerDemo03">--%>
        <%--<ul class="navbar-nav mr-auto mt-2 mt-lg-0">--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="/login">Profile login<span class="sr-only">(current)</span></a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="/logout">logout</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link " href="/register">register</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link " href="/ads/create">create post</a>--%>
            <%--</li>--%>

        <%--</ul>--%>
        <%--<form class="form-inline my-2 my-lg-0" action="/search" method="POST">--%>
            <%--<label for="input"></label>--%>
            <%--<input class="form-control w-2" type="search" placeholder="Search" id="input" name="input">--%>
            <%--<button class="btn btn-outline-success my-2 my-sm-0 ml-4 text-center" type="submit">Search</button>--%>
        <%--</form>--%>
    <%--</div>--%>
<%--</nav>--%>




