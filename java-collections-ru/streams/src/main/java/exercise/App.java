package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .map(s->s.split("@"))
                .map(s->s[1])
                .filter(s->s.equals("gmail.com") || s.equals("yandex.ru") || s.equals("hotmail.com"))
                .count();
    }
}
// END
