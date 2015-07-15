package service;

import dao.UnitDao;
import dao.UnitDaoImpl;
import model.Unit;

/**
 * Created by Natallia_Rakitskaya.
 */
public class UnitServiceImpl implements UnitService {

    UnitDao unitDao = new UnitDaoImpl();

    public void createUnit(Unit unit) {
        unitDao.begin();
        unitDao.createUnit(unit);
        unitDao.commit();
    }

    public Unit findUnitById(Long id) {
        return unitDao.findUnitById(id);
    }

    public void deleteUnit(Unit unit) {
        unitDao.begin();
        unitDao.deleteUnit(unit);
        unitDao.commit();
    }

    public void updateUnit(Unit unit) {
        unitDao.begin();
        unitDao.updateUnit(unit);
        unitDao.commit();
    }

    public void addEmployee(Long unitId, Long employeeId) {
        unitDao.begin();
        unitDao.addEmployee(unitId, employeeId);
        unitDao.commit();
    }
}
