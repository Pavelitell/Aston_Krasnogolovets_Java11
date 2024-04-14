import java.util.LinkedHashMap;
import java.util.Map;

public class CountUniqueWords {
    public static void countUnique(String[] words) {
        Map<String, Integer> numberOfWords = new LinkedHashMap<>();
        for (String word : words) {
            countWord(numberOfWords, word);
        }
        for (String word : numberOfWords.keySet()) {
            System.out.println(word + " : " + numberOfWords.get(word) + ".");
        }
    }

    public static void countWord(Map<String, Integer> numberOfWords, String word) {
        if (numberOfWords.containsKey(word)) {
            numberOfWords.put(word, numberOfWords.get(word) + 1);
        } else {
            numberOfWords.put(word, 1);
        }
    }
}
