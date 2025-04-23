package rt.nlp;

import opennlp.tools.doccat.DocumentCategorizerME;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NLPClassifier {

    private Map<String, DocumentCategorizerME> models;

    public void setModels(Map<String, DocumentCategorizerME> models) {
        this.models = models;
    }

    public List<String> classify(String[] tokens) {
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, DocumentCategorizerME> entry : models.entrySet()) {
            String label = entry.getKey();
            DocumentCategorizerME categorizer = entry.getValue();
            double[] probabilities = categorizer.categorize(tokens);
            int labelIndex = categorizer.getIndex(label);
            double labelProbability = probabilities[labelIndex];
            System.out.println(String.join(" ", categorizer.getAllResults(probabilities)));

            if (labelProbability > 0.6) {
                result.add(label);
            }
        }
        return result;
    }
}