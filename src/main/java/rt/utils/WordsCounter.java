package rt.utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordsCounter {

    private HashMap<String, Integer> wordsMap = new HashMap<>();

    public WordsCounter(String[] wordsArr) {
        for (String word : wordsArr) {
            count(word);
        }
    }

    private void count(String word) {
        if (wordsMap.containsKey(word)) {
            wordsMap.put(word, wordsMap.get(word) + 1);
        } else {
            wordsMap.put(word, 1);
        }
    }

    public String getResult() {
        Map<String, Integer> sortedMap = wordsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
