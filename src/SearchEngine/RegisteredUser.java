package SearchEngine;

import java.util.ArrayList;
import java.util.List;

public class RegisteredUser extends User {
    private String username;
    private String passswordHash;
    private String email;
    
    private SearchHistory searchHistory;
    private List<Bookmark> bookmarks;
    
    public RegisteredUser() {
    	super();
    }
    
    public RegisteredUser(String sessionID, String username, String email) {
        super(sessionID);
        this.username = username;
        this.email = email;
        this.searchHistory = new SearchHistory();
        this.bookmarks = new ArrayList<>();
        this.passswordHash = "hashed_secret"; 
    }

    public String getSessionID() {
		return this.sessionID;
	}
    
    public String getUsername() {
        return username;
    }

    public String getPassswordHash() {
		return passswordHash;
	}
    
    public String getEmail() {
        return email;
    }

    public SearchHistory getSearchHistory() {
		return searchHistory;
	}

    public java.util.List<Bookmark> getBookmarks() {
        return this.bookmarks;
    }
    
    public void setUsername(String username) {
		this.username = username;
	}
    
	public void setPassswordHash(String passswordHash) {
		this.passswordHash = passswordHash;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSearchHistory(SearchHistory searchHistory) {
		this.searchHistory = searchHistory;
	}

	public void setBookmarks(List<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

    public void login(String username, String password) {
        System.out.println("RegisteredUser: " + username + " logged in.");
    }

    public void logout() {
        System.out.println("RegisteredUser: " + username + " logged out.");
    }

    public void saveSearch(SearchQuery query) {
        System.out.println("RegisteredUser: Saving search query to history.");
        searchHistory.add(query);
    }
    
    public void addBookmark(Bookmark bookmark) {
        if (this.bookmarks == null) {
            this.bookmarks = new ArrayList<>();
        }
        this.bookmarks.add(bookmark);
    }

    public void viewBookmarks() {
        System.out.println("\n--- " + username + "'s Bookmarks ---");
        if (bookmarks.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            for (Bookmark b : bookmarks) {
                b.viewDetails();
            }
        }
        System.out.println("--------------------------------");
    }

    public void viewSearchHistory() {
        System.out.println("RegisteredUser: Viewing search history...");
        //
    }
}