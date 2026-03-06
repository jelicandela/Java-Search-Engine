package SearchEngine;

/**
 * Abstract factory defining the creation method for WebPage objects.
 * Allows the system to dynamically process different content types (e.g., HTML, Text).
 * * @author Andela Jelic
 */

public abstract class WebPageFactory {

    public abstract WebPage createWebPage(String url, String content);

    // factory method to create and then process the page.
    public WebPage createAndProcess(String url, String content) {
        WebPage page = createWebPage(url, content);
        page.parse(); // shared logic
        return page;
    }
}