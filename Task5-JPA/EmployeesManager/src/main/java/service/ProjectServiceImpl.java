package service;

import dao.ProjectDao;
import dao.ProjectDaoImpl;
import model.Project;

/**
 * Created by Natallia_Rakitskaya.
 */
public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao = new ProjectDaoImpl();

    public void createProject(Project project) {
        projectDao.begin();
        projectDao.createProject(project);
        projectDao.commit();
    }

    public Project findProjectById(Long id) {
        return projectDao.findProjectById(id);
    }

    public void deleteProject(Project project) {
        projectDao.begin();
        projectDao.deleteProject(project);
        projectDao.commit();
    }

    public void updateProject(Project project) {
        projectDao.begin();
        projectDao.updateProject(project);
        projectDao.commit();
    }

    public void assignEmployee(Long projectId, Long employeeId) {
        projectDao.begin();
        projectDao.assignEmployee(projectId, employeeId);
        projectDao.commit();
    }
}
