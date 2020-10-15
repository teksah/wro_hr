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
    private List<EmployerEmployee> employerEmployee = new ArrayList<>();

    public void addEmployeeEmployer(EmployerEmployee employerEmployee) {
        this.employerEmployee.add(employerEmployee);
        employerEmployee.setJobTitle(this);
    }
    public void removeEmployeeEmployer(EmployerEmployee employerEmployee) {
        this.employerEmployee.remove(employerEmployee);
        employerEmployee.setJobTitle(null);
    }

}
