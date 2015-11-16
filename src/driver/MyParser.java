package driver;
// **********************************************************
// Assignment3:
// UTORID user_name: vieirad7
//
// Author: Vitor D. V. Queiroz
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// *********************************************************
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

import extractFunctions.AuthorName;
import extractFunctions.CitationNumber;
import extractFunctions.CoAuthors;
import extractFunctions.IndexNumber;
import extractFunctions.Publications;
import extractFunctions.TotalCitations;

public class MyParser {

  /**
   * @param args
   */
  public static void main(String[] args) {
    StarterCode(args);
  }
  
  private static void StarterCode(String[] args) {
    try {
      System.out.println("URLS are " + args[0] + "\n");      
    } catch (Exception e) {
      System.out.println("Did you change the run configuration in"
          + "Ec1lipse for argument0 and argument 1?");
    }
    
    
    String inputFiles[] = args[0].split(",");
    
   for (String inputFile : inputFiles) {	 
	  //Calling each extract function static method 
	  //on a previous provided argument. (sample1.html,sample2.html)
      AuthorName.extract(inputFile);
      CitationNumber.extract(inputFile);
      IndexNumber.extract(inputFile);
      Publications.extract(inputFile);
      TotalCitations.extract(inputFile);
      CoAuthors.extract(inputFile);
      CoAuthors.list(inputFile);
      System.out.println("\n");
    } 
   	  //Print CoAuthors after it has added both co-authors from both arguments.
   	  CoAuthors.print();
    
  }  
  

    public String getHTML(String urlString) throws Exception {
	    // create object to store html source text as it is being collected
	    StringBuilder html = new StringBuilder();
	    // open connection to given url
	    URL url = new File(urlString).toURI().toURL();
	    // create BufferedReader to buffer the given url's HTML source
	    BufferedReader htmlbr =
	        new BufferedReader(new InputStreamReader(url.openStream()));
	    String line;
	    // read each line of HTML code and store in StringBuilder
	    while ((line = htmlbr.readLine()) != null) {
	      html.append(line);
	    }
	    htmlbr.close();
	    // convert StringBuilder into a String and return it
	    return html.toString();
	  }
}