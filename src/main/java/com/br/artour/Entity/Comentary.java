package com.br.artour.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comentary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    private String media;

    private int approved;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference(value = "userRef")
    private User user;

    @ManyToOne
    @JoinColumn(name = "establishment_id", nullable = false)
    @JsonBackReference(value = "establishmentRef")
    private Establishment establishment;


}
