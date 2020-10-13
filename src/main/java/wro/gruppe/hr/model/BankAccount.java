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
public class BankAccount extends BaseEntity {
    private String fullName;
    private String fullAddress;
    private String bankCode;
    private String iBan;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;


}
