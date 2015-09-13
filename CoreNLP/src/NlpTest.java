import java.io.*;
import java.util.*;

import org.apache.commons.io.*;
import edu.stanford.nlp.dcoref.CorefChain;
import edu.stanford.nlp.dcoref.CorefCoreAnnotations;
import edu.stanford.nlp.io.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.util.*;

public class NlpTest {
	public static void main(String[] args) throws IOException{
		PrintWriter out;
	    if (args.length > 1) {
	      out = new PrintWriter(args[1]);
	    } else {
	      out = new PrintWriter(System.out);
	    }
	    PrintWriter xmlOut = null;
	    if (args.length > 2) {
	      xmlOut = new PrintWriter(args[2]);
	    }
	    String ext = FilenameUtils.getExtension("Stanford University is located in California. It is a great university, founded in 1891.");
	    System.out.println("Extension is " + ext);
	    System.out.println(ext.isEmpty());
	    /**
	    StanfordCoreNLP pipeline = new StanfordCoreNLP();

	    // Initialize an Annotation with some text to be annotated. The text is the argument to the constructor.
	    Annotation annotation;
	    if (args.length > 0) {
	      annotation = new Annotation(IOUtils.slurpFileNoExceptions("test.txt"));
	    } else {
	      annotation = new Annotation("Stanford University is located in California. It is a great university, founded in 1891.");
	    }

	    // run all the selected Annotators on this text
	    pipeline.annotate(annotation);

	    // print the results to file(s)
	    pipeline.prettyPrint(annotation, out);
	    if (xmlOut != null) {
	      pipeline.xmlPrint(annotation, xmlOut);
	    }*/
	}
}
