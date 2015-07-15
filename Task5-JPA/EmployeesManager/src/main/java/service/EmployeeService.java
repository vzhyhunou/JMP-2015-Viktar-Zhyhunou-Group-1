package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.Employee;

/**
 * Created by Natallia_Rakitskaya.
 */
public interface EmployeeService {

    public void createEmployee(Employee employee);

    public Employee findEmployeeById(Long id);

    public void deleteEmployee(Employee employee);

    public void updateEmployee(Employee employee);
}
