package rt.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import rt.utils.FileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JSONExtractor {

    public static void extractFromJSON(String filePath, String extFileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            ObjectMapper objectMapper = new ObjectMapper();
            List<String> extractedData = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                try {
                    JsonNode jsonNode = objectMapper.readTree(line);

                    String lang = jsonNode.get("lang").asText();
                    String label = jsonNode.get("label").asText();
                    String text = jsonNode.get("text").asText();
                    text = text.replaceAll("\\s+", " ");
                    extractedData.add(lang + " " + label + " " + text + System.lineSeparator());
//
//                    String label = jsonNode.get("label_text").asText();
//                    String text = jsonNode.get("text").asText();
//                    text = text.replaceAll("\\s+", " ");
//                    extractedData.add(label + " " + text + System.lineSeparator());

//                    String title = jsonNode.get("title").asText();
//                    String categories = jsonNode.get("categories").asText();
//                    String text = jsonNode.get("text").asText();
//                    extractedData.add(title + " " + categories + " " + text + System.lineSeparator());

                } catch (IOException e) {
                    System.err.println("Ошибка при обработке строки JSON: " + line);
                    e.printStackTrace(); // Выводим stack trace для отладки
                } catch (NullPointerException e) {
                    System.err.println("Поле не найдено в JSON: " + line);
                    e.printStackTrace();
                }
            }
            extractedData.sort(Comparator.naturalOrder());
            extractedData.forEach(l -> {
                try {
                    FileIO.writeTextToFile(l, extFileName);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
