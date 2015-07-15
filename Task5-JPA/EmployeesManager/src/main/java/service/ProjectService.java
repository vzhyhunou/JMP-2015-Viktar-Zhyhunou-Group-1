package service;

import model.Project;

/**
 * Created by Natallia_Rakitskaya.
 */
public interface ProjectService {

    public void createProject(Project project);

    public Project findProjectById(Long id);

    public void deleteProject(Project project);

    public void updateProject(Project project);

    public void assignEmployee(Long projectId, Long employeeId);

}
