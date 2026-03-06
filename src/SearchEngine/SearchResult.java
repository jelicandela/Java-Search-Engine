package SearchEngine;

public class SearchResult {
	private String title;
	private String url;

	public SearchResult(String title, String url) {
		this.title = title;
		this.url = url;
	}
	public SearchResult() {}

	public Bookmark createBookmark(String userNote) {
		System.out.println("SearchResult: Converting [" + title + "] to bookmark...");
		return new Bookmark(this.url, userNote);
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "[" + title + "] (" + url + ")";
	}
}