package dao;

import core.EntityManagerCreator;
import model.Employee;
import model.Unit;

import javax.persistence.EntityManager;

/**
 * Created by Natallia_Rakitskaya.
 */
public class UnitDaoImpl implements UnitDao {
    private EntityManager em = EntityManagerCreator.createEntityManager();

    @Override
    public void createUnit(Unit unit) {
        em.getTransaction().begin();
        em.persist(unit);
        em.getTransaction().commit();
    }

    @Override
    public Unit findUnitById(Long id) {
        return em.find(Unit.class, id);
    }

    @Override
    public void deleteUnit(Unit unit) {
        em.getTransaction().begin();
        Unit mergedUnit = em.merge(unit);
        em.remove(mergedUnit);
        em.getTransaction().commit();
    }

    @Override
    public void updateUnit(Unit unit) {
        em.getTransaction().begin();
        em.merge(unit);
        em.getTransaction().commit();
    }
    
    @Override
    public void addEmployee(Long unitId, Long employeeId) {
        em.getTransaction().begin();
        Unit unit = em.find(Unit.class, unitId);
        Employee employee = em.find(Employee.class, employeeId);
        unit.getEmployees().add(employee);
        em.merge(unit);
        em.getTransaction().commit();
    }
}
