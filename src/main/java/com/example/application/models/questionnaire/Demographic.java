package com.example.application.models.questionnaire;

import com.example.application.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "DEMOGRAPHIC")
public class Demographic extends QuestionnaireSection {

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "occupation")
    private String occupation;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;
}
