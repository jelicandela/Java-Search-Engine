package SearchEngine;

public class DemoFactory {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Demo ===");

        // Declaring the variable using the Abstract Parent 'WebPageFactory'
        WebPageFactory factory;

        // Scenario 1: HTML Page
        System.out.println("\n--- Scenario 1: Client needs an HTML Page ---");
        
        // The Client decides which specific factory (Concrete Creator) to use
        // Instantiating the HTML-specific factory
        factory = new HTMLWebPageFactory(); 

        String url1 = "www.example.com/index.html";
        String content1 = "<html><body>Hello World</body></html>";

        // Calling 'createAndProcess'
        // The factory will internally call 'createWebPage' to build the HTMLPage
        WebPage page1 = factory.createAndProcess(url1, content1); 
        
        if (page1 != null) {
            System.out.println("Result Class: " + page1.getClass().getSimpleName());
            System.out.println("Output: " + page1);
        }

        // Scenario 2: Text Page
        System.out.println("\n--- Scenario 2: Client needs a Text Page ---");
        
        // Swapping the factory implementation to the Text-specific one
        factory = new TextWebPageFactory();
        
        String url2 = "www.example.com/readme.txt";
        String content2 = "Plain text content.";
        
        // Calling the method 'createAndProcess'
        // 'factory' is now a TextWebPageFactory, so it produces a TextPage
        WebPage page2 = factory.createAndProcess(url2, content2);
        
        if (page2 != null) {
            System.out.println("Result Class: " + page2.getClass().getSimpleName());
            System.out.println("Output: " + page2);
        }
    }
}