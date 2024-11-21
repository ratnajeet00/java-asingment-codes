import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface UserManager extends Remote {
    // Add a user
    String addUser(String username) throws RemoteException;

    // Get all users
    List<String> getUsers() throws RemoteException;

    // Remove a user
    String removeUser(String username) throws RemoteException;
}
