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
    private List<EmployerEmployee> employees = new ArrayList<>();

    public void addEmployee(Employee employee, JobTitle jobTitle, LocalDate signDate, LocalDate startDate, LocalDate expirationDate, LocalDate endDate) {
        EmployerEmployee employerEmployee = new EmployerEmployee(employee, this, jobTitle, signDate, startDate, expirationDate, endDate);
        employees.add(employerEmployee);
        jobTitle.addEmployeeEmployer(employerEmployee);
        employee.getEmployers().add(employerEmployee);
    }
}
