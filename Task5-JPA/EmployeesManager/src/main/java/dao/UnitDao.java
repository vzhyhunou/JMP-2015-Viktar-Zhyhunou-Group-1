package dao;

import model.Unit;

/**
 * Created by Natallia_Rakitskaya.
 */
public interface UnitDao {

    public void begin();

    public void commit();

    public void createUnit(Unit unit);

    public Unit findUnitById(Long id);

    public void deleteUnit(Unit unit);

    public void updateUnit(Unit unit);

    public void addEmployee(Long unitId, Long employeeId);
}
