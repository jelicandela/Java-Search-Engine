package SearchEngine;

import java.util.List;

public class SynonymTracker {
	private SynonymDatabase synonymDatabase;

	public SynonymTracker() {
		this.synonymDatabase = new SynonymDatabase();
	}

	public void findSynonyms(String word) {
		System.out.println("SynonymTracker: Analyzing '" + word + "'...");

		List<String> synonyms = synonymDatabase.getSynonyms(word);

		if (synonyms.isEmpty()) {
			System.out.println("SynonymTracker: No synonyms found.");
		} else {
			System.out.println("SynonymTracker: Found synonyms: " + synonyms);
		}
	}

	// Nested Inner Class
	public static class Suggestion {
		private String originalWord;
		private int confidenceScore;

		public Suggestion(String word, int score) {
			this.originalWord = word;
			this.confidenceScore = score;
		}
	}
}