@import gg.jte.Content
@import exercise.util.NamedRoutes
@param Content content

<!-- BEGIN -->
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
            <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
            <span class="fs-4">HEADER</span>
        </a>

        <ul class="nav nav-pills">
            <li class="nav-item"><a href="${NamedRoutes.postsPath()}" class="nav-link active" aria-current="page">Posts</a></li>
            <li class="nav-item"><a href="${NamedRoutes.buildPostPath()}" class="nav-link active" aria-current="page">Create post</a></li>
        </ul>
    </header>
</div>
${content}
<footer class="py-3 my-4">
    <ul class="nav justify-content-center border-bottom pb-3 mb-3">
        <li class="nav-item"><a href="${NamedRoutes.postsPath()}" class="nav-link px-2 text-muted">Post</a></li>
        <li class="nav-item"><a href="${NamedRoutes.buildPostPath()}" class="nav-link px-2 text-muted">Create post</a></li>
    </ul>
    <p class="text-center text-muted">© 2023 JavaDeveloper, Inc</p>
</footer>
</body>
</html>
<!-- END -->
