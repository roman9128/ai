package rt;

import rt.nlp.NLPService;
import rt.nlp.NLPTrainer;
import rt.utils.FileIO;
import rt.utils.RussianLanguageTokenizer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

//        FileIO.prepareFile("juris.txt", System.lineSeparator());
//        NLPTrainer trainer = new NLPTrainer();
//        trainer.train("право");
        String text1 = "В середине мая экономколлегии предстоит рассмотреть спор, в котором столкнулись три вида исключительной подсудности: групповые иски, споры с депозитариями и санкционные разбирательства. Дело о взыскании задолженности по еврооблигациям станет ключевым для формирования практики. Так, суду предстоит решить, имеют ли право физические лица — инвесторы обращаться в арбитражные суды, и определить границы применения антисанкционных процессуальных норм";
        String text2 = "С 2 мая расширится список видов деятельности, за которые могут признать иноагентом. Теперь статус иноагента будут получать за помощь, в том числе финансовую, при исполнении решений, которые направлены против безопасности России и приняты иностранными государственными органами или международными организациями, в которых не участвует Россия. Кроме того, иноагентом смогут признать за вовлечение других лиц в сбор данных, которые при их получении иностранными источниками могут поставить под угрозу безопасность страны";
        NLPService service = new NLPService();
        Map<String, Double> result1 = service.classify(text1);
        Map<String, Double> result2 = service.classify(text2);
        System.out.println(result1);
        System.out.println(result2);


//        String text = FileIO.readTextFromFile("jur.txt");
//        String[] lines = text.split(System.lineSeparator());

//        Random random = new Random();
//        int count = 2185;
//        String[] copy = lines.clone();
//        for (int i = copy.length - 1; i > 0; i--) {
//            int index = random.nextInt(i + 1);
//            String temp = copy[index];
//            copy[index] = copy[i];
//            copy[i] = temp;
//        }
//        String[] res = new String[count];
//        System.arraycopy(copy, 0, res, 0, count);
//        lines = Arrays.stream(res).sorted().toArray(String[]::new);
//        for (String string : lines) {
//            FileIO.writeTextToFile("1_" + string + System.lineSeparator(), "juris.txt");
//        }
    }
}

/**
 * categories_translator =
 * {'climate': 0,
 * 'conflicts': 1, done
 * 'culture': 2,
 * 'economy': 3,
 * 'gloss': 4,
 * 'health': 5,
 * 'politics': 6, done
 * 'science': 7,
 * 'society': 8,
 * 'sports': 9,
 * 'travel': 10}
 */