package rt.utils;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordsLoader {

    public static Set<String> loadWordsSet(String fileName) {
        try {
            String[] stopWordsArr = FileIO.readTextFromFile(fileName).split("\\s+");
            return new HashSet<>(List.of(stopWordsArr));
        } catch (IOException e) {
            return new HashSet<>();
        }
    }
}
