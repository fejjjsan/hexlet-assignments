package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        List<Character> symbolsList = strToCharArrList(symbols);
        List<Character> wordList = strToCharArrList(word);

        boolean result = false;

      for (Character symbol : wordList) {
          if (symbolsList.contains(symbol)) {
                result = true;
                symbolsList.remove(symbolsList.indexOf(symbol));
          } else {
               result = false;
               break;
          }
      }
      return result;
    }

    public static ArrayList<Character> strToCharArrList(String str) {
        ArrayList<Character> charList = new ArrayList<>();
        char[] chars = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            charList.add(Character.toLowerCase(chars[i])); // ?
        }
        return charList;
    }
}
//END
