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
public class MartialStatus extends BaseEntity {
    private String martialStatus;

    @OneToMany(
            mappedBy = "martialStatus",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Employee> employees = new ArrayList<>();

    private void addEmployee(Employee employee) {
        this.employees.add(employee);
        employee.setMartialStatus(this);
    }
    private void removeEmployee(Employee employee) {
        this.employees.remove(employee);
        employee.setMartialStatus(null);
    }




}
