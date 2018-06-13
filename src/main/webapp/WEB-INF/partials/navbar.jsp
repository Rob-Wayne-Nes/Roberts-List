<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
    <a class="navbar-brand" href="/ads">Robert's List</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item ">
                <a class="nav-link" href="/login">Login <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">logout</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/register">register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/ads/create">create post</a>
            </li>

        </ul>
        <form class="form-inline my-2 my-lg-0" action="/search" method="post">
            <input class="form-control col-lg-6 col-sm-4" type="search" placeholder="Search" >
            <button class="btn btn-outline-success my-2 my-sm-0 ml-4" type="submit" name="searchTerm">Search</button>
        </form>
    </div>
</nav>
