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
public class QualificationType {
    @Id @GeneratedValue
    private Long id;
    private String qualificationType;

    @OneToMany(
            mappedBy = "qualificationType",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Qualification> qualifications;



}
