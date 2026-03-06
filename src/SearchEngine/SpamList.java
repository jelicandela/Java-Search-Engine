package SearchEngine;

import java.util.ArrayList;
import java.util.List;

public class SpamList {
	private static SpamList instance;
    private List<String> blockedURLList;

    public SpamList() {
        this.blockedURLList = new ArrayList<>();
        blockedURLList.add("malware-site.com");
    }
    
    public static SpamList getInstance() {
        if (instance == null) {
            instance = new SpamList();
        }
        return instance;
    }
    
    public void manageList(String url) {
        if (!blockedURLList.contains(url)) {
            blockedURLList.add(url);
            System.out.println("SpamList: Added " + url + " to block list.");
        }
    }

    public boolean checkSpam() {
        // simplified logic
        return !blockedURLList.isEmpty();
    }
    
    public void blockUrl(String url) {
        if (!blockedURLList.contains(url)) {
            blockedURLList.add(url);
            System.out.println("SpamList: " + url + " has been BLOCKED.");
        }
    }

    public void unblockUrl(String url) {
        if (blockedURLList.contains(url)) {
            blockedURLList.remove(url);
            System.out.println("SpamList: " + url + " is now SECURE (Unblocked).");
        } else {
            System.out.println("SpamList: " + url + " was not found in the block list.");
        }
    }
    
    public boolean isBlocked(String url) {
        return blockedURLList.contains(url);
    }
    
    public boolean containsBlockedUrl(String textToCheck) {
        if (textToCheck == null || blockedURLList.isEmpty()) {
            return false;
        }
        
        // Iterating through the Singleton's real data
        for (String badUrl : blockedURLList) {
            if (textToCheck.contains(badUrl)) {
                return true;
            }
        }
        return false;
    }
    
    public List<String> getBlockedList() {
        return this.blockedURLList;
    }
}
