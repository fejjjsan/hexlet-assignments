@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes

@param PostsPage page

@template.layout.page(content = @`
    <div class="container text-center">
        @if(page != null && page.getFlash() != null)
            <div class="alert alert-primary" role="alert">${page.getFlash()}</div>
        @endif
        <ul class="list-group">
            @if (page.getPosts().isEmpty())
                <p>пока не добавленно ни одного поста</p>
            @else
                @for(var post : page.getPosts())
                    <li class="list-group-item">
                        <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                    </li>
                @endfor
            @endif
        </ul>
    </div>
`)
