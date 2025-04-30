package rt.nlp;

import opennlp.tools.doccat.DocumentCategorizerME;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NLPClassifier {

    private Map<String, DocumentCategorizerME> models;

    public void setModels(Map<String, DocumentCategorizerME> models) {
        this.models = models;
    }

    /**
     * Метод оценивает вероятность соответствия текста определённой категории от 0 до 100%.
     * @param tokens токенизированный текст для анализа
     * @return HashMap категория-вероятность
     */
    public Map<String, Double> classify(String[] tokens) {
        Map<String, Double> result = new HashMap<>();

        for (Map.Entry<String, DocumentCategorizerME> entry : models.entrySet()) {
            String label = entry.getKey();
            DocumentCategorizerME categorizer = entry.getValue();
            double[] probabilities = categorizer.categorize(tokens);
            int labelIndex = categorizer.getIndex(label);
            double labelProbability = probabilities[labelIndex];
            result.put(label, labelProbability * 100);
        }
        return result;
    }
}