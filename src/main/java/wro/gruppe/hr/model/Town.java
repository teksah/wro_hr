package wro.gruppe.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Town extends BaseEntity {
    private String town;

    @OneToMany(
            mappedBy = "town",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PostalCode> postalCodes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Commune commune;

    @ManyToOne(fetch = FetchType.LAZY)
    private District district;

    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;

    @OneToMany(
            mappedBy = "town",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setTown(this);
    }

    public void removeAddress(Address address) {
        this.addresses.remove(address);
        address.setTown(null);
    }
}
