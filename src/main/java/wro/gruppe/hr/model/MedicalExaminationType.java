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
public class MedicalExaminationType extends BaseEntity {

    private String medicalExaminationType;

    @OneToMany(
            mappedBy = "medicalExaminationType",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MedicalExamination> medicalExaminations = new ArrayList<>();

    public void addMedicalExamination(MedicalExamination medicalExamination) {
        this.medicalExaminations.add(medicalExamination);
        medicalExamination.setMedicalExaminationType(this);
    }

    public void removeMedicalExamination(MedicalExamination medicalExamination) {
        this.medicalExaminations.remove(medicalExamination);
        medicalExamination.setMedicalExaminationType(null);
    }
}
