import java.io.*;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.util.AttributeFactory;

public class LuceneMain {
	public static void main(String[] args) throws IOException{
		String read = "input2.txt";
		String write = "output2.txt";
		String inputfile;
		String outputfile;
		FileInputStream inputStream = new FileInputStream(read);
		try{
			inputfile = IOUtils.toString(inputStream);
		}finally {
			inputStream.close();
		}
		
		System.out.println(removeStopWords(inputfile));
		
		FileOutputStream outputStream = new FileOutputStream(write);
		try{
			IOUtils.write(removeStopWords(inputfile), outputStream);
		}finally{
			outputStream.close();
		}
	}
	private static String removeStopWords(String file) throws IOException{
		//Analyzer analyzer = new StandardAnalyzer();
		EnglishAnalyzer ea = new EnglishAnalyzer();
				
		//add stopwords to standard stop set
		/**
		CharArraySet stopWords = CharArraySet.copy(StandardAnalyzer.STOP_WORDS_SET);
		stopWords.add("\n");
		**/
		
		
		List<String> words = Arrays.asList();
		CharArraySet stopWords = new CharArraySet(words, true);
		
		TokenStream tokenStream = ea.tokenStream("file", new StringReader(file));
	    tokenStream = new StopFilter(tokenStream, stopWords);
	    StringBuilder sb = new StringBuilder();
	    CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
	    tokenStream.reset();
	    while (tokenStream.incrementToken()) {
	        String term = charTermAttribute.toString();
	        sb.append(term + " ");
	    }
	    return sb.toString();
		
	}
}


