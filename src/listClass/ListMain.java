package listClass;

import listClass.commands.UserCommand;
import listClass.model.Ad;
import listClass.model.User;
import listClass.storage.AdStorage;
import listClass.storage.UserStorage;
import java.util.Date;
import java.util.Scanner;

public class  ListMain implements UserCommand {
    private UserStorage userStorage = new UserStorage();
    private AdStorage adStorage = new AdStorage();
    private User currentUser = null;
    private Scanner scanner = new Scanner(System.in);

    public void runApplication() {
        boolean isRun = true;
        while (isRun) {
            printUserCommands();
            int userCommand = Integer.parseInt(scanner.nextLine());
            switch (userCommand) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
            }
        }
    }

    private void list() {
        boolean isLoggedIn = true;
        while (isLoggedIn) {
            printListCommands();
            int listCommand = Integer.parseInt(scanner.nextLine());
            switch (listCommand) {
                case 0:
                    isLoggedIn = false;
                    currentUser = null;
                    break;
                case 1:
                    addAd1();
                    break;
                case 2:
                    printAllAd();
                    break;
                case 3:
                    printMyAdd();
                    break;
                case 4:
                    printAdsByType();
                    break;
                case 5:
                    updateAd();
                    break;
                case 6:
                    searchWord();
                    break;
            }
        }
    }

    /**
     * this is method which helps to find word both in Ad's title and Description,
     * and print those variable in which input word is founded
     */
    private void searchWord() {
        String word = scanner.nextLine();
        for (int i = 0; i < adStorage.size; i++) {
            if (adStorage.ads[i].getTitle().contains(word)||adStorage.ads[i].getDesc().contains(word)) {
                System.out.println(adStorage.ads[i]);
            } else {
                System.out.println("not founded");
            }
        }
    }

    /**
     * method description:
     * first we call scanner.nextLine to input Ad's title for finding Advertisement with the help of loop
     *second we input new price
     * then set new price in the place of our price
     * next we update the Ad with the help of lastUpdated variable which is Date typed
     * then we set new price and make our variable current
     */
    private void updateAd() {
        System.out.println("please input Title for changing price");
        String searchingTitle = scanner.nextLine();
        for (int i = 0; i < adStorage.size; i++) {
            if (adStorage.ads[i].getTitle().equalsIgnoreCase(searchingTitle)) {
                System.out.println("input new price");
                double pr = Double.parseDouble(scanner.nextLine());
                adStorage.ads[i].setPrice(pr);
                adStorage.ads[i].setLastUpdatedDate(new Date());
                System.out.println("Thank you, the price is changed");
            } else {
                System.out.println("there is no Ad at that title, Please input other one");
                updateAd();
            }
        }
    }

    /**
     *this is a method which helps to add advertisement in AdStorage
     */
    private void addAd1() {
        System.out.println("please input title, desc, type, price");
        String adStr = scanner.nextLine();
        String[] adData = adStr.split(",");
        //add validation
        Ad ad = new Ad(adData[0], adData[1], adData[2], Double.parseDouble(adData[3]), new Date(), currentUser);
        adStorage.add(ad);
    }

    /**
     * this method helps to print the Advertisement by given type
     */
    private void printAdsByType() {
        System.out.println("please input type");
        adStorage.printByType(scanner.nextLine());

    }

    /**
     * this method prints the advert which belongs to current user
     */
    private void printMyAdd() {
        adStorage.printAdsByUser(currentUser);
    }

    /**
     * this method prints all adverts of AdStorage
     */
    private void printAllAd() {
        adStorage.printAllAd();

    }

    /**
     * this method helps to login by input username and password, but only after registering
     */

    private void login() {
        System.out.println("please input username, password");
        String userNameAndPassword = scanner.nextLine();
        String[] loginData = userNameAndPassword.split(",");
        User user = userStorage.getUserNameAndPassword(loginData[0], loginData[1]);
        if (user == null) {
            System.out.println("wrong username or password");
        } else {
            currentUser = user;
            list();

        }
    }

    /**
     * this method helps to register by adding name, surname, username and password;
     * username will be unique, so try to input the username which won't be repeated
     */
    private void register() {
        System.out.println("please input name, surname, username, password");
        String userStr = scanner.nextLine();
        String[] userData = userStr.split(",");
//        if (userStorage.isUserNameExist(userData[2])){
//            System.out.println("existed");
//        }
        User user = new User(userData[0], userData[1], userData[2], userData[3]);
        for (int i = 0; i < userStorage.size; i++) {
            if (userStorage.users[i].getUsername().equals(userData[2])) {
                System.out.println("The user is already existed");
                register();
            }
        }
        userStorage.add(user);
        System.out.println("Thank you, you have successfully registered");
    }

    /**
     * this methods contains commands, which helps either to login or to register or to exit
     */
    private void printUserCommands() {
        System.out.println("Please enter "+ EXIT +" for Exit");
        System.out.println("Please enter "+LOGIN +" for Login");
        System.out.println("Please enter "+REGISTER+" for Registration");
    }

    /**
     * this method contains commands, which concerns the advertisements
     */
    private void printListCommands() {
        System.out.println("0 Logout");
        System.out.println("1 add Ad");
        System.out.println("2 print all Ads");
        System.out.println("3 print My Ad");
        System.out.println("4 search Ad by type");
        System.out.println("5 for changing price");
        System.out.println("6 for searching word");
    }
}

