package wro.gruppe.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class IdentityCard extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private IdentityCardType identityCardType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    private String cardNumber;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String issuingAuthority;

}
