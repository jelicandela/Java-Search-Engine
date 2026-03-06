package SearchEngine;

public class SearchQuery {
    private String searchString;
    private SynonymTracker synonymTracker;

    public SearchQuery(String searchString) {
        this.searchString = searchString;
        this.synonymTracker = new SynonymTracker(); 
    }

    public void execute() {
        System.out.println("\nExecuting Search for: " + searchString);
        
        synonymTracker.findSynonyms(searchString);

        ResultList results = Index.getInstance().search(searchString);

        RelevanceChecker checker = new RelevanceChecker();
        checker.sort(results);

        System.out.println("--- Results ---");
        for (SearchResult r : results) {
            System.out.println(r);
        }
    }
    
    @Override
    public String toString() {
        return "Query: " + searchString;
    }
}