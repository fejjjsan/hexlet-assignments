@import exercise.dto.users.UsersPage

@param UsersPage page


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width">
    <title>Document</title>
</head>
    <body>
      <div>
         <table>
             <thead>
                <tr>
                    <th>ID</th>
                    <th>FIRST_NAME</th>
                    <th>LAST_NAME</th>
                    <th>E-MAIL</th>
                </tr>
             </thead>
             <tbody>
                @if(page.getUsers().isEmpty())
                    <tr>
                        <td>в базе нет пользователей</td>
                        <td>---</td>
                        <td>---</td>
                        <td>---</td>
                    </tr>
                @else
                    @for(var course : page.getUsers())
                        <tr>
                            <td>${course.getId()}</td>
                            <td>${course.getFirstName()}</td>
                            <td>${course.getLastName()}</td>
                            <td>${course.getEmail()}</td>
                        </tr>
                    @endfor
             @endif
             </tbody>
         </table>
      </div>
    </body>
</html>