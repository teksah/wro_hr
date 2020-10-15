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
public class AddressType extends BaseEntity{
    private String addressType;

    @OneToMany(
            mappedBy = "addressType",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EmployeeAddress> employeeAddress = new ArrayList<>();

    public void addAddressEmployee(EmployeeAddress employeeAddress) {
        this.employeeAddress.add(employeeAddress);
        employeeAddress.setAddressType(this);
    }
    public void removeAddressEmployee(EmployeeAddress employeeAddress) {
        this.employeeAddress.remove(employeeAddress);
        employeeAddress.setAddressType(null);
    }
}
