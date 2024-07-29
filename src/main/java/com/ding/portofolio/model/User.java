package com.ding.portofolio.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeBinderType;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "occupation")
    private String occupation;
    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Column(name = "project_data")
    private ProjectData projectData;

    @Column(name = "training_data")
    private TrainingData trainingData;
}
