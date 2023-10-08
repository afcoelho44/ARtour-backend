package com.br.artour.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private String phone;

    private String email;

    private String password;

    private boolean isAdmin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    @JsonManagedReference(value = "userRef")
    private List<Comentary> comments;


}
