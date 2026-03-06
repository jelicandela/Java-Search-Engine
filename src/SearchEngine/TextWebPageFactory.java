package SearchEngine;

public class TextWebPageFactory extends WebPageFactory {
    @Override
    public WebPage createWebPage(String url, String content) {
        System.out.println("TextFactory: Creating Text page...");
        return new TextPage(url, content);
    }
}