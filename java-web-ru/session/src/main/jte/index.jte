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
                <a class="btn btn-primary mt-3" href="${NamedRoutes.buildSessionPath()}">Войти</a>
            </div>
        @endif
    </div>
`)