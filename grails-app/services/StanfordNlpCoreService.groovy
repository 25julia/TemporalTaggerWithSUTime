import edu.stanford.nlp.ling.CoreAnnotations
import edu.stanford.nlp.pipeline.*
import edu.stanford.nlp.time.TimeAnnotations
import edu.stanford.nlp.time.TimeAnnotator
import edu.stanford.nlp.time.TimeExpression
import edu.stanford.nlp.util.CoreMap

import java.text.SimpleDateFormat

class StanfordNlpCoreService {

    def temporalResolutionWithSuTime(String text) {
        Properties props = new Properties();
        AnnotationPipeline pipeline = new AnnotationPipeline();
        pipeline.addAnnotator(new TokenizerAnnotator(false));
        pipeline.addAnnotator(new WordsToSentencesAnnotator(false));
        pipeline.addAnnotator(new POSTaggerAnnotator(false));
        pipeline.addAnnotator(new TimeAnnotator("sutime", props));

        Annotation annotation = new Annotation(text);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = df.format(new Date());
        annotation.set(CoreAnnotations.DocDateAnnotation.class, currentDate);
        pipeline.annotate(annotation);
        System.out.println(annotation.get(CoreAnnotations.TextAnnotation.class));
        List<CoreMap> timexAnnsAll = annotation.get(TimeAnnotations.TimexAnnotations.class);
        def parsedDate;
        for (CoreMap cm : timexAnnsAll) {
            println(" --> " + cm.get(TimeExpression.Annotation.class).getTemporal())
            parsedDate = cm.get(TimeExpression.Annotation.class).getTemporal()
        }
        if (parsedDate == null) {
            parsedDate = annotation.get(CoreAnnotations.TextAnnotation.class)
        }
        return parsedDate

    }
}
