package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.Employee;

/**
 * Created by Natallia_Rakitskaya.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    public void createEmployee(Employee employee) {
        employeeDao.begin();
        employeeDao.createEmployee(employee);
        employeeDao.commit();
    }

    public Employee findEmployeeById(Long id) {
        return employeeDao.findEmployeeById(id);
    }

    public void deleteEmployee(Employee employee) {
        employeeDao.begin();
        employeeDao.deleteEmployee(employee);
        employeeDao.commit();
    }

    public void updateEmployee(Employee employee) {
        employeeDao.begin();
        employeeDao.updateEmployee(employee);
        employeeDao.commit();
    }
}
