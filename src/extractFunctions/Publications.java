package extractFunctions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import driver.MyParser;

public class Publications extends MyParser {
	public static void extract(String googleScholarURL) {
		  
	    try {
	    	// Instantiates a MyParser object and then reads a HTML file passed
		      // as an argument. Gets a string representations of it.
	      MyParser googleScholarParser = new MyParser();
	      String rawHTMLString = googleScholarParser.getHTML(googleScholarURL);
	   // Below we write a regex to match the information we want to get
	       // from the html file.
	      String reForCitationsExtraction = "class=\""
	      		+ "cit-dark-large-link\">(.*?)<\\/a>";
	     
	      Pattern patternObject = Pattern.compile(reForCitationsExtraction);
	      Matcher matcherObject = patternObject.matcher(rawHTMLString);	     
	   // For the first three find method evaluates to true 
	        // it prints the match.	    
	      System.out.println("Title of the first 3 publications: ");
	      for(int i = 1;  i <= 3; i++) {    
	    	matcherObject.find();
	        System.out.println(" - " + i + " " + matcherObject.group(1));	        
	      } 

	    } catch (Exception e) {
	      System.out.println("malformed URL or cannot open connection to "
        + "given URL");
	    }
	  }

}
