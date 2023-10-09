package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
    }

    public static void swapKeyValue(KeyValueStorage map) {
        Map<String, String> swapped = map.toMap().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        map.setMap(swapped);
    }
}
// END
