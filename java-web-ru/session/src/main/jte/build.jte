@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(content = @`
    <form class="container mt-3" action="${NamedRoutes.loginPath()}" method="post">
        @if(page.getError() != null)
                <p1>Wrong username or password</p1>
        @endif
        <div class="form-group mt-3">
            <label for="username" class="mb-1">Username</label>
            <input type="text" name="name" class="form-control" id="username" placeholder="Enter username">
        </div>
        <div class="form-group mt-3">
            <label for="password" class="mb-1">Password</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="Enter password">
        </div>
        <button type="submit" class="btn btn-primary mt-3">Login</button>
    </form>
`)
