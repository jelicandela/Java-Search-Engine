package SearchEngine;

public class DemoSingleton {

    public static void main(String[] args) {
        System.out.println("=== SINGLETON PATTERN DEMO ===");
        
        // Using a concrete factory to create dummy data for Singleton test
        WebPageFactory factory = new HTMLWebPageFactory();
        
        // First Access (Instantiation)
        System.out.println("\n[Crawler] Requesting access to the Index...");
        
        // Calling getInstance() for the first time
        // 'uniqueInstance' is null, the Index constructor will run once
        Index crawlerIndex = Index.getInstance();
        
        // Adding data to this specific reference 'crawlerIndex'
        WebPage page = factory.createWebPage("www.sample.com/java.html", "Sample Page Content");
        crawlerIndex.addPage(page); 
        System.out.println("[Crawler] Page added. Index size is now: " + crawlerIndex.getSize());

        // Second Access (Global Access Point)
        System.out.println("\n[SearchQuery] Requesting access to the Index...");

        // Calling getInstance() again from a different context
        // The Index constructor should not run this time
        // It should return the exact same object already created
        Index searchIndex = Index.getInstance();

        // Proof: If this is the same object, it should already contain the page added above
        System.out.println("[SearchQuery] Checking Index size...");
        if (searchIndex.getSize() == 1) {
            System.out.println(" - Success! The Index already has data.");
        } else {
            System.out.println(" - Error! The Index is empty (Different object?).");
        }

        // Identity Verification
        System.out.println("\n--- Memory Address Verification ---");
        // System.identityHashCode prints the actual memory location of the object
        int id1 = System.identityHashCode(crawlerIndex);
        int id2 = System.identityHashCode(searchIndex);
        
        System.out.println("Crawler Index Ref ID : " + id1);
        System.out.println("Search Index Ref ID  : " + id2);

        if (crawlerIndex == searchIndex) {
            System.out.println("RESULT: SUCCESS. Both variables point to the EXACT SAME instance.");
        } else {
            System.out.println("RESULT: FAIL. You have multiple instances.");
        }
    }
}