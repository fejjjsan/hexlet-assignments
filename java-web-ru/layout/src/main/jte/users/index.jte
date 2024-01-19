@import exercise.dto.users.UsersPage
@param UsersPage page


@template.layout.page(content = @`
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
                                <td><a href="users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></td>
                            </tr>
                        @endfor
                    @endif
                    </tbody>
                </table>
            </div>
        </div>
    </div>
`)
