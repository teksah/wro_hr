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
public class Citizenship extends BaseEntity {

    private String citizenship;

    @OneToMany(
            mappedBy = "citizenship",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        employee.setCitizenship(this);
    }
    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
        employee.setCitizenship(this);
    }
}
