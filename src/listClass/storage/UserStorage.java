package listClass.storage;

import listClass.model.User;

public class UserStorage {

public User[] users = new User[16];
public int size=0;
public void add (User user){
    if (users.length ==size){
        extend();
    }
    users[size++]= user;
}
private void extend(){
    User [] temp = new User[users.length+10];
    System.arraycopy(users,0,temp,0,users.length);
    users=temp;
}
public User getUserNameAndPassword(String username, String password){
    for (int i = 0; i <size ; i++) {
        if (users[i].getUsername().equals(username)&&
                users[i].getPassword().equals(password)){
            return users[i];
        }
    }
    return null;
}
public boolean isUserNameExist(String userName){
    for (int i = 0; i <size ; i++) {
        if (users[i].getUsername().equals(userName)){
            return  true;
        }
    }
    return  false;
}
}
