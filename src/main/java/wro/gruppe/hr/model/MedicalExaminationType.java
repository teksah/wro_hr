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
public class MedicalExaminationType {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicalExaminationType;

    @OneToMany(
            mappedBy = "medicalExaminationType",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MedicalExamination> medicalExaminations;
}
