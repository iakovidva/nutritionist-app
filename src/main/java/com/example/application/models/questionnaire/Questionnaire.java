package com.example.application.models.questionnaire;

import com.example.application.enums.QuestionnaireStatus;
import com.example.application.enums.QuestionnaireType;
import com.example.application.models.Client;
import com.example.application.models.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private QuestionnaireType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private QuestionnaireStatus status;
}
