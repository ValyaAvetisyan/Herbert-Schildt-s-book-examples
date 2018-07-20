package list;

import java.util.Scanner;

public class ListTest {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean isRun = true;
        boolean isRun2 = true;
        while (isRun) {
            printCommands();
            int command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case 0:
                    isRun = false;
                    break;
                case 1:
                    Util.logIn();
                    while (isRun2) {
                        printCommandsForAd();
                        int command1 = Integer.parseInt(scanner.nextLine());
                        switch (command1) {
                            case 0:
                                isRun2 = false;
                                break;
                            case 1:
                                Util.addAd();
                                break;
                            case 2:
                                Util.getAdDataStorage().printAds();
                                break;
                            case 3:
                                System.out.println("input username");
                                Util.printMyAd(scanner.nextLine());
                                break;
                            case 4:
                                Util.adsByType(scanner.nextLine());
                        }

                    }
                case 2:
                    Util.registration();

            }
        }
    }


    private static void printCommands() {
        System.out.println("0 Exit");
        System.out.println("1 Login");
        System.out.println("2 Registration");
    }

    private static void printCommandsForAd() {
        System.out.println("0 Exit");
        System.out.println("1 add Ad");
        System.out.println("2 print all Ads");
        System.out.println("3 print My Ad");
        System.out.println("4 search Ad by type");
    }
}

//Create separate AdDataStorage and UserDataStorage separate the logic
//handle null pointer exceptions if user enter only the username or more then needed
//Create User currentUser static field which will hold the current user
// if you want to get your adds you should filter adds by username  if(currentUSer.getUsername.equals(ad.getUsername()){...your logic here}