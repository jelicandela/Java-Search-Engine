package SearchEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Main entry point for the console-based simulation of the search engine.
 * Demonstrates the architectural interaction between Users, Administrators, 
 * the Crawler, and the core Index.
 * * @author Andela Jelic
 */

public class MainSearchEngine {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   SEARCH ENGINE SYSTEM STARTUP");
        System.out.println("==========================================");

        // 1. Administrator
        System.out.println("\n1. Administratior Action");
        Administrator admin = new Administrator("Admin_007");
        
        // Admin is checking system health via Dashboard
        admin.accessDashboard(); 
        
        // Admin is configuring the Strategy (SpamFilter)
        // This sets the behavior for the Singleton Index
        admin.configureSpamFilter(new SpamFilter());

        // 2. Crawler
        System.out.println("\n2. Crawler Action");
        Crawler crawler = new Crawler();
        
        List<String> seeds = new ArrayList<>();
        seeds.add("www.haw-hamburg.de/index.html"); 
        seeds.add("www.example.com/spam.txt"); 
        
        // Crawler uses Factory Method to create pages and Index to store them
        crawler.startCrawling(seeds);

        // Verifying Spam blocking
        System.out.println("\n>> System: Attempting to force-index a spam page...");
        
        // Using TextWebPageFactory for text-based spam check
        WebPageFactory factory = new TextWebPageFactory();
        
        // Using 'createAndProcess'
        WebPage spamPage = factory.createAndProcess("www.scam.com", "BUY BUY BUY now! Click here!");
        
        // Trying to add to Index (Blocked by the SpamFilter Strategy)
        Index.getInstance().addPage(spamPage); 
        
        // 3. Registered User
        System.out.println("\n3. Registered User Action");
        RegisteredUser regUser = new RegisteredUser("Session_ID_99", "MaxMustermann", "max@haw.de");
        regUser.login("MaxMustermann", "secret123");

        // Searching (Uses SearchQuery -> Index -> RelevanceChecker)
        SearchQuery userQuery = new SearchQuery("content"); 
        regUser.search(userQuery);

        // Search History
        regUser.saveSearch(userQuery);
        regUser.viewSearchHistory();

        // Bookmarking
        System.out.println("\n>> RegisteredUser: Found a useful page. Creating a bookmark...");
        Bookmark usefulPage = new Bookmark("www.haw-hamburg.de", "University Homepage");
        
        // adding it to the user's list
        regUser.addBookmark(usefulPage);
        
        usefulPage.viewDetails();
        System.out.println(">> RegisteredUser: Updating the bookmark note...");
        usefulPage.updateNote("University Homepage - Check exam schedule!");
        
        // Viewing the collection to prove it was saved
        regUser.viewBookmarks();
        
        regUser.logout();

        // 4. Anonymous User
        System.out.println("\n4. Anonymous User Action");
        AnonymousUser anonUser = new AnonymousUser("Guest_01");
        anonUser.viewPublicContent();
        
        // searching for something that might not exist
        SearchQuery anonQuery = new SearchQuery("python");
        anonUser.search(anonQuery);

        // 5. System Status
        System.out.println("\n5. System Status");
        // Accessing the Singleton Index to check final size
        System.out.println("Total Pages in Index: " + Index.getInstance().getSize());

        System.out.println("\n==========================================");
        System.out.println("   SYSTEM SHUTDOWN");
        System.out.println("==========================================");
    }
}