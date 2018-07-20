package taskManagement.storage;

import taskManagement.enams.UserType;
import taskManagement.model.User;

import java.util.Map;
import java.util.TreeMap;

public class UserStorage {
    private Map<String, User> userMap = new TreeMap<>();

    public void add(User user) {
        userMap.put(user.getEmail(), user);
    }

    public User getEmailAndPassword(String email, String password)  {

        for (User user : userMap.values()) {
            if (user.getEmail().equals(email) &&
                    user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void printUsers() {

        for (User user : userMap.values()) {
            if (user.getType().equals(UserType.USER)) {
                System.out.println(user);
            }
        }
    }
    public boolean isEmailExist(String email){
        return  userMap.containsKey(email);
    }
    public User getUserByEmail(String email){
        return userMap.get(email);
    }

}
