package taskManagement.storage;

import taskManagement.enams.StatusType;
import taskManagement.model.Task;
import taskManagement.model.User;


import java.util.*;

public class TaskStorage {
    Scanner scanner = new Scanner(System.in);
    private List<Task> tasks = new LinkedList<>();
    private static Collections collections;

    //this method adds tasks in storage

    public void add(Task task) {
        tasks.add(task);

    }

    // this method prints all tasks
    public void printTasks() {
        for (Task task : tasks) {
            System.out.println(task);

        }
    }

    public Task printTaskByTitle(String name) {
        for (Task task : tasks) {
           if( task.getTitle().equals(name)){
                return task;
            }
        }
return null;
    }


    public void printTaskByUser(User user) {
        collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        for (Task task : tasks) {
            if (task.getAssignTo().equals(user))
                System.out.println(task);

        }
    }

    //this method prints tasks by given status
    public void printTaskByStatus(String task) {
        for (Task task1 : tasks) {
            if (task1.getStatus().equals(task)) {
                System.out.println(task1);
                break;
            }
        }
    }

    // this method prints only the tasks by status of new
    public void printNewTask() {
        for (Task task : tasks) {
            if (task.getStatus().equalsIgnoreCase(StatusType.NEW.name())) {
                System.out.println(task);
            }
        }
    }

    // this method prints only the tasks by status of in progress
    public void printInProgressTask() {
        for (Task task : tasks) {
            if (task.getStatus().equalsIgnoreCase(StatusType.IN_PROGRESS.name())) {
                System.out.println(task);
            }
        }
    }

    // this method prints only the tasks by status of finished
    public void printFinishedTask() {
        for (Task task : tasks) {
            if (task.getStatus().equalsIgnoreCase(StatusType.FINISHED.name())) {
                System.out.println(task);
            }
        }
    }

    //this method helps to change task duration by giving task's title
    public void changeEstimateByTaskName() {
        System.out.println("Please input task's name");
        String name = scanner.nextLine();
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(name)) {
                printTasks();
            } else if (task.getTitle() == null) {
                System.out.println("wrong title, please try again");
                changeEstimateByTaskName();
                {

                    System.out.println("Please input new time duration");
                    int estimate = scanner.nextInt();
                    task.setEstimate(estimate);
                    System.out.println("Your task duration is changed");
                    break;
                }
            }
        }
    }

    //this method change task's status by giving task title
    public void changeStatusByTaskName() {
        System.out.println("Please input task's name");
        String name = scanner.nextLine();
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(name)) {
                printTasks();
            } else if (task.getTitle() == null) {
                System.out.println("wrong title, please try again");
                changeStatusByTaskName();
            }

            System.out.println("Please input new status");
            String status = scanner.nextLine();
            task.setStatus(status);
            System.out.println("your status is changed");
            break;
        }
    }
}
