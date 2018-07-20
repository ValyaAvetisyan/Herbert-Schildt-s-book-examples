package educationCenter;

import educationCenter.command.AdminCommands;
import educationCenter.command.StudentCommands;
import educationCenter.command.UserCommands;

import educationCenter.exception.UserNotFoundException;
import educationCenter.model.Lesson;
import educationCenter.model.Message;
import educationCenter.model.User;
import educationCenter.model.UserType;
import educationCenter.storage.LessonStorage;
import educationCenter.storage.MessageStorage;
import educationCenter.storage.UserStorage;


import java.util.*;

public class EducationCenter implements AdminCommands, UserType, StudentCommands, UserCommands {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final UserStorage STUDENT_STORAGE = new UserStorage();
    private static final LessonStorage LESSON_STORAGE = new LessonStorage();
    private static final MessageStorage MESSAGE_STORAGE = new MessageStorage();
    private static User currentUser = null;
    // private static List<Lesson> lessonList = new ArrayList<>();
    // private static List<User> userList= new ArrayList<>();
    //  private static Map<String,User> userHashMap = new HashMap<>();
    //   private static List<Message> messageList= new ArrayList<>();

    public static void main(String[] args) {
        EducationCenter center = new EducationCenter();
        center.createAdminUser();
        center.runApplication();


    }

    /**
     * this method contains exit and login commands
     */
    private static void runApplication() {
        boolean isRun = true;
        while (isRun) {
            printUserCommands();
            int userCommands = Integer.parseInt(SCANNER.nextLine());
            switch (userCommands) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    login();
                    break;
            }

        }

    }

    /*
    this method contains commands for both admin and student
     */
    private static void mainCommands() {
        boolean isLogged = true;
        while (isLogged) {
            if (currentUser.getType().equalsIgnoreCase(ADMIN)) {
                printAdminCommand();
                int command = 0;
                try {
                    command = Integer.parseInt(SCANNER.nextLine());
                } catch (NumberFormatException e) {
                    command = -1;
                }
                switch (command) {
                    case -1:
                        System.out.println("please input a number");
                        break;
                    case EXIT:
                        runApplication();
                    case ADD_LESSON:
                        addLesson();
                        break;
                    case ADD_STUDENT:
                        addStudent();
                        break;
                    case PRINT_LESSONS:
                        LESSON_STORAGE.printLessonsSortedByPrice();
                        break;
                    case PRINT_STUDENTS:
                        STUDENT_STORAGE.printUsers();
                        break;
                    case CHANGE_STUDENT_LESSON:
                        changeStudentByLessonName();
                        break;
                    case PRINT_STUDENTS_BY_LESSON_NAME:
                        printStudentByLessonName();
                        break;
                    default:
                        System.out.println("Please input a valid command");
                }
            } else {
                printStudentCommand();

                int command = 0;
                try {
                    command = Integer.parseInt(SCANNER.nextLine());
                } catch (NumberFormatException e) {
                    command = -1;
                }
                switch (command) {
                    case LOG_OUT:
                        login();
                        break;
                    case CHANGE_PASSWORD:
                        changePassword();
                        break;
                    case CHANGE_MY_LESSON:
                        changeMyLesson();
                        break;
                    case PRINT_MY_LESSON:
                        printMyLesson();
                        break;
                    case CHANGE_MY_DATA:
                        changeData();
                        break;
                    case SEND_MESSAGE:
                        sendMessage();
                        break;
                    case VIEW_MESSAGES:
                        viewAllMessages();
                        break;
                    case PRINT_NEW_MESSAGES:
                        showUserMessagesByEmail();
                        break;
                    default:
                        System.out.println("Please input a valid command");


                }

            }
        }
    }

    /**
     * this method's aim is to create user as admin
     */
    private void createAdminUser() {
        System.out.println("Please register as admin");
        System.out.println("Input name, surname,username");
        String adminStr = SCANNER.nextLine();
        String[] adminData = null;
        try {
            adminData = adminStr.split(",");
        } catch (Exception e) {
            System.out.println("Please try again wrong input arguments");

        }

        User userAdmin = new User();
        userAdmin.setName(adminData[0]);
        userAdmin.setSurname(adminData[1]);
        userAdmin.setUsername(adminData[2]);
        userAdmin.setPassword(generatePassword(adminData[0]));
        userAdmin.setType(ADMIN);
        STUDENT_STORAGE.add(userAdmin);
        System.out.println(userAdmin.toString());

    }

    /**
     * this method is for adding lesson in storage
     */
    private static void addLesson() {
        System.out.println("Please input name, lecturerName, duration, price");
        String lessonString = SCANNER.nextLine();
        try {
            String[] lessonData = lessonString.split(",");
            int duration = Integer.parseInt(lessonData[2]);
            double price = Integer.parseInt(lessonData[3]);
            Lesson lesson = new Lesson(lessonData[0], lessonData[1], duration, price);
            LESSON_STORAGE.add(lesson);
            System.out.println("successfully added");

        } catch (Exception e) {
            System.out.println("invalid Data");
            addLesson();

        }

    }

    /**
     * this method is for adding student in array list
     */
    private static void addStudent() {
        System.out.println("Please input name, surname, phone, email");
        String studentStr = SCANNER.nextLine();
        String[] studentsData = studentStr.split(",");
        try {
            System.out.println("please input lessons name");
            LESSON_STORAGE.printLessons();
            String lessonStr = SCANNER.nextLine();
            String[] lessonsName = lessonStr.split(",");
            Set<Lesson> lessons = new HashSet<>();
            for (String s : lessonsName) {
                Lesson lessonByName = LESSON_STORAGE.getLessonByName(s);
                lessons.add(lessonByName);
            }

            User student = new User();
            student.setName(studentsData[0]);
            student.setSurname(studentsData[1]);
            student.setPhone(studentsData[2]);
            student.setEmail(studentsData[3]);
            student.setRegisterDate(new Date());
            student.setType(STUDENT);
            student.setUsername(studentsData[3]);
            student.setPassword(generatePassword(studentsData[0]));
            student.setLessons(lessons);
            STUDENT_STORAGE.add(student);
            System.out.println("Your login is " + student.getUsername() + " Your password is " + student.getPassword());

        } catch (Exception e) {
            System.out.println("invalid data");
            addStudent();
        }
    }

    /**
     * this method is aimed to print student by lesson name
     */
    private static void printStudentByLessonName() {
        System.out.println("Please input lesson name");
        LESSON_STORAGE.printLessons();
        String lessonName = SCANNER.nextLine();
        STUDENT_STORAGE.printUserByLesson(LESSON_STORAGE.getLessonByName(lessonName));
    }

    // this method is for changing student by its lesson name
    private static void changeStudentByLessonName() {
        System.out.println("Please input student by email");
        STUDENT_STORAGE.printUsers();
        String studentEmail = SCANNER.nextLine();
        try {
            User student = STUDENT_STORAGE.getUserByEmail(studentEmail);
            System.out.println("Please input lessons name by email");
            LESSON_STORAGE.printLessons();
            String lessonStr = SCANNER.nextLine();
            String[] lessonsName = lessonStr.split(",");
            Set<Lesson> lessons = new HashSet<>();
            for (String s : lessonsName) {
                Lesson lessonByName = LESSON_STORAGE.getLessonByName(s);
                lessons.add(lessonByName);
            }
            student.setLessons(lessons);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
            changeStudentByLessonName();

        }
    }

    // this method give random number for password

    private static String generatePassword(String name) {
        Random rand = new Random();
        return name + (1000 + rand.nextInt(8000));
    }

    // this method's aim is to allow user to login to the system
    private static void login() {
        System.out.println("please input username, password");
        try {
            String userNameAndPassword = SCANNER.nextLine();
            String[] loginData = userNameAndPassword.split(",");
            User user = STUDENT_STORAGE.getUserNameAndPassword(loginData[0], loginData[1]);
            if (user == null) {
                System.out.println("wrong username or password");
            } else {
                currentUser = user;
                mainCommands();

            }
        } catch (Exception e) {
            System.out.println("invalid data");
        }
    }

    // this method helps user to change the current password
    private static void changePassword() {
        System.out.println("please input your current password");
        String password = SCANNER.nextLine();
        Set<User> userSet = new HashSet<>();
        for (User user : userSet) {
            if (user.getPassword() == null) {
                System.out.println("there is no user at that username");
                changePassword();
            } else {
                System.out.println("input new password");
                String pass = SCANNER.nextLine();
                user.setPassword(pass);
                System.out.println("Thanks, your password is changed");
                break;
            }
        }
    }

    // this method allow student to change his/her lesson
    private static void changeMyLesson() {
        System.out.println("Please choose your subject for changing");
        LESSON_STORAGE.printLessons();
        String less = SCANNER.nextLine();
        Set<User> userSet = new HashSet<>();
        for (User user : userSet) {
            user.setLessons(less);

        }
        System.out.println("Your lesson is changed");

    }

    // this method print current user's lessons
    private static void printMyLesson() {
        for (Lesson l : currentUser.getLessons())
            System.out.println(l.toString());
    }

    //this method's aim is to change student's phone number
    private static void changeData() {
        System.out.println("Please input your phone number");
        String phone = SCANNER.nextLine();
        Set<User> userSet = new HashSet<>();
        for (User user : userSet) {
            if (user.getPhone() == null) {
                System.out.println("wrong phone number, please try again");
                changeData();

            } else
                System.out.println("Please input new phone number");
            String newPhone = SCANNER.nextLine();
            user.setPhone(newPhone);
            System.out.println("Your phone number is changed");
            break;
        }

    }

    // this method give chance to send message to other students, and that messages will save in message storage
    private static void sendMessage() {
        STUDENT_STORAGE.printStudents();
        STUDENT_STORAGE.printEmails();
        try {
            String mess = SCANNER.nextLine();
            String[] messageData = mess.split(",");
            Message message = new Message(currentUser.getEmail(), messageData[0], messageData[1], new Date(), false);
            MESSAGE_STORAGE.add(message);
        } catch (NumberFormatException e) {
            System.out.println("invalid data");
            sendMessage();
        }
    }

    // this method print all messages
    private static void viewAllMessages() {
        MESSAGE_STORAGE.printMessages();
    }

    // this method print the messages to whom is sent
    private static void showUserMessagesByEmail() {
        boolean isNoMessages = true;
        for (int i = 0; i < MESSAGE_STORAGE.getSize(); i++) {
            if (MESSAGE_STORAGE.getMessage(i).getTo().equalsIgnoreCase(currentUser.getEmail()) && (MESSAGE_STORAGE.getMessage(i).isRead() == false)) {
                MESSAGE_STORAGE.getMessage(i).setRead(true);
                System.out.println(MESSAGE_STORAGE.getMessage(i).toString());
                isNoMessages = false;
            }
        }
        if (isNoMessages) {
            System.out.println("You have no messages");
        }
    }

    // this method print admin's commands
    private static void printAdminCommand() {
        System.out.println("Please input " + ADD_LESSON + " for adding lesson");
        System.out.println("Please input " + ADD_STUDENT + " for adding students");
        System.out.println("Please input " + PRINT_LESSONS + " for printing lessons ");
        System.out.println("Please input " + PRINT_STUDENTS + " for printing students");
        System.out.println("Please input " + CHANGE_STUDENT_LESSON + " for changing student's lesson");
        System.out.println("Please input " + PRINT_STUDENTS_BY_LESSON_NAME + " for printing students by lesson name");
        System.out.println("Please enter " + EXIT + " for Exit");

    }

    // this method print student's commands
    private static void printStudentCommand() {

        System.out.println("Please input " + PRINT_NEW_MESSAGES + " for viewing new messages");
        System.out.println("Please input " + CHANGE_PASSWORD + " for changing password");
        System.out.println("please input " + CHANGE_MY_LESSON + " for changing lesson");
        System.out.println("Please input " + PRINT_MY_LESSON + " for printing lesson");
        System.out.println("Please input " + CHANGE_MY_DATA + " for changing data");
        System.out.println("Please input " + SEND_MESSAGE + " for sending message");
        System.out.println("Please input " + VIEW_MESSAGES + " for viewing all messages");
        System.out.println("Please input " + LOG_OUT + " for log out");


    }

    // this method print user's commands
    private static void printUserCommands() {
        System.out.println("Please enter " + EXIT + " for Exit");
        System.out.println("Please enter " + LOGIN + " for Login");

    }


}
