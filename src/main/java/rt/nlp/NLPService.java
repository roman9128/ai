package rt.nlp;

import rt.utils.RussianLanguageTokenizer;

import java.io.IOException;
import java.util.Map;

public class NLPService {
    private final NLPClassifier classifier = new NLPClassifier();

    public NLPService() throws IOException {
        NLPModelFinder modelFinder = new NLPModelFinder();
        modelFinder.findModels();
        classifier.setModels(modelFinder.getModels());
    }

    public Map<String, Double> classify(String text) {
        String[] tokenizedText = RussianLanguageTokenizer.tokenize(text);
        return classifier.classify(tokenizedText);
    }
}
