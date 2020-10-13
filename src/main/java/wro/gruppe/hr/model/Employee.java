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
    private Citizenship citizenship;

    @ManyToOne(fetch = FetchType.LAZY)
    private Gender gender;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<IdentityCard> identityCards = new ArrayList<>();
    public void addIdentityCard(IdentityCard identityCard) {
        this.identityCards.add(identityCard);
        identityCard.setEmployee(this);
    }
    public void removeIdentityCard(IdentityCard identityCard) {
        this.identityCards.remove(identityCard);
        identityCard.setEmployee(null);
    }

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
    public void addBankAccount(BankAccount bankAccount) {
        this.bankAccounts.add(bankAccount);
        bankAccount.setEmployee(this);
    }
    public void removeBankAccount(BankAccount bankAccount) {
        this.bankAccounts.remove(bankAccount);
        bankAccount.setEmployee(null);
    }

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MedicalExamination> medicalExaminations = new ArrayList<>();
    public void addMedicalExamination(MedicalExamination medicalExamination) {
        this.medicalExaminations.add(medicalExamination);
        medicalExamination.setEmployee(this);
    }
    public void removeMedicalExamination(MedicalExamination medicalExamination) {
        this.medicalExaminations.remove(medicalExamination);
        medicalExamination.setEmployee(null);
    }

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Qualification> qualifications = new ArrayList<>();
    public void addQualification(Qualification qualification) {
        this.qualifications.add(qualification);
        qualification.setEmployee(this);
    }
    public void removeQualification(Qualification qualification) {
        this.qualifications.remove(qualification);
        qualification.setEmployee(null);
    }

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EmployeeEmployer> employers = new ArrayList<>();

    @PrePersist
    void prePersist() {
        this.uniqueName = this.firstName + '_' + this.lastName.substring(0,2) + '_' + String.valueOf(birthDate.getYear()).substring(2,4);
    }
}
