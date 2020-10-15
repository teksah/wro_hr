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
public class Address extends BaseEntity{

    private String streetName;
    private String streetNumber;
    private String localNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private PostalCode postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private Town town;

    @ManyToOne(fetch = FetchType.LAZY)
    private Commune commune;

    @ManyToOne(fetch = FetchType.LAZY)
    private District district;

    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;

    @OneToMany(
            mappedBy = "address",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<AddressEmployee> employees = new ArrayList<>();



}
