package educationCenter.storage;


import educationCenter.exception.UserNotFoundException;
import educationCenter.model.Lesson;
import educationCenter.model.User;
import educationCenter.model.UserType;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserStorage implements UserType {
    private Map<String, User> users = new HashMap<>();

    public void add(User user) {
        users.put(user.getEmail(), user);
    }

    public void printUsers() {
        for (User user : users.values()) {
            System.out.println(user);
        }
    }

    public void printStudents() {
        for (User user : users.values()) {
            if (user.getType().equals(STUDENT)) {
                System.out.println(user);
            }

        }
    }

    public void printEmails() {
        for (User user : users.values()) {
            if (user.getType().equals(STUDENT)) {
                System.out.println(user.getEmail());

            }
        }
    }

    public User getUserByEmail(String email) throws UserNotFoundException {
        for (User user : users.values()) {

            if (user.getEmail().equals(email)) {
                return user;
            }

        }
        throw new UserNotFoundException("User with" + email + "not exist");
    }

//    public void printUserByLessonName(Lesson lessonName) {
//        for (User user : users.values()) {
//            for (Lesson lesson : user.getLessons()) {
//                if (lessonName.equalsIgnoreCase(lesson.getName())) {
//                    System.out.println(user);
//                }

//            }

//        }
//    }

    public User getUserNameAndPassword(String username, String password) {
        for (User user : users.values()) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void printUserByLesson(Lesson lesson) {
        for (User user : users.values()) {
            if (user.getLessons().contains(lesson)) {
                System.out.println(user);
                break;
            }

        }
    }
}
