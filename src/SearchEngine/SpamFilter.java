package SearchEngine;

public class SpamFilter implements SpamBehavior {

    private SpamList spamList;

    public SpamFilter() {
        this.spamList = new SpamList();
        
        // Populating the list (Simulating a database load)
        // In a real system, this would load from a file or SQL DB
        this.spamList.manageList("malware-site.com");
        this.spamList.manageList("phishing-example.net");
        this.spamList = SpamList.getInstance();
    }

    @Override
    public SpamResult check(String content) {
        // 1. Safety Check: Null or Empty
        if (content == null || content.isEmpty()) {
            return new SpamResult(false, 0.0, "Empty content");
        }

        String lowerContent = content.toLowerCase();

        // 2. Checking against the SpamList for blacklisted URLs or domains
        if (checkIfInSpamList(lowerContent)) {
             return new SpamResult(true, 1.0, "Blacklisted Domain (Found in SpamList)");
        }

        // 3. Keyword Stuffing Check: Simple heuristic for demonstration
        if (lowerContent.contains("buy buy buy") || lowerContent.contains("click here")) {
            SpamResult result = new SpamResult(true, 0.95, "Keyword Stuffing");
            result.addKeyword("buy buy buy"); 
            return result;
        }

        // 4. Length Check: Very short content might be spam (e.g., "Free!", "Win now!")
        if (content.length() < 10) {
            return new SpamResult(true, 0.5, "Content too short");
        }

        // Default: Safe
        return new SpamResult(false, 0.0, "None");
    }

    private boolean checkIfInSpamList(String content) {
        // Delegating the check to the SpamList class
        // For the admin to add a new URL to SpamList later
    	return spamList.containsBlockedUrl(content);
    }
}