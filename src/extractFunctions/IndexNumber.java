package extractFunctions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import driver.MyParser;

public class IndexNumber extends MyParser {
	
	 public static void extract(String googleScholarURL) {

	  	  
		 try {
			// Instantiates a MyParser object and then reads a HTML file passed
		      // as an argument. Gets a string representations of it.
		   MyParser googleScholarParser = new MyParser();
		   String rawHTMLString = googleScholarParser.getHTML(googleScholarURL);
		
		   
		   // Below we write a regex to match the information we want to get
	       // from the html file.
		      String reForCitationsExtraction = "<td class=\"cit-"
		      		+ "borderleft cit-data\">(.*?)</td>";	   	      
		      Pattern patternObject = Pattern.compile(reForCitationsExtraction);
		      Matcher matcherObject = patternObject.matcher(rawHTMLString);	
		      // the for matches each time it 
		 		//finds a number in the table, the index after 2009
		 		 // appears at the eleventh position.
		      for(int i=0;i<=11;i++){ 
		    	  	if(matcherObject.find() == true){
		    	  		i++;
		    	  	}
		    	  	if(i==11){
		    	  		System.out.println("Number of i10 index after "
		    	  				+ "2009 is: " + matcherObject.group(1));		        	 
		    	  	}
		      }	  

	  } catch (Exception e) {
	    System.out.println("malformed URL or cannot open connection to "
	    + "given URL");
	  }
	}

}
