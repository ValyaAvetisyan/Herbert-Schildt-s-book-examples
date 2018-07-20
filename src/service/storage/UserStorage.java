package service.storage;

import service.exception.ModelNotFoundException;
import service.model.User;
import service.util.SerializeUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private Map<String, User> users = new HashMap<>();

    public void add(User user) {
        users.put(user.getEmail(), user);
        try{
            SerializeUtil.serializeUser(users);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public User getUserByEmailAndPassword(String email, String password) throws ModelNotFoundException {
        User user = users.get(email);
        if (user == null) {
            throw new ModelNotFoundException("User with" + email + "not found");
        }
        return user.getPassword().equals(password) ? user : null;
    }

    public boolean isExist(String email) {
        return users.containsKey(email);
    }

    public void printUsersData() {
        for (User user : users.values()) {

            System.out.println(user.getName() + " " + user.getSurname() + " " + user.getEmail());
        }
    }

    public void refreshUsers() {
        File file = new File(SerializeUtil.USER_FILE_PATH);
        if (file.exists()) {
            try {
                users = SerializeUtil.deserializeUser();
            } catch (IOException e) {
                System.out.println();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("can't create file for user");
            }
        }
    }
}
