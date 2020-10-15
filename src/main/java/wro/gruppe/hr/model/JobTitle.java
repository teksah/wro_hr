package wro.gruppe.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class JobTitle extends BaseEntity {
    private String jobTitle;

    @OneToMany(
            mappedBy = "jobTitle",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EmployeeEmployer> employeeEmployer = new ArrayList<>();

    public void addEmployeeEmployer(EmployeeEmployer employeeEmployer) {
        this.employeeEmployer.add(employeeEmployer);
        employeeEmployer.setJobTitle(this);
    }
    public void removeEmployeeEmployer(EmployeeEmployer employeeEmployer) {
        this.employeeEmployer.remove(employeeEmployer);
        employeeEmployer.setJobTitle(null);
    }

}
