package rt.nlp;

import java.io.IOException;
import java.util.Map;

public class NLPService {
    private final NLPTrainer trainer = new NLPTrainer();
    private final NLPClassifier classifier = new NLPClassifier();

    public NLPService() {
        NLPModelFinder modelFinder = new NLPModelFinder();
        modelFinder.findModels();
        classifier.setModels(modelFinder.getModels());
    }

    public void train(String label){
        try {
            trainer.train(label);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Double> classify(String text) {
        String[] tokenizedText = RussianLanguageTokenizer.tokenize(text);
        return classifier.classify(tokenizedText);
    }
}
