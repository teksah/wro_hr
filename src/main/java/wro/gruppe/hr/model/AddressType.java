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
    private List<AddressEmployee> addressEmployee = new ArrayList<>();

    public void addAddressEmployee(AddressEmployee addressEmployee) {
        this.addressEmployee.add(addressEmployee);
        addressEmployee.setAddressType(this);
    }
    public void removeAddressEmployee(AddressEmployee addressEmployee) {
        this.addressEmployee.remove(addressEmployee);
        addressEmployee.setAddressType(null);
    }
}
