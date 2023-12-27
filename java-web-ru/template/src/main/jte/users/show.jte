@import exercise.dto.users.UserPage

@param UserPage page


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
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
            <tr>
                <td>${page.getUser().getId()}</td>
                <td>${page.getUser().getFirstName()}</td>
                <td>${page.getUser().getLastName()}</td>
                <td>${page.getUser().getEmail()}</td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>