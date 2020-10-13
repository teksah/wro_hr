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
public class TaxOffice extends BaseEntity {

    private String taxOffice;

    @OneToMany(
            mappedBy = "taxOffice",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        employee.setTaxOffice(this);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
        employee.setTaxOffice(null);
    }
}
