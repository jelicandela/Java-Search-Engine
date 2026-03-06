package SearchEngine;

public class HTMLWebPageFactory extends WebPageFactory {
    @Override
    public WebPage createWebPage(String url, String content) {
        System.out.println("HTMLFactory: Creating HTML page...");
        return new HTMLPage(url, content);
    }
}