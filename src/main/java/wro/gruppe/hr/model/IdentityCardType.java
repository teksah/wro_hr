package wro.gruppe.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class IdentityCardType {
    @Id @GeneratedValue
    private Long id;
    private String identityCardType;

    @OneToMany(
            mappedBy = "identityCardType",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<IdentityCard> identityCards;


}
