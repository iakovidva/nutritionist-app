package com.example.application.models;

import com.example.application.models.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class User extends BaseEntity {

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

}
