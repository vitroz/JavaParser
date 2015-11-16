package extractFunctions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import driver.MyParser;

public class TotalCitations extends MyParser {
	
	public static void extract(String googleScholarURL) {
		  
	    try {
	    	// Instantiates a MyParser object and then reads a HTML file passed
		      // as an argument. Gets a string representations of it.
	      MyParser googleScholarParser = new MyParser();
	      String rawHTMLString = googleScholarParser.getHTML(googleScholarURL);	 
	      int totalCitation = 0;

	   // Below we write a regex to match the information we want to get
	       // from the html file.
	      String reForCitationsExtraction = "<td id=\"col-citedby\"><a "
	      		+ "class=\"cit-dark-link\""
	      		+ " href=\"(.*?)\">(.*?)</a></td>";		      
	   
	      Pattern patternObject = Pattern.compile(reForCitationsExtraction);
	      Matcher matcherObject = patternObject.matcher(rawHTMLString);	     
	      // For the first five find method evaluates to true 
	        // it sums and then prints the total.	   
	      for(int i = 0;  i < 5; i++) {    
	    	matcherObject.find();
	    	String citationStr = matcherObject.group(2);	  
	    	int citationValue = Integer.parseInt(citationStr);
	    	totalCitation += citationValue;
	    	
	      } 
	      System.out.println("Total paper "
	      		+ "citations (first 5) : " + totalCitation);	

	    } catch (Exception e) {
	      System.out.println("malformed URL or cannot open connection to "
      + "given URL");
	    }
	  }


}
