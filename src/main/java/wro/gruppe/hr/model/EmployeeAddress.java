package wro.gruppe.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class EmployeeAddress extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    private AddressType addressType;

    public EmployeeAddress(Address address, Employee employee, AddressType addressType) {
        this.address = address;
        this.employee = employee;
        this.addressType = addressType;
    }
}
