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
public class District extends BaseEntity{
    private String district;

    @OneToMany(
            mappedBy = "district",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PostalCode> postalCodes = new ArrayList<>();

    @OneToMany(
            mappedBy = "district",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Town> towns = new ArrayList<>();

    @OneToMany(
            mappedBy = "district",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Commune> communes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;

    @OneToMany(
            mappedBy = "district",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Address> addresses = new ArrayList<>();
    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setDistrict(this);
    }
    public void removeAddress(Address address) {
        this.addresses.remove(address);
        address.setDistrict(null);
    }
}
