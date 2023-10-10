package com.br.artour.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="establishment")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "establishment")
    @JsonManagedReference(value = "establishmentRef")
    private List<Comentary> comments;

    @ManyToMany
    @JoinTable(name="establishments_tags", joinColumns = {@JoinColumn(name="establishment_id")}, inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference(value= "categoryRef")
    private Category category;


    public void removeTag(Tag tag){
        tags.remove(tag);
    }


}
