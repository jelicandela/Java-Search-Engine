package SearchEngine;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RelevanceChecker {

    public RelevanceChecker() {
    }

    public void sort(ResultList resultList) {
        System.out.println("RelevanceChecker: Analyzing and sorting results...");

        List<SearchResult> rawList = resultList.getResults();

        // sorting the list in-place using a Custom Comparator
        Collections.sort(rawList, new Comparator<SearchResult>() {
            @Override
            public int compare(SearchResult r1, SearchResult r2) {
                // Comparing based on calculated scores
                // For this demo, we use String comparison of titles
                // (In a real engine, this would compare rank scores)
                return r1.getTitle().compareToIgnoreCase(r2.getTitle());
            }
        });
    }

    private double calculateScore(SearchResult result, String query) {
        // Placeholder logic: 
        // 10 points if title matches, 5 if URL matches
        double score = 0;
        if (result.getTitle().contains(query)) score += 10;
        if (result.getUrl().contains(query)) score += 5;
        return score;
    }
}