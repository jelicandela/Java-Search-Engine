package SearchEngine;

public class HTMLPage extends WebPage {
    private String content;

    public HTMLPage(String url, String content) {
        super(url);
        this.content = content;
    }

    @Override
    public void parse() {
        System.out.println("--> [HTML Logic] Stripping <html> tags...");
        this.title = "HTML Doc: " + url; 
        this.rankScore = 0.9;
    }

    @Override
    public String getContent() {
        return content;
    }
}