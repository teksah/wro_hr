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

    public void addEmployee(Employee employee, LocalDate sign, LocalDate start, LocalDate expiration, JobTitle jobTitle) {
        EmployeeEmployer employeeEmployer = new EmployeeEmployer(employee, this, jobTitle, sign, start, expiration);
        employees.add(employeeEmployer);
        employee.getEmployers().add(employeeEmployer);
    }
}
