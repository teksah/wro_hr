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
public class Qualification extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private QualificationType qualificationType;

    private LocalDate issueDate;
    private LocalDate expiryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

}
