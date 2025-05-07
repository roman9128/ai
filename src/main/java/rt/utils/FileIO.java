package rt.utils;

import java.io.*;

public class FileIO {

    public static void prepareFile(String fileName, String separator) {
        try {
            String text = readTextFromFile(fileName);
            String[] textArr = text.split(separator);
            for (String s : textArr) {
                String[] tokens = RussianLanguageTokenizer.tokenize(s);
                writeTextToFile(String.join(" ", tokens) + System.lineSeparator(), "nlp/training/new_" + fileName);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeTextToFile(String text, String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(text);
        }
    }

    public static String readTextFromFile(String fileName) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }
            return builder.toString();
        }
    }
}