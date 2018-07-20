package list;

public class DataStorage {
    public User array[] = new User[10];
    private int size = 0;

    public void add(User user) {
        if (size == array.length) {
            extend();
        }
        array[size++] = user;
    }

    private void extend() {

        User[] temp = new User[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];

        }
        array = temp;
    }

    public User getUserByUserName(String username) {
        for (int i = 0; i < size; i++) {
            if (array[i].getUsername().equals(username)) {
                return array[i];
            }
        }
        return null;
    }

    public User getUserByUserPassword(String password) {
        for (int i = 0; i < size; i++) {
            if (array[i].getPassword().equals(password)) {
                return array[i];
            }
        }
        return null;
    }


}