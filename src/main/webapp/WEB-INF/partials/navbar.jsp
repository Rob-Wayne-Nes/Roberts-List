<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
    <div class="container-fluid">

        <a class="navbar-brand" href="/ads">List All Ads</a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
                aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0 suggestionsBox" id="suggestions">
                <c:if test="${loggedin == true}">
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">logout</a>
                    </li>
                </c:if>
                <c:if test="${loggedin == false}">
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                    <li class="nav-item">
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
                <c:if test="${location == \"profile\"}">
                    <li class="nav-item">
                        <a class="nav-link" href="/ads">See Ads</a>
                    </li>
                </c:if>
                <li class="u" id="autoSuggestionsList"></li>

            </ul>

            <c:if test="${location == \"ads\"}">
                <form class="form-inline my-2 my-lg-0">
                    <input id="inputString" class="form-control mr-sm-2" type="text" placeholder="Search Ads"
                           aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </c:if>


        </div>
    </div><!-- /.container-fluid -->
    <script>
        var inputString = document.querySelector("#inputString");
        inputString.addEventListener('keyup', lookup);

        function lookup(e) {
            e.preventDefault();
            var search = inputString.value;
            var html = '';
            <c:forEach var="ad" items="${ads}">
            var title = "${ad.title}";
            if (title.toLowerCase().includes(search)) {
                $('#suggestions').show();
                html += "<li><a href=\"http://localhost:8080/ads/page?id=${ad.id}\">" + title + "</a></li>";
            }
            </c:forEach>
            $('#autoSuggestionsList').html(html);
        }

        function fill(thisValue) {
            $('#inputString').val(thisValue);
        }
    </script>
</nav>



