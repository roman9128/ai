package rt.nlp;

import opennlp.tools.doccat.*;
import opennlp.tools.util.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

class NLPTrainer {

    void train(String label) throws IOException {

        File trainingDataFile = new File("nlp/training/" + label + ".txt");
        InputStreamFactory inputStreamFactory = new MarkableFileInputStreamFactory(trainingDataFile);
        ObjectStream<String> lineStream = new PlainTextByLineStream(inputStreamFactory, StandardCharsets.UTF_8);
        ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);

        TrainingParameters params = TrainingParameters.defaultParams();
        params.put(TrainingParameters.ITERATIONS_PARAM, 400);
        params.put(TrainingParameters.CUTOFF_PARAM, 2);
        params.put(TrainingParameters.ALGORITHM_PARAM, "MAXENT");
        DoccatModel model = DocumentCategorizerME.train("ru", sampleStream, params, new DoccatFactory());

        model.serialize(new File("nlp/models/" + label + ".model"));
    }
}