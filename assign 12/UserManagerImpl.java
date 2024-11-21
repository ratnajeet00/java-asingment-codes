import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl extends UnicastRemoteObject implements UserManager {
    private List<String> users;

    protected UserManagerImpl() throws RemoteException {
        users = new ArrayList<>();
    }

    @Override
    public String addUser(String username) throws RemoteException {
        if (users.contains(username)) {
            return "User already exists!";
        }
        users.add(username);
        return "User added: " + username;
    }

    @Override
    public List<String> getUsers() throws RemoteException {
        return users;
    }

    @Override
    public String removeUser(String username) throws RemoteException {
        if (users.remove(username)) {
            return "User removed: " + username;
        }
        return "User not found!";
    }
}
