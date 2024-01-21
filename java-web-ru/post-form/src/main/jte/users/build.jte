

@template.layout.page(content = @`
    <div class="container">

            <form class="form-control" action="/users" method="post">
                <div class="row mb-3">
                        <div class="col-6">
                        <label>
                            Имя пользователя
                            <input type="text" name="firstName" placeholder="Имя">
                        </label>
                        </div>
                        <div class="col-6">
                        <label>
                             Фамилия пользователя
                            <input type="text" required name="lastName" placeholder="Фамилия">
                        </label>
                        </div>
                </div>
                <div class="row mb-3">
                    <div class="col-6">
                        <label>
                            Адрес электронной почты
                            <input type="email" required name="email" placeholder="E-mail">
                        </label>
                    </div>
                    <div class="col-6">
                        <label>
                            Пароль
                            <input type="password" required name="password" placeholder="Пароль">
                        </label>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col">
                        <button type="submit" class="btn btn-primary">Зарегестрироваться</button>
                    </div>
                </div>
            </form>
    </div>
`)