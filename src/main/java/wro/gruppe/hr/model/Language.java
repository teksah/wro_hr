package wro.gruppe.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Language extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private LanguageName languageName;

    @ManyToOne(fetch = FetchType.LAZY)
    private LanguageLevel languageLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
}
