package SearchEngine;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    
    private static UserDatabase instance;
    
    private List<RegisteredUser> users; 

    private UserDatabase() {
        this.users = new ArrayList<>();
        users.add(new RegisteredUser("ID_01", "admin", "admin@test.com"));
        users.add(new RegisteredUser("ID_02", "guest", "guest@test.com"));
    }
    
    public static synchronized UserDatabase getInstance() {
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }
    
    public void addUser(RegisteredUser user) {
        this.users.add(user);
        System.out.println("UserDatabase: Added new user " + user.getUsername());
    }

    public RegisteredUser getUser(String id) {
        for (RegisteredUser u : users) {
            if (u.sessionID.equals(id) || u.getUsername().equalsIgnoreCase(id)) { 
                return u; 
            }
        }
        return null; 
    }

    public void getAllAccounts() {
        System.out.println("UserDatabase: Retrieving all accounts...");
        for (RegisteredUser user : users) {
            System.out.println(" - " + user.getUsername() + " [" + user.getEmail() + "]");
        }
    }

    public void removeUser(String userID) {
        RegisteredUser userToRemove = getUser(userID);
        if (userToRemove != null) {
            users.remove(userToRemove);
            System.out.println("UserDatabase: Removed user " + userID);
        } else {
            System.out.println("UserDatabase: User " + userID + " not found.");
        }
    }

    public boolean validateCredentials(String user, String pass) {
        return "admin".equals(user) && "1234".equals(pass);
    }
}