package exercise;

import java.util.*;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> changes = new TreeSet<>(data1.keySet());
        changes.addAll(data2.keySet());

        LinkedHashMap<String, String> result = new LinkedHashMap<>();

        for (String elem : changes) {
            if (!data1.containsKey(elem)) {
                result.put(elem, "added");
            } else if (!data2.containsKey(elem)) {
                result.put(elem, "deleted");
            } else if (data1.containsValue(data2.get(elem))) {
                result.put(elem, "unchanged");
            } else if (!data1.containsValue(data2.get(elem))) {
                result.put(elem, "changed");
            }
        }
        return result;
    }
}
//END
