import java.rmi.Naming;
import java.util.List;

public class UserManagerClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object
            UserManager userManager = (UserManager) Naming.lookup("rmi://localhost/UserManager");

            // Perform operations
            System.out.println(userManager.addUser("Alice"));
            System.out.println(userManager.addUser("Bob"));
            System.out.println(userManager.addUser("Alice")); // Duplicate user

            // Get all users
            List<String> users = userManager.getUsers();
            System.out.println("Users: " + users);

            // Remove a user
            System.out.println(userManager.removeUser("Alice"));
            System.out.println(userManager.removeUser("Charlie")); // Non-existent user

            // Get all users again
            users = userManager.getUsers();
            System.out.println("Users: " + users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
