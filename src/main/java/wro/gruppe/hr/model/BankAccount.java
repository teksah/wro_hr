package wro.gruppe.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class BankAccount {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String fullAddress;
    private String bankCode;
    private String iBan;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;


}
