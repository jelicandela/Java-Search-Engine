package SearchEngine;

import java.util.Date;

public class Bookmark {
	private String url;
	private String note;
	private Date savedDate;

	public Bookmark(String url, String note) {
		this.url = url;
		this.note = note;
		this.savedDate = new Date();
	}

	public Bookmark() {
    }
	
	public void setUrl(String url) {
		this.url = url;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setSavedDate(Date savedDate) {
		this.savedDate = savedDate;
	}

	public void updateNote(String newNote) {
		this.note = newNote;
		System.out.println("Bookmark: Note updated for [" + url + "]");
	}

	// opening the bookmark
	public void open() {
		System.out.println("Bookmark: Redirecting to... " + url);
	}

	// displaying the details of the bookmark
	public void viewDetails() {
		System.out.println("--- Saved Bookmark ---");
		System.out.println("URL:  " + url);
		System.out.println("Note: " + note);
		System.out.println("Date: " + savedDate);
		System.out.println("----------------------");
	}

	public String getUrl() {
		return url;
	}

	public String getNote() {
		return note;
	}

	public Date getSavedDate() {
		return savedDate;
	}
}