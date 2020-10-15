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
public class Commune extends BaseEntity {
    private String commune;

    @OneToMany(
            mappedBy = "commune",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PostalCode> postalCodes = new ArrayList<>();

    @OneToMany(
            mappedBy = "commune",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Town> towns = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private District district;

    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;

    @OneToMany(
            mappedBy = "commune",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setCommune(this);
    }

    public void removeAddress(Address address) {
        this.addresses.remove(address);
        address.setCommune(null);
    }
}
