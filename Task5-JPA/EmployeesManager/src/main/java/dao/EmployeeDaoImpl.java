package dao;

import core.EntityManagerCreator;
import model.Employee;

import javax.persistence.EntityManager;

/**
 * Created by Natallia_Rakitskaya.
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private EntityManager em = EntityManagerCreator.createEntityManager();

    public void begin() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }

    public void createEmployee(Employee employee) {
        em.persist(employee.getPersonalInfo());
        em.persist(employee);
        employee.getPersonalInfo().setEmployee(employee);
        em.merge(employee.getPersonalInfo());
    }

    public Employee findEmployeeById(Long id) {
        return em.find(Employee.class, id);
    }

    public void deleteEmployee(Employee employee) {
        Employee mergedEmployee = em.merge(employee);
        em.remove(mergedEmployee);
    }

    public void updateEmployee(Employee employee) {
        em.merge(employee);
    }
}
