package model;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

/**
 * Created by Natallia_Rakitskaya.
 */
@Entity
public class EmployeePersonalInfo {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "personal_info_id")
    private Long id;

    @OneToOne(mappedBy = "employeePersonalInfo")
    private Employee employee;

    private String coreSkill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoreSkill() {
        return coreSkill;
    }

    public void setCoreSkills(String coreSkill) {
        this.coreSkill = coreSkill;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
