package rt;

import rt.nlp.NLPService;
import rt.nlp.NLPTrainer;
import rt.utils.FileIO;
import rt.utils.RussianLanguageTokenizer;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

//        FileIO.prepareFile("politic.txt", System.lineSeparator());
//        NLPTrainer trainer = new NLPTrainer();
//        trainer.train("политика");
        String text1 = "Назвать вероятного преемника главы Чечни Рамзана Кадырова на данный момент очень сложно — им может стать командир спецназа «Ахмат», замначальника главного военно-политического управления Минобороны России генерал-лейтенант Апти Алаудинов, сын Кадырова или кто-то третий, заявил в разговоре с «Лентой.ру» политолог Станислав Тарасов.";
        String text2 = "Бывший клавишник музыкальной группы «Ленинград» Дмитрий Иванов впал в кому. Об этом сообщается на его странице в социальной сети «ВКонтакте».\n" +
                "\n" +
                "По информации, опубликованной в посте, Иванов, сотрудничавший с Сергеем Шнуровым и певицей МакSим, в тяжелом состоянии. Сообщается, что у музыканта инсульт.";
        NLPService service = new NLPService();

        Map<String, Double> result1 = service.classify(text1);
        Map<String, Double> result2 = service.classify(text2);
        System.out.println(result1);
        System.out.println(result2);


//        String text1 = FileIO.readTextFromFile("not1.txt");
//        String[] lines1 = text1.split(System.lineSeparator());
//        for (int i = 0; i < lines1.length; i++) {
//            if (i % 2 == 0) {
//                FileIO.writeTextToFile(lines1[i] + System.lineSeparator(), "not2.txt");
//            }
//        }
//        String text = FileIO.readTextFromFile("politic.txt");
//        String[] lines = text.split(System.lineSeparator());
//        for (int i = 0; i < lines.length; i++) {
//            FileIO.writeTextToFile("xxxx" + lines[i] + System.lineSeparator(), "politic1.txt");
//        }

    }
}

/**
 * categories_translator =
 * {'climate': 0,
 * 'conflicts': 1,
 * 'culture': 2,
 * 'economy': 3,
 * 'gloss': 4,
 * 'health': 5,
 * 'politics': 6,
 * 'science': 7,
 * 'society': 8,
 * 'sports': 9,
 * 'travel': 10}
 */