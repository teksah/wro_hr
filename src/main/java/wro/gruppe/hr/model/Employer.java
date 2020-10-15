package wro.gruppe.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Employer extends BaseEntity {
    private String companyName;

    @OneToMany(
            mappedBy = "employer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EmployeeEmployer> employees = new ArrayList<>();

    public void addEmployee(Employee employee, JobTitle jobTitle, LocalDate contractSignDate, LocalDate contractStartDate, LocalDate contractExpirationDate, LocalDate contractEndDate) {
        EmployeeEmployer employeeEmployer = new EmployeeEmployer(employee, this, jobTitle, contractSignDate, contractStartDate, contractExpirationDate, contractEndDate);
        employees.add(employeeEmployer);
        jobTitle.addEmployeeEmployer(employeeEmployer);
        employee.getEmployers().add(employeeEmployer);
    }
}
