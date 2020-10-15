package wro.gruppe.hr.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Employee extends BaseEntity {

    private String uniqueName;
    private String firstName;
    private String secondName;
    private String lastName;
    private String personalNumber;
    private LocalDate birthDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    private Citizenship citizenship;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<IdentityCard> identityCards = new ArrayList<>();

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
    private List<BankAccount> bankAccounts = new ArrayList<>();
    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MedicalExamination> medicalExaminations = new ArrayList<>();
    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Qualification> qualifications = new ArrayList<>();
    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Language> languages = new ArrayList<>();

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EmployeeAddress> addresses = new ArrayList<>();
    private String phoneNumber;
    private String email;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EmployerEmployee> employers = new ArrayList<>();


    @PrePersist
    void prePersist() {
        this.uniqueName = this.firstName + '_' + this.lastName.substring(0,2) + '_' + String.valueOf(birthDate.getYear()).substring(2,4);
    }

    public void addIdentityCard(IdentityCard identityCard) {
        this.identityCards.add(identityCard);
        identityCard.setEmployee(this);
    }
    public void removeIdentityCard(IdentityCard identityCard) {
        this.identityCards.remove(identityCard);
        identityCard.setEmployee(null);
    }

    public void addBankAccount(BankAccount bankAccount) {
        this.bankAccounts.add(bankAccount);
        bankAccount.setEmployee(this);
    }
    public void removeBankAccount(BankAccount bankAccount) {
        this.bankAccounts.remove(bankAccount);
        bankAccount.setEmployee(null);
    }

    public void addMedicalExamination(MedicalExamination medicalExamination) {
        this.medicalExaminations.add(medicalExamination);
        medicalExamination.setEmployee(this);
    }
    public void removeMedicalExamination(MedicalExamination medicalExamination) {
        this.medicalExaminations.remove(medicalExamination);
        medicalExamination.setEmployee(null);
    }

    public void addQualification(Qualification qualification) {
        this.qualifications.add(qualification);
        qualification.setEmployee(this);
    }
    public void removeQualification(Qualification qualification) {
        this.qualifications.remove(qualification);
        qualification.setEmployee(null);
    }

    public void addAddress(Address address, AddressType addressType) {
        EmployeeAddress employeeAddress = new EmployeeAddress(address, this, addressType);
        addresses.add(employeeAddress);
        addressType.addAddressEmployee(employeeAddress);
        address.getEmployees().add(employeeAddress);
    }

    public void addLanguage(Language language) {
        this.languages.add(language);
        language.setEmployee(this);
    }
    public void removeLanguage(Language language) {
        this.languages.remove(language);
        language.setEmployee(null);
    }


}
