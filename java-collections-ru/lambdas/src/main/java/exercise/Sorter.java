package exercise;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> people) {
        List result = people.stream()
                .filter(p -> p.get("gender").equals("male"))
                .sorted((u1, u2) -> u1.get("birthday").compareTo(u2.get("birthday")))
                .map(u -> u.get("name"))
                .collect(Collectors.toList());
        return result;
    }
}
// END
