package rt;

import rt.nlp.NLPService;

import java.io.IOException;
import java.util.Map;

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
    }
}

/**
 * 'climate': 0,
 * 'culture': 2,
 * 'economy': 3,
 * 'gloss': 4,
 * 'health': 5,
 * 'science': 7,
 * 'society': 8,
 * 'sports': 9,
 * 'travel': 10
 */