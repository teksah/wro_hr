package wro.gruppe.hr.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String secondName;
    private String lastName;

    private String personalNumber;
    private LocalDate birthDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Citizenship citizenship;


    @ManyToOne(fetch = FetchType.LAZY)
    private Gender gender;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<IdentityCard> identityCards;

    private String fatherName;
    private String motherName;
    private String familyName;

    @ManyToOne(fetch = FetchType.LAZY)
    private MartialStatus martialStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private TaxOffice taxOffice;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BankAccount> bankAccounts;


//    private List<Email> emails;
//    private List<PhoneNumber> phoneNumbers;
//    private List<Address> addresses;


    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MedicalExamination> medicalExaminations;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Qualification> qualifications;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EmployeeEmployer> employers;













}
