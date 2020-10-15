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
public class LanguageName extends BaseEntity {
    private String language;

    @OneToMany(
            mappedBy = "languageName",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Language> languages = new ArrayList<>();

    public void addLanguage(Language language) {
        this.languages.add(language);
        language.setLanguageName(this);
    }
    public void removeLanguage(Language language) {
        this.languages.remove(language);
        language.setLanguageName(null);
    }
}
