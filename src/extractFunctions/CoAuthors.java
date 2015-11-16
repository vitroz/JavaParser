package extractFunctions;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import driver.MyParser;

public class CoAuthors extends MyParser {
	
	static SortedSet<String> CoAuthors = new TreeSet<String>();
	
	public static void extract(String googleScholarURL) {
		  
	    try {
	    	// Instantiates a MyParser object and then reads a HTML file passed
		      // as an argument. Gets a string representations of it.
	      MyParser googleScholarParser = new MyParser();
	      String rawHTMLString = googleScholarParser.getHTML(googleScholarURL);
	      //counter for the number of co-authors initialized.
	      int coAuthorCount = 0;
	      
	      // Below we write a regex to match the information we want to get
	       // from the html file.
	      String reForCoAuthorExtraction = "<a class=\"cit-dark-link\" "
	      		+ "href=\"(.*?)\" title=\"(.*?)\">(.*?)</a>";
	
	    
	      Pattern patternObject = Pattern.compile(reForCoAuthorExtraction);
	      Matcher matcherObject = patternObject.matcher(rawHTMLString);	  
	      
	      // While the matcher find method is true 
	      // it increments the counter.	         
	      while(matcherObject.find()) {  
	    	  if(matcherObject.group(3).equals("Citations")){
	    		  break;
	    	  }
	    	  coAuthorCount ++;	            
	      } 
	      System.out.println("Number of Co-Authors : "
	        		+ " : " + coAuthorCount);	    

	    } catch (Exception e) {
	      System.out.println("malformed URL or cannot open connection to "
      + "given URL");
	    }
	  }
	
	public static void list(String googleScholarURL){
		
		 try {
		   MyParser googleScholarParser = new MyParser();
		   String rawHTMLString = googleScholarParser.getHTML(googleScholarURL);
		   
		      

		      String reForCoAuthorExtraction = "<a class=\"cit-dark-link\" "
		      		+ "href=\"(.*?)\" title=\"(.*?)\">(.*?)</a>";
		
		    
		      Pattern patternObject = Pattern.compile(reForCoAuthorExtraction);
		      Matcher matcherObject = patternObject.matcher(rawHTMLString);	  
		      
		      // While the matcher find method is true 
		      // it adds the match to the set.	       
		      while(matcherObject.find()) {  
		    	  if(matcherObject.group(3).equals("Citations")){
		    		  break;
		    	  }
		    	  CoAuthors.add(matcherObject.group(3));		    	             
		      } 		      
		       

		    } catch (Exception e) {
		      System.out.println("malformed URL or cannot open connection to "
	      + "given URL");
		    }
		
	}
	
	public static void print(){
		System.out.println("Co-Author list sorted (Total: " 
				+ CoAuthors.size()+")");
		for(String coauthor : CoAuthors){
			System.out.println(coauthor);
		}
	}
}
