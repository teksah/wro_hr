package wro.gruppe.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Employer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;


    @OneToMany(
            mappedBy = "employer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EmployeeEmployer> employees;

    public void addEmployee(Employee employee, LocalDate sign, LocalDate start, LocalDate expiration, JobTitle jobTitle) {
        EmployeeEmployer employeeEmployer = new EmployeeEmployer(employee, this, jobTitle, sign, start, expiration);
        employees.add(employeeEmployer);
        employee.getEmployers().add(employeeEmployer);
    }
}
