package SearchEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton core engine that manages the central repository of WebPages.
 * Applies the Strategy Pattern (SpamBehavior) before indexing new content.
 * * @author Andela Jelic
 */

public class Index {
	// 1. The Static Variable
	// the variable belongs to the class, not a specific object and it will only hold one instance of index
	private static Index instance;

	private List<WebPage> allPages;
	private SpamBehavior spamFilter;

	// 2. The Private Constructor
	// forces users to go through the 'getInstance()' method.
	private Index() {
		System.out.println("--> [Index Constructor] Initialize Database...");
		allPages = new ArrayList<>();
		spamFilter = new SpamFilter();
	}

	// 3. The Public access
	public static synchronized Index getInstance() {
	    if (instance == null) {
	        instance = new Index();
	    }
	    return instance;
	}

	public void addPage(WebPage page) {
		// Delegating the logic to the Strategy (SpamFilter) and Factory (WebPage)
		SpamResult result = spamFilter.check(page.getContent());

		if (!result.isSpam()) {
			allPages.add(page);
			System.out.println("Index: Added page [" + page.getTitle() + "]");
		} else {
			System.out.println("Index: Blocked page [" + page.getUrl() + "] Reason: " + result.getRuleViolated());
		}
	}

	public int getSize() {
		return allPages.size();
	}

	public void setSpamBehavior(SpamBehavior newBehavior) {
		this.spamFilter = newBehavior;
		System.out.println("Index: Spam filter strategy updated.");
	}

	public ResultList search(String keyword) {

		ResultList matches = new ResultList();
		String lowerKey = keyword.toLowerCase();

		for (WebPage page : allPages) {
			if (page.getContent().toLowerCase().contains(lowerKey)) {
				SearchResult res = new SearchResult(page.getTitle(), page.getUrl());
				matches.addResult(res);
			}
		}
		return matches;
	}
}