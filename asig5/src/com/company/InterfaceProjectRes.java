package com.company;
import com.company.Project;
import java.util.List;

public interface InterfaceProjectRes {
    boolean createProject(Project project);
    Project getProject(int id);
    List<Project> getAllProjects();
}
