package SearchEngine;

public abstract class User {
	protected String sessionID;

	protected User() {
		this.sessionID = "unknown";
	}

	public User(String sessionID) {
		this.sessionID = sessionID;
	}

	public void search(SearchQuery words) {
		System.out.println("User [" + sessionID + "] initiating search.");
		words.execute();
	}

	public void analyzeResults(ResultList list) {
		System.out.println("User [" + sessionID + "] analyzing search results...");

		if (list == null || list.getResults().isEmpty()) {
			System.out.println("User: No results to analyze.");
			return;
		}

		int count = 0;
		for (SearchResult res : list) {
			if (count >= 3)
				break;

			System.out.println(" -> Clicking result: " + res.getTitle());
			System.out.println("    (Redirecting to " + res.getUrl() + ")");
			count++;
		}
	}
}