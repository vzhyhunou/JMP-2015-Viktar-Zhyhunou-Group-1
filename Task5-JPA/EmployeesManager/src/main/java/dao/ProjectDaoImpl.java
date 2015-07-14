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

    @Override
    public void createProject(Project project) {
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();
    }

     @Override
     public Project findProjectById(Long id) {
        return em.find(Project.class, id);
    }

    @Override
    public void deleteProject(Project project) {
        em.getTransaction().begin();
        Project mergedProject = em.merge(project);
        em.remove(mergedProject);
        em.getTransaction().commit();
    }

    @Override
    public void updateProject(Project project) {
        em.getTransaction().begin();
        em.merge(project);
        em.getTransaction().commit();
    }

    @Override
    public void assignEmployee(Long projectId, Long employeeId) {
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, employeeId);
        Project project = em.find(Project.class, projectId);
        project.getEmployees().add(employee);
        em.merge(project);
        em.getTransaction().commit();
    }
}
