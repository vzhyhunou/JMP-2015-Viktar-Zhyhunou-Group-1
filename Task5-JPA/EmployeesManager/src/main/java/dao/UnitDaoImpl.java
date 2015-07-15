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

    public void begin() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }

    public void createUnit(Unit unit) {
        em.persist(unit);
    }

    public Unit findUnitById(Long id) {
        return em.find(Unit.class, id);
    }

    public void deleteUnit(Unit unit) {
        Unit mergedUnit = em.merge(unit);
        em.remove(mergedUnit);
    }

    public void updateUnit(Unit unit) {
        em.merge(unit);
    }

    public void addEmployee(Long unitId, Long employeeId) {
        Unit unit = em.find(Unit.class, unitId);
        Employee employee = em.find(Employee.class, employeeId);
        unit.getEmployees().add(employee);
        em.merge(unit);
    }
}
