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
public class IdentityCardType extends BaseEntity {
    private String identityCardType;

    @OneToMany(
            mappedBy = "identityCardType",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<IdentityCard> identityCards = new ArrayList<>();

    public void addIdentityCard(IdentityCard identityCard) {
        this.identityCards.add(identityCard);
        identityCard.setIdentityCardType(this);
    }

    public void removeIdentityCard(IdentityCard identityCard) {
        this.identityCards.remove(identityCard);
        identityCard.setIdentityCardType(null);
    }


}
