package wro.gruppe.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class MedicalExamination {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private MedicalExaminationType medicalExaminationType;

    private LocalDate issueDate;
    private LocalDate expiryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;


}
