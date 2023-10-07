package com.br.artour.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private boolean active;

    private Double latitude;

    private Double longitude;

    private LocalTime hour;

    private String attractions;

    private String fees_costs;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="establishment")
    @JsonManagedReference
    private List<Comentary> comments;

    /* @OneToMany(cascade = CascadeType.ALL, mappedBy="establishment")
    @JsonManagedReference
    private List<Tag> tags;
    */

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    @JsonBackReference
    private Category category;




}
