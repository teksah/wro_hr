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
public class JobTitle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobTitle;

    @OneToMany(
            mappedBy = "jobTitle",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EmployeeEmployer> employeeEmployer;
}
