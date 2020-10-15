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
public class LanguageLevel extends BaseEntity {
    private String languageLevel;

    @OneToMany(
            mappedBy = "languageLevel",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Language> language = new ArrayList<>();

    public void addLanguage(Language language) {
        this.language.add(language);
        language.setLanguageLevel(this);
    }
    public void removeLanguage(Language language) {
        this.language.remove(language);
        language.setLanguageLevel(null);
    }
}
