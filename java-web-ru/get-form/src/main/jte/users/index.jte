@import exercise.dto.users.UsersPage

@param UsersPage page


@template.layout.page(content = @`
    <div class="container">
        <form action="/users" method="get" class="form-control">
            <input type="search" required name="term" value="${page.getTerm()}" placeholder="">
            <input type="submit" value="Search">
        </form>
    </div>
    @if(page.getTerm() == null)
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <table class="table justify-content-center table-borderless">
                        <thead>
                        <tr>
                            <th>Users</th>
                        </tr>
                        </thead>
                        <tbody>
                        @if(page.getUsers().isEmpty())
                            <tr>
                                <td>в базе нет пользователей</td>
                            </tr>
                        @else
                            @for(var user : page.getUsers())
                                <tr>
                                    <td>${user.getFirstName()} ${user.getLastName()}</td>
                                </tr>
                            @endfor
                        @endif
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    @else
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <table class="table justify-content-center table-borderless">
                        <thead>
                        <tr>
                            <th>Users</th>
                        </tr>
                        </thead>
                        <tbody>
                        @if(page.getUsers().isEmpty())
                            <tr>
                                <td>в базе нет пользователей с таким именем</td>
                            </tr>
                        @else
                            @for(var user : page.getUsers())
                                <tr>
                                    <td>${user.getFirstName()} ${user.getLastName()}</td>
                                </tr>
                            @endfor
                        @endif
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    @endif
`)
