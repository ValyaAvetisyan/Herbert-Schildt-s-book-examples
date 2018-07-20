package taskManagement;


import taskManagement.commands.LoginExit;
import taskManagement.commands.ManagerCommands;
import taskManagement.commands.UserCommand;
import taskManagement.model.Comment;
import taskManagement.model.Project;
import taskManagement.model.Task;
import taskManagement.model.User;
import taskManagement.storage.CommentStorage;
import taskManagement.storage.ProjectStorage;
import taskManagement.storage.TaskStorage;
import taskManagement.storage.UserStorage;
import taskManagement.enams.UserType;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Management implements ManagerCommands, UserCommand, LoginExit {
    private static final UserStorage USER_STORAGE = new UserStorage();
    private static final TaskStorage TASK_STORAGE = new TaskStorage();
    private static final ProjectStorage PROJECT_STORAGE = new ProjectStorage();
    private static final CommentStorage COMMENT_STORAGE = new CommentStorage();
    private static final Scanner SCANNER = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static User currentUser = null;

    public static void main(String[] args) {
        USER_STORAGE.add(new User("name", "surname", "email", "password",UserType.MANAGER));
        runApplication();
    }

    /**
     * this method contains exit and login commands
     */
    private static void runApplication() {
        boolean isRun = true;
        while (isRun) {
            printCommands();
            int userCommands = Integer.parseInt(SCANNER.nextLine());
            switch (userCommands) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    logIn();
                    break;
            }

        }

    }

    // this method contains both manager and user commands
    private static void mainCommands() throws ParseException {
        boolean isLogged = true;
        while (isLogged) {
            if (currentUser.getType()==(UserType.MANAGER)) {
                printManagerCommands();
                ;
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
                        break;
                    case AddProject:
                        addProject();
                        break;
                    case AddUser:
                        addUser();
                        break;
                    case ADDTask:
                        addTask();
                        break;
                    case PrintAllTasks:
                        TASK_STORAGE.printTasks();
                        break;
                    case PrintAllUsers:
                        USER_STORAGE.printUsers();
                        break;
                    case PrintTasksByStatus:
                        printTasksByStatus();
                        break;
                    case ManagerCommands.AddComment:
                        addComment();
                        break;
                    default:
                        System.out.println("Please input a valid command");
                }
            } else {
                printUserCommands();

                int command = 0;
                try {
                    command = Integer.parseInt(SCANNER.nextLine());
                } catch (NumberFormatException e) {
                    command = -1;
                }
                switch (command) {
                    case UserCommand.LOGOUT:
                        break;
                    case PrintMyNewTasks:
                        TASK_STORAGE.printNewTask();
                        break;
                    case PrintMyCurrentTasks:
                        TASK_STORAGE.printInProgressTask();
                        break;
                    case PrintMyFinishedTasks:
                        TASK_STORAGE.printFinishedTask();
                        break;
                    case ChangeMyTaskStatusByName:
                        changeStatusByTaskName();
                        break;
                    case ChangeMyTaskEstimationsByName:
                        changeEstimateByTaskName();
                        break;
                    case AddComments:
                        addComment();
                        break;
                    default:
                        System.out.println("Please input a valid command");


                }

            }
        }
    }

    // this method is for login
    private static void logIn() {
        System.out.println("please input username, password");
        try {
            String userNameAndPassword = SCANNER.nextLine();
            String[] loginData = userNameAndPassword.split(",");
            User user = USER_STORAGE.getEmailAndPassword(loginData[0], loginData[1]);
            if (user == null) {
                System.out.println("wrong username or password");
            } else {
                currentUser = user;
                mainCommands();

            }
        } catch (NullPointerException b) {
            System.out.println("invalid data");
            logIn();
        } catch (ParseException e) {
            System.out.println("parse exception");
        }
    }

    //this method is for adding project
    private static void addProject() throws ParseException {
        System.out.println("Please input project's name,price,startDate,endDate");
        String projectData = SCANNER.nextLine();
        try {
            String[] splitProjects = projectData.split(",");
            double price = Double.parseDouble(splitProjects[1]);
            Project project = new Project();
            project.setName(splitProjects[0]);
            project.setPrice(price);
            project.setStartDate(sdf.parse(splitProjects[2]));
            project.setEndDate(sdf.parse(splitProjects[3]));
            PROJECT_STORAGE.add(project);
            SerializeUtil.addProjectToStorage(project);
            PROJECT_STORAGE.printProject();
        } catch (Exception e) {
            System.out.println("invalid Data");
        }
    }

    // this method is for adding user in system
    private static void addUser() {
        System.out.println("Please input user's name, surname, email, password,");
        String userStr = SCANNER.nextLine();
        try {
            String[] splitUser = userStr.split(",");
            User user = new User();
            user.setName(splitUser[0]);
            user.setSurname(splitUser[1]);
            user.setEmail(splitUser[2]);
            user.setPassword(splitUser[3]);
            user.setType(UserType.USER);
            USER_STORAGE.add(user);
            SerializeUtil.addUserToStorage(user);
            System.out.println("User is successfully added");

        } catch (Exception e) {
            System.out.println("invalid Data");
            addUser();
        }
    }

    // this method is for adding tasks for users,
    // and task should have a project
    private static void addTask() {
        System.out.println("Please input task's title, description, estimate, assignTo, status");
        String taskStr = SCANNER.nextLine();
        String[] splitTask = taskStr.split(",");
        long estimate = Long.parseLong(splitTask[2]);

        try {
            System.out.println("Please input project name");
            PROJECT_STORAGE.printProject();
            String projectName = SCANNER.nextLine();
            Project project = PROJECT_STORAGE.getProjectByName(projectName);
            Task task = new Task();
            task.setTitle(splitTask[0]);
            task.setDescription(splitTask[1]);
            task.setEstimate(estimate);
            task.setAssignTo(splitTask[3]);
            task.setCreatedDate(new Date());
            task.setStatus(splitTask[4]);
            task.setProject(project);
            TASK_STORAGE.add(task);
            SerializeUtil.addTaskToStorage(task);
            System.out.println("the task is successfully added");
        } catch (Exception e) {
            System.out.println("invalid data");
            addTask();
        }
    }
//this method is for adding comments on tasks
    private static void addComment() {
        System.out.println("Please input comment's text,task");
        String comData = SCANNER.nextLine();
        try {
            String[] splitComms = comData.split(",");
            Task task = TASK_STORAGE.printTaskByTitle(splitComms[1]);
            Comment comment = new Comment();
            comment.setText(splitComms[0]);
            comment.setCommentedUser(currentUser);
            comment.setTask(task);
            comment.setCommentedDate(new Date());
            COMMENT_STORAGE.add(comment);
            SerializeUtil.addCommentToStorage(comment);
            COMMENT_STORAGE.printComments();
        } catch (Exception e) {
            System.out.println("invalid data");
            addComment();
        }
    }


    // this method is for showing task by given status
    private static void printTasksByStatus() {
        System.out.println("Please input status");
        TASK_STORAGE.printTaskByStatus(SCANNER.nextLine());

    }

    // this method allows to change the status by giving task's name
    private static void changeStatusByTaskName() {
        TASK_STORAGE.changeStatusByTaskName();
    }

    // this method allows to change task's duration by giving task's name
    private static void changeEstimateByTaskName() {
        TASK_STORAGE.changeEstimateByTaskName();


    }

    // this method prints user commands
    private static void printUserCommands() {
        System.out.println("Please input " + UserCommand.LOGOUT + " for logout");
        System.out.println("Please input " + PrintMyNewTasks + " for showing new tasks");
        System.out.println("Please input " + PrintMyCurrentTasks + " for showing current tasks");
        System.out.println("Please input " + PrintMyFinishedTasks + " for showing finished tasks");
        System.out.println("Please input " + ChangeMyTaskStatusByName + " for changing task's status");
        System.out.println("Please input " + ChangeMyTaskEstimationsByName + " for changing task's duration");
        System.out.println("Please input " + UserCommand.AddComments + " for adding comments");

    }

    //this method prints manager commands
    private static void printManagerCommands() {
        System.out.println("Please input " + ManagerCommands.LOGOUT + " for logout");
        System.out.println("Please input " + AddProject + " for adding project");
        System.out.println("Please input " + AddUser + " for adding user");
        System.out.println("Please input " + ADDTask + " for adding task");
        System.out.println("Please input " + PrintAllTasks + " for showing all tasks");
        System.out.println("Please input " + PrintAllUsers + " for showing all user");
        System.out.println("Please input " + PrintTasksByStatus + " for showing tasks by status");
        System.out.println("Please input " + ManagerCommands.AddComment + " for adding comments");
    }

    //this method prints exit and login commands
    private static void printCommands() {
        System.out.println("Please input " + EXIT + " for exit");
        System.out.println("Please input " + LOGIN + " for login");
    }
}

