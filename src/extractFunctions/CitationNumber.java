package extractFunctions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import driver.MyParser;

public class CitationNumber extends MyParser {
	
	public static void extract(String googleScholarURL) {
		  
	    try {
	      // Instantiates a MyParser object and then reads a HTML file passed
	      // as an argument. Gets a string representations of it.
	      MyParser googleScholarParser = new MyParser();
	      String rawHTMLString = googleScholarParser.getHTML(googleScholarURL);
	      
	      // Below we write a regex to match the information we want to get
	       // from the html file.
	      String reForCitationsExtraction = "<td class=\"cit-bord"
	      		+ "erleft cit-data\">(.*?)</td>";	   	      
	      Pattern patternObject = Pattern.compile(reForCitationsExtraction);
	      Matcher matcherObject = patternObject.matcher(rawHTMLString);	
	      
	   // While the matcher find method is true 
	        // it prints the match.	    
        while (matcherObject.find()) {
	        System.out.println("Number of all "
	        		+ "Citations is " + matcherObject.group(1));
	        break; // To prevent getting the other citation# 
	        		 // "Since" as they are in a tag named 
	        		// the same as "all citations".
	      } 

	    } catch (Exception e) {
	      System.out.println("malformed URL or cannot open connection to "
          + "given URL");
	    }
	  }

}
