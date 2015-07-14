package dao;

import core.EntityManagerCreator;
import model.Employee;

import javax.persistence.EntityManager;

/**
 * Created by Natallia_Rakitskaya.
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private EntityManager em = EntityManagerCreator.createEntityManager();

    @Override
    public void createEmployee(Employee employee) {
        em.getTransaction().begin();
        em.persist(employee.getPersonalInfo());
        em.persist(employee);
        employee.getPersonalInfo().setEmployee(employee);
        em.merge(employee.getPersonalInfo());
        em.getTransaction().commit();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return em.find(Employee.class, id);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        em.getTransaction().begin();
        Employee mergedEmployee = em.merge(employee);
        em.remove(mergedEmployee);
        em.getTransaction().commit();
    }

    @Override
    public void updateEmployee(Employee employee) {
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
    }
}
