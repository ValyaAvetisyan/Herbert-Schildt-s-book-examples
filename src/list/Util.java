package list;

import java.util.Date;
import java.util.Scanner;

public class Util {

    private static Scanner scanner = new Scanner(System.in);
    private static DataStorage dataStorage = new DataStorage();
    private static AdDataStorage adDataStorage = new AdDataStorage();
    private static ListTest listTest = new ListTest();
    public static User currentUser;

    public static AdDataStorage getAdDataStorage() {
        return adDataStorage;
    }

    public static void registration() {
        System.out.println("Please input name, surname, username, password");
        String reg = scanner.nextLine();
        String[] splitForReg = reg.split(",");
        if (splitForReg.length < 4) {
            System.out.println("You should have 4 inputs separated , ");
            registration();
        }
        User user = new User(splitForReg[0], splitForReg[1], splitForReg[2], splitForReg[3]);
        System.out.println("Thank you for registering");
        dataStorage.add(user);
    }

    public static void logIn() {
        System.out.println("enter username");
        String log = scanner.nextLine();
        User getUserByUsername1 = dataStorage.getUserByUserName(log);
        if (getUserByUsername1 == null) {
            System.out.println("no user at that username");
        } else {
            System.out.println("enter password");
        }
        String pass = scanner.nextLine();
        User getUserByPassword1 = dataStorage.getUserByUserPassword(pass);
        if (getUserByPassword1 == null) {
            System.out.println("Wrong password");
        } else {
            System.out.println("Welcome " + getUserByUsername1.getName());

        }
    }

    public static void addAd() {
        System.out.println("please input Ad's title, type, address, createDate, user");
        String add = scanner.nextLine();
        String[] splitForAdd = add.split(",");
        if (splitForAdd.length < 5) {
            System.out.println("You should have 5 inputs separated , ");
            addAd();
        }
        User user = dataStorage.getUserByUserName(splitForAdd[4]);
        Advertisement advertisement = new Advertisement(splitForAdd[0], splitForAdd[1], splitForAdd[2], new Date(), user);

//        adDataStorage.addAd(advertisement);

    }

    public static void printMyAd(String currentUser) {
        User getUserByUsername2 = dataStorage.getUserByUserName(currentUser);
        if (getUserByUsername2 == null) {
            System.out.println("no Ad by that user");
        } else {
            for (int i = 0; i < adDataStorage.adSize; i++) {
                if (dataStorage.getUserByUserName(currentUser).getUsername().equals(adDataStorage.adArray[i].getUser().getUsername())) {
                    adDataStorage.printAds();
                }
            }
        }
    }

    public static void adsByType(String type) {
        for (int i = 0; i < adDataStorage.adSize; i++) {
            if (adDataStorage.adArray[i].getType().equals(type)) {
                adDataStorage.printAds();
            } else {
                System.out.println("no Ad at that type");
            }

        }
    }
}
