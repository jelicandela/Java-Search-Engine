package SearchEngine;

import java.util.ArrayList;
import java.util.List;

public class SearchHistory {
    private List<SearchQuery> logs;

    public SearchHistory() {
        this.logs = new ArrayList<>();
    }

    public void add(SearchQuery query) {
        logs.add(query);
        System.out.println("SearchHistory: Query added to logs.");
    }
}