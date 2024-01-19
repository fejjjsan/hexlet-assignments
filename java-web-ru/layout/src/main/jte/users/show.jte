@import exercise.dto.users.UserPage
@param UserPage page


@template.layout.page(
content = @`
    <div class="container">
        <table class="table table-borderless">
            <thead>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>E-MAIL</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${page.getUser().getId()}</td>
                <td>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</td>
                <td>${page.getUser().getEmail()}</td>
            </tr>
            </tbody>
        </table>
    </div>

`
)
