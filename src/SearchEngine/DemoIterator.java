package SearchEngine;

import java.util.Iterator;

public class DemoIterator {

    public static void main(String[] args) {
        
        // 'ResultList' is custom collection
    	// The user doesn't need to know that it uses an ArrayList internally
        ResultList resultList = new ResultList();

        resultList.addResult(new SearchResult("HAW Hamburg", "www.haw-hamburg.de"));
        resultList.addResult(new SearchResult("Google", "www.google.com"));
        resultList.addResult(new SearchResult("YouTube", "www.youtube.com"));
        resultList.addResult(new SearchResult("Wikipedia", "www.wikipedia.org"));

        System.out.println("--- Iterator Pattern Demo ---");
        
        // Asking the collection for an iterator
        // so we don't need to write a 'for (int i=0; i < size; i++)' loop
        Iterator<SearchResult> iterator = resultList.iterator();

        String searchContext = "Hamburg";
        
        // hasNext() checks if there is another item
        while (iterator.hasNext()) {
            
            // next() returns the current item and moves the cursor forward
            SearchResult current = iterator.next();
            
            // Checking relevance
            if (current.getTitle().contains(searchContext)) {
                System.out.println(" [MATCH]  " + current.getTitle() + " is relevant.");
            } else {
                System.out.println(" [IGNORE] " + current.getTitle() + " does not match.");
            }
        }
        
        System.out.println("--- End of List ---");
    }
}