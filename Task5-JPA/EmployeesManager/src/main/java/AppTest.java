import model.*;
import org.junit.Before;
import org.junit.Test;
import service.*;

import static org.junit.Assert.*;

/**
 * Created by Natallia_Rakitskaya.
 */
public class AppTest {

    ProjectService projectService = new ProjectServiceImpl();
    UnitService unitService = new UnitServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void addEmployeeAndAssignTest() {

        //create project
        Project project = new Project();
        project.setName("IHG");

        projectService.createProject(project);

        assertNotNull(projectService.findProjectById(1L));


        //create unit
        Unit unit = new Unit();
        unit.setName("Testing Team 5");

        unitService.createUnit(unit);

        assertNotNull(unitService.findUnitById(1L));

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

        employeeService.createEmployee(employee);

        assertNotNull(employeeService.findEmployeeById(1L));

        //assign employee to project
        projectService.assignEmployee(1L, 1L);

        //add employee to unit
        unitService.addEmployee(1L, 1L);

        Unit unitEmp = unitService.findUnitById(1L);
        assertTrue(unitEmp.getEmployees().size() == 1);

        Project projectEmp = projectService.findProjectById(1L);
        assertTrue(projectEmp.getEmployees().size() == 1);

        //remove objects
        projectService.deleteProject(project);
        unitService.deleteUnit(unit);
        employeeService.deleteEmployee(employee);
        assertNull(employeeService.findEmployeeById(1L));
    }


}
