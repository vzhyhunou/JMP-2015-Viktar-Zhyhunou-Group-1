import dao.*;
import model.*;

/**
 * Created by Natallia_Rakitskaya.
 */
public class App {
    public static void main(String[] args) {
        ProjectDao projectDao = new ProjectDaoImpl();
        UnitDao unitDao = new UnitDaoImpl();
        EmployeeDao employeeDao = new EmployeeDaoImpl();

        //create project
        Project project = new Project();
        project.setName("IHG");

        projectDao.createProject(project);

        Project projectResult = projectDao.findProjectById(1L);

        //create unit
        Unit unit = new Unit();
        unit.setName("Testing Team 5");

        unitDao.createUnit(unit);

        Unit unitResult = unitDao.findUnitById(1L);

        //create employee
        Employee employee = new Employee();
        employee.setFirstName("Natallia");
        employee.setLastName("Rakitskaya");
        employee.setStatus(EmployeeStatus.FULL_TIME_EMPLOYEE);

        Address address = new Address();
        address.setCity("Brest");
        address.setStreet("Moskovskaya");
        employee.setAddress(address);

        EmployeePersonalInfo personalInfo = new EmployeePersonalInfo();
        personalInfo.setCoreSkills("Automated testing");
        employee.setPersonalInfo(personalInfo);

        employeeDao.createEmployee(employee);

        Employee employeeResult = employeeDao.findEmployeeById(1L);

        //assign employee to project
        projectDao.assignEmployee(1L, 1L);

        //add employee to unit
        unitDao.addEmployee(1L, 1L);

        //remove objects
        projectDao.deleteProject(project);
        unitDao.deleteUnit(unit);
        employeeDao.deleteEmployee(employee);
        employeeResult = employeeDao.findEmployeeById(1L);
    }
}
