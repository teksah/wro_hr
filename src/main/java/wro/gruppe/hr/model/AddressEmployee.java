package wro.gruppe.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class AddressEmployee {

    @EmbeddedId
    private AddressEmployeeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("addressId")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("employeeId")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    private AddressType addressType;

    public AddressEmployee(Address address, Employee employee, AddressType addressType) {
        this.address = address;
        this.employee = employee;
        this.addressType = addressType;
    }
}
