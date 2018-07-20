package enamExample;

import java.util.Scanner;

public class UserTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input use's data");
        String s = scanner.nextLine();
        String[] split = s.split(",");
        User user = new User();
        user.setName(split[0]);
        user.setSurname(split[1]);
        user.setUserType(UserType.valueOf(split[2].toUpperCase()));
        user.setGender(Gender.valueOf(split[3].toUpperCase()));
        System.out.println(user);
    if (user.getUserType()==UserType.ADMIN) {
            System.out.println("welcome admin");
        }else System.out.println("welcome user");

        System.out.println("user's type:");
        for (UserType userType : UserType.values()) {
            System.out.println(userType.name());
            System.out.println(userType.getId()+""+userType.name());
        }
        }
//        User user= new User("anun","azganun",UserType.ADMIN,Gender.MALE);
//        System.out.println(user);
    }


