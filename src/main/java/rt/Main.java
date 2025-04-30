package rt;

import rt.nlp.NLPClassifier;
import rt.nlp.NLPModelFinder;
import rt.nlp.NLPTrainer;
import rt.utils.FileIO;
import rt.utils.RussianLanguageTokenizer;
import rt.utils.WordsCounter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

//        FileIO.prepareFileForTokenization("chron.txt");
//        NLPTrainer trainer = new NLPTrainer();
//        trainer.train("экономика");
//        String text = "Президент США Дональд Трамп 2 апреля подписал указ о введении \"взаимных\" пошлин на импорт из других стран. Их базовая ставка составляет 10%, а для 57 стран с 9 апреля заработали повышенные ставки, которые были рассчитаны исходя из торгового дефицита Штатов с конкретной страной: чтобы вместо дефицита был баланс. Однако уже 9 апреля американский лидер объявил, что более 75 стран не приняли ответных мер и запросили переговоры, поэтому на 90 дней для всех, кроме Китая, будут действовать базовые импортные пошлины в 10%.";
//        String[] tokenizedText = RussianLanguageTokenizer.tokenize(text);
//        NLPModelFinder modelFinder = new NLPModelFinder();
//        modelFinder.findModels();
//        NLPClassifier classifier = new NLPClassifier();
//        classifier.setModels(modelFinder.getModels());
//        List<String> result = classifier.classify(tokenizedText);
//        System.out.println(result);
    }
}
