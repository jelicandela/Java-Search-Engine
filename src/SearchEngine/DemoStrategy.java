package SearchEngine;

public class DemoStrategy {
    public static void main(String[] args) {
        // The Singleton Index
        Index searchIndex = Index.getInstance();
        
        // Since WebPageFactory is abstract, we need specific creators for HTML and Text.
        WebPageFactory htmlFactory = new HTMLWebPageFactory();
        WebPageFactory textFactory = new TextWebPageFactory();

        System.out.println("=== TEST 1: Standard SpamFilter (Default) ===");

        // case 1: HTML Page
        // Using 'createAndProcess' which is the shared method in the abstract parent
        WebPage p1 = htmlFactory.createAndProcess("www.wikipedia.org", "History of computer science.");
        
        // case 2: Text Page
        WebPage p2 = textFactory.createAndProcess("readme.txt", "BUY BUY BUY now! Click here!");

        // adding to Index
        searchIndex.addPage(p1);
        searchIndex.addPage(p2);


        System.out.println("\n=== TEST 2: Switch Strategy -> NotSpammed ===");
        // Strategy Pattern: Changing behavior at runtime
        searchIndex.setSpamBehavior(new NotSpammed());

        // case 3: Text Page that is spam
        WebPage p3 = textFactory.createAndProcess("spam_list.txt", "BUY BUY BUY now!!!");
        
        searchIndex.addPage(p3);
        
        System.out.println("\n=== TEST 3: Switch Strategy -> IsSpammed ===");
        // Strategy Pattern: Changing behavior at runtime
        searchIndex.setSpamBehavior(new IsSpammed());

        WebPage p4 = htmlFactory.createAndProcess("www.safe-site.com", "Valid content.");
        searchIndex.addPage(p4); 
        
        System.out.println("\nFinal Index Size: " + searchIndex.getSize());
    }
}