package SearchEngine;

import java.util.List;

/**
 * Simulates a web crawler that fetches URLs and processes content.
 * Delegates the creation of specific page types to the WebPageFactory.
 * * @author Andela Jelic
 */

public class Crawler {
    private String userAgent;
    private Parser parser;

    public Crawler() {
        this.userAgent = "SelCrawler/1.0";
        this.parser = new Parser(); 
    }

    public void startCrawling(List<String> seedUrlList) {
        System.out.println("Crawler: Starting with User-Agent: " + userAgent);
        for (String url : seedUrlList) {
            fetch(url);
        }
    }

    public void fetch(String url) {
        System.out.println("Crawler: Fetching " + url);
        String dummyContent = "<html>Content for " + url + "</html>";

        // Factory Method
        WebPageFactory factory;

        // Crawler decides which concrete factory to use
        if (url.endsWith(".html") || url.endsWith(".htm")) {
            factory = new HTMLWebPageFactory();
        } else {
            factory = new TextWebPageFactory();
        }
        
        // Calling the shared method on the Abstract Parent.
        // This method calls createWebPage() and then .parse()
        WebPage page = factory.createAndProcess(url, dummyContent);

        if (page != null) {
            parser.extractData(dummyContent);
            Index.getInstance().addPage(page);
        }
    }
}