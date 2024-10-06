package com.example.application.model.questionnaire;

import com.example.application.model.common.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "QUESTIONNAIRE")
public class Questionnaire extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestionnaireType type;

    // Define a one-to-many relationship with QuestionnaireSection
    @OneToMany(mappedBy = "questionnaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DietaryPreferences> sections;

    private String name;
    public enum QuestionnaireType {
        INITIAL,
        PROGRESS
    }
}
