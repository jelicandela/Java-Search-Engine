package SearchEngine;

public abstract class WebPage {

	protected String url;
	protected String title;
	protected double rankScore;

	public WebPage(String url) {
		this.url = url;
		this.title = "Untitled";
		this.rankScore = 0.0;
	}

	public abstract void parse();

	public abstract String getContent();

	public String getUrl() {
		return url;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Page Info: [Title=" + title + ", URL=" + url + "]";
	}
}