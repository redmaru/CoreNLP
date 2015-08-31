import edu.stanford.nlp.dcoref.CorefChain;
import edu.stanford.nlp.dcoref.CorefCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;


import java.util.Iterator;
import java.util.Map;
import java.util.Properties;


public class testmain {

    public static void main(String[] args) {

        String text = "Viki is a smart boy. He knows a lot of things.";
        Annotation document = new Annotation(text);
        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        pipeline.annotate(document);


        Map<Integer, CorefChain> graph = document.get(CorefCoreAnnotations.CorefChainAnnotation.class);



        Iterator<Integer> itr = graph.keySet().iterator();

        while (itr.hasNext()) {

             String key = itr.next().toString();

             String value = graph.get(key).toString();

             System.out.println(key + " " + value);      
        }

   }
}