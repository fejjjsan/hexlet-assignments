@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
    content = @`

    <div class="container">
        @if(page.getErrors() != null)
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        @endif
        <form action="/articles" method="post">
            <div class="form-group mb-3 mt-3">
                <label for="articleName" class="text-muted">Название статьи</label>
                <input type="text" required name="title" class="form-control" id="articleName"  value="${page.getTitle()}" placeholder="Название статьи">
            </div>
            <div class="form-group mb-3">
                <label for="articleText" class="text-muted">Название статьи</label>
                <textarea class="form-control" required name="content" id="articleText" placeholder="Тект статьи">${page.getContent()}"</textarea>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>
`
)