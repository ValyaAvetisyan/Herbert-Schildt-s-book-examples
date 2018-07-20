package service;

public interface MailCommand {
    int EXIT = 0;
    int LOGIN = 1;

    int LOGOUT = 0;
    int REGISTER = 2;

    int SEND_MAIL = 1;
    int PRINT_MY_MESSAGES = 2;
    int PRINT_MY_SENT_EMAILS = 3;
}


