import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class UserManagerServer {
    public static void main(String[] args) {
        try {
            // Start RMI registry
            LocateRegistry.createRegistry(1099);

            // Create and bind the remote object
            UserManager userManager = new UserManagerImpl();
            Naming.rebind("UserManager", userManager);

            System.out.println("UserManager Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
