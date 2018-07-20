package service;

import service.exception.ModelNotFoundException;
import service.model.Mail;
import service.model.User;
import service.storage.MailStorage;
import service.storage.UserStorage;


import java.util.Date;
import java.util.Scanner;

public class MailService implements MailCommand {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final MailStorage MAIL_STORAGE = new MailStorage();
    private static final UserStorage USER_STORAGE = new UserStorage();
    private static User currentUser = null;

    public static void main(String[] args) {
        USER_STORAGE.refreshUsers();
        MAIL_STORAGE.refreshMails();
        boolean isRun = true;
        while (isRun) {
            printMainCommand();
            int command;
            try {
                command = Integer.parseInt(SCANNER.nextLine());

            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case -1:
                    System.out.println("input number");
                    break;
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
            }
        }

    }

    private static void login() {
        System.out.println("Please input email,password");
        String userLogin = SCANNER.nextLine();
        String[] split = userLogin.split(",");
        try {
            User user = USER_STORAGE.getUserByEmailAndPassword(split[0], split[1]);
            if (user == null) {
                System.out.println("wrong email");
            } else {
                System.out.println("Welcome" + user.getName());
                currentUser = user;
                menu();
            }
        } catch (ModelNotFoundException e) {
            System.out.println(e);
            login();
        }
    }

    private static void register() {

        System.out.println("Please input name, surname, email,password");
        String userLogin = SCANNER.nextLine();
        String[] split = userLogin.split(",");
        if (USER_STORAGE.isExist(split[2])) {
            System.out.println("Email is already existed");
            register();
        } else {
            User user = new User();
            user.setName(split[0]);
            user.setSurname(split[1]);
            user.setEmail(split[2]);
            user.setPassword(split[3]);
            USER_STORAGE.add(user);
            System.out.println("Thank you, you are successfully added");
        }
    }
    private static void menu() {
        boolean isRun = true;
        while (isRun) {
            printMailCommands();
            int command;
            try {
                command = Integer.parseInt(SCANNER.nextLine());

            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case -1:
                    System.out.println("input number");
                    break;
                case LOGOUT:
                    isRun = false;
                    break;
                case SEND_MAIL:
                    sendMail();
                    break;
                case PRINT_MY_MESSAGES:
                    for (Mail mail : MAIL_STORAGE.getReceivedMails(currentUser.getEmail())) {
                        System.out.println(mail);
                    }
                    break;
                case PRINT_MY_SENT_EMAILS:

                    for (Mail mail : MAIL_STORAGE.getSentMails(currentUser.getEmail())) {
                        System.out.println(mail);
                    break;
            }


        }
    }}
    private static void sendMail(){
        System.out.println("Please choose a user by email");
        USER_STORAGE.printUsersData();
        String userMail = SCANNER.nextLine();
        System.out.println("please input message");
        String message = SCANNER.nextLine();
        Mail mail = new Mail(userMail,currentUser.getEmail(),message, new Date());
        MAIL_STORAGE.add(mail);
        System.out.println("mail was sent");

    }

    private static void printMainCommand() {
        System.out.println("Input" + EXIT + " for exit");
        System.out.println("Input" + LOGIN + " for login");
        System.out.println("Input" + REGISTER + " for register");
    }

    private static void printMailCommands() {
        System.out.println("Input" + LOGOUT + " for logout");
        System.out.println("Input" + SEND_MAIL + " for send mail");
        System.out.println("Input" + PRINT_MY_MESSAGES + " for print my message");
        System.out.println("Input" + PRINT_MY_SENT_EMAILS + " for print sent emails");
    }

}
