package service.util;

import service.model.Mail;
import service.model.User;


import java.io.*;
import java.util.List;
import java.util.Map;

public class SerializeUtil {
    public static final String USER_FILE_PATH="src\\service\\data\\user";
    public static final String MAIL_FILE_PATH="src\\service\\data\\mail";
    public static void serializeUser(Map<String,User> useMap) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(USER_FILE_PATH));
        objectOutputStream.writeObject(useMap);
        objectOutputStream.close();
    }


    public static Map<String,User> deserializeUser() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(USER_FILE_PATH));

        return (Map<String ,User>)objectInputStream.readObject();
    }

    public static void serializeMail(List<Mail> mailList) throws IOException {
        ObjectOutputStream objectOutputStream= new ObjectOutputStream(new FileOutputStream(MAIL_FILE_PATH));
        objectOutputStream.writeObject(mailList);
        objectOutputStream.close();
    }
    public static List<Mail> deserializeMails() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(MAIL_FILE_PATH));

        return (List<Mail>) objectInputStream.readObject();
    }


}
