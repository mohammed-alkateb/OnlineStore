import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private boolean isAdmin;
    private static List<User> users = new ArrayList<>();

    public User(String username, String password, String email, String firstName, String lastName, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmin = isAdmin;
        users.add(this);
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean register(String username, String password, String email, String firstName, String lastName) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return false;
            }
        }
        new User(username, password, email, firstName, lastName, false);
        return true;
    }

    public boolean updateEmail(String username, String email) {
        for (User user : users) {
            if (user.username.equals(username)) {
                user.email = email;
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean promoteToAdmin(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                user.isAdmin = true;
                return true;
            }
        }
        return false;
    }

    public boolean demoteFromAdmin(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                user.isAdmin = false;
                return true;
            }
        }
        return false;
    }
}