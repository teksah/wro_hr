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
public class QualificationType extends BaseEntity {

    private String qualificationType;

    @OneToMany(
            mappedBy = "qualificationType",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Qualification> qualifications = new ArrayList<>();

    public void addQualification(Qualification qualification) {
        this.qualifications.add(qualification);
        qualification.setQualificationType(this);
    }

    public void removeQualification(Qualification qualification) {
        this.qualifications.remove(qualification);
        qualification.setQualificationType(null);
    }



}
