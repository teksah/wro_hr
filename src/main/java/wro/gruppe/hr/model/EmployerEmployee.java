package wro.gruppe.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class EmployerEmployee extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employer employer;

    @ManyToOne(fetch = FetchType.LAZY)
    private JobTitle jobTitle;

    private LocalDate signDate;
    private LocalDate startDate;
    private LocalDate expirationDate;
    private LocalDate endDate;

    private boolean active;

    public EmployerEmployee(Employee employee, Employer employer, JobTitle jobTitle, LocalDate signDate, LocalDate startDate, LocalDate expirationDate, LocalDate endDate) {
        this.active = true;
        this.employee = employee;
        this.employer = employer;
        this.jobTitle = jobTitle;
        this.signDate = signDate;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
        this.endDate = endDate;
    }
}
