package SearchEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	public static class StructuralData {
		public String metaTitle;
		public int wordCount;

		public StructuralData(String title, int count) {
			this.metaTitle = title;
			this.wordCount = count;
		}

		@Override
		public String toString() {
			return "{Title=" + metaTitle + ", Words=" + wordCount + "}";
		}
	}

	private String lastParsedContent = "";

	public void extractData(String rawHTML) {
		this.lastParsedContent = rawHTML;
		System.out.println("Parser: Content loaded (" + rawHTML.length() + " chars).");
	}

	public StructuralData identifyKeyContent() {
		int words = lastParsedContent.split("\\s+").length;

		String title = "Unknown";
		if (lastParsedContent.contains("Title:")) {
			title = lastParsedContent.split("Title:")[1].split("\n")[0].trim();
		} else if (lastParsedContent.length() > 10) {
			title = lastParsedContent.substring(0, 10) + "...";
		}

		return new StructuralData(title, words);
	}

	public void extractLinks() {
		System.out.println("Parser: Scanning for hyperlinks...");

		String urlPattern = "(http|https)://[\\w\\.\\-/]+";
		Pattern pattern = Pattern.compile(urlPattern);
		Matcher matcher = pattern.matcher(lastParsedContent);

		int count = 0;
		while (matcher.find()) {
			System.out.println(" -> Found Link: " + matcher.group());
			count++;
		}

		if (count == 0)
			System.out.println(" -> No hyperlinks found.");
	}
}
