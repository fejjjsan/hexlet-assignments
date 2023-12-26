package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static exercise.Data.getUsers;

public final class App {

    private static final List<Map<String, String>> USERS = getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);

            var result = new ArrayList<Map<String, String>>();
            var users = getUsers();

            for (int i = (page * per) - per; i < (page * per); i++) {
                var user = users.get(i);
                result.add(user);
            }
            ctx.json(result);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
