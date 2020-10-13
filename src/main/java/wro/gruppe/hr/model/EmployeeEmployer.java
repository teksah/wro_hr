package wro.gruppe.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class EmployeeEmployer {

    @EmbeddedId
    private EmployeeEmployerId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("employeeId")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("employerId")
    private Employer employer;

    @ManyToOne(fetch = FetchType.LAZY)
    private JobTitle jobTitle;

    private LocalDate contractSignDate;
    private LocalDate contractStartDate;
    private LocalDate contractExpirationDate;

    public EmployeeEmployer(Employee employee, Employer employer, JobTitle jobTitle, LocalDate contractSignDate, LocalDate contractStartDate, LocalDate contractExpirationDate) {
        this.employee = employee;
        this.employer = employer;
        this.jobTitle = jobTitle;
        this.contractSignDate = contractSignDate;
        this.contractStartDate = contractStartDate;
        this.contractExpirationDate = contractExpirationDate;
    }
}
