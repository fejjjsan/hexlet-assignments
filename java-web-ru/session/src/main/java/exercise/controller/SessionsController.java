package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        var page = new LoginPage();
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void index(Context ctx) {
        if (ctx.sessionAttribute("currentUser") == null) {
            var page = new MainPage(ctx.sessionAttribute("currentUser"));
            System.out.println(page.getName());
            ctx.render("index.jte", Collections.singletonMap("page", page));
        } else if (ctx.sessionAttribute("currentUser") != null) {
            var page = new MainPage(ctx.sessionAttribute("currentUser"));
            System.out.println(page.getName());
            ctx.render("index.jte", Collections.singletonMap("page", page));
        }
    }

    public static void login(Context ctx) {
        var userName = ctx.formParam("name");

        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(UsersRepository::existsByName, "Wrong username.")
                    .get();
            var rightPassword = UsersRepository.findByName(name).getPassword();
            var password = ctx.formParamAsClass("password", String.class)
                    .check(p -> Security.encrypt(p).equals(rightPassword), "Wrong password.")
                    .get();
            ctx.sessionAttribute("currentUser", String.valueOf(userName));
            ctx.redirect(NamedRoutes.rootPath());

        } catch (ValidationException e) {
            var page = new LoginPage(userName, "Wrong username or password.");
            ctx.render("build.jte", Collections.singletonMap("page", page)).status(422);
        }

    }
    public static void logout(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.status(302).redirect(NamedRoutes.rootPath());
    }



    // END
}
