package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String str) {
        String[] words = str.split(" ");
        Map<String, Integer> wordbook = new HashMap<>(); 

        for (String word : words) { // тут нужно добавить что если стринг пустой ничего добавлять не нужно.
            if (wordbook.containsKey(word)) {
               int value =  wordbook.get(word);
               wordbook.put(word, value + 1);
            } else if (word.length() != 0) {
                int value = 1;
                wordbook.put(word, value);
            }
        }
        return wordbook;
    }

    public static String toString(Map<String, Integer> map) {

        StringBuilder str = new StringBuilder();
        str.append("{\n");
        if (map.isEmpty()) {
            return "{}";
        } else {
            for (String key: map.keySet()) {
                str.append("  ");
                str.append(key);
                str.append(": ");
                str.append(map.get(key));
                str.append("\n");
            }
            str.append("}");
        }
        return str.toString();
    }
}

//END
