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
public class Province extends BaseEntity {
    private String province;

    @OneToMany(
            mappedBy = "province",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PostalCode> postalCodes = new ArrayList<>();

    @OneToMany(
            mappedBy = "province",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Town> towns = new ArrayList<>();

    @OneToMany(
            mappedBy = "province",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Commune> communes = new ArrayList<>();

    @OneToMany(
            mappedBy = "province",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<District> districts = new ArrayList<>();

    @OneToMany(
            mappedBy = "province",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setProvince(this);
    }
    public void removeAddress(Address address) {
        this.addresses.remove(address);
        address.setProvince(null);
    }

}
