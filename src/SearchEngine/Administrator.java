package SearchEngine;

public class Administrator {
    private String adminID;
    private AdminDashboard adminDashboard;

    public Administrator(String adminID) {
        this.adminID = adminID;
        this.adminDashboard = new AdminDashboard();
    }

    public void accessDashboard() {
        System.out.println("Administrator [" + adminID + "] accessing dashboard.");
        adminDashboard.checkSystemHealth();
    }
    
    public void configureSpamFilter(SpamBehavior behavior) {
        System.out.println("Administrator [" + adminID + "]: Updating System Spam Strategy...");
        Index.getInstance().setSpamBehavior(behavior);
    }
}