package dao;

import core.EntityManagerCreator;
import model.Employee;
import model.Project;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natallia_Rakitskaya.
 */
public class ProjectDaoImpl implements ProjectDao {
    private EntityManager em = EntityManagerCreator.createEntityManager();

    public void begin() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }

    public void createProject(Project project) {
        em.persist(project);
    }

     public Project findProjectById(Long id) {
        return em.find(Project.class, id);
    }

    public void deleteProject(Project project) {
        Project mergedProject = em.merge(project);
        em.remove(mergedProject);
    }

    public void updateProject(Project project) {
        em.merge(project);
    }

    public void assignEmployee(Long projectId, Long employeeId) {
        Employee employee = em.find(Employee.class, employeeId);
        Project project = em.find(Project.class, projectId);
        project.getEmployees().add(employee);
        em.merge(project);
    }
}
