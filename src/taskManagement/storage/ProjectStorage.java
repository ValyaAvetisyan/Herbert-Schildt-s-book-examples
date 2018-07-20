package taskManagement.storage;

import taskManagement.model.Project;

import java.util.HashSet;
import java.util.Set;

public class ProjectStorage {
    Set<Project> projects = new HashSet<>();

    public void add(Project project) {
        projects.add(project);
    }

    public void printProject() {
        for (Project project : projects) {
            System.out.println(project);
        }
    }

    public Project getProjectByName(String name) {
        for (Project project : projects) {
            if (project.getName().equals(name)) {
                return project;
            }
        }
        return null;
    }
}

