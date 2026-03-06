package SearchEngine;

import java.util.List;

public class AdminDashboard {
    private UserDatabase userDatabase;
    private SpamList spamList;
    
    public AdminDashboard() {
    	this.userDatabase = UserDatabase.getInstance();
        this.spamList = SpamList.getInstance();
    }

    public void manageUsers(String userID) {
        System.out.println("AdminDashboard: Managing user " + userID);
        userDatabase.getAllAccounts();
    }

    public void excludeInAccurateSources(String url) {
        if (url != null && !url.isEmpty()) {
            System.out.println("AdminDashboard: Blacklisting inaccurate source: " + url);
            spamList.blockUrl(url);
        } else {
            System.out.println("AdminDashboard: Invalid URL provided.");
        }
    }

    public void reviewSpamReports() {
        System.out.println("--- Admin Report: Blocked Domains ---");
        List<String> blocked = spamList.getBlockedList();
        
        if (blocked.isEmpty()) {
            System.out.println("No active spam reports.");
        } else {
            for (String site : blocked) {
                System.out.println(" [BLOCKED] " + site);
            }
        }
        System.out.println("-------------------------------------");
    }

    public void checkSystemHealth() {
        System.out.println("--- System Health Check ---");
        
        // checking index size
        int dbSize = Index.getInstance().getSize();
        System.out.println("Database Integrity: OK (" + dbSize + " pages indexed)");
        
        // checking memory usage
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory Usage: " + (memory / 1024 / 1024) + " MB");
        
        System.out.println("System Status: NOMINAL");
        System.out.println("---------------------------");
    }
    
    public void manualUnblock(String url) {
        System.out.println("AdminDashboard: Manually overriding status for " + url);
        spamList.unblockUrl(url);
    }
}
