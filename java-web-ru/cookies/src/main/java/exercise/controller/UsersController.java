package exercise.controller;

import com.fasterxml.jackson.databind.util.Named;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import java.util.Collections;
import exercise.repository.UserRepository;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        var firstName = ctx.formParamAsClass("firstName", String.class).get();
        var lastName = ctx.formParamAsClass("lastName", String.class).get();
        var email = ctx.formParamAsClass("email", String.class).get();
        var password = ctx.formParamAsClass("password", String.class).get();

        var token = Security.generateToken();

        var user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);

        ctx.redirect(NamedRoutes.userPath(user.getId()));
//        ctx.render("users/show.jte", Collections.singletonMap("user", user));
        ctx.cookie("token", token);
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var token = ctx.cookie("token");
//        var token = ctx.queryParamAsClass("token", String.class).get();

        var user = UserRepository.find(id).orElseThrow(NotFoundResponse::new);

        if (user.getToken().equals(token)) {
            ctx.render("users/show.jte", Collections.singletonMap("user", user));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }

    // END
}
