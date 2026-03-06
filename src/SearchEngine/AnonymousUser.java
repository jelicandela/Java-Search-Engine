package SearchEngine;

public class AnonymousUser extends User {

    public AnonymousUser(String sessionID) {
        super(sessionID);
    }

    public void viewPublicContent() {
        System.out.println("AnonymousUser [" + sessionID + "] viewing public content.");
    }
}