package taskManagement;

import taskManagement.model.Comment;
import taskManagement.model.Project;
import taskManagement.model.Task;
import taskManagement.model.User;

import java.io.*;
import java.util.*;

/**
 * Utility class for storage operations
 */
public class SerializeUtil {
    private static final String FOLDER_LOCATION = "C:\\storage\\";
    private static final String USER_STORAGE_FILE_NAME = "userStorage";
    private static final String PROJECT_STORAGE_FILE_NAME = "projectStorage";
    private static final String TASK_STORAGE_FILE_NAME = "taskStorage";
    private static final String COMMENT_STORAGE_FILE_NAME = "commentStorage";

    private SerializeUtil() {
    }

    //this method is for adding tasks to storage file
    public static void addTaskToStorage(Task task) throws IOException, ClassNotFoundException {
        List<Task> taskList = getTaskStorage();
        taskList.add(task);
        FileOutputStream fos = new FileOutputStream(checkStorageFile(TASK_STORAGE_FILE_NAME));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(taskList);
        oos.flush();
        oos.close();
    }

    //this method is for getting task storage
    public static List<Task> getTaskStorage() throws IOException, ClassNotFoundException {
        checkStorageFolder();
        FileInputStream fis = new FileInputStream(checkStorageFile(TASK_STORAGE_FILE_NAME));
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(fis);

        } catch (EOFException e) {
            return new LinkedList<>();
        }
        List<Task> tasks = (List<Task>) ois.readObject();
        if (tasks == null) {
            return new LinkedList<>();
        }
        return tasks;
    }

    //this method is for adding user to storage file
    public static void addUserToStorage(User user) throws IOException, ClassNotFoundException {
        Map<String, User> userMap = getUserStorage();
        userMap.put(user.getEmail(), user);
        FileOutputStream fos = new FileOutputStream(checkStorageFile(USER_STORAGE_FILE_NAME));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(userMap);
        oos.flush();
        oos.close();
    }

    //this method is for getting user storage
    public static Map<String, User> getUserStorage() throws IOException, ClassNotFoundException {
        checkStorageFolder();
        FileInputStream fis = new FileInputStream(checkStorageFile(USER_STORAGE_FILE_NAME));
        ObjectInputStream oin;
        try {
            oin = new ObjectInputStream(fis);
        } catch (EOFException e) {
            return new HashMap<>();
        }
        Map<String, User> users = (Map<String, User>) oin.readObject();
        if (users == null) {
            return new HashMap<>();
        }
        return users;
    }

    // this method is for calling fileOutputStream and add project to that file
    public static void addProjectToStorage(Project project) throws IOException, ClassNotFoundException {
        Set<Project> projectSet = getProjectStorage();
        projectSet.add(project);
        FileOutputStream fos = new FileOutputStream(checkStorageFile(PROJECT_STORAGE_FILE_NAME));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(projectSet);
        oos.flush();
        oos.close();
    }

    // this method is for getting project
    public static Set<Project> getProjectStorage() throws IOException, ClassNotFoundException {
        checkStorageFolder();
        FileInputStream fis = new FileInputStream(checkStorageFile(PROJECT_STORAGE_FILE_NAME));
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(fis);
        } catch (EOFException e) {
            return new HashSet<>();
        }
        Set<Project> projects = (Set<Project>) ois.readObject();
        if (projects == null) {
            return new HashSet<>();
        }
        return projects;

    }
// this is for adding Comment to storage file
    public static void addCommentToStorage(Comment comment) throws IOException, ClassNotFoundException {
        Map<Task, List<Comment>> commentMap = getCommentStorage();
        List<Comment> commentList = new ArrayList<>();
        commentMap.put(comment.getTask(), commentList);
        FileOutputStream fos = new FileOutputStream(checkStorageFile(COMMENT_STORAGE_FILE_NAME));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(commentMap);
        oos.flush();
        oos.close();

    }
    //this method is for getting Comments
    public static Map<Task, List<Comment>> getCommentStorage() throws IOException, ClassNotFoundException {
        checkStorageFolder();
        FileInputStream fis = new FileInputStream(checkStorageFile(COMMENT_STORAGE_FILE_NAME));
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(fis);
        } catch (EOFException e) {
            return new HashMap<>();
        }
        Map<Task, List<Comment>> comments = (Map<Task, List<Comment>>) ois.readObject();
        if (comments == null) {
            return new HashMap<>();
        }
        return comments;
    }
// this method is for checking and creating file
    private static File checkStorageFile(String fileName) throws IOException {
        File file = new File(FOLDER_LOCATION + fileName);
        file.createNewFile();
        return file;
    }
// this method is for checking and creating folder for storage
    private static void checkStorageFolder() {
        File storageFolder = new File(FOLDER_LOCATION);
        if (!storageFolder.exists() || storageFolder.isFile()) {
            storageFolder.mkdir();
        }
    }
}
