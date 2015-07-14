package model;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

/**
 * Created by Natallia_Rakitskaya.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "employee_id")
    private Long id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @Embedded
    private Address address;

    @OneToOne
    @JoinColumn(name = "personal_info_id")
    private EmployeePersonalInfo employeePersonalInfo;

    @ManyToMany
    @JoinTable(name = "employees_projects", joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projects;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public EmployeePersonalInfo getPersonalInfo() {
        return employeePersonalInfo;
    }

    public void setPersonalInfo(EmployeePersonalInfo personalInfo) {
        this.employeePersonalInfo = personalInfo;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
