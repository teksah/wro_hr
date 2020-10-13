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
public class Citizenship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String citizenship;

    @OneToMany(
            mappedBy = "citizenship",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Employee> employees;
}
