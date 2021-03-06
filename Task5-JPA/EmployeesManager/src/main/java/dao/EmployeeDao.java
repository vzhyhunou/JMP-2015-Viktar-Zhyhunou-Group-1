package dao;

import model.Employee;

/**
 * Created by Natallia_Rakitskaya.
 */
public interface EmployeeDao {

    public void begin();

    public void commit();

    public void createEmployee(Employee employee);

    public Employee findEmployeeById(Long id);

    public void deleteEmployee(Employee employee);

    public void updateEmployee(Employee employee);
}
