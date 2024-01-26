@import exercise.dto.MainPage
@import exercise.util.NamedRoutes

@param MainPage page

@template.layout.page(content = @`

    <div class="container">
        @if(page.getName() != null)
            <div class="row">
                <p>${page.getName().toString()}</p>
                    <form action="${NamedRoutes.logoutPath()}" method="post">
                        <button type="submit" class="btn btn-primary">Выйти</button>
                    </form>
            </div>
        @else
            <div class="row">
                <form action="${NamedRoutes.buildSessionPath()}" method="get">
                    <button type="submit" class="btn btn-primary mt-3">Войти</button>
                </form>
            </div>
        @endif
    </div>
`)