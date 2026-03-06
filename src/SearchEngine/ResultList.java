package SearchEngine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResultList implements Iterable<SearchResult> {
    // internal storage is encapsulated
    private List<SearchResult> results;

    public ResultList() {
        this.results = new ArrayList<>();
    }

    public void addResult(SearchResult result) {
        this.results.add(result);
    }

    public List<SearchResult> getResults() {
        return results;
    }
    
    @Override
    public Iterator<SearchResult> iterator() {
        return new ResultIterator(this.results);
    }

    private class ResultIterator implements Iterator<SearchResult> {
        private List<SearchResult> list;
        private int position = 0;

        public ResultIterator(List<SearchResult> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return position < list.size();
        }

        @Override
        public SearchResult next() {
            if (hasNext()) {
                SearchResult item = list.get(position);
                position++;
                return item;
            }
            return null;
        }
    }
}
