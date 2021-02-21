package com.company;

import java.util.List;

public class Controller {
    private final InterfaceProjectRes repo;

    public Controller(InterfaceProjectRes repo) {
        this.repo = repo;
    }

    public String createProject(String name,int totalCost) {
        Project project = new Project(name, totalCost);

        boolean created = repo.createProject(project);

        return (created ? "Project was created!" : "Project creation was failed!");
    }

    public String getProject(int id) {
        Project user = repo.getProject(id);

        return (user == null ? "Project was not found!" : user.toString());
    }

    public String getAllProjects() {
        List<Project> users = repo.getAllProjects();

        return users.toString();
    }
}
