package SearchEngine;

public class TextPage extends WebPage {
    private String content;

    public TextPage(String url, String content) {
        super(url);
        this.content = content;
    }

    @Override
    public void parse() {
        System.out.println("--> [Text Logic] Reading raw characters...");
        this.title = "Text Doc: " + url;
        this.rankScore = 0.5;
    }

    @Override
    public String getContent() {
        return content;
    }
}